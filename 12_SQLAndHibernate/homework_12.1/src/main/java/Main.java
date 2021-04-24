import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "789654123";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses ORDER BY name;");
            while (resultSet.next()){
                String courseName = resultSet.getString("name");
                System.out.println(courseName);

                Statement statement1 = connection.createStatement();
                int countMonths = 0;
                int lastMonth = 0;
                for(int i = 1; i <= 12; i++) {
                    ResultSet resultSet1 = statement1.executeQuery("SELECT pl.course_name, pl.subscription_date FROM PurchaseList pl WHERE pl.course_name = \"" + courseName + "\" and MONTH(pl.subscription_date ) =" + i + ";");
                    if (resultSet1.next()) {
//                        String string = resultSet1.getString("subscription_date");
//                        System.out.println("\t" + string);
                        countMonths++;
                        lastMonth = i;
                    }
                    resultSet1.close();
                }
                statement1.close();
//                System.out.println("\tКоличество месяцев " + countMonths);
//                System.out.println("\tПоследний месяц " + lastMonth);
                if(countMonths > 0 && lastMonth > 0){
                    double avg =  (double)countMonths / (double)lastMonth;
                    System.out.printf("\tСреднее количество покупок в месяц для курса: %.2f %n", avg);
                }else
                    System.out.println("\tПокупок не было");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
