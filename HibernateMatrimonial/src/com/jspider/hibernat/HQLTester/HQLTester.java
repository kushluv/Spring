package com.jspider.hibernat.HQLTester;

import java.util.List;

import com.jspider.hibernat.DAO.matrimonyDAO;
import com.jspider.hibernat.DTO.MatrimonyDTO;

public class HQLTester {
	public static void main(String[] args) {
		MatrimonyDTO dto = new MatrimonyDTO();
		dto.setName("MR.Akhilesh");
		dto.setpAge(23);
		dto.setQualification("B.Tech");
		matrimonyDAO dao = new matrimonyDAO();
		/*Without using HQL query
		
		// Insert data
		dao.SaveData(dto);
		
		
		// Fetch data
		String st = dao.getData(1);
		System.out.println(st);
		
		
		// Update Data
		dao.updateData(1, "Mr.Kush");
		System.out.println(dao.getData(1));
		
		
		//Delete Data
		dao.deletData(3);
		System.out.println(dao.getData(3));
		
		*/
		
		/*//fetch data using HQl query
		System.out.println(dao.getPersonName(1));
		
		Object[] dto2=dao.getAgeandnameById(1);
		
		
		System.out.println(dto2[0]+"...."+dto2[1]);*/
		
		//Fetch data from a column 
		/*MatrimonyDTO dto3=dao.getAgeByname("luv");
		System.out.println(dto3.getName()+"..."+dto3.getpAge()+"......"+dto3.getpId()+"....."+dto3.getQualification());*/
		
		
	}
}
