//package com.spotfav.controller;
//
//import java.io.*;
//import java.sql.Date;
//import java.util.*;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//import com.dept.model.DeptService;
//import com.emp.model.EmpService;
//import com.emp.model.EmpVO;
//import com.follow.model.FollowService;
//import com.follow.model.FollowVO;
//import com.spotfav.model.SpotFavService;
//import com.spotfav.model.SpotFavVO;
//
//public class SpotFavServlet extends HttpServlet {
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
//				
//				
//				/***************************2.�}�l�d�߸��*****************************************/
//				SpotFavService Svc = new SpotFavService();
//				String mebId = null;
//				SpotFavVO spotfavVO = Svc.getOneSpotFav(mebId);
//				
//				
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
//				req.setAttribute("spotfavVO", spotfavVO); 
//				String url = "/information11.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);
//				successView.forward(req, res);
//
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
//				
//	
//				
//				//�R��
//				if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp
//
//			
//					try {
//						/***************************1.�����ШD�Ѽ�***************************************/
//						String mebIdA  = new String(req.getParameter("mebIdA"));
//						String mebIdB  = new String(req.getParameter("mebIdB"));
//						/***************************2.�}�l�R�����***************************************/
//						FollowService Svc = new FollowService();
//						
//						Svc.deleteFollow(mebIdA, mebIdB);
//						
//						/***************************3.�R������,�ǳ����(Send the Success view)***********/								
//						String url = "/information.jsp";
//						RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
//						successView.forward(req, res);
//						
//						/***************************��L�i�઺���~�B�z**********************************/
//					} catch (Exception e1) {
//						List<String> errorMsgs = null;
//						errorMsgs.add("�R����ƥ���:"+e1.getMessage());
//						RequestDispatcher failureView1 = req
//								.getRequestDispatcher("/information.jsp");
//						failureView1.forward(req, res);
//					}
//				}
//				
//			}
//}
//
//			
//	
//
//			
//		