import java.util.*;

abstract class Staff{
    String name;
    String id;
    String dept;

    public Staff(String n, String i, String d){
        name = n;
        id = i;
        dept = d;
    }

    public abstract double calculateSalary();

    public String toString(){
        return "Name: "+name+"ID: "+id+"Department: "+dept;
    }
}

class Professor extends Staff{
    double FixedMonthSalary;

    public Professor(String n, String i, String d, double s){
        super(n,i,d);
        FixedMonthSalary = s;
    }

    public double calculateSalary(){
        return FixedMonthSalary;
    }

    public String toString(){
        return super.toString()+"Salary: "+calculateSalary();
    }
    

}
class Lecturer extends Staff{
    int noOfDays;
    double pricePerLecturer;

    public Lecturer(String n, String i, String d, int no , double p){
        super(n,i,d);
        noOfDays = no;
        pricePerLecturer = p;
    }

    public double calculateSalary(){
        return noOfDays*pricePerLecturer;
    }

    public String toString(){
        return super.toString()+"Salary: "+calculateSalary();
    }
}
class Administrator extends Staff{
    double baseSalary;
    double performanceBonus;

    public Administrator(String n, String i, String d, double bs , double ps){
        super(n,i,d);
        baseSalary = bs;
        performanceBonus = ps;
    }

    public double calculateSalary(){
        return baseSalary+performanceBonus;
    }

    public String toString(){
        return super.toString()+"Salary: "+calculateSalary();
    }   
}

class ResearchAssistant extends Staff{
    double Stipend;
    double researchGrant;

    public ResearchAssistant(String n, String i, String d, double st , double rg){
        super(n,i,d);
        Stipend = st;
        researchGrant = rg;
    }

    public double calculateSalary(){
        return Stipend+researchGrant;
    }

    public String toString(){
        return super.toString()+"Salary: "+calculateSalary();
    }
}
public class inheritance{
    public static void main(String[] args){

        Scanner obj = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = obj.nextInt();
        Staff[] array = new Staff[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nSelect Staff Type:");

            System.out.println("1. Professor");
            System.out.println("2. Lecturer");
            System.out.println("3. Administrator");
            System.out.println("4. Research Assistant");
            System.out.println("Enter choice: ");

            int choice = obj.nextInt();
            obj.nextLine();

            System.out.println("Enter Name: ");
            String name = obj.nextLine();
            System.out.println("Enter ID: ");
            String id = obj.nextLine();
            System.out.println("Enter Department: ");
            String department = obj.nextLine();

            if (choice == 1){

                System.out.println("Fixed Monthly Salary: ");
                double sal = obj.nextDouble();
                array[i] = new Professor(name, id, department, sal);

            }

            else if(choice == 2){

                System.out.println("No of Days: ");
                int days = obj.nextInt();
                System.out.println("Price per Lecture: ");
                double price = obj.nextDouble();
                array[i] = new Lecturer(name, id, department, days, price);

            }

            else if (choice == 3){

                
                System.out.println("Base Salary: ");
                double sal = obj.nextDouble();
                System.out.println("Performance Bouns: ");
                double bonus = obj.nextDouble();
                array[i] = new Administrator(name, id, department, sal, bonus);

            }

            else if (choice == 4){

                System.out.println("Stipend: ");
                double stipend = obj.nextDouble();
                System.out.println("Reserach Grant: ");
                double reserach = obj.nextDouble();
                array[i] = new ResearchAssistant(name, id, department, stipend, reserach);

            }

            else{
                System.out.println("Invalid Choice");
            }
    }

    System.out.println("Salary Details");
    for (int i=0; i<n;i++) {
            System.out.println(array[i]);
        }

}
}
