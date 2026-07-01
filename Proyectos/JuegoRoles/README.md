# 🎮 Juego de Combate por Turnos

## 📖 Descripción

Juego de estrategia por turnos desarrollado en Java donde dos equipos de personajes compiten en un combate hasta que uno de los equipos sea eliminado por completo. El juego incluye sistema de guardado y carga de partidas, permitiendo continuar el juego en sesiones posteriores.

## 🎯 Objetivo

Eliminar a todos los personajes del equipo rival utilizando las habilidades únicas de cada tipo de personaje.

## 👥 Tipos de Personajes

### 🧙 Mago
- **Vida inicial:** 100
- **Hechizos disponibles:** 4
- **Especialidades:**
  - **Magia Blanca:** Cura más (70-100 pts) pero hace menos daño (25 pts)
  - **Magia Negra:** Cura menos (40-70 pts) pero hace más daño (45 pts)
- **Habilidades:**
  1. **Curar personaje:** Restaura vida aleatoria a un aliado
  2. **Conjuro de sanación:** Cura al 100% a todos los aliados (consume 1 hechizo)
  3. **Hechizo:** Daña a todos los enemigos (consume 1 hechizo)

### ⚔️ Soldado
- **Vida inicial:** 100
- **Curaciones disponibles:** 4
- **Habilidades:**
  1. **Atacar enemigo:** Provoca entre 10-20 puntos de daño aleatorio
  2. **Curar aliado:** Restaura 20 puntos de vida a un aliado, pero pierde 10 de vida propia (consume 1 curación)

### 🏹 Arquero
- **Vida inicial:** 100
- **Flechas disponibles:** 4
- **Habilidades:**
  1. **Atacar enemigo:** Provoca 20 puntos de daño fijo
  2. **Ataque grupal:** Provoca 30 puntos de daño a todos los enemigos (consume 1 flecha)

### 🛡️ Guerrero
- **Vida inicial:** 100
- **Potenciadores disponibles:** 2
- **Habilidades:**
  1. **Atacar enemigo:** Provoca 50 puntos de daño fijo
  2. **Ataque mortal:** Quita el 50% de la vida actual a todos los enemigos (consume 1 potenciador)

## 📋 Reglas del Juego

### Equipos
- Hay **2 equipos**: Equipo A y Equipo B
- Cada equipo puede tener **máximo 1 personaje de cada tipo** (1 Mago, 1 Soldado, 1 Arquero, 1 Guerrero)
- No se pueden repetir tipos de personaje en el mismo equipo
- Cada equipo puede tener entre 1 y 4 personajes

### Sistema de Turnos
- Los turnos se alternan entre el Equipo A y el Equipo B
- En cada turno, el jugador elige qué personaje usar y qué acción realizar
- Solo pueden actuar los personajes que estén vivos
- El juego termina cuando todos los personajes de un equipo mueren

### Sistema de Rango
- Cada personaje empieza en **rango 1**
- Al acumular **100 puntos provocados**, el personaje sube de rango
- Los puntos provocados se obtienen al:
  - Dañar enemigos
  - Curar aliados
- Al subir de rango, los puntos provocados se resetean (pero conservan el sobrante)

### Condición de Victoria
- Gana el equipo que logre eliminar a todos los personajes del equipo rival

## 🎮 Cómo Jugar

### Menú Principal
Al iniciar el programa, se muestra el menú principal con las siguientes opciones:

1. **Agregar personaje:** Crea un nuevo personaje y lo añade a un equipo
2. **Listar equipos:** Muestra todos los personajes de ambos equipos
3. **Buscar personaje:** Busca personajes por nombre (búsqueda parcial)
4. **Comenzar juego:** Inicia el combate por turnos
5. **Guardar partida:** Guarda el estado actual de los equipos
6. **Cargar partida:** Carga una partida guardada anteriormente
7. **Salir:** Cierra el programa

### Durante el Juego
En cada turno se muestra:
- Los personajes vivos disponibles
- Las acciones que puede realizar el personaje seleccionado
- El estado de todos los personajes después de cada acción

Al final de cada turno, se puede guardar la partida para continuar más tarde.
