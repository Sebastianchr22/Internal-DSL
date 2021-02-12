import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class model {

	static String filePath = "index.html";
	static String dirPath = "files/";
	
	public static void main(String[] args) {
		Map<String, String> pageMap = new HashMap<String, String>();
		WebComponent web = (WebComponent) new Web();
		
		// TODO Auto-generated method stub
		web.
			navigationBar(pageMap).
				option("Home", "Home.html").
				option("Shop", "Shop.html").
				option("About", "About.html").
				option("Contact", "Contact.html");
		web.
			page("Home").
				text("If you want to read more about this page ").text("click here.").link(pageMap, "About"). //Refers to link of About page
				header("Some Text").
				image("https://i.pinimg.com/originals/17/5e/49/175e4930f8833b76a2a65039c83300f7.jpg").size(200,350);
		web.
			page("About").
				text("This is the about page..").
				text("Click to go to home").link(pageMap, "Home");
		
		
		savePagesToFiles(web);
	}
	
	private static void savePagesToFiles(WebComponent web) {
		WebComponent navigation = getNavigation(web);
		List<WebPage> pages = getPages(web);
		storeToHtmlFile(navigation, pages);
	}
	
	private static WebComponent getNavigation(WebComponent web){
		for(IWebComponent comp : web.components) {
			if(comp.getClass() == WebNavigationBar.class) {
				return (WebComponent) comp;
			}
		}
		return null;
	}
	
	private static List<WebPage> getPages(WebComponent web){
		List<WebPage> pages = new ArrayList<WebPage>();
		for(IWebComponent comp : web.components) {
			if(comp.getClass() == WebPage.class) {
				pages.add((WebPage) comp);
				System.out.println(comp.toHtml());
			}
		}
		return pages;
	}
	
	private static void storeToHtmlFile(WebComponent navigation, List<WebPage> pages) {
		for(WebPage page : pages) {
			String toSave = "";
			toSave += navigation.toHtml();
			toSave += page.toHtml();
			System.out.println(toSave);
			try{
				Files.createDirectories(Paths.get(dirPath));
				File f = new File(dirPath + page.name + ".html");
				f.createNewFile();
				
				FileWriter myWriter = new FileWriter(dirPath + page.name + ".html");
				myWriter.write(toSave);
				myWriter.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
