import { useEffect, useState } from "react";
import { FaChevronLeft, FaChevronRight } from "react-icons/fa";

export const Carousel = ({ children: slides, autoSlide = false, autoSlideInterval = 3000, onSlideChange }) => {
    const [current, setCurrent] = useState(0);

    const prev = () => {
        setCurrent(curr => curr === 0 ? slides.length - 1 : curr - 1);
        if (onSlideChange) onSlideChange(curr === 0 ? slides.length - 1 : curr - 1);
    };

    const next = () => {
        setCurrent(curr => curr === slides.length - 1 ? 0 : curr + 1);
        if (onSlideChange) onSlideChange(curr === slides.length - 1 ? 0 : curr + 1);
    };

    useEffect(() => {
        if (!autoSlide) return;
        
        const slideInterval = setInterval(() => {
            next();
        }, autoSlideInterval);
        
        return () => clearInterval(slideInterval);
    }, []);

    useEffect(() => {
        if (onSlideChange) onSlideChange(current);
    }, [current, onSlideChange]);

    return (
        <div className="overflow-hidden relative">
            <div className="flex transition-transform ease-out duration-500" style={{ transform: `translateX(-${current * 100}%)` }}>
                {slides}
            </div>
            <div className="absolute inset-0 flex items-center justify-between p-4">
                <button onClick={prev} className="p-1 rounded-full shadow backdrop-blur-sm bg-Blue bg-opacity-30 hover:scale-125 transition-all hover:shadow-lg">
                    <FaChevronLeft size={40} className="text-Newhite" />
                </button>
                <button onClick={next} className="p-1 rounded-full shadow backdrop-blur-sm bg-Blue bg-opacity-30 hover:scale-125 transition-all hover:shadow-lg">
                    <FaChevronRight size={40} className="text-Newhite" />
                </button>
            </div>

            <div className="absolute bottom-4 right-0 left-0">
                <div className="flex items-center justify-center gap-2">
                    {slides.map((_, i) => (
                        <div key={i} className={`transition-all w-3 h-3 bg-Newhite rounded-full ${current === i ? "p-2" : "bg-opacity-50"}`} />
                    ))}
                </div>
            </div>
        </div>
    );
};
