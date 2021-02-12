import java.util.HashMap;
import java.util.Map;

public interface IWebComponent {	
	public WebNavigationBar navigationBar(Map<String, String> pageMap);
	public String toHtml();
	public WebComponent page(String name);
	public WebComponent text(String text);
}
