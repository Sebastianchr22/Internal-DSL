
public class WebHeader extends WebComponent {
	
	String preMeta = "<h1>";
	String postMeta = "</h1>";
	String content = "";
	
	public WebHeader(String text) {
		content = text;
	}
	
	public String toHtml() {
		String childComps = "";
		for(IWebComponent comp : components) {
			childComps += comp.toHtml();
		}
		return preMeta + content + postMeta + childComps;
	}
}
