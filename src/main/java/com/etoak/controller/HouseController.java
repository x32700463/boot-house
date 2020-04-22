package com.etoak.controller;

import com.etoak.bean.House;

import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;
import com.etoak.execption.ParamException;
import com.etoak.service.HouseService;
import com.etoak.utils.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;


import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.Validation;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/house")
@Slf4j
public class HouseController {
    @Value("${upload.dir}")
    private String uploadDirctory;
    @Value("${upload.savePathPrefix}")
    private String savePathPrefix;
    @Autowired
    HouseService houseService;
    /**
     * 跳转添加页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "house/add";
    }

    @PostMapping("/add2")
    public String add(@RequestParam("file") MultipartFile file, @Valid House house, BindingResult bingResult) throws IOException {

       List<ObjectError> allErrors = bingResult.getAllErrors();
       if(CollectionUtils.isNotEmpty(allErrors)){
           StringBuffer msgBuffer = new StringBuffer();
           for(ObjectError objectError:allErrors){
               String message = objectError.getDefaultMessage();
               msgBuffer.append(message).append(",");
           }
           throw new ParamException("参数校验失败"+msgBuffer.toString());
       }

       //拿取原始名称
        String originalFilename = file.getOriginalFilename();
        //拿取后缀名
        /*String suffix = FilenameUtils.getExtension(originalFilename);*/
        //UUID生成前缀
        String prefix = UUID.randomUUID().toString().replace("-","");
        /*String newFileName = originalFilename+"_"+prefix+"."+suffix;*/
        String newFileName = prefix+"_"+originalFilename;
        //上传目录
        File destFile = new File(this.uploadDirctory,newFileName);
        file.transferTo(destFile);
        //给house设置访问地址
        house.setPic(this.savePathPrefix+newFileName);
        houseService.addHouse(house);
        return "redirect:/house/toAdd";
    }

    @PostMapping("/add")
    public String add2(@RequestParam("file") MultipartFile file, @Valid House house) throws IOException {

        ValidationUtil.validate(house);
        //拿取原始名称
        String originalFilename = file.getOriginalFilename();
        //拿取后缀名
        /*String suffix = FilenameUtils.getExtension(originalFilename);*/
        //UUID生成前缀
        String prefix = UUID.randomUUID().toString().replace("-","");
        /*String newFileName = originalFilename+"_"+prefix+"."+suffix;*/
        String newFileName = prefix+"_"+originalFilename;
        //上传目录
        File destFile = new File(this.uploadDirctory,newFileName);
        file.transferTo(destFile);
        //给house设置访问地址
        house.setPic(this.savePathPrefix+newFileName);
        houseService.addHouse(house);
        return "redirect:/house/toAdd";
    }
    @GetMapping(value="/list" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Page<HouseVo> queryList(@RequestParam(required = false,defaultValue = "1")int pageNum,
                                   @RequestParam(required = false,defaultValue = "10")int pageSize, HouseVo housevo){
       log.info("pageNum -{},pageSize -{} houseVo -{}",pageNum,pageSize,housevo);
       return houseService.queryList(pageNum,pageSize,housevo);
    }
}
