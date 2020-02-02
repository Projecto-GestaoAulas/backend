package pt.upacademy.coreFinalProject.repositories.lessons;


import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import pt.upacademy.coreFinalProject.models.lessons.Edition;
import pt.upacademy.coreFinalProject.repositories.core.EntityRepository;



@ApplicationScoped
public class EditionRepository extends EntityRepository <Edition>{

	@Override
	protected Class<Edition> getEntityClass() {
		return Edition.class;
	}

	@Override
	protected String getAllEntities() {
		return Edition.GET_ALL_EDITIONS;
	}

	protected String getAllEntitiesIds() {
		return Edition.GET_ALL_EDITIONS_IDS;
	}


	protected String getEntitiesCount() {
		return Edition.GET_ALL_EDITIONS_COUNT;
	}

	public Collection<Edition> getbyAccountId(long id) {
		return entityManager.createNamedQuery(Edition.GET_EDITION_ACCOUNT_ID, getEntityClass()).setParameter("accountId", id).getResultList();
		
	}

	public Collection<Long> getEditionIdsByAccountID(long id) {
		return entityManager.createNamedQuery(Edition.GET_EDITION_ACCOUNT_ID, getEntityClass()).setParameter("accountId", id).getResultList().stream().map(e -> e.getId()).collect(Collectors.toList());
	}



}
