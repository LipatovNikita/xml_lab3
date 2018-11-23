package program.help;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;

public class XmlTransformer {

   public void transformXmlToHtml(String xmlFileName, String xslFileName) {
      XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
      try (FileInputStream fileInputStream = new FileInputStream(xmlFileName)) {
         XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(fileInputStream);
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslFileName));
         /*  Пункт №5 - вместо SAXSource и DOMResult используем более современные - StAXSource и StreamResult */
         transformer.transform(new StAXSource(xmlEventReader), new StreamResult(new File("out.html")));
      } catch (Exception e) {
         System.err.println("Ошибка обработки xml-документа");
         e.printStackTrace();
      }
   }
}
