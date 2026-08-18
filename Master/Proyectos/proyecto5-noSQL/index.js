const express = require("express");

const connectDB = require("./utils/db");

const server = express();

server.use(express.json());

const moviesRouter = require("./routes/movies.routes")
const PORT = 8080;

connectDB();



//-----Rutas-----

server.use("/", moviesRouter);

server.use((req,res) => {
    return res.status(404).json({error: "Página no encontrada"})
});

server.listen(PORT, () => {
    console.log(`Servidor levantado en http://localhost:${PORT}`)
});