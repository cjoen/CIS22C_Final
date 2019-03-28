import java.util.*;

public class SocialNetwork {

    public static void main(String args[]){
        Network facebook = new Network();
        Profile temp =  facebook.searchFriends(intro(facebook));







    }

    public static int intro(Network facebook){
        String ans;
        int profilePosition = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the social network!");
        System.out.println("Do you already have a profile? (yes/no)");
        ans = sc.nextLine();

        if (ans == "yes") {
            System.out.println("What is your name?");
            String name = sc.nextLine();

            profilePosition = facebook.findPos(name);

        } else if (ans == "no") {
            System.out.println("Lets create a new profile for you!");
            facebook.createProfile();
            profilePosition = facebook.newestProfile();

        }

        return profilePosition;
    }




}
