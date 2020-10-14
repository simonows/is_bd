package com.servletcrud.service;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "user_data")
public class UserData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_t")
    private String name;
    @Column(name = "sername_t")
    private String sername;
    @Column(name = "patr_t")
    private String patronymic;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "rege")
    private Date rege;

    @OneToOne(mappedBy = "data")
    private User user;

    public UserData() {}

    public UserData(String name, String sername, String patronymic, Date birth, Date rege) {
        this.name = name;
        this.sername = sername;
        this.patronymic = patronymic;
        this.birth = birth;
        this.rege = rege;
    }

    public int getId() {
        return id;
    }

    public void setName(String uname)
    {
        name = uname;
    }
    public String getName()
    {
        return name;
    }
    public void setSername(String uname)
    {
        sername = uname;
    }
    public String getSername()
    {
        return sername;
    }
    public String getPatronymic()
    {
        return patronymic;
    }
    public void setPatronymic(String upatronymic)
    {
        patronymic = upatronymic;
    }
    public Date getBirth()
    {
        return birth;
    }
    public void setBirth(Date ubirth)
    {
        birth = ubirth;
    }
    public Date getRege()
    {
        return rege;
    }
    public void setRege(Date urege)
    {
        rege = urege;
    }

    @Override
    public String toString() {
        return "com.servletcrud.service.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birth='" + birth + '\'' +
                ", rege='" + rege + '\'' +
                '}';
    }
}

