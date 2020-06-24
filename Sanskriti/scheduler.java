import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class scheduler {
	
	private static int POOL_SIZE = 5;
	private static int QUEUE_SIZE = 50;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the URL");
		String url[] = {
				"https://www.amazon.in/gp/product/B07HGLBZ5R/ref=s9_acss_bw_cg_CPACS_5a1_w?pf_rd_m=A1K21FY43GMZF8&pf_rd_s=merchandised-search-9&pf_rd_r=657WM7FM15GRD1KB9K19&pf_rd_t=101&pf_rd_p=c50bc5d3-6095-4dac-a786-63b8566da55f&pf_rd_i=1389401031",
				"https://www.amazon.in/dp/B086R4XJHT/ref=s9_acsd_al_bw_c2_x_1_i?pf_rd_m=A1K21FY43GMZF8&pf_rd_s=merchandised-search-3&pf_rd_r=ZQNCK8513F9SWKNCGG5B&pf_rd_t=101&pf_rd_p=ada365a6-ef4f-4121-ae41-ff433e944c91&pf_rd_i=21246961031",
				"https://www.amazon.in/gp/product/B07MNPSSY8/ref=crt_ewc_title_dp_4?ie=UTF8&psc=1&smid=A29WIH9FDOTYQN",
				"https://www.amazon.in/Bull-Socket-Switch-Extension-Board/dp/B01NCZRREH/ref=pd_rhf_se_s_rp_c_0_5/258-6738923-6627809?_encoding=UTF8&pd_rd_i=B01NCZRREH&pd_rd_r=dbe6ee80-6bf7-48cc-8347-f13b81eb0990&pd_rd_w=RYgOt&pd_rd_wg=XJNUG&pf_rd_p=e90b64f0-dae5-4141-ab1d-b81aea3463b5&pf_rd_r=X2S8DQ2S2W04417RX9NW&psc=1&refRID=X2S8DQ2S2W04417RX9NW",
				"https://www.amazon.in/Gala-Advance-Polyester-Floor-Cloth/dp/B07BHS9B7W/ref=sr_1_13_sspa?dchild=1&keywords=spray+mop&pf_rd_i=2083408031&pf_rd_m=A1K21FY43GMZF8&pf_rd_p=1b2f2bd8-c8ba-4de1-b7fa-6cf8267c28e7&pf_rd_r=Q0JTFAEX0ASGYF688N5K&pf_rd_s=merchandised-search-4&pf_rd_t=101&qid=1593014999&refinements=p_85%3A10440599031&rps=1&s=kitchen&sr=1-13-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzQlcxSUlFNTZRWkQ2JmVuY3J5cHRlZElkPUEwNjQwMzY0M0kyMzRSMkdOU1QwRCZlbmNyeXB0ZWRBZElkPUEwMTIwODkzMlRUWjlYUElCS041OSZ3aWRnZXROYW1lPXNwX210ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU=" };

//		ExecutorService pool = Executors.newFixedThreadPool(3);
//
//		for (String i : url) {
//			Runnable r = new scraper(i, JobPriority.HIGH);
//			pool.execute(r);
//		}

		Priority_Sched pjs = new Priority_Sched(POOL_SIZE, QUEUE_SIZE);

		for (int i = 0;i<5;i++) {
			if(i%2 == 0) {
				scraper r = new scraper(url[i], JobPriority.LOW);	
				pjs.scheduleJob(r);
			}
			else {
				scraper r = new scraper(url[i], JobPriority.HIGH);	
				pjs.scheduleJob(r);
			}
		}
	
		//pool.shutdown();
		sc.close();
	}

}
