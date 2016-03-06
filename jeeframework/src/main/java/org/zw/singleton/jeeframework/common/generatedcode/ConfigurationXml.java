package org.zw.singleton.jeeframework.common.generatedcode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 设置配置
  * @类名:ConfigurationXml
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月25日-下午2:57:20
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
@Deprecated
public class ConfigurationXml {
	/**
	 * 懒汉式的单例模式
//	 */
//	// 实例化对象
//	private static ConfigurationXml lazySingleton = null;

	/**
	 * 私有构造方法 外界不能直接创建改实例
	 * 更加不能被继承
	 */
	private ConfigurationXml() {
	}

	/**
	 * 静态的工厂方法
	 * 返回此类唯一的实例
	 */
//	synchronized public static ConfigurationXml getcreate() {
//		// 返回是实例化的对像
//		if(lazySingleton==null){
//			lazySingleton = new ConfigurationXml();
//		}
//		return lazySingleton;
//	}
	/**
	 * 传入文件流，使用扩展包进行解析
	 * @方法说明:
	 * @方法名称:getSuffixs
	 * @param path
	 * @param parameter
	 * @throws Exception
	 * @作者:zw
	 * @返回值:void
	 */
    public static void saveXml(String path,String parameter){ 
    	try {
			InputStream inputStream = new FileInputStream(path);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
			DocumentBuilder builder = factory.newDocumentBuilder();  
			Document document = builder.parse(inputStream);  //加载资源
			Element element = document.getDocumentElement();  
			Node singleNode = selectSingleNode("/beans/bean[@id='sqlSessionFactory']", element);
			if(singleNode.getNodeType() == Node.ELEMENT_NODE){
				Element firstPersonElement = (Element)singleNode;
			    NodeList firstNameList = firstPersonElement.getElementsByTagName("property");
			  for (int i = 0; i < firstNameList.getLength(); i++) {
				  Element firstNameElement = (Element)firstNameList.item(i);
			      if("typeAliases".equals(firstNameElement.getAttribute("name"))){
			    	  NodeList childNodes = firstNameElement.getElementsByTagName("array");
			    	  Element add2 = (Element)childNodes.item(0);
			    	  Element add = document.createElement("value");
//            	  firstNameElement.appendChild(add2);
//            	  firstPersonElement.appendChild(firstNameElement);
            	  NodeList name2 = add2.getElementsByTagName("value");
            	  if(name2!=null&&name2.getLength()>0){
	            	  for (int j = 0; j < name2.getLength(); j++) {
	            		  Element o = (Element)name2.item(j);
	            		  //有就不配置
	            		 if(!o.getTextContent().equals(parameter)&& o.getTextContent()!=parameter){
	            			 add.setTextContent(parameter);
	            			 add2.appendChild(add);
	            		 }
//	            		  System.out.println(o.getTextContent());
	            	  }
            	  	}else{
            	  		 add.setTextContent(parameter);
            			 add2.appendChild(add);
            	  	}
			      }
			}
//          output(document);
			}
			saveXml(document,path);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }  
    
    /**
     * 保存
     * @方法说明:
     * @方法名称:saveXml
     * @param doc xml
     * @param path
     * @作者:zw
     * @返回值:void
     */
    public static void saveXml(Document doc,String path) {//将Document输出到文件
        TransformerFactory transFactory=TransformerFactory.newInstance();
        try {
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            DOMSource source=new DOMSource();
            source.setNode(doc);
            StreamResult result=new StreamResult();
            result.setOutputStream(new FileOutputStream(path));
            
            transformer.transform(source, result);
//            System.out.println("-----配置加载成功---------");
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    /**
     * 查询
     * @方法说明:
     * @方法名称:selectSingleNode
     * @param express
     * @param source
     * @return
     * @作者:zw
     * @返回值:Node
     */
    public static Node selectSingleNode(String express, Object source) {//查找节点，并返回第一个符合条件节点
    	Node result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    /**
     * 查询
     * @方法说明:
     * @方法名称:selectNodes
     * @param express
     * @param source
     * @return
     * @作者:zw
     * @返回值:NodeList
     */
    public static NodeList selectNodes(String express, Object source) {//查找节点，返回符合条件的节点集。
        NodeList result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    /**
     * 输出xml数据
     * @方法说明:
     * @方法名称:output
     * @param node
     * @作者:zw
     * @返回值:void
     */
    public static void output(Node node) {//将node的XML字符串输出到控制台
        TransformerFactory transFactory=TransformerFactory.newInstance();
        try {
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty("encoding", "UTF-8");
            transformer.setOutputProperty("indent", "yes");

            DOMSource source=new DOMSource();
            source.setNode(node);
            StreamResult result=new StreamResult();
            result.setOutputStream(System.out);
            
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }   
    }
}
