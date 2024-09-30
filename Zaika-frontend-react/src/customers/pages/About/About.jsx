import React from "react";
import { useTypewriter, Cursor } from "react-simple-typewriter";
import Navbar from "../../components/Navbar/Navbar";
import Footer from "../../pages/Footer/Footer";
// Example data for founders and investors
const founders = [
  {
    name: "Ashwin Shelke",
    photo:
      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8sk7-c17JrjoQFRUifgRnh1UvRXvdtCGbLA&s",
    desc: "PG-Dac Student of Cdac Mumbai, Expert in Full Stack Web Development using MERN STACK",
  },
];

const investors = [
  { name: "Mukesh Ambani", photo: "../../public/mukeshambani.webp" },
  { name: "Elon Musk", photo: "../../public/elonmusk.webp" },
  { name: "Bil Gates", photo: "../../public/billgates.webp" },
  { name: "Warren Buffett", photo: "../../public/warrenbuffett.webp" },
];

function About() {
  const [text] = useTypewriter({
    words: ["Learn more about our vision, mission, founders, and investors."],
    loop: 0,
  });

  return (
    <>
      <Navbar />

      <section className="bg-gray-100 py-12 ">
        <div className="container mx-auto px-4">
          <div className="text-center mb-12">
            <h2 className="text-3xl font-bold mt-20">About Us</h2>
            <p className="text-gray-600 mt-4">
              <span className="text-pink-500 text-2xl font-bold">{text}</span>
              <Cursor className="text-2xl" />
            </p>
          </div>

          <div className="mb-12">
            <h3 className="text-2xl font-semibold text-center">
              Vision & Mission
            </h3>
            <div className="mt-6 flex flex-col md:flex-row md:justify-around">
              <div className="bg-white shadow-lg rounded-lg p-6 mb-6 md:mb-0 md:w-1/2 md:mr-4">
                <h4 className="text-xl font-bold mb-2">Our Vision</h4>
                <p className="text-gray-700 ">
                  "To become the world's most beloved online bookstore,
                  inspiring a lifelong love of reading by making books
                  accessible and enjoyable for everyone.
                </p>
              </div>
              <div className="bg-white shadow-lg rounded-lg p-6 md:w-1/2 md:ml-4">
                <h4 className="text-xl font-bold mb-2">Our Mission</h4>
                <p className="text-gray-700 ">
                  "To provide a seamless and personalized online book buying
                  experience, offering a vast selection of titles, competitive
                  prices, and exceptional customer service, while fostering a
                  community of readers and promoting the joy of discovery
                  through books."
                </p>
              </div>
            </div>
          </div>

          <div className="mb-12">
            <h3 className="text-2xl font-semibold text-center mb-6">Founder</h3>
            <div className="flex flex-wrap justify-center">
              {founders.map((founder) => (
                <div key={founder.name} className="m-4">
                  <img
                    src={founder.photo}
                    alt={founder.name}
                    className="w-40 h-40 rounded-full object-cover mx-auto"
                  />
                  <h4 className="text-center mt-4 text-xl font-bold">
                    {founder.name}
                  </h4>
                  <p>{founder.desc}</p>
                </div>
              ))}
            </div>
          </div>

          <div className="mb-12">
            <h3 className="text-2xl font-semibold text-center mb-6">
              Investors
            </h3>
            <div className="flex flex-wrap justify-center">
              {investors.map((investor) => (
                <div key={investor.name} className="m-4">
                  <img
                    src={investor.photo}
                    alt={investor.name}
                    className="w-40 h-40 rounded-full object-cover mx-auto"
                  />
                  <h4 className="text-center mt-4 text-xl font-bold">
                    {investor.name}
                  </h4>
                </div>
              ))}
            </div>
          </div>
        </div>
      </section>

      <Footer />
    </>
  );
}

export default About;
