public class ProjectTest  {
    public static void main(String[] args) {
        Project proj1 = new Project();
        Project proj2 = new Project("comp1");
        Project proj3 = new Project("comp2","this",5.00);
        Project proj4 = new Project("comp3","this",9.00);
        Project proj5 = new Project("comp4","this",7.00);
        Portfolio port=new Portfolio();
        port.setProjects(proj1);
        port.setProjects(proj2);
        port.setProjects(proj3);
        port.setProjects(proj4);
        port.setProjects(proj5);
        System.out.println(port.getPortfolioCost());
        port.showPortfolio();
    }
}
