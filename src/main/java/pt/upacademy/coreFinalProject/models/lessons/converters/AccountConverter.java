package pt.upacademy.coreFinalProject.models.lessons.converters;

import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import pt.upacademy.coreFinalProject.models.core.converters.EntityConverter;
import pt.upacademy.coreFinalProject.models.lessons.AccountLessons;
import pt.upacademy.coreFinalProject.models.lessons.DTOS.AccountDTO;
import pt.upacademy.coreFinalProject.services.lessons.EditionService;

@RequestScoped
public class AccountConverter extends EntityConverter<AccountLessons, AccountDTO> {

	@Inject
	private EditionService editionBus;

	@Inject
	protected EditionConverter converter;

	@Override
	public AccountLessons toEntity(AccountDTO dto) {

		AccountLessons account = new AccountLessons();

		if (dto.getId() > 0) {
			account.setId(dto.getId());
		}

		account.setUserId(dto.getUserId());

		return account;

	}

// ------------------------------------------><----------------------------------------------------------	

	@Override
	public AccountDTO toDTO(AccountLessons ent) {
		AccountDTO accountDTO = new AccountDTO(
				ent.getId(),
				ent.getUserId(), 
//				editionBus.getbyAccountId(ent.getId()).stream().map(edition -> converter.toDTO(edition)).collect(Collectors.toList()));
				editionBus.getbyAccountId(ent.getId()).stream().collect(Collectors.toList()));

		return accountDTO;
		
	}

}
