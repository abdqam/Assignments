import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Project> projects= new ArrayList<Project>();
    public Portfolio(){

    }
    public void setProjects(Project project){
        this.projects.add(project);
    }
    public ArrayList<Project> getProjects(){
        return this.projects;
    }
    public double getPortfolioCost(){
        double totalCost=0;
        for(Project project : getProjects()){
            totalCost+=project.getinitialCost();
        }
        return totalCost;
    }
    public void showPortfolio(){
        for(Project project:getProjects()){
            System.out.println(project.elevatorPitch());
        }
        System.out.println(getPortfolioCost());
    }
}
