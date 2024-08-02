import java.util.ArrayList;
import java.util.Scanner;
public class studentgradetracker {
	    public static void main(String[] args) {

	        Scanner scan = new Scanner(System.in);
	        ArrayList<Double> grades = new ArrayList<>();

	        while (true) {
	            System.out.println("Enter a grade (or 'q' to quit): ");
	            String input = scan.next();

	            if (input.equalsIgnoreCase("q")) {
	                break;
	            }

	            try {
	                double grade = Double.parseDouble(input);
	                grades.add(grade);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a number or 'q' to quit.");
	            }
	        }

	        if (grades.size() == 0) {
	            System.out.println("No grades entered.");
	        } else {
	            double sum = 0;
	            double highest = grades.get(0);
	            double lowest = grades.get(0);

	            for (double grade : grades) {
	                sum += grade;
	                if (grade > highest) {
	                    highest = grade;
	                }
	                if (grade < lowest) {
	                    lowest = grade;
	                }
	            }

	            double average = sum / grades.size();

	            System.out.println("Average grade: " + average);
	            System.out.println("Highest grade: " + highest);
	            System.out.println("Lowest grade: " + lowest);
	        }
	        scan.close();
	    }
	    
	

}