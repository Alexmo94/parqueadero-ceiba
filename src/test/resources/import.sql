CREATE TABLE estacionamiento (
  parking_id int(11) NOT NULL,
  vehiculo_id int(11) NOT NULL,
  parking_fecha_entrada date NOT NULL,
  parking_fecha_salida date DEFAULT NULL,
  parking_total decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (parking_id),
  KEY vehiculo_id (vehiculo_id),
  CONSTRAINT estacionamiento_ibfk_1 FOREIGN KEY (vehiculo_id) REFERENCES vehiculo (vehiculo_id)
);