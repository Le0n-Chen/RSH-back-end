package com.leoncf.video.service;

import com.leoncf.video.model.Picture;

import java.util.List;
import java.util.Map;

public interface PictureService {
    public List<Picture> getPictureList();

    public Picture findPictureById(long id);

    public List<Object> findPictureArrByDay(String date);

    public void save(Picture picture);

    public void edit(Picture userLog);

    public void delete(long id);
}
