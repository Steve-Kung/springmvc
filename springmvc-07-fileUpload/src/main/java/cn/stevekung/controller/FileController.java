package cn.stevekung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FileController {
    /**
     * 文件上传第一种办法
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    // String getOriginalFilename()：获取上传文件的原名
    // InputStream getInputStream()：获取文件流
    // void transferTo(File dest)：将上传文件保存到一个目录文件中

    //@RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
    //批量上传CommonsMultipartFile则为数组即可
//    貌似有点问题
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名
        String uploadFileName = file.getOriginalFilename();
        //如果文件名为空，直接回到首页！
        if ("".equals(uploadFileName)) {
            return "redirect:/index.jsp";
        }
        //上传文件路径设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        //如果路径不存在，创建一个
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        //文件输入流
        InputStream is = file.getInputStream();
        //文件输出流
        OutputStream os = new FileOutputStream(new File(realPath, uploadFileName));
        // 读写操作
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";
    }

    /**
     * 文件上传第二种办法
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    //采用file.Transto 来保存上传的文件
//    这个没有问题
    @RequestMapping("/upload2")
    public String upload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }


    /**
     * 文件下载第一种办法
     * @param response
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 要下载的图片地址
        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "1.png";


        //1、设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path,fileName);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return null;
    }
}