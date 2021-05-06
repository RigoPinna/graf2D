
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
    public double vectorPuntos[][] = new double[2][7];
    public double vPuntosTrasladados[][];
    double tx=0, ty=0,t2x=2,t2y=-2;
    int btnGraf=-1, btnAplicar=-1, btnRestaurar=-1;
    Color original=new Color(0,153,204);
    Color traslacion= new Color(255,102,102);
    Color tras2 = new Color(153,0,255);
    Operations op = new Operations();
    public double [][] getVectorP (){
         this.vectorPuntos = op.asignarPuntos();
        return this.vectorPuntos;
    }
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
    public double getT2x() {
        return tx;
    }
    public void setT2x(double tx) {
        this.t2x = tx;
    }
    public double getT2y() {
        return ty;
    }
    public void setT2y(double ty) {
        this.t2y = ty;
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
        this.vectorPuntos = op.asignarPuntos();
    }
    public void setTamañoS(TraslacionesR v){
        this.setBounds(0,0,v.jPlano2.getWidth(), v.jPlano2.getHeight());
        ejeXx1=0;
        ejeXx2=v.jPlano2.getWidth();
        ejeXy= (v.jPlano2.getHeight()/2);
        ejeYx1= (v.jPlano2.getWidth()/2);
        ejeYy1=0;
        ejeYy2=v.jPlano2.getHeight(); 
        this.vectorPuntos = op.asignarPuntos();
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
            this.vectorPuntos = op.asignarPuntos();
            op.dibujarFigura(g, this.original,vectorPuntos,0);
        }
        if(this.btnAplicar==1){
            this.vectorPuntos = op.asignarPuntos();
            op.dibujarFigura(g, this.original,vectorPuntos,0);
            double v [][] = aplicarTraslacion(tx, ty, this.vectorPuntos);
            op.dibujarFigura(g, this.traslacion,v,1);
        }
        if(this.btnAplicar==2){
            this.vectorPuntos = op.asignarPuntos();
            op.dibujarFigura(g, this.original,vectorPuntos,0);
            double v [][] = aplicarTraslacion(tx, ty, this.vectorPuntos);
            op.dibujarFigura(g, this.traslacion,v,1);
            double v2 [][] = aplicarTraslacion(t2x, t2y, v);
            op.dibujarFigura(g, this.tras2,v2,2);
            
        }
        if(this.btnRestaurar==1){
            this.restaurar();
        }
    }
    public void restaurar(){
        this.tx=0;
        this.ty=0;
        
    }
    public double[][] aplicarTraslacion(double tx, double ty, double [][] vectorPuntos){
        this.vPuntosTrasladados = new double[2][7];
        double traslacion[]={tx,ty};
        System.out.println("entra22");
        for(int i=0; i<7; i++){
            for(int j=0; j<2; j++){
                vPuntosTrasladados[j][i]= vectorPuntos[j][i]+traslacion[j];
            }
        }
        return vPuntosTrasladados;
    }
    

}
