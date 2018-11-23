package program.help;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

   public void validateXMLSchema(String xmlDocumentPath, String xsdSchemaPath) {
      try {
         SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
         Schema schema = schemaFactory.newSchema(new File(xsdSchemaPath));
         Validator xsdValidator = schema.newValidator();
         xsdValidator.validate(new StreamSource(new File(xmlDocumentPath)));
      } catch (IOException | SAXException exception) {
         System.err.println("Ошибка валидации xml-документа");
         exception.printStackTrace();
      }
   }
}
