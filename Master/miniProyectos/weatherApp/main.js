//Faltaría ocultar la api en un .env
const API_KEY = "e4b0823208084bc3ba9122305250112";

const main = document.querySelector("main");
const myInput = document.querySelector("#myInput");
const myBtn = document.querySelector("#myBtn");

const getWeather = async (city) => {
   const res = await fetch(`http://api.weatherapi.com/v1/current.json?key=${API_KEY}&q=${city}&aqi=no`);

   const data = await res.json();
   renderWeather(data)
};

const renderWeather = (data) => {
    main.innerHTML = `
    <h2>${data.location.name} - ${data.location.country}</h2>
    <img src="${data.current.condition.icon}" alt="${data.current.condition.text}">
    <h3>${data.current.temp_c}º</h3>
    <h4>Humidity: ${data.current.humidity}%</h4>
    <h4>Atmospheric Pressure: ${data.current.pressure_mb}mb</h4>
    <h4>Wind: ${data.current.wind_kph}kph</h4>
    <h4>Uv Index: ${data.current.uv}</h4>
    <h4>Feels like: ${data.current.feelslike_c}º</h4>
      
    `
};

getWeather("Madrid");

myBtn.addEventListener("click", () => {
    getWeather(myInput.value);
    myInput.value = "";
})