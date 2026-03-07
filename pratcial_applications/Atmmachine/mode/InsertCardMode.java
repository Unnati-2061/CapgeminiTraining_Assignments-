package com.atm.mode;
import java.util.Scanner;
import com.atm.transaction.*;
import com.atm.model.Account;

public class InsertCardMode implements AtmMode {
	@Override
	public void showMenu(Account acc) {
		this.acc = acc;
		
		boolean success = validateAccount();
		if (!success) {
			System.out.println("Invalid Pin!");
			return;
		}

		System.out.println("Account validated succesfully!");
		System.out.println("LOGGED IN...\n");
		
		int choice;
		do {
			System.out.println("========== OPTIONS ==========");

			for(int i=0; i<options.length; i++) {
				System.out.println("[" + (i+1) + "] " + options[i].getLabel());
			}
			
			System.out.println("[" + (options.length+1) + "] Back");
			System.out.println("=============================\n");
			
			System.out.print("Enter your choice (e.g 1 or 2): ");
			choice = sc.nextInt();
			
			if (choice <= 0 || choice > options.length+1) {
				System.out.println("Please enter a valid choice!");
				continue;
			}

			if (choice == options.length+1) return;

			options[choice-1].execute(this.acc);
			System.out.print("Press enter to go BACK!");
			sc.nextLine();
			sc.nextLine();

			System.out.println("");
		} while(choice != options.length+1);
	}
	
	@Override
	public String getLabel() { return "Insert Card"; }
	
	@Override
	public TransactionOption[] getOptions() { return options; }
	
	@Override
	public boolean validateAccount() {
		String pin;
		do {
			System.out.print("Enter your account pin(4-digits): ");
			pin = sc.next();

			if (pin.length() != 4) {
				System.out.println("Please enter a valid pin! (It should be of 4 digits).");
			}
		} while (pin.length() != 4);

		return acc.isValidPin(pin);
	}

	private Account acc = null;
	private Scanner sc = new Scanner(System.in);

	private TransactionOption []options = {
		new DepositOption(),
		new WithdrawOption(),
		new QuickWithdrawOption(),
		new CheckBalanceOption(),
		new ChangePinOption()
	};
}
