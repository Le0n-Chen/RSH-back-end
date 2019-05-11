package com.leoncf.video.service.impl;

import com.leoncf.video.model.Picture;
import com.leoncf.video.repository.PictureRepo;
import com.leoncf.video.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureRepo pictureRepo;

    @Override
    public List<Picture> getPictureList() {
        return pictureRepo.findAll();
    };

    @Override
    public Picture findPictureById(long id) {
        return pictureRepo.findById(id);
    };

    @Override
    public List<Object> findPictureArrByDay(String date) {
        List<Object> list = pictureRepo.findByDateASC(date);
        return list;
    };

    @Override
    public void save(Picture picture) {
        this.pictureRepo.save(picture);
    };

    @Override
    public void edit(Picture picture) {
        this.pictureRepo.save(picture);
    };

    @Override
    public void delete(long id) {
        this.pictureRepo.deleteById(id);
    };
}
