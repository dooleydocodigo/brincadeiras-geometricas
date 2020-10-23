package Figuras2d;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Linha2d implements GLEventListener, KeyListener {
    private float angulo; //Angulo de rotação
    private GLU glu = new GLU();
    private float translacaoX, translacaoY; //Posição da translação
    private float x = 1.0f, y = 1.0f, z = 1.0f; //Tamanho do aumento ou da diminuição da escala iniciado com 1.0f pois isso não interfere no tamanho original
    private GL2 gl;
   // private GLAutoDrawable glDrawable;

    @Override
    public void display(GLAutoDrawable desenho) {
        gl = desenho.getGL().getGL2();
        gl.glLineWidth(3);

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT |  GL2.GL_DEPTH_BUFFER_BIT ); //Limpar a imagem
        gl.glLoadIdentity();

        gl.glTranslatef(translacaoX, translacaoY, 0f); //Translação
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f ); //Rotação no eixo Y
        gl.glScalef(x, y, z); //Escala

        gl.glBegin(GL2.GL_LINES);
        gl.glColor3f(1f,0f,0f); // Vermelho
        gl.glVertex3f(0.50f, -0.50f, 0);

        gl.glColor3f( 0f,1f, 1f ); //Azul claro
        gl.glVertex3f(-0.50f, 0.50f, 0);

        gl.glEnd();
        gl.glFlush();


    }

    @Override
    public void reshape(GLAutoDrawable desenho, int x, int y, int largura, int altura) {

    }

    @Override
    public void dispose(GLAutoDrawable desenho) {

    }

    @Override
    public void init(GLAutoDrawable desenho) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (int) KeyEvent.VK_RIGHT:
                translacaoX = translacaoX + 0.1f;
                break;

            case(int)  KeyEvent.VK_LEFT:
                translacaoX = translacaoX - 0.1f;
                break;

            case (int) KeyEvent.VK_UP:
                translacaoY = translacaoY + 0.1f;
                break;

            case (int) KeyEvent.VK_DOWN:
                translacaoY = translacaoY - 0.1f;
                break;

            case (int) KeyEvent.VK_R:    //Apertar R ele faz a rotação
                angulo = angulo + 0.5f;
                break;

            case (int) KeyEvent.VK_0: //Aumenta a escala
                x = x + 0.2f;
                y = y + 0.2f;
                break;

            case (int) KeyEvent.VK_MINUS: //Diminui a escala
                x = x - 0.2f;
                y = y - 0.2f;
                break;
        }

        //glDrawable.display();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}