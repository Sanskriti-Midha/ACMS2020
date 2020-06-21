
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

		final long startTime = System.currentTimeMillis();

		Document document = Jsoup.connect(
				"https://www.amazon.in/dp/B086R4XJHT/ref=s9_acsd_al_bw_c2_x_1_i?pf_rd_m=A1K21FY43GMZF8&pf_rd_s=merchandised-search-3&pf_rd_r=ZQNCK8513F9SWKNCGG5B&pf_rd_t=101&pf_rd_p=ada365a6-ef4f-4121-ae41-ff433e944c91&pf_rd_i=21246961031")
				.userAgent(ua).get();

		final long searchTime1 = System.currentTimeMillis();
		System.out.println("Total connect time: " + (searchTime1 - startTime));
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
		final long searchTime2 = System.currentTimeMillis();
		System.out.println("Total search time: " + (searchTime2 - searchTime1));
		String pattern = "\\d+(\\.\\d+)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(price_text);
		System.out.println(price_text);
		m.find();
		System.out.println(m.group(0));
	}

}
