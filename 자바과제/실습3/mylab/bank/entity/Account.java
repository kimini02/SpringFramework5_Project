package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

/**
 * 모든 계좌의 기본이 되는 추상 클래스
 */
public abstract class Account {
    private String accountNumber;  // 계좌번호
    private String ownerName;      // 소유자 이름
    protected double balance;      // 잔액

    // 생성자
    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * 입금
     */
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
    }

    /**
     * 출금
     */
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + balance + "원");
        }
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public abstract String toString();
}
