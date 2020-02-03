package pt.upacademy.coreFinalProject.services.lessons;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;

import pt.upacademy.coreFinalProject.models.lessons.Lesson;
import pt.upacademy.coreFinalProject.models.lessons.Materials;
import pt.upacademy.coreFinalProject.models.lessons.DTOS.MaterialsDTO;
import pt.upacademy.coreFinalProject.models.lessons.converters.MaterialsConverter;
import pt.upacademy.coreFinalProject.repositories.lessons.MaterialsRepository;
import pt.upacademy.coreFinalProject.services.core.EntityService;

public class MaterialsService extends EntityService <MaterialsRepository, Materials> {

	@Inject
	protected MaterialsRepository MR;
	
	@Inject
	protected LessonService LS;
	
	@Inject
	protected MaterialsConverter MC;
	

	public void delete(long id) {
		Collection<Lesson> lessons = LS.getLessonByMaterialId(id);
		for (Lesson lesson : lessons) {
			Collection<Materials> mats = lesson.getMaterials();
//			for (Materials mat : mats) {
//				if (mat.getId() == id) {
//					mats.remove(mat);
//					
//				}
//			}
			mats = mats.stream().filter(mat -> mat.getId() != id).collect(Collectors.toList());
			lesson.setMaterials(mats);
			LS.update(lesson);
		}
		repository.deleteEntity(id);
	}


	public Collection<MaterialsDTO> getMaterialsByLessonID(long id) {
		return repository.getMaterialsByLessonID(id).stream().map(mat -> MC.toDTO(mat)).collect(Collectors.toList());
	}
	
//	public Collection<Long> getMaterialsByLessonId(long id) {
//		return repository.getMaterialsByLessonsIds(id);
//	}
	
//	public Materials getById(long id) {
//		return MR.getEntity(id);
//		
//	}

}
