package et5.service.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * class utils contains utils static methods
 */
public class Utils {

	private static final String APPLI_PROPERTIES = "resources/appliMail.properties";

	/**
	 * @param to
	 * @param subject
	 * @param content
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void sendHTMLMailUsingSMTPAppliEmail(String to, String subject,
			String content) throws AddressException, MessagingException {

		String appliEmail = readPropertyFile(APPLI_PROPERTIES, "Appli.Email");
		String appliPassword = readPropertyFile(APPLI_PROPERTIES,"Appli.Password");
		String appliPort = readPropertyFile(APPLI_PROPERTIES, "Appli.Port");
		String applihostname = readPropertyFile(APPLI_PROPERTIES,"Appli.HostName");
		sendSMTPMail(appliEmail, to, appliPassword, applihostname, appliPort,subject, content, "text/html; charset=utf-8");
	}

	/**
	 * Method that send a message to the adress "to" in param using JavaMail
	 * 
	 * @param from
	 * @param to
	 * @param fromPassword
	 * @param hostName
	 * @param port
	 * @param subject
	 * @param content
	 * @param messageType 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	private static void sendSMTPMail(String from, String to,
			String fromPassword, String hostName, String port, String subject,
			String content, String messageType) throws AddressException, MessagingException {

		// Properties used for logging
		Properties props = new Properties();
		props.setProperty("mail.host", hostName); // smtp.gmail.com ou
													// smtp.free.fr ou
													// smtp.u-psud.fr
		props.setProperty("mail.smtp.port", port); // 587
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");

		// Authentication object
		Authenticator auth = new SMTPAuthenticator(from, fromPassword);

		// Session used to send the message
		Session session = Session.getInstance(props, auth);

		// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(session);

		// Set From/to: header field of the header.
		message.setFrom(new InternetAddress(from));
		message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

		// Write subject and content
		message.setSubject(subject);
		message.setContent(content,messageType);
		message.setSentDate(new Date());
		// Send message
		Transport.send(message);
	}

	/**
	 * @param filename
	 * @param keyProperty
	 * @return a property read in the file passed in param, at the key position
	 *         passed in param
	 */
	public static String readPropertyFile(String filename, String keyProperty) {
		Properties prop = new Properties();
		InputStream input = null;
		String result = "";
		try {
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
	 * transformation xslt, to transform an XML to an HTML for presentation
	 * 
	 * @param input
	 * @param output
	 * @param transfo
	 */
	public static void transformationXML(String input, String output,String transfo) {
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Source xslSource = new StreamSource(transfo);
		try {
			Transformer xml2soap = tFactory.newTransformer(xslSource);
			StreamSource xmlSource = new StreamSource(input);
			Result outputTarget = new StreamResult(output);
			System.out.println("transformation de " + input + " en " + output	+ " par " + transfo);
			xml2soap.setOutputProperty(OutputKeys.INDENT, "yes");
			xml2soap.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			xml2soap.transform(xmlSource, outputTarget);
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
	 * @param xmlFile
	 * @return Object corresponding to the XMLfile param , having a XML schema and a XML description at the packageName param
	 * @throws JAXBException
	 */
	public static Object unmarshal(String packageName, String xmlFile) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(packageName);
		Unmarshaller u = context.createUnmarshaller();
		return u.unmarshal(new File(xmlFile));
	}
	
	/**
	 * output an XML file at the newFile param, corresponding to the obj param, and with the XMLSchema and the XMLDescription at the packageName param
	 * @param packageName
	 * @param obj
	 * @param newFile
	 * @throws JAXBException
	 */
	public static void marshal(String packageName, Object obj, String newFile) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(packageName);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(obj, new File(newFile));
	}
}
