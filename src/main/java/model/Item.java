package model;

public class Item {
	private int itemNumber;
	private String itemName;
	private int qty;
	private String itemDesc;
	private String sellerID;
	private String itemCategory;
	private float itemPrice;
	private String itemPhoto;
	


	public Item(int itemNumber, String itemName, String itemCategory, int qty, float itemPrice, String itemDesc) {
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.qty = qty;
		this.itemDesc = itemDesc;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
	}
	
	public Item(int itemNumber, String itemName, String itemCategory, int qty, float itemPrice, String itemDesc, String sellerID) {
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.qty = qty;
		this.itemDesc = itemDesc;
		this.sellerID = sellerID;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
	}
	
	public void setImage(String itemPhoto) {
        this.itemPhoto = itemPhoto;
    }

	public int getItemNumber() {
		return itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public int getQty() {
		return qty;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public String getSellerID() {
		return sellerID;
	}

	public String getItemCategory() {
		return itemCategory;
	}
	
	public float getItemPrice() {
		return itemPrice;
	}
	
	public String getItemPhoto() {
		return itemPhoto;
	}	
	
}
