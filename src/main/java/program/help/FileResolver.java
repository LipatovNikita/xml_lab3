package program.help;

public class FileResolver {

   public String getXmlFileAbsolutePath(String xmlFileName) {
      return getClass().getClassLoader().getResource(xmlFileName).getPath();
   }
}
