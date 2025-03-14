import java.util.Scanner;

public class PolynomialDriver {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first polynomial: ");

        Polynomial p1 = new Polynomial();

        readPolynomial(scanner, p1);    


        System.out.println("Enter the second polynomial: ");
        Polynomial p2 = new Polynomial();
        readPolynomial(scanner, p2);

        System.out.println("Enter a value of x for 1st polynomial: ");
        int x1 = scanner.nextInt();

        System.out.println("Enter a value of x for 2nd polynomial: ");
        int x2 = scanner.nextInt();

        Polynomial sum =p1.add(p2);

        System.out.println("First Polynomial: " + p1);
        System.out.println("Second Polynomial: " + p2);

        System.out.println("Sum of Polynomials: " + sum);

        System.out.println("Evaluation of 1st polynomial at x= " + x1 + " is : "+p1.evaluate(x1));
        System.out.println("Evaluation of 2nd polynomial at x= " + x2 + " is : "+p2.evaluate(x2));

        scanner.close();
    }

    private static void readPolynomial(Scanner scanner, Polynomial polynomial){
        String input = scanner.nextLine();
        Scanner lineScanner = new Scanner(input);

        while(lineScanner.hasNextInt()){
            int coefficient = lineScanner.nextInt();
            int power = lineScanner.nextInt();
            polynomial.addTerm(coefficient, power);
        }
        lineScanner.close();
    }
}
