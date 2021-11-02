package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class DictionaryConnector {

    private static final String propertiesPath = "resources/connection.properties";

    public static String getDictPath(DictionaryTypes types){
        Properties properties = new Properties();
        String result = null;
        try(FileInputStream fis = new FileInputStream(propertiesPath)){
            properties.load(fis);
            Enumeration<?> dictNames = properties.propertyNames();
            while (dictNames.hasMoreElements()){
                String dictName = dictNames.nextElement().toString();
                if (dictName.equals(types.toString())) result = properties.getProperty(types.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

}
