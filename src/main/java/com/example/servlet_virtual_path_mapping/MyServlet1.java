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
 * Class(类名): MyServlet1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/21
 * Time(创建时间)： 20:27
 * Version(版本): 1.0
 * Description(描述)：
 * Servlet 多重映射
 * Servlet 的多重映射是指一个 Servlet 可以被映射到多个虚拟路径上。此时，客户端可以通过多个路径实现对同一个 Servlet 的访问。
 * Servlet 多重映射的实现方式有 3 种：
 * 配置多个 <servlet-mapping> 元素。
 * 配置多个 <url-pattern> 子元素。
 * 在 @WebServlet 的 urlPatterns 属性中使用字符串数组
 */

@WebServlet(urlPatterns = { "/MyServlet5", "/MyServlet6" })
public class MyServlet1 extends HttpServlet
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
        writer.write("----多重映射----<br/>");
        writer.write("初始化次数:" + initCount + "<br/>" + "处理请求次数:" + httpCount + "<br/>" + "销毁次数:" + destoryCount);
        writer.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    }
}
