package pt.upacademy.coreFinalProject.repositories;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import pt.upacademy.coreFinalProject.models.Lesson;

@ApplicationScoped
public class LessonRepository extends EntityRepository<Lesson> {

	@Override
	protected Class<Lesson> getEntityClass() {
		return Lesson.class;
	}

	@Override
	protected String getAllEntities() {

		return Lesson.GET_ALL_LESSONS;
	}

	public Collection<Lesson> getLessonsByEditionId(long id) {
		return entityManager.createNamedQuery(Lesson.GET_LESSONS_BY_EDITION_ID, Lesson.class).setParameter("editionId", id).getResultList();
	}

}
