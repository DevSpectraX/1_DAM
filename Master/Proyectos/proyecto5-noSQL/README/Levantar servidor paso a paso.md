
### 1. Abrimos MongoDB

MongoDB esta vacío.

![Mongo](./images_added.MongoDB Vacio.png)


### 2. Cargamos las semillas

Con el siguiente comando en VSCode cargamos las semillas.

![[Comand seeds.png]]


Ahora en MongoDB vemos que han cargado las semillas correctamente.

![[MongoDB seeds added.png]]


### 3. Levantar el servidor

Hasta el momento Insomnia se muestra así, sin conexión.

![[Captura de pantalla 2026-08-18 110054 1.png]]


Ejecutamos este comando en VSCode para levantar el servidor.

![[Comand run dev.png]]


Y ahora ya podemos empezar a ejecutar las peticiones con Insomnia.

### 4. Prueba de peticiones

#### Error pagina no encontrada

![[Get_Error.png]]


#### Get AllMovies

![[Get_AllMovies.png]]


#### Get MoviesByID

![[Get_MoviesByID.png]]


#### Get MoviesByTitle

![[Get_MoviesByTitle.png]]


#### Get MoviesByYear

![[Get_MoviesByYear.png]]


#### Post CreateMovie

![[Post_CreateMovie.png]]


#### Put UpdateMovie

![[Put_UpdateMovie.png]]


#### Delete DeleteMovie

![[Delete_DeleteByID.png]]