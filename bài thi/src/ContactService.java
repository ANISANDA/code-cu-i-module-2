import java.util.*;

public class ContactService {
    private List<Contact> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{9,11}");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
    }

    public List<Contact> getList() {
        return list;
    }

    public void showContacts() {
        if (list.isEmpty()) {
            System.out.println("Danh ba trong.");
            return;
        }

        int count = 0;
        for (Contact c : list) {
            System.out.println(c);
            count++;
            if (count % 5 == 0) {
                System.out.print("-- Nhan Enter de xem tiep --");
                sc.nextLine();
            }
        }
        System.out.println("\n--- Het danh sach ---");
    }

    public void addContact() {
        System.out.print("So dien thoai: ");
        String phone = sc.nextLine();
        if (!isValidPhone(phone)) {
            System.out.println("So dien thoai khong hop le!");
            return;
        }

        System.out.print("Nhom: ");
        String group = sc.nextLine();
        System.out.print("Ho ten: ");
        String name = sc.nextLine();
        System.out.print("Gioi tinh: ");
        String gender = sc.nextLine();
        System.out.print("Dia chi: ");
        String address = sc.nextLine();
        System.out.print("Ngay sinh: ");
        String dob = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        if (!isValidEmail(email)) {
            System.out.println("Email khong hop le!");
            return;
        }

        list.add(new Contact(phone, group, name, gender, address, dob, email));
        System.out.println("Them thanh cong");
    }

    public void updateContact() {
        System.out.print("Nhap so dien thoai can sua: ");
        String phone = sc.nextLine();

        Contact found = list.stream()
                .filter(c -> c.getPhone().equals(phone))
                .findFirst().orElse(null);

        if (found == null) {
            System.out.println("Khong tim thay!");
            return;
        }

        System.out.print("Nhom moi: ");
        found.setGroup(sc.nextLine());
        System.out.print("Ten moi: ");
        found.setName(sc.nextLine());
        System.out.print("Gioi tinh moi: ");
        found.setGender(sc.nextLine());
        System.out.print("Dia chi moi: ");
        found.setAddress(sc.nextLine());
        System.out.print("Ngay sinh moi: ");
        found.setDob(sc.nextLine());
        System.out.print("Email moi: ");
        String email = sc.nextLine();

        if (!isValidEmail(email)) {
            System.out.println("Email khong hop le!");
            return;
        }
        found.setEmail(email);

        System.out.println("Cap nhat thanh cong");
    }

    public void deleteContact() {
        System.out.print("Nhap so dien thoai can xoa: ");
        String phone = sc.nextLine();

        Contact found = list.stream()
                .filter(c -> c.getPhone().equals(phone))
                .findFirst().orElse(null);

        if (found == null) {
            System.out.println("Khong tim thay!");
            return;
        }

        System.out.print("Ban chac chan muon xoa? (Y/N): ");
        if (sc.nextLine().equalsIgnoreCase("Y")) {
            list.remove(found);
            System.out.println("Da xoa");
        }
    }

    public void searchContact() {
        System.out.print("Nhap tu khoa: ");
        String key = sc.nextLine().toLowerCase();

        list.stream()
            .filter(c -> c.getPhone().contains(key) || c.toString().toLowerCase().contains(key))
            .forEach(System.out::println);
    }

    public void setList(List<Contact> newList) {
        list = newList;
    }
}
