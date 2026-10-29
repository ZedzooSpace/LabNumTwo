package classes;

public class Name {
    private String lastName;
    private String firstName;
    private String patronymic;

    public Name(String firstName) {
        this(null, firstName, null);
    }

    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public Name(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null && !lastName.trim().isEmpty()) sb.append(lastName).append(" ");
        if (firstName != null && !firstName.trim().isEmpty()) sb.append(firstName).append(" ");
        if (patronymic != null && !patronymic.trim().isEmpty()) sb.append(patronymic).append(" ");
        return sb.toString().trim();
    }
}