package com.company;

public class Bank { private String name;
    private Client[] clients;
    private static final double INTEREST = 1.2D;

    public Bank(String name, Client[] clients) {
        this.name = name;
        this.clients = clients;
    }

    public int login(String accountNumber, String pin) {
        int position = -1;

        for(int i = 0; i < this.clients.length; ++i) {
            if (this.clients[i].getAccountNumber().equals(accountNumber) && this.clients[i].getPin().equals(pin)) {
                position = i;
            }
        }

        return position;
    }

    public void display(int loggedInClientPosition) {
        double amountAfterInterest = this.clients[loggedInClientPosition].getAmount() + this.clients[loggedInClientPosition].getAmount() * 0.012D;
        System.out.println(this.clients[loggedInClientPosition].getAccountNumber() + " " + this.clients[loggedInClientPosition].getName() + " " + this.clients[loggedInClientPosition].getSurname() + " " + this.clients[loggedInClientPosition].getAmount() + " " + amountAfterInterest + this.clients[loggedInClientPosition].getCurrency() + " ");
    }

    public void deposit(int loggedInClientPosition, double amountToDeposit) {
        double initialAmount = this.clients[loggedInClientPosition].getAmount();
        double amountAfterDeposit = initialAmount + amountToDeposit;
        this.clients[loggedInClientPosition].setAmount(amountAfterDeposit);
        System.out.println("Your money has been successfuly deposited!");
    }

    public void withdraw(int loggedInClientPosition, double amountToWithdraw) {
        double initialAmount = this.clients[loggedInClientPosition].getAmount();
        if (amountToWithdraw > initialAmount) {
            System.out.println("Action failed");
        } else {
            double amountAfterWithdraw = initialAmount - amountToWithdraw;
            this.clients[loggedInClientPosition].setAmount(amountAfterWithdraw);
            System.out.println("Withdraw was successful!");
        }

    }

    public void transferToAnotherAccount(int loggedInClientPosition, int clientPositionToDeposit, double amountToTransfer) {
        double initialAmountOfFirstClient = this.clients[loggedInClientPosition].getAmount();
        if (amountToTransfer > initialAmountOfFirstClient) {
            System.out.println("Not enoungh money in your account!");
        } else {
            double amountOfFirstClientAfterTransfer = initialAmountOfFirstClient - amountToTransfer;
            double amountOfSecondClientAfterDeposit = this.clients[clientPositionToDeposit].getAmount() + amountToTransfer;
            this.clients[clientPositionToDeposit].setAmount(amountOfSecondClientAfterDeposit);
            this.clients[loggedInClientPosition].setAmount(amountOfFirstClientAfterTransfer);
            System.out.println("Transfer was succesful!");
        }

    }

    public int checkAccountNumberOfClientToDeposit(int loggedInClientPosition, String accountNumber) {
        int position = -1;
        if (this.clients[loggedInClientPosition].getAccountNumber() == accountNumber) {
            System.out.println("You can't transfer in your acccount!");
        } else {
            for(int i = 0; i < this.clients.length; ++i) {
                if (this.clients[i].getAccountNumber().equals(accountNumber)) {
                    position = i;
                }
            }
        }

        return position;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client[] getClients() {
        return this.clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }
}


