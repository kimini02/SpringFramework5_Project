package mylab.bank.entity;

/**
 * 저축 계좌 클래스
 */
public class SavingsAccount extends Account {
    private double interestRate;  // 이자율 (%)

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * 이자 적용
     */
    public double applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + balance + "원");
        return interest;
    }

    @Override
    public String toString() {
        return "계좌번호: " + getAccountNumber() + ", 소유자: " + getOwnerName() + 
               ", 잔액: " + getBalance() + "원, 이자율: " + interestRate + "%";
    }
}
