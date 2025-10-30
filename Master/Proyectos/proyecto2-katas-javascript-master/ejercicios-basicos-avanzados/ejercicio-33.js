const capitals = {
  Spain: "Madrid",
  France: "Paris",
  Italy: "Rome",
  Germany: "Berlin",
  Portugal: "Lisbon",
  Poland: "Warsaw",
  Greece: "Athens",
  Austria: "Vienna",
  Hungary: "Budapest",
  Ireland: "Dublin",
};

function getCapital(country) {
  let selectCountry = "";
  for (actualCountry in capitals) {
    if (capitals[actualCountry] == capitals[country]) {
      selectCountry = capitals[actualCountry];
      return selectCountry;
    }
  }return "Pais no encontrado";
}

console.log(getCapital("Ireland"));
