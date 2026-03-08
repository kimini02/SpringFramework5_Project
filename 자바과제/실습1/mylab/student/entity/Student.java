package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

/**
 * 학생 정보를 담는 클래스 (캡슐화 적용)
 */
public class Student {
    // 모든 필드는 private으로 선언
    private String studentId;  // 학번
    private String name;       // 이름
    private String major;      // 전공
    private int grade;         // 학년

    // 기본 생성자
    public Student() {
    }

    // 모든 필드를 초기화하는 생성자
    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        try {
            setGrade(grade);
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
            this.grade = 1; // 기본값 설정
        }
    }

    // Getter 메서드들
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGrade() {
        return grade;
    }

    // Setter 메서드들
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 학년 설정 메서드
     * 학년은 1~4 사이여야 하며, 범위를 벗어나면 예외 발생
     */
    public void setGrade(int grade) throws InvalidGradeException {
        if (grade < 1 || grade > 4) {
            throw new InvalidGradeException("학년은 1~4 사이여야 합니다.");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " / " + major + " / " + grade + "학년";
    }
}
