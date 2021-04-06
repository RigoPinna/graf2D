package Vistas;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import javax.swing.JPanel;
public class PlanoEscalacion extends JPanel {
    int ejeXx1,ejeXx2, ejeXy;
    int ejeYx1, ejeYy1,ejeYy2;
    public int vectorPuntos[][] = new int[2][5];
    public double vPuntosEscalacion[][];
    double sx=0, sy=0;
    int btnGraf=-1, btnAplicar=-1, btnRestaurar=-1;
   Color original=new Color(0,204,102);
   Color escalacion= new Color(204,102,0);

    public double getSx() {
        return sx;
    }
    public void setSx(double sx) {
        this.sx = sx;
    }
    public double getSy() {
        return sy;
    }

    public void setSy(double sy) {
        this.sy = sy;
    }

    public int getBtnGraf() {
        return btnGraf;
    }

    public void setBtnGraf(int btnGraf) {
        this.btnGraf = btnGraf;
    }

    public int getBtnAplicar() {
        return btnAplicar;
    }

    public void setBtnAplicar(int btnAplicar) {
        this.btnAplicar = btnAplicar;
    }

    public int getBtnRestaurar() {
        return btnRestaurar;
    }

    public void setBtnRestaurar(int btnRestaurar) {
        this.btnRestaurar = btnRestaurar;
    }

    public Color getOriginal() {
        return original;
    }

    public void setOriginal(Color original) {
        this.original = original;
    }

    public Color getEscalacion() {
        return escalacion;
    }
    public void paintComponent(Graphics g){
        Color c = new Color(220,220,220);
        int x=-14;
        g.setFont(new Font("Consolas", Font.PLAIN,10));
        for(int i=0; i<=600; i+=20){
            g.setColor(c);
            g.drawLine(0, i,600, i);//y
            g.drawLine(i,0,i,600);//x
            g.setColor(Color.BLACK);
            if(i!=0){
                if(x<0){
                    g.drawLine(i,295, i,305);
                    g.drawString(""+x, i-10,315);
                    g.drawLine(295,i,305,i);
                    g.drawString(""+(-x),280, i+5);
                }else{
                    g.drawLine(i,295, i,305);
                    g.drawString(""+x, i,315);
                    if(x>0){
                    g.drawLine(295,i,305,i);
                     g.drawString(""+(-x),280, i+5);
                    }
                }
            x++;         
            }
        
        }
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(5));
        g.setColor(new Color(153,153,255));
        g.drawLine(0,0,0,600);
        g.drawLine(0,600,600,600);
        g.drawLine(0,0,600,0);
        g.drawLine(599,0,599,600);
        g2d.setStroke(new BasicStroke(1));
        g.setColor(Color.black);
        //EJE X
        g.drawLine(ejeXx1, ejeXy, ejeXx2, ejeXy);
        //EJE Y
        g.drawLine(ejeYx1, ejeYy1, ejeYx1, ejeYy2);
        //Fin del Plano
        //Inicio de la figura
        if(this.btnGraf==1){
            dibujarFigura(g, this.original);
        }
        if(this.btnAplicar==1){
            dibujarFigura(g, this.original);
            this.dibujarFigEscalada(g,this.aplicarEscalacion(sx, sy),this.escalacion);
            this.dibujarLineas(g);
        }
        if(this.btnRestaurar==1){
            this.restaurar();
        }
    }
    public void setEscalacion(Color escalacion) {
        this.escalacion = escalacion;
    }
    public void setTamaño(Escalacion v){
        System.out.println("Entra");
        this.setBounds(0,0,v.jPlano2.getWidth(), v.jPlano2.getHeight());
        ejeXx1=0;
        ejeXx2=v.jPlano2.getWidth();
        ejeXy= (v.jPlano2.getHeight()/2);
        ejeYx1= (v.jPlano2.getWidth()/2);
        ejeYy1=0;
        ejeYy2=v.jPlano2.getHeight();
        this.asignarPuntos();
        
    }
    public int setXPixel(double x){return ((int)(300+(x*20)));}
    public int setYPixel(double y){return ((int)(300-(y*20)));}
    public double[][] aplicarEscalacion(double tx, double ty){
        this.sx=sx; this.sy=sy;
        this.vPuntosEscalacion= new double[2][5];
        double escalacion[]={this.sx,this.sy};
        System.out.println("Entra");
        for(int i=0; i<5; i++){
            for(int j=0; j<2; j++){
                vPuntosEscalacion[j][i]=(double)vectorPuntos[j][i]*escalacion[j];
            }
        }
        return vPuntosEscalacion;
    }
  private void dibujarPuntos(Graphics g){
        g.fillOval(setXPixel(1)-4, setYPixel(5)-4,8,8);//P1
        g.fillOval(setXPixel(5)-4, setYPixel(5)-4,8,8);//P2
        g.fillOval(setXPixel(2)-4, setYPixel(3)-4,8,8);//P3
        g.fillOval(setXPixel(5)-4, setYPixel(1)-4,8,8);//P4
        g.fillOval(setXPixel(1)-4, setYPixel(1)-4,8,8);//P5
        g.drawLine(setXPixel(1), setYPixel(5),setXPixel(5), setYPixel(5));
        g.drawLine(setXPixel(5), setYPixel(5),setXPixel(2), setYPixel(3));
        g.drawLine(setXPixel(2), setYPixel(3),setXPixel(5), setYPixel(1));
        g.drawLine(setXPixel(5), setYPixel(1),setXPixel(1), setYPixel(1));
        
    }
    private void asignarPuntos(){
        vectorPuntos[0][0]=1;
        vectorPuntos[1][0]=5;
        
        vectorPuntos[0][1]=5;
        vectorPuntos[1][1]=5;
        
        vectorPuntos[0][2]=2;
        vectorPuntos[1][2]=3;
        
        vectorPuntos[0][3]=5;
        vectorPuntos[1][3]=1;
        
        vectorPuntos[0][4]=1;
        vectorPuntos[1][4]=1; 
    }
    public void dibujarFigura(Graphics g, Color c){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        g.setColor(c);
        this.dibujarPuntos(g);
        this.escribirPuntos(g,vectorPuntos);
        
    }
   
    public void dibujarFigEscalada(Graphics g, double v[][], Color c){
        g.setColor(c);
        for(int i=0; i<5;i++){
            g.fillOval(this.setXPixel(v[0][i])-4,this.setYPixel(v[1][i])-4,8,8);
            if(i+1<5){
            g.drawLine(this.setXPixel(v[0][i]),this.setYPixel(v[1][i]),this.setXPixel(v[0][i+1]),this.setYPixel(v[1][i+1]));
            }
        }
         
        this.escribirPuntosEsca(g,this.vPuntosEscalacion);
    }
    public void dibujarLineas(Graphics g){
        
        
    }
    public void escribirPuntos(Graphics g, int [][] puntos){
        for(int i=0; i<5; i++){
            if((i==0)||(i==5)||(i==7)){
                g.drawString("P"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])+12);
            }else if((i==1)||(i==3)||(i==4)||(i==6)){
                g.drawString("P"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])-8);   
            }else if(i==2){
                g.drawString("P"+(i+1),setXPixel(puntos[0][i])+8,setYPixel(puntos[1][i])-4);
            }
        }
    }
    public void escribirPuntosEsca(Graphics g, double [][] puntos){
        for(int i=0; i<5; i++){
            if((i==0)||(i==5)){
                g.drawString("P'"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])+12);
            }else if((i==1)||(i==3)||(i==4)){
                g.drawString("P'"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])-8);   
            }else if(i==2){
                g.drawString("P'"+(i+1),setXPixel(puntos[0][i])+8,setYPixel(puntos[1][i])-4);
            }
        }
    }
    public void restaurar(){
        this.sx=0;
        this.sy=0;
        
    }   
    }
    
    
