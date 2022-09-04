/**
 * Student Manager Class
 * This class manager all the services offered by the application.
 * @author Baye Talla NDIAYE
 */
package services;

import model.Account;
import model.Student;
import utils.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentManager {

   /* we work with this variable (list) into the programme as a tempo
   *  Then save all the data in the file
   * */
   List<Student> list ;
    public StudentManager(List<Student> list) {
        this.list = list;
    }

    /**
      * CreateEtudiant function
      * This function allow to create student
      * @param nbreEtudiant is a number of student you want to create
      */
     public void createStudent(int nbreEtudiant) {
         /* tempo variable */
         Random random = new Random();

         for(int i = 0 ;i<nbreEtudiant;i++) {
             Student student = new Student();

             student.setId(i);
             student.setName(Util.enterString("Enter  name"));
             student.setUsername(Util.enterString("Enter  username"));
             student.setAge(Util.enterInt("Enter  age"));
             student.setClasse(Util.enterString("Enter  classe"));
             student.setMatricule("MATST"+student.getName()+random.nextInt(99));

             /* Add student in tempo variable : list */
             this.list.add(student);

         }
     }

    /**
     * This function is to list all students .
     * we recuperate the data from the file, and we affect this in the list
     */
    public  void listStudents() {
        //List<Student> list = DataFile.readData();
         System.out.println("All Etudiants :  ---------------");
         /* list all students */
         for (Student student : this.list){
             System.out.println("Register Number  : "+ student.getMatricule());
             System.out.println("Name : " + student.getName());
             System.out.println("Username : " + student.getUsername());
             System.out.println("Age : " + student.getAge());
             System.out.println("Class : " + student.getClasse());
             System.out.println("-------------------------------");
         }
     }

    /**
     * The function is to search student with the identified
     * is a list of students
     *
     */
     public  Student findStudent(){
         // Enter matriculate of student
         String matriculate = Util.enterString("Please enter your register number : format(MATSTname11)");

         for (Student student : this.list){
             // we compare the register number  to others register number  in the list of student
             if(student.getMatricule().equalsIgnoreCase(matriculate)){
                 return student;
             }
         }
         return null;
     }

    /**
     * This function is to display an Student
     * @param student
     */

    public  void oneStudent(Student student){

        System.out.println("Register Number : " + student.getMatricule() + " --- ");
        System.out.println("Name : " + student.getName());
        System.out.println("Username : " + student.getUsername());
        System.out.println("Age : " + student.getAge());
        System.out.println("Class : " + student.getClasse());
        System.out.println("-------------------------------");
    }

     /* This function is to update student */
    public  void updateStudent(){
        System.out.println("Update Student .....");
        /* find student with the function findStudent */
        Student student = findStudent();
        /* Update element */
        student.setName(Util.enterString("Enter your name : "));
        student.setUsername(Util.enterString("Enter your username"));
        student.setAge(Util.enterInt("Enter you age"));
        student.setClasse(Util.enterString("Enter your class"));

        /* update element in the list */
        this.list.set(student.getId(),student);
    }

    /* this function to delete student */
    public  void deleteStudent()  {
        System.out.println("Delete  Student .....");
        /* Find student */
        Student student = findStudent();
        // Delete student in the list
        if(this.list.remove(student)){
            System.out.println("Delete in loading ....");
            try {
                // wait main thread to 2 seconds
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("successful ");
        }else{
            System.out.println("Error ...");
        }
    }

    /* This function is to generate Password and mail */
    public  void generateMailPassword(){
         Student student;
         student = findStudent();
         if(student != null){
             // generate mail : concat name + username + @school.com
             String mail = student.getName().concat("." + student.getUsername() + "@school.com");
             // default password for all user
             String password ="passer@1";
             // we link the student to the account
             Account account = new Account(mail,password);
             student.setAccount(account);
             // Display element
             System.out.println("Your account identified :  ------- " );
             System.out.println("Email : " + student.getAccount().getEmail());
             System.out.println("password : " + student.getAccount().getPassword());

         }else{
             System.out.println("Student not exists ...!");
         }

    }
    /* This function is to buy formations */
    public  void buyFormation(){

         Student student = findStudent();
         // Initialize the list of training
         List<String> formations = initial();
         // Display list of training
         for(int i=0;i< formations.size();i++){
             System.out.println(i + " -> " + formations.get(i));
         }

         Util.enterInt("Please choice your formation");
         // the amount of training on the student's money is reduced
         student.setMonaie(student.getMonaie() - 400);
         System.out.println("your new balance is " + student.getMonaie());

         this.list.set(student.getId(),student);


    }

    /**
     * this function is used to initialize the list of training courses
     * @return list of training
     */
    public  List<String>  initial(){

         List<String> formations = new ArrayList<>();
         // add training in the list
         formations.add("Developer - 400 ");
         formations.add("Infographic - 400 ");
         formations.add("Marketer - 400");
         formations.add("Networking -400");

         return formations;

    }
}
