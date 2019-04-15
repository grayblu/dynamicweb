import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public class QueryMap {
	
	static public String getQueryString(Map<String, Object> map)
										throws Exception{
		StringBuilder sb = new StringBuilder();
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String value = map.get(key).toString();
			value = URLEncoder.encode(value, "UTF-8");
			String query = String.format("%s=%s&",key, value);
			sb.append(query);
		}
		return sb.toString();
	}
}
