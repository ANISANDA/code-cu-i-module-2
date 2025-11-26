public class Contact {
    private String phone;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String dob;
    private String email;

    public Contact(String phone, String group, String name, String gender,
                   String address, String dob, String email) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.email = email;
    }

    public String getPhone() { return phone; }
    public void setGroup(String group) { this.group = group; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAddress(String address) { this.address = address; }
    public void setDob(String dob) { this.dob = dob; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("%-12s | %-10s | %-20s | %-6s | %-15s | %-12s | %s",
                phone, group, name, gender, address, dob, email);
    }

    public String toCSV() {
        return String.join(",",
            phone, group, name, gender, address, dob, email
        );
    }

    public static Contact fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length != 7) return null;
        return new Contact(parts[0], parts[1], parts[2], parts[3],
                           parts[4], parts[5], parts[6]);
    }
}
