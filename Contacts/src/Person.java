import java.io.*;

// Here is the class, it might look funny but its just because I kept everything
// together on one line.  This is the same way as doing:
// public void setName(String name)
// {
//		this.name = name;
// }


@SuppressWarnings("serial")
public class Person implements Serializable
{
	private int age;
	private String name, phone, email, address, website, work, comment, image;
	private Gender gender;

	public void setName(String name) { this.name = name; }
	// Note I will add regex to validate phone later
	public void setPhone(String phone) { this.phone = phone; }
	public void setEmail(String email) { this.email = email; }
	public void setAddress(String address) { this.address = address; }
	public void setWebsite(String website) { this.website = website; }
	public void setWork(String work) { this.work = work; }
	public void setComment(String comment) { this.comment = comment; }
	public void setGender(Gender gender) { this.gender = gender; }
	public void setAge(Integer age) { this.age = age; }
	public void setImage(String image){this.image = image;}

	public String getName() { return name; }
	public String getPhone() { return phone; }
	public String getEmail() { return email; }
	public String getAddress() { return address; }
	public String getWebsite() { return website; }
	public String getWork() { return work; }
	public String getComment() { return comment; }
	public Gender getGender() { return gender; }
	public Integer getAge() { return age; }
	public String getImage() { return image; }
	
	public String toString()
	{
		return this.name;
	}
}