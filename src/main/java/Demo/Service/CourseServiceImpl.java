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
		course.setTitle("����ǳ��Java���߳�");
		course.setImgPath("resource/imgs/course-img.jpg");
		course.setLearningNum(12345);
		course.setLevel(2);
		course.setLevelDesc("�м�");
		course.setDuration(7200l);
		course.setDescr("���߳����ճ������г���֪ʶ������");
		
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
		chapter.setTitle("��һ�� ����֪ʶ");
		chapter.setDescr("���ܱ�������");
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(2);
		chapter.setCourseId(courseId);
		chapter.setOrder(2);
		chapter.setTitle("�ڶ��� java�̳߳�����");
		chapter.setDescr("��δ�������ֹͣ�߳�");
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(3);
		chapter.setCourseId(courseId);
		chapter.setOrder(3);
		chapter.setTitle("������ �߳�����֪ʶ");
		chapter.setDescr("����֪ʶ������");
		chapterList.add(chapter);
		
	}

}
