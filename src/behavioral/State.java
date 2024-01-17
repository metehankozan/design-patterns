package behavioral;

public class State {

    class Package {
        private PackageState state = new ReceivedState();

        public PackageState getState() {
            return state;
        }

        public void setState(PackageState state) {
            this.state = state;
        }

        public void previousState() {
            state.previous(this);
        }

        public void nextState() {
            state.next(this);
        }

        public void printState() {
            state.printState();
        }
    }

    interface PackageState {
        void next(Package pkg);
        void previous(Package pkg);
        void printState();
    }

    class ReceivedState implements PackageState {

        @Override
        public void next(Package pkg) {
            pkg.setState(new TransferState());
        }

        @Override
        public void previous(Package pkg) {
            System.out.println("This is the initial state of the package.");
        }

        @Override
        public void printState() {
            System.out.println("Package is received to be delivered.");
        }
    }

    class TransferState implements PackageState {

        @Override
        public void next(Package pkg) {
            pkg.setState(new DeliveredState());
        }

        @Override
        public void previous(Package pkg) {
            pkg.setState(new ReceivedState());
        }

        @Override
        public void printState() {
            System.out.println("Package is in transfer state.");
        }
    }

    class DeliveredState implements PackageState {

        @Override
        public void next(Package pkg) {
            System.out.println("This is the final state for the package.");
        }

        @Override
        public void previous(Package pkg) {
            pkg.setState(new TransferState());
        }

        @Override
        public void printState() {
            System.out.println("Package is delivered.");
        }
    }

    void stateDemo(){
        Package pkg = new Package();
        pkg.printState();

        pkg.nextState();
        pkg.printState();

        pkg.nextState();
        pkg.printState();

        pkg.nextState();
        pkg.printState();
    }

    public static void main(String[] args) {
        new State().stateDemo();
    }
}
