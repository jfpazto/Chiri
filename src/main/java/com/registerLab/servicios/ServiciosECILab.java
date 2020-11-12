package com.registerLab.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.registerLab.ECILabException;
import com.registerLab.entities.Elemento;
import com.registerLab.entities.Equipo;
import com.registerLab.entities.Laboratorio;
import com.registerLab.entities.Novedad;
import com.registerLab.entities.Usuario;

public interface ServiciosECILab {
	
	public Usuario getUsuario(String correo);
	
	public void insertarEquipoSinLaboratorio(int id,Date fechaInicioActividad,Date fechafinactividad,Date fechaAdquisicion) throws ECILabException;
	
	public Equipo getEquipo(int id);
	
	public Elemento getElemento(int id);
	
	public List<Elemento> getElementos();
	
	public Novedad getNovedad(int id) throws ECILabException;
	
	public void AgregarNovedad(String descripcion,String justificacion,int idEquipo,int idElemento,int usuario) throws ECILabException;
	
	public void AgregarElemento(int id, String categoria, String fabricante, String referencia, Date fechaAdquisicion, Date fechaInicioActividad, Date fechaFinActivida) throws ECILabException; 
	
	public int getUltimaNovedad();
	
	public void asociarElemento(int idElemento, int IdEquipoN,int usuario) throws ECILabException;
	
	public ArrayList<Equipo> getEquipos();
	
	public void asociarElemento(int idElemento, int IdEquipoN) throws ECILabException;
	
	public void asociarEquipo(int idEquipo, int IdLaboratorioN) throws ECILabException;

	public void registrarUsuario(int carnet,String nombre,String apellido,String correo,String rol,String contra);
	
	public boolean equipoPoseElemento(int elemento);
	
	public void darBajaElemento(int elemento,int usuario) throws ECILabException ;
	
	public void registrarNovedadSinEquipo(String descripcion,String justificacion,int elemento,int usuario);
	
	public void darBajaEquipo(int equipo,int usuario) throws ECILabException ;

	public void asociarEquipo(int idEquipo, int IdLaboratorioN, int usuario) throws ECILabException;
	
	public ArrayList<Novedad> getNovedades();
	
	public void agregarLaboratorio(int id, String nombre, int capacidad, Date fechacierre, Date fechaapertura) throws ECILabException;

	public List<Laboratorio> getLaboratorios();
	
	public void darBajaConEquipoAsociado(Elemento e, Equipo eq);
	
	public void desvincularElemento(Elemento e, Equipo eq);
	
	public ArrayList<Elemento> getElementosActivos();
	
	public ArrayList<Equipo> getEquiposinLab();
	
	public void cerrarLaboratorio(int laboratorio) throws ECILabException;
	

	public List<Laboratorio> getTodosLaboratorios();
	
	public int cantidadEquipo( int laboratorio);
	
	public ArrayList<Novedad> getNovedadesLabEqui(int labo);
	
	public int ElementosLaboratorio(int laboratorio);
	
	public int equiposLaboratorios(String mes);
}
