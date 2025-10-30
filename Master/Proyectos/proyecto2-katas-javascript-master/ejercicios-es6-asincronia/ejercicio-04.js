// 4.1 Dado el siguiente array, utiliza .filter() para generar un nuevo array con los valores que sean mayor que 18
const ages = [22, 14, 24, 55, 65, 21, 12, 13, 90];

const newAges = ages.filter((age) => age > 18);

console.log(newAges);

// 4.2 Dado el siguiente array, utiliza .filter() para generar un nuevo array con los valores que sean par.
const moreAges = [22, 14, 24, 55, 65, 21, 12, 13, 90];

const parAges = moreAges.filter((age) => age % 2 === 0);

console.log(parAges);

// 4.3 Dado el siguiente array, utiliza .filter() para generar un nuevo array con los streamers que tengan el gameMorePlayed = 'League of Legends'.
const streamers = [
  { name: "Rubius", age: 32, gameMorePlayed: "Minecraft" },
  { name: "Ibai", age: 25, gameMorePlayed: "League of Legends" },
  { name: "Reven", age: 43, gameMorePlayed: "League of Legends" },
  { name: "AuronPlay", age: 33, gameMorePlayed: "Among Us" },
];

const gameTopStreamers = streamers.filter(
  (streamer) => streamer.gameMorePlayed === "League of Legends"
);

console.log(gameTopStreamers);

// 4.4 Dado el siguiente array, utiliza .filter() para generar un nuevo array con los streamers que incluyan el caracter 'u' en su propiedad .name. Recomendamos usar la funcion .includes() para la comprobación.
const moreStreamers = [
  { name: "Rubius", age: 32, gameMorePlayed: "Minecraft" },
  { name: "Ibai", age: 25, gameMorePlayed: "League of Legends" },
  { name: "Reven", age: 43, gameMorePlayed: "League of Legends" },
  { name: "AuronPlay", age: 33, gameMorePlayed: "Among Us" },
];

const includeU = moreStreamers.filter((streamer) =>
  streamer.name.includes("u")
);

console.log(includeU);

// 4.5 utiliza .filter() para generar un nuevo array con los streamers que incluyan el caracter 'Legends' en su propiedad .gameMorePlayed. Recomendamos usar la funcion .includes() para la comprobación. Además, pon el valor de la propiedad .gameMorePlayed a MAYUSCULAS cuando .age sea mayor que 35.


// Creo una variable que filtre Legends y edades
let streamersWithLegends = moreStreamers.filter(
  (streamer) => streamer.gameMorePlayed.includes("Legends") && streamer.age > 35
);

streamersWithLegends = streamersWithLegends.concat(
  moreStreamers.filter(
    (streamer) =>
      streamer.gameMorePlayed.includes("Legends") && streamer.age <= 35
  )
);

// Lo transformo a mayusculas los que cumplan la condición
let toUpperCase = streamersWithLegends.map(streamer => {
  if (streamer.age > 35) {
    return streamer.name + " " + streamer.gameMorePlayed.toUpperCase();
  } else {
    return streamer.name + " " + streamer.gameMorePlayed;
  }
});

// Compruebo que tengo realmente en streamerWithLegends
console.log(streamersWithLegends);

console.log(toUpperCase);
