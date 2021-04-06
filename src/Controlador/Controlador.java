
package Controlador;
import Vistas.Creditos;
import Vistas.Escalacion;
import Vistas.Menu;

import Vistas.PlanoEscalacion;
import Vistas.PlanoRotacion;

import Vistas.PlanoTraslaciones;
import Vistas.Portada;
import Vistas.Rotacion;

import Vistas.Traslaciones;

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
    Escalacion es;
    PlanoEscalacion pes;
    Rotacion rot;
    PlanoRotacion prt;
    Creditos cr;
    Color original= new Color(0,102,102),original2= new Color(0,102,102),original3= new Color(0,102,102), traslacion= new Color (255,153,0),
            escalacion= new Color (255,153,0), rotacion= new Color (255,153,0);
    Color orTrS= new Color(0,102,102), trSus=new Color (255,153,0),  trSus2=new Color (153,0,153);
    Color orEsS= new Color(0,102,102), esSus=new Color (255,153,0),  esSus2=new Color (153,0,153);
    Color orRoS= new Color(0,102,102), RoSus=new Color (255,102,102),  RoSus2=new Color (0,204,204);
    public Controlador(Portada portadav,Menu m,Traslaciones tr, PlanoTraslaciones ptr, Escalacion es, PlanoEscalacion pes,
            Rotacion rot, PlanoRotacion prt, Creditos cr){
        this.cr=cr;
        this.cr.btnMenu.addActionListener(this);
        this.m = m;
        this.m.btnCred.addActionListener(this);
        this.portadav=portadav;
        this.portadav.setVisible(true);
        this.portadav.BtnAv.addActionListener(this);     
        this.m.BtnEsca.addActionListener(this);
        this.m.btnTras.addActionListener(this);
        this.m.btnRota.addActionListener(this);
        
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
        this.rot.txtDatosRota2.setVisible(false);
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
        this.es.t.setVisible(true);

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
        this.tr.setVisible(false);
        this.es.setVisible(false);
        this.m.setVisible(false);  
        
    }
    
    public void tablaTrasOr(JTable tabla){
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
    public void tablaTrasTr(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Punto'");
        modelo.addColumn(" X' ");
        modelo.addColumn(" Y' ");
        Object [] columna = new Object[3];
        for(int i=0; i<5; i++){
            columna[0]="P'"+(i+1);
            columna[1]=this.ptr.vPuntosTrasladados[0][i];
            columna[2]=this.ptr.vPuntosTrasladados[1][i];
           
            modelo.addRow(columna);
        } 
    }
    public void tablaEscaOr(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Punto");
        modelo.addColumn(" X ");
        modelo.addColumn(" Y ");
        Object [] columna = new Object[3];
        for(int i=0; i<5; i++){
            columna[0]="P"+(i+1);
            columna[1]=this.pes.vectorPuntos[0][i];
            columna[2]=this.pes.vectorPuntos[1][i];
            modelo.addRow(columna);
        }
        
        
    }
    public void tablaEscaEs(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Punto'");
        modelo.addColumn(" X' ");
        modelo.addColumn(" Y' ");
        Object [] columna = new Object[3];
        for(int i=0; i<5; i++){
            columna[0]="P'"+(i+1);
            columna[1]=this.pes.vPuntosEscalacion[0][i];
            columna[2]=this.pes.vPuntosEscalacion[1][i];
            modelo.addRow(columna);
        } 
    }
    public void tablaRotaOr(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Punto");
        modelo.addColumn(" X ");
        modelo.addColumn(" Y ");
        Object [] columna = new Object[3];
        for(int i=0; i<5; i++){
            columna[0]="P"+(i+1);
            columna[1]=this.prt.vectorPuntos[0][i];
            columna[2]=this.prt.vectorPuntos[1][i];
            modelo.addRow(columna);
        }
        
        
    }
    public void tablaRotaRot(JTable tabla){
        DecimalFormat f = new DecimalFormat("00.0");
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Punto'");
        modelo.addColumn(" X' ");
        modelo.addColumn(" Y' ");
        Object [] columna = new Object[3];
        for(int i=0; i<5; i++){
            columna[0]="P'"+(i+1);
            columna[1]=f.format(this.prt.vPuntosRotacion[0][i]);
            columna[2]=f.format(this.prt.vPuntosRotacion[1][i]);
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
        if(rot.btnMenu==e.getSource()){
            m.setVisible(true);
            rot.setVisible(false);
            rot.btnGraf.setEnabled(true);
            rot.btnApl.setEnabled(false);
            rot.btnRestaurar.setEnabled(false);
            rot.jLineaO.setVisible(false);
            rot.jLineaRota.setVisible(false);
            rot.txtDatosRota1.setVisible(false);
            rot.txtDatosRota2.setVisible(false);
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
          if(es.btnMenu==e.getSource()){
            m.setVisible(true);
            es.setVisible(false);
            es.btnGraf.setEnabled(true);
            es.btnApl.setEnabled(false);
            es.btnRestaurar.setEnabled(false);
            es.jLineaO.setVisible(false);
            es.txtDatosgraf.setVisible(false);
            es.txtDatosEsca1.setText("0.5");
            es.t.setText("0.5");
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
        if(m.btnTras==e.getSource()){
            m.setVisible(false);
            tr.setVisible(true);
            tr.btnApl.setEnabled(false);
        }
        if(m.BtnEsca==e.getSource()){
            m.setVisible(false);
            es.setVisible(true); 
            es.t.setVisible(false);
            es.txtDatosEsca.setVisible(false);
            es.txtEsca.setVisible(false);
            //es.jTablaEsca.setVisible(false);
            es.t.setVisible(false);
        }
         if(m.btnRota==e.getSource()){
            m.setVisible(false);
            rot.setVisible(true); 
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
            this.tablaTrasOr(tr.jtablaOr);
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
                        this.ptr.aplicarTraslacion(tx, ty);
                        this.tablaTrasTr(tr.jTablaTras);
                       
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
            this.tablaEscaOr(es.jtablaOr);
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
                        this.pes.aplicarEscalacion(sx, sy);
                        this.tablaEscaEs(es.jTablaEsca);
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
            es.t.setVisible(false);
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
        //
        if(rot.btnGraf==e.getSource()){
            prt.setBtnGraf(1);
            prt.setBtnAplicar(-1);
            prt.setBtnRestaurar(-1);
            rot.repaint();
            rot.btnGraf.setEnabled(false);
            rot.btnApl.setEnabled(true);
            rot.btnRestaurar.setEnabled(false);
            rot.txtAngulo.setEditable(true);
            
            this.tablaRotaOr(rot.jtablaOr);
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
                prt.establecerAngulosRadios();
                prt.setBtnAplicar(1);
                prt.setBtnGraf(-1);
                prt.setBtnRestaurar(-1);
                rot.btnGraf.setEnabled(false);
                rot.btnRestaurar.setEnabled(true);
                rot.repaint();
                this.prt.aplicarRotacion(angulo);
                this.tablaRotaRot(rot.jTablaTras);

                this.rot.jLineaRota.setVisible(true);
                this.rot.txtDatosRota1.setVisible(true);
                this.rot.txtDatosRota2.setVisible(true);
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
            rot.txtDatosRota2.setVisible(false);
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
          
    }
   
}
