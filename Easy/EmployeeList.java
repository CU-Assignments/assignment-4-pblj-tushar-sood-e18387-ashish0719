import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + salary;
    }
}

public class EmployeeList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();
        while (true) {
            System.out.println("1. Add  2. Update  3. Remove  4. Search  5. Show  6. Exit");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("Enter ID, Name, Salary:");
                int id = sc.nextInt();
                String name = sc.next();
                double salary = sc.nextDouble();
                list.add(new Employee(id, name, salary));
            } else if (ch == 2) {
                System.out.println("Enter ID to update:");
                int id = sc.nextInt();
                for (Employee e : list) {
                    if (e.id == id) {
                        System.out.println("Enter new Name and Salary:");
                        e.name = sc.next();
                        e.salary = sc.nextDouble();
                        break;
                    }
                }
            } else if (ch == 3) {
                System.out.println("Enter ID to remove:");
                int id = sc.nextInt();
                list.removeIf(e -> e.id == id);
            } else if (ch == 4) {
                System.out.println("Enter ID to search:");
                int id = sc.nextInt();
                for (Employee e : list) {
                    if (e.id == id) {
                        System.out.println(e);
                        break;
                    }
                }
            } else if (ch == 5) {
                for (Employee e : list) {
                    System.out.println(e);
                }
            } else if (ch == 6) {
                break;
            }
        }
        sc.close();
    }
}
