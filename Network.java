import java.util.*;

public class Network {

    private ListInterface<Profile> network = new AList<Profile>();

    Network(){

    }


    public void createProfile(){
        String inName;
        String inImg;
        String inStat;
        Scanner sc = new Scanner(System.in);

        System.out.println("Just a couple questions to create a new profile!");


        System.out.println("What is your name?");
        inName = sc.nextLine();

        System.out.println("What is your status?");
        inImg = sc.nextLine();

        System.out.println("do you have a pic for you profile? (enter url)");
        inStat = sc.nextLine();

        Profile tmp = new Profile(inName, inImg, inStat);
        network.add(tmp);

        System.out.println( inName + ", welcome to Facebook!");


    }

    public void createProfile(String name, String img, String stat){

        Profile tmp = new Profile(name, img, stat);
        network.add(tmp);

    }

    public int newestProfile (){
        return network.getLength();
    }

    public int signIn(){

        Scanner sc = new Scanner(System.in);
        String search;

        System.out.println("What is your name?");
        search = sc.nextLine();

        int pos = findPos(search);

        if(pos >= 0){
            System.out.println("Welcome back " + network.getEntry(pos).getName() + "!");
            return pos;
        } else {
            System.out.println(search + " is not a current user. Try making a new profile");
            return -1;
        }

    }

    public String deleteAccount(){

    }

    public void addFriends(){

    }

    public void searchFriends (){

    }

    public void modifyProfile () {

    }

    public void findMutual(){

    }

    public Profile getProfile(String name){
        int count = network.getLength();
        int index = 0;
        for (int i = 0; count > i; i++){
            if(network.getEntry(i).getName() == name)
                return network.getEntry(i);
        }

        return null;
    }

    public int findPos(String name){
        int count = network.getLength();
        for (int i = 0; count > i; i++){
            if(network.getEntry(i).getName() == name)
                return i;
        }
        return -1;
    }

}
