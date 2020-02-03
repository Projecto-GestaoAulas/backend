package pt.upacademy.coreFinalProject.services.lessons;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import pt.upacademy.coreFinalProject.models.lessons.Lesson;
import pt.upacademy.coreFinalProject.models.lessons.DTOS.LessonDTO;
import pt.upacademy.coreFinalProject.models.lessons.converters.LessonConverter;
import pt.upacademy.coreFinalProject.repositories.lessons.LessonRepository;
import pt.upacademy.coreFinalProject.services.core.EntityService;


@RequestScoped
public class LessonService extends EntityService <LessonRepository, Lesson> {
	
	@Inject
	protected LessonConverter converter;

	public Collection<LessonDTO> getLessonsByEditionId(long id) {
		return repository.getLessonsByEditionId(id).stream().map(ed -> converter.toDTO(ed)).collect(Collectors.toList());
	}
	
	public Collection<Lesson> getLessonByMaterialId(long id) {
		return repository.getLessonByMaterialId(id);
	}
}
