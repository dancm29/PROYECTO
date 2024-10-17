/* Programa Práctica 2: Entidad Motocicletas
   Paradigmas de programación II
   Profesor: M. en C. Manuel Alejandro Valdés Marrero
   Nombre: Allan Daniel Cruz Matias
   Grupo: 412
 */

package catalogo_motocicletas.dominio;

import java.util.ArrayList;
import java.util.Date;

/*
 * Clase Motocicleta la cual maneja las características propias de la entidad.
 */
public class Motocicleta {
	// 1. Número libre
	private int id;
	// 2. Número de rango
	private int cilindrada;
	// 3. Texto libre
	private String modelo;
	// 4. Texto con formato predefinido
	/*
	 * Carácter 1 al 3: WMI (World Manufacturer Identifier)-Identifica al fabricante
	 * y el país de origen. Carácter 4 al 9: VDS (Vehicle Descriptor
	 * Section)-Describen atributos del vehículo como el modelo, tipo de motor, y
	 * tipo de carrocería. Carácter 10: Año de fabricación. Utiliza una letra o un
	 * número para indicar el año de producción del vehículo. Carácter 11: Planta de
	 * ensamblaje. Identifica la planta donde fue ensamblada la motocicleta.
	 * Carácter 12 al 17: Número de serie único del vehículo. Especifica un número
	 * secuencial asignado al vehículo en particular.
	 */
	private String serie;
	// 5. Fecha, que serían un objeto de tipo Date
	private Date fechaFabricacion;
	// 6. Opciones mutuamente excluyentes fijas (Tipo combustible: Gasolina,
	// Eléctrico)
	private String tipoCombustible;
	// 7. Opciones mutuamente excluyentes dinámicas
	private String marca;
	// 8.Opciones no excluyentes fijas (Características Fijas: ABS, Bluetooth,
	// Alarma)
	private ArrayList<String> caracteristicasPropias;
	// 9. Opciones no excluyentes dinámicas
	private ArrayList<String> accesorios;
	// 10. Imagen, que sería un String para la ruta de la imagen
	private String rutaImagen;

	// Métodos get por defecto.
	/*
	 * Getter para consultar el id de la motocicleta.
	 */
	public int getId() {
		return id;
	}

	/*
	 * Getter para consultar la cilindrada de la motocicleta.
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/*
	 * Getter para consultar el modelo de la motocicleta.
	 */
	public String getModelo() {
		return modelo;
	}

	/*
	 * Getter para consultar la serie de la motocicleta.
	 */
	public String getSerie() {
		return serie;
	}

	/*
	 * Getter para consultar la fecha de fabricación de la motocicleta.
	 */
	public Date getFechaFabricacion() {
		return fechaFabricacion;
	}

	/*
	 * Getter para consultar el tipo de combustible de la motocicleta.
	 */
	public String getTipoCombustible() {
		return tipoCombustible;
	}

	/*
	 * Getter para consultar la marca de la motocicleta.
	 */
	public String getMarca() {
		return marca;
	}

	/*
	 * Getter para consultar las características propias de la motocicleta.
	 */
	public ArrayList<String> getCaracteristicasFijas() {
		return caracteristicasPropias;
	}

	/*
	 * Getter para consultar los accesorios de la motocicleta.
	 */
	public ArrayList<String> getAccesorios() {
		return accesorios;
	}

	/*
	 * Getter para consultar la ruta de la imagen de la motocicleta.
	 */
	public String getRutaImagen() {
		return rutaImagen;
	}

	// Métodos set para las variables 1 y 2
	/*
	 * El setter id transformará el dato String al tipo de dato de la variable y
	 * llamará al setter cilindrada.
	 */
	public void setId(String id) {
		if (id != null) {
			id = id.replace(" ", "");
			if (id.matches("\\d+")) {
				setId(Integer.parseInt(id));
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	/*
	 * Setter para establecer el id de la motocicleta.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * El setter cilindrada validará el dato de ser necesario y hará la asignación a
	 * la variable miembro.
	 */
	public void setCilindrada(String cilindrada) {
		if (cilindrada != null) {
			cilindrada = cilindrada.replace(" ", "");
			if (cilindrada.matches("\\d+")) {
				setCilindrada(Integer.parseInt(cilindrada));
			} else {
				throw new IllegalArgumentException("La cilindrada debe ser un número válido.");
			}
		} else {
			throw new IllegalArgumentException("La cilindrada no puede ser nula.");
		}
	}

	/*
	 * Setter que tiene el propósito de validar y asignar un valor a dicho atributo.
	 */
	public void setCilindrada(int cilindrada) {
		if (cilindrada > 0 && cilindrada <= 2000) {
			this.cilindrada = cilindrada;
		} else {
			throw new IllegalArgumentException();
		}
	}

	// Método set para la variable 3
	/*
	 * Setter que quita los espacios de los extremos y valida que no esté vacío el
	 * dato.
	 */
	public void setModelo(String modelo) {
		modelo = modelo.trim();
		if (modelo.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.modelo = modelo;
	}

	// Método set para la variable 4
	/*
	 * Setter que quita los espacios de los extremos y valida el formato del dato.
	 */
	public void setSerie(String serie) {
		if (serie != null && serie.matches("[A-Z]{3}-\\d{4}$")) {
			this.serie = serie;
		} else {
			throw new IllegalArgumentException();
		}
	}

	// Métodos set por defecto para las variables 5-10
	/*
	 * Setter para establecer la fecha de fabricación de la motocicleta.
	 */
	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	/*
	 * Setter para establecer el tipo de combustible de la motocicleta.
	 */
	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	/*
	 * Setter para establecer la marca de la motocicleta.
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/*
	 * Setter para establecer las características propias de la motocicleta.
	 */
	public void setCaracteristicasFijas(ArrayList<String> caracteristicasFijas) {
		this.caracteristicasPropias = caracteristicasFijas;
	}

	/*
	 * Setter para establecer los accesorios de la motocicleta.
	 */
	public void setAccesorios(ArrayList<String> accesorios) {
		this.accesorios = accesorios;
	}

	/*
	 * Setter para establecer la ruta de la imagen de la motocicleta.
	 */
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	// Constructor sin parámetros
	public Motocicleta() {
		this.id = 0;
		this.cilindrada = 0;
		this.modelo = "";
		this.serie = "";
		this.fechaFabricacion = null;
		this.tipoCombustible = "";
		this.marca = "";
		this.caracteristicasPropias = null;
		this.accesorios = null;
		this.rutaImagen = "";
	}

	/*
	 * Método que permite concatenar
	 */
	public String toString() {
		return marca + modelo + cilindrada;
	}
}
