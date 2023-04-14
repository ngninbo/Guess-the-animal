import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.Arrays;

class Converter {
    public static char[] convert(String[] words) throws IOException {

        //String.join("", words).toCharArray();
        CharArrayWriter charArrayWriter = new CharArrayWriter();

        Arrays.stream(words).forEach(charArrayWriter::append);

        return charArrayWriter.toCharArray();
    }
}