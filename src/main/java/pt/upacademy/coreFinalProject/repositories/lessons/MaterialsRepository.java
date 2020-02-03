package pt.upacademy.coreFinalProject.repositories.lessons;

import java.util.Collection;

import pt.upacademy.coreFinalProject.models.lessons.Materials;
import pt.upacademy.coreFinalProject.repositories.core.EntityRepository;

public class MaterialsRepository extends EntityRepository <Materials> {

	@Override
	protected Class<Materials> getEntityClass() {
		return Materials.class;
	}

	@Override
	protected String getAllEntities() {
		return Materials.GET_ALL_MATERIALS;
	}

	public Collection<Materials> getMaterialsByLessonID(long id) {
		return entityManager.createNamedQuery(Materials.GET_MATERIALS_BY_LESSON_ID, Materials.class).setParameter("lessonId", id).getResultList();
	}

//	public Collection<Long> getMaterialsByLessonsIds(long id) {
//		return Materials.GET_MATERIALS_BY_LESSON_ID;
//	}

}
