package com.member.controller;

import java.io.*;
import java.sql.Date;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.dept.model.DeptService;
import com.emp.model.*;
import com.follow.model.FollowService;
import com.follow.model.FollowVO;
import com.member.model.MemberService;
import com.member.model.MemberVO;

public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {

				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String mebId = req.getParameter("mebId");
				System.out.println(mebId + "=====");

				/*************************** 2.開始查詢資料 *****************************************/
				MemberService Svc = new MemberService();
				MemberVO memberVO = Svc.getOneMember(mebId);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("memberVO", memberVO);
				String url = "/information11.jsp";

				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/information11.jsp");
				failureView.forward(req, res);
			}
			
			if ("update".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp 的請求

				List<String> errorMsgs1 = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs1);
				
				try {
					/***************************1.接收請求參數****************************************/
					String mebId = new String(req.getParameter("mebId"));
					
					/***************************2.開始查詢資料****************************************/
					MemberService memberSvc = new MemberService();
					MemberVO memberVO = memberSvc.getOneMember("mebId");
									
					/***************************3.查詢完成,準備轉交(Send the Success view)************/
					req.setAttribute("memberVO", memberVO); // 資料庫取出的empVO物件,存入req
					String url = "/information11.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emp_input.jsp
					successView.forward(req, res);

					/***************************其他可能的錯誤處理************************************/
				} catch (Exception e) {
					throw new ServletException(e);
				}
			}
			
			if("changeInfo".equals(action)){
				MemberService memberService =  new MemberService();
				MemberVO memberVO = memberService.getOneMember((String) req.getParameter("mebId"));
				java.sql.Date date = java.sql.Date.valueOf(req.getParameter("mebBirthday"));
				MemberService memberSvc = new MemberService();
				memberSvc.updateMember(
						req.getParameter("mebId"), 
						memberVO.getEmail(), 
						memberVO.getMebPass(), 
						req.getParameter("mebName"), 
						memberVO.getGender(), 
						req.getParameter("mebTEL"), 
						date, 
						memberVO.getIntro(), 
						memberVO.getReported(), 
						memberVO.getMebStatus(), 
						memberVO.getMebPortrait());
			}
			
			if("changeIntr".equals(action)){
				MemberService memberService =  new MemberService();
				MemberVO memberVO = memberService.getOneMember((String) req.getParameter("mebId"));
				MemberService memberSvc = new MemberService();
				memberSvc.updateMember(
						req.getParameter("mebId"), 
						memberVO.getEmail(), 
						memberVO.getMebPass(), 
						memberVO.getMebName(), 
						memberVO.getGender(), 
						memberVO.getTel(), 
						memberVO.getBirthday(), 
						req.getParameter("mebIntr"), 
						memberVO.getReported(), 
						memberVO.getMebStatus(), 
						memberVO.getMebPortrait());
			}
			if("changPic".equals(action)){
				MemberService memberService =  new MemberService();
				MemberVO memberVO = memberService.getOneMember((String) req.getParameter("mebId"));
				MemberService memberSvc = new MemberService();
				InputStream is = req.getPart("newPic").getInputStream();
				byte[] buffer = new byte[is.available()];
				is.read(buffer);
				memberSvc.updateMember(
						req.getParameter("mebId"), 
						memberVO.getEmail(), 
						memberVO.getMebPass(), 
						memberVO.getMebName(), 
						memberVO.getGender(), 
						memberVO.getTel(), 
						memberVO.getBirthday(), 
						memberVO.getIntro(), 
						memberVO.getReported(), 
						memberVO.getMebStatus(), 
						buffer);
			}
		}
		
		// if("changPic".equals(action)){
		// MemberService memberService = new MemberService();
		// MemberVO memberVO = memberService.getOneMember((String)
		// req.getParameter("mebId"));
		// MemberService memberSvc = new MemberService();
		// InputStream is = req.getPart("newPic").getInputStream();
		// byte[] buffer = new byte[is.available()];
		// is.read(buffer);
		// memberSvc.updateMember(
		// req.getParameter("mebId"),
		// memberVO.getEmail(),
		// memberVO.getMebPass(),
		// memberVO.getMebName(),
		// memberVO.getGender(),
		// memberVO.getTel(),
		// memberVO.getBirthday(),
		// memberVO.getIntro(),
		// memberVO.getReported(),
		// memberVO.getMebStatus(),
		// buffer);
		// }
		// }
		//
		// if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
		//
		// List<String> errorMsgs = new LinkedList<String>();
		// // Store this set in the request scope, in case we need to
		// // send the ErrorPage view.
		// req.setAttribute("errorMsgs", errorMsgs);
		//
		// try {
		// /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
		// String mebId = new String(req.getParameter("mebId").trim());
		//
		// java.sql.Date birthday = null;
		// try {
		// birthday = java.sql.Date.valueOf(req.getParameter("birthday").trim());
		// } catch (IllegalArgumentException e) {
		// birthday=new java.sql.Date(System.currentTimeMillis());
		// errorMsgs.add("此為必填欄位。");
		// }
		//
		// String email = null;
		// try {
		// email = new String(req.getParameter("email").trim());
		// } catch (NumberFormatException e) {
		// email = null;
		// errorMsgs.add("此為必填欄位。");
		// }
		//
		// String mebPass = null;
		// try {
		// mebPass = new String(req.getParameter("mebPass").trim());
		// } catch (NumberFormatException e) {
		// mebPass = null;
		// errorMsgs.add("此為必填欄位。");
		// }
		//
		// Integer gender = null;
		// try {
		// gender = new Integer(req.getParameter("gender").trim());
		// } catch (NumberFormatException e) {
		// gender = null;
		// errorMsgs.add("此為必填欄位。");
		// }
		//
		// String mebName = null;
		// try {
		// mebName = new String(req.getParameter("mebName").trim());
		// } catch (NumberFormatException e) {
		// mebName = null;
		// errorMsgs.add("此為必填欄位。");
		// }
		//
		// String tel = null;
		// try {
		// tel = new String(req.getParameter("tel").trim());
		// } catch (NumberFormatException e) {
		// tel = null;
		// errorMsgs.add("此為必填欄位。");
		// }
		//
		//
		// String mebId1 = new String(req.getParameter("mebId").trim());
		//
		// MemberVO memberVO = new MemberVO();
		// memberVO.setMebId(mebId);
		// memberVO.setEmail(email);
		// memberVO.setMebPass(mebPass);
		// memberVO.setMebName(mebName);
		// memberVO.setGender(gender);
		// memberVO.setTel(tel);
		// memberVO.setBirthday(birthday);
		//
		// String tel = req.getParameter("tel");
		// String birthday = req.getParameter("birthday");
		//
		//
		//
		//
		// // Send the use back to the form, if there were errors
		// if (!errorMsgs.isEmpty()) {
		// req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
		// RequestDispatcher failureView = req
		// .getRequestDispatcher("/emp/update_emp_input.jsp");
		// failureView.forward(req, res);
		// return; //程式中斷
		// }
		//
		// /***************************2.開始修改資料*****************************************/
		// EmpService empSvc = new EmpService();
		// empVO = empSvc.updateEmp(empno, ename, job, hiredate, sal,comm, deptno);
		//
		// /***************************3.修改完成,準備轉交(Send the Success view)*************/
		// req.setAttribute("empVO", empVO); // 資料庫update成功後,正確的的empVO物件,存入req
		// String url = "/emp/listOneEmp.jsp";
		// RequestDispatcher successView = req.getRequestDispatcher(url); //
		// 修改成功後,轉交listOneEmp.jsp
		// successView.forward(req, res);
		//
		// /***************************其他可能的錯誤處理*************************************/
		// } catch (Exception e) {
		// errorMsgs.add("修改資料失敗:"+e.getMessage());
		// RequestDispatcher failureView = req
		// .getRequestDispatcher("/emp/update_emp_input.jsp");
		// failureView.forward(req, res);
		// }
		// }
	}
}
