
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class scraper {

	public static void main(String args[]) throws IOException {

		String ua = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36";

		String price_text;

		Document document = Jsoup.connect("https://www.amazon.in/AmazonBasics-Performance-Alkaline-Non-Rechargeable-Batteries/dp/B00O869QUC/ref=lp_21246976031_1_1?srs=21246976031&ie=UTF8&qid=1592672924&sr=8-1")
				.userAgent(ua).get();

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
		String pattern = "\\d+(\\.\\d+)?";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(price_text);
		System.out.println(price_text);
		m.find();
		System.out.println(m.group(0));
	}

}
