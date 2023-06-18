package main;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;

	public class BankingSystem {
	    private Map<String, Double> accounts;
	    
	    public BankingSystem() {
	        accounts = new HashMap<>();
	    }
	    
	    public void createAccount(String accountNumber, double initialBalance) {
	        if (accounts.containsKey(accountNumber)) {
	            System.out.println("Account already exists.");
	        } else {
	            accounts.put(accountNumber, initialBalance);
	            System.out.println("Account created successfully.");
	        }
	    }
	    
	    public void deposit(String accountNumber, double amount) {
	        if (accounts.containsKey(accountNumber)) {
	            double balance = accounts.get(accountNumber);
	            balance += amount;
	            accounts.put(accountNumber, balance);
	            System.out.println("Deposit successful. New balance: " + balance);
	        } else {
	            System.out.println("Account not found.");
	        }
	    }
	    
	    public void withdraw(String accountNumber, double amount) {
	        if (accounts.containsKey(accountNumber)) {
	            double balance = accounts.get(accountNumber);
	            if (balance >= amount) {
	                balance -= amount;
	                accounts.put(accountNumber, balance);
	                System.out.println("Withdrawal successful. New balance: " + balance);
	            } else {
	                System.out.println("Insufficient balance.");
	            }
	        } else {
	            System.out.println("Account not found.");
	        }
	    }
	    
	    public void checkBalance(String accountNumber) {
	        if (accounts.containsKey(accountNumber)) {
	            double balance = accounts.get(accountNumber);
	            System.out.println("Account balance: " + balance);
	        } else {
	            System.out.println("Account not found.");
	        }
	    }
	    
	    public static void main(String[] args) {
	        BankingSystem bankingSystem = new BankingSystem();
	        Scanner scanner = new Scanner(System.in);
	        
	        boolean exit = false;
	        while (!exit) {
	            System.out.println("1. Create Account");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Check Balance");
	            System.out.println("5. Exit");
	            System.out.println("Choose an option:");
	            
	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("Enter account number:");
	                    String accountNumber = scanner.next();
	                    System.out.println("Enter initial balance:");
	                    double initialBalance = scanner.nextDouble();
	                    bankingSystem.createAccount(accountNumber, initialBalance);
	                    break;
	                case 2:
	                    System.out.println("Enter account number:");
	                    accountNumber = scanner.next();
	                    System.out.println("Enter deposit amount:");
	                    double depositAmount = scanner.nextDouble();
	                    bankingSystem.deposit(accountNumber, depositAmount);
	                    break;
	                case 3:
	                    System.out.println("Enter account number:");
	                    accountNumber = scanner.next();
	                    System.out.println("Enter withdrawal amount:");
	                    double withdrawalAmount = scanner.nextDouble();
	                    bankingSystem.withdraw(accountNumber, withdrawalAmount);
	                    break;
	                case 4:
	                    System.out.println("Enter account number:");
	                    accountNumber = scanner.next();
	                    bankingSystem.checkBalance(accountNumber);
	                    break;
	                case 5:
	                    exit = true;
	                    break;
	                default:
	                    System.out.println("Invalid option.");
	            }
	        }
	        
	        scanner.close();
	    }
	}


