package pt.upacademy.coreFinalProject.controllers.lessons;

import java.util.Collection;
import java.util.Collections;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pt.upacademy.coreFinalProject.controllers.core.EntityControllerDTO;
import pt.upacademy.coreFinalProject.models.lessons.Lesson;
import pt.upacademy.coreFinalProject.models.lessons.DTOS.LessonDTO;
import pt.upacademy.coreFinalProject.models.lessons.converters.LessonConverter;
import pt.upacademy.coreFinalProject.repositories.lessons.LessonRepository;
import pt.upacademy.coreFinalProject.services.lessons.LessonService;

@Path("/aulas/lessons")
@RequestScoped
public class LessonController extends EntityControllerDTO <LessonService, LessonRepository,LessonConverter, Lesson, LessonDTO> {

	@GET
	@Path("/edition/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<LessonDTO> getLessonsByEditionId(@PathParam("id") long id) {
		return service.getLessonsByEditionId(id);
	}
	
	public Collection<Lesson> getLessonByMaterialId(long id) {
		return service.getLessonByMaterialId(id);
	}
	
	@Override
	@DELETE
	@Path("/{id}")
	public Response delete (@PathParam("id") long id) {
		Lesson deleteLesson = service.get(id);
		deleteLesson.setMaterials(Collections.emptyList());
		service.update(deleteLesson);
		service.delete(id);
		return Response.ok().build();
	}
}
