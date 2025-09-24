import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecord {
    private int id;
    private String name;
    private int marks;
    public StudentRecord(int id,String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
    public static void main(String[] args){
        boolean running = true;
        ArrayList<StudentRecord> studentRecords = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(running){
            System.out.println("Enter 1 to Add, 2 to View,3 to Update,4 to Delete, 5 to EXIT");
            int choice = sc.nextInt();
            if(choice==1){
               System.out.println("Enter Student ID");
               int id = sc.nextInt();
               System.out.println("Enter Student Name");
               String name = sc.next();
               System.out.println("Enter Student Marks");
               int marks = sc.nextInt();
               if(marks<=100) {
                   studentRecords.add(new StudentRecord(id, name, marks));
               }
               else{
                   System.out.println("Invalid Marks! Please enter less than or equal to 100");
               }
            }

            else if(choice==2){
                if(studentRecords.isEmpty()){
                    System.out.println("There are no records in the database.");
                }
                else{
                    for(StudentRecord studentRecord:studentRecords){
                        System.out.println(studentRecord.toString());
                    }
                }
            }
            else if(choice==3){
                System.out.println("Enter Student ID");
                int id = sc.nextInt();
                for(StudentRecord studentRecord:studentRecords){
                    if(studentRecord.getId()==id){
                        System.out.println("Enter new ID : ");
                        int newId = sc.nextInt();
                        studentRecord.setId(newId);
                        System.out.println("Enter new name : ");
                        String newName = sc.next();
                        studentRecord.setName(newName);
                        System.out.println("Enter new marks : ");
                        int newMarks = sc.nextInt();
                        if(newMarks<=100) {
                            studentRecord.setMarks(newMarks);
                            System.out.println("Updated Successfully!");
                            System.out.println(studentRecord);
                        }
                        else {
                            System.out.println("Invalid Marks! Please enter less than or equal to 100");
                        }

                    }
                }
            }
            else if(choice==4){
                System.out.println("Enter Student ID");
                int id = sc.nextInt();
                for(StudentRecord student: studentRecords){
                    if(student.getId()==id){
                        studentRecords.remove(student);
                    }
                }
                System.out.println("Deleted Successfully!");
            }
            else {
                running = false;
                System.out.println("You choosed to exit");
            }
        }
    }
}
