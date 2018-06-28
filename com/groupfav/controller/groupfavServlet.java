//package com.groupfav.controller;
//
//import java.io.*;
//import java.sql.Date;
//import java.util.*;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//import com.blogfav.model.BlogFavService;
//import com.blogfav.model.BlogFavVO;
//import com.dept.model.DeptService;
//import com.emp.model.EmpService;
//import com.emp.model.EmpVO;
//import com.follow.model.FollowService;
//import com.follow.model.FollowVO;
//import com.groupfav.model.GroupFavService;
//import com.groupfav.model.GroupFavVO;
//
//public class groupfavServlet extends HttpServlet {
//
//	private static final String String = null;
//
//	public void doGet(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//		doPost(req, res);
//	}
//
//	public void doPost(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//
//		req.setCharacterEncoding("UTF-8");
//		String action = req.getParameter("action");
//		
//		
//		if ("view".equals(action)) { 
//
//
//			try {
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//				String str = req.getParameter("mebId");
//			
//				/***************************2.�}�l�d�߸��*****************************************/
//			
//				GroupFavService gSvc = new GroupFavService();
//			
//				java.lang.String mem_id = null;
//				GroupFavVO groupfavVO = (GroupFavVO) gSvc.getOneGroupFavAll(mem_id);
//			
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
//				req.setAttribute("groupfavVO", groupfavVO); 
//				String url = "/information11.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);
//				successView.forward(req, res);
//
//				/***************************��L�i�઺���~�B�z*************************************/
//			} catch (Exception e) {
//				List<String> errorMsgs = null;
//				errorMsgs.add("�L�k���o���:" + e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/select_page.jsp");
//				failureView.forward(req, res);
//			}
//		}
//			
//	}
//}
