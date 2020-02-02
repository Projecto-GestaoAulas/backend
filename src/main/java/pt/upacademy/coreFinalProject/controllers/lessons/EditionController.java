package pt.upacademy.coreFinalProject.controllers.lessons;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.upacademy.coreFinalProject.controllers.core.EntityControllerDTO;
import pt.upacademy.coreFinalProject.models.lessons.Edition;
import pt.upacademy.coreFinalProject.models.lessons.DTOS.EditionDTO;
import pt.upacademy.coreFinalProject.models.lessons.converters.EditionConverter;
import pt.upacademy.coreFinalProject.repositories.lessons.EditionRepository;
import pt.upacademy.coreFinalProject.services.lessons.EditionService;


@RequestScoped
@Path ("/aulas/editions")
public class EditionController extends EntityControllerDTO <EditionService, EditionRepository, EditionConverter, Edition, EditionDTO> {
	
	@Inject
	protected EditionService service;
	
	@GET
	@Path("accounts/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<EditionDTO> getbyAccountId(@PathParam("id") long id) {
		Collection<EditionDTO> ent = service.getbyAccountId(id);
		return ent;
	}
	
	@GET
	@Path("accounts/ids/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Long> getEditionIdsByAccountID(@PathParam("id") long id) {
		return service.getEditionIdsByAccountID(id);
	}
}

	

