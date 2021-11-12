package P_Notepad.notepad;

import P_Notepad.edit.EditOperation;
import P_Notepad.file.FileOperation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notepad implements MenuConstants, ActionListener {

    private JFrame frame;
    private JTextArea textArea;
    private JLabel statusBar;
    private FileOperation fileHandler;
    private EditOperation editHandler;

    public JTextArea getTextArea() {
        return textArea;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Notepad(String title) {
        frame = new JFrame(title);  // JFrame 생성
        textArea = new JTextArea(30, 60); // TextArea 생성
        statusBar = new JLabel("Line: 1 Row: 1 ", JLabel.CENTER); // Label 생성

        createMenuBar(frame);   // 메뉴바 생성
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);  // BorderLayout의 가운데 배치
        frame.add(statusBar, BorderLayout.SOUTH);   // 아래 쪽에 상태바 배치

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();   // 하위 항목들의 크기에 맞춰서 프레임 크기 맞춤

        textArea.addCaretListener(new CaretListener() {                 // textArea에 이벤트 추가
            @Override
            public void caretUpdate(CaretEvent e) {
            int lineNumber = 0, column = 0, pos = 0;

            try {
                pos = textArea.getCaretPosition();
                lineNumber = textArea.getLineOfOffset(pos);
                column = pos - textArea.getLineStartOffset(lineNumber);
            } catch (Exception excp) {

            }

            if (textArea.getText().length() == 0) {
                lineNumber = 0;
                column = 0;
            }

            LocalDateTime now = LocalDateTime.now();
            String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
            statusBar.setText("Line: " + (lineNumber + 1) + "  Col: " + (column + 1) + "   " + formatedNow);
            }
        });

        fileHandler = new FileOperation(this);
        editHandler = new EditOperation(this);
    }

    void createMenuBar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();  // 메뉴 바 생성

        JMenu fileMenu = new JMenu(fileText);   // 메뉴 생성

        JMenuItem fn = new JMenuItem(fileNew);  // 파일
        fn.addActionListener(this);
        JMenuItem fo = new JMenuItem(fileOpen); // 열기
        fo.addActionListener(this);
        JMenuItem fs = new JMenuItem(fileSave); // 저장
        fs.addActionListener(this);
        JMenuItem fsa = new JMenuItem(fileSaveAs);  // 다른 이름으로 저장
        fsa.addActionListener(this);
        JMenuItem print = new JMenuItem(filePrint); // 인쇄
        print.addActionListener(this);
        JMenuItem exit = new JMenuItem(fileExit);   // 종료
        exit.addActionListener(this);

        fileMenu.add(fn);
        fileMenu.add(fo);
        fileMenu.add(fs);
        fileMenu.add(fsa);
        fileMenu.addSeparator();    // 구분자
        fileMenu.add(print);
        fileMenu.addSeparator();    // 구분자
        fileMenu.add(exit);

        menuBar.add(fileMenu);  // 메뉴바에 파일 메뉴 추가

        JMenu editMenu = createMenu(editText, menuBar); // 편집
        JMenu formatMenu = createMenu(formatText, menuBar); // 보기
        JMenu viewMenu = createMenu(viewText, menuBar); // 서식
        JMenu helpMenu = createMenu(helpText, menuBar); // 도움말

        createMenuItem(editUndo,  editMenu, KeyEvent.VK_Z, this);
        editMenu.addSeparator();
        createMenuItem(editCut, editMenu, KeyEvent.VK_X, this);
        createMenuItem(editCopy,  editMenu, KeyEvent.VK_C, this);
        createMenuItem(editPaste,  editMenu, KeyEvent.VK_V, this);
        createMenuItem(editDelete,  editMenu, KeyEvent.VK_D, this);
        editMenu.addSeparator();
        createMenuItem(editSelectAll,  editMenu, KeyEvent.VK_A, this);

        frame.setJMenuBar(menuBar);
    }

    JMenu createMenu(String s, JMenuBar menuBar) {
        JMenu temp = new JMenu(s);
        menuBar.add(temp);
        return temp;
    }

    JMenuItem createMenuItem(String s, JMenu toMenu, int aclKey, ActionListener al) {
        JMenuItem temp = new JMenuItem(s);
        temp.addActionListener(al);
        temp.setAccelerator(KeyStroke.getKeyStroke(aclKey, ActionEvent.CTRL_MASK));
        toMenu.add(temp);

        return temp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println(cmd);

        if (cmd.equals(fileNew))    // 새로 만들기
            fileHandler.newFile();
        else if (cmd.equals(fileSave))  // 저장
            fileHandler.saveThisFile();
        else if (cmd.equals(fileSaveAs))  // 저장
            fileHandler.saveAsFile();
        else if (cmd.equals(fileOpen)) // 열기
            fileHandler.openFile();
        else if (cmd.equals(fileExit))  // 종료
            System.exit(0);
        else if (cmd.equals(editCut))   // 잘라내기
            editHandler.cut();
        else if (cmd.equals(editCopy))  // 복사하기
            editHandler.copy();
        else if (cmd.equals(editPaste)) // 붙여넣ㅇ게
            editHandler.paste();
        else if (cmd.equals(editDelete))    // 삭제
            editHandler.delete();

    }

}
