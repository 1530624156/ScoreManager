package com.mavis.controller;

import com.mavis.entity.vo.FileVO;
import com.mavis.utils.MavisUtils;
import com.mavis.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * FileController
 *
 * @author Mavis郭逸轩
 * @since 2024/5/8 17:10
 */


@Slf4j
@RestController
@RequestMapping("file")
public class FileController {

    private final MavisUtils mavisUtils;
    //文件保存路径
    @Value("${app.upload.dir}")
    private String filePath;

    public FileController(MavisUtils mavisUtils) {
        this.mavisUtils = mavisUtils;
    }

    /**
     * 文件上传接口
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public RestResult handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return RestResult.fail("上传失败，请选择文件");
        }
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = mavisUtils.randomFileName() + fileType;
        File dest = new File(filePath + fileName);
        FileVO fileVO = new FileVO();
        fileVO.setFileName(fileName);
        fileVO.setFilePath(filePath);
        try {
            file.transferTo(dest);
            Thread.sleep(1500);
            return RestResult.success(fileVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RestResult.fail("上传失败");
    }
}