package behavioral;

public class TemplateMethod {

    abstract class Game {
        abstract void initialize();

        abstract void startPlay();

        abstract void endPlay();

        public final void play() {
            initialize();
            startPlay();
            endPlay();
        }
    }

    class Cricket extends Game {

        @Override
        void initialize() {
            System.out.println("Cricket Game initialized.");
        }

        @Override
        void startPlay() {
            System.out.println("Cricket Game started.");
        }

        @Override
        void endPlay() {
            System.out.println("Cricket Game finished.");
        }
    }

    class Football extends Game {

        @Override
        void initialize() {
            System.out.println("Football Game initialized.");
        }

        @Override
        void startPlay() {
            System.out.println("Football Game started.");
        }

        @Override
        void endPlay() {
            System.out.println("Football Game finished.");
        }
    }

    void templateDemo() {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }

    public static void main(String[] args) {
        new TemplateMethod().templateDemo();
    }
}
