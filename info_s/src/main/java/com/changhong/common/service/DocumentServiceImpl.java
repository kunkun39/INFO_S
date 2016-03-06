package com.changhong.common.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.changhong.common.facade.dto.MetaDataSubItem;
import com.changhong.common.facade.dto.MetaDataDTO;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 17:17
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
    @Override
    public MetaDataDTO parseXML(InputStream inputStream) {
        MetaDataDTO dto = null;
        Element root = loadXMLFile(inputStream);
        if (root != null) {
            dto = new MetaDataDTO();
            dto.setMetadataName(getMetaDataName(root));
            dto.setItems(getMetaDataItems(root));
        }
        return dto;
    }

    @Override
    public boolean writeToXML(OutputStream outputStream, MetaDataDTO dto) {
        if (outputStream != null) {
            Document document = createXMLDocument(dto);
            if (document != null) {
                try {
                    // 排版缩进的格式
                    OutputFormat format = OutputFormat.createPrettyPrint();
                    // 设置编码
                    format.setEncoding("UTF-8");
                    XMLWriter writer = new XMLWriter(new OutputStreamWriter(outputStream, "UTF-8"), format);
                    // 写入
                    writer.write(document);
                    // 立即写入
                    writer.flush();
                    // 关闭操作
                    writer.close();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private Element loadXMLFile(InputStream in) {
        Element root = null;
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            root = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return root;
    }

    private String getMetaDataName (Element element) {
        return element.elementText("name");
    }

    private List<MetaDataSubItem> getMetaDataItems (Element element) {
        List<MetaDataSubItem> items = new ArrayList<MetaDataSubItem>();

        List<Element> metadataElements = element.elements("item");
        for (Element metadataelement : metadataElements) {
            MetaDataSubItem item = new MetaDataSubItem();
            item.setIndex(metadataelement.attributeValue("index"));
            item.setValue(metadataelement.getStringValue());
            items.add(item);
        }

        return items;
    }

    private Document createXMLDocument(MetaDataDTO dto) {
        Document document = null;
        if (dto != null) {
            // 创建根节点
            document = DocumentHelper.createDocument();
            Element root = document.addElement("metadataitems");
            setMetaDataName(root, dto.getMetadataName());
            setMetaDataItems(root, dto.getItems());
        }

        return document;
    }

    private void setMetaDataName(Element root, String name) {
        Element element = root.addElement("name");
        element.setText(name);
    }

    private void setMetaDataItems(Element root, List<MetaDataSubItem> items) {
        for (MetaDataSubItem item : items) {
            Element element = root.addElement("item");
            element.setText(item.getValue());
            element.addAttribute("index", item.getIndex());
        }
    }
}
