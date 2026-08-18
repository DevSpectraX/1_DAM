const mongoose = require("mongoose");

const Movie = require("../Schemas/Movie.model");

const movies = require("./data")

const moviesDocuments = movies.map((movie) => new Movie(movie));

mongoose.connect("mongodb://localhost:27017/moviesDB").then(async ()=>{
    const allMovies = await Movie.find()

    if(allMovies.length){
        await Movie.collection.drop()
        console.log("Colección borrada exitosamente")
    }
}).catch((error) => {
    console.log(error.message);
}).then(async () =>{
    await Movie.insertMany (moviesDocuments);
    console.log("Peliculas insertadas correctamente en la DB");

}).catch((error) =>{
    console.log(error.message);
}).finally(()=> mongoose.disconnect())