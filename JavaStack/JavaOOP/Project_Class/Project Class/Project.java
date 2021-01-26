public class Project {
    private String name ="";
    private String desc = "";
    private double initialCost = 0;
    public Project() {
        name ="";
        desc = "";
        initialCost = 0;
    }
    public Project(String name){
        this.name =name;
    }
    public Project(String name, String description, double initialCost) {
        this.name =name;
        this.desc = description;
        this.initialCost = initialCost;
    }
    public void setName(String name){
        this.name =name;
    }
    public void setDescription(String description){
        this.desc = description;
    }
    public void setinitialCost(double initialCost){
        this.initialCost = initialCost;
    }
    public double getinitialCost(){
        return this.initialCost;
    }
    public String getDescription(){
        return this.desc;
    }
    public String getName(){
        return this.name;
    }
    public String elevatorPitch(){
        return (getName()+ " (" + getinitialCost()+ ") :" + getDescription());
    }
}