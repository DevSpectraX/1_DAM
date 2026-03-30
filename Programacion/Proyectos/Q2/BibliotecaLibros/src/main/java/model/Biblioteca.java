package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Biblioteca {
    //Representará el conjunto de libros importados desde el JSON.

    private List<Libro> libros = new ArrayList<>();
    private List<Libro> favoritos = new ArrayList<>();

}
