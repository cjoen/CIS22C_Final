import java.util.*;

public class Profile
{
	private String name;
	private String picUrl;
	private String status;
	private Profile[] friends;
	private int friendCount;

// Probably won't use this if the driver inputs correct data each time.
	public Profile()
	{
		name = "nothing";
		picUrl = null;
		status = "nothing";
		friends = new Profile[10];
		friendCount = 0;
	}

	public Profile(String nameIn, String picUrlIn, String stat)
	{
		name = nameIn;
		picUrl = picUrlIn;
		status = stat;
		friends = new Profile[10];
		friendCount = 0;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String nameIn)
	{
		name = nameIn;
		System.out.println("Name changed to " + nameIn);
	}

	public String getPic()
	{
		return picUrl;
	}

	public void setPic(String picIn)
	{
		picUrl = picIn;
		System.out.println("Picture changed to " + picIn);
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String statusIn)
	{
		status = statusIn;
		System.out.println("Status changed to " + statusIn);

	}

	public void addFriend(Profile newFriend)
	{
		friends[friendCount] = newFriend;
		friendCount++;
		System.out.println("Friend added");
	}

	public void removeFriend(Profile iHateThisGuy)
	{
		boolean found = false;
		for(int i = 0; i < friendCount; i++)
		{
			if(friends[i] == iHateThisGuy)
			{
				friends[i] = null;
				friendCount--;
				found = true;
			}
		}
		if(found)
		{
			System.out.println("Friend removed");
		}
		else
		{
			System.out.println("Friend not found");
		}
	}
}
