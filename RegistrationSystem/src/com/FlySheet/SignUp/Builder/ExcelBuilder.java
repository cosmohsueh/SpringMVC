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

import com.FlySheet.SignUp.model.GENDER;
import com.FlySheet.SignUp.model.MEALS;
import com.FlySheet.SignUp.model.PICKUP;
import com.FlySheet.SignUp.model.STAY;

import data.Applicants;

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
		
		HSSFSheet sheet = workbook.createSheet();
		sheet.setDefaultColumnWidth(10);
		
        HSSFRow header = sheet.createRow(0);
        
        header.createCell(0).setCellValue("");
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
            aRow.createCell(0).setCellValue(applicants.getApplicantsId());
            aRow.createCell(1).setCellValue(applicants.getActivityId());
            aRow.createCell(2).setCellValue(applicants.getSessionsId());
            aRow.createCell(3).setCellValue(applicants.getConfirm());
            aRow.createCell(4).setCellValue(applicants.getFullName());
            aRow.createCell(5).setCellValue(applicants.getNationalIdNumber());
            aRow.createCell(6).setCellValue(applicants.getOrganization());
            aRow.createCell(7).setCellValue(applicants.getPosition());
            aRow.createCell(8).setCellValue(applicants.getTel());
            aRow.createCell(9).setCellValue(applicants.getCell());
            aRow.createCell(10).setCellValue(applicants.getEmail());
            aRow.createCell(11).setCellValue(STAY.valueOf(applicants.getStay()).getReason());
            aRow.createCell(12).setCellValue(PICKUP.valueOf(applicants.getPickUp()).getReason());
            aRow.createCell(13).setCellValue(GENDER.valueOf(applicants.getGender()).getReason());
            aRow.createCell(14).setCellValue(MEALS.valueOf(applicants.getMeals()).getReason());
            aRow.createCell(15).setCellValue(formaterDashTime.format(applicants.getApplicantsDate()));
        }
	}

}
