package Demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Demo.Model.Chapter;
import Demo.Model.Course;

@Service
public class CourseServiceImpl implements CourseService{

	@Override
	public Course getCourseById(Integer courseId) {
		Course course = new Course();
		course.setCourseId(courseId);
		course.setTitle("深入浅出Java多线程");
		course.setImgPath("resource/imgs/course-img.jpg");
		course.setLearningNum(12345);
		course.setLevel(2);
		course.setLevelDesc("中级");
		course.setDuration(7200l);
		course.setDescr("多线程是日常开发中常用知识。。。");
		
		List<Chapter> chapterList = new ArrayList<Chapter>();
		
		warpChapterList(courseId, chapterList);
		
		course.setChapterList(chapterList);
		
		return course;
	}

	private void warpChapterList(Integer courseId, List<Chapter> chapterList) {
		Chapter chapter = new Chapter();
		chapter.setId(1);
		chapter.setCourseId(courseId);
		chapter.setOrder(1);
		chapter.setTitle("第一章 背景知识");
		chapter.setDescr("介绍背景概念");
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(2);
		chapter.setCourseId(courseId);
		chapter.setOrder(2);
		chapter.setTitle("第二章 java线程初体验");
		chapter.setDescr("如何创建启动停止线程");
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(3);
		chapter.setCourseId(courseId);
		chapter.setOrder(3);
		chapter.setTitle("第三章 线程其他知识");
		chapter.setDescr("其他知识。。。");
		chapterList.add(chapter);
		
	}

}
