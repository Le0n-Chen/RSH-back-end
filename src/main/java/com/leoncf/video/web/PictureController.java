package com.leoncf.video.web;

import com.leoncf.video.model.Picture;
import com.leoncf.video.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/camera")
public class PictureController {
    private  static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private  static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final ResourceLoader resourceLoader;

    @Value("${picture.address}")
    private String path;

    @Resource
    public PictureService pictureService;

    @Autowired
    public PictureController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping("show/{fileName}")
    public ResponseEntity showPhotos(@PathVariable("fileName") String fileName){

            try {
                // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
                return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("list/{day}")
    public List<Object> showPhotosList(@PathVariable("day") String day){
        return pictureService.findPictureArrByDay(day);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addPhotoAddr(@RequestParam(value = "picAddress") String picAddress) {
        Date now = new Date();
        String date = dateFormat.format(now);
        String time = timeFormat.format(now);
        Picture picture = new Picture( date, time, picAddress);
        this.pictureService.save(picture);
    }
}
