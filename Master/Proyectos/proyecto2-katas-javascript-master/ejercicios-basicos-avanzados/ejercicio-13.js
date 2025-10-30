const names = [
  "Peter",
  "Steve",
  "Tony",
  "Natasha",
  "Clint",
  "Logan",
  "Xabier",
  "Bruce",
  "Peggy",
  "Jessica",
  "Marc",
];

let person = "";
function nameFinder(nameList) {
  
  if (nameList.includes(person)) {
    console.log("True");
  } else {
    console.log("False");
  }
}
person = "bruce";
nameFinder(names);