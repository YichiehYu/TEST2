package com.member.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberService;

@WebServlet("/MemberServletPic1")
public class MemberServletPic1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		MemberService memberService = new MemberService();
		ServletOutputStream out = res.getOutputStream();
		String mebId = req.getParameter("mebIdForPic1");
		BufferedInputStream bis = new BufferedInputStream(memberService.getOneMemberPic1(mebId));
		byte[] buf = new byte[4*1024];
		int len;
		while((len = bis.read(buf)) != -1){
			out.write(buf, 0, len);
		}
		out.flush();
		out.close();
		bis.close();
	}
}
