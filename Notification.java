public class Notification {
	private String title;
	private boolean isImportant;
	private DateTime timeCreated;
	private String content;

	public Notification(String title, boolean isImportant, DateTime timeCreated, String content) {
		this.title = title;
		this.isImportant = isImportant;
		this.timeCreated = timeCreated;
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isIsImportant() {
		return this.isImportant;
	}

	public boolean getIsImportant() {
		return this.isImportant;
	}

	public void setIsImportant(boolean isImportant) {
		this.isImportant = isImportant;
	}

	public DateTime getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(DateTime timeCreated) {
		this.timeCreated = timeCreated;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
		return this.title;
	}

}