import java.util.Scanner;

public class inputOutput
{
    public static void main (String[] args)
    {
        if (args.length > 0)
        {
            System.out.println("Printing arguments :");
            int i = 0;
            do
            {
                System.out.print(args[i] + " ");
                i++;
            } while(i < args.length);
        }
        System.out.println();
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        if (age < 0)
        {
            System.err.println("Error: Age cannot be negative.");
        }

        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    
        String employeeName = "Alice";
        int employeeAge = 30;
        double employeeSalary = 2500.75;
        System.out.printf("Employee Details \n Name: %s, Age: %d, Salary: %.2f%n", employeeName, employeeAge, employeeSalary);
    }
}