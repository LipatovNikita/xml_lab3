package program;

import program.help.FileResolver;
import program.help.XmlTransformer;
import program.help.XmlValidator;

public class Main {
   public static void main(String[] args) {
      XmlValidator xmlValidator = new XmlValidator();
      FileResolver fileResolver = new FileResolver();
      XmlTransformer xmlTransformer = new XmlTransformer();

      xmlValidator.validateXMLSchema(fileResolver.getXmlFileAbsolutePath("businessEntityList.xml"),
              fileResolver.getXmlFileAbsolutePath("schema.xsd"));
      xmlTransformer.transformXmlToHtml(fileResolver.getXmlFileAbsolutePath("businessEntityList.xml"),
              fileResolver.getXmlFileAbsolutePath("template.xsl"));
   }
}
