package com.blog.control;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@WebServlet("/servlet/ImgServlet")
public class ImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	BufferedImage bfi = new BufferedImage(100, 34, BufferedImage.TYPE_INT_RGB); //图像缓冲区
        Graphics g = bfi.getGraphics();
        //画背景框
        Color color = new Color(190, 250, 220);
        g.setColor(color);
        g.fillRect(0, 0, 100, 34);
        g.setFont(new Font("Roman", Font.PLAIN, 20));
        //第一个数字
        Random r = new Random();
        int tmp1 = r.nextInt(20);
        g.setColor(new Color(r.nextInt(100),r.nextInt(100),r.nextInt(100))); //设置随机颜色
        g.drawString(tmp1+"",5, 22);
        //加号
        g.setColor(new Color(r.nextInt(100),r.nextInt(100),r.nextInt(100))); //设置随机颜色
        g.drawString("+",30, 22);
        //第二个数字
        int tmp2 = r.nextInt(20);
        g.setColor(new Color(r.nextInt(100),r.nextInt(100),r.nextInt(100))); //设置随机颜色
        g.drawString(tmp2+"",50, 22);
        //等号
        g.setColor(new Color(r.nextInt(100),r.nextInt(100),r.nextInt(100))); //设置随机颜色
        g.drawString("=",75, 22);
        //问号
        g.setColor(new Color(r.nextInt(100),r.nextInt(100),r.nextInt(100))); //设置随机颜色
        g.drawString("?", 85, 22);
        //保存到session
        int result = tmp1+tmp2;
        request.getSession().setAttribute("VerifyCode", result+"");
        
        drawLine(bfi);
        //写入response输出流
        ImageIO.write(bfi, "JPEG", response.getOutputStream());
        
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    
    private Color randomColor() {
    	Random r = new Random();
        int red = r.nextInt(150);
        int green = r.nextInt(150);
        int blue = r.nextInt(150);
        return new Color(red, green, blue);
    }
    
    private  void drawLine(BufferedImage image) {
        int num = 5;// 一共画5条
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        Random r = new Random();
        for (int i = 0; i < num; i++) {// 生成两个点的坐标，即4个值
            int x1 = r.nextInt(68);
            int y1 = r.nextInt(30);
            int x2 = r.nextInt(68);
            int y2 = r.nextInt(30);
            g2.setStroke(new BasicStroke(0.2F));
            g2.setColor(randomColor()); // 随机生成干扰线颜色
            g2.drawLine(x1, y1, x2, y2);// 画线
        }
    }
}
