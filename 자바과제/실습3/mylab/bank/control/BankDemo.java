package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.entity.CheckingAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

/**
 * 은행 시스템 테스트 클래스
 */
public class BankDemo {

    public static void main(String[] args) {
        Bank bank = new Bank();

        // 계좌 생성
        System.out.println("=== 계좌 생성 ===");
        SavingsAccount savings1 = bank.createSavingsAccount("홍길동", 10000, 3.0);
        CheckingAccount checking1 = bank.createCheckingAccount("김철수", 20000, 5000);
        SavingsAccount savings2 = bank.createSavingsAccount("이영희", 30000, 2.0);

        // 모든 계좌 출력
        bank.printAllAccounts();

        try {
            // 입금/출금 테스트
            System.out.println("\n=== 입금/출금 테스트 ===");
            bank.deposit("AC1000", 5000);
            bank.withdraw("AC1001", 3000);

            // 이자 적용 테스트
            System.out.println("\n=== 이자 적용 테스트 ===");
            savings1.applyInterest();

            // 계좌 이체 테스트
            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.transfer("AC1002", "AC1001", 5000);

            // 모든 계좌 출력
            bank.printAllAccounts();

            // 예외 테스트 - 출금 한도 초과
            System.out.println();
            bank.withdraw("AC1001", 10000);

        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 예외 테스트 - 출금 한도 초과 (체킹 계좌)
        try {
            bank.withdraw("AC1001", 10000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 예외 테스트 - 존재하지 않는 계좌
        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
