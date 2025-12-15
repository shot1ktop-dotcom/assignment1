import java.util.ArrayList;
import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        //Контакты поставшика
        System.out.println("Contact of supplier:");
        Supplier supplier = new Supplier("+7 705 893 9039", "Astana/2", "shot1ktop@gmail.com");
        System.out.print("Phone -> " + supplier.getPhone() + "; ");
        System.out.print("Email -> " + supplier.getEmail() + "; ");
        System.out.println("Address -> " + supplier.getAddress() + "; ");


        //Имена компаний
        Inventory inventory = new Inventory( false,  true);
        inventory.addCompany("Oracle");
        inventory.addCompany("Blue Yonder");
        inventory.addCompany("SAP");
        inventory.addCompany("Körber");
        inventory.addCompany("Infor");

        //Ищеть имя компоний
        Scanner user = new Scanner(System.in);
        System.out.print("Name of the company you want: ");
        String name_com = user.nextLine();
        System.out.print("New Version -> 1\nOld Version -> 0: ");
        int version = user.nextInt();
        if (inventory.getName_company().contains(name_com)) {
            if (version == 1) {
                System.out.println("New version " + inventory.isNew_version());
            } else {
                System.out.println("Old version " + inventory.isOld_version());
            }
        }

        Product product = new Product("AI_Control", 40000, 100);
        System.out.println("Name -> " + product.getName() + " ");
        System.out.println("Price -> " + product.getPrice() + " ");
        System.out.println("Pieces -> " + product.getPieces() + " ");

    }
}