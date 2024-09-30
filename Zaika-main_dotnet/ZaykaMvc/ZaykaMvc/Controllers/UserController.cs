
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using Stripe.Checkout;
using Stripe.Climate;
using Stripe;
using ZaykaMvc.Models;
using Microsoft.Extensions.Options;

namespace ZaykaMvc.Controllers
{
    public class UserController : Controller
    {
        private readonly ZaykaDbContext _context;
        private readonly StripeSettings _stripeSettings;
        public UserController(ZaykaDbContext context, IOptions<StripeSettings> stripeSettings)
        {
            _context = context;
            _stripeSettings = stripeSettings.Value;
        }

        // GET: User/Create
        public IActionResult SignUp()
        {
            return View();
        }

        // POST: User/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> SignUp([Bind("Id,Username,Password,ConfirmPassword,Email,City,Address")] User user)
        {
            if (ModelState.IsValid)
            {
                _context.Add(user);
                int result = await _context.SaveChangesAsync();                
                    ViewBag.message = "User Registeres";
                    return RedirectToAction("Login");
                
            }
            return View(user);
        }

        public IActionResult Login()
        {
            return View();
        }

        // POST: User/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Login(string Username,string Password)
        {
            try
            {
                var admin = await _context.Users.FirstOrDefaultAsync(a => a.Username == Username && a.Password == Password);
                if (admin != null)
                {
                    HttpContext.Session.SetString("username", Username);
                    return RedirectToAction("Index","Home");
                }
                else
                {
                    string error = "Invalid Credentials";
                    ViewBag.error = error;
                    return View();
                }
            }
            catch
            {
                return View();
            }
        }

     
        static HashSet<DishViewModel> cartdish = new HashSet<DishViewModel>();
        public IActionResult MyCart(int Id)
        {
            if (Id == null || _context.Dishes == null)
            {
                return NotFound();
            }

            var dish = _context.Dishes.Find(Id);
            if (dish == null)
            {
                return NotFound();
            }
            DishViewModel dishview = new DishViewModel();
            dishview.Id = dish.Id;
            dishview.Name = dish.Name;
            dishview.Price = dish.Price;
            cartdish.Add(dishview);
            return View(cartdish);
        }



  
        [HttpPost]
        public IActionResult SubmitCart(string SerializedMenu)
        {
            if (!string.IsNullOrEmpty(SerializedMenu))
            {
                var menu = JsonConvert.DeserializeObject<List<DishViewModel>>(SerializedMenu);
                decimal? totalbill = 0;
                int quantity;
                foreach (var item in menu)
                {
                    ZaykaMvc.Models.Order  order = new ZaykaMvc.Models.Order();
                    order.Username = HttpContext.Session.GetString("username");
                    order.DishName = item.Name;
                    order.Price = item.Price;
                    order.Quantity = item.Quantity;
                    quantity = order.Quantity;
                    totalbill = totalbill + (item.Price * item.Quantity);
                    _context.Orders.Add(order);
                }
                _context.SaveChanges(); // Save all changes once
                ViewBag.totalbill = totalbill;
                cartdish.Clear();
                         StripeConfiguration.ApiKey = _stripeSettings.SecretKey;

                         var options = new Stripe.Checkout.SessionCreateOptions
                         {
                             PaymentMethodTypes = new List<string> { "card" },
                             LineItems = new List<SessionLineItemOptions>
                 {
                     new SessionLineItemOptions
                     {
                         PriceData = new SessionLineItemPriceDataOptions
                         {
                             Currency = "usd",
                             ProductData = new SessionLineItemPriceDataProductDataOptions
                             {
                                 Name = "Zaika",
                             },
                             UnitAmount = (long?)(totalbill*100), 
                         },
                         Quantity = 1,
                     },
                 },
                             Mode = "payment",
                             SuccessUrl = "http://localhost:5097/User/Success",
                             CancelUrl = "http://localhost:5097/User/Failed",
                         };

                var service = new Stripe.Checkout.SessionService();
                Stripe.Checkout.Session session = service.Create(options);

                return Redirect(session.Url);
            }

            return View("MyCart");
        }

        public IActionResult LogOut() {
            HttpContext.Session.Clear();
            return RedirectToAction("Login");
        }

        public IActionResult Success()
        {
            return View("Success");
        }
    }
}
