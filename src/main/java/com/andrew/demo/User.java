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
    private int contactNumber;

    User() {}

    User(String firstName, String lastName, int contactNumber) {

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

    public int getContactNumber(){
        return this.contactNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String _firstName) {
        this.firstName = _firstName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }
    public void setContactNumber(int _contactNumber) {
        this.contactNumber = _contactNumber;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (!(obj instanceof User))
            return false;
        User user = (User) obj;
        return Objects.equals(this.id, user.id) && Objects.equals(this.firstName, user.firstName)
                && Objects.equals(this.lastName, user.lastName)
                && Objects.equals(this.contactNumber, user.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.contactNumber) ;
    }

    @Override
    public String toString(/*User this*/) {
        return "User{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName
                + '\'' + this.contactNumber + '}';
    }
}