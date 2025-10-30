const albums = [
  "De Mysteriis Dom Sathanas",
  "Reign of Blood",
  "Ride the Lightning",
  "Painkiller",
  "Iron Fist",
];

const lista = document.querySelector(".lista");
let list = document.createElement("ul");
for (const element of albums) {
  let li = document.createElement("li");
  li.innerText =element ;
  list.appendChild(li);
  
}

lista.appendChild(list);
