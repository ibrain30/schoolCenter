/**
 * The Main class
 * @author Baye Talla NDIAYE
 */
import services.Menu;
import utils.Util;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("=== School Center Management === ");

            System.out.println("-.1 Teacher \n" + "-.2 Student \n" + "-.3 Quit Application ");
            int answer = Util.enterInt("Please choice your profile");

            if (answer == 1) {
                /* Menu when your profile is Teacher */
                Menu.MenuTeacher();
            } else if (answer == 2) {
                /* Menu when your profile is Student */
                Menu.MenuStudent();
            } else if(answer == 3){
                /* Quit Programme */
                return;
            }else{
                System.out.println(" !!! Sorry choose again ");
            }

        }
    }
}
