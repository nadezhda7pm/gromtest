package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {

    private static Set<Project> projects;

    public ProjectDAO() {
        projects = new HashSet<>();
    }

    public static Set<Project> getProjects() {
        return projects;
    }

    public static Project getProjectByName(String name) {
        if (projects != null)
            for (Project p : projects){
                if (p != null && p.getName().equals(name))
                    return p;
            }
        return null;
    }



//
//    public static Project add (Project p){
//        projects.add(p);
//        return p;
//    }
//
//    public static Project remove (Project p){
//        projects.remove(p);
//        return p;
//    }
//
//    public static Project contains (Project p){
//        projects.contains(p);
//        return p;
//    }


}
