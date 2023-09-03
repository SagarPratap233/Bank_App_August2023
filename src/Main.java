public class Main {
    public static void main(String[] args) {
        HDFCAccount SagarAccount = new HDFCAccount("Sagar", "Sagar123", 2000);
        System.out.println(SagarAccount); //prints the attributes

        //fetch balance
        System.out.println(SagarAccount.fetchBalance("random")); //wrong password
        System.out.println(SagarAccount.fetchBalance("Sagar123")); //right password


        //add money
        System.out.println(SagarAccount.addMoney(10000));

        //withdraw
        System.out.println(SagarAccount.withdrawMoney(2000000, "Sagar123"));
        System.out.println(SagarAccount.withdrawMoney(10000, "Sagar123"));
        System.out.println(SagarAccount.withdrawMoney(10000, "random"));


        //change password
        System.out.println(SagarAccount.changePassword("random", "Pratap123"));
        System.out.println(SagarAccount.changePassword("Sagar123", "Pratap123"));
        System.out.println(SagarAccount.fetchBalance("Pratap123"));

        //interest
        System.out.println("Interest for 5 years on current balance: "+ SagarAccount.calculateInterest(5));

    }
}


