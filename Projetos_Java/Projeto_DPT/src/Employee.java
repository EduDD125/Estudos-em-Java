public class Employee {
    private String name;
    private long id;  // todo fazer logica interna para haver acrescimo do id automaticamente
    private double salary;
    private String jobTitle;

    private Department dept;

    public Employee(String name, double salary, String jobTitle, Department dept, long id) {
        this.name = name;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.dept = dept;
        dept.addEmployee(this);
        this.id = id;
    }

    public void printState(){
        StringBuilder strBuilder = new StringBuilder();

        System.out.println("###   Employee Status    ###");
        strBuilder.append("\n name: ")
                .append(this.name)
                .append(" | salary: ")
                .append(this.salary)
                .append(" | job title: ")
                .append(this.jobTitle)
                .append("\n\n ##############################");
        System.out.println(strBuilder);
    }

    public double getAnnualSalary() {
        return this.salary*12;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Department getDept() {
        return dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary > 0 ? salary : 0;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}

