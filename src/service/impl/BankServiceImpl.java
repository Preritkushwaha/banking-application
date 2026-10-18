package service.impl;

import domain.Account;
import repository.AccountRepository;
import service.BankService;

import java.util.UUID;

public class BankServiceImpl implements BankService {

    AccountRepository accountRepository = new AccountRepository();

    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId = UUID.randomUUID().toString();

        //CHANGE LATER --> 10 + 1 = AC000011 -> AC<06>
//        String accountNumber = UUID.randomUUID().toString();
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, accountType, (double) 0, customerId);
        //SAVE
        accountRepository.save(account);

        return accountNumber;

    }

    private String getAccountNumber() {
        int size = accountRepository.findAll().size() + 1;
        String acNumber = String.format("AC%06d", size);
        return acNumber;
    }
}
