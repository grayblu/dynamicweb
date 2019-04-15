import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageItem {
	String title;
	String link;
	String thumbnail;
	int sizeheight;
	int sizewidth;
}
