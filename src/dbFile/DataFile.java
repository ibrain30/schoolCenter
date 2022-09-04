/**
 * DataFile class
 * This class allow me to manager the file "./src/DbFile/Students.txt"
 * @author Baye Talla NDIAYE
 */
package dbFile;

import model.Student;
import java.io.*;
import java.util.List;

public class DataFile {
    /* declaration File */
   static  File file = new File("./src/DbFile/Students.txt");

    /**
     * insertData is a function to insert data in the file
     * @param list is a tempo contains all students
     */
     public static void insertData(List<Student> list) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        /* objectOutputStream allow me to serialize the list of object students */
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
     }

    /**
     * readData is a function to read data from the file
     * @return result is a list of students
     */
     public static List<Student> readData() {
         List<Student> result = null;

         FileInputStream fileInputStream = null;
         try {
             fileInputStream = new FileInputStream(file);
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         }

         ObjectInputStream objectInputStream = null;
         try {
             objectInputStream = new ObjectInputStream(fileInputStream);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

         try {
             /* casting object to List<Student> */
             result = (List<Student>)objectInputStream.readObject();
         } catch (IOException | ClassNotFoundException e) {
             throw new RuntimeException(e);
         }
         return  result;
     }



}
