// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // criando departamentos

        Department dep01 = new Department("Fisica", "Rio Claro", 1655555555, 5000000, 1);
        Department dep02 = new Department("Sociais", "Rio Preto", 1688888888, 1000000, 2);

        //   criando funcionários

        Employee employee1 = new Employee("John Doe", 50000, "HR Manager", dep01, 0);
        Employee employee2 = new Employee("Jane Smith", 60000, "Software Engineer", dep02, 1);
        Employee employee3 = new Employee("Alice Johnson", 55000, "Marketing Specialist", dep01, 2);
        Employee employee4 = new Employee("Bob Williams", 70000, "Data Analyst", dep02, 3);
        Employee employee5 = new Employee("Eva Brown", 58000, "Product Manager", dep01, 4);
        Employee employee6 = new Employee("David Lee", 62000, "QA Engineer", dep02, 5);
        Employee employee7 = new Employee("Olivia Wilson", 54000, "Recruiter", dep01, 6);
        Employee employee8 = new Employee("Liam Miller", 68000, "Backend Developer", dep02, 7);
        Employee employee9 = new Employee("Sophia Garcia", 52000, "Sales Representative", dep01, 8);
        Employee employee10 = new Employee("Noah Martinez", 59000, "UX Designer", dep02, 9);
        Employee employee11 = new Employee("Ava Lopez", 73000, "Data Scientist", dep01, 10);
        Employee employee12 = new Employee("James Rodriguez", 57000, "Graphic Designer", dep02, 11);
        Employee employee13 = new Employee("Isabella Perez", 64000, "Business Analyst", dep01, 12);
        Employee employee14 = new Employee("William Turner", 51000, "Content Writer", dep02, 13);
        Employee employee15 = new Employee("Mia Hernandez", 67000, "Systems Engineer", dep01, 14);
        Employee employee16 = new Employee("Alexander Smith", 60000, "Product Designer", dep02, 15);
        Employee employee17 = new Employee("Sofia Taylor", 56000, "Financial Analyst", dep01, 16);
        Employee employee18 = new Employee("Benjamin Brown", 71000, "Software Developer", dep02, 17);
        Employee employee19 = new Employee("Michael Johnson", 75000, "Marketing Specialist", dep01, 18);
        Employee employee20 = new Employee("Emily Davis", 55000, "Frontend Developer", dep02, 19);


        dep01.listAllEmployees();
        dep02.listAllEmployees();

        // Remover um funcionário
        dep01.removeEmployee(employee1);
        dep02.removeEmployee(employee2);

        // Listar novamente após a remoção
        dep01.listAllEmployees();
        dep02.listAllEmployees();


        dep01.addEmployee(employee1);
        dep02.addEmployee(employee2);

        dep01.listAllEmployees();
        dep02.listAllEmployees();

        // testando funão listAllEmployees
        employee20.printState();
        System.out.println(employee20.getAnnualSalary());


    }
}