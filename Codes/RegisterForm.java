import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class RegisterForm {
    private static RegisterForm RegisterForm;
    private JPanel registerCanvas = new JPanel();
    private JLabel register = new JLabel("Register");
    private JLabel msg = new JLabel();
    protected JTextField name = new JTextField("Enter Name");
    protected JTextField UID;
    protected JTextField username = new JTextField("Enter Username");
    protected JPasswordField password = new JPasswordField("Enter Password");
    protected JTextField email = new JTextField("Enter Email");
    protected JRadioButton Staff = new JRadioButton("Staff");
    protected JRadioButton Supervisor = new JRadioButton("Supervisor");
    protected JRadioButton HVAC = new JRadioButton("HVAC");
    protected JRadioButton room = new JRadioButton("HouseKeeping");
    protected JRadioButton elec = new JRadioButton("Electricity");
    protected JRadioButton media = new JRadioButton("Audio/Video");
    protected JRadioButton security = new JRadioButton("Security");
    private JLabel typeSelect = new JLabel("Select Type:");
    private JLabel depSelect = new JLabel("Select Department:");
    private JButton doRegister = new JButton("Register");
    private JButton exit = new JButton("Exit");
    protected ButtonGroup TypeGroup = new ButtonGroup();
    protected ButtonGroup DepGroup = new ButtonGroup();
    private RegisterForm(){}
    public static RegisterForm getRegisterForm(){
        if(RegisterForm == null){
            RegisterForm = new RegisterForm();
        }
        return RegisterForm;
    }
    public String IDgenerator(){
        Database db = Database.getDatabase();
        db.makeDatabase();
        int size = db.getPendingPersons().size();
        return ""+size;
    }
    private void setRegisterScreenProperties(){
        registerCanvas.setBackground(Color.ORANGE);
        registerCanvas.setLayout(null);
    }
    private void setRegisterScreenContent(){
        UID = new JTextField("UID: "+IDgenerator());
        setComponentBounds();
        setFonts();
        setAlignments();
        groupButtons();
        setBackgroundColor();
        addComponents();
        setJTextFieldToEmpty();
        UID.setEditable(false);
    }
    private void groupButtons(){
        TypeGroup.add(Staff);
        TypeGroup.add(Supervisor);
        DepGroup.add(HVAC);
        DepGroup.add(elec);
        DepGroup.add(room);
        DepGroup.add(security);
        DepGroup.add(media);
    }
    private void setComponentBounds(){
        register.setBounds(650,18,500,90);
        name.setBounds(700,165,300,50);
        UID.setBounds(700,235,300,50);
        username.setBounds(700,305,300,50);
        email.setBounds(700,375,300,50);
        password.setBounds(700,445,300,50);
        typeSelect.setBounds(700,495,300,30);
        Staff.setBounds(750,545,100,30);
        Supervisor.setBounds(900,545,200,30);
        depSelect.setBounds(700,575,300,30);
        HVAC.setBounds(750,625,300,30);
        elec.setBounds(750,665,300,30);
        room.setBounds(750,705,300,30);
        security.setBounds(750,745,300,30);
        media.setBounds(750,785,300,30);
        doRegister.setBounds(550,850,300,50);
        exit.setBounds(870,850,300,50);
        msg.setBounds(1100,305,700,50);
    }
    private void setBackgroundColor(){
        Staff.setBackground(Color.ORANGE);
        Supervisor.setBackground(Color.ORANGE);
        HVAC.setBackground(Color.ORANGE);
        elec.setBackground(Color.ORANGE);
        room.setBackground(Color.ORANGE);
        security.setBackground(Color.ORANGE);
        media.setBackground(Color.ORANGE);
        doRegister.setBackground(Color.CYAN);
        exit.setBackground(Color.PINK);
    }
    private void setFonts(){
        register.setFont(new Font(Font.MONOSPACED,Font.PLAIN,80));
        name.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        username.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        UID.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        password.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        email.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        typeSelect.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        depSelect.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
        Staff.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        Supervisor.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        HVAC.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        room.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        elec.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        security.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        media.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        doRegister.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        exit.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        msg.setFont(new Font(Font.MONOSPACED,Font.PLAIN,30));
    }
    private void setAlignments(){
        register.setHorizontalAlignment(JLabel.CENTER);
        name.setHorizontalAlignment(JTextField.CENTER);
        username.setHorizontalAlignment(JTextField.CENTER);
        UID.setHorizontalAlignment(JTextField.CENTER);
        password.setHorizontalAlignment(JPasswordField.CENTER);
        email.setHorizontalAlignment(JTextField.CENTER);
        doRegister.setHorizontalAlignment(JButton.CENTER);
        exit.setHorizontalAlignment(JButton.CENTER);
        msg.setVerticalAlignment(JLabel.TOP);
    }
    private void addComponents(){
        registerCanvas.add(register);
        registerCanvas.add(name);
        registerCanvas.add(UID);
        registerCanvas.add(username);
        registerCanvas.add(password);
        registerCanvas.add(email);
        registerCanvas.add(Staff);
        registerCanvas.add(Supervisor);
        registerCanvas.add(HVAC);
        registerCanvas.add(room);
        registerCanvas.add(elec);
        registerCanvas.add(media);
        registerCanvas.add(security);
        registerCanvas.add(typeSelect);
        registerCanvas.add(depSelect);
        registerCanvas.add(doRegister);
        registerCanvas.add(exit);
        registerCanvas.add(msg);
    }
    public JPanel getRegisterCanvas(){
        setRegisterScreenProperties();
        setRegisterScreenContent();
        return this.registerCanvas;
    }

    public JLabel getMsg(){
        return this.msg;
    }

    public JButton getDoRegister(){
        return this.doRegister;
    }

    public JButton getExit(){
        return this.exit;
    }

    private void setJTextFieldToEmpty(){
        name.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                name.setText("");
            }
        });
        password.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                password.setText("");
            }
        });
        username.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                username.setText("");
            }
        });
        email.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                email.setText("");
            }
        });
    }
}
