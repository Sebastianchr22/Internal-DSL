
public class WebImage extends WebComponent {
	String url = "";
	String preMeta = "<img ";
	String classMeta = "class='img-fluid'";
	String sizeMeta = "";
	String postMeta = ">";
	
	public WebImage(String src) {
		preMeta += "src='" + src + "'";
	}
	
	public void size(float x, float y) {
		sizeMeta= "width=" + x + " height=" + y;
	}
	
	public String toHtml() {
		String childComps = "";
		for(IWebComponent comp : components) {
			childComps += comp.toHtml();
		}
		return preMeta + classMeta + sizeMeta + postMeta + childComps;
	}
}
