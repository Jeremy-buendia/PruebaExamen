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
}
