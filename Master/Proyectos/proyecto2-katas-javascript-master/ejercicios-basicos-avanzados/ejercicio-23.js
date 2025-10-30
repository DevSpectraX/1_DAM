const movies = [
  { name: "Titan A.E.", durationInMinutes: 130 },
  { name: "Nightmare before Christmas", durationInMinutes: 225 },
  { name: "Inception", durationInMinutes: 165 },
  { name: "The Lord of the Rings", durationInMinutes: 967 },
  { name: "Star Wars: A New Hope", durationInMinutes: 214 },
  { name: "Terminator", durationInMinutes: 140 },
  { name: "Spirited Away", durationInMinutes: 80 },
  { name: "The Matrix", durationInMinutes: 136 },
  { name: "Amélie", durationInMinutes: 110 },
  { name: "Eternal Sunshine of the Spotless Mind", durationInMinutes: 108 },
];

let littleMovies = [];
let mediumMovies = [];
let bigMovies = [];

for (let movie of movies) {
  if (movie.durationInMinutes < 100) {
    littleMovies.push(movie);
  } else if (movie.durationInMinutes > 100 && movie.durationInMinutes < 200) {
    mediumMovies.push(movie);
  } else if (movie.durationInMinutes > 200) {
    bigMovies.push(movie);
  }
}

console.log("Películas pequeñas:", littleMovies);
console.log("Películas medianas:", mediumMovies);
console.log("Películas grandes:", bigMovies);
