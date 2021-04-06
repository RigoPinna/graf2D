
package Vistas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class PlanoTraslaciones extends JPanel {
    int ejeXx1,ejeXx2, ejeXy;
    int ejeYx1, ejeYy1,ejeYy2;
    public int vectorPuntos[][] = new int[2][5];
    public double vPuntosTrasladados[][];
    double tx=0, ty=0;
    int btnGraf=-1, btnAplicar=-1, btnRestaurar=-1;
    Color original=new Color(0,204,102);
    Color traslacion= new Color(204,102,0);
    public double getTx() {
        return tx;
    }
    public void setTx(double tx) {
        this.tx = tx;
    }
    public double getTy() {
        return ty;
    }
    public void setTy(double ty) {
        this.ty = ty;
    }
    public Color getOriginal() {
        return original;
    }
    public void setOriginal(Color original) {
        this.original = original;
    }
    public Color getTraslacion() {
        return traslacion;
    }
    public void setTraslacion(Color traslacion) {
        this.traslacion = traslacion;
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
    public void setTamaño(Traslaciones v){
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
    public int setYPixel(double y){return ((int)(300-(y*20)));
    }
    public double[][] aplicarTraslacion(double tx, double ty){
        this.tx=tx; this.ty=ty;
        this.vPuntosTrasladados = new double[2][5];
        double traslacion[]={this.tx,this.ty};
        for(int i=0; i<5; i++){
            for(int j=0; j<2; j++){
                vPuntosTrasladados[j][i]=(double)vectorPuntos[j][i]+traslacion[j];
            }
        }
        return vPuntosTrasladados;
    } 
    @Override
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
            this.dibujarFigTrasladada(g,this.aplicarTraslacion(tx, ty),this.traslacion);

        }
        if(this.btnRestaurar==1){
            this.restaurar();
        }
    }
    public void dibujarFigura(Graphics g, Color c){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        g.setColor(c);
        dibujarPuntos(g);
        this.escribirPuntos(g,vectorPuntos);  
    }
    public void dibujarFigTrasladada(Graphics g, double v[][], Color c){
        g.setColor(c);
        for(int i=0; i<5;i++){
            g.fillOval(this.setXPixel(v[0][i])-4,this.setYPixel(v[1][i])-4,8,8);
            if(i+1<5){
            g.drawLine(this.setXPixel(v[0][i]),this.setYPixel(v[1][i]),this.setXPixel(v[0][i+1]),this.setYPixel(v[1][i+1]));
            }
        }
        this.escribirPuntosTras(g,this.vPuntosTrasladados);
    }
    public void restaurar(){
        this.tx=0;
        this.ty=0;
        
    }   
    public void escribirPuntos(Graphics g, int [][] puntos){
        for(int i=0; i<5; i++){
            if((i==0)||(i==5)){
                g.drawString("P"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])+12);
            }else if((i==1)||(i==3)||(i==4)||(i==6)){
                g.drawString("P"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])-8);   
            }else if(i==2){
                g.drawString("P"+(i+1),setXPixel(puntos[0][i])+8,setYPixel(puntos[1][i])-4);
            }
        }
    }
    public void escribirPuntosTras(Graphics g, double [][] puntos){
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

}
