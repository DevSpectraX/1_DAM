const numbers = [12, 21, 38, 5, 45, 37, 6];

let suma = 0;
let total = 0;

function average(numberList) {
  for (let i = 0; i < numberList.length; i++) {
    suma += numberList[i];
  }

  return (total = suma / numberList.length);
}

console.log(average(numbers));
