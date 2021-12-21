package com.example.servlet_virtual_path_mapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project name(项目名称)：Servlet_Virtual_path_mapping
 * Package(包名): com.example.servlet_virtual_path_mapping
 * Class(类名): MyServlet
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/21
 * Time(创建时间)： 20:23
 * Version(版本): 1.0
 * Description(描述)：
 * Servlet 单一映射
 * Servelt 单一映射是指一个 Servlet 只被映射到一个虚拟路径上。
 * <p>
 * Servlet 单一映射的实现方式有 2 种：
 * 使用 web.xml 实现单一映射；
 * 使用 @WebServlet 实现单一映射。
 */

@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private int initCount = 0;
    private int httpCount = 0;
    private int destoryCount = 0;

    @Override
    public void destroy()
    {
        destoryCount++;
        super.destroy();
        // 向控制台输出destory方法被调用次数
        System.out.println(
                "**********************************destroy方法：" + destoryCount + "*******************************");
    }

    @Override
    public void init() throws ServletException
    {
        initCount++;
        super.init();
        // 向控制台输出init方法被调用次数
        System.out.println("init方法：" + initCount);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        httpCount++;
        // 控制台输出doGet方法次数
        System.out.println("doGet方法：" + httpCount);
        // 设置返回页面格式与字符集
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        // 向页面输出
        writer.write("----单一映射----<br/>");
        writer.write("初始化次数:" + initCount + "<br/>" + "处理请求次数:" + httpCount + "<br/>" + "销毁次数:" + destoryCount);
        writer.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    }
}
