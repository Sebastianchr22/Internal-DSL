
public class WebOption extends WebComponent{
	String name;
	
	String preMeta = "<li class='nav-item'>";
	
	String link = "";
	
	String postMeta = "</a></li>";
	
	public WebOption(String label, String url) {
		name = label;
		link = "<a class='nav-link active' aria-current='page' href='" + url + "'>";
	}
	
	public String toHtml() {
		return preMeta + link + name + postMeta;
	}
}
