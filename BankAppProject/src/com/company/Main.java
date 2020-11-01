package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SalariedEmployee salariedEmployee=new SalariedEmployee("John","Smith","111-11-1111",800.000);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
        Managers managers = new Managers("Bob", "Lewis", "444-44-4444", 5000, .04, 300);

        System.out.println("Employees processed individually:\n");

        System.out.printf("%s\n%s: $%,.2f\n\n", salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%s\n%s: $%,.2f\n\n", hourlyEmployee, "earned", hourlyEmployee.earnings());
        System.out.printf("%s\n%s: $%,.2f\n\n", commissionEmployee, "earned", commissionEmployee.earnings());
        System.out.printf("%s\n%s: $%,.2f\n\n", managers, "earned", managers.earnings());


        Employee[] employees = new Employee[4];

        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = managers;

        System.out.println("Comisoion employes are :");


        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);

            if (currentEmployee instanceof Managers) {

                Managers employee = (Managers) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf("new base salary with 10%% increase is: $%,.2f\n", employee.getBaseSalary());
            }

            System.out.printf("earned $%,.2f\n\n", currentEmployee.earnings());
        }


        for (int j = 0; j < employees.length; j++)
            System.out.printf("Employee %d is a %s\n", j,
                    employees[j].getClass());

        // write your code here
        Client[] clients = new Client[]{new Client("ab123", "123", "Ben", "X", 150.0D, "Lek"), new Client("cb234", "234", "Agron", "Y", 100.0D, "Lek")};
        Bank bank = new Bank("BKT", clients);
        Scanner in = new Scanner(System.in);
        System.out.println("Put your account Number");
        String accountNo = in.next();
        System.out.println("Insert the code");
        String pin = in.next();
        int loggedInClientPosition = bank.login(accountNo, pin);

        while (true) {
            while (true) {
                while (loggedInClientPosition < 0) {
                    System.out.println("Your account no or code might be wrong");
                }

                System.out.println("Please select one of the options ");
                System.out.println("1. Display all");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Deposit to another account");
                System.out.println("5. Log out");
                int option = in.nextInt();
                switch (option) {
                    case 1:
                        bank.display(loggedInClientPosition);
                        break;
                    case 2:
                        System.out.println("Give the amount you want to deposit :");

                        double amountToDeposit;
                        for (amountToDeposit = in.nextDouble(); amountToDeposit < 0.0D; amountToDeposit = in.nextDouble()) {
                            System.out.println("It must be an ammount not something else!");
                        }

                        bank.deposit(loggedInClientPosition, amountToDeposit);
                        bank.display(loggedInClientPosition);
                        break;
                    case 3:
                        System.out.println("Input the ammount you want to take:");
                        double amoutToWithdraw = in.nextDouble();
                        bank.withdraw(loggedInClientPosition, amoutToWithdraw);
                        bank.display(loggedInClientPosition);
                        break;
                    case 4:
                        System.out.println("Imput the account no you want to transfer:");
                        String accountNumberToDeposit = in.next();
                        System.out.println("Give the ammount you want to deposit:");
                        double amountToTransfer = in.nextDouble();
                        int clientPositionToTransfer = bank.checkAccountNumberOfClientToDeposit(loggedInClientPosition, accountNumberToDeposit);
                        if (clientPositionToTransfer >= 0) {
                            bank.transferToAnotherAccount(loggedInClientPosition, clientPositionToTransfer, amountToTransfer);
                            bank.display(loggedInClientPosition);
                            bank.display(clientPositionToTransfer);
                        } else {
                            System.out.println("This account no does not exist!");
                        }
                        break;
                    case 5:
                        System.exit(0);
                }
            }
        }

    }


}
