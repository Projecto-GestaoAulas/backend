package pt.upacademy.coreFinalProject.models.lessons;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import pt.upacademy.coreFinalProject.models.core.EntityRoot;

@Entity
@NamedQueries({ @NamedQuery(name = Edition.GET_ALL_EDITIONS, query = "SELECT e FROM Edition e"),
		@NamedQuery(name = Edition.GET_ALL_EDITIONS_IDS, query = "SELECT e.id FROM Edition e"),
		@NamedQuery(name = Edition.GET_ALL_EDITIONS_COUNT, query = "SELECT COUNT(e.id) FROM Edition e"),
		@NamedQuery(name = Edition.GET_EDITION_ACCOUNT_ID, query = "SELECT e FROM Edition e inner join e.accounts accounts WHERE accounts.id in :accountId"),
		@NamedQuery(name = Edition.GET_EDITION_IDS_BY_ACCOUNT_ID, query = "SELECT e.id FROM Edition e inner join e.accounts accounts WHERE accounts.id in :accountId")})


public class Edition extends EntityRoot {

	public static final String GET_ALL_EDITIONS = "getAllEditions";
	public static final String GET_ALL_EDITIONS_IDS = "getAllEditionsIds";
	public static final String GET_ALL_EDITIONS_COUNT = "getAllEditionsCount";
	public static final String GET_EDITION_ACCOUNT_ID = "getEditionsByAccountId";
	public static final String GET_EDITION_IDS_BY_ACCOUNT_ID = "getEditionsIdsByAccountId";

	private static final long serialVersionUID = 1L;

	private String name;
	private String type;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "Edition_Account", joinColumns = { @JoinColumn(name = "edition_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "account_id", referencedColumnName = "id") })
	private Collection<AccountLessons> accounts = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<AccountLessons> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<AccountLessons> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Edition [name=" + name + ", type=" + type + ", accounts=" + accounts + "]";
	}

}
