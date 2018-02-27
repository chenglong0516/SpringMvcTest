package Demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Demo.Model.Course;
import Demo.Service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static Logger log = LoggerFactory.getLogger(CourseController.class);
	
	private CourseService courseService;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	//请求拼接参数风格
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId, Model model){
		
		log.info("In viewCourse, courseId={}", courseId);
		Course course = courseService.getCourseById(courseId);
		model.addAttribute(course);
		return "course_overview";
	}
	
	//restful风格   /courses/view2/{courseId}
	@RequestMapping(value="/view2/{courseId}", method=RequestMethod.GET)
	public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model){
		
		System.out.println("In viewCourse2, courseId="+courseId);
		Course course = courseService.getCourseById(courseId);
		model.put("course", course);
		return "course_overview";
	}
	
	//传统风格
	@RequestMapping(value="/view3", method=RequestMethod.GET)
	public String viewCourse3(HttpServletRequest request){
		
		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		System.out.println("In viewCourse3, courseId="+courseId);
		Course course = courseService.getCourseById(courseId);
		request.setAttribute("course", course);
		return "course_overview";
	}
	
	//限制请求方法和请求参数
	@RequestMapping(value="admin", method=RequestMethod.GET, params="add")
	public String createCourse(){
		return "course_admin/edit";
	}
	
	//保持课程（练习请求参数绑定对象）
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String doSave(Course course){
		//打印对象属性
		System.out.println("ReflectionToStringBuilder"+ReflectionToStringBuilder.toString(course));
		//业务操作，例如数据库持久化
		course.setCourseId(123);
		//重定向
		return "redirect:view2/"+course.getCourseId();
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String showUploadPage(){
		return "course_admin/file";
	}
	
	//文件上传接口
	@RequestMapping(value="/doUpload", method=RequestMethod.POST)
	public String doUploadfile(@RequestParam("file") MultipartFile file) throws IOException{
		//C:\Users\chenglong\Downloads
		if(!file.isEmpty()){
			System.out.println("Process file "+file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("C:\\Users\\chenglong\\Downloads",System.currentTimeMillis()+file.getOriginalFilename()));
		}
		return "success";
	}
}
