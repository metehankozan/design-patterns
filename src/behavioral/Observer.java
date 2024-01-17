package behavioral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Observer {

    interface Channel {
        void update(String news);
        void printNews();
    }

    class NewsAgency {
        private String news;
        private List<Channel> channels = new ArrayList<>();

        public void addObserver(Channel channel) {
            channels.add(channel);
        }

        public void removeObserver(Channel channel) {
            channels.remove(channel);
        }

        public void setNews(String news) {
            this.news = news;
            for (Channel channel : channels) {
                channel.update(this.news);
            }
        }
    }

    class NewsChannel implements Channel {
        private List<String> newsList = new ArrayList<>();

        @Override
        public void update(String news) {
            newsList.add(0, news);
        }

        @Override
        public void printNews() {
            for (String news : newsList){
                System.out.println(news);
            }
        }
    }

    void observerDemo() {
        Channel channel1 = new NewsChannel();
        Channel channel2 = new NewsChannel();
        Channel channel3 = new NewsChannel();

        NewsAgency newsAgency = new NewsAgency();
        newsAgency.addObserver(channel1);
        newsAgency.addObserver(channel2);
        newsAgency.addObserver(channel3);

        newsAgency.setNews("News 1");
        newsAgency.setNews("News 2");
        newsAgency.setNews("News 3");

        channel1.printNews();
        channel2.printNews();
        channel3.printNews();
    }

    public static void main(String[] args) {
        new Observer().observerDemo();
    }
}
