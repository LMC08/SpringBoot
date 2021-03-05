package com.example.demo.controller;

import com.example.demo.pdf.CreatePdfTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName: JspController
 * @Description:
 * @Author liminchuan
 * @Date:Create： 2021/3/4 9:00
 */

@Controller
public class JspController {

    // 从 application.yml 中读取配置，如取不到默认值为Hello Jsp
    @Value("${application.hello:liminchuan1：Hello Jsp}")
    private String hello;

    /**
     * 默认页<br/>
     * @RequestMapping("/") 和 @RequestMapping 是有区别的
     * 如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
     * 如果加了参数“/”，则只认为是根页面。
     * 可以通过localhost:8080或者localhost:8080/index访问该方法
     */
    @RequestMapping(value = {"/", "/index"})
    public String index(Map<String, Object> model) {
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/views/index.jsp
        model.put("time", new Date());
        model.put("message", this.hello);
        //return 的是文件的名字
        return "index";
    }

    /**
     * （方法一）
     * 响应到JSP页面page1
     */
    @RequestMapping("/page1")
    public ModelAndView page1() {
        // 页面位置 /WEB-INF/views/page1.jsp
        ModelAndView mav = new ModelAndView("page1");
        mav.addObject("content", hello);
        return mav;
    }

    /**
     * （方法二）
     * 响应到JSP页面page1（可以直接使用Model封装内容，直接返回页面字符串）
     * 浏览器地址栏使用 page2
     */
    @RequestMapping("/page2")
    public String page2(Model model) {
        // 页面位置 /WEB-INF/views/page1.jsp
        model.addAttribute("content", hello + "（第二种）");
        return "page1";
    }

    @RequestMapping("/downloadpage")
    public String downloadpage() {
        return "download";
    }

    /**
     * 下载文件
     */
    @RequestMapping(value = "/download")
    public void download(HttpServletRequest request, HttpServletResponse res) throws Exception {
        String path = CreatePdfTest.getPdfPath();
        if (path != null) {
            File excelFile = new File(path);
            res.setCharacterEncoding("UTF-8");
            String realFileName = excelFile.getName();
            res.setHeader("content-type", "application/octet-stream");
            res.setContentType("application/octet-stream;charset=UTF-8");
            //加上设置大小下载下来的.xlsx文件打开时才不会报“Excel 已完成文件级验证和修复。此工作簿的某些部分可能已被修复或丢弃”
//            res.addHeader("Content-Length", String.valueOf(excelFile.length()));
            try {
                res.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(realFileName.trim(), "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            byte[] buff = new byte[1024];
            BufferedInputStream bis = null;
            OutputStream os = null;
            try {
                os = res.getOutputStream();
                bis = new BufferedInputStream(new FileInputStream(excelFile));
                int i = bis.read(buff);
                while (i != -1) {
                    os.write(buff, 0, buff.length);
                    os.flush();
                    i = bis.read(buff);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                excelFile.delete();
            }
        }
    }

}


