//2.1
const newDiv = document.createElement("div");
document.body.appendChild(newDiv);

//2.2
const div = document.createElement("div");
const p = document.createElement("p");
div.appendChild(p);
document.body.appendChild(div);

//2.3
const divLoop = document.createElement("div");

for (let i = 0; i < 5; i++) {
  const pLoop = document.createElement("p");
  divLoop.appendChild(pLoop);
}
document.body.appendChild(divLoop);

//2.4
const pText = document.createElement("p");
pText.innerText = "Soy dinámico!";
document.body.appendChild(pText);

//2.5
const h2 = document.querySelector("h2");
h2.innerText = "Wubba Lubba dub dub";

//2.6
const apps = ["Facebook", "Netflix", "Instagram", "Snapchat", "Twitter"];

const newUl = document.createElement("ul");
for (const app of apps) {
  const li = document.createElement("li");
  li.innerText = app;
  newUl.appendChild(li);
}

document.body.appendChild(newUl);

//2.7
const fnRemove = document.querySelectorAll(".fn-remove-me");
fnRemove.forEach((item) => {
  item.remove();
});

//2.8
const secondDiv = document.querySelector("div:nth-of-type(2)");

const middle = document.createElement("p");
middle.innerText = "Voy en medio";

document.body.insertBefore(middle, secondDiv);

//2.9
const allDiv = document.querySelectorAll(".fn-insert-here");

for (item of allDiv) {
  const textAllDiv = document.createElement("p");
  textAllDiv.innerText = "Voy dentro!";
  item.appendChild(textAllDiv);
}
