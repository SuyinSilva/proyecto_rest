package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.entidades.TipoReclamo;
import com.example.rest.util.ConectaDB;

public class TipoReclamoModel {

	private static final Log log = LogFactory.getLog(TipoReclamoModel.class);
	
	
	public List<TipoReclamo> listarTodos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<TipoReclamo> lista = new ArrayList<TipoReclamo>();
		try {
			String sql = "select * from tiporeclamo";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			TipoReclamo bean = null;
			while(rs.next()){
				bean = new TipoReclamo();
				bean.setIdtipoReclamo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setEstado(rs.getString(3));
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	
	public int insertaTipoReclamo(TipoReclamo obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into tiporeclamo values(null,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,obj.getDescripcion());
			pstm.setString(2,obj.getEstado());
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	
	public int actualizaTipoReclamo(TipoReclamo obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update tiporeclamo set descripcion =?, estado =? where idtiporeclamo =? ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,obj.getDescripcion());
			pstm.setString(2,obj.getEstado());
			pstm.setInt(3, obj.getIdtipoReclamo());
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	
	public List<TipoReclamo> consultaTipoReclamoPorId(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<TipoReclamo> lista = new ArrayList<TipoReclamo>();
		try {
			String sql = "select * from tiporeclamo where idtiporeclamo = ?";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			log.info(pstm);
			rs = pstm.executeQuery();
			TipoReclamo bean = null;
			while(rs.next()){
				bean = new TipoReclamo();
				bean.setIdtipoReclamo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setEstado(rs.getString(3));
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}
	
	public int eliminaTipoReclamo(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from tiporeclamo where id =?";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

}
