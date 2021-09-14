/*******************************/
/*Students number : 300188539 
/*Student full name : Alae Boufarrachene
/*******************************/
public class Item {
  
    private String label;
    private int quantity;
	private float price;	
  
    public Item(String label, int quantity, float price) { //Class constructor with three parameters
        this.label = label;
		this.quantity = quantity;
		this.price = price;
	}

    public String getLabel() {
        return this.label;
    }

    public float getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int inputQuantity) {
        this.quantity = inputQuantity;
    }

    public void setPrice(float inputPrice) {
        this.price = inputPrice;
    }

    @Override
    public String toString() { //toString method that overrides the default one
        return (this.label + " - " + this.quantity+ " - " + this.price);
    }  

    public float calculateCurrentItemStock() {
        float totalStock = this.quantity*this.price;
        return totalStock;
	}
	
}