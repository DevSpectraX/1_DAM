const Movie = require("../Schemas/Movie.model");

const getMovies = async (req, res) => {
  try {
    const movies = await Movie.find();
    return res.status(200).json(movies);
  } catch (err) {
    return res.status(500).json(err);
  }
};

const getMoviesByID = async (req, res) => {
  const id = req.params.id;
  try {
    const movie = await Movie.findById(id);
    if (movie) {
      return res.status(200).json(movie);
    } else {
      return res.status(404).json("No movie found by this id");
    }
  } catch (err) {
    return res.status(500).json(err);
  }
};

const getMoviesByTitle = async (req, res) => {
  const { title } = req.params;

  try {
    const movieByTitle = await Movie.find({ title });
    return res.status(200).json(movieByTitle);
  } catch (err) {
    return res.status(500).json(err);
  }
};

const getMoviesByGenre = async (req, res) => {
  const { genre } = req.params;

  try {
    const movieByGenre = await Movie.find({ genre });
    return res.status(200).json(movieByGenre);
  } catch (err) {
    return res.status(500).json(err);
  }
};

const getMoviesByYear = async (req, res) => {
  const { year } = req.params;

  try {
    const movieByYear = await Movie.find({ year });
    return res.status(200).json(movieByYear);
  } catch (err) {
    return res.status(500).json(err);
  }
};

const createMovie = async (req, res) => {
  try {
    const newMovie = new Movie(req.body);
    const savedMovie = await newMovie.save();
    return res.status(201).json(savedMovie);
  } catch (error) {
    return res.status(500).json({
      message: "Error creando la pelicula",
      error: error.message,
    });
  }
};

const updateMovie = async (req, res) => {
  try {
    const { id } = req.params;
    const updatedMovie = await Movie.findByIdAndUpdate(id, req.body, {
      new: true,
      runValidators: true,
    });
    if (!updatedMovie) {
      return res.status(404).json({
        message: "No se encuentra la película",
      });
    }

    return res.status(200).json(updatedMovie);
  } catch (error) {
    return res.status(500).json({
      message: "Error actualizando la pelicula",
      error: error.message,
    });
  }
};

const deleteMovieByID = async (req, res) => {
  try {
    const { id } = req.params;
    const deletedMovieByID = await Movie.findByIdAndDelete(id);
    if (!deletedMovieByID) {
      return res.status(404).json({ message: "Película no encontrada" });
    }
    return res.status(200).json({ message: "Pelicula borrada correctamente" });
  } catch (error) {
    return res
      .status(500)
      .json({ message: "Error borrando la pelicula", error: error.message });
  }
};

module.exports = {
  getMovies,
  getMoviesByID,
  getMoviesByTitle,
  getMoviesByGenre,
  getMoviesByYear,
  createMovie,
  updateMovie,
  deleteMovieByID,
};
