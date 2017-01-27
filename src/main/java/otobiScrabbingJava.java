import com.sun.tracing.dtrace.DependencyClass;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by Shafayat on 1/27/2017.
 */

public class otobiScrabbingJava {
    public static void main(String[] args)
    {
        for (int i = 15; i <52 ; i++) {

            try {
                Document doc = Jsoup.connect("http://otobi.com/index.php/products/details/"+i+"/1/1").get();
                Elements newsHeadlines = doc.select(".container .span6:nth-of-type(2)");
                Elements link = doc.select(".container .span6:nth-of-type(1)");
                for (Element element:
                        newsHeadlines) {
                    String name = element.select("h4").text();
                    String material =element.select(".ditails table tbody tr:nth-of-type(1) td:nth-of-type(3)").text();
                    String code = element.select(".ditails table tbody tr:nth-of-type(2) td:nth-of-type(3)").text();
                    String price = element.select(".ditails table tbody tr:nth-of-type(5) td:nth-of-type(3)").text();

                    System.out.println(name+" "+material+" "+code+" "+price);
                }
                for (Element element:
                     link) {
                    String getLink=element.select(".imgzoom").attr("src");
                    System.out.println(getLink);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
