import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebComponent implements IWebComponent {	
	List<IWebComponent> components = new ArrayList<IWebComponent>();

	
	public void addComponent(IWebComponent comp) {
		components.add(comp);
	}
	
	@Override
	public WebNavigationBar navigationBar(Map<String, String> map) {
		WebNavigationBar nav = new WebNavigationBar(map);
		addComponent(nav);
		return nav;
	}

	@Override
	public WebComponent page(String name) {
		WebComponent page = new WebPage(name);
		addComponent(page);
		return page;
	}

	public WebText text(String text) {
		WebText webText = new WebText(text);
		components.add(webText);
		return webText;
	}

	public WebImage image(String src) {
		WebImage i = new WebImage(src);
		addComponent(i);
		return i;
	}

	public WebComponent header(String text) {
		WebHeader t = new WebHeader(text);
		addComponent(t);
		return t;
	}
	
	@Override
	public String toHtml() {
		String content = "";
		for(IWebComponent comp : components) {
			content += comp.toHtml();
		}
		return content;
	}
}
