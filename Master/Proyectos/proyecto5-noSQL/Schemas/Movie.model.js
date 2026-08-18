const mongoose = require("mongoose");

const movieSchema = new mongoose.Schema(
  {
    title: { type: "string", required: true },
    director: { type: "string", required: true },
    year: { type: "number", required: true, min: 1900, max: 2026 },
    genre: { type: "string", required: true },
  },
  {
    timestamps: true,
    versionKey: false,
  },
);

const Movie = mongoose.model("Movie", movieSchema);

module.exports = Movie;
