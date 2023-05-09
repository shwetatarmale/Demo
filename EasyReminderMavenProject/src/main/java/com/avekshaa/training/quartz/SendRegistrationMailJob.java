package com.avekshaa.training.quartz;

import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.avekshaa.traning.mail.SendMailService;

public class SendRegistrationMailJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
			SendMailService.sendRegistrationEmail(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}





