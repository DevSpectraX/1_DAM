const mongoose = require("mongoose");

const connectDB = async () => {
  try {
    await mongoose.connect("mongodb://localhost:27017/moviesDB");
  } catch (error) {
    console.error(
      "Error al conectarse a la base de datos de Mongo",
      error.message,
    );
  }
};

module.exports = connectDB;
