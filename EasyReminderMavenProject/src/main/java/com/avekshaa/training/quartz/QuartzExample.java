package com.avekshaa.training.quartz;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.avekshaa.traning.mail.SendMailService;

public class QuartzExample {

	public static void main(String[] args) throws Exception {

		try {
			JobDetail job1 = JobBuilder.newJob(SendLoginMailJob.class).withIdentity("sendLoginMailJob", "group1")
					.build();

			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group1")
					.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(30)).build(); 
			Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
			scheduler1.start();
			scheduler1.scheduleJob(job1, trigger1);

			JobDetail job2 = JobBuilder.newJob(SendRegistrationMailJob.class)
					.withIdentity("sendRegistrationMailJob", "group2").build();
			Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("cronTrigger", "group2")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
			Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
			scheduler2.start();
			scheduler2.scheduleJob(job2, trigger2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}