const avengers = [
  "Hulk",
  "Thor",
  "Iron Man",
  "Captain A.",
  "Spiderman",
  "Captain M.",
];
function findLongestWord(stringList) {
  let word = "";
  for (let i = 0; i < stringList.length; i++) {
    if (stringList[i].length > word.length) {
      word = stringList[i];
    }
  }
  return word;
}

console.log(findLongestWord(avengers));
