const express = require("express");

module.exports = {
  getMovies,
  getMoviesByID,
  getMoviesByTitle,
  getMoviesByGenre,
  getMoviesByYear,
  createMovie,
  updateMovie,
  deleteMovieByID,
  deleteMovieByTitle,
} = require("../controllers/movies.controllers");

const router = express.Router();

router.get("/movies", getMovies);
router.get("/movies/id/:id", getMoviesByID);
router.get("/movies/title/:title", getMoviesByTitle);
router.get("/movies/genre/:genre", getMoviesByGenre);
router.get("/movies/year/:year", getMoviesByYear);
router.post("/movies/create", createMovie);
router.put("/movies/update/:id", updateMovie);
router.delete("/movies/delete/:id", deleteMovieByID);

module.exports = router;
