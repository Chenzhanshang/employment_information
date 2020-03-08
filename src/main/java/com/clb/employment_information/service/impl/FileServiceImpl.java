package com.clb.employment_information.service.impl;

import com.clb.employment_information.dao.FileDao;
import com.clb.employment_information.entity.File;
import com.clb.employment_information.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;
    @Override
    public void insertFile(File file1) {
        fileDao.insertFile(file1);
    }

    @Override
    public List<File> getAllFile() {
        return fileDao.getAllFile();
    }

    @Override
    public void updateFile(File file) {
        fileDao.updateFile(file);
    }

    @Override
    public void deleteFile(String fileId) {
        fileDao.deleteFile(fileId);
    }
}
