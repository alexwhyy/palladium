public class Notification {
	private String title;
	private boolean isImportant;
	private Date time_created;
	private String content;

	public Notification(String title, boolean isImportant, Date time_created, String content) {
		this.title = title;
		this.isImportant = isImportant;
		this.time_created = time_created;
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

	public Date getTime_created() {
		return this.time_created;
	}

	public void setTime_created(Date time_created) {
		this.time_created = time_created;
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