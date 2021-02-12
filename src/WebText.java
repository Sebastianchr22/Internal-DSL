import java.util.Map;

public class WebText extends WebComponent {
	
	String preMeta = "<p class='nav-item'>";
	String content = "";
	String link = "";
	String postLink = "";
	String postMeta = "</p>";
	
	public WebText(String text) {
		content = text;
	}
	
	public WebText link(Map<String, String> pageMap, String pageName) {
		String url = pageMap.get(pageName);
		link += "<a href='" + url + "'>";
		postLink = "</a>";
		return this;
	}
	
	public String toHtml() {
		String childComps = "";
		for(IWebComponent comp : components) {
			childComps += comp.toHtml();
		}
		return link + preMeta + content + postMeta + postLink + childComps;
	}
}
