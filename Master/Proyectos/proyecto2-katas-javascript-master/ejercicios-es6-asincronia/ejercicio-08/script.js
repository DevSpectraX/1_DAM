fetch("https://thronesapi.com/api/v2/Characters")
  .then((res) => res.json())
  .then((data) => {
    const characters = data;

    //Seleccionar los elementos del html
    const characterList = document.querySelector(".character-list");
    const characterImage = document.querySelector(".character-image");


    //Bucle para ver asignarle los nombres a los options
    for (const personaje of characters) {
      //Creamos un option
      const option = document.createElement("option");

      
      //Añadimos el nombre al option
      option.textContent = personaje.fullName;
      characterList.appendChild(option);
    }

    //Añadimos un evento change para comprobar cuando cambia y comparamos el nombre con el que coincida de la api
    characterList.addEventListener("change", () =>{
    const personajeSeleccionado = characters.find(c => c.fullName == characterList.value);

    //Le damos valor al src de la imagen
    characterImage.src = personajeSeleccionado.imageUrl;
    }
);

    


});
