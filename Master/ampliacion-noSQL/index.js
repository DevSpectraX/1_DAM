// Importa el módulo Express para facilitar la creación del servidor
const express = require('express');

//Preparamos la conexión
const {connect} = require('./src/config/dbConnect');

//Traemos el modelo Character
const Character = require('./src/models/Character.model');

//Importamos los charactersRoutes
const charactersRoutes = require('./src/routes/character.routes')

//Nos conectamos
connect();

// Define el puerto en el que escuchará el servidor
const PORT = 8080;

// Crea una instancia de la aplicación Express
const server = express();

//Vamos a tratar datos json
server.use(express.json());



// Crea un router para definir rutas separadamente
const router = express.Router();


server.use('/characters', charactersRoutes);


//Manejador de rutas no especificadas
server.use((req, res, next) => {
	const error = new Error('Route not found'); 
	error.status = 404;
	next(error); 
  });

//Manejador de errores
server.use((error, req, res, next) => {
	return res.status(error.status || 500).json(error.message || 'Unexpected error');
});

// Inicia el servidor y muestra un mensaje en consola
server.listen(PORT, () => {
  console.log(`Server running in <http://localhost>:${PORT}`);
});