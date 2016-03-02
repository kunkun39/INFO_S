package com.changhong.common.service;

import java.util.ArrayList;
import java.util.List;

import com.changhong.common.facade.dto.MetaDataSubItem;
import com.changhong.common.facade.dto.MetaDataDTO;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * User: pengjie
 * Date: 2016/3/1
 * Time: 17:17
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
    @Override
    public MetaDataDTO parseXML(InputStream in) {
        MetaDataDTO dto = null;
        Element root = loadXMLFile(in);
        if (root != null) {
            dto = new MetaDataDTO();
            dto.setMetadataName(getMetaDataName(root));
            dto.setItems(getMetaDataItems(root));
        }
        return dto;
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
}
