package com.FlySheet.SignUp.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.FlySheet.SignUp.dao.NoticeLogDAO;
import com.FlySheet.SignUp.dao.NoticeTemplateDAO;
import com.FlySheet.SignUp.model.NOTICETYPE;
import com.FlySheet.SignUp.model.TemplateModel;
import com.FlySheet.SignUp.notice.NoticesHandler;

import data.Applicants;
import data.NoticeTemplate;
import data.Sessions;

public class NoticeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeService.class);

	@Autowired
	private SessionsService sessionsService;
	@Autowired
	private ApplicantsService applicantsService;
	@Autowired
	private NoticeTemplateDAO noticeTemplateDAO;
	@Autowired
	private NoticeLogDAO noticeLogDAO;
	@Autowired
	private NoticesHandler noticesHandler;
	
	public static SimpleDateFormat formaterForwardSlash = new SimpleDateFormat("yyyyMMdd");
	
	public List<NoticeTemplate> findAll(){
		try {
			return noticeTemplateDAO.findAll();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public List<TemplateModel> findTemplateModelView(){
		try {
			return noticeTemplateDAO.findTemplateModelView();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public NoticeTemplate findTemplateById(Integer noticeId){
		try {
			return noticeTemplateDAO.findByNoticeId(noticeId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public void saveTemplate(NoticeTemplate noticeTemplate){
		if(noticeTemplate.getNoticeId() == null){
			noticeTemplateDAO.save(noticeTemplate);
		}else {
			noticeTemplateDAO.update(noticeTemplate);
		}
	}
	
	public void sendNotice(){
		List<Sessions> sessionsList = sessionsService.findAll();
		if(sessionsList != null && sessionsList.size() > 0){
			for(Sessions sessions: sessionsList){
				String today = formaterForwardSlash.format(new Date());
				String enrollDate = formaterForwardSlash.format(sessions.getEnrollNotice());
				String dueDate = formaterForwardSlash.format(sessions.getDueNotice());
				if(today.equals(enrollDate)){
					sendNoticeByEnroll(sessions);
					sendNoticeByNotEnroll(sessions);
				}
				if(today.equals(dueDate)){
					sendNoticeByDue(sessions);
				}
			}
		}
	}
	
	private void sendNoticeByEnroll(Sessions sessions){
		try {
			NoticeTemplate enrollTemp = noticeTemplateDAO.findBySessionIdAndNoticeType(sessions.getSessionsId(), 2);
			if(enrollTemp != null){
				sendNotice(enrollTemp, true);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	private void sendNoticeByNotEnroll(Sessions sessions){
		try {
			NoticeTemplate notenrollTemp = noticeTemplateDAO.findBySessionIdAndNoticeType(sessions.getSessionsId(), 3);
			if(notenrollTemp != null){
				sendNotice(notenrollTemp, false);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	private void sendNoticeByDue(Sessions sessions){
		try {
			NoticeTemplate dueTemp = noticeTemplateDAO.findBySessionIdAndNoticeType(sessions.getSessionsId(), 4);
			if(dueTemp != null){
				sendNotice(dueTemp, true);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	private void sendNotice(NoticeTemplate noticeTemp, Boolean confirm){
		List<Applicants> appList = null;
		if(confirm == null){
			appList = applicantsService.findApplicantsBySessionsId(noticeTemp.getSessionId());
		}else{
			appList = applicantsService.findApplicantsBySessionsId(noticeTemp.getSessionId(), confirm);
		}
		if(appList != null && appList.size() > 0){
			for(Applicants app: appList){
				try {
					noticesHandler.addJobNotice(noticeTemp, app);
				} catch (ClassNotFoundException e) {
					LOGGER.error(e.getMessage(), e);
				} catch (InstantiationException e) {
					LOGGER.error(e.getMessage(), e);
				} catch (IllegalAccessException e) {
					LOGGER.error(e.getMessage(), e);
				} catch (SchedulerException e) {
					LOGGER.error(e.getMessage(), e);
				} catch (ParseException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
	}
	
	public void resendNotice(NoticeTemplate noticeTemp){
		if(NOTICETYPE.B.getCode().compareTo(noticeTemp.getNoticeType()) == 0
				|| NOTICETYPE.D.getCode().compareTo(noticeTemp.getNoticeType()) == 0){
			sendNotice(noticeTemp, true);
		}else if(NOTICETYPE.C.getCode().compareTo(noticeTemp.getNoticeType()) == 0){
			sendNotice(noticeTemp, false);
		}
	}
}
