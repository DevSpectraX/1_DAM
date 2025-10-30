const duplicates = [
  "sushi",
  "pizza",
  "burger",
  "potatoe",
  "pasta",
  "ice-cream",
  "pizza",
  "chicken",
  "onion rings",
  "pasta",
  "soda",
];

function removeDuplicates(list) {
  let newArray = [];
  for (let i = 0; i < list.length; i++) {
    if (!newArray.includes(list[i])) {
      newArray = newArray.concat(list[i]);
    }
  }
  return newArray;
}

console.log(removeDuplicates(duplicates));
