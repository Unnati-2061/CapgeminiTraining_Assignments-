package com.atm.mode;
import com.atm.transaction.*;
import com.atm.model.Account;

public interface AtmMode {
	public void showMenu(Account acc);
	public String getLabel();
	public TransactionOption[] getOptions();
	public boolean validateAccount();
}
