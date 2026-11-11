package Presentacion;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TemplatePanel extends JPanel {

    // 1. Tipografías estándar del sistema
    public final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 22);       
    public final Font FUENTE_SUBTITULO = new Font("Segoe UI", Font.PLAIN, 12);    
    public final Font FUENTE_ETIQUETA = new Font("Segoe UI", Font.BOLD, 12);        
    public final Font FUENTE_CUERPO = new Font("Segoe UI", Font.PLAIN, 12);        

    // 2. Paleta visual profesional (Fondo oscuro moderno + Acentos verdes)
    public final Color COLOR_FONDO_PRINCIPAL = new Color(24, 28, 36);       // #181C24 - Gris oscuro para el fondo
    public final Color COLOR_CABECERA_TABLA = new Color(20, 90, 58);        // #145A3A - Verde medio para tablas
    public final Color COLOR_BOTON_Y_BORDE = new Color(47, 125, 91);     // #2F7D5B - Verde para botones y bordes
    public final Color COLOR_TEXTO_BLANCO = new Color(240, 247, 244);    // Blanco  para textos
    public final Color COLOR_TEXTO_ATENUADO = new Color(160, 175, 190);  // Gris claro para subtítulos
    public final Color COLOR_FONDO_ENTRADA_TEXTO = new Color(18, 22, 28); // Fondo oscuro para inputs y tablas

    public TemplatePanel() {
        setOpaque(false);
        setLayout(new BorderLayout()); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Pinta el fondo principal con el gris oscuro 
        g2d.setColor(COLOR_FONDO_PRINCIPAL);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Dibuja un borde sutil alrededor del panel
        g2d.setColor(COLOR_BOTON_Y_BORDE);
        g2d.drawRect(0, 0, getWidth(), getHeight());
    }

    
    public void configurarPantalla() {
        designComponentes(this);
    }

    
    private void designComponentes(Container contenedor) {
        Component[] listaComponentes = contenedor.getComponents();

        for (int i = 0; i < listaComponentes.length; i++) {
            Component componenteActual = listaComponentes[i];

            // 1. Etiquetas (JLabel)
            if (componenteActual instanceof JLabel) {
                JLabel etiqueta = (JLabel) componenteActual;
                
                // Si es un título grande (como el de "Empleados"), 
                if (etiqueta.getFont().getSize() > 16) {
                    etiqueta.setFont(FUENTE_TITULO);
                    etiqueta.setForeground(COLOR_TEXTO_BLANCO);
                    etiqueta.setOpaque(false); 
                } 
                // Si es una etiqueta normal de campo (Nombre, Cédula, etc.)
                else { 
                    etiqueta.setFont(FUENTE_ETIQUETA);
                    etiqueta.setForeground(COLOR_TEXTO_BLANCO);
                }
            } 
            // 2. Botones 
            else if (componenteActual instanceof JButton) {
                JButton boton = (JButton) componenteActual;
                boton.setFont(FUENTE_ETIQUETA);
                boton.setBackground(COLOR_BOTON_Y_BORDE);
                boton.setForeground(COLOR_TEXTO_BLANCO);
                boton.setFocusPainted(false);
            } 
            // 3. Campos de texto (JTextField)
            else if (componenteActual instanceof JTextField) {
                JTextField campoTexto = (JTextField) componenteActual;
                campoTexto.setFont(FUENTE_CUERPO);
                campoTexto.setBackground(COLOR_FONDO_ENTRADA_TEXTO);
                campoTexto.setForeground(COLOR_TEXTO_BLANCO);
                campoTexto.setCaretColor(COLOR_TEXTO_BLANCO);
            } 
            // 4. Listas desplegables (JComboBox)
            else if (componenteActual instanceof JComboBox) {
                JComboBox<?> combo = (JComboBox<?>) componenteActual;
                combo.setFont(FUENTE_CUERPO);
                combo.setBackground(COLOR_FONDO_ENTRADA_TEXTO);
                combo.setForeground(COLOR_TEXTO_BLANCO);
            } 
            // 5. Tablas (JTable)
            else if (componenteActual instanceof JTable) {
                JTable tabla = (JTable) componenteActual;
                tabla.setFont(FUENTE_CUERPO);
                tabla.setBackground(COLOR_FONDO_ENTRADA_TEXTO);
                tabla.setForeground(COLOR_TEXTO_BLANCO);
                tabla.setGridColor(COLOR_BOTON_Y_BORDE);
                
                JTableHeader cabeceraTabla = tabla.getTableHeader();
                if (cabeceraTabla != null) {
                    cabeceraTabla.setFont(FUENTE_ETIQUETA);
                    cabeceraTabla.setBackground(COLOR_CABECERA_TABLA);
                    cabeceraTabla.setForeground(COLOR_TEXTO_BLANCO);
                }
            } 
            // 6. Contenedores internos (Paneles adicionales)
            // 6. Si es otro contenedor interno (como un JPanel)
            else if (componenteActual instanceof Container) {
                if (componenteActual instanceof JPanel) {
                    JPanel panelInterno = (JPanel) componenteActual;
                    // Forzamos a que el panel sea transparente para eliminar barras de colores extraños
                    panelInterno.setOpaque(false);
                }
                // Continúa buscando
                designComponentes((Container) componenteActual);
            }
        }
    }
}