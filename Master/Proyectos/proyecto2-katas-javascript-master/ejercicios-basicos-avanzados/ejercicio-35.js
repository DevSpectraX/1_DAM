const mutants = [
  { name: "Wolverine", power: "regeneration" },
  { name: "Magneto", power: "magnetism" },
  { name: "Professor X", power: "telepathy" },
  { name: "Jean Grey", power: "telekinesis" },
  { name: "Rogue", power: "power absorption" },
  { name: "Storm", power: "weather manipulation" },
  { name: "Mystique", power: "shape-shifting" },
  { name: "Beast", power: "superhuman strength" },
  { name: "Colossus", power: "steel skin" },
  { name: "Nightcrawler", power: "teleportation" },
];

function findMutantByPower(mutants, power) {
  let nameMutants = [];
  for (let mutant of mutants) {
    if (mutant.power == power) {
      nameMutants.push(mutant.name);
    }
  }

  if (nameMutants.length > 0) {
    console.log("Sí, fue encontrado", nameMutants);
  } else {
    console.log("no fue encontrado");
  }
}

findMutantByPower(mutants, "teleportation");
