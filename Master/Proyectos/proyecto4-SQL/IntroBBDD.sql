1. Escribe una consulta que recupere los Vuelos (flights) y su identificador que 
figuren con status 'On Time'.

SELECT flight_id, route_no, status FROM flights
WHERE status = 'On Time'


2. Escribe una consulta que extraiga todas las columnas de la tabla bookings y refleje 
todas las reservas que han supuesto una cantidad total mayor a 1.000.000 (Unidades monetarias).
Nota: las tablas son públicas de Rusia, por tanto son Rublos sus unidades monetarias

SELECT * FROM bookings
WHERE total_amount > 1000000


3. Escribe una consulta que extraiga todas las columnas de los datos de los modelos de aviones 
disponibles (aircraft_data). Puede que os aparezca en alguna actualización como "aircrafts_data", 
revisad las tablas y elegid la que corresponda.

SELECT * FROM airplanes_data


4. Con el resultado anterior visualizado previamente, escribe una consulta que extraiga los 
identificadores de vuelo que han volado con un Boeing 737. (Código Modelo Avión = 733) 

/*  Nota: El Modelo actualmente es 7M7 y la columna se encuentra en jsonb, he necesitado pasar de json a texto 
usando ::text y luego buscar Boeing737. */

SELECT * FROM airplanes_data
WHERE model::text ILIKE '%Boeing 737%';


5. Escribe una consulta que te muestre la información detallada de los tickets que han comprado 
las personas que se llaman Irina.

SELECT * FROM tickets
WHERE passenger_name ILIKE 'irina%'


6. Mostrar las ciudades con más de un aeropuerto.

/* Esta consulta a sido complicada porque he tenido que mezclar conceptos de jsonb + IN */ 

SELECT city->>'en' AS ciudad, COUNT(*) AS numero_aeropuertos FROM airports_data
WHERE city ->>'en' IN (
    --Significa coge el nombre de las ciudades del json y saca solo 'en'
	SELECT city->>'en' FROM airports_data
    -- y agrupadlos por el nombre pero que sean mayor de 1
	GROUP BY city->>'en'
	HAVING COUNT(*) > 1
)
GROUP BY city->>'en'
ORDER BY numero_aeropuertos DESC
	

7. Mostrar el número de vuelos por modelo de avión.

SELECT model->>'en' AS modelo, COUNT(*) AS numero_vuelos FROM airplanes_data ad

JOIN routes r
	ON ad.airplane_code = r.airplane_code
JOIN flights f
	ON r.route_no = f.route_no
GROUP BY model->>'en'


8. Reservas con más de un billete (varios pasajeros).

SELECT t.book_ref AS reserva, 
    --Contamos pasajeros
	COUNT(t.passenger_id) AS numero_pasajeros  
FROM bookings b

JOIN tickets t
	ON b.book_ref = t.book_ref
--Agrupamos por book_ref que seria el codigo de reserva
GROUP BY t.book_ref
--Y filtramos por mayores a 1 pasajero
HAVING COUNT(t.passenger_id) > 1
--Por último ordenamos el numero de pasajeros aprovechando el alias en orden descendente
ORDER BY numero_pasajeros DESC
	
	
9. Vuelos con retraso de salida superior a una hora.
/*He creado una tabla donde dice a donde va el vuelo
y he creado una columna con el retraso y lo he ordenado
por el destino ascendente*/
SELECT flight_id, r.arrival_airport AS llegada_a, 
actual_departure - scheduled_departure AS retraso 

FROM flights f
JOIN routes r
ON f.route_no = r.route_no
WHERE actual_departure - scheduled_departure > INTERVAL '1 hour'
ORDER BY llegada_a ASC