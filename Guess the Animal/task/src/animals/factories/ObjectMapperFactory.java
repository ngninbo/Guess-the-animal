package animals.factories;

import animals.domain.FileFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class ObjectMapperFactory {

    public static ObjectMapper of() {
        return new ObjectMapper();
    }

    public static ObjectMapper of(FileFormat format) {
        switch (format) {
            case XML:
                return new XmlMapper();
            case YAML:
                return new YAMLMapper();
            default:
                return new JsonMapper();
        }
    }

}
