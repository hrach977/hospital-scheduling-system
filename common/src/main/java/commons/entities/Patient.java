package commons.entities;

import commons.validator.anotations.NoWhitespace;
import commons.validator.anotations.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "patients")
//@PasswordMatches
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @NoWhitespace
    private String username;
    @NotEmpty
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty
    @NotNull
    @NoWhitespace
    private String password;
    @Transient
    private String passwordConfirmation;
    @ValidEmail
    @NotEmpty
    @NotNull
    private String email;

    @Column(name = "user_type", columnDefinition = "varchar(32) default 'USER'")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Patient() {}

    public Patient(@NotNull @NotEmpty String username, @NotEmpty @NotNull String firstName,
                   @NotEmpty @NotNull String lastName, @NotEmpty @NotNull String password, String passwordConfirmation,
                   @NotEmpty @NotNull String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.email = email;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}




