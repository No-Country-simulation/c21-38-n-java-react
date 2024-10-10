/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'orange': '#F39C12',
        'Newhite' : '#F8F9FA',
        'Blue': '#1F485C'
      },

      animation:{
        bounceIn: 'bounceIn 1s ease-in-out',
      },

      keyframes:{
        bounceIn:{
          '0%, 20%, 50%, 80%, 100%': { transform: 'translateY(0)' },
          '40%': { transform: 'translateY(-30px)' },
          '60%': { transform: 'translateY(-15px)' },
        }
      },
      brightness: {
        '80': 'brightness(0.8)'
      }
      
    },
  },
  plugins: [],
}