package com.follow.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dept.model.DeptService;
import com.emp.model.EmpVO;
import com.follow.model.FollowService;
import com.follow.model.FollowVO;


		
public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  public FollowServlet() {
	        super();
	    }
	  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");
			
//			if ("getOne_For_Display".equals(action)) {
//
//				List errorMsgs = (List) new LinkedList<String>();
//				// Store this set in the request scope, in case we need to
//				// send the ErrorPage view.
//				req.setAttribute("errorMsgs", errorMsgs);
//
//				try {
//
//					/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//					String mebId = req.getParameter("mebId");
//					System.out.println(mebId + "=====");
//
//					/*************************** 2.開始查詢資料 *****************************************/
//					FollowService fSvc = new FollowService();
//					FollowVO followVO = fSvc.getOneFollow(mebId);
//
//					req.setAttribute("followVO", followVO);
//					String url = "/information11.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url);
//					successView.forward(req, res);
//
//					/*************************** 其他可能的錯誤處理 *************************************/
//				} catch (Exception e) {
//					((LinkedList<String>) errorMsgs).add("無法取得資料:" + e.getMessage());
//					RequestDispatcher failureView = req.getRequestDispatcher("/information11.jsp");
//					failureView.forward(req, res);
//				}
//			}
			
			if ("getOne_For_Display".equals(action)) {

				

				try {
					/*************************** 1.接收請求參數 ****************************************/
					String mebIdB = new String(req.getParameter("mebIdB"));
					System.out.println(mebIdB + "mebIdB");
					/*************************** 2.開始查詢資料 ****************************************/
					
					FollowService fSvc = new FollowService();
					List<FollowVO> followerlist = fSvc.getOneFollowAll(mebIdB);
					req.setAttribute("followerlist", followerlist);
					String url = "/information11.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
					
//					/*************************** 其他可能的錯誤處理 *************************************/
				} catch (Exception e) {
					List errorMsgs = null;
					errorMsgs.add("無法取得資料:" + e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/information11.jsp");
					failureView.forward(req, res);
				}
			}
			
	if ("getOne_For_Display".equals(action)) {

				

				try {
					/*************************** 1.接收請求參數 ****************************************/
					String mebIdA = new String(req.getParameter("mebIdA"));
					System.out.println(mebIdA + "mebIdA");
					/*************************** 2.開始查詢資料 ****************************************/
					
					FollowService fedSvc = new FollowService();
					List<FollowVO> followedlist = fedSvc.getOneFollowedAll(mebIdA);
					req.setAttribute("followedlist", followedlist);
					String url = "/information11.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
					
//					/*************************** 其他可能的錯誤處理 *************************************/
				} catch (Exception e) {
					List errorMsgs = null;
					errorMsgs.add("無法取得資料:" + e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/information11.jsp");
					failureView.forward(req, res);
				}
			}
		}
	}
