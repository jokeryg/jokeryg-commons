package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TipController {
    @RequestMapping("/tips")
    public String tip(@ModelAttribute("msg") String msg, @ModelAttribute("url") String url,@ModelAttribute("close")String close ,Model model){
        model.addAttribute("msg",msg);
        model.addAttribute("url",url);
        if(close != null){
            //close有值就存入
            model.addAttribute("close",close);
        }
        return "tips/tips";
    }
}
