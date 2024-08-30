package com.vericomm.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vericomm.dao.PlanDao;
import com.vericomm.model.Plan;
import com.vericomm.service.PlanService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlanServiceTest {
	@MockBean
	private PlanDao plandao;
	@Autowired
	private PlanService planservice;

	@Test
	public void getPlanstest() {
		// fail("Not yet implemented");
		Plan plan = new Plan();
		plan.setCost(300f);
		plan.setDurationInMins(350);
		plan.setPid(6);
		plan.setPname("lion");
		plan.setValidity(30);

		Plan plan1 = new Plan();
		plan1.setCost(360f);
		plan1.setDurationInMins(480);
		plan1.setPid(8);
		plan1.setPname("lionking");
		plan1.setValidity(60);

		List<Plan> planlst = new ArrayList<>();
		planlst.add(plan);
		planlst.add(plan1);

		Mockito.when(plandao.findAll()).thenReturn(planlst);
		Assert.assertEquals(planservice.getPlans(), planlst);
	}

	@Test
	public void getPlanBelowThisCostTest() {
		Plan plan2 = new Plan();
		plan2.setCost(345f);
		plan2.setDurationInMins(320);
		plan2.setPid(9);
		plan2.setPname("lionsuper");
		plan2.setValidity(45);
		
		Plan plan3 = new Plan();
		plan3.setCost(345f);
		plan3.setDurationInMins(320);
		plan3.setPid(9);
		plan3.setPname("lionsuper");
		plan3.setValidity(45);
		List<Plan> planlst = new ArrayList<>();
		planlst.add(plan2);
		planlst.add(plan3);
		

		Mockito.when(plandao.findPlanBelowThisCost(400f)).thenReturn(planlst);
		Assert.assertEquals(planservice.getPlanBelowThisCost(400f), planlst);

	}
	
	@Test
	public void getPlansByCostRangeAndValidityTest()
	{
		Plan plan4 = new Plan();
		plan4.setCost(445f);
		plan4.setDurationInMins(220);
		plan4.setPid(10);
		plan4.setPname("lionper");
		plan4.setValidity(43);
		
		Plan plan6 = new Plan();
		plan6.setCost(32f);
		plan6.setDurationInMins(310);
		plan6.setPid(9);
		plan6.setPname("lier");
		plan6.setValidity(23);
		List<Plan> planlst = new ArrayList<>();
		planlst.add(plan4);
		planlst.add(plan6);
		

		Mockito.when(plandao.findPlansByCostRangeAndValidity(400f,3000f,60)).thenReturn(planlst);
		Assert.assertEquals(planservice.getPlansByCostRangeAndValidity(400f,3000f,60), planlst);
	}
	
	@Test
	public void getPlansByValidityTest()
	{
		Plan plan4 = new Plan();
		plan4.setCost(405f);
		plan4.setDurationInMins(20);
		plan4.setPid(190);
		plan4.setPname("liomjhcgnper");
		plan4.setValidity(63);
		
		Plan plan6 = new Plan();
		plan6.setCost(326f);
		plan6.setDurationInMins(10);
		plan6.setPid(95);
		plan6.setPname("lischger");
		plan6.setValidity(253);
		List<Plan> planlst = new ArrayList<>();
		planlst.add(plan4);
		planlst.add(plan6);
		

		Mockito.when(plandao.findPlansByValidity(60)).thenReturn(planlst);
		Assert.assertEquals(planservice.getPlansByValidity(60), planlst);

	}
}
