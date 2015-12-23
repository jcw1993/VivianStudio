package nju.swi.controller;

public class StudentController extends BaseController {

	public void grades() {
		renderJsp("student/grades");
	}
	
	public void uploadPage() {
		renderJsp("student/upload");
	}
	
	public void download() {
		renderJsp("student/download");
	}
	
	public void profile() {
		renderJsp("student/profile");
	}
}
