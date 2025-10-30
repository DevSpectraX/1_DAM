const mixedElements = [
  6,
  1,
  "Marvel",
  1,
  "hamburguesa",
  "10",
  "Prometeo",
  8,
  "Hola mundo",
];
function averageWord(list) {
    let totalNumbers = 0;
    let totalString = 0;

    for(let i = 0; i < list.length; i++){
        if(typeof list[i] === "number"){totalNumbers += list[i];}

        else if(typeof list[i] === "string"){
            totalString += list[i].length;
        }
    }
    return (totalNumbers + totalString) / list.length;
}

console.log(averageWord(mixedElements));