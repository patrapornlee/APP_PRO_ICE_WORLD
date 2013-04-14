import iceworld.given.*;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: AVALON
 * Date: 9/4/2556
 * Time: 19:29 น.
 * To change this template use File | Settings | File Templates.
 */
//------------------------------------------------------------------------------
// Import helper classes from org.json to easily parse JSON format
// These classes were also downloaded from http://code.google.com/p/json-simple/
// and made available in CourseVille in the .jar format.
// For Eclipse users, add the .jar file as external jar into
// the src folder of your project.
// (project properties > Java Build Path > libraries > Add External JARs)
//------------------------------------------------------------------------------
//import the given classes/interfaces from the ICE World

public class MyICEWorldImmigration{
    public static void main(String[] args) {
        String usernameFromField = "Patraporn.L";
        String passwordFromField = "7741578";
        // ----------------------------------------------------------
        // Firstly, you need to create your own class that implements
        // the iceworld.given.MyIcetizen interface. The class should
        // represents your "Icetizen" implementation in your project.
        // ----------------------------------------------------------

        // ----------------------------------------------------------
        // Instantiate an object of your "Icetizen" class.
        // Set its attributes.

        Icetizen tester = new Icetizen();

        // *** Strictly use the ICE Port ID assigned to your group
        tester.setIcePortID(252);
        tester.setUsername(usernameFromField);
        // Pick any port number that this instance will use for
        // the peer-to-peer communication of the file transfer
        // action.
        // It is a good idea to find a way ensuring that different
        // instances of your ICE Port running on the same machine
        // do not use duplicated port numbers.
        tester.setListeningPort(10777);
        IcetizenLook look = new IcetizenLook();
        look.gidB = "B001";
        look.gidS = "S001";
        look.gidH = "H001";
        look.gidW = "W001";

        // ----------------------------------------------------------


        // ----------------------------------------------------------
        // Instantiate an object of the ICEWorldImmigration class.
        // Pass the Icetizen object, corresponding to the one to
        // enter the ICE World, as the input to the ICEWorldImmigration
        // constructor.

        ICEWorldImmigration immigration = new ICEWorldImmigration(tester);
        // ----------------------------------------------------------
        IcetizenLook look2 = new IcetizenLook();
        look2.gidB = "B001";
        look2.gidS = "S019";
        look2.gidH = "H008";
        look2.gidW = "W046";
        tester.setIcetizenLook(look);

        boolean loginTest = immigration.loginAlien();
        boolean talkTest = immigration.talk("Hello");
        boolean yellTest = immigration.yell("Hello");
        boolean walkTest = immigration.walk(9, 4);
        boolean customizeTest = immigration.customization(look2);
        boolean logoutTest = immigration.logout();

        // ----------------------------------------------------------
        // Do the login as an Alien
        if (loginTest){
            System.out.println("Login Alien OK");
        }
        // ----------------------------------------------------------

        // ----------------------------------------------------------
        // If you want to do the login as an Inhabitant
        if (immigration.login(passwordFromField))
        {
        	System.out.println("Login OK");
        }
        // ----------------------------------------------------------

        // ----------------------------------------------------------
        // Say "Hello"
        if (talkTest){
            System.out.println("Talk OK");
        }
        // ----------------------------------------------------------

        // ----------------------------------------------------------
        // Yell "Hello"
        if (yellTest){
            System.out.println("Yell OK");
        }
        // ----------------------------------------------------------

        // ----------------------------------------------------------
        // Walk to the (9,4) location of the ICE World ground
        if (walkTest){
            System.out.println("Walk OK");
        }
        // ----------------------------------------------------------

        // ----------------------------------------------------------
        // Customize the look of the active Icetizen

        if (customizeTest){
            System.out.println("Customization OK");
        }
        // ----------------------------------------------------------

        // ----------------------------------------------------------
        // Log out of the ICE World
        if (logoutTest){
            System.out.println("Logout OK");
        }
        // ----------------------------------------------------------
        Login loginWindow = new Login("Login");

    }

}

