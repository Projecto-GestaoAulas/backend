package pt.upacademy.coreFinalProject.repositories.lessons;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import pt.upacademy.coreFinalProject.models.lessons.Note;
import pt.upacademy.coreFinalProject.repositories.core.EntityRepository;



@ApplicationScoped
public class NoteRepository extends EntityRepository<Note>{

	@Override
	protected Class<Note> getEntityClass() {
		return Note.class;
	}

	@Override
	protected String getAllEntities() {
		return Note.GET_ALL_NOTES;
	}


	protected String getAllEntitiesIds() {
		return Note.GET_ALL_NOTES_IDS;
	}

	
	protected String getEntitiesCount() {
		return Note.GET_NOTES_COUNT;
	}
	
	
	public List <Note> getNotesByLessonsIds(long id) {
		return entityManager.createNamedQuery(Note.GET_NOTES_BY_LESSONS_IDS, Note.class).setParameter("lessonId", id).getResultList();
	}
	
	public List <Note> getNotesByAccountId(long id) {
		return entityManager.createNamedQuery(Note.GET_NOTES_BY_ACCOUNT_ID, Note.class).setParameter("accountId", id).getResultList();
	}

	public Note createNote(Note note) {
		return entityManager.merge(note);
	}

	public Note updateNote(Note note) {
		return entityManager.merge(note);
	}
}
