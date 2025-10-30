const numbers = [1, 2, 3, 5, 45, 37, 58];

let total = 0;

function sumNumbers(numberList) {
  for (let i = 0; i < numberList.length; i++) {
    total += numberList[i];
  }
  return total;
}

console.log(sumNumbers(numbers));
