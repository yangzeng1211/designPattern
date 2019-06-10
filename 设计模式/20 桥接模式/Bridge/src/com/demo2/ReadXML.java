package com.demo2;

import java.io.File;
import java.net.URLDecoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @description: 读取xml，通过反射创建对象实例
 * @author: yz
 * @create: 2019/6/10 17:15
 */
public class ReadXML {
    public static Object getObject(String args) {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
//            doc = builder.parse(new File("src/com/demo2/config.xml"));
            doc = builder.parse(new File(URLDecoder.decode(ReadXML.class.getResource("config.xml").getPath(), "UTF-8")));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = null;
            if (args.equals("color")) {
                classNode = nl.item(0).getFirstChild();
            } else if (args.equals("bag")) {
                classNode = nl.item(1).getFirstChild();
            } else if (args.equals("size")) {
                classNode = nl.item(2).getFirstChild();
            }

            String cName = "com.demo2." + classNode.getNodeValue();
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
