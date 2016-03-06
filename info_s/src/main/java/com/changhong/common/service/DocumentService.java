package com.changhong.common.service;

import com.changhong.common.facade.dto.MetaDataDTO;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 16:57
 */
public interface DocumentService {

    /**
     * 解析XML输入流
     * @param inputStream
     */
    MetaDataDTO parseXML(InputStream inputStream);

    boolean writeToXML(OutputStream outputStream, MetaDataDTO dto);
}
