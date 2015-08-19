package com.FlySheet.SignUp.notice;

import javax.mail.internet.AddressException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.Applicants;
import data.NoticeTemplate;

public class EmailJob implements Job {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			LOGGER.info("Running task..." + arg0.getJobDetail().getKey().getName());
			NoticeTemplate noticeTemp = (NoticeTemplate) arg0.getJobDetail().getJobDataMap().get("noticeTemp");
			Applicants applicants = (Applicants) arg0.getJobDetail().getJobDataMap().get("applicants");
			Emailer emailer = new Emailer();
			emailer.setTo(applicants.getEmail());
			emailer.setSubject(noticeTemp.getSubject());
			emailer.setHtmlTextMessage(noticeTemp.getContent());
            emailer.sendEmail();
		} catch (java.net.ConnectException connException) {
            throw new JobExecutionException(connException);
        } catch (AddressException e) {
            throw new JobExecutionException(e);
        } catch (Exception e) {
            throw new JobExecutionException(e);
        } finally {
        	LOGGER.info("Finish task..." + arg0.getJobDetail().getKey().getName());
        }
	}

}
