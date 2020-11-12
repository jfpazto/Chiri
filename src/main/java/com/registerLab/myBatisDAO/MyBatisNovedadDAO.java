package com.registerLab.myBatisDAO;

import java.sql.Date;
import java.util.ArrayList;

import com.google.inject.Inject;
import com.registerLab.ECILabException;
import com.registerLab.DAO.NovedadDAO;
import com.registerLab.entities.Novedad;
import com.registerLab.mappers.NovedadMapper;

public class MyBatisNovedadDAO implements NovedadDAO{
	@Inject
	private NovedadMapper mapper;
	
	@Override
	public Novedad getNovedad(int id) {
		return mapper.getNovedad(id);		
	}
	
	@Override
	public void agregarNovedad(String descripcion,String justificacion,int idEquipo, int idElemento,int usuario) throws ECILabException {
		if(justificacion =="" || justificacion== null) throw new ECILabException("No se puede agregar, debido a que no hay justificacion");
		if(descripcion =="" || descripcion== null) throw new ECILabException("No se puede agregar, debido a que no hay descripcion");
		mapper.agregarNovedad(descripcion, justificacion,idEquipo,idElemento,usuario);
		
	}
	
	@Override
	public int getUltimaNovedad() {
		return mapper.getUltimaNovedad();
	}

	@Override
	public void registrarNovedadSinEquipo(String descripcion, String justificacion, int elemento, int usuario) {
		mapper.registrarNovedadSinEquipo(descripcion,justificacion,elemento,usuario);
		
	}
	public ArrayList<Novedad> getNovedades(){
		return mapper.getNovedades();
	}

	@Override
	public ArrayList<Novedad> novedadesEquipo(int equipo) {
		// TODO Auto-generated method stub
		return mapper.novedadesEquipo(equipo);
	}

	@Override
	public ArrayList<Novedad> getNovedadesElemento(int elemento) {
		// TODO Auto-generated method stub
		return mapper.getNovedadesElemento(elemento);
	}

	@Override
	/*
	 * @param elemento - id del elemento
	 * @param equipo - id del equipo
	 * @return devuelve las novedades que corresponden a la id del los elementos y equipos dados 
	 */
	public ArrayList<Novedad> getNovedades(int elemento, int equipo) {
		return mapper.getNovedadesElementoEquipo(elemento,equipo);
	}

	@Override
	public void agregarNovedadSinElemento(String razon, String justificacion, int equipo, int usuario) {
		mapper.agregarNovedadSinElemento(razon,justificacion,equipo,usuario);
		
	}
	
	@Override
	public ArrayList<Novedad> getNovedadesLabEqui(int labo){
		return mapper.getNovedadesLabEqui(labo);
	}
	
}
