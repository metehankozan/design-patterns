package behavioral;

public class Memento {

    public class TextWindow {
        StringBuilder currentText;

        public TextWindow() {
            this.currentText = new StringBuilder();
        }

        void addText(String text) {
            currentText.append(text);
        }

        String getText() {
            return currentText.toString();
        }

        public TextWindowState save() {
            return new TextWindowState(currentText.toString());
        }

        public void restore(TextWindowState save) {
            currentText = new StringBuilder(save.getText());
        }
    }

    class TextWindowState {
        String text;

        public TextWindowState(String text) {
            this.text = text;
        }

        String getText() {
            return text;
        }
    }

    class TextEditor {

        TextWindow textWindow;
        TextWindowState savedTextWindow;

        public TextEditor(TextWindow textWindow) {
            this.textWindow = textWindow;
        }

        void write(String text) {
            textWindow.addText(text);
        }

        void print() {
            System.out.println(textWindow.getText());
        }

        void hitSave() {
            savedTextWindow = textWindow.save();
        }

        void hitUndo() {
            textWindow.restore(savedTextWindow);
        }
    }

    void mementoDemo() {
        TextEditor textEditor = new TextEditor(new TextWindow());
        textEditor.write("The Memento Design Pattern\n");
        textEditor.write("This is how to implement it in Java\n");
        textEditor.hitSave();

        textEditor.write("new text added\n");

        textEditor.print();
        textEditor.hitUndo();
        textEditor.print();
    }

    public static void main(String[] args) {
        new Memento().mementoDemo();
    }
}
