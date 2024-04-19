//package com.iso.iso8583.Mine;
//
//import org.jpos.iso.ISOFieldPackager;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import java.io.File;
//
//public class IsoField {
//
//    public static ISOFieldPackager[] createFromXML(String xmlFilePath) {
//        try {
//            File xmlFile = new File(xmlFilePath);
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(xmlFile);
//
//            doc.getDocumentElement().normalize();
//            NodeList nodeList = doc.getElementsByTagName("isofield");
//
//            ISOFieldPackager[] fieldPackagers = new ISOFieldPackager[nodeList.getLength()];
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element element = (Element) node;
//                    int id = Integer.parseInt(element.getAttribute("id"));
//                    int length = Integer.parseInt(element.getAttribute("length"));
//                    String name = element.getAttribute("name");
//                    String className = element.getAttribute("class");
//
//                    Class<?> cls = Class.forName(className);
//                    ISOFieldPackager fieldPackager = (ISOFieldPackager) cls.getDeclaredConstructor(int.class, String.class).newInstance(id, name, length);
//                    fieldPackagers[i] = fieldPackager;
//                }
//            }
//
//            return fieldPackagers;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static void main(String[] args) {
//        String xmlFilePath = "field.xml";
//        ISOFieldPackager[] fieldPackagers = createFromXML(xmlFilePath);
//        if (fieldPackagers != null) {
//            for (ISOFieldPackager fieldPackager : fieldPackagers) {
//                System.out.println("ISO Field Packager: " + fieldPackager);
//            }
//        }
//    }
//}
//
