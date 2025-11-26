import java.util.*;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        ContactService service = new ContactService();
        String path = "data/contacts.csv";

        while (true) {
            System.out.println("\n--- CHUONG TRINH QUAN LY DANH BA ---");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them moi");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Tim kiem");
            System.out.println("6. Doc tu file");
            System.out.println("7. Ghi vao file");
            System.out.println("8. Thoat");
            System.out.print("Chon: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": service.showContacts(); break;
                case "2": service.addContact(); break;
                case "3": service.updateContact(); break;
                case "4": service.deleteContact(); break;
                case "5": service.searchContact(); break;
                case "6":
                    System.out.print("Ghi de bo nho hien tai? (Y/N): ");
                    if (sc.nextLine().equalsIgnoreCase("Y")) {
                        try {
                            service.setList(FileUtils.readCSV(path));
                            System.out.println("Da load tu file.");
                        } catch (Exception e) { 
                            System.out.println("Loi doc file!"); 
                        }
                    }
                    break;
                case "7":
                    System.out.print("Ghi de file? (Y/N): ");
                    if (sc.nextLine().equalsIgnoreCase("Y")) {
                        try {
                            FileUtils.writeCSV(path, service.getList());
                            System.out.println("Da ghi file.");
                        } catch (Exception e) { 
                            System.out.println("Loi ghi file!"); 
                        }
                    }
                    break;
                case "8":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Sai lua chon!");
            }
        }
    }
}
