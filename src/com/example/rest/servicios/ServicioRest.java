package com.example.rest.servicios;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.UsuarioModel;
import com.example.rest.entidades.Usuario;

import com.example.rest.dao.MarcaModel;
import com.example.rest.dao.TipoReclamoModel;
import com.example.rest.entidades.Marca;
import com.example.rest.entidades.TipoReclamo;

//GET,POST,PUT,DELETE métodos del protocolo HTTP
// La tecnología rest utiliza estos cuatro métodos
// GET--->se va realiza un select
// POST--->se va realiza un registrar
// PUT--->se va realiza un actualizar
// DELETE--->se va realiza un eliminar

@Path("/servicios")
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);
	private UsuarioModel daoUser = new UsuarioModel();

	@GET
	@Path("/usuario/{idParam}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarPorId(@PathParam("idParam") int id) {
		log.info("listarTodos rest ");
		return Response.ok(daoUser.consultaUserPorId(id)).build();
	}

	@GET
	@Path("/usuario")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarTodos() {
		log.info("listarTodos rest ");
		return Response.ok(daoUser.listarTodos()).build();
	}

	@POST
	@Path("/usuario")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response registra(Usuario obj) {
		log.info("Registra usuario " + obj.getId());
		if (daoUser.insertaUser(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/usuario")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response atualiza(Usuario obj) {
		log.info("Actualiza usuario " + obj.getId());
		if (daoUser.actualizaUser(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/usuario/{idParam}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response elimina(@PathParam("idParam") int id) {
		log.info("Elimina usuario " + id);
		if (daoUser.eliminaUser(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	/*Marca*/
	private MarcaModel daoMarca = new MarcaModel();
	
	@GET
	@Path("/marca/{idParam}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarPorIdMarca(@PathParam("idParam") int id) {
		log.info("listarTodos rest ");
		return Response.ok(daoMarca.consultaMarcaPorId(id)).build();
	}

	@GET
	@Path("/marca")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarTodosMarca() {
		log.info("listarTodos rest ");
		return Response.ok(daoMarca.listarTodos()).build();
	}

	@POST
	@Path("/marca")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response registraMarca(Marca obj) {
		log.info("Registra marca" + obj.getIdMarca());
		if (daoMarca.insertaMarca(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/marca")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response atualizaMarca(Marca obj) {
		log.info("Actualiza marca" + obj.getIdMarca());
		if (daoMarca.actualizaMarca(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/marca/{idParam}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response eliminaMarca(@PathParam("idParam") int id) {
		log.info("Elimina marca" + id);
		if (daoMarca.eliminaMarca(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	/*TIPORECLAMO*/
	private TipoReclamoModel daoTipoReclamo = new TipoReclamoModel();
	
	@GET
	@Path("/tiporeclamo/{idParam}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarPorIdTipoReclamo(@PathParam("idParam") int id) {
		log.info("listarTodos rest ");
		return Response.ok(daoTipoReclamo.consultaTipoReclamoPorId(id)).build();
	}

	@GET
	@Path("/tiporeclamo")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarTodosTipoReclamo() {
		log.info("listarTodos rest ");
		return Response.ok(daoTipoReclamo.listarTodos()).build();
	}

	@POST
	@Path("/tiporeclamo")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response registraTipoReclamo(TipoReclamo obj) {
		log.info("Registra tipo reclamo" + obj.getIdtipoReclamo());
		if (daoTipoReclamo.insertaTipoReclamo(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/tiporeclamo")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response atualizaTipoReclamo(TipoReclamo obj) {
		log.info("Actualiza tipo reclamo" + obj.getIdtipoReclamo());
		if (daoTipoReclamo.actualizaTipoReclamo(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/tiporeclamo/{idtipoReclamo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response eliminaTipoReclamo(@PathParam("idtipoReclamo") int id) {
		log.info("Elimina tipo reclamo" + id);
		if (daoTipoReclamo.eliminaTipoReclamo(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

}