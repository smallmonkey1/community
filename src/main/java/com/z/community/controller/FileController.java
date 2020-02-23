package com.z.community.controller;

import com.z.community.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * project--community.
 * Create by zfl on 2020/2/22 15:41.
 **/
@Controller
public class FileController {

    @RequestMapping("/files/upload")
    @ResponseBody
    public FileDTO upload(){
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("img/i1.jpg");
        return fileDTO;
    }
}
