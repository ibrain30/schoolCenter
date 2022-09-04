/**
 * MENU CLASS
 * this class is used  to manage the sub menu
 * we call all functions define in Student Manager
 * @author Baye Talla NDIAYE
 */
package services;

import dbFile.DataFile;
import model.Student;
import utils.Util;

import java.io.IOException;
import java.util.List;

public class Menu {
     // read data in the file
     static List<Student> list = DataFile.readData();

     // Instance of StudentManager
     static StudentManager studentManager = new StudentManager(list);

     /* Function for the option Teacher */
     public static void MenuTeacher(){
        while(true) {
            System.out.println("===== Menu Professeur ======");
            System.out.println("-.1 Create Student \n" +
                    "-.2 List Students \n" +
                    "-.3 Update Student \n" + "-.4 Delete Student \n" +
                    "-.5 Quit and Save ");
            int response = Util.enterInt("Please take your choice : ");

            switch (response) {
                case 1:
                    /* create student */
                    int nbre = Util.enterInt("How many student want you create : ");
                    studentManager.createStudent(nbre);
                    break;
                case 2:
                    /* Display all student */
                    studentManager.listStudents();
                    break;
                case 3:
                    /* to modify student */
                    studentManager.updateStudent();
                    break;
                case 4:
                    /* to delete student */
                    studentManager.deleteStudent();
                    break;
                case 5:
                    try {
                        /* InsertData is a function to write the tempo ( the list of students) in the File */
                        DataFile.insertData(list);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return;
                default:
                    System.out.println("Choice not available");
                    break;
            }

        }
    }

    /* Menu for the option student */
    public static void MenuStudent(){
        System.out.println("===== Menu Student ======");
        System.out.println("-.1 Create Email  \n" +
                           "-.2 Buy Formations \n" +
                           "-.3 Quit ");
        int response = Util.enterInt("Please take your choice : ");

        switch (response){
            case 1:
                /* to generate mail and password for student */
                studentManager.generateMailPassword();
                break;
            case 2:
                /* to buy formation */
                studentManager.buyFormation();
                break;
            case 3:
                /* quit */
                break;
            default:
                System.out.println("Choice not available");
                break;
        }

    }
}
