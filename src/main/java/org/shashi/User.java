package org.shashi;

import javax.persistence.*;

@Entity
@Table    // This use to create class name table,
          // You do not to create the class name table then use @Table(name= "Another-Table-Name")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String gender;
    @Column
    private String city;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getGender() {
        return gender;
    }
    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setCity(String city) {
        this.city = city;
    }



    public void setGender(String gender) {
        this.gender = gender;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public void setName(String name) {
        this.name = name;
    }
}
