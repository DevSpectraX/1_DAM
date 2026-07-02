//Generar número aleatorio
let randomNum = Math.floor(Math.random() * 151 + 1);

//Ponemos el numero aleatorio en el link
fetch(`https://pokeapi.co/api/v2/pokemon/${randomNum}`)
    .then((res) => res.json())
    .then((data) => {

    //Seleccionar elementos del DOM 
    const number = document.querySelector("#numberRandom");
    const name = document.querySelector("#name");
    const imgNormal = document.querySelector("#pokemonNormal");
    const imgShiny = document.querySelector("#pokemonShiny");
   
    //Asignamos los valores
    number.textContent = data.id;
    name.textContent = data.name;
    imgNormal.src = data.sprites.other["official-artwork"].front_default; 
    imgShiny.src = data.sprites.other["official-artwork"].front_shiny;
})



