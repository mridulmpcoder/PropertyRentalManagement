//package property_management.app.service;
//
//
//
//import property_management.app.model.Payment;
//import property_management.utility.DatabaseConnection;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentService {
//
//    // Method to retrieve payment history for a tenant
//    public List<Payment> getPaymentHistory(int tenantId) {
//        List<Payment> paymentList = new ArrayList<>();
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = DatabaseConnection.getConnection();
//            String sql = "SELECT payment_date, amount, payment_method, status FROM payments WHERE tenant_id = ?";
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, tenantId);
//            resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                Payment payment = new Payment();
//                payment.setPaymentDate(resultSet.getDate("payment_date"));
//                payment.setAmount(resultSet.getDouble("amount"));
//                payment.setPaymentMethod(resultSet.getString("payment_method"));
//                payment.setStatus(resultSet.getString("status"));
//                paymentList.add(payment);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (resultSet != null) resultSet.close();
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return paymentList;
//    }
//}
