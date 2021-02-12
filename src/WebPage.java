public class WebPage extends WebComponent {
	
	String name;
	
	String preMeta = "<!DOCTYPE html>"
			+ "<html>"
			+ "<head>"
			+ "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl' crossorigin='anonymous'>"
			+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js' integrity='sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0' crossorigin='anonymous'></script>"
			+ "<meta name='viewport' content='width=device-width, initial-scale=1'>"
			+ "<title>Web page from DSL</title>"
			+ "</head>"
			+ "<body>"
			+ "<div class='text-center'>";
	
	String postMeta = "</div></body></html>";
	
	public WebPage(String name) {
		this.name = name;
	}
	
	public String toHtml() {
		String content = "";
		for(IWebComponent comp : components) {
			content += comp.toHtml();
		}
		return preMeta + content + postMeta;
	}
}
