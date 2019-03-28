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

    public void deleteAccount(int currentProfile){
        Scanner sc = new Scanner(System.in);
        System.out.println("Are your sure you want to delete your account?");
        if(sc.nextLine() == "yes"){
            network.remove(currentProfile);
        }

    }

    public void addFriends(int currentProfile, String searchName){
        network.getEntry(currentProfile).addFriend(getProfile(searchName));
    }

    public int searchFriends (int currentProfile, String searchName){
        int friendPos = findPos(searchName);
        return friendPos;
    }

    public void modifyProfile (Profile currentProfile) {
        int choice;
        System.out.println("What part of the profile would you like to modify? (0 to exit)\n");
        System.out.println("1. Name\n 2. Profile Pic \n 3. Status");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        if(choice == 1){
            System.out.println("What would you like to change your name to?");
            currentProfile.setName(sc.nextLine());

        } else if(choice == 2){
            System.out.println("What would you like to change your pic to?");
            currentProfile.setPic(sc.nextLine());

        } else if(choice == 3){
            System.out.println("What would you like to change your status to?");
            currentProfile.setStatus(sc.nextLine());

        } else {
            System.out.println("All modifications will be saved\n");
        }

    }

    public void findMutual(){

        //implement graphs to make this happen.

    }

    private Profile getProfile(String name){
        int count = network.getLength();
        int index = 0;
        for (int i = 0; count > i; i++){
            if(network.getEntry(i).getName() == name)
                return network.getEntry(i);
        }

        return null;
    }

    private int findPos(String name){
        int count = network.getLength();
        for (int i = 0; count > i; i++){
            if(network.getEntry(i).getName() == name)
                return i;
        }
        return -1;
    }

}
