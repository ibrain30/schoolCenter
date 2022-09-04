/**
 * Student class .
 * The class represent object student.
 * @author Baye Talla NDIAYE
 */
package model;
import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String matricule;
    private String name;
    private String username;
    private String classe;
    private double monaie = 1000;
    private int age;

    private Account account;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public double getMonaie() {
        return monaie;
    }

    public void setMonaie(Double monaie) {
        this.monaie = monaie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
