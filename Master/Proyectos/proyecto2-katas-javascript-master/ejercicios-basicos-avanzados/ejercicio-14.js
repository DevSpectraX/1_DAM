const words = [
  "code",
  "repeat",
  "eat",
  "sleep",
  "code",
  "enjoy",
  "sleep",
  "code",
  "enjoy",
  "sleep",
  "code",
];
function repeatCounter(list) {
  let count = {};
  for (let i = 0; i < list.length; i++) {
    if (count[list[i]]) {
      count[list[i]]++;
    } else {
      count[list[i]] = 1;
    }
  } return count;
}

console.log(repeatCounter(words));
