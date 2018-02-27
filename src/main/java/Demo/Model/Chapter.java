package Demo.Model;

public class Chapter {
	private Integer id;
	private Integer CourseId;
	private Integer order;
	private String Title;
	private String Descr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCourseId() {
		return CourseId;
	}
	public void setCourseId(Integer courseId) {
		CourseId = courseId;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescr() {
		return Descr;
	}
	public void setDescr(String descr) {
		Descr = descr;
	}
	
	
}
