/**
 * Account class .
 * The class represent object Account.
 * @author Baye Talla NDIAYE
 */
package model;

import java.io.Serializable;
public class Account implements Serializable {
    private String email;
    private String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
