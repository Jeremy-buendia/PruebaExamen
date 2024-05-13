package org.openjfx.PruebaExamen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	public static ArrayList<KoalaDO> getKoala(Connection con) {

		try {
			// Query para cargar el koala con el id
			String query = "SELECT * FROM koala";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			ArrayList<KoalaDO> arrayProductos = new ArrayList<>();

			while (rs.next()) {
				// Creamos un KoalaDO y le añadimos los datos del de la base de datos
				KoalaDO koala = new KoalaDO();
				koala.setIdKoala(rs.getInt("idKoala"));
				koala.setNombre(rs.getString("nombre"));
				koala.setNickguerra(rs.getString("nickguerra"));
				koala.setEdad(rs.getInt("edad"));
				koala.setColor(rs.getString("color"));
				koala.setFuerza(rs.getInt("fuerza"));
				koala.setInteligencia(rs.getInt("inteligencia"));
				koala.setHorasSueno(rs.getInt("horasSueno"));
				koala.setTiempoBerserk(rs.getInt("tiempoBerserk"));
				koala.setCarritoGolf_idCarritoGolf(rs.getInt("CarritoGolf_idCarritoGolf"));
				koala.setAvestruz_idAvestruz(rs.getInt("Avestruz_idAvestruz"));
				arrayProductos.add(koala);
			}
			return arrayProductos;
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<AvestruzDO> getAvestruz(Connection con) {

		try {
			// Query para cargar el koala con el id
			String query = "SELECT * FROM avestruz";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			ArrayList<AvestruzDO> arrayProductos = new ArrayList<>();

			while (rs.next()) {
				// Creamos un KoalaDO y le añadimos los datos del de la base de datos
				AvestruzDO avestruz = new AvestruzDO();
				avestruz.setIdAvestruz(rs.getInt("idAvestruz"));
				avestruz.setNombre(rs.getString("nombre"));
				avestruz.setNickguerra(rs.getString("nickguerra"));
				avestruz.setEdad(rs.getInt("edad"));
				avestruz.setAltura(rs.getDouble("altura"));
				avestruz.setNivelMalaLeche(rs.getInt("nivelMalaLeche"));
				avestruz.setNumHuevos(rs.getInt("numHuevos"));
				arrayProductos.add(avestruz);
			}
			return arrayProductos;
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<CarritoDO> getCarrito(Connection con) {

		try {
			// Query para cargar el koala con el id
			String query = "SELECT * FROM carritogolf";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			ArrayList<CarritoDO> arrayProductos = new ArrayList<>();

			while (rs.next()) {
				// Creamos un KoalaDO y le añadimos los datos del de la base de datos
				CarritoDO carrito = new CarritoDO();
				carrito.setIdCarritoGolf(rs.getInt("idCarritoGolf"));
				carrito.setNumSerie(rs.getString("numSerie"));
				carrito.setMarca(rs.getString("marca"));
				carrito.setVelocidadMax(rs.getInt("velocidadMax"));
				carrito.setArmamento(rs.getString("armamento"));
				carrito.setMunicion(rs.getInt("municion"));
				arrayProductos.add(carrito);
			}
			return arrayProductos;
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<KoalaDO> cargarLacayos(int idAvestruz, Connection con) {
		try {
			// Creamos un ArrayList de Koalas
			ArrayList<KoalaDO> koalasAsociadosAvestruz = new ArrayList<>();
			// Query para cargar los koalas asociados a un Avestruz
			String query = "SELECT * FROM koala WHERE Avestruz_idAvestruz = ?";

			// Preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, idAvestruz);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// Creamos un nuevo koala y le agregamos los datos
				KoalaDO koala = new KoalaDO();
				koala.setIdKoala(rs.getInt("idKoala"));
				koala.setNombre(rs.getString("nombre"));
				koala.setNickguerra(rs.getString("nickguerra"));
				koala.setEdad(rs.getInt("edad"));
				koala.setColor(rs.getString("color"));
				koala.setFuerza(rs.getInt("fuerza"));
				koala.setInteligencia(rs.getInt("inteligencia"));
				koala.setHorasSueno(rs.getInt("horasSueno"));
				koala.setTiempoBerserk(rs.getInt("tiempoBerserk"));
				koala.setCarritoGolf_idCarritoGolf(rs.getInt("CarritoGolf_idCarritoGolf"));
				koala.setAvestruz_idAvestruz(rs.getInt("Avestruz_idAvestruz"));
				// Lo agregamos al ArrayList
				koalasAsociadosAvestruz.add(koala);
			}

			// Devolvemos el arrayList
			return koalasAsociadosAvestruz;

		} catch (Exception e) {
			e.printStackTrace();
			// si hay error devolvemos null
			return null;
		}
	}
}
