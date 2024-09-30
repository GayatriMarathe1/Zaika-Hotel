import React, { useEffect } from "react";
import "./HomePage.css";
import Navbar from "../../components/Navbar/Navbar";
import MultipleItemsCarousel from "../../components/MultiItemCarousel/MultiItemCarousel";
import { restaurents } from "../../../Data/restaurents";
import RestaurantCard from "../../components/RestarentCard/RestaurantCard";
import { useDispatch, useSelector } from "react-redux";
import { getAllRestaurantsAction } from "../../../State/Customers/Restaurant/restaurant.action";
// import { getAllRestaurantsAction } from "../../../State/Restaurant/Action";
// import RestarantCard from "../../components/RestarentCard/Restaurant";

import { useTypewriter, Cursor } from "react-simple-typewriter";
import Footer from "../Footer/Footer";

const HomePage = () => {
  const { auth, restaurant } = useSelector((store) => store);
  const dispatch = useDispatch();

  var [text] = useTypewriter({
    words: ["Taste the Convenience: Food, Fast and Delivered."],
    loop: 0,
  });

  useEffect(() => {
    if (auth.user) {
      dispatch(getAllRestaurantsAction(localStorage.getItem("jwt")));
    }
  }, [auth.user]);
  return (
    <>
      <div className="">
        <section className="-z-50 banner relative flex flex-col justify-center items-center">
          <div className="w-[50vw] z-10 text-center ml-80">
            <p className="text-2xl lg:text-7xl font-sans font-bold z-10 py-5 text-[#ff5c0c]">
              Zaika Food
            </p>
            <p className="z-10  text-gray-300 text-xl lg:text-4xl">
              <span className="text-black ">{text}</span>
              <Cursor />
            </p>
          </div>

          <div className="cover absolute top-0 left-0 right-0"></div>
          <div className=""></div>
        </section>

        <section className="bg-white p-10 lg:py-10 lg:px-20">
          <div className="">
            <p className="text-2xl font-semibold text-gray-400 py-3 pb-10">
              Top Meals
            </p>
            <MultipleItemsCarousel />
          </div>
        </section>
        <section className="bg-white px-5 lg:px-20">
          <div className="">
            <h1 className="text-2xl font-semibold text-gray-400 py-3 ">
              Order From Our Handpicked Favorites
            </h1>
            <div className="flex flex-wrap items-center justify-around ">
              {restaurant.restaurants.map((item, i) => (
                <RestaurantCard data={item} index={i} />
              ))}
            </div>
          </div>
        </section>
        
      </div>
      <Footer />
    </>
  );
};

export default HomePage;
