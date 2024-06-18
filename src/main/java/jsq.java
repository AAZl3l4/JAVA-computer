import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jsq extends JFrame implements Runnable{
    private JButton m;
    private JButton MS;
    private JButton a2Button;
    private JButton zf;
    private JButton a1Button;
    private JButton a0Button;
    private JButton a3Button;
    private JButton d;
    private JButton jian;
    private JButton a1X;
    private JButton jia;
    private JButton dy;
    private JButton cheng;
    private JButton quyu;
    private JButton a6Button;
    private JButton a5Button;
    private JButton a4Button;
    private JButton MC;
    private JButton MR;
    private JButton chu;
    private JButton a9Button;
    private JButton a8Button;
    private JButton a7Button;
    private JButton CE;
    private JButton back;
    private JPanel JSQ;
    private JButton C;
    private JButton sqrt;
    private JTextField jsq;
    //M功能储存字符串
    private String mcc;

    jsq(){
        //界面初始化
        this.setContentPane(this.JSQ);
        this.setTitle("计算器");
        ImageIcon btx = new ImageIcon("img/ad.png");
        Image image = btx.getImage();
        this.setIconImage(image);
        this.setSize(600,300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //创建菜单
        JMenuBar cd = new JMenuBar();
        JMenu bianji = new JMenu("编辑");
        JMenu chakan = new JMenu("查看");
        JMenu bangzhu = new JMenu("帮助");
        cd.add(bianji);
        cd.add(chakan);
        cd.add(bangzhu);
        JMenuItem fuzi = new JMenuItem("复制(c)");
        //绑定快捷键
        fuzi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
        fuzi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("复制了");
                String text = jsq.getText();
                // 获取系统剪贴板
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                // 创建要复制的内容
                StringSelection selection = new StringSelection(text);
                // 将内容设置到剪贴板
                clipboard.setContents(selection, null);
            }
        });
        JMenuItem zhantie = new JMenuItem("粘贴(v)");
        zhantie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
        zhantie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("粘贴了");
                try {
                    String text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                    jsq.setText(text);
                } catch (Exception ex) {
                    System.out.println("报错");
                }
            }
        });
        bianji.add(fuzi);
        bianji.add(zhantie);
        this.setJMenuBar(cd);
        //显示界面
        this.setVisible(true);
        //窗口关闭监听器
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void run() {
        //按钮监听
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("0");
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("9");
            }
        });
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone(".");
            }
        });
        jia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("+");
            }
        });
        jian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("-");
            }
        });
        cheng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("*");
            }
        });
        chu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("/");
            }
        });
        quyu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdone("%");
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsq.setText(jsq.getText().substring(0,jsq.getText().length()-1));
            }
        });
        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsq.setText("");
            }
        });
        CE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jsq.getText();
                for (int i = text.length()-1; i >=0 ; i--) {
                    if (text.charAt(i)=='+'||text.charAt(i)=='-'||text.charAt(i)=='*'||text.charAt(i)=='/'||text.charAt(i)=='%'){
                        jsq.setText(text.substring(0,i+1));
                        break;
                    }
                }
            }
        });
        dy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsq.setText(String.valueOf(qiuhe()));
            }
        });
        a1X.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double number = qiuhe();
                double reciprocal = 1.0 / number;
                jsq.setText(String.valueOf(reciprocal));
            }
        });
        sqrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double number = qiuhe();
                jsq.setText(String.valueOf(Math.sqrt(number)));
            }
        });
        zf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsq.setText("-"+qiuhe());
            }
        });
        MC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mcc ="";
            }
        });
        MR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jsq.setText(mcc);
            }
        });
        MS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mcc=jsq.getText();
            }
        });
        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qiuhe();
                double msum = Double.parseDouble(jsq.getText()) + Double.parseDouble(mcc);
                jsq.setText(String.valueOf(msum));
            }
        });
    }

    void pdone(String text) {
        if (jsq.getText().isEmpty()) {
            jsq.setText(text);
        }else {
            jsq.setText(jsq.getText()+text);
        }
    }

    ArrayList<String> fengg(){
        //分割输入字符
        String text = jsq.getText();
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*|[\\+\\-\\*\\/\\%]");
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> result = new ArrayList<>();
        //添加到结果列表
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    double qiuhe(){
        double sum = 0;
        ArrayList<String> jis = fengg();
        //判断有无运算符
        if (!jis.contains("*")&&!jis.contains("/")&&!jis.contains("%")&&!jis.contains("+")&&!jis.contains("-")){
            return Double.parseDouble(jsq.getText());
        }
        //先乘除
        while (jis.contains("*")||jis.contains("/")||jis.contains("%")){
            int i = jis.indexOf("*");
            int j = jis.indexOf("/");
            int q = jis.indexOf("%");

            int a = 0;
            //如果一个为-1 则直接选择另一个
            if (i != -1 && (j == -1 || i < j) && (q == -1 || i < q)) {
                a = i;
            } else if (j != -1 && (i == -1 || j < i) && (q == -1 || j < q)) {
                a = j;
            } else if (q != -1) {
                a = q;
            }
            double v;
            if (jis.get(a).equals("*")) {
                v = Double.parseDouble(jis.get(a - 1)) * Double.parseDouble(jis.get(a + 1));
            }else if (jis.get(a).equals("/")){
                if (Double.parseDouble(jis.get(a + 1))==0){
                    break;
                }
                v = Double.parseDouble(jis.get(a - 1)) / Double.parseDouble(jis.get(a + 1));
            }else {
                if (Double.parseDouble(jis.get(a + 1))==0){
                    break;
                }
                v = Double.parseDouble(jis.get(a - 1)) % Double.parseDouble(jis.get(a + 1));
            }
            jis.remove(a+1);
            jis.set(a, String.valueOf(v));
            jis.remove(a-1);
            sum=v;
        }
        //再加减
        while (jis.contains("+")||jis.contains("-")){
            int i = jis.indexOf("+");
            int j = jis.indexOf("-");
            int a;
            //如果一个为-1 则直接选择另一个
            if (i == -1) {
                a = j;
            } else if (j == -1) {
                a = i;
            } else {
                a = i > j ? j : i;
            }
            double v;
            if (jis.get(a).equals("+")) {
                v = Double.parseDouble(jis.get(a - 1)) + Double.parseDouble(jis.get(a + 1));
            }else {
                v = Double.parseDouble(jis.get(a - 1)) - Double.parseDouble(jis.get(a + 1));
            }
            jis.remove(a+1);
            jis.set(a, String.valueOf(v));
            jis.remove(a-1);
            sum=v;
        }
        return sum;
    }


}
