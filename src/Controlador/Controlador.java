
package Controlador;
import Vistas.Creditos;
import Vistas.Escalacion;
import Vistas.EscalacionS;
import Vistas.Menu;

import Vistas.PlanoEscalacion;
import Vistas.PlanoRotacion;

import Vistas.PlanoTraslaciones;
import Vistas.Portada;
import Vistas.Rotacion;
import Vistas.RotacionS;

import Vistas.Traslaciones;
import Vistas.TraslacionesR;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

/**
 *
 * @author Rigoberto
 */
public class Controlador implements ActionListener{
    Portada portadav ;
    Menu m;
    
    Traslaciones tr;
    PlanoTraslaciones ptr;
    TraslacionesR tr2;
    PlanoTraslaciones ptr2;
    
    Escalacion es;
    PlanoEscalacion pes;
    EscalacionS es2;
    PlanoEscalacion pes2;
    
    Rotacion rot;
    PlanoRotacion prt;
    RotacionS rot2;
    PlanoRotacion prt2;
    Creditos cr;
    Color original= new Color(0,102,102),original2= new Color(0,102,102),original3= new Color(0,102,102), traslacion= new Color (255,153,0),
            escalacion= new Color (255,153,0), rotacion= new Color (255,153,0);
    Color orTrS= new Color(0,102,102), trSus=new Color (255,153,0),  trSus2=new Color (153,0,153);
    Color orEsS= new Color(0,102,102), esSus=new Color (255,153,0),  esSus2=new Color (153,0,153);
    Color orRoS= new Color(0,102,102), RoSus=new Color (255,102,102),  RoSus2=new Color (0,204,204);
    public Controlador(Portada portadav,Menu m,Traslaciones tr, PlanoTraslaciones ptr, Escalacion es, PlanoEscalacion pes,
            Rotacion rot, PlanoRotacion prt, Creditos cr, TraslacionesR tr2, PlanoTraslaciones ptr2, EscalacionS es2, PlanoEscalacion pes2,RotacionS rot2, PlanoRotacion prt2){
        this.cr=cr;
        this.cr.btnMenu.addActionListener(this);
        this.m = m;
        this.m.btnCred.addActionListener(this);
        this.portadav=portadav;
        this.portadav.setVisible(true);
        this.portadav.BtnAv.addActionListener(this);     
        this.m.BtnEsca.addActionListener(this);
        this.m.btnEsc2.addActionListener(this);
        this.m.btnTras.addActionListener(this);
        this.m.btnTras2.addActionListener(this);
        this.m.btnRota.addActionListener(this);
        this.m.btnRota2.addActionListener(this);
        
        this.rot =rot;
        this.prt=prt;
        this.prt.setTamaño(this.rot);
        this.rot.jPlano2.add(this.prt);
        this.rot.btnGraf.addActionListener(this);
        this.rot.btnApl.addActionListener(this);
        this.rot.btnRestaurar.addActionListener(this);
        this.rot.jLineaO.setVisible(false);
        this.rot.txtDatosgraf.setVisible(false);
        this.rot.jLineaRota.setVisible(false);
        this.rot.txtDatosRota1.setVisible(false);
        this.rot.txtRota3.setVisible(false);
        this.rot.btnMenu.addActionListener(this);
       
        
        this.es = es;
        this.pes = pes;
        this.pes.setTamaño(this.es);
        this.es.jPlano2.add(this.pes);
        this.es.btnGraf.addActionListener(this);
        this.es.btnApl.addActionListener(this);
        this.es.btnRestaurar.addActionListener(this);
        this.es.jLineaO.setVisible(false);
        this.es.jLineaEsca.setVisible(false);
        this.es.txtDatosgraf.setVisible(false);
        this.es.txtDatosEsca1.setVisible(true);
        this.es.txtEsca.setVisible(true);

        this.es.btnMenu.addActionListener(this);
        
        this.tr = tr;
        this.ptr = ptr;
        this.ptr.setTamaño(this.tr);
        this.tr.jPlano2.add(this.ptr);
        this.tr.btnMenu.addActionListener(this);
        this.tr.btnGraf.addActionListener(this);
        this.tr.btnApl.addActionListener(this);
        this.tr.btnRestaurar.addActionListener(this);
        this.tr.jLineaO.setVisible(false);
        this.tr.txtDatosgraf.setVisible(false);
        this.tr.txtDatosTras.setVisible(false);
        this.tr.jLineaTras.setVisible(false);
        this.tr.txtDatosTras.setVisible(false);
        this.tr.txtDatosTras2.setVisible(false);
        this.tr.txtTraslacion.setVisible(false);
        
        
        this.tr2 = tr2;
        this.ptr2 = ptr2;
        this.ptr2.setTamañoS(this.tr2);
        this.tr2.jPlano2.add(this.ptr2);
        this.tr2.btnMenu.addActionListener(this);
        this.tr2.btnGraf.addActionListener(this);
        this.tr2.btnApl.addActionListener(this);
        this.tr2.btnApl2.addActionListener(this);
        this.tr2.btnRestaurar.addActionListener(this);
        this.tr2.jLineaO.setVisible(false);
        this.tr2.txtDatosgraf.setVisible(false);
        this.tr2.txtDatosTras.setVisible(false);
        this.tr2.jLineaTras.setVisible(false); 
        this.tr2.jLineaTras2.setVisible(false);
        this.tr2.txtDatosTras.setVisible(false);
        this.tr2.txtDatosTras2.setVisible(false);
        this.tr2.txtTraslacion.setVisible(false);
        this.tr2.txtDatos2.setVisible(false);
        
        this.es2 = es2;
        this.pes2 = pes2;
        this.pes2.setTamañoS(this.es2);
        this.es2.jPlano2.add(this.pes2);
        this.es2.btnMenu.addActionListener(this);
        this.es2.btnGraf.addActionListener(this);
        this.es2.btnApl.addActionListener(this);
        this.es2.btnApl2.addActionListener(this);
        this.es2.btnRestaurar.addActionListener(this);
        this.es2.jLineaO.setVisible(false);
        this.es2.txtDatosgraf.setVisible(false);
        this.es2.txtDatosTras.setVisible(false);
        this.es2.jLineaTras.setVisible(false); 
        this.es2.jLineaTras2.setVisible(false);
        this.es2.txtDatosTras.setVisible(false);
        this.es2.txtDatosTras2.setVisible(false);
        this.es2.txtTraslacion.setVisible(false);
        this.es2.txtDatos2.setVisible(false);
        this.rot2 =rot2;
        this.prt2 = prt2;
        this.prt2.setTamañoS(this.rot2);
        this.rot2.jPlano2.add(this.prt2);
        this.rot2.btnMenu.addActionListener(this);
        this.rot2.btnGraf.addActionListener(this);
        this.rot2.btnApl.addActionListener(this);
        this.rot2.btnApl2.addActionListener(this);
        this.rot2.btnRestaurar.addActionListener(this);
        this.rot2.jLineaO.setVisible(false);
        this.rot2.txtDatosgraf.setVisible(false);
        this.rot2.txtDatosTras.setVisible(false);
        this.rot2.jLineaTras.setVisible(false); 
        this.rot2.jLineaTras2.setVisible(false);
        this.rot2.txtDatosTras.setVisible(false);
        this.rot2.txtDatosTras2.setVisible(false);
        this.rot2.txtTraslacion.setVisible(false);
        this.rot2.txtDatos2.setVisible(false);
        this.tr.setVisible(false);
        this.tr2.setVisible(false);
        this.es2.setVisible(false);
        this.rot2.setVisible(false);
        this.es.setVisible(false);
        this.m.setVisible(false);  
        
    }
    
    public void tablaOr(JTable tabla, double [][] vector){
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Punto");
        modelo.addColumn(" X ");
        modelo.addColumn(" Y ");
        Object [] columna = new Object[3];
        for(int i=0; i<5; i++){
            columna[0]="P"+(i+1);
            columna[1]=this.ptr.vectorPuntos[0][i];
            columna[2]=this.ptr.vectorPuntos[1][i];
            modelo.addRow(columna);
        }
    }
    public void tablaTrasVaciar(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Punto");
        modelo.addColumn(" X ");
        modelo.addColumn(" Y ");
        Object [] columna = new Object[3];
        for(int i=0; i<5; i++){
            columna[0]="";
            columna[1]="";
            columna[2]="";
             modelo.addRow(columna);
        }
        
        
    }
    public void tablaPr1(JTable tabla, double [][] vector){
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Punto'");
        modelo.addColumn(" X' ");
        modelo.addColumn(" Y' ");
        Object [] columna = new Object[3];
        for(int i=0; i<7; i++){
            columna[0]="P'"+(i+1);
            columna[1]=vector[0][i];
            columna[2]=vector[1][i];
            modelo.addRow(columna);
        } 
    }
    public void tablaPr2(JTable tabla, double [][] vector){
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Punto''");
        modelo.addColumn(" X'' ");
        modelo.addColumn(" Y'' ");
        Object [] columna = new Object[3];
        for(int i=0; i<7; i++){
            columna[0]="P''"+(i+1);
            columna[1]=vector[0][i];
            columna[2]=vector[1][i];
            modelo.addRow(columna);
        } 
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(cr.btnMenu==e.getSource()){
            m.setVisible(true);
            cr.setVisible(false);
        }
        if(m.btnCred==e.getSource()){
            m.setVisible(false);
            cr.setVisible(true);
        }
        if(portadav.BtnAv==e.getSource()){
            portadav.setVisible(false);
             m.setVisible(true);
        }
        traslacionBasica( e );
        traslacionSus( e );
        
        escalacionBasica( e );
        escalacionSus( e );
        rotacionBasica( e );
        rotacionSucesiva( e );
    }
    public void traslacionBasica( ActionEvent e ) {
        if(tr.btnMenu==e.getSource()){
        m.setVisible(true);
        tr.setVisible(false);
        tr.btnGraf.setEnabled(true);
        tr.btnApl.setEnabled(false);
        tr.btnRestaurar.setEnabled(false);
        tr.jLineaO.setVisible(false);
        tr.jLineaTras.setVisible(false);
        tr.txtDatosTras.setVisible(false);
        tr.txtDatosTras2.setVisible(false);
        tr.txtDatosgraf.setVisible(false);
        tr.txtTraslacion.setVisible(false);
        tr.txtTx.setText("0");
        tr.txtTy.setText("-10");
        this.tablaTrasVaciar(tr.jTablaTras);
        this.tablaTrasVaciar(tr.jtablaOr);
        ptr.setBtnGraf(-1);
        ptr.setBtnAplicar(-1);
        ptr.setBtnRestaurar(-1);
        ptr.restaurar();
        tr.repaint();
        tr.txtTx.setEditable(false);
        tr.txtTy.setEditable(false);
    }
    if(m.btnTras==e.getSource()){
        m.setVisible(false);
        tr.setVisible(true);
        tr.btnApl.setEnabled(false);
    }
    if(tr.btnGraf==e.getSource()){
        ptr.setBtnGraf(1);
        ptr.setBtnAplicar(-1);
        ptr.setBtnRestaurar(-1);
        tr.repaint();
        tr.btnGraf.setEnabled(false);
        tr.btnApl.setEnabled(true);
        tr.btnRestaurar.setEnabled(false);
        tr.txtTx.setEditable(true);
        tr.txtTy.setEditable(true);
        this.tablaOr(tr.jtablaOr,ptr.getVectorP());
        this.tr.jLineaO.setVisible(true);
        this.tr.txtDatosgraf.setVisible(true);
    }
    if(tr.btnApl==e.getSource()){
        if(tr.txtTx.getText().isEmpty()==true){
            JOptionPane.showMessageDialog(null,"Error no a igresado los valores\n de traslación","Atención",JOptionPane.ERROR);
        }else{

            double tx =Double.parseDouble(tr.txtTx.getText());
            double ty =Double.parseDouble(tr.txtTy.getText());
                if((tx<16&&tx>-16)&&(ty<16&&ty>-16)){
                    ptr.setTx((double)tx);
                    ptr.setTy((double)ty);
                    tr.txtTraslacion.setText("("+tr.txtTx.getText()+","+tr.txtTy.getText()+")");
                    ptr.setBtnAplicar(1);
                    ptr.setBtnGraf(-1);
                    ptr.setBtnRestaurar(-1);
                    tr.btnGraf.setEnabled(false);
                    tr.btnRestaurar.setEnabled(true);
                    tr.repaint();
                    this.tablaPr1(tr.jTablaTras,this.ptr.aplicarTraslacion(tx, ty, this.ptr.vectorPuntos));
                    this.tr.jLineaTras.setVisible(true);
                    this.tr.txtDatosTras.setVisible(true);
                    this.tr.txtDatosTras2.setVisible(true);
                    this.tr.txtTraslacion.setVisible(true);    
            }
        }  
    }
     if(tr.btnRestaurar== e.getSource()){
        tr.btnGraf.setEnabled(true);
        tr.btnApl.setEnabled(false);
        tr.btnRestaurar.setEnabled(false);
        tr.jLineaO.setVisible(false);
        tr.jLineaTras.setVisible(false);
        tr.txtDatosTras.setVisible(false);
        tr.txtDatosTras2.setVisible(false);
        tr.txtDatosgraf.setVisible(false);
        tr.txtTraslacion.setVisible(false);
        tr.txtTx.setText("-10");
        tr.txtTy.setText("-5");
        this.tablaTrasVaciar(tr.jTablaTras);
        this.tablaTrasVaciar(tr.jtablaOr);
        ptr.setBtnGraf(-1);
        ptr.setBtnAplicar(-1);
        ptr.setBtnRestaurar(-1);
        ptr.restaurar();
        tr.repaint();
        tr.txtTx.setEditable(false);
        tr.txtTy.setEditable(false);
    }

    }
    public void traslacionSus( ActionEvent e) {
        if(tr2.btnMenu==e.getSource()){
            m.setVisible(true);
            tr2.setVisible(false);
            tr2.btnGraf.setEnabled(true);
            tr2.btnApl.setEnabled(false);
            tr2.btnApl2.setEnabled(false);
            tr2.btnRestaurar.setEnabled(false);
            tr2.jLineaO.setVisible(false);
            tr2.jLineaTras.setVisible(false);
            tr2.txtDatosTras.setVisible(false);
            tr2.txtDatosTras2.setVisible(false);
            tr2.txtDatosgraf.setVisible(false);
            tr2.txtTraslacion.setVisible(false);
            tr2.txtTx.setText("0");
            tr2.txtTy.setText("-10");
            tr2.txtTx2.setText("0");
            tr2.txtTy2.setText("-5");
            this.tablaTrasVaciar(tr2.jTablaTras);
            this.tablaTrasVaciar(tr2.jTablaTras2);
            this.tablaTrasVaciar(tr2.jtablaOr);
            ptr2.setBtnGraf(-1);
            ptr2.setBtnAplicar(-1);
            ptr2.setBtnRestaurar(-1);
            ptr2.restaurar();
            tr2.repaint();
            tr2.txtTx.setEditable(false);
            tr2.txtTy.setEditable(false);
            tr2.txtTx2.setEditable(false);
            tr2.txtTy2.setEditable(false);
        }
         if(m.btnTras2==e.getSource()){
            m.setVisible(false);
            tr2.setVisible(true);
            tr2.btnApl.setEnabled(false);
            tr2.btnApl2.setEnabled(false);
        }
        if(tr2.btnGraf==e.getSource()){
            ptr2.setBtnGraf(1);
            ptr2.setBtnAplicar(-1);
            ptr2.setBtnRestaurar(-1);
            tr2.repaint();
            tr2.btnGraf.setEnabled(false);
            tr2.btnApl.setEnabled(true);
            tr2.txtTx.setEditable(true);
            tr2.txtTy.setEditable(true);
            this.tablaOr(tr2.jtablaOr,ptr2.getVectorP());
            this.tr2.jLineaO.setVisible(true);
            this.tr2.txtDatosgraf.setVisible(true);
        }
        if(tr2.btnApl==e.getSource()){
            if(tr2.txtTx.getText().isEmpty()==true){
                JOptionPane.showMessageDialog(null,"Error no a igresado los valores\n de traslación","Atención",JOptionPane.ERROR);
            }else{
                
                double tx =Double.parseDouble(tr2.txtTx.getText());
                double ty =Double.parseDouble(tr2.txtTy.getText());
                    if((tx<16&&tx>-16)&&(ty<16&&ty>-16)){
                        ptr2.setTx((double)tx);
                        ptr2.setTy((double)ty);
                        tr2.txtTraslacion.setText("("+tr2.txtTx.getText()+","+tr2.txtTy.getText()+")");
                        ptr2.setBtnAplicar(1);
                        ptr2.setBtnGraf(-1);
                        ptr2.setBtnRestaurar(-1);
                        tr2.btnGraf.setEnabled(false);
                        tr2.repaint();
                        this.tablaPr1(tr2.jTablaTras,this.ptr2.aplicarTraslacion(tx, ty, this.ptr2.vectorPuntos));
                        this.tr2.jLineaTras.setVisible(true);
                        this.tr2.txtDatosTras.setVisible(true);
                        this.tr2.txtDatosTras2.setVisible(true);
                        this.tr2.txtTraslacion.setVisible(true);   
                        tr2.txtTx2.setEditable(true);
                        tr2.txtTy2.setEditable(true);
                        tr2.btnApl2.setEnabled(true);
                    }
                }  
            }
        if(tr2.btnApl2==e.getSource()){
            if(tr2.txtTx2.getText().isEmpty()==true){
                JOptionPane.showMessageDialog(null,"Error no a igresado los valores\n de traslación","Atención",JOptionPane.ERROR);
            }else{
                
                double tx2 =Double.parseDouble(tr2.txtTx2.getText());
                double ty2 =Double.parseDouble(tr2.txtTy2.getText());
                double tx =Double.parseDouble(tr2.txtTx.getText());
                double ty =Double.parseDouble(tr2.txtTy.getText());
                    if((tx2<16&&tx2>-16)&&(ty2<16&&ty2>-16)){
                        ptr2.setT2x((double)tx2);
                        ptr2.setT2y((double)ty2);
                        tr2.txtDatos2.setText("Figura con Traslación T2("+tr2.txtTx2.getText()+","+tr2.txtTy2.getText()+")");
                        ptr2.setBtnAplicar(2);
                        ptr2.setBtnGraf(-1);
                        ptr2.setBtnRestaurar(-1);
                        tr2.btnRestaurar.setEnabled(true);
                        tr2.jLineaTras2.setVisible(true);
                        tr2.txtDatos2.setVisible(true);
                        tr2.repaint();
                        double v2 [][] = this.ptr2.aplicarTraslacion(tx, ty, this.ptr2.vectorPuntos);
                        this.tablaPr2(tr2.jTablaTras2,this.ptr2.aplicarTraslacion(tx2, ty2, v2));

                    }
                }  
            }
        if(tr2.btnRestaurar== e.getSource()){
            tr2.btnGraf.setEnabled(true);
            tr2.btnApl.setEnabled(false);
            tr2.btnApl2.setEnabled(false);
            tr2.btnRestaurar.setEnabled(false);
            tr2.jLineaO.setVisible(false);
            tr2.jLineaTras.setVisible(false);
            tr2.jLineaTras2.setVisible(false);
            tr2.txtDatosTras.setVisible(false);
            tr2.txtDatosTras2.setVisible(false);
            tr2.txtDatosgraf.setVisible(false);
            tr2.txtTraslacion.setVisible(false);
            tr2.txtTx.setText("-10");
            tr2.txtTy.setText("0");
            tr2.txtTx2.setText("0");
            tr2.txtTy2.setText("-5");
            this.tablaTrasVaciar(tr2.jTablaTras);
            this.tablaTrasVaciar(tr2.jTablaTras2);
            this.tablaTrasVaciar(tr2.jtablaOr);
            ptr2.setBtnGraf(-1);
            ptr2.setBtnAplicar(-1);
            ptr2.setBtnRestaurar(-1);
            ptr2.restaurar();
            tr2.repaint();
            tr2.txtTx.setEditable(false);
            tr2.txtTy.setEditable(false);
            tr2.txtTx2.setEditable(false);
            tr2.txtTy2.setEditable(false);
            tr2.txtDatos2.setVisible(false);
        } 
    }
    public void escalacionSus( ActionEvent e ) {
          if(es2.btnMenu==e.getSource()){
            m.setVisible(true);
            es2.setVisible(false);
            es2.btnGraf.setEnabled(true);
            es2.btnApl.setEnabled(false);
            es2.btnApl2.setEnabled(false);
            es2.btnRestaurar.setEnabled(false);
            es2.jLineaO.setVisible(false);
            es2.jLineaTras.setVisible(false);
            es2.txtDatosTras.setVisible(false);
            es2.txtDatosTras2.setVisible(false);
            es2.txtDatosgraf.setVisible(false);
            es2.txtTraslacion.setVisible(false);
            es2.txtTx.setText("0");
            es2.txtTy.setText("-10");
            es2.txtTx2.setText("0");
            es2.txtTy2.setText("-5");
            this.tablaTrasVaciar(es2.jTablaTras);
            this.tablaTrasVaciar(es2.jTablaTras2);
            this.tablaTrasVaciar(es2.jtablaOr);
            pes2.setBtnGraf(-1);
            pes2.setBtnAplicar(-1);
            pes2.setBtnRestaurar(-1);
            pes2.restaurar();
            es2.repaint();
            es2.txtTx.setEditable(false);
            es2.txtTy.setEditable(false);
            es2.txtTx2.setEditable(false);
            es2.txtTy2.setEditable(false);
        }
         if(m.btnEsc2==e.getSource()){
            m.setVisible(false);
            es2.setVisible(true);
            es2.btnApl.setEnabled(false);
            es2.btnApl2.setEnabled(false);
        }
        if(es2.btnGraf==e.getSource()){
            pes2.setBtnGraf(1);
            pes2.setBtnAplicar(-1);
            pes2.setBtnRestaurar(-1);
            es2.repaint();
            es2.btnGraf.setEnabled(false);
            es2.btnApl.setEnabled(true);
            es2.txtTx.setEditable(true);
            es2.txtTy.setEditable(true);
            this.tablaOr(es2.jtablaOr,pes2.getVectorP());
            this.es2.jLineaO.setVisible(true);
            this.es2.txtDatosgraf.setVisible(true);
        }
        if(es2.btnApl==e.getSource()){
            if(es2.txtTx.getText().isEmpty()==true){
                JOptionPane.showMessageDialog(null,"Error no a igresado los valores\n de traslación","Atención",JOptionPane.ERROR);
            }else{
                
                double tx =Double.parseDouble(es2.txtTx.getText());
                double ty =Double.parseDouble(es2.txtTy.getText());
                    if((tx<16&&tx>-16)&&(ty<16&&ty>-16)){
                        pes2.setSx((double)tx);
                        pes2.setSy((double)ty);
                        es2.txtTraslacion.setText("("+es2.txtTx.getText()+","+es2.txtTy.getText()+")");
                        pes2.setBtnAplicar(1);
                        pes2.setBtnGraf(-1);
                        pes2.setBtnRestaurar(-1);
                        es2.btnGraf.setEnabled(false);
                        es2.repaint();
                        this.tablaPr1(es2.jTablaTras,this.pes2.aplicarEscalacion(tx, ty, this.pes.getVectorP()));
                        this.es2.jLineaTras.setVisible(true);
                        this.es2.txtDatosTras.setVisible(true);
                        this.es2.txtDatosTras2.setVisible(true);
                        this.es2.txtTraslacion.setVisible(true);   
                        es2.txtTx2.setEditable(true);
                        es2.txtTy2.setEditable(true);
                        es2.btnApl2.setEnabled(true);
                    }
                }  
            }
        if(es2.btnApl2==e.getSource()){
            if(es2.txtTx2.getText().isEmpty()==true){
                JOptionPane.showMessageDialog(null,"Error no a igresado los valores\n de traslación","Atención",JOptionPane.ERROR);
            }else{
                
                double tx2 =Double.parseDouble(es2.txtTx2.getText());
                double ty2 =Double.parseDouble(es2.txtTy2.getText());
                double tx =Double.parseDouble(es2.txtTx.getText());
                double ty =Double.parseDouble(es2.txtTy.getText());
                    if((tx2<16&&tx2>-16)&&(ty2<16&&ty2>-16)){
                        pes2.setSx2((double)tx2);
                        pes2.setSy2((double)ty2);
                        es2.txtDatos2.setText("Figura con Escalacón S2("+es2.txtTx2.getText()+","+es2.txtTy2.getText()+")");
                        pes2.setBtnAplicar(2);
                        pes2.setBtnGraf(-1);
                        pes2.setBtnRestaurar(-1);
                        es2.btnRestaurar.setEnabled(true);
                        es2.jLineaTras2.setVisible(true);
                        es2.txtDatos2.setVisible(true);
                        es2.repaint();
                        System.out.println(tx2+","+ty2);
                        double v2 [][] = this.pes2.aplicarEscalacion(tx, ty, this.pes.getVectorP());
                        this.tablaPr2(es2.jTablaTras2,this.pes2.aplicarEscalacion(tx2, ty2, v2));

                    }
                }  
            }
        if(es2.btnRestaurar== e.getSource()){
            es2.btnGraf.setEnabled(true);
            es2.btnApl.setEnabled(false);
            es2.btnApl2.setEnabled(false);
            es2.btnRestaurar.setEnabled(false);
            es2.jLineaO.setVisible(false);
            es2.jLineaTras.setVisible(false);
            es2.jLineaTras2.setVisible(false);
            es2.txtDatosTras.setVisible(false);
            es2.txtDatosTras2.setVisible(false);
            es2.txtDatosgraf.setVisible(false);
            es2.txtTraslacion.setVisible(false);
            es2.txtTx.setText("1.8");
            es2.txtTy.setText("1.8");
            es2.txtTx2.setText("0.5");
            es2.txtTy2.setText("0.5");
            this.tablaTrasVaciar(es2.jTablaTras);
            this.tablaTrasVaciar(es2.jTablaTras2);
            this.tablaTrasVaciar(es2.jtablaOr);
            pes2.setBtnGraf(-1);
            pes2.setBtnAplicar(-1);
            pes2.setBtnRestaurar(-1);
            pes2.restaurar();
            es2.repaint();
            es2.txtTx.setEditable(false);
            es2.txtTy.setEditable(false);
            es2.txtTx2.setEditable(false);
            es2.txtTy2.setEditable(false);
            es2.txtDatos2.setVisible(false);
        } 
        
    }
    public void escalacionBasica( ActionEvent e ) {
        if(m.BtnEsca==e.getSource()){
            m.setVisible(false);
            es.setVisible(true); 
            es.txtEsca.setVisible(false);
            es.txtDatosEsca.setVisible(false);
            es.txtEsca.setVisible(false);
            //es.jTablaEsca.setVisible(false);
            es.txtEsca.setVisible(false);
        }
        if(es.btnGraf==e.getSource()){
            pes.setBtnGraf(1);
            pes.setBtnAplicar(-1);
            pes.setBtnRestaurar(-1);
            es.repaint();
            es.btnGraf.setEnabled(false);
            es.btnApl.setEnabled(true);
            es.btnRestaurar.setEnabled(false);
            es.txtDatosEsca1.setEditable(true);
            es.txtDatosEsca2.setEditable(true);
            this.tablaOr(es.jtablaOr,pes.getVectorP());
            this.es.jLineaO.setVisible(true);
            this.es.txtDatosgraf.setVisible(true);
        }
        if(es.btnApl==e.getSource()){
            if(es.txtDatosEsca1.getText().isEmpty()==true){
                JOptionPane.showMessageDialog(null,"Error no a igresado los valores\n de traslación","Atención",JOptionPane.ERROR);
            }else{
                
                double sx =Double.parseDouble(es.txtDatosEsca1.getText());
                double sy =Double.parseDouble(es.txtDatosEsca2.getText());
                    if((sx<16&&sx>-16)&&(sy<16&&sy>-16)){
                        pes.setSx((double)sx);
                        pes.setSy((double)sy);
                        es.txtEsca.setText("("+es.txtDatosEsca1.getText()+","+es.txtDatosEsca2.getText()+")");
                        pes.setBtnAplicar(1);
                        pes.setBtnGraf(-1);
                        pes.setBtnRestaurar(-1);
                        es.btnGraf.setEnabled(false);
                        es.btnRestaurar.setEnabled(true);
                        es.repaint();
                        this.tablaPr1(es.jTablaEsca,this.pes.aplicarEscalacion(sx, sy, this.pes.getVectorP()));
                        this.es.jLineaEsca.setVisible(true);
                        this.es.txtDatosEsca1.setVisible(true);
                        this.es.txtDatosEsca2.setVisible(true);
                        this.es.txtDatosEsca.setVisible(true);
                        this.es.txtDatosEsca2.setVisible(true);
                        this.es.txtEsca.setVisible(true);
                }
            }  
        }
        if(es.btnRestaurar== e.getSource()){
            es.btnGraf.setEnabled(true);
            es.btnApl.setEnabled(false);
            es.btnRestaurar.setEnabled(false);
            es.jLineaO.setVisible(false);
            es.txtDatosEsca.setVisible(false);
            es.jLineaEsca.setVisible(false);
            es.txtDatosEsca1.setVisible(true);
            es.txtDatosEsca2.setVisible(true);
            es.txtEsca.setVisible(false);
            es.txtDatosgraf.setVisible(false);
            es.txtEsca.setVisible(false);
            es.txtDatosEsca1.setText("1.2");
            es.txtDatosEsca2.setText("1.2");
            es.txtDatosEsca1.setEditable(false);
            es.txtDatosEsca2.setEditable(false);
            this.tablaTrasVaciar(es.jTablaEsca);
            this.tablaTrasVaciar(es.jtablaOr);
            pes.restaurar();
            pes.setBtnGraf(-1);
            pes.setBtnAplicar(-1);
            pes.setBtnRestaurar(-1);
            es.repaint();
        }
        if(es.btnMenu==e.getSource()){
            m.setVisible(true);
            es.setVisible(false);
            es.btnGraf.setEnabled(true);
            es.btnApl.setEnabled(false);
            es.btnRestaurar.setEnabled(false);
            es.jLineaO.setVisible(false);
            es.txtDatosgraf.setVisible(false);
            es.txtDatosEsca1.setText("0.5");
            es.txtEsca.setText("0.5");
            es.txtDatosEsca1.setEditable(false);
            es.txtDatosEsca2.setEditable(false);
            this.tablaTrasVaciar(es.jTablaEsca);
            this.tablaTrasVaciar(es.jtablaOr);
            pes.restaurar();
            pes.setBtnGraf(-1);
            pes.setBtnAplicar(-1);
            pes.setBtnRestaurar(-1);
            es.repaint();
        }
    }
    public void rotacionBasica( ActionEvent e ){
        if(m.btnRota==e.getSource()){
            m.setVisible(false);
            rot.setVisible(true); 
        }
        if(rot.btnGraf==e.getSource()){
            prt.setBtnGraf(1);
            prt.setBtnAplicar(-1);
            prt.setBtnRestaurar(-1);
            rot.repaint();
            rot.btnGraf.setEnabled(false);
            rot.btnApl.setEnabled(true);
            rot.btnRestaurar.setEnabled(false);
            rot.txtAngulo.setEditable(true);
            this.tablaOr(rot.jtablaOr,ptr.getVectorP());
            this.rot.jLineaO.setVisible(true);
            this.rot.txtDatosgraf.setVisible(true);
        }
        if(rot.btnApl==e.getSource()){
            if(rot.txtAngulo.getText().isEmpty()==true){
                JOptionPane.showMessageDialog(null,"Error no a igresado los valores\n de traslación","Atención",JOptionPane.ERROR);
            }else{
                double angulo =Double.parseDouble(rot.txtAngulo.getText());  
                prt.setAngulo(angulo);
                rot.txtRota3.setText("("+angulo+"°)");
                prt.setBtnAplicar(1);
                prt.setBtnGraf(-1);
                prt.setBtnRestaurar(-1);
                rot.btnGraf.setEnabled(false);
                rot.btnRestaurar.setEnabled(true);
                rot.repaint();
                this.tablaPr1(rot.jTablaTras,this.prt.aplicarRotacion(angulo, this.prt.getAngulos(prt.vectorPuntos),this.prt.getRadios(prt.vectorPuntos)));
                this.rot.jLineaRota.setVisible(true);
                this.rot.txtDatosRota1.setVisible(true);
                this.rot.txtRota3.setVisible(true); 
            }  
        }
        if(rot.btnRestaurar== e.getSource()){
            rot.btnGraf.setEnabled(true);
            rot.btnApl.setEnabled(false);
            rot.btnRestaurar.setEnabled(false);
            rot.jLineaO.setVisible(false);
            rot.jLineaRota.setVisible(false);
            rot.txtDatosRota1.setVisible(false);
            rot.txtDatosgraf.setVisible(false);
            rot.txtAngulo.setText("65");
            rot.txtAngulo.setEditable(false);
            this.rot.txtRota3.setVisible(false);
            this.tablaTrasVaciar(rot.jTablaTras);
            this.tablaTrasVaciar(rot.jtablaOr);
            prt.restaurar();
            prt.setBtnGraf(-1);
            prt.setBtnAplicar(-1);
            prt.setBtnRestaurar(-1);
            rot.repaint();
        }
        if(rot.btnMenu==e.getSource()){
            m.setVisible(true);
            rot.setVisible(false);
            rot.btnGraf.setEnabled(true);
            rot.btnApl.setEnabled(false);
            rot.btnRestaurar.setEnabled(false);
            rot.jLineaO.setVisible(false);
            rot.jLineaRota.setVisible(false);
            rot.txtDatosRota1.setVisible(false);
            rot.txtDatosgraf.setVisible(false);
            rot.txtAngulo.setText("90");
            rot.txtAngulo.setEditable(false);
            this.rot.txtRota3.setVisible(false);
            this.tablaTrasVaciar(rot.jTablaTras);
            this.tablaTrasVaciar(rot.jtablaOr);
            prt.restaurar();
            prt.setBtnGraf(-1);
            prt.setBtnAplicar(-1);
            prt.setBtnRestaurar(-1);
            rot.repaint();
        }
    }
    public void rotacionSucesiva(ActionEvent e) {
         if(rot2.btnMenu==e.getSource()){
            m.setVisible(true);
            rot2.setVisible(false);
            rot2.btnGraf.setEnabled(true);
            rot2.btnApl.setEnabled(false);
            rot2.btnApl2.setEnabled(false);
            rot2.btnRestaurar.setEnabled(false);
            rot2.jLineaO.setVisible(false);
            rot2.jLineaTras.setVisible(false);
            rot2.txtDatosTras.setVisible(false);
            rot2.txtDatosTras2.setVisible(false);
            rot2.txtDatosgraf.setVisible(false);
            rot2.txtTraslacion.setVisible(false);
            rot2.txtTx.setText("20");
            rot2.txtTx2.setText("70");
            this.tablaTrasVaciar(rot2.jTablaTras);
            this.tablaTrasVaciar(rot2.jTablaTras2);
            this.tablaTrasVaciar(rot2.jtablaOr);
            prt2.setBtnGraf(-1);
            prt2.setBtnAplicar(-1);
            prt2.setBtnRestaurar(-1);
            prt2.restaurar();
            rot2.repaint();
            rot2.txtTx.setEditable(false);
            rot2.txtTx2.setEditable(false);
        }
         if(m.btnRota2==e.getSource()){
            m.setVisible(false);
            rot2.setVisible(true);
            rot2.btnApl.setEnabled(false);
            rot2.btnApl2.setEnabled(false);
            System.out.println("clic");
        }
        if(rot2.btnGraf==e.getSource()){
            prt2.setBtnGraf(1);
            prt2.setBtnAplicar(-1);
            prt2.setBtnRestaurar(-1);
            rot2.repaint();
            rot2.btnGraf.setEnabled(false);
            rot2.btnApl.setEnabled(true);
            rot2.txtTx.setEditable(true);
            this.tablaOr(rot2.jtablaOr,prt2.getVectorP());
            this.rot2.jLineaO.setVisible(true);
            this.rot2.txtDatosgraf.setVisible(true);
        }
        if(rot2.btnApl==e.getSource()){
            if(rot2.txtTx.getText().isEmpty()==true){
                JOptionPane.showMessageDialog(null,"Error no a igresado los valores\n de traslación","Atención",JOptionPane.ERROR);
            }else{
  
                double tx =Double.parseDouble(rot2.txtTx.getText());
                        prt2.setAngulo((double)tx);
                        rot2.txtTraslacion.setText("("+rot2.txtTx.getText()+")°");
                        prt2.setBtnAplicar(1);
                        prt2.setBtnGraf(-1);
                        prt2.setBtnRestaurar(-1);
                        rot2.btnGraf.setEnabled(false);
                        rot2.repaint();
                        this.tablaPr1(rot2.jTablaTras,this.prt2.aplicarRotacion(tx, this.prt2.getAngulos(prt2.vectorPuntos),this.prt2.getRadios(prt2.vectorPuntos)));
                        this.rot2.jLineaTras.setVisible(true);
                        this.rot2.txtDatosTras.setVisible(true);
                        this.rot2.txtDatosTras2.setVisible(true);
                        this.rot2.txtTraslacion.setVisible(true);   
                        rot2.txtTx2.setEditable(true);
                        rot2.btnApl2.setEnabled(true);
                }  
            }
        if(rot2.btnApl2==e.getSource()){
            if(rot2.txtTx2.getText().isEmpty()==true){
                JOptionPane.showMessageDialog(null,"Error no a igresado los valores\n de traslación","Atención",JOptionPane.ERROR);
            }else{
                
                double tx2 =Double.parseDouble(rot2.txtTx2.getText());
                double tx =Double.parseDouble(rot2.txtTx.getText());

                        prt2.setAngulo((double)tx);
                        prt2.setAngulo2((double)tx2);
                        rot2.txtDatos2.setText("Figura con Rotación R2 ("+rot2.txtTx2.getText()+")°");
                        prt2.setBtnAplicar(2);
                        prt2.setBtnGraf(-1);
                        prt2.setBtnRestaurar(-1);
                        rot2.btnRestaurar.setEnabled(true);
                        rot2.jLineaTras2.setVisible(true);
                        rot2.txtDatos2.setVisible(true);
                        rot2.repaint();
                        double v [][] = this.prt2.aplicarRotacion(tx, this.prt2.getAngulos(prt2.vectorPuntos),this.prt2.getRadios(prt2.vectorPuntos));
                        double v2 [][] = this.prt2.aplicarRotacion(tx2, this.prt2.getAngulos(v),this.prt2.getRadios(v));
                        this.tablaPr2(rot2.jTablaTras2,v2);
                }  
            }
        if(rot2.btnRestaurar== e.getSource()){
            rot2.btnGraf.setEnabled(true);
            rot2.btnApl.setEnabled(false);
            rot2.btnApl2.setEnabled(false);
            rot2.btnRestaurar.setEnabled(false);
            rot2.jLineaO.setVisible(false);
            rot2.jLineaTras.setVisible(false);
            rot2.jLineaTras2.setVisible(false);
            rot2.txtDatosTras.setVisible(false);
            rot2.txtDatosTras2.setVisible(false);
            rot2.txtDatosgraf.setVisible(false);
            rot2.txtTraslacion.setVisible(false);
            rot2.txtTx.setText("-10");
            rot2.txtTx2.setText("0");
            this.tablaTrasVaciar(rot2.jTablaTras);
            this.tablaTrasVaciar(rot2.jTablaTras2);
            this.tablaTrasVaciar(rot2.jtablaOr);
            prt2.setBtnGraf(-1);
            prt2.setBtnAplicar(-1);
            prt2.setBtnRestaurar(-1);
            prt2.restaurar();
            rot2.repaint();
            rot2.txtTx.setEditable(false);
            rot2.txtTx2.setEditable(false);
            rot2.txtDatos2.setVisible(false);
        } 

    }
}


