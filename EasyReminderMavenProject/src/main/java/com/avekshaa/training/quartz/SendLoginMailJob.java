package com.avekshaa.training.quartz;

import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.avekshaa.traning.mail.SendMailService;

public class SendLoginMailJob implements Job{
	public void execute(JobExecutionContext context) throws JobExecutionException {
        SendMailService.sendLoginEmail();
       
    }

}
