package com.scraper;

import com.model.SkiResort;
import com.model.SkiSlope;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {

    private static final String URL = "http://www.romaniaturistica.ro/info-schi";

    private static final String EFFECTIVE_INFO_DIV_CLASS = "panel-default";

    private static WebScraper webScraper = new WebScraper();

    private Document page;

    private WebScraper() {
        try {
            getScrapedData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static WebScraper getWebScraper() {
        return webScraper;
    }

    public List<SkiResort> getSkiResortsData() {
        Elements resortDetails = page.getElementsByAttributeValueContaining("class", "panel panel-default");

        List<SkiResort> skiResorts = new ArrayList<>();

        for (Element resortDetail : resortDetails) {
            SkiResort skiResort = new SkiResort();
            skiResort.setName(resortDetail.child(0).child(0).child(0).text());
            skiResort.setSnowHeight(resortDetail.child(0).child(0).child(2).text());

            List<SkiSlope> slopes = new ArrayList<>();
            for (Element slopeDetails : resortDetail.child(1).child(0).child(0).children()) {
                SkiSlope slope = new SkiSlope();
                slope.setName(slopeDetails.child(0).text());
                slope.setOpen(checkSlopeState(slopeDetails.child(2).text()));
                slopes.add(slope);
            }

            skiResort.setSlopes(slopes);
            skiResorts.add(skiResort);
        }

        return skiResorts;
    }

    private void getScrapedData() throws IOException {
        page = Jsoup.connect(URL).get();
    }

    private boolean checkSlopeState(final String state) {
        return !state.equals("Închisă");
    }

}
