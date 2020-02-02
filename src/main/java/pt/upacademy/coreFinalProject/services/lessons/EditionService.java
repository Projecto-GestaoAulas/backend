package pt.upacademy.coreFinalProject.services.lessons;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import pt.upacademy.coreFinalProject.models.lessons.Edition;
import pt.upacademy.coreFinalProject.models.lessons.DTOS.EditionDTO;
import pt.upacademy.coreFinalProject.models.lessons.converters.EditionConverter;
import pt.upacademy.coreFinalProject.repositories.lessons.EditionRepository;
import pt.upacademy.coreFinalProject.services.core.EntityService;



@RequestScoped
public class EditionService extends  EntityService <EditionRepository, Edition>{
	
	@Inject
	protected EditionConverter converter;

	
	public Collection<EditionDTO> getbyAccountId(long id) {
		return repository.getbyAccountId(id).stream().map(ed -> converter.toDTO(ed)).collect(Collectors.toList());
	}


	public Collection<Long> getEditionIdsByAccountID(long id) {
		return repository.getEditionIdsByAccountID(id);
	}

}
