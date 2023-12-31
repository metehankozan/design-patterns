package creational;

class Employee {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final int personalId;
    private final String phone;
    private final String address;
    private final String mail;

    public Employee(String firstName, String lastName, int age, int personalId) {
        this(firstName, lastName, age, personalId, "");
    }

    public Employee(String firstName, String lastName, int age, int personalId, String phone) {
        this(firstName, lastName, age, personalId, phone, "");
    }

    public Employee(String firstName, String lastName, int age, int personalId, String phone, String address) {
        this(firstName, lastName, age, personalId, phone, address, "");
    }

    public Employee(String firstName, String lastName, int age, int personalId, String phone, String address, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.personalId = personalId;
        this.phone = phone;
        this.address = address;
        this.mail = mail;
    }
}

class EmployeeWithBuilder {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final int personalId;
    private final String phone;
    private final String address;
    private final String mail;

    static class EmployeeBuilder {
        private final String firstName;
        private final String lastName;
        private final int age;
        private final int personalId;
        private String phone;
        private String address;
        private String mail;

        public EmployeeBuilder(String firstName, String lastName, int age, int personalId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.personalId = personalId;
        }

        public EmployeeBuilder setPhone(String phone){
            this.phone = phone;
            return this;
        }

        public EmployeeBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public EmployeeBuilder setMail(String mail){
            this.mail = mail;
            return this;
        }

        public EmployeeWithBuilder build() {
            return new EmployeeWithBuilder(this);
        }
    }

    private EmployeeWithBuilder(EmployeeBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.personalId = builder.personalId;
        this.phone = builder.phone;
        this.address = builder.address;
        this.mail = builder.mail;
    }

    @Override
    public String toString() {
        return "EmployeeWithBuilder{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", personalId=" + personalId +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}

public class Builder {
    public static void main(String[] args) {
        EmployeeWithBuilder employeeWithBuilder = new EmployeeWithBuilder
                .EmployeeBuilder("firstName", "lastName", 22, 32452)
                .setPhone("3352529")
                .setAddress("Turkey")
                .setMail("mail@mail.com")
                .build();

        System.out.println(employeeWithBuilder);
    }
}
