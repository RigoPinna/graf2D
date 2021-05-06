package Vistas;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.Array;
import javax.swing.JPanel;

public class PlanoRotacion extends JPanel {
    Operations op = new Operations();
    int ejeXx1,ejeXx2, ejeXy;
    int ejeYx1, ejeYy1,ejeYy2;
    public double vectorPuntos[][] = new double[2][7];
    public double angulos[];
    public double radios[];
    public double vPuntosRotacion[][];
    double angulo, angulo2;
    int btnGraf=-1, btnAplicar=-1, btnRestaurar=-1;
    Color original=new Color(0,153,204);
    Color rotacion= new Color(255,102,102);
    Color rota2 = new Color(153,0,255);
    public double getAngulo() {
        return angulo;
    }
    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
    public void setAngulo2(double angulo) {
        this.angulo2 = angulo;
    }
    public void setTamaño(Rotacion v){
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
    public void setTamañoS(RotacionS v){
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

    public Color getRotacion() {
        return rotacion;
    }

    public void setRotacion(Color rotacion) {
        this.rotacion = rotacion;
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
        g.setColor(new Color(17,21,10));
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
            this.establecerAngulosRadios( vectorPuntos );
            op.dibujarFigura(g, this.original,vectorPuntos,0);
        }
        if(this.btnAplicar==1){
           this.vectorPuntos = op.asignarPuntos();
           op.dibujarFigura(g, this.original,vectorPuntos,0);
           op.dibujarFigura(g, this.rotacion, aplicarRotacion(angulo, getAngulos(vectorPuntos), getRadios(vectorPuntos)),1);
            //this.dibujarLineas(g);
        }
        if(this.btnAplicar==2){
           this.vectorPuntos = op.asignarPuntos();

           op.dibujarFigura(g, this.original,vectorPuntos,0);
           double v [][] = aplicarRotacion(angulo, getAngulos(vectorPuntos), getRadios(vectorPuntos));
           op.dibujarFigura(g, this.rotacion,v,1);
           op.dibujarFigura(g, this.rota2, aplicarRotacion(angulo2, getAngulos(v), getRadios(v)),2);
            //this.dibujarLineas(g);
        }
        
        if(this.btnRestaurar==1){
            this.restaurar();
        }
    }
     public void  establecerAngulosRadios( double[][]vectorPuntos){
        this.angulos = new double[7];
        this.radios = new double[7];
        for(int i=0; i<7; i++){
            angulos[i]=Math.toDegrees(Math.atan2(vectorPuntos[1][i],vectorPuntos[0][i]));
            radios[i]=Math.sqrt(Math.pow(vectorPuntos[0][i],2)+Math.pow(vectorPuntos[1][i],2));
            System.out.println(""+angulos[i]);
        }
        
    }
    public double[] getAngulos (double [][] vectorPuntos){
        double angulos[] = new double[7];
        for(int i=0; i<7; i++){
            angulos[i]=Math.toDegrees(Math.atan2(vectorPuntos[1][i],vectorPuntos[0][i]));

        }
        return angulos;
    }
    public double[] getRadios (double [][] vectorPuntos){
        double radios [] = new double[7];
        for(int i=0; i<7; i++){
            radios[i]=Math.sqrt(Math.pow(vectorPuntos[0][i],2)+Math.pow(vectorPuntos[1][i],2));
        }
        return radios;
    }
    
     public double[][] aplicarRotacion(double angulo, double []angulos, double []radios){
        this.angulo=angulo;
        this.vPuntosRotacion= new double[2][7];
        for(int i=0; i<7; i++){
            vPuntosRotacion[0][i]=(radios[i])*(Math.cos(Math.toRadians(angulos[i]+this.angulo)));
            vPuntosRotacion[1][i]=(radios[i])*(Math.sin(Math.toRadians(angulos[i]+this.angulo)));
        }
        return vPuntosRotacion;
    }
     public void restaurar(){
        angulo=0;
    }
      public double [][] getVectorP (){
         this.vectorPuntos = op.asignarPuntos();
        return this.vectorPuntos;
    }
    
    
}
