import java.util.*;

class EmployeeWorkHours {
    private String employeeName;
    private int[] dailyHours;

    public EmployeeWorkHours(String employeeName, int[] dailyHours) {
        this.employeeName = employeeName;
        this.dailyHours = dailyHours;
    }

    public int getTotalHours() {
        int totalHours = 0;
        for (int hours : dailyHours) {
            totalHours += hours;
        }
        return totalHours;
    }
}

public class WorkHoursAnalyzer {
    public static void main(String[] args) {
        // Sample employee work hours list
        List<EmployeeWorkHours> workHoursList = new ArrayList<>();
        workHoursList.add(new EmployeeWorkHours("Employee1", new int[]{8, 8, 8, 8, 8}));
        workHoursList.add(new EmployeeWorkHours("Employee2", new int[]{7, 8, 8, 8, 9}));
        workHoursList.add(new EmployeeWorkHours("Employee3", new int[]{6, 7, 8, 9, 5}));
        workHoursList.add(new EmployeeWorkHours("Employee4", new int[]{8, 8, 8, 8, 8}));
        workHoursList.add(new EmployeeWorkHours("Employee5", new int[]{8, 7, 9, 6, 7}));
        workHoursList.add(new EmployeeWorkHours("Employee6", new int[]{8, 8, 8, 8, 8}));
        workHoursList.add(new EmployeeWorkHours("Employee7", new int[]{8, 8, 7, 8, 8}));

        // Initialize variables to store counts and total hours for each group
        int moreThan40 = 0, exactly40 = 0, lessThan40 = 0;
        double moreThan40AvgHours = 0, exactly40AvgHours = 0, lessThan40AvgHours = 0;

        // Iterate over each employee work hours
        for (EmployeeWorkHours employee : workHoursList) {
            int totalHours = employee.getTotalHours();
            if (totalHours > 40) {
                moreThan40++;
                moreThan40AvgHours += totalHours / 5.0;
            } else if (totalHours == 40) {
                exactly40++;
                exactly40AvgHours += 8; // Assuming 8 hours worked per day on average
            } else {
                lessThan40++;
                lessThan40AvgHours += totalHours / 5.0;
            }
        }

        // Calculate average hours per day for each group
        moreThan40AvgHours /= moreThan40;
        exactly40AvgHours /= exactly40;
        lessThan40AvgHours /= lessThan40;

        // Print results
        System.out.println("Work Hours Group\tNumber of Employees\tAverage Hours Per Day");
        System.out.printf("More than 40 hours\t%d\t\t\t\t%.2f\n", moreThan40, moreThan40AvgHours);
        System.out.printf("Exactly 40 hours\t%d\t\t\t\t%.2f\n", exactly40, exactly40AvgHours);
        System.out.printf("Less than 40 hours\t%d\t\t\t\t%.2f\n", lessThan40, lessThan40AvgHours);
    }
}