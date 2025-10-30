function findArrayIndex(array, text) {
  for (let i = 0; i < array.length; i++) {
    if (array[i] == text) {
      console.log("La palabra se encuentra en la posicion " + i);
      return i;
    }
  }
}

function removeItem(array, text) {
array.splice(findArrayIndex(array, text), 1);
  console.log(array)
}

const mainCharacters = [
  "Luke",
  "Leia",
  "Han Solo",
  "Chewbacca",
  "Rey",
  "Anakin",
  "Obi-Wan",
];

findArrayIndex(mainCharacters, "Rey");

removeItem(mainCharacters, "Obi-Wan")