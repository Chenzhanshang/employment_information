package com.clb.employment_information.dao;

import com.clb.employment_information.entity.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileDao {
    public void insertFile(File file1);

    List<File> getAllFile();

    void updateFile(File file);

    void deleteFile(String fileId);
}
