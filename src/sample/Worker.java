package sample;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "worker")
public class Worker implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)	private long id;

    @Column(name = "name")
    String name;
    @Column(name = "age")
    String age;
    @Column(name = "adress")
    String adress;
    @Column(name = "income")
    String income;

    public Worker() {}

    public Worker(String name, String age, String adress, String income)
    {   this.name = name;
        this.age = age;
        this.adress = adress;
        this.income = name; }

    public String cannibalclown() {return getName() + getAge() + getAdress() + getAdress();}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
