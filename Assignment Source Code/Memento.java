public class Memento {
    private ToyProduct typr;
    private int qty;
    private String name;
    private double cost, price, maxSpeed, height;
    
    // constructor
    public Memento(ToyProduct typr) {
        this.typr = typr;
        this.qty = typr.getQty();
        this.name = typr.getName();
        this.cost = typr.getCost();
        this.price = typr.getPrice();
        
        if (typr instanceof Robot) {
            this.height = ((Robot) typr).getHeight();
        } else if (typr instanceof RemoteControlCar) {
            this.maxSpeed = ((RemoteControlCar) typr).getMaxSpeed();
        }
    }
    
    public void restore() {
        // restore data
        this.typr.setName(this.name);
        this.typr.setQty(this.qty);
        this.typr.setCost(this.cost);
        this.typr.setPrice(this.price);
        
        if (typr instanceof Robot) {
            ((Robot) typr).setHeight(this.height);
        } else if (typr instanceof RemoteControlCar) {
            ((RemoteControlCar) typr).setMaxSpeed(this.maxSpeed);
        }
    }
    
    public ToyProduct getToyProduct() {
        return this.typr;
    }
}
