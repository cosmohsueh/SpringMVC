package com.FlySheet.SignUp.Builder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.FlySheet.SignUp.model.CONFIRM;
import com.FlySheet.SignUp.model.GENDER;
import com.FlySheet.SignUp.model.MEALS;
import com.FlySheet.SignUp.model.PICKUP;
import com.FlySheet.SignUp.model.STAY;
import com.FlySheet.SignUp.service.ActivityService;
import com.FlySheet.SignUp.service.SessionsService;

import data.Activity;
import data.Applicants;
import data.Sessions;

public class ExcelBuilder extends AbstractExcelView{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelBuilder.class);
	
	@Override
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SimpleDateFormat formaterDashTime = new SimpleDateFormat("yyyyMMddHHmmssS");
		String date = formaterDashTime.format(new Date());
		
		response.setHeader("Content-Disposition", "attachment; filename=\"Applicants_" + date + ".xls\"");
		
		List<Applicants> listBooks = (List<Applicants>) model.get("applicantsList");
		ActivityService activityService = (ActivityService) model.get("activityService");
		SessionsService sessionsService = (SessionsService) model.get("sessionsService");
		
		List<Activity> activityList = activityService.findAll();
		List<Sessions> sessionsList = sessionsService.findAll();
		
		HSSFSheet sheet = workbook.createSheet();
		sheet.setDefaultColumnWidth(10);
		
        HSSFRow header = sheet.createRow(0);
        
        header.createCell(0).setCellValue("報名序號");
        header.createCell(1).setCellValue("活動名稱");
        header.createCell(2).setCellValue("場次名稱");
        header.createCell(3).setCellValue("錄取狀態");
        header.createCell(4).setCellValue("姓名");
        header.createCell(5).setCellValue("身份證字號");
        header.createCell(6).setCellValue("服務單位");
        header.createCell(7).setCellValue("職稱");
        header.createCell(8).setCellValue("電話");
        header.createCell(9).setCellValue("手機");
        header.createCell(10).setCellValue("email");
        header.createCell(11).setCellValue("住宿");
        header.createCell(12).setCellValue("接送選項");
        header.createCell(13).setCellValue("性別");
        header.createCell(14).setCellValue("餐別");
        header.createCell(15).setCellValue("報名日期");
        
        int rowCount = 1;
        formaterDashTime = new SimpleDateFormat("yyyy-MM-dd");
        for (Applicants applicants : listBooks) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            
            String activityName = "";
            if(activityList != null && activityList.size() > 0){
            	for(Activity act: activityList){
            		if(act.getActivityId() == applicants.getActivityId()){
            			activityName = act.getActivityName();
            		}
            	}
            }
            
            String sessionsName = "";
            if(sessionsList != null && sessionsList.size() > 0){
            	for(Sessions sess: sessionsList){
            		if(sess.getSessionsId() == applicants.getSessionsId()){
            			sessionsName = sess.getSessionsName();
            		}
            	}
            }
            aRow.createCell(0).setCellValue(applicants.getApplicantsId());
            aRow.createCell(1).setCellValue(activityName);
            aRow.createCell(2).setCellValue(sessionsName);
            aRow.createCell(3).setCellValue(CONFIRM.getReasonByCode(applicants.getConfirm()));
            aRow.createCell(4).setCellValue(applicants.getFullName());
            aRow.createCell(5).setCellValue(applicants.getNationalIdNumber());
            aRow.createCell(6).setCellValue(applicants.getOrganization());
            aRow.createCell(7).setCellValue(applicants.getPosition());
            aRow.createCell(8).setCellValue(applicants.getTel());
            aRow.createCell(9).setCellValue(applicants.getCell());
            aRow.createCell(10).setCellValue(applicants.getEmail());
            aRow.createCell(11).setCellValue(STAY.getReasonByCode(applicants.getStay()));
            aRow.createCell(12).setCellValue(PICKUP.getReasonByCode(applicants.getPickUp()));
            aRow.createCell(13).setCellValue(GENDER.getReasonByCode(applicants.getGender()));
            aRow.createCell(14).setCellValue(MEALS.getReasonByCode(applicants.getMeals()));
            aRow.createCell(15).setCellValue(formaterDashTime.format(applicants.getApplicantsDate()));
        }
	}

}
