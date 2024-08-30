package com.vericomm.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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

import com.vericomm.dao.CallDao;
import com.vericomm.dao.PlanDao;
import com.vericomm.model.Call;
import com.vericomm.model.Customer;
import com.vericomm.model.Plan;
import com.vericomm.service.CallService;
import com.vericomm.service.PlanService;
@RunWith(SpringRunner.class)
@SpringBootTest
class CallServiceTest {
	
	@MockBean
	private CallDao calldao;
	@Autowired
	private CallService callservice;
	@Test
	public void getCallRecordstest() {
		Call call=new Call();
		call.setCallId(201);
		Customer c1=new Customer();
		c1.setCid(1);
		call.setCustomer(c1);
		Plan p1=new Plan();
		p1.setPid(1);
		call.setPlan(p1);
		call.setDuration(30);
		call.setFrom("8763538643");
		call.setTo("183678223");
		
		Call call1=new Call();
		call1.setCallId(201);
		Customer c2=new Customer();
		c2.setCid(2);
		call1.setCustomer(c2);
		Plan p2=new Plan();
		p2.setPid(2);
		call1.setPlan(p2);
		call1.setDuration(30);
		call1.setFrom("983282572");
		call1.setTo("883563562");
		
		List<Call> calllst = new ArrayList<>();
		calllst.add(call);
		calllst.add(call1);

		Mockito.when(calldao.findAll()).thenReturn(calllst);
		Assert.assertEquals(callservice.getCallRecords(), calllst);
		
		
		
	}

	@Test
	public void getCallsByCustomerIdtest() {
		Call call=new Call();
		call.setCallId(201);
		Customer c1=new Customer();
		c1.setCid(1);
		call.setCustomer(c1);
		Plan p1=new Plan();
		p1.setPid(1);
		call.setPlan(p1);
		call.setDuration(30);
		call.setFrom("8763538643");
		call.setTo("183678223");
		
		Call call1=new Call();
		call1.setCallId(201);
		Customer c2=new Customer();
		c2.setCid(2);
		call1.setCustomer(c2);
		Plan p2=new Plan();
		p2.setPid(2);
		call1.setPlan(p2);
		call1.setDuration(30);
		call1.setFrom("983282572");
		call1.setTo("883563562");
		
		List<Call> calllst = new ArrayList<>();
		calllst.add(call);
		calllst.add(call1);

		Mockito.when(calldao.findCallsByCustomerId(2)).thenReturn(calllst);
		Assert.assertEquals(callservice.getCallsByCustomerId(2), calllst);
		
	}
	@Test
	public void getTotalCallDurationByCustomerIdtest() {
		Call call=new Call();
		call.setCallId(201);
		Customer c1=new Customer();
		c1.setCid(1);
		call.setCustomer(c1);
		Plan p1=new Plan();
		p1.setPid(1);
		call.setPlan(p1);
		call.setDuration(30);
		call.setFrom("8763538643");
		call.setTo("183678223");
		
		
		Call call2=new Call();
		call2.setCallId(201);
		Customer c3=new Customer();
		c3.setCid(1);
		call.setCustomer(c1);
		Plan p3=new Plan();
		p1.setPid(1);
		call2.setPlan(p3);
		call2.setDuration(30);
		call2.setFrom("8763538643");
		call2.setTo("183678223");

		Call call1=new Call();
		call1.setCallId(202);
		Customer c2=new Customer();
		c2.setCid(2);
		call1.setCustomer(c2);
		Plan p2=new Plan();
		p2.setPid(2);
		call1.setPlan(p2);
		call1.setDuration(30);
		call1.setFrom("983282572");
		call1.setTo("883563562");
		
		List<Call> calllst = new ArrayList<>();
		calllst.add(call);
		calllst.add(call2);
		
		calllst.add(call1);
		

        Mockito.when(calldao.findTotalCallDurationByCustomerId(201)).thenReturn((call.getDuration()));

        Assert.assertEquals(callservice.getTotalCallDurationByCustomerId(1), call);

		//Mockito.when(calldao.findTotalCallDurationByCustomerId(3)).thenReturn(calllst);
		//Assert.assertEquals(callservice.getTotalCallDurationByCustomerId(3), calllst);
		
	}
}
