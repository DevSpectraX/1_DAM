//1.1
const btn = document.createElement("button");
btn.innerText = "boton";
btn.setAttribute("id", "btnToClick");

document.body.appendChild(btn);
btn.addEventListener("click", (eventClick) => {
  console.log(eventClick);
});

//1.2 Añade un evento 'focus' que ejecute un console.log con el valor del input.
const focus = document.querySelector(".focus");
focus.addEventListener("focus",(eventFocus) => {
    console.log(eventFocus)
})

//1.3
const input = document.querySelector(".value");
input.addEventListener("input", (eventInput) => {
  console.log(eventInput);
})