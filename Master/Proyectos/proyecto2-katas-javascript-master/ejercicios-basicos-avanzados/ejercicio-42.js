const fantasticFour = [
  "La antorcha humana",
  "Mr. Fantástico",
  "La mujer invisible",
  "La cosa",
];

function swap(array, firstIndex, secondIndex){
    let first = array[firstIndex];
    let second = array[secondIndex];
    array[firstIndex] = second;
    array[secondIndex] = first;
                
    console.log(array)
}

swap(fantasticFour, 1, 2)