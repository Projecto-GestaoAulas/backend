package pt.upacademy.coreFinalProject.models.lessons.converters;

import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import pt.upacademy.coreFinalProject.models.core.converters.EntityConverter;
import pt.upacademy.coreFinalProject.models.lessons.Edition;
import pt.upacademy.coreFinalProject.models.lessons.DTOS.EditionDTO;
import pt.upacademy.coreFinalProject.services.lessons.AccountService;
import pt.upacademy.coreFinalProject.services.lessons.LessonService;

@RequestScoped
public class EditionConverter extends EntityConverter<Edition, EditionDTO> {

	@Inject
	private AccountService AS;
	
	@Inject
	private LessonService LS;
	
	
	@Override
	public Edition toEntity(EditionDTO dto) {
		Edition edition = new Edition();
		if (dto.getId() > 0) {
			edition.setId(dto.getId());
		}
		edition.setName(dto.getName());
		edition.setType(dto.getType());
		edition.setAccounts(dto.getAccountsIds().stream().map(entityId -> AS.get(entityId)).collect(Collectors.toList()));
		return edition;
	}

	@Override
	public EditionDTO toDTO(Edition ent) {
		EditionDTO editionDTO = new EditionDTO();
		editionDTO.setId(ent.getId());
		editionDTO.setName(ent.getName());
		editionDTO.setType(ent.getType());
		editionDTO.setAccountsIds(ent.getAccounts().stream().map(acc -> acc.getId()).collect(Collectors.toList()));
		editionDTO.setLessonsDtos(LS.getLessonsByEditionId(ent.getId()).stream().collect(Collectors.toList()));
		return editionDTO;

	}

}
