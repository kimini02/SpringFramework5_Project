package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

/**
 * 체킹 계좌 클래스
 */
public class CheckingAccount extends Account {
    private double withdrawalLimit;  // 출금 한도

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    /**
     * 출금 - 한도 초과 검사 포함
     */
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return "계좌번호: " + getAccountNumber() + ", 소유자: " + getOwnerName() + 
               ", 잔액: " + getBalance() + "원, 출금 한도: " + withdrawalLimit + "원";
    }
}
