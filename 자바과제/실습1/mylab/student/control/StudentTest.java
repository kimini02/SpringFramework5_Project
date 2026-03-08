package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;


public class StudentTest {
    
    public static void main(String[] args) {
        // 학생 객체 생성
        Student student = new Student("20230001", "김민수", "컴퓨터공학", 3);
        
        // 학생 정보 출력
        System.out.println(student);
        
        // 학년 변경 테스트 (유효하지 않은 학년)
        System.out.println("5학년으로 변경");
        try {
            student.setGrade(5);
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }
}
