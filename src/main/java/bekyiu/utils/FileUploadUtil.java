package bekyiu.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUploadUtil
{
    /**
     * 处理文件上传
     * @param pic
     * @param req
     * @return 返回文件的名称, 如果返回null, 说明没有文件上传
     */
    public static String upload(MultipartFile pic, HttpServletRequest req)
    {
        // 说明并没有上传东西
        if(pic.isEmpty())
        {
            return null;
        }
        String path = req.getServletContext().getRealPath("/upload");
        String uuid = UUID.randomUUID().toString();
        String ext = pic.getOriginalFilename().split("\\.")[1];
        String fileName = uuid + "." + ext;
        try
        {
            Files.copy(pic.getInputStream(), Paths.get(path, fileName));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return fileName;
    }

    public static void deleteUploaded(String fileName, HttpServletRequest req)
    {
        // 原来没有图片, 就不用删除
        if(fileName == null)
        {
            return;
        }
        String path = req.getServletContext().getRealPath("/upload");
        path = path.substring(0, path.lastIndexOf("\\"));
        File file = new File(path, fileName);
        if(file.exists())
        {
            file.delete();
        }
    }
}
