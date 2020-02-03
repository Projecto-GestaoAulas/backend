package pt.upacademy.coreFinalProject.services.lessons;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import pt.upacademy.coreFinalProject.models.lessons.Note;
import pt.upacademy.coreFinalProject.repositories.lessons.NoteRepository;
import pt.upacademy.coreFinalProject.services.core.EntityService;

@RequestScoped
public class NoteService extends EntityService<NoteRepository, Note> {

	public List<Note> getNotesByLessonId(long id) {
		return repository.getNotesByLessonsIds(id);
	}

	public List<Note> getNotesByAccountId(long id) {
		return repository.getNotesByAccountId(id);
	}

	public Note createNote(Note note) {
		return repository.createNote(note);
	}

	public Note updateNote(Note note) {
		return repository.updateNote(note);
	}

}
