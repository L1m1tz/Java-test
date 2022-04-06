package com.andrew.demo;

import java.util.Objects;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;

@Entity
class User {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String contactNumber;


    User() {}

    User(String firstName, String lastName, String contactNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getContactNumber(){
        return this.contactNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id) && Objects.equals(this.firstName, user.firstName)
                && Objects.equals(this.lastName, user.lastName)
                && Objects.equals(this.contactNumber, user.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.contactNumber) ;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName
                + '\'' + this.contactNumber + '}';
    }
}