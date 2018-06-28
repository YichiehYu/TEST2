//package com.blogfav.controller;
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
//
//public class BlogFavServlet extends HttpServlet {
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
//				BlogFavService Svc = new BlogFavService();
//				String mebId = null;
//				BlogFavVO blogfavVO = Svc.getOneBlogFav(mebId);
//			
//			
//				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
//				req.setAttribute("blogfavVO", blogfavVO); 
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
//		
//		if ("getOneBlogFav_For_Display".equals(action)) {
//
//						
//
//						try {
//							/*************************** 1.接收請求參數 ****************************************/
//							String mebId = new String(req.getParameter("mebId"));
//
//							/*************************** 2.開始查詢資料 ****************************************/
//							BlogFavService Svc = new BlogFavService();
//							String mem_id = null;
//							List<BlogFavVO> list = Svc.getOneBlogFavAll(mem_id);
//							req.setAttribute("list", list);
//							String url = "/information11.jsp";
//							RequestDispatcher successView = req.getRequestDispatcher(url);
//							successView.forward(req, res);
//							
////							/*************************** 其他可能的錯誤處理 *************************************/
//						} catch (Exception e) {
//							List errorMsgs = null;
//							errorMsgs.add("無法取得資料:" + e.getMessage());
//							RequestDispatcher failureView = req.getRequestDispatcher("/information11.jsp");
//							failureView.forward(req, res);
//						}
//					}
//			
//	}
//}
