/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edisoncor.gui.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JToolTip;
import org.edisoncor.gui.toolTip.ToolTipRound;

/**
 *
 * @author Edison
 */
public class ButtonAeroRound extends JButton{

    private Image buttonHighlight;
    private float shadowOffsetX;
    private float shadowOffsetY;
    private Color colorDeSombra=new Color(0,0,0);
    private int direccionDeSombra=60;
    private int distanciaDeSombra=1;
    private int angulo=20;
    private boolean foco=false;

    public ButtonAeroRound(Icon icon) {
        super(icon);
    }

    public ButtonAeroRound() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.BOLD, 14));
        setForeground(new Color(255,255,255));
        buttonHighlight = loadImage("/resources/header-halo.png");
        addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                foco=true;
            }

            public void focusLost(FocusEvent e) {
                foco=false;
            }
        });
    }

    private static Image loadImage(String fileName) {
        try {
            return ImageIO.read(ButtonAeroRound.class.getResource(fileName));
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public JToolTip createToolTip() {
        ToolTipRound tip = new ToolTipRound();
        tip.setComponent(this);
        return tip;
    }

    private void computeShadow() {
        double rads = Math.toRadians(direccionDeSombra);
        shadowOffsetX = (float) Math.cos(rads) * distanciaDeSombra;
        shadowOffsetY = (float) Math.sin(rads) * distanciaDeSombra;
    }

    @Override
    protected void paintComponent(Graphics g) {
        computeShadow();
        
        Graphics2D g2 = (Graphics2D) g;
        Paint oldPaint = g2.getPaint();

        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                0,0,getWidth(),getHeight(),angulo,angulo);
        g2.clip(r2d);

        ButtonModel modelo = getModel();

        Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth(), getHeight() / 2.0);
        if(modelo.isArmed()|modelo.isPressed())
            g2.setPaint(getBackground().darker());
        else
            g2.setPaint(getBackground());
       
        g2.fill(rect);

        rect = new Rectangle2D.Double(0, (getHeight() / 2.0) - 1.0, getWidth(), getHeight());
        if(modelo.isArmed()|modelo.isPressed())
            g2.setPaint(getBackground().darker().darker());
        else
            g2.setPaint(getBackground().darker());
        
        g2.fill(rect);

        if(modelo.isRollover() | foco){
            g2.drawRect(0, 0, getWidth(), getHeight());
            g2.drawImage(buttonHighlight,
                    0,0,
                    getWidth(), getHeight(), null);
        }


        FontMetrics fm = getFontMetrics(getFont());
        TextLayout layout = new TextLayout(getText(),
                getFont(),
                g2.getFontRenderContext());
        Rectangle2D bounds = layout.getBounds();

        int x = (int) (getWidth() - bounds.getWidth()) / 2;
        //x -= 2;
        int y = (getHeight() -  fm.getMaxAscent() - fm.getMaxDescent()) / 2;
        y += fm.getAscent() - 1;

        if (modelo.isArmed()) {
            x += 1;
            y += 1;
        }

        g2.setColor(colorDeSombra);
        layout.draw(g2,
                x + (int) Math.ceil(shadowOffsetX),
                y + (int) Math.ceil(shadowOffsetY));
        if(isEnabled())
            g2.setColor(getForeground());
        else
            g2.setColor(getForeground().darker());
        layout.draw(g2, x, y);

        g2.setPaint(oldPaint);

    }

    public Color getColorDeSombra() {
        return colorDeSombra;
    }

    public void setColorDeSombra(Color colorDeSombra) {
        this.colorDeSombra = colorDeSombra;
        repaint();
    }

    public int getDireccionDeSombra() {
        return direccionDeSombra;
    }

    public void setDireccionDeSombra(int direccionDeSombra) {
        this.direccionDeSombra = direccionDeSombra;
        repaint();
    }

    public int getDistanciaDeSombra() {
        return distanciaDeSombra;
    }

    public void setDistanciaDeSombra(int distanciaDeSombra) {
        this.distanciaDeSombra = distanciaDeSombra;
        repaint();
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
        repaint();
    }

}
