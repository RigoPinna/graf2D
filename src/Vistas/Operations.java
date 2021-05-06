package Vistas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Operations {
    public void dibujarPuntos(Graphics g, double [][] puntos){
        for(int i = 0; i<7; i++){
            g.fillOval(setXPixel(puntos[0][i])-4, setYPixel(puntos[1][i])-4,8,8);
            if( i+1 < 7 ) {
                 g.drawLine(
                         setXPixel(puntos[0][i]), setYPixel(puntos[1][i]),
                         setXPixel(puntos[0][i+1]), setYPixel(puntos[1][i+1])
                 );
            }
        }
    }
    public void dibujarFigura(Graphics g, Color c, double [][] vector,int typeFigure){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        g.setColor(c);
        dibujarPuntos(g,vector);
        this.escribirPuntos(g,vector, typeFigure);  
    }
    public void escribirPuntos(Graphics g, double [][] puntos, int type){
        switch(type){
            case 0:
                for(int i=0; i<7; i++){
                    if((i==0)||(i==5)){
                        g.drawString("P"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])+12);
                    }else if((i==1)||(i==3)||(i==4)||(i==6)){
                        g.drawString("P"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])-8);   
                    }else if(i==2){
                        g.drawString("P"+(i+1),setXPixel(puntos[0][i])+8,setYPixel(puntos[1][i])-4);
                    }
                }
                break;
            case 1:
                for(int i=0; i<7; i++){
                    if((i==0)||(i==5)){
                        g.drawString("P'"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])+12);
                    }else if((i==1)||(i==3)||(i==4)||(i==6)){
                        g.drawString("P'"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])-8);   
                    }else if(i==2){
                        g.drawString("P'"+(i+1),setXPixel(puntos[0][i])+8,setYPixel(puntos[1][i])-4);
                    }
                }
                break;
            case 2: 
                for(int i=0; i<7; i++){
                    if((i==0)||(i==5)){
                        g.drawString("P''"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])+12);
                    }else if((i==1)||(i==3)||(i==4)||(i==6)){
                        g.drawString("P''"+(i+1),setXPixel(puntos[0][i])-4,setYPixel(puntos[1][i])-8);   
                    }else if(i==2){
                        g.drawString("P''"+(i+1),setXPixel(puntos[0][i])+8,setYPixel(puntos[1][i])-4);
                    }
                                }
                break;
            default: 
                break;
        }
    }
    public int setXPixel(double x){return ((int)(300+(x*20)));}
    public int setYPixel(double y){return ((int)(300-(y*20)));}
    public double[][] asignarPuntos(){
        double vectorPuntos[][] = new double[2][7];
        vectorPuntos[0][0]=5;
        vectorPuntos[1][0]=1;
        
        vectorPuntos[0][1]=3;
        vectorPuntos[1][1]=5;
        
        vectorPuntos[0][2]=5;
        vectorPuntos[1][2]=5;
        
        vectorPuntos[0][3]=7;
        vectorPuntos[1][3]=1;
        
        vectorPuntos[0][4]=9;
        vectorPuntos[1][4]=5;
        
        vectorPuntos[0][5]=11;
        vectorPuntos[1][5]=5;
        
        vectorPuntos[0][6]=9;
        vectorPuntos[1][6]=1;
        
        return vectorPuntos;
    }
}
