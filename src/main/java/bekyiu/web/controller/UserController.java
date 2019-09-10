package bekyiu.web.controller;

import bekyiu.domain.User;
import bekyiu.query.UserQueryObject;
import bekyiu.service.IUserService;
import bekyiu.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController
{
    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public String list(Model model, UserQueryObject qo)
    {
        model.addAttribute("pageResult", userService.query(qo));
        model.addAttribute("qo", qo);
        return "list";
    }

    @RequestMapping("/input")
    public String input(Long id, Model model)
    {
        if(id != null)
        {
            model.addAttribute("user", userService.get(id));
        }
        return "edit";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(User user, MultipartFile pic, HttpServletRequest req)
    {
        String fileName = FileUploadUtil.upload(pic, req);
        if(fileName != null)
        {
            //上传了新的图片, 删除原来得图片
            FileUploadUtil.deleteUploaded(user.getHeadImg(), req);
            user.setHeadImg("/upload/" + fileName);
        }
        if(user.getId() != null)
        {
            userService.update(user);
        }
        else
        {
            userService.save(user);
        }
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id)
    {
        userService.delete(id);
        return "redirect:/list";
    }
}
