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
    public double vectorPuntos[][] = new double[2][7];
    public double vPuntosEscalacion[][];
    double sx=0, sy=0, sx2=0, sy2=0;
    int btnGraf=-1, btnAplicar=-1, btnRestaurar=-1;
    Color original=new Color(0,153,204);
    Color escalacion= new Color(255,102,102);
    Color esca2 = new Color(153,0,255);
    Operations op = new Operations();

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
     public double getSx2() {
        return sx2;
    }
    public void setSx2(double sx) {
        this.sx2 = sx;
    }
    public double getSy2() {
        return sy2;
    }

    public void setSy2(double sy) {
        this.sy2 = sy;
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
    public void setTamañoS(EscalacionS v){
        this.setBounds(0,0,v.jPlano2.getWidth(), v.jPlano2.getHeight());
        ejeXx1=0;
        ejeXx2=v.jPlano2.getWidth();
        ejeXy= (v.jPlano2.getHeight()/2);
        ejeYx1= (v.jPlano2.getWidth()/2);
        ejeYy1=0;
        ejeYy2=v.jPlano2.getHeight(); 
        this.vectorPuntos = op.asignarPuntos();
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
            this.vectorPuntos = op.asignarPuntos();
            op.dibujarFigura(g, this.original,vectorPuntos,0);
        }
        if(this.btnAplicar==1){
            this.vectorPuntos = op.asignarPuntos();
            op.dibujarFigura( g, this.original,vectorPuntos,0);
            double v [][] = aplicarEscalacion(sx, sy, this.vectorPuntos);
            op.dibujarFigura(g, this.escalacion,v,1);
        }
         if(this.btnAplicar==2){
            this.vectorPuntos = op.asignarPuntos();
            op.dibujarFigura(g, this.original,vectorPuntos,0);
            double v [][] = aplicarEscalacion(sx, sy, this.vectorPuntos);
            op.dibujarFigura(g, this.escalacion,v,1);
             System.out.println(sx2+","+sy2);
            double v2 [][] = aplicarEscalacion(sx2, sy2, v);
            op.dibujarFigura(g, this.esca2,v2,2);
            
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
         this.vectorPuntos = op.asignarPuntos();
    }
    public double[][] aplicarEscalacion(double tx, double ty, double [][] vectorPuntos){
        this.vPuntosEscalacion= new double[2][7];
        double escalacion[]= { tx,ty };
        for(int i=0; i<7; i++){
            for(int j=0; j<2; j++){
                vPuntosEscalacion[j][i]=(double)vectorPuntos[j][i]*escalacion[j];
            }
        }
        return vPuntosEscalacion;
    }
    public double [][] getVectorP (){
         this.vectorPuntos = op.asignarPuntos();
        return this.vectorPuntos;
    }
    public void restaurar(){
        this.sx=0;
        this.sy=0;
        
    }   
    }
    
    
