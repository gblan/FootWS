package et5.utils;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

import et5.service.camel.Log;

public class UtilsIO {
	//LOCAL
	//private static final String ROUTE_PATH_TRANSFO_XSLT = "resources/displayHTMLroute.xslt";
	// DEPLOY
	private static final String ROUTE_PATH_TRANSFO_XSLT = "deploy/resources/displayHTMLroute.xslt";
	private static final Logger logger = Logger.getLogger(UtilsIO.class); 


	/**
	 * @param filename
	 * @param keyProperty
	 * @return a property read in the file passed in param, at the key position
	 *         passed in param
	 */
	public static String readPropertyFile(String filename, String keyProperty) {
		logger.info("filename : "+filename);
		Properties prop = new Properties();
		InputStream input = null;
		String result = "";
		try {
			logger.info("pwd : "+System.getProperty("user.dir"));
			input = new FileInputStream(filename);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			result = prop.getProperty(keyProperty);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	
	
	/**
	 * @param filePath
	 * @return String of the file content in param
	 * @throws IOException
	 */
	public static String fileToString(String filePath) throws IOException{
		return new String(readAllBytes(get(filePath)));
	}
	
	/**
	 * 
	 * transformation xslt, to transform an XML string to an HTML file with the xslt transfo param
	 * @param input
	 * @param output
	 */
	public static void routeTransformXMLStringintoHTMLFile(String stringInput, String fileOutput) {
		StreamSource xmlSource = new StreamSource(new StringReader(stringInput));
		StreamResult outputTarget = new StreamResult(new File(fileOutput));
		transformXMLIntoHTML(xmlSource, outputTarget, ROUTE_PATH_TRANSFO_XSLT);
	}

	/**
	 * 
	 * transformation xslt, to transform an XML to an HTML string with the xslt transfo param
	 * @param stringInput
	 */
	public static String routeTransformXMLStringIntoHTMLString(String stringInput) {
		StreamSource xmlSource = new StreamSource(new StringReader(stringInput));
		StreamResult outputTarget = new StreamResult(new StringWriter());
		transformXMLIntoHTML(xmlSource, outputTarget, ROUTE_PATH_TRANSFO_XSLT);
		return outputTarget.getWriter().toString();
	}
		
	/**
	 * transformation xslt, to transform an xmlSource with the xslt transfo param
	 * @param output
	 * @param transfo
	 * @param xmlSource
	 */
	private static void transformXMLIntoHTML(StreamSource xmlSource, StreamResult htmlResult, String transfo) {
		final String TRANSFORMER_FACTORY_CLASS = "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl";

		TransformerFactory tFactory = TransformerFactory.newInstance(TRANSFORMER_FACTORY_CLASS,null);
		Source xslSource = new StreamSource(transfo);
		logger.info("transfo : "+transfo);
		logger.info("xslSource : "+xslSource.getSystemId());
		try {
			Transformer xml2soap = tFactory.newTransformer(xslSource);
			logger.info("xml2soap : "+xml2soap);
			xml2soap.setOutputProperty(OutputKeys.INDENT, "yes");
			xml2soap.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			xml2soap.transform(xmlSource, htmlResult);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param path
	 * @param encoding
	 * @return String of the file passed in parameter
	 * @throws IOException
	 */
	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	/**
	 * @param packageName
	 * @param pathToXmlFile
	 * @return Object corresponding to the XMLfile param , having a XML schema and a XML description at the packageName param
	 * @throws JAXBException
	 */
	public static Object unmarshalFromFile(String packageName, String pathToXmlFile) throws JAXBException{
		return UtilsIO.unmarshaller(packageName).unmarshal(new File(pathToXmlFile));
	}
	
	/**
	 * @param packageName
	 * @param inputStream
	 * @return Object corresponding to the XML string param , having a XML schema and a XML description at the packageName param
	 * @throws JAXBException
	 */
	public static Object unmarshalFromString(String packageName, InputStream inputStream) throws JAXBException{
		return UtilsIO.unmarshaller(packageName).unmarshal(inputStream);
	}
	
	/**
	 * @param packageName
	 * @return unmarshaller
	 * @throws JAXBException
	 */
	private static Unmarshaller unmarshaller(String packageName) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(packageName);
		return context.createUnmarshaller();
	}

	
	/**
	 * output an XML file at the newFile param, corresponding to the obj param, and with the XMLSchema and the XMLDescription at the packageName param
	 * @param packageName
	 * @param obj
	 * @param newFile
	 * @throws JAXBException
	 */
	public static void marshalToFile(String packageName, Object obj, String newFile) throws JAXBException{
		marshaller(packageName).marshal(obj, new File(newFile));
	}
	
	/**
	 * @param packageName
	 * @param obj
	 * @return xml string correspondind to the obj in param and with the XMLSchema and the XMLDescription at the packageName param
	 * @throws JAXBException
	 * @throws UnsupportedEncodingException
	 */
	public static String marshalToString(String packageName, Object obj) throws JAXBException, UnsupportedEncodingException{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		marshaller(packageName).marshal(obj, os);
		return new String(os.toByteArray(), "UTF-8");
	}
	
	/**
	 * @param packageName
	 * @return marshaller
	 * @throws JAXBException
	 */
	private static Marshaller marshaller(String packageName) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(packageName);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		return marshaller;
	}
}
