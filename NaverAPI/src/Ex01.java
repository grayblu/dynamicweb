
public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			NaverImageApi api = new NaverImageApi();
			SearchResult<ImageItem> res = api.get("자동차");
			
			for(ImageItem image : res.getItems()) {
				System.out.println(image);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
