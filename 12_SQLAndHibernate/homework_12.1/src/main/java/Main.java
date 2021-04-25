import java.sql.*;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "789654123";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses ORDER BY name;");)
        {
            while (resultSet.next()){
                String courseName = resultSet.getString("name");
                System.out.println(courseName);
                String SQL = "SELECT pl.course_name, pl.subscription_date FROM PurchaseList pl WHERE pl.course_name = ? " +
                        "and MONTH(pl.subscription_date) = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(SQL);){
                    int countMonths = 0;
                    int lastMonth = 0;
                    for(int i = 1; i <= 12; i++) {
                        preparedStatement.setString(1, courseName);
                        preparedStatement.setInt(2, i);
                        try(ResultSet resultSet1 = preparedStatement.executeQuery();) {
                            if (resultSet1.next()) {
                                countMonths++;
                                lastMonth = i;
                            }
                        }
                    }
                    if(countMonths > 0 && lastMonth > 0){
                        double avg =  (double)countMonths / (double)lastMonth;
                        System.out.printf("\tСреднее количество покупок в месяц для курса: %.2f %n", avg);
                    }else
                        System.out.println("\tПокупок не было");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
