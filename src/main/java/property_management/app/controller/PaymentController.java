package property_management.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import property_management.app.dao.PaymentDao;
import property_management.app.dao.UserDao;

@Controller
public class PaymentController {
	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private UserDao userDao;

}