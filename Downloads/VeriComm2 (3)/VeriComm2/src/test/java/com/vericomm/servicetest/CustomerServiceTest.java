package com.vericomm.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vericomm.dao.CustomerDao;
import com.vericomm.dao.PlanDao;
import com.vericomm.model.Customer;
import com.vericomm.model.Plan;
import com.vericomm.service.CustomerService;
import com.vericomm.service.PlanService;
@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerServiceTest {
	@MockBean
	private CustomerDao customerdao;
	@Autowired
	private CustomerService customerservice;

	@Test
	public void getCustomerstest() {
		Customer customer=new Customer();//getCustomers
		customer.setCid(1);
		customer.setCname("havela");
		customer.setEmail("havela@gmail.com");
		customer.setLocation("hyd");
		customer.setPhn("8634872332");
		Plan p1=new Plan();
		p1.setPid(1);
		customer.setPlan(p1);
		
		Customer customer1=new Customer();//getCustomers
		customer1.setCid(2);
		customer1.setCname("raju");
		customer1.setEmail("raj@gmail.com");
		customer1.setLocation("dehradun");
		customer1.setPhn("8722573332");
		Plan p2=new Plan();
		p2.setPid(1);
		customer.setPlan(p2);
		
		List<Customer> custlst = new ArrayList<>();
		custlst.add(customer);
		custlst.add(customer1);

		Mockito.when(customerdao.findAll()).thenReturn(custlst);
		Assert.assertEquals(customerservice.getCustomers(), custlst);
		
		
	}
	@Test
	public void getCustomersTest()
	{
	
		Customer customer = new Customer();
        customer.setCid(1);
        customer.setCname("havela");
        customer.setEmail("havela@gmail.com");
        customer.setLocation("hyd");
        customer.setPhn("8634872332");
        Plan p1 = new Plan();
        p1.setPid(1);
        customer.setPlan(p1);

        Mockito.when(customerdao.findById(1)).thenReturn(Optional.of(customer));

        Assert.assertEquals(customerservice.getCustomers(1), customer);
	}
	@Test
	public void getCustomersRegisteredBetweentest() {
		Customer customer=new Customer();
		customer.setCid(1);
		customer.setCname("havela");
		customer.setEmail("havela@gmail.com");
		customer.setLocation("hyd");
		customer.setPhn("8634872332");
//		customer.setRegisterDate("2023-09-22");
		Plan p1=new Plan();
		p1.setPid(1);
		customer.setPlan(p1);
		
		Customer customer1=new Customer();
		customer1.setCid(2);
		customer1.setCname("raju");
		customer1.setEmail("raj@gmail.com");
		customer1.setLocation("dehradun");
		customer1.setPhn("8722573332");
		Date startSqlDate = Date.valueOf("2023-09-22");
        Date endSqlDate = Date.valueOf("2024-08-21");


		Plan p2=new Plan();
		p2.setPid(1);
		customer.setPlan(p2);
		
		List<Customer> custlst = new ArrayList<>();
		custlst.add(customer);
		custlst.add(customer1);
		Mockito.when(customerdao.findByRegisterDateBetween(startSqlDate,endSqlDate)).thenReturn(custlst);
		Assert.assertEquals(customerservice.getCustomersRegisteredBetween(Date.valueOf("2023-09-22"),Date.valueOf("2024-08-21")), custlst);
		
	}
	
	@Test
	public void getCustomersByPlantest() {
		Customer customer=new Customer();//getCustomers
		customer.setCid(1);
		customer.setCname("havela");
		customer.setEmail("havela@gmail.com");
		customer.setLocation("hyd");
		customer.setPhn("8634872332");
		Plan p1=new Plan();
		p1.setPid(1);
		customer.setPlan(p1);
		
		Customer customer1=new Customer();//getCustomers
		customer1.setCid(3);
		customer1.setCname("raju");
		customer1.setEmail("raj@gmail.com");
		customer1.setLocation("dehradun");
		customer1.setPhn("8722573332");
		Plan p2=new Plan();
		p2.setPid(1);
		customer.setPlan(p2);
		
		List<Customer> custlst = new ArrayList<>();
		custlst.add(customer);
		custlst.add(customer1);

		Mockito.when(customerdao.findCustomerByPlan(3)).thenReturn(custlst);
		Assert.assertEquals(customerservice.getCustomersByPlan(3), custlst);
	}
}

