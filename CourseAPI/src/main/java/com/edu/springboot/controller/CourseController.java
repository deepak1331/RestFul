package com.edu.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboot.model.Course;
import com.edu.springboot.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	/*
	 * @RequestMapping(value = "/topics/{topicId}/courses", produces =
	 * MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET) public
	 * List<Course> getAllCourses(@PathVariable String topicId) {
	 * System.out.println("Get Course Controller called..."); return
	 * courseService.getAllCourse(topicId); }
	 */

	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Optional<Course> getCourseById(@PathVariable String courseId) {
		System.out.println("Get Course Controller called...");
		return courseService.getCourse(courseId);
	}

	@RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		System.out.println("Add Course Controller called...");
		courseService.addCourse(topicId, course);
	}

	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
	public void putCourse(@RequestBody Course course, @PathVariable String courseId) {
		System.out.println("Put/Update Course Controller called...");
		courseService.updateCourse(courseId, course);
	}

	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String courseId) {
		System.out.println("Delete Course Controller called...");
		courseService.deleteCourse(courseId);
	}

	@RequestMapping(value = "/topics/{topicId}/courses", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public MyResponse<Course> getAllCourses(@PathVariable String topicId) {
		System.out.println("Get Course Controller called...");
		List<Course> courseList = null;
		MyResponse<Course> response = null;
		try {
			courseList = courseService.getAllCourse(topicId);
		} catch (Exception e) {
			response = new MyResponse<Course>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), courseList);
		}
		if (courseList != null) {
			if (courseList.size() == 0)
				response = new MyResponse<Course>(HttpStatus.OK, "No matching records found for your request",
						courseList);
			else
				response = new MyResponse<Course>(HttpStatus.OK, "Successful", courseList);
		}

		return response;
	}

	/*
	 * @RequestMapping(value = "/topics/{topicId}/courses", produces =
	 * MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	 * 
	 * @ResponseStatus(HttpStatus.CREATED)
	 * 
	 * @ResponseBody public ResponseEntity<List<Course>> getAllCourses(@PathVariable
	 * String topicId){ System.out.println("Get Course Controller called...");
	 * List<Course> courseList = null; try { courseList =
	 * courseService.getAllCourse(topicId); }catch(Exception e) { return new
	 * ResponseEntity<List<Course>>(courseList, HttpStatus.BAD_REQUEST); } return
	 * new ResponseEntity<List<Course>>(courseList, HttpStatus.OK); }
	 */

	/*
	 * @PreAuthorize("#oauth2.hasScope('ENTERPRISE') or #oauth2.hasScope('PREMIUM') or #oauth2.hasScope('FREE') or hasRole('ROLE_ADMIN')"
	 * )
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value = "/getSameTestDetails",
	 * produces = MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @ResponseStatus(HttpStatus.CREATED)
	 * 
	 * @ResponseBody public ResponseEntity<ArrayList<TestCaseDetails>>
	 * getSameTestsDetails(@RequestBody final UserModel userModel) throws Exception
	 * {
	 * 
	 * ArrayList<TestCaseDetails> executionSameTestDetails = null;
	 * 
	 * try { logger.info("/getSameTestDetails"); logger.info(userModel.toString());
	 * UsersEntity usersEntity = usersService.getUser(userModel); DateFormat format
	 * = new SimpleDateFormat("dd-MM-yyyy"); Date startDate =
	 * format.parse(userModel.getStartDate()); Date endDate =
	 * format.parse(userModel.getEndDate()); executionSameTestDetails =
	 * dashBoardService.getSameTestsCompletedByStartAndEndDate(startDate, endDate,
	 * usersEntity); } catch (Exception e) { return new
	 * ResponseEntity<ArrayList<TestCaseDetails>>(executionSameTestDetails,
	 * HttpStatus.BAD_REQUEST); } return new
	 * ResponseEntity<ArrayList<TestCaseDetails>>(executionSameTestDetails,
	 * HttpStatus.OK); }
	 */
}
