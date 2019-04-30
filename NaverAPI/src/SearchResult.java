import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult<T> {
	String lastBuildDate;
	int total; // ": 4637078,
	int start; // "start": 1,
	int display; // ": 10,
	T[] items;
}
