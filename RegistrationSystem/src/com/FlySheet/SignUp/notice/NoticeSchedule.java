package com.FlySheet.SignUp.notice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.FlySheet.SignUp.service.NoticeService;

public class NoticeSchedule {

	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeSchedule.class);
	
	@Autowired
	private NoticeService noticeService;
	
	public void sendNotice(){
		LOGGER.debug("sendNotice Start: " + new Date());
		noticeService.sendNotice();
		LOGGER.debug("sendNotice End: " + new Date());
	}
}
