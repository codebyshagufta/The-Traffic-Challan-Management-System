import java.sql.*;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n========================================");
            System.out.println("    TRAFFIC CHALLAN SYSTEM ");
            System.out.println("========================================");
            System.out.println("1. Issue Challan");
            System.out.println("2. Mark Challan as Paid");
            System.out.println("3. View Unpaid Challans");
            System.out.println("4. Daily Report");
            System.out.println("5. Exit");
            System.out.println("========================================");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    issueChallan();
                    break;
                case 2:
                    markPaid();
                    break;
                case 3:
                    viewUnpaid();
                    break;
                case 4:
                    dailyReport();
                    break;
                case 5:
                    System.out.println(" Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }

    static void issueChallan() {
        try (Connection conn = DBConnection.getConnection()) {

            System.out.print("Enter Vehicle Number: ");
            String vehicle = sc.nextLine();

            System.out.print("Enter Violation: ");
            String violation = sc.nextLine();

            System.out.print("Enter Fine Amount: ");
            double fine = sc.nextDouble();

            String query = "INSERT INTO challans (vehicle_no, violation, fine_amount) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, vehicle);
            ps.setString(2, violation);
            ps.setDouble(3, fine);

            ps.executeUpdate();

            System.out.println(" Challan Issued Successfully!");

        } catch (Exception e) {
            System.out.println(" Error issuing challan");
            e.printStackTrace();
        }
    }

    static void markPaid() {
        try (Connection conn = DBConnection.getConnection()) {

            System.out.print("Enter Challan ID: ");
            int id = sc.nextInt();

            String query = "UPDATE challans SET paid = TRUE WHERE challan_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println(" Payment Successful!");
            else
                System.out.println(" Challan not found!");

        } catch (Exception e) {
            System.out.println("  Error updating payment");
            e.printStackTrace();
        }
    }

    static void viewUnpaid() {
        try (Connection conn = DBConnection.getConnection()) {

            System.out.print("Enter Vehicle Number: ");
            String vehicle = sc.nextLine();

            String query = "SELECT * FROM challans WHERE vehicle_no=? AND paid=FALSE";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, vehicle);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Unpaid Challans ---");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("ID: " + rs.getInt("challan_id"));
                System.out.println("Violation: " + rs.getString("violation"));
                System.out.println("Fine: ₹" + rs.getDouble("fine_amount"));
                System.out.println("----------------------");
            }

            if (!found)
                System.out.println(" No unpaid challans!");

        } catch (Exception e) {
            System.out.println(" Error fetching data");
            e.printStackTrace();
        }
    }

    static void dailyReport() {
        try (Connection conn = DBConnection.getConnection()) {

            String totalQuery = "SELECT SUM(fine_amount) FROM challans WHERE paid=TRUE AND DATE(issued_on)=CURDATE()";
            PreparedStatement ps1 = conn.prepareStatement(totalQuery);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                System.out.println("💰 Total Collected Today: ₹" + rs1.getDouble(1));
            }

            String repeatQuery = "SELECT vehicle_no, COUNT(*) as count FROM challans GROUP BY vehicle_no HAVING count >= 2";
            PreparedStatement ps2 = conn.prepareStatement(repeatQuery);
            ResultSet rs2 = ps2.executeQuery();

            System.out.println("\n Repeat Offenders:");
            while (rs2.next()) {
                System.out.println(rs2.getString("vehicle_no") + " (" + rs2.getInt("count") + " challans)");
            }

        } catch (Exception e) {
            System.out.println(" Error generating report");
            e.printStackTrace();
        }
    }
}