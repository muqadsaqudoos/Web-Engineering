import java.util.*;

class InvalidMarksException extends Exception{
    private double marks;

    public InvalidMarksException(double m){
        marks = m;
    }

    public String toString(){
        return "Marks " + marks +" not in the range of 0-100";
    }
}

class Student{
    private String name;
    private double marks;

    public Student(String n, double m){
        name = n;
        marks = m;
    }

    public String assignGrade(double marks) throws InvalidMarksException{
        if (marks<0 || marks>100){
            throw new InvalidMarksException(marks);
        }
        else if (marks < 50){
            return "F";
        }
        else if(marks < 70){
            return "C";
        }
        else if( marks < 85){
            return "B";
        }
        else{
            return "A";
        }
    }
}

public class university{

    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = obj.nextLine();
        System.out.println("Enter Marks: ");
        double marks = obj.nextDouble();

        Student std = new Student(name, marks);

        try{
            String grade = std.assignGrade(marks);
            System.out.println("Grade: "+ grade);
        }
        catch(InvalidMarksException e){
            System.out.println("Error: " + e.toString());

        }
        finally{
            System.out.println("Grade assigned successfully.");

        }
    

    }
}