package com.clb.employment_information.service;


import com.clb.employment_information.entity.File;

import java.util.List;

public interface FileService {
    void insertFile(File file1);

    List<File> getAllFile();

    void updateFile(File file);

    void deleteFile(String fileId);
}
