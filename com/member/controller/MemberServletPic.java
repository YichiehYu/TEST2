package com.member.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberService;

@WebServlet("/MemberServletPic")
public class MemberServletPic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("image/gif");
		MemberService memberService = new MemberService();
		ServletOutputStream out = res.getOutputStream();
		String mebId = req.getParameter("mebIdForPic");
//		System.out.println("mebId = " + mebId);
		byte[] pic = memberService.getOneMemberPic(mebId);
		
		if(pic == null) {
			URL u = new URL(req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/img/personalPhotoNotFound.jpg");
			InputStream in = u.openStream();
//			File file = new File("src/3.jpg");
//			FileInputStream fin = new FileInputStream(file);
//			BufferedInputStream in = new BufferedInputStream(fin);
			byte[] buf = new byte[4 * 1024]; // 4K buffer
			int len;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			in.close();
		} else {
			out.write(pic);
		}
		out.flush();
		out.close();
	}
}
