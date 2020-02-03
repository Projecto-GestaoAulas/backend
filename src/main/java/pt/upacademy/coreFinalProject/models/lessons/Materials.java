package pt.upacademy.coreFinalProject.models.lessons;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import pt.upacademy.coreFinalProject.models.core.EntityRoot;

@Entity
@NamedQueries({ @NamedQuery(name = Materials.GET_ALL_MATERIALS, query = "SELECT m FROM Materials m"),
	@NamedQuery(name = Materials.GET_ALL_MATERIALS_IDS, query = "SELECT m.id FROM Materials m"),
	@NamedQuery(name = Materials.GET_MATERIALS_BY_LESSON_ID, query = "SELECT m FROM Materials m inner join m.lessons lessons WHERE lessons.id in :lessonId")
})

public class Materials extends EntityRoot {

	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_MATERIALS = "getAllMaterials";
	public static final String GET_ALL_MATERIALS_IDS = "getAllMaterialsIds";
	public static final String GET_MATERIALS_BY_LESSON_ID = "getMaterialsByLessonsIds";


	private String title;
	private String type;
	private String url;
	
	@ManyToMany(mappedBy = "materials", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Collection<Lesson> lessons = new HashSet<>();

	public Collection<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Collection<Lesson> lessons) {
		this.lessons = lessons;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Materials [title=" + title + ", type=" + type + ", url=" + url + ", lessons=" + lessons + "]";
	}
	
	
}
