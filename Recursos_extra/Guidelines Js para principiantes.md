# Guía de Aprendizaje de JavaScript para Principiantes

## Índice
1. [Fundamentos Básicos](#fundamentos-básicos)
2. [Variables y Tipos de Datos](#variables-y-tipos-de-datos)
3. [Operadores](#operadores)
4. [Estructuras de Control](#estructuras-de-control)
5. [Funciones](#funciones)
6. [Arrays y Objetos](#arrays-y-objetos)
7. [DOM Manipulation](#dom-manipulation)
8. [Mejores Prácticas](#mejores-prácticas)
9. [Ejercicios Progresivos](#ejercicios-progresivos)

---

## Fundamentos Básicos

### ¿Qué es JavaScript?
JavaScript es un lenguaje de programación interpretado, dinámico y orientado a objetos que se ejecuta principalmente en navegadores web.

### Configuración inicial
```javascript
// Incluir JavaScript en HTML
// Opción 1: Inline
<script>
  console.log("¡Hola Mundo!");
</script>

// Opción 2: Archivo externo
<script src="script.js"></script>
```

### Tu primer programa
```javascript
// Mostrar mensaje en consola
console.log("¡Hola Mundo!");

// Mostrar alerta en navegador
alert("¡Bienvenido a JavaScript!");

// Mostrar en página web
document.write("Mi primer programa en JS");
```

---

## Variables y Tipos de Datos

### Declaración de Variables
```javascript
// ES6+ (Recomendado)
let nombre = "Juan";          // Variable que puede cambiar
const edad = 25;              // Constante (no cambia)

// Evitar (legacy)
var apellido = "Pérez";       // Scope global/función
```

### Tipos de Datos Primitivos
```javascript
// String (Cadenas de texto)
let mensaje = "Hola mundo";
let nombre = 'Ana';
let template = `Mi nombre es ${nombre}`;

// Number (Números)
let entero = 42;
let decimal = 3.14;
let negativo = -10;

// Boolean (Verdadero/Falso)
let activo = true;
let inactivo = false;

// Undefined
let sinDefinir;
console.log(sinDefinir); // undefined

// Null
let vacio = null;

// Symbol (ES6)
let simbolo = Symbol('id');
```

### Verificar Tipos
```javascript
console.log(typeof "Hola");      // "string"
console.log(typeof 42);          // "number"
console.log(typeof true);        // "boolean"
console.log(typeof undefined);   // "undefined"
console.log(typeof null);        // "object" (peculiaridad de JS)
```

---

## Operadores

### Operadores Aritméticos
```javascript
let a = 10, b = 3;

console.log(a + b);  // 13 (suma)
console.log(a - b);  // 7  (resta)
console.log(a * b);  // 30 (multiplicación)
console.log(a / b);  // 3.333... (división)
console.log(a % b);  // 1  (módulo/resto)
console.log(a ** b); // 1000 (exponente)

// Incremento y decremento
let contador = 5;
contador++;          // 6
contador--;          // 5
```

### Operadores de Comparación
```javascript
let x = 10, y = "10";

console.log(x == y);   // true  (igualdad débil)
console.log(x === y);  // false (igualdad estricta)
console.log(x != y);   // false (desigualdad débil)
console.log(x !== y);  // true  (desigualdad estricta)
console.log(x > 5);    // true
console.log(x >= 10);  // true
```

### Operadores Lógicos
```javascript
let a = true, b = false;

console.log(a && b);   // false (AND)
console.log(a || b);   // true  (OR)
console.log(!a);       // false (NOT)
```

---

## Estructuras de Control

### Condicionales
```javascript
// if/else básico
let edad = 18;

if (edad >= 18) {
    console.log("Eres mayor de edad");
} else {
    console.log("Eres menor de edad");
}

// if/else if/else
let nota = 85;

if (nota >= 90) {
    console.log("Excelente");
} else if (nota >= 80) {
    console.log("Muy bien");
} else if (nota >= 70) {
    console.log("Bien");
} else {
    console.log("Necesitas mejorar");
}

// Switch
let dia = "lunes";

switch (dia) {
    case "lunes":
        console.log("Inicio de semana");
        break;
    case "viernes":
        console.log("¡Por fin viernes!");
        break;
    default:
        console.log("Día normal");
}
```

### Bucles
```javascript
// for clásico
for (let i = 0; i < 5; i++) {
    console.log(`Número: ${i}`);
}

// while
let contador = 0;
while (contador < 3) {
    console.log(`Contador: ${contador}`);
    contador++;
}

// do-while
let numero;
do {
    numero = Math.floor(Math.random() * 10);
    console.log(`Número generado: ${numero}`);
} while (numero !== 5);
```

---

## Funciones

### Declaración de Funciones
```javascript
// Función tradicional
function saludar(nombre) {
    return `Hola, ${nombre}!`;
}

// Expresión de función
const despedir = function(nombre) {
    return `Adiós, ${nombre}!`;
};

// Función flecha (ES6)
const multiplicar = (a, b) => a * b;

// Función flecha con cuerpo
const calcularArea = (radio) => {
    const pi = 3.14159;
    return pi * radio * radio;
};
```

### Parámetros y Argumentos
```javascript
// Parámetros por defecto
function saludar(nombre = "Usuario") {
    return `Hola, ${nombre}!`;
}

// Parámetros rest
function sumar(...numeros) {
    return numeros.reduce((total, num) => total + num, 0);
}

console.log(sumar(1, 2, 3, 4)); // 10
```

### Scope (Ámbito)
```javascript
let global = "Variable global";

function ejemplo() {
    let local = "Variable local";
    console.log(global); // Acceso a variable global ✓
    console.log(local);  // Acceso a variable local ✓
}

ejemplo();
// console.log(local); // Error: local no está definida ✗
```

---

## Arrays y Objetos

### Arrays (Arreglos)
```javascript
// Creación de arrays
let frutas = ["manzana", "banana", "naranja"];
let numeros = [1, 2, 3, 4, 5];
let mixto = ["texto", 42, true, null];

// Métodos básicos
frutas.push("uva");           // Agregar al final
frutas.unshift("fresa");      // Agregar al inicio
frutas.pop();                 // Remover último
frutas.shift();               // Remover primero

// Iteración
frutas.forEach((fruta, index) => {
    console.log(`${index}: ${fruta}`);
});

// Métodos útiles
let numerosPares = numeros.filter(num => num % 2 === 0);
let numerosDobles = numeros.map(num => num * 2);
let suma = numeros.reduce((total, num) => total + num, 0);
```

### Objetos
```javascript
// Creación de objetos
let persona = {
    nombre: "Ana",
    edad: 30,
    ciudad: "Madrid",
    activo: true
};

// Acceso a propiedades
console.log(persona.nombre);        // Notación punto
console.log(persona["edad"]);       // Notación corchetes

// Modificar propiedades
persona.edad = 31;
persona["trabajo"] = "Desarrolladora";

// Métodos en objetos
let calculadora = {
    suma: function(a, b) {
        return a + b;
    },
    // Método abreviado (ES6)
    resta(a, b) {
        return a - b;
    }
};
```

---

## DOM Manipulation

### Seleccionar Elementos
```javascript
// Por ID
let elemento = document.getElementById("miId");

// Por clase
let elementos = document.getElementsByClassName("miClase");

// Por selector CSS
let elemento = document.querySelector(".miClase");
let elementos = document.querySelectorAll("p");
```

### Modificar Contenido
```javascript
// Cambiar texto
elemento.textContent = "Nuevo texto";
elemento.innerHTML = "<strong>Texto en negrita</strong>";

// Cambiar estilos
elemento.style.color = "red";
elemento.style.fontSize = "20px";

// Agregar/remover clases
elemento.classList.add("nueva-clase");
elemento.classList.remove("vieja-clase");
elemento.classList.toggle("activo");
```

### Eventos
```javascript
// Event listener
let boton = document.querySelector("#miBoton");

boton.addEventListener("click", function() {
    alert("¡Botón clickeado!");
});

// Función flecha
boton.addEventListener("click", () => {
    console.log("Click registrado");
});

// Evento con parámetros
function manejarClick(evento) {
    console.log("Elemento clickeado:", evento.target);
}

boton.addEventListener("click", manejarClick);
```

---

## Mejores Prácticas

### Convenciones de Nomenclatura
```javascript
// Correcto
let nombreUsuario = "Ana";           // camelCase para variables
const MAX_INTENTOS = 3;              // UPPER_CASE para constantes
function calcularTotal() {}          // camelCase para funciones

// Evitar
let nombre_usuario = "Ana";          // snake_case
let NombreUsuario = "Ana";           // PascalCase (solo para clases)
```

### Código Limpio
```javascript
// Buenas prácticas
const DESCUENTO_MAXIMO = 0.15;

function calcularPrecioFinal(precio, descuento = 0) {
    if (descuento > DESCUENTO_MAXIMO) {
        descuento = DESCUENTO_MAXIMO;
    }
    
    return precio * (1 - descuento);
}

// Evitar
function calc(p, d) {
    return p * (1 - d);
}
```

### Manejo de Errores
```javascript
// Try-catch para manejo de errores
function dividir(a, b) {
    try {
        if (b === 0) {
            throw new Error("No se puede dividir por cero");
        }
        return a / b;
    } catch (error) {
        console.error("Error:", error.message);
        return null;
    }
}
```

---

## Ejercicios Progresivos

### Nivel Principiante
```javascript
// 1. Calculadora básica
function calculadora(num1, num2, operacion) {
    switch (operacion) {
        case '+': return num1 + num2;
        case '-': return num1 - num2;
        case '*': return num1 * num2;
        case '/': return num2 !== 0 ? num1 / num2 : "Error: División por cero";
        default: return "Operación no válida";
    }
}

// 2. Verificar número par/impar
function esPar(numero) {
    return numero % 2 === 0;
}

// 3. Encontrar el mayor de tres números
function mayorDeTres(a, b, c) {
    return Math.max(a, b, c);
}
```

### Nivel Intermedio
```javascript
// 1. Contador de palabras
function contarPalabras(texto) {
    return texto.trim().split(/\s+/).length;
}

// 2. Palíndromo
function esPalindromo(palabra) {
    const limpia = palabra.toLowerCase().replace(/[^a-z]/g, '');
    return limpia === limpia.split('').reverse().join('');
}

// 3. Fibonacci
function fibonacci(n) {
    if (n <= 1) return n;
    
    let a = 0, b = 1;
    for (let i = 2; i <= n; i++) {
        [a, b] = [b, a + b];
    }
    return b;
}
```

### Proyectos Prácticos
```javascript
// 1. Lista de tareas simple
class ListaTareas {
    constructor() {
        this.tareas = [];
    }
    
    agregar(tarea) {
        this.tareas.push({
            id: Date.now(),
            texto: tarea,
            completada: false
        });
    }
    
    completar(id) {
        const tarea = this.tareas.find(t => t.id === id);
        if (tarea) tarea.completada = true;
    }
    
    listar() {
        return this.tareas;
    }
}

// 2. Generador de contraseñas
function generarContrasena(longitud = 8) {
    const caracteres = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*';
    let contrasena = '';
    
    for (let i = 0; i < longitud; i++) {
        contrasena += caracteres.charAt(Math.floor(Math.random() * caracteres.length));
    }
    
    return contrasena;
}
```

---

## Recursos Adicionales

### Sitios Web Recomendados
- **MDN Web Docs**: Documentación oficial y completa
- **JavaScript.info**: Tutorial moderno y detallado
- **FreeCodeCamp**: Cursos interactivos gratuitos
- **Codecademy**: Lecciones estructuradas

### Herramientas de Desarrollo
- **Chrome DevTools**: Para debugging
- **Visual Studio Code**: Editor recomendado
- **Node.js**: Para ejecutar JS fuera del navegador
- **Codepen**: Para experimentar online

### Próximos Pasos
1. Practicar con ejercicios diarios
2. Construir proyectos pequeños
3. Aprender sobre ES6+ features
4. Explorar frameworks (React, Vue, Angular)
5. Estudiar Node.js para backend

---

## Consejos Finales

1. **Practica constantemente**: La programación se aprende haciendo
2. **Lee código de otros**: GitHub es tu aliado
3. **No memorices, entiende**: Los conceptos son más importantes que la sintaxis
4. **Usa la consola**: `console.log()` es tu mejor amigo para debugging
5. **Se paciente**: Todo programador ha estado donde tú estás ahora

¡Feliz programación promo mayo del 25 (la mejor promo)! 