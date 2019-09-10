package bekyiu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class DownloadController
{
    @RequestMapping("/download")
    public void download(String imgPath, HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String filename = imgPath.substring(imgPath.lastIndexOf("/") + 1);
        // get乱码
        filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
        // 告诉浏览器不要直接打开文件, 而是弹出下载框下载(chrome貌似不会弹出下载框而是直接下载了)
        resp.setContentType("application/x-msdownload");
        // 设置下载文件的建议保存名称, 非IE
        resp.setHeader("Content-Disposition",
                "attachment;filename=" + new String(filename.getBytes("UTF-8"), "ISO-8859-1"));
        String dir = req.getServletContext().getRealPath("/upload");
        Files.copy(Paths.get(dir, filename), resp.getOutputStream());
    }
}
