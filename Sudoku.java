/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;
/**
 *
 * @author Jyothika Surya
 */
public class Sudoku extends javax.swing.JFrame {

    /** Creates new form Sudoku */
    public Sudoku() {
        initComponents();
        startGame();
    }
    ArrayList[]rows=new ArrayList[9];
    ArrayList[]cols=new ArrayList[9];
    ArrayList[][]boxes=new ArrayList[3][3];
    int[][] solution=new int[9][9];
    int[][] board=new int[9][9];
    JButton[][] boardInputs= new JButton[9][9];
    JButton[] numberInputs=new JButton[9];
    int curNum=1;
    
    
    public void startGame(){
        initialiseArrays();
        initialiseInputs();
        createGrid();
        numberInputs[0].setBackground(Color.pink);
        printInitialGrid();
        generateSolution(0,0);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(solution[i][j]);
                
            }
            System.out.println();
        }
      
    }
    public void initialiseArrays(){
        rows=new ArrayList[9];
        cols=new ArrayList[9];
        boxes=new ArrayList[3][3];
        for(int i=0;i<9;i++){
            ArrayList temp=new ArrayList();
            rows[i]=temp;
            ArrayList temp1=new ArrayList();
            cols[i]=temp1;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ArrayList temp=new ArrayList();
                boxes[i][j]=temp;
                
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=0;
            }
        
    }
        
    }
    public void initialiseInputs(){
        boardInputs=new JButton[][]{
                {B1,B2,B3,B4,B5,B6,B7,B8,B9},
                {B10,B11,B12,B13,B14,B15,B16,B17,B18},
                {B19,B20,B21,B22,B23,B24,B25,B26,B27},
                {B28,B29,B30,B31,B32,B33,B34,B35,B36},
                {B37,B38,B39,B40,B41,B42,B43,B44,B45},
                {B46,B47,B48,B49,B50,B51,B52,B53,B54},
                {B55,B56,B57,B58,B59,B60,B61,B62,B63},
                {B64,B65,B66,B67,B68,B69,B70,B71,B72},
                {B73,B74,B75,B76,B77,B78,B79,B80,B81}
        };
        numberInputs =new JButton[]{
            i1,i2,i3,i4,i5,i6,i7,i8,i9
        };
    }
    public boolean isValid(int i,int j,int num){
        if(rows[i].contains(num))return false;
        if(cols[j].contains(num))return false;
        else if(boxes[(int)(Math.floor((double)i/3))][(int)(Math.floor((double)j/3))].contains(num)) return false;
        return true;
        
    }
       
    public void addToGrid(int i,int j,int num){
        rows[i].add(num);
        cols[j].add(num);
        boxes[(int)(Math.floor((double)i/3))][(int)(Math.floor((double)j/3))].add(num);
    }
    public void createGrid(){
        int count=0;
        while(count !=20){
            int i=(int)(Math.random()*9);
            int j=(int)(Math.random()*9);
            int num=(int)(Math.random()*9)+1;
            if(board[i][j]==0 && isValid(i,j,num)){
                count++;
                addToGrid(i,j,num);
                board[i][j]=num;
                solution[i][j]=num;
            }
        }
        
    }
    public void printInitialGrid(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                JButton cur_btn=boardInputs[i][j];
                if(board[i][j]==0){
                    cur_btn.setBackground(Color.white);
                }
                else{
                    int num=board[i][j];
                    cur_btn.setText(Integer.toString(num));
                    cur_btn.setBackground(Color.black);
                    cur_btn.setForeground(Color.white);
                    
                }
            }
           
        }
        
    }
    
    public boolean generateSolution(int i,int j){
        if(i==9) return true;
        if(solution[i][j]!=0){
            int x=i,y=j+1;
            if(y==9){
                x=x+1;
                y=0;
            }
            return generateSolution(x,y);
        }
        boolean b=false;
        for(int num=1;num<=9;num++){
            if(isValid(i,j,num)){
                addToGrid(i,j,num);
                solution[i][j]=num;
                int x=i,y=j+1;
                if(y==9){
                    x=i+1;
                    y=0;
                    
                }
                b=b||generateSolution(x,y);
                if(b) break;
                rows[i].remove(Integer.valueOf(num));
                cols[j].remove(Integer.valueOf(num));
                boxes[(int)(Math.floor((double)i/3))][(int)(Math.floor((double)j/3))].remove(Integer.valueOf(num));
                solution[i][j]=0;

                
            }
        }
        return b;
        
    }
    public void setValueInInput(int i,int j){
        if(board[i][j]==0) boardInputs[i][j].setText(Integer.toString(curNum));
    }
    public void selectNumber(int num){
        int prevNum=curNum;
        JButton prevSelected=numberInputs[prevNum-1];
        prevSelected.setBackground(new Color(0,204,204));
        JButton curSelected=numberInputs[num-1];
        curSelected.setBackground(Color.pink);
        curNum=num;
        
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        B2 = new javax.swing.JButton();
        B1 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        B6 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        B9 = new javax.swing.JButton();
        B17 = new javax.swing.JButton();
        B16 = new javax.swing.JButton();
        B18 = new javax.swing.JButton();
        B11 = new javax.swing.JButton();
        B10 = new javax.swing.JButton();
        B12 = new javax.swing.JButton();
        B14 = new javax.swing.JButton();
        B13 = new javax.swing.JButton();
        B15 = new javax.swing.JButton();
        B26 = new javax.swing.JButton();
        B25 = new javax.swing.JButton();
        B27 = new javax.swing.JButton();
        B20 = new javax.swing.JButton();
        B19 = new javax.swing.JButton();
        B21 = new javax.swing.JButton();
        B23 = new javax.swing.JButton();
        B22 = new javax.swing.JButton();
        B24 = new javax.swing.JButton();
        B42 = new javax.swing.JButton();
        B53 = new javax.swing.JButton();
        B52 = new javax.swing.JButton();
        B54 = new javax.swing.JButton();
        B47 = new javax.swing.JButton();
        B46 = new javax.swing.JButton();
        B48 = new javax.swing.JButton();
        B50 = new javax.swing.JButton();
        B49 = new javax.swing.JButton();
        B51 = new javax.swing.JButton();
        B33 = new javax.swing.JButton();
        B35 = new javax.swing.JButton();
        B34 = new javax.swing.JButton();
        B36 = new javax.swing.JButton();
        B44 = new javax.swing.JButton();
        B43 = new javax.swing.JButton();
        B45 = new javax.swing.JButton();
        B38 = new javax.swing.JButton();
        B37 = new javax.swing.JButton();
        B39 = new javax.swing.JButton();
        B29 = new javax.swing.JButton();
        B28 = new javax.swing.JButton();
        B30 = new javax.swing.JButton();
        B32 = new javax.swing.JButton();
        B31 = new javax.swing.JButton();
        B41 = new javax.swing.JButton();
        B40 = new javax.swing.JButton();
        B69 = new javax.swing.JButton();
        B80 = new javax.swing.JButton();
        B79 = new javax.swing.JButton();
        B81 = new javax.swing.JButton();
        B74 = new javax.swing.JButton();
        B73 = new javax.swing.JButton();
        B75 = new javax.swing.JButton();
        B77 = new javax.swing.JButton();
        B76 = new javax.swing.JButton();
        B78 = new javax.swing.JButton();
        B60 = new javax.swing.JButton();
        B62 = new javax.swing.JButton();
        B61 = new javax.swing.JButton();
        B63 = new javax.swing.JButton();
        B71 = new javax.swing.JButton();
        B70 = new javax.swing.JButton();
        B72 = new javax.swing.JButton();
        B65 = new javax.swing.JButton();
        B64 = new javax.swing.JButton();
        B66 = new javax.swing.JButton();
        B56 = new javax.swing.JButton();
        B55 = new javax.swing.JButton();
        B57 = new javax.swing.JButton();
        B59 = new javax.swing.JButton();
        B58 = new javax.swing.JButton();
        B68 = new javax.swing.JButton();
        B67 = new javax.swing.JButton();
        i2 = new javax.swing.JButton();
        i1 = new javax.swing.JButton();
        i7 = new javax.swing.JButton();
        i3 = new javax.swing.JButton();
        i6 = new javax.swing.JButton();
        i5 = new javax.swing.JButton();
        i4 = new javax.swing.JButton();
        i9 = new javax.swing.JButton();
        i8 = new javax.swing.JButton();
        jButton89 = new javax.swing.JButton();
        jButton92 = new javax.swing.JButton();
        jButton93 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sudoku Game");

        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });

        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });

        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });

        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });

        B6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B6ActionPerformed(evt);
            }
        });

        B8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B8ActionPerformed(evt);
            }
        });

        B7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B7ActionPerformed(evt);
            }
        });

        B9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B9ActionPerformed(evt);
            }
        });

        B17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B17ActionPerformed(evt);
            }
        });

        B16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B16ActionPerformed(evt);
            }
        });

        B18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B18ActionPerformed(evt);
            }
        });

        B11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B11ActionPerformed(evt);
            }
        });

        B10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B10ActionPerformed(evt);
            }
        });

        B12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B12ActionPerformed(evt);
            }
        });

        B14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B14ActionPerformed(evt);
            }
        });

        B13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B13ActionPerformed(evt);
            }
        });

        B15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B15ActionPerformed(evt);
            }
        });

        B26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B26ActionPerformed(evt);
            }
        });

        B25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B25ActionPerformed(evt);
            }
        });

        B27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B27ActionPerformed(evt);
            }
        });

        B20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B20ActionPerformed(evt);
            }
        });

        B19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B19ActionPerformed(evt);
            }
        });

        B21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B21ActionPerformed(evt);
            }
        });

        B23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B23ActionPerformed(evt);
            }
        });

        B22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B22ActionPerformed(evt);
            }
        });

        B24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B24ActionPerformed(evt);
            }
        });

        B42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B42ActionPerformed(evt);
            }
        });

        B53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B53ActionPerformed(evt);
            }
        });

        B52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B52ActionPerformed(evt);
            }
        });

        B54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B54ActionPerformed(evt);
            }
        });

        B47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B47ActionPerformed(evt);
            }
        });

        B46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B46ActionPerformed(evt);
            }
        });

        B48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B48ActionPerformed(evt);
            }
        });

        B50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B50ActionPerformed(evt);
            }
        });

        B49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B49ActionPerformed(evt);
            }
        });

        B51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B51ActionPerformed(evt);
            }
        });

        B33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B33ActionPerformed(evt);
            }
        });

        B35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B35ActionPerformed(evt);
            }
        });

        B34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B34ActionPerformed(evt);
            }
        });

        B36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B36ActionPerformed(evt);
            }
        });

        B44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B44ActionPerformed(evt);
            }
        });

        B43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B43ActionPerformed(evt);
            }
        });

        B45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B45ActionPerformed(evt);
            }
        });

        B38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B38ActionPerformed(evt);
            }
        });

        B37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B37ActionPerformed(evt);
            }
        });

        B39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B39ActionPerformed(evt);
            }
        });

        B29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B29ActionPerformed(evt);
            }
        });

        B28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B28ActionPerformed(evt);
            }
        });

        B30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B30ActionPerformed(evt);
            }
        });

        B32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B32ActionPerformed(evt);
            }
        });

        B31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B31ActionPerformed(evt);
            }
        });

        B41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B41ActionPerformed(evt);
            }
        });

        B40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B40ActionPerformed(evt);
            }
        });

        B69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B69ActionPerformed(evt);
            }
        });

        B80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B80ActionPerformed(evt);
            }
        });

        B79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B79ActionPerformed(evt);
            }
        });

        B81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B81ActionPerformed(evt);
            }
        });

        B74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B74ActionPerformed(evt);
            }
        });

        B73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B73ActionPerformed(evt);
            }
        });

        B75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B75ActionPerformed(evt);
            }
        });

        B77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B77ActionPerformed(evt);
            }
        });

        B76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B76ActionPerformed(evt);
            }
        });

        B78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B78ActionPerformed(evt);
            }
        });

        B60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B60ActionPerformed(evt);
            }
        });

        B62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B62ActionPerformed(evt);
            }
        });

        B61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B61ActionPerformed(evt);
            }
        });

        B63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B63ActionPerformed(evt);
            }
        });

        B71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B71ActionPerformed(evt);
            }
        });

        B70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B70ActionPerformed(evt);
            }
        });

        B72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B72ActionPerformed(evt);
            }
        });

        B65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B65ActionPerformed(evt);
            }
        });

        B64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B64ActionPerformed(evt);
            }
        });

        B66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B66ActionPerformed(evt);
            }
        });

        B56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B56ActionPerformed(evt);
            }
        });

        B55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B55ActionPerformed(evt);
            }
        });

        B57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B57ActionPerformed(evt);
            }
        });

        B59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B59ActionPerformed(evt);
            }
        });

        B58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B58ActionPerformed(evt);
            }
        });

        B68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B68ActionPerformed(evt);
            }
        });

        B67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B67ActionPerformed(evt);
            }
        });

        i2.setBackground(new java.awt.Color(0, 204, 204));
        i2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        i2.setText("2");
        i2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i2ActionPerformed(evt);
            }
        });

        i1.setBackground(new java.awt.Color(0, 204, 204));
        i1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        i1.setText("1");
        i1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i1ActionPerformed(evt);
            }
        });

        i7.setBackground(new java.awt.Color(0, 204, 204));
        i7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        i7.setText("7");
        i7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i7ActionPerformed(evt);
            }
        });

        i3.setBackground(new java.awt.Color(0, 204, 204));
        i3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        i3.setText("3");
        i3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i3ActionPerformed(evt);
            }
        });

        i6.setBackground(new java.awt.Color(0, 204, 204));
        i6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        i6.setText("6");
        i6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i6ActionPerformed(evt);
            }
        });

        i5.setBackground(new java.awt.Color(0, 204, 204));
        i5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        i5.setText("5");
        i5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i5ActionPerformed(evt);
            }
        });

        i4.setBackground(new java.awt.Color(0, 204, 204));
        i4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        i4.setText("4");
        i4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i4ActionPerformed(evt);
            }
        });

        i9.setBackground(new java.awt.Color(0, 204, 204));
        i9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        i9.setText("9");
        i9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i9ActionPerformed(evt);
            }
        });

        i8.setBackground(new java.awt.Color(0, 204, 204));
        i8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        i8.setText("8");
        i8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i8ActionPerformed(evt);
            }
        });

        jButton89.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton89.setText("Check");
        jButton89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton89ActionPerformed(evt);
            }
        });

        jButton92.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton92.setText("Reset");
        jButton92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton92ActionPerformed(evt);
            }
        });

        jButton93.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton93.setText("Exit");
        jButton93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton93ActionPerformed(evt);
            }
        });

        jButton94.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton94.setText("Display");
        jButton94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton94ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B73, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B74, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B75, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B76, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B77, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B78, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B79, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B80, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B81, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B64, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B65, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B66, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B67, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B68, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B69, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B70, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B71, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B72, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B55, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B56, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B57, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B58, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B59, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B60, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B61, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B62, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B63, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B46, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B47, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B48, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B49, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B50, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B51, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B52, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B53, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B54, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B37, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B38, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B39, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B40, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B41, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B42, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B43, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B44, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B45, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B28, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B29, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B30, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B31, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B32, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B33, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B34, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B35, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B36, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B20, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B21, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B22, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B23, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B24, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B25, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B26, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(i1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(i3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B25, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B30, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B32, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B33, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B31, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B35, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B36, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B34, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B38, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B39, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B41, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B42, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B40, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B44, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B45, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B43, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B47, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B48, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B46, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B50, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B51, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B49, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B53, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B54, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B52, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B56, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B57, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B55, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B59, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B60, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B58, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B62, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B63, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B61, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B65, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B66, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B64, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B68, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B69, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B67, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B71, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B72, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B70, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B74, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B75, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B73, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B77, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B78, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B76, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B80, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B81, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B79, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(i2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B8ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,7);
    }//GEN-LAST:event_B8ActionPerformed

    private void B17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B17ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,7);
    }//GEN-LAST:event_B17ActionPerformed

    private void B26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B26ActionPerformed
        // TODO add your handling code here:
         setValueInInput(2,7);
    }//GEN-LAST:event_B26ActionPerformed

    private void B53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B53ActionPerformed
        // TODO add your handling code here:
        setValueInInput(5,7);
    }//GEN-LAST:event_B53ActionPerformed

    private void B35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B35ActionPerformed
        // TODO add your handling code here:
         setValueInInput(3,7);
    }//GEN-LAST:event_B35ActionPerformed

    private void B44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B44ActionPerformed
        // TODO add your handling code here:
         setValueInInput(4,7);
    }//GEN-LAST:event_B44ActionPerformed

    private void B80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B80ActionPerformed
        // TODO add your handling code here:
         setValueInInput(8,7);
    }//GEN-LAST:event_B80ActionPerformed

    private void B62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B62ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,7);
    }//GEN-LAST:event_B62ActionPerformed

    private void B71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B71ActionPerformed
        // TODO add your handling code here:
        setValueInInput(7,7);
    }//GEN-LAST:event_B71ActionPerformed

    private void i1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i1ActionPerformed
        // TODO add your handling code here:
        selectNumber(1);
    }//GEN-LAST:event_i1ActionPerformed

    private void i2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i2ActionPerformed
        // TODO add your handling code here:
        selectNumber(2);
    }//GEN-LAST:event_i2ActionPerformed

    private void i3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i3ActionPerformed
        // TODO add your handling code here:
        selectNumber(3);
    }//GEN-LAST:event_i3ActionPerformed

    private void i4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i4ActionPerformed
        // TODO add your handling code here:
        selectNumber(4);
    }//GEN-LAST:event_i4ActionPerformed

    private void i5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i5ActionPerformed
        // TODO add your handling code here:
        selectNumber(5);
    }//GEN-LAST:event_i5ActionPerformed

    private void i6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i6ActionPerformed
        // TODO add your handling code here:
        selectNumber(6);
    }//GEN-LAST:event_i6ActionPerformed

    private void i7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i7ActionPerformed
        // TODO add your handling code here:
        selectNumber(7);
    }//GEN-LAST:event_i7ActionPerformed

    private void i8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i8ActionPerformed
        // TODO add your handling code here:
        selectNumber(8);
    }//GEN-LAST:event_i8ActionPerformed

    private void i9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i9ActionPerformed
        // TODO add your handling code here:
        selectNumber(9);
    }//GEN-LAST:event_i9ActionPerformed

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,0);
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,1);
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,2);
    }//GEN-LAST:event_B3ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,3);
    }//GEN-LAST:event_B4ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,4);
    }//GEN-LAST:event_B5ActionPerformed

    private void B6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B6ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,5);
    }//GEN-LAST:event_B6ActionPerformed

    private void B7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B7ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,6);
    }//GEN-LAST:event_B7ActionPerformed

    private void B9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B9ActionPerformed
        // TODO add your handling code here:
        setValueInInput(0,8);
    }//GEN-LAST:event_B9ActionPerformed

    private void B10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B10ActionPerformed
        // TODO add your handling code here:
        setValueInInput(1,0);
    }//GEN-LAST:event_B10ActionPerformed

    private void B11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B11ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,1);
    }//GEN-LAST:event_B11ActionPerformed

    private void B12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B12ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,2);
    }//GEN-LAST:event_B12ActionPerformed

    private void B13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B13ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,3);
    }//GEN-LAST:event_B13ActionPerformed

    private void B14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B14ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,4);
    }//GEN-LAST:event_B14ActionPerformed

    private void B15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B15ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,5);
    }//GEN-LAST:event_B15ActionPerformed

    private void B16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B16ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,6);
    }//GEN-LAST:event_B16ActionPerformed

    private void B18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B18ActionPerformed
        // TODO add your handling code here:
         setValueInInput(1,8);
    }//GEN-LAST:event_B18ActionPerformed

    private void B19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B19ActionPerformed
        // TODO add your handling code here:
         setValueInInput(2,0);
    }//GEN-LAST:event_B19ActionPerformed

    private void B20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B20ActionPerformed
        // TODO add your handling code here:
         setValueInInput(2,1);
    }//GEN-LAST:event_B20ActionPerformed

    private void B21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B21ActionPerformed
        // TODO add your handling code here:
         setValueInInput(2,2);
    }//GEN-LAST:event_B21ActionPerformed

    private void B22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B22ActionPerformed
 
        // TODO add your handling code here:
         setValueInInput(2,3);
    }//GEN-LAST:event_B22ActionPerformed

    private void B23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B23ActionPerformed
        // TODO add your handling code here:
         setValueInInput(2,4);
    }//GEN-LAST:event_B23ActionPerformed

    private void B24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B24ActionPerformed
        // TODO add your handling code here:
         setValueInInput(2,5);
    }//GEN-LAST:event_B24ActionPerformed

    private void B25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B25ActionPerformed
        // TODO add your handling code here:
         setValueInInput(2,6);
    }//GEN-LAST:event_B25ActionPerformed

    private void B27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B27ActionPerformed
        // TODO add your handling code here:
         setValueInInput(2,8);
    }//GEN-LAST:event_B27ActionPerformed

    private void B28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B28ActionPerformed
        // TODO add your handling code here:
         setValueInInput(3,0);
    }//GEN-LAST:event_B28ActionPerformed

    private void B29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B29ActionPerformed
        // TODO add your handling code here:
         setValueInInput(3,1);
    }//GEN-LAST:event_B29ActionPerformed

    private void B30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B30ActionPerformed
        // TODO add your handling code here:
         setValueInInput(3,2);
    }//GEN-LAST:event_B30ActionPerformed

    private void B31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B31ActionPerformed
        // TODO add your handling code here:
         setValueInInput(3,3);
    }//GEN-LAST:event_B31ActionPerformed

    private void B32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B32ActionPerformed
        // TODO add your handling code here:
         setValueInInput(3,4);
    }//GEN-LAST:event_B32ActionPerformed

    private void B33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B33ActionPerformed
        // TODO add your handling code here:
         setValueInInput(3,5);
    }//GEN-LAST:event_B33ActionPerformed

    private void B34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B34ActionPerformed
        // TODO add your handling code here:
         setValueInInput(3,6);
    }//GEN-LAST:event_B34ActionPerformed

    private void B36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B36ActionPerformed
        // TODO add your handling code here:
         setValueInInput(3,8);
    }//GEN-LAST:event_B36ActionPerformed

    private void B37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B37ActionPerformed
        // TODO add your handling code here:
         setValueInInput(4,0);
    }//GEN-LAST:event_B37ActionPerformed

    private void B38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B38ActionPerformed
        // TODO add your handling code here:
         setValueInInput(4,1);
    }//GEN-LAST:event_B38ActionPerformed

    private void B39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B39ActionPerformed
        // TODO add your handling code here:
         setValueInInput(4,2);
    }//GEN-LAST:event_B39ActionPerformed

    private void B40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B40ActionPerformed
        // TODO add your handling code here:
         setValueInInput(4,3);
    }//GEN-LAST:event_B40ActionPerformed

    private void B41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B41ActionPerformed
        // TODO add your handling code here:
         setValueInInput(4,4);
    }//GEN-LAST:event_B41ActionPerformed

    private void B42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B42ActionPerformed
        // TODO add your handling code here:
         setValueInInput(4,5);
    }//GEN-LAST:event_B42ActionPerformed

    private void B43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B43ActionPerformed
        // TODO add your handling code here:
         setValueInInput(4,6);
    }//GEN-LAST:event_B43ActionPerformed

    private void B45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B45ActionPerformed
        // TODO add your handling code here:
         setValueInInput(4,8);
    }//GEN-LAST:event_B45ActionPerformed

    private void B46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B46ActionPerformed
        // TODO add your handling code here:
         setValueInInput(5,0);
    }//GEN-LAST:event_B46ActionPerformed

    private void B47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B47ActionPerformed
        // TODO add your handling code here:
        setValueInInput(5,1);
    }//GEN-LAST:event_B47ActionPerformed

    private void B48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B48ActionPerformed
        // TODO add your handling code here:
        setValueInInput(5,2);
    }//GEN-LAST:event_B48ActionPerformed

    private void B49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B49ActionPerformed
        // TODO add your handling code here:
        setValueInInput(5,3);
    }//GEN-LAST:event_B49ActionPerformed

    private void B50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B50ActionPerformed
        // TODO add your handling code here:
        setValueInInput(5,4);
    }//GEN-LAST:event_B50ActionPerformed

    private void B51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B51ActionPerformed
        // TODO add your handling code here:
        setValueInInput(5,5);
    }//GEN-LAST:event_B51ActionPerformed

    private void B52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B52ActionPerformed
        // TODO add your handling code here:
        setValueInInput(5,6);
    }//GEN-LAST:event_B52ActionPerformed

    private void B54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B54ActionPerformed
        // TODO add your handling code here:
        setValueInInput(5,8);
    }//GEN-LAST:event_B54ActionPerformed

    private void B55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B55ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,0);
    }//GEN-LAST:event_B55ActionPerformed

    private void B56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B56ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,1);
    }//GEN-LAST:event_B56ActionPerformed

    private void B57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B57ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,2);
    }//GEN-LAST:event_B57ActionPerformed

    private void B58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B58ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,3);
    }//GEN-LAST:event_B58ActionPerformed

    private void B59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B59ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,4);
    }//GEN-LAST:event_B59ActionPerformed

    private void B60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B60ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,5);
    }//GEN-LAST:event_B60ActionPerformed

    private void B61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B61ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,6);
    }//GEN-LAST:event_B61ActionPerformed

    private void B63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B63ActionPerformed
        // TODO add your handling code here:
        setValueInInput(6,8);
    }//GEN-LAST:event_B63ActionPerformed

    private void B64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B64ActionPerformed
        // TODO add your handling code here:
        setValueInInput(7,0);
    }//GEN-LAST:event_B64ActionPerformed

    private void B65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B65ActionPerformed
        // TODO add your handling code here:
        setValueInInput(7,1);
    }//GEN-LAST:event_B65ActionPerformed

    private void B66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B66ActionPerformed
        // TODO add your handling code here:
        setValueInInput(7,2);
    }//GEN-LAST:event_B66ActionPerformed

    private void B67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B67ActionPerformed
        // TODO add your handling code here:
        setValueInInput(7,3);
    }//GEN-LAST:event_B67ActionPerformed

    private void B68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B68ActionPerformed
        // TODO add your handling code here:
        setValueInInput(7,4);
    }//GEN-LAST:event_B68ActionPerformed

    private void B69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B69ActionPerformed
        // TODO add your handling code here:
        setValueInInput(7,5);
    }//GEN-LAST:event_B69ActionPerformed

    private void B70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B70ActionPerformed
        // TODO add your handling code here:
        setValueInInput(7,6);
    }//GEN-LAST:event_B70ActionPerformed

    private void B72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B72ActionPerformed
        // TODO add your handling code here:
        setValueInInput(7,8);
    }//GEN-LAST:event_B72ActionPerformed

    private void B73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B73ActionPerformed
        // TODO add your handling code here:
        setValueInInput(8,0);
    }//GEN-LAST:event_B73ActionPerformed

    private void B74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B74ActionPerformed
        // TODO add your handling code here:
         setValueInInput(8,1);
    }//GEN-LAST:event_B74ActionPerformed

    private void B75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B75ActionPerformed
        // TODO add your handling code here:
         setValueInInput(8,2);
    }//GEN-LAST:event_B75ActionPerformed

    private void B76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B76ActionPerformed
        // TODO add your handling code here:
         setValueInInput(8,3);
    }//GEN-LAST:event_B76ActionPerformed

    private void B77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B77ActionPerformed
        // TODO add your handling code here:
         setValueInInput(8,4);
    }//GEN-LAST:event_B77ActionPerformed

    private void B78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B78ActionPerformed
        // TODO add your handling code here:
         setValueInInput(8,5);
    }//GEN-LAST:event_B78ActionPerformed

    private void B79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B79ActionPerformed
        // TODO add your handling code here:
         setValueInInput(8,6);
    }//GEN-LAST:event_B79ActionPerformed

    private void B81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B81ActionPerformed
        // TODO add your handling code here:
         setValueInInput(8,8);
    }//GEN-LAST:event_B81ActionPerformed

    private void jButton93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton93ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_jButton93ActionPerformed

    private void jButton94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton94ActionPerformed
        // TODO add your handling code here:
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    boardInputs[i][j].setBackground(Color.white);
                    boardInputs[i][j].setText(Integer.toString(solution[i][j]));
                    
                }
                
            }
            
        }
    }//GEN-LAST:event_jButton94ActionPerformed

    private void jButton92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton92ActionPerformed
        // TODO add your handling code here:
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    boardInputs[i][j].setText("");
                    boardInputs[i][j].setBackground(Color.white);
                }
            }
        }
    }//GEN-LAST:event_jButton92ActionPerformed

    private void jButton89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton89ActionPerformed
        // TODO add your handling code here:
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    JButton cur_btn=boardInputs[i][j];
                    if(!cur_btn.getText().isEmpty()){
                        int num=Integer.parseInt(cur_btn.getText());
                        if(num==solution[i][j]) cur_btn.setBackground(Color.green);
                        else cur_btn.setBackground(Color.red);
                        
                    }
                    
                }
            }
        }
    }//GEN-LAST:event_jButton89ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sudoku().setVisible(true);
            }
        });
      //  System.out.println("Hello!");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B10;
    private javax.swing.JButton B11;
    private javax.swing.JButton B12;
    private javax.swing.JButton B13;
    private javax.swing.JButton B14;
    private javax.swing.JButton B15;
    private javax.swing.JButton B16;
    private javax.swing.JButton B17;
    private javax.swing.JButton B18;
    private javax.swing.JButton B19;
    private javax.swing.JButton B2;
    private javax.swing.JButton B20;
    private javax.swing.JButton B21;
    private javax.swing.JButton B22;
    private javax.swing.JButton B23;
    private javax.swing.JButton B24;
    private javax.swing.JButton B25;
    private javax.swing.JButton B26;
    private javax.swing.JButton B27;
    private javax.swing.JButton B28;
    private javax.swing.JButton B29;
    private javax.swing.JButton B3;
    private javax.swing.JButton B30;
    private javax.swing.JButton B31;
    private javax.swing.JButton B32;
    private javax.swing.JButton B33;
    private javax.swing.JButton B34;
    private javax.swing.JButton B35;
    private javax.swing.JButton B36;
    private javax.swing.JButton B37;
    private javax.swing.JButton B38;
    private javax.swing.JButton B39;
    private javax.swing.JButton B4;
    private javax.swing.JButton B40;
    private javax.swing.JButton B41;
    private javax.swing.JButton B42;
    private javax.swing.JButton B43;
    private javax.swing.JButton B44;
    private javax.swing.JButton B45;
    private javax.swing.JButton B46;
    private javax.swing.JButton B47;
    private javax.swing.JButton B48;
    private javax.swing.JButton B49;
    private javax.swing.JButton B5;
    private javax.swing.JButton B50;
    private javax.swing.JButton B51;
    private javax.swing.JButton B52;
    private javax.swing.JButton B53;
    private javax.swing.JButton B54;
    private javax.swing.JButton B55;
    private javax.swing.JButton B56;
    private javax.swing.JButton B57;
    private javax.swing.JButton B58;
    private javax.swing.JButton B59;
    private javax.swing.JButton B6;
    private javax.swing.JButton B60;
    private javax.swing.JButton B61;
    private javax.swing.JButton B62;
    private javax.swing.JButton B63;
    private javax.swing.JButton B64;
    private javax.swing.JButton B65;
    private javax.swing.JButton B66;
    private javax.swing.JButton B67;
    private javax.swing.JButton B68;
    private javax.swing.JButton B69;
    private javax.swing.JButton B7;
    private javax.swing.JButton B70;
    private javax.swing.JButton B71;
    private javax.swing.JButton B72;
    private javax.swing.JButton B73;
    private javax.swing.JButton B74;
    private javax.swing.JButton B75;
    private javax.swing.JButton B76;
    private javax.swing.JButton B77;
    private javax.swing.JButton B78;
    private javax.swing.JButton B79;
    private javax.swing.JButton B8;
    private javax.swing.JButton B80;
    private javax.swing.JButton B81;
    private javax.swing.JButton B9;
    private javax.swing.JButton i1;
    private javax.swing.JButton i2;
    private javax.swing.JButton i3;
    private javax.swing.JButton i4;
    private javax.swing.JButton i5;
    private javax.swing.JButton i6;
    private javax.swing.JButton i7;
    private javax.swing.JButton i8;
    private javax.swing.JButton i9;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
