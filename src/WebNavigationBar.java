import java.util.HashMap;
import java.util.Map;

public class WebNavigationBar extends WebComponent {
	
	String preMeta = 
			"<nav class='navbar navbar-expand-lg navbar-light bg-light'>"
			+ "<div class='container-fluid'>"
			+ "<div class='collapse navbar-collapse' id='navbarSupportedContent'>"
			+ "<ul class='navbar-nav me-auto mb-2 mb-lg-0'>";
	
	String postMeta = "</ul>"
			+ "</div>"
			+ "</div>"
			+ "</nav>";
	
	Map<String, String> pageMap;
	
	public WebNavigationBar(Map<String, String> map) {
		this.pageMap = map;
	}
	
	public WebNavigationBar option(String label, String url) {
		//System.out.println("Making new Option to nav bar");
		components.add(new WebOption(label, url));
		//System.out.println("Adding " + label + " mapped to " + url);
		pageMap.put(label, url);
		return this;
	}
	
	public String toHtml() {
		String content = "";
		for(IWebComponent comp : components) {
			content += comp.toHtml();
		}
		return preMeta + content + postMeta;
	}
}
