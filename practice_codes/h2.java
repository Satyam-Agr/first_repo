package first_repo.practice_codes;
import java.util.*;

class Student {
    private int ID;
    private String Name;
    private double CGPA;

    Student(int id, String name, double cgpa) {
        ID = id;
        Name = name;
        CGPA = cgpa;
    }

    int getID() {
        return ID;
    }

    String getName() {
        return Name;
    }

    double getCGPA() {
        return CGPA;
    }
}

class Input {
    Scanner sc = new Scanner(System.in);

    int getN() {
        int N = 0;
        boolean test = true;
        while (test) {
            N = sc.nextInt();
            if (N >= 2 && N <= 1000)
                test = false;
            else
                System.out.println("Invalid value of 'n'. Enter in the range of 2-1000");
        }
        return N;
    }

    String getEvent() {
        String stE = "";
        boolean test = true;
        while (test) {
            stE = sc.next(); // Only call once
            if (stE.equals("ENTER") || stE.equals("SERVED")|| stE.equals("mastercontrole_end")) {
                test = false;
            } else {
                System.out.println("Invalid event");
            }
        }
        return stE;
    }

    int sID() {
        int sid = 0;
        boolean test = true;
        while (test) {
            sid = sc.nextInt();
            if (sid >= 1 && sid <= 100000)
                test = false;
            else
                System.out.println("Invalid ID");
        }
        return sid;
    }

    double sCGPI() {
        double scgpi = 0;
        boolean test = true;
        while (test) {
            scgpi = sc.nextDouble();
            if (scgpi >= 0 && scgpi <= 4.00)
                test = false;
            else
                System.out.println("Invalid CGPI");
        }
        return scgpi;
    }

    String sName() {
        String sname = "";
        boolean test = true;
        while (test) {
            sname = sc.next(); // Only call once
            if (sname.length() >= 2 && sname.length() <= 30)
                test = false;
            else
                System.out.println("Invalid Name length");
        }
        return sname;
    }
}

class Priorities {
    List<Student> queue = new ArrayList<>();

    List<Student> getStudents(List<String> events) {
        Input input = new Input();
        if (events.contains("ENTER")) 
        {
        	String na= input.sName(); 
            int x=input.sID();
        	double cg=input.sCGPI();
            Student student = new Student(x,na,cg);
            queue.add(student);
        } else if (events.contains("SERVED")) {
            List<Student> serve = filterByHighestCGPA();
            if (serve.size() > 1) {
                serve = filterByName(serve);
                if (serve.size() > 1) {
                    serve = filterByID(serve);
                }
            }
            if (!serve.isEmpty()) {
                queue.remove(serve.get(0));
            }
        } else {
            System.out.println("Invalid event");
        }
        return queue;
    }

    List<Student> filterByHighestCGPA() {
        List<Student> hcgpa = new ArrayList<>();
        hcgpa.add(queue.get(0));
        for (Student temp : queue) {
            if (temp.getCGPA() > hcgpa.get(0).getCGPA()) {
                hcgpa.clear();
                hcgpa.add(temp);
            } else if (temp.getCGPA() == hcgpa.get(0).getCGPA()) {
                hcgpa.add(temp);
            }
        }
        return hcgpa;
    }

    List<Student> filterByName(List<Student> ascName) {
        List<Student> hname = new ArrayList<>();
        hname.add(ascName.get(0));
        for (Student temp : ascName) {
            if (temp.getName().compareTo(hname.get(0).getName()) < 0) {
                hname.clear();
                hname.add(temp);
            } else if (temp.getName().compareTo(hname.get(0).getName()) == 0) {
                hname.add(temp);
            }
        }
        return hname;
    }

    List<Student> filterByID(List<Student> ascID) {
        List<Student> hid = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (Student temp : ascID) {
            if (temp.getID() < min) {
                hid.clear();
                hid.add(temp);
                min = temp.getID();
            }
        }
        return hid;
    }
}

public class h2 
{
    public static void main(String[] args) {
        Input input = new Input();
        Priorities pri = new Priorities();
        int n = input.getN();
        List<Student> printf = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String event = input.getEvent();
            List<String> e = new ArrayList<>();
            e.add(event);
            printf = pri.getStudents(e);
            e.clear();

        }
        for (Student St : printf) {
            System.out.println(St.getName());
        }
    }
}
