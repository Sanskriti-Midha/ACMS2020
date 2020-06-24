import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class scraper implements Runnable {

	String ua = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36";

	String url;
	
	private JobPriority jobPriority;
	
	public scraper(String url, JobPriority jp) {
		this.url = url;
		jobPriority = jp;
	}

	@Override
	public void run() {
		String price_text;

		// final long startTime = System.currentTimeMillis();
		Document document = null;
		try {
			document = Jsoup.connect(url).userAgent(ua).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// final long searchTime1 = System.currentTimeMillis();
		// System.out.println("Total connect time: " + (searchTime1 - startTime));
		Element price = document.getElementById("priceblock_ourprice");

		if (price == null) {
			price = document.getElementById("priceblock_saleprice");
		}

		if (price != null) {
			price_text = price.toString();
		} else {
			Elements price_element = document.select("b:contains(Price:)");
			Element el = price_element.first();
			price_text = ((TextNode) el.nextSibling()).text();
		}

		// final long searchTime2 = System.currentTimeMillis();
		// System.out.println("Total search time: " + (searchTime2 - searchTime1));

		// Regex to extract the price from the element's text
		String pattern = "\\d+(,)?\\d+(,)?\\d+(\\.\\d+)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(price_text);
		System.out.println(price_text);
		m.find();
		System.out.println(m.group(0)+ "Priority:"+jobPriority);
	}

	public JobPriority getJobPriority() {
		return jobPriority;
	}
}
