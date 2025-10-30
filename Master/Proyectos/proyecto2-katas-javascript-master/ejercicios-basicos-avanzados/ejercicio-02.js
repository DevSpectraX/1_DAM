// 1. Luke Skywalker cumple años
const jedi = { nombre: "Luke Skywalker", edad: 19 };
console.log(`${jedi.nombre} tiene ${jedi.edad + 1}`);

// 2. Presentación al estilo Leia Organa
const nombre = "Leia";
const apellido = "Organa";
const edad = 20;

console.log(
  `Soy ${nombre} ${apellido} tengo ${edad} años y soy una princesa de Alderaan`
);

// 3. Calculando el coste total de sables de luz
const sable1 = { nombre: "Shoto de Yoda", precio: 1500 };
const sable2 = { nombre: "Sable de Darth Vader", precio: 2000 };

let precioTotal = sable1.precio + sable2.precio;
console.log("El precio total de los dos sables es " + precioTotal);

// 4. Actualizando el precio final de las naves
let precioBaseGlobal = 10000;

// Cambia el precio base en esta linea modificando la variable
precioBaseGlobal = 15000;

const nave1 = {
    nombre: "Ala-X",
    precioBase: 50000,
    precioFinal: 60000
};

const nave2 = {
  nombre: "Halcón Milenario",
  precioBase: 70000,
  precioFinal: 80000,
};

// Tu código para actualizar el precio final de cada nave aquí...

nave1.precioFinal = precioBaseGlobal + nave1.precioBase;
nave2.precioFinal = precioBaseGlobal + nave2.precioBase;

console.log(
  `El precio de ${nave1.nombre} es ${nave1.precioFinal} y de ${
    nave2.nombre
  } es ${nave2.precioFinal}. El total de ${nave1.nombre} y ${
    nave2.nombre
  } es de ${nave1.precioFinal + nave2.precioFinal}`
);
