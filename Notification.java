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

	public String toString() {
		return this.title;
	}

}