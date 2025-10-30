let nameList; 

fetch("https://thronesapi.com/api/v2/Characters")  
    .then((res) => res.json())
    .then((data) => {
        nameList = data.map(character => character.fullName)
        console.log(nameList)
    })

const characterList = document.querySelector("#character-list")
const ul = document.createElement(ul)
