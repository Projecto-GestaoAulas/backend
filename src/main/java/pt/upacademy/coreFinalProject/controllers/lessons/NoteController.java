package pt.upacademy.coreFinalProject.controllers.lessons;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.upacademy.coreFinalProject.controllers.core.EntityController;
import pt.upacademy.coreFinalProject.models.lessons.Note;
import pt.upacademy.coreFinalProject.repositories.lessons.NoteRepository;
import pt.upacademy.coreFinalProject.services.lessons.NoteService;



@RequestScoped
@Path("/aulas/notes")
public class NoteController extends EntityController<NoteService, NoteRepository, Note>{

	@Inject
	protected NoteService NS;
	
	@GET
	@Path("/lesson/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getNotesByLessonId(@PathParam("id") long id) {
		return NS.getNotesByLessonId(id);
	}

	@GET
	@Path("/account/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getNotesByAccountId(@PathParam("id") long id) {
		return NS.getNotesByAccountId(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Note createNote(Note note) {
		return NS.createNote(note);
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Note updateNote(Note note) {
		return NS.updateNote(note);
	}
	
	
	
	
	
}
