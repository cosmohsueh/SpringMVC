package com.FlySheet.SignUp.notice;

import java.text.ParseException;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.Applicants;
import data.NoticeTemplate;

public class NoticesHandler {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticesHandler.class);
    
    private final Scheduler scheduler;
    
    public NoticesHandler() throws SchedulerException {
        this.scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
    }
    
    public void addJobNotice(NoticeTemplate noticeTemp, Applicants applicants)
        throws SchedulerException, ParseException, ClassNotFoundException, java.lang.InstantiationException,
        IllegalAccessException {
        JobDetail jobDetail = JobBuilder
                .newJob(EmailJob.class)
                .withIdentity("job_" + noticeTemp.getSessionId() + 
                        "_" + noticeTemp.getNoticeType() + 
                        "_" + applicants.getApplicantsId(), "group")
                .build();
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger_"+ noticeTemp.getSessionId() + 
                        "_" + noticeTemp.getNoticeType() + 
                        "_" + applicants.getApplicantsId(),"group")
                .startNow()
                .build();
        
        jobDetail.getJobDataMap().put("noticeTemp", noticeTemp);
        jobDetail.getJobDataMap().put("applicants", applicants);
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
