const products = [
  "Camiseta de Metallica",
  "Pantalón vaquero",
  "Gorra de beisbol",
  "Camiseta de Basket",
  "Cinturón de Orión",
  "AC/DC Camiseta",
];
let word = "Camiseta";
for (let i = 0; i < products.length; i++) {
    if (products[i].includes(word)) {
        console.log(products[i]);
        
    }
    
}
