package com.tsy.cl.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 			验证码工具类
 * @author Administrator
 *
 */
@WebServlet("/page/admin/login/codeUtil")
public class CodeUtil extends HttpServlet{

	private  char[]  codes="abcdefghijkmnpqrstuvwyzxABCDEFGHJKLMNPQRSTUVWYZX23456789".toCharArray();

	private  Random  random = new Random();

	public  String getCode(){

		StringBuffer stringBuffer=new StringBuffer();

		for (int i = 0; i < 4; i++) {

			stringBuffer.append(codes[random.nextInt(codes.length)]);
		}

		return stringBuffer.toString();

	}


	/*public static void main(String[] args) throws Exception {

		//1.创建画布
		BufferedImage bufferedImage = new BufferedImage(120, 32, BufferedImage.TYPE_INT_RGB);

		//2.创建画笔
		Graphics2D graphics2d = bufferedImage.createGraphics();

		//4.设置画笔颜色
		graphics2d.setColor(new Color(26, 128, 203));

		//5.设置背景颜色
		graphics2d.fillRect(0, 0, 120,32);

		graphics2d.setColor(new Color(255, 255, 255));

		//6.设置字体
		graphics2d.setFont(new Font("Dope Crisis", Font.PLAIN,22));

		String code = getCode();

		//3.写内容
		graphics2d.drawString(code, 35, 20);

		//4.保存验证码到磁盘
		ImageIO.write(bufferedImage, "JPEG", new File("C:\\abc.jpg"));
	}*/

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1.创建画布
		BufferedImage bufferedImage = new BufferedImage(120, 32, BufferedImage.TYPE_INT_RGB);

		//2.创建画笔
		Graphics2D graphics2d = bufferedImage.createGraphics();

		//4.设置画笔颜色
		graphics2d.setColor(new Color(26, 128, 203));

		//5.设置背景颜色
		graphics2d.fillRect(0, 0, 120,32);

		graphics2d.setColor(new Color(255, 255, 255));

		//6.设置字体
		graphics2d.setFont(new Font("Dope Crisis", Font.PLAIN,22));

		String code = getCode();
		
		req.getSession().setAttribute("realcode", code);

		//3.写内容
		graphics2d.drawString(code, 35, 20);

		//4.响应验证码到页面
		ImageIO.write(bufferedImage, "JPEG", resp.getOutputStream());
	}


}
