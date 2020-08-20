package telran.ashkelon2020.student.controller;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.student.dto.*;
import telran.ashkelon2020.student.service.MessagingService;
import telran.ashkelon2020.student.service.StudentService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	List <MessagingService> messagingServices;

	@PostMapping("/student")
	public boolean addStudent(@RequestBody StudentDto studentDto) {
		return studentService.addStudent(studentDto);
	}

	@GetMapping("/student/{id}")
	public StudentResponseDto findStudent(@PathVariable Integer id) {
		return studentService.findStudent(id);

	}

	@DeleteMapping("/student/{id}")
	public StudentResponseDto deleteStudent(@PathVariable Integer id) {
		return studentService.deleteStudent(id);

	}

	@PutMapping("/student/{id}")
	public StudentDto updateStudent(@PathVariable Integer id, @RequestBody StudentUpdateDto studentUpdateDto) {
		return studentService.updateStudent(id, studentUpdateDto);

	}

	@PutMapping("/score/student/{id}")
	public boolean addScore(@PathVariable Integer id, @RequestBody ScoreDto scoreDto) {
		return studentService.addScore(id, scoreDto);

	}
	@PostMapping("/student/message/{message}")
	public List<MessageDto> sendMessageS (@PathVariable String message) {

		return messagingServices.stream().map(s->s.sendMessage(message))
				.collect(Collectors.toList());
	}

}
