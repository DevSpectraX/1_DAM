const xMen = [
  { name: "Wolverine", year: 1974 },
  { name: "Cyclops", year: 1963 },
  { name: "Storm", year: 1975 },
  { name: "Phoenix", year: 1961 },
  { name: "Beast", year: 1963 },
  { name: "Gambit", year: 1990 },
  { name: "Nightcrawler", year: 1975 },
  { name: "Magneto", year: 1963 },
  { name: "Professor X", year: 1963 },
  { name: "Mystique", year: 1978 },
];

function findOldestXMen(xMen) {
  let oldestHero = xMen[0];
  for (let hero of xMen) {
    if (hero.year < oldestHero.year) {
      oldestHero = hero;
    }
  }
  return oldestHero;
}

console.log(findOldestXMen(xMen));
