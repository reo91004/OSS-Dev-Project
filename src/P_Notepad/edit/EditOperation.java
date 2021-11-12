package P_Notepad.edit;

import P_Notepad.notepad.Notepad;

import javax.swing.JTextArea;

public class EditOperation {

    private Notepad npd;
    private JTextArea textArea;

    public EditOperation(Notepad npd) {
        this.npd = npd;
        textArea = npd.getTextArea();
    }

    public boolean cut() {
        textArea.cut();
        return true;
    }

    public boolean copy() {
        textArea.copy();
        return true;
    }

    public boolean paste() {
        textArea.paste();
        return true;
    }

    public void delete() {
        textArea.replaceSelection("");
    }
}
