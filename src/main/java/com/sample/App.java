package com.sample;

import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		try{

			KieServices kieServices=KieServices.Factory.get();
			KieContainer kieContainer=kieServices.getKieClasspathContainer();
			System.out.println("kieServices.getKieClasspathContainer()"+kieServices.getKieClasspathContainer());
			KieSession kieSession=kieContainer.newKieSession("ksession-rules");

			System.out.println("kieSession"+kieSession.toString());

			//System.out.println("kieSession"+kieSession.getId());
			Timesheet timesheet=new Timesheet();
			timesheet.setName("asha");
			timesheet.setHours(5);
			
			
			//System.out.println("timesheet"+timesheet.getHours()+""+timesheet.getName());

			kieSession.insert(timesheet);

			kieSession.fireAllRules();
			Timesheet timesheet2=new Timesheet();
			
			timesheet2.setName("shilpa");

			kieSession.insert(timesheet2);

			kieSession.fireAllRules();			
			System.out.println("final payment status"+timesheet.getSalary());
		}
		catch(Throwable t){
			t.printStackTrace();
		}

	}

	/*private  static Timesheet getTimesheetvalues(){
		Timesheet timesheet=new Timesheet();
		timesheet.setHours(5);
		timesheet.setName("shilpa");
		timesheet.setSalary(10000);
		return timesheet;
	}*/
}
