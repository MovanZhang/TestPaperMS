package bean;

public class Question {
	private String queId;
	private String queCate;
	private String queSubject;
	private String queBody;
	private String queAns;
	private Float queDiff;
	private Integer queCon;
	public String getQueId() {
		return queId;
	}
	public void setQueId(String queId) {
		this.queId = queId;
	}
	public String getQueCate() {
		return queCate;
	}
	public void setQueCate(String queCate) {
		this.queCate = queCate;
	}
	public String getQueSubject() {
		return queSubject;
	}
	public void setQueSubject(String queSubject) {
		this.queSubject = queSubject;
	}
	public String getQueBody() {
		return queBody;
	}
	public void setQueBody(String queBody) {
		this.queBody = queBody;
	}
	public String getQueAns() {
		return queAns;
	}
	public void setQueAns(String queAns) {
		this.queAns = queAns;
	}
	public Float getQueDiff() {
		return queDiff;
	}
	public void setQueDiff(Float queDiff) {
		this.queDiff = queDiff;
	}
	public Integer getQueCon() {
		return queCon;
	}
	public void setQueCon(Integer queCon) {
		this.queCon = queCon;
	}
	public Question(String queId, String queCate, String queSubject,
			String queBody, String queAns, Float queDiff, Integer queCon) {
		super();
		this.queId = queId;
		this.queCate = queCate;
		this.queSubject = queSubject;
		this.queBody = queBody;
		this.queAns = queAns;
		this.queDiff = queDiff;
		this.queCon = queCon;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
