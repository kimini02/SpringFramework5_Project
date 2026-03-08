package mylab.student.exception;

/**
 * 학년이 유효하지 않을 때 발생하는 예외 클래스
 */
public class InvalidGradeException extends Exception {
    
    public InvalidGradeException(String message) {
        super(message);
    }
}
