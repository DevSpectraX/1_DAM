//1.1 Basandote en el array siguiente, crea una lista ul > li dinámicamente en el html que imprima cada uno de los paises.
const countries = ["Japón", "Nicaragua", "Suiza", "Australia", "Venezuela"];

const ul = document.createElement("ul");
for (const item of countries) {
  const li = document.createElement("li");
  li.innerText = item;
  ul.appendChild(li);
}
document.body.appendChild(ul);

//1.2 Elimina el elemento que tenga la clase .fn-remove-me.
const rm = document.querySelector(".fn-remove-me");
rm.remove();

//1.3 Utiliza el array para crear dinamicamente una lista ul > li de elementos en el div de html con el atributo data-function="printHere".
const cars = ["Mazda 6", "Ford fiesta", "Audi A4", "Toyota corola"];

const printHere = document.querySelector("[data-function='printHere']");
const newUl = document.createElement("ul");
for (const car of cars) {
  const li = document.createElement("li");
  li.innerText = car;
  newUl.appendChild(li);
}
printHere.appendChild(newUl);

//1.4 Crea dinamicamente en el html una serie de divs que contenga un elemento h4 para el titulo y otro elemento img para la imagen.
const secondCountries = [
  { title: "Random title", imgUrl: "https://picsum.photos/300/200?random=1" },
  { title: "Random title", imgUrl: "https://picsum.photos/300/200?random=2" },
  { title: "Random title", imgUrl: "https://picsum.photos/300/200?random=3" },
  { title: "Random title", imgUrl: "https://picsum.photos/300/200?random=4" },
  { title: "Random title", imgUrl: "https://picsum.photos/300/200?random=5" },
];

//crear div
const newDiv = document.createElement("div");

for (const item of secondCountries) {
  const divCountries = document.createElement("div");
  divCountries.classList.add("randomPhoto");
  const h4 = document.createElement("h4");
  h4.innerText = item.title;
  const img = document.createElement("img");
  img.setAttribute("src", item.imgUrl);
  divCountries.appendChild(h4);
  divCountries.appendChild(img);
  newDiv.appendChild(divCountries);
}
document.body.appendChild(newDiv);

//1.5 Basandote en el ejercicio anterior. Crea un botón que elimine el último elemento de la serie de divs.
const button = document.createElement("button");
button.innerText = "Elimino el ultimo div";
button.addEventListener("click", () => {
  newDiv.lastChild.remove();
});
document.body.appendChild(button);

//1.6 Basandote en el ejercicio anterior. Crea un botón para cada uno de los divs que elimine ese mismo elemento del html.

const photos = document.querySelectorAll(".randomPhoto");

for (const photo of photos) {
  const btnInDiv = document.createElement("button");
  btnInDiv.innerText = "Elimino este div";
  btnInDiv.addEventListener("click", () => {
    photo.remove();
  });
  photo.appendChild(btnInDiv);
}
