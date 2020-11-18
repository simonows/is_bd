package com.servletcrud.customer;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @OneToOne(optional=true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    public UserData data;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setName(String uname1)
    {
        name = uname1;
    }
    public String getName()
    {
        return name;
    }
    public void setPassword(String password2)
    {
        password = password2;
    }
    public String getPassword()
    {
        return password;
    }

    @Override
    public String toString() {
        return "com.servletcrud.customer.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}

