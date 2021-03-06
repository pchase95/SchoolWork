

public class Item
{
	private String name;
	private String desc;
	private Double price;
	private Integer rating = 0;
	private String itemImage = null;
	private Integer date = -1;

	
	public Item(String name, String desc, Double price)
	{
		name = this.name;
		desc = this.desc;
		price = this.price;
	}
	
	
	public void setName(String s)
	{
		name = s;
	}
	public String getName()
	{
		return name;
	}
	
	public void setDesc(String s)
	{
		desc = s;
	}
	public String getDesc()
	{
		return desc;
	}
	
	public void setPrice(String d)
	{
		price = Double.parseDouble(d);
	}
	public void setPrice(double d)
	{
		price = d;
	}
	public double getPrice()
	{
		return price;
	}
	
	public void setItemImage(String s)
	{
		itemImage = s;
	}
	public String getItemImage()
	{
		return itemImage;
	}
	
	public void setRating(Integer r)
	{
		rating = r;
	}
	public Integer getRating()
	{
		return rating;
	}
	
	
	public Double getPriceDouble()
	{
		return new Double(price);
	}
	
	public void setDate(Integer r)
	{
		date = r;
	}
	public Integer getDate()
	{
		return date;
	}
	
	//Override
	public String toString()
	{
		return name;
	}
}
