package org.example.fichador.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Usuario {

    private String nombre, apellido, dni, correo, password, rol;

    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Usuario("Admin", "Principal", "1A", "admin@fichador.com", "admin123", "ADMIN"));
        usuarios.add(new Usuario("Juan", "García", "2B", "juan@fichador.com", "juan123", "TRABAJADOR"));
    }

    public static void alta(Usuario u) {
        usuarios.add(u);
    }

    public static boolean baja(String dni) {
        return usuarios.removeIf(u -> u.getDni().equals(dni));
    }

    public static Usuario buscarPorDni(String dni) {
        return usuarios.stream()
                .filter(u -> u.getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }

    public static List<Usuario> mostrarTodos() {
        return usuarios;
    }

    public static boolean cambiarPass(String dni, String nuevaPass) {
        Usuario usuario = buscarPorDni(dni);
        if (usuario != null) {
            usuario.setPassword(nuevaPass);
            return true;
        }
        return false;
    }

    public static Usuario login(String dni, String password) {
        return usuarios.stream()
                .filter(u -> u.getDni().equals(dni) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}