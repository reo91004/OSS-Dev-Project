package P_Notepad.file;

import P_Notepad.notepad.Notepad;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileOperation {
    private Notepad npd;
    private String fileName;
    private File fileRef;
    private JFileChooser chooser;
    private boolean newFileFlag;

    public FileOperation(Notepad npd) {
        this.npd = npd;
        fileName = new String("Untitled");
        newFileFlag = true;
        fileRef = new File(fileName);
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
    }

    public void newFile() {
        this.npd.getTextArea().setText("");
    }

    boolean saveFile(File temp) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(temp);
            fout.write(npd.getTextArea().getText());
        } catch (IOException ioe) {

        } finally {
            try {
                fout.close();
            } catch (IOException excp) {
            }
        }
        return true;
    }

    public boolean saveAsFile() {
        File temp = null;
        chooser.setDialogTitle("Save As...");
        chooser.setApproveButtonText("Save Now");
        chooser.setApproveButtonToolTipText("Click me to save!");

        do {
            if (chooser.showSaveDialog(this.npd.getFrame()) != JFileChooser.APPROVE_OPTION)
                return false;
            temp = chooser.getSelectedFile();
            if (!temp.exists()) break;
            if (JOptionPane.showConfirmDialog(
                    this.npd.getFrame(), "<html>" + temp.getPath() + " already exists.<br>Do you want to replace it?<html>",
                    "Save As", JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION)
                break;
        } while (true);

        newFileFlag = false;
        return saveFile(temp);
    }

    public boolean saveThisFile() {
        if (!newFileFlag) {
            return saveFile(fileRef);
        }

        return saveAsFile();
    }

    boolean open(File file) {
        FileInputStream fin = null;
        BufferedReader din = null;

        try {
            fin = new FileInputStream(file);
            din = new BufferedReader(new InputStreamReader(fin));
            String str = " ";
            while (str != null) {
                str = din.readLine();   // 한줄 을 읽는다
                if (str == null)
                    break;
                this.npd.getTextArea().append(str + "\n");
            }

        } catch (IOException ioe) {
            return false;
        } finally {
            try {
                din.close();
                fin.close();
            } catch (IOException excp) {
            }
        }
        this.npd.getTextArea().setCaretPosition(0);
        return true;
    }

    public void openFile() {
        chooser.setDialogTitle("Open File...");
        chooser.setApproveButtonText("Open this");
        chooser.setApproveButtonToolTipText("Click me to open the selected file.!");

        File file = null;
        do {
            if (chooser.showOpenDialog(this.npd.getFrame()) != JFileChooser.APPROVE_OPTION)
                return;
            file = chooser.getSelectedFile();

            if (file.exists()) break;

            // 파일이 없을 때
            JOptionPane.showMessageDialog(this.npd.getFrame(),
                    "<html>" + file.getName() + "<br>file not found.<br>" +
                            "Please verify the correct file name was given.<html>",
                    "Open", JOptionPane.INFORMATION_MESSAGE);

        } while (true);

        this.npd.getTextArea().setText("");
        open(file);

    }

}

