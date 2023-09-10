public class Department {
    private String name;
    private int code;
    private String location;
    private int phoneExtention;
    private double budget;
    private double totalExpenses;
    private Employee[] employeeList = new Employee[100];
    private int numEmployees;

    public Department(String name, String location, int phoneExtension, double budget, int code) {
        this.name = name;
        this.location = location;
        this.phoneExtention = phoneExtension;
        this.budget = budget;
        this.code = code;
    }

    public Employee getEmployee(long id) {
        for (int i = 0; i < numEmployees; i++)
            if (employeeList[i].getId() == id) return employeeList[i];
        return null;
    }
    public int sizeOfEmployees() {
        return this.numEmployees;
    }

    public void listAllEmployees(){
        StringBuilder strBuilder = new StringBuilder();

        System.out.printf("###   Listing Employees from %s    ###", this.name);
        for (int i = 0; i < numEmployees; i++) {
            strBuilder.append("\n name: ").append(this.employeeList[i].getName())
                    .append(" | salary: ")
                    .append(this.employeeList[i].getSalary())
                    .append(" | job title: ")
                    .append(this.employeeList[i].getJobTitle());
        }
        System.out.println(strBuilder);
        System.out.println("\n\n ##############################");
    }
    public void addEmployee(Employee newEmployee){
        if (isAllowedToHire(newEmployee.getSalary())) {
            totalExpenses += newEmployee.getSalary();
            employeeList[numEmployees] = newEmployee;
            numEmployees++;
        }
    }

    public boolean isAllowedToHire(double salary) {
        return budget >= this.totalExpenses + salary;
    }

    public void removeEmployee(long id){
        // todo refazer dentro da função pra veridficar se pode reduzir o orçamento com o a demisão bem sucedida
        Employee employeeTarget = getEmployee(id);
        this.totalExpenses -= employeeTarget.getSalary();
        removeEmployeeFromList(id);
        this.numEmployees--;
    }
    public void removeEmployee(Employee employee){
        removeEmployee(employee.getId());
    }

    public void removeEmployeeFromList(long id) {
        for (int position = 0; position < employeeList.length; position++) {
            if (employeeList[position].getId() == id) {
                for ( int i = position; i < employeeList.length-1; i++) {
                    employeeList[i] = employeeList[i+1];
                }
                employeeList[--numEmployees] = null;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getLocation() {
        return location;
    }

    public int getPhoneExtention() {
        return phoneExtention;
    }

    public double getBudget() {
        return budget;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhoneExtention(int phoneExtention) {
        this.phoneExtention = phoneExtention;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
}
