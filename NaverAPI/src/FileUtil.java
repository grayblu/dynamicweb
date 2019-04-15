import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
	
	static String readString(InputStream in) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while((inputLine = br.readLine()) != null){
			response.append(inputLine);
		}
		br.close();
		return response.toString();
	}
	
	static byte[] readBytes(InputStream in) throws Exception{
		try (BufferedInputStream bin = new BufferedInputStream(in);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
		){
			
			int data;
			while((data = bin.read()) != -1) {
				bos.write(data);
			}
		 
			return bos.toByteArray();
		
		}
	}
	
	public static void download(String urlStr) throws Exception{
		URL url = new URL(urlStr);
		InputStream in = url.openStream();
		
		File file = new File(url.getFile());
		Path dest = Paths.get("c:/temp/download", file.getName());
		Files.copy(in, dest);
	}
}
