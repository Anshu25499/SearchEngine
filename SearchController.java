package springsearch.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	@RequestMapping("/home")
	public String home() {
		System.out.println("Home page is running!!");
		return "home";
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("queryBox") String query) {
		
		RedirectView redirectView = new RedirectView();
		if (query.isBlank()) {
			String url="http://localhost:8080/springsearch/error";
			redirectView.setUrl(url);
			
		}else {
			String urlString= "https://google.com/search?q="+query;
			redirectView.setUrl(urlString);
		}
		
		
		return redirectView;
	}
}
