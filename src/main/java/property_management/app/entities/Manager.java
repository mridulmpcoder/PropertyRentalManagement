package property_management.app.entities;

import org.springframework.web.multipart.MultipartFile;

public class Manager {

	private String experience;
	private MultipartFile resume;

	public Manager() {
		super();
	}

	public Manager(String experience, MultipartFile resume) {
		super();
		this.experience = experience;
		this.resume = resume;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public MultipartFile getResume() {
		return resume;
	}

	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}

}
