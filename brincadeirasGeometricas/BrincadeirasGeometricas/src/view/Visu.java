package view;

import Figuras2d.*;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Visu {


    public void menuPrincipal(){
        Scanner input = new Scanner(System.in);
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas glcanvas = new GLCanvas(capabilities);
        glcanvas.setSize(400, 400);

        int x;
        System.out.println("Seja well comido, essas são as gracinhas geométricas do Dolley");
        System.out.println("Digite o que deseja ver: ");
        System.out.println("1 --> Linha2d");
        System.out.println("2 --> Circulo2d");
        System.out.println("3 --> Poligono2d");
        System.out.println("4 --> Quadrilatero");
        System.out.println("5 --> Triângulo2d");
        x = input.nextInt();
        while(x < 1 || x > 5){
            System.out.println("Inválido! Digite novamente: ");
            x = input.nextInt();
        }

        switch(x){
            case 1:  //Linha2d
                Linha2d l = new Linha2d();
                glcanvas.addGLEventListener(l);
                glcanvas.addKeyListener(l);
                System.out.println("Segure a tecla 'R' para rotacionar em torno do eixo Y!");
                System.out.println("Pressione '0' para aumentar a Escala ou '-'(Menos) para diminuir a Escala!");
                System.out.println("Utilize as setas para Transladar a figura!");
                break;

            case 2: //Circulo2d
                Circulo2d c = new Circulo2d();
                glcanvas.addGLEventListener(c);
                glcanvas.addKeyListener(c);
                System.out.println("Segure a tecla 'R' para rotacionar em torno do eixo Y!");
                System.out.println("Pressione '0' para aumentar a Escala ou '-'(Menos) para diminuir a Escala!");
                System.out.println("Utilize as setas para Transladar a figura!");
                break;

            case 3: //Poligono2d
                Poligono2d p = new Poligono2d();
                glcanvas.addGLEventListener(p);
                glcanvas.addKeyListener(p);
                System.out.println("Segure a tecla 'R' para rotacionar em torno do eixo Y!");
                System.out.println("Pressione '0' para aumentar a Escala ou '-'(Menos) para diminuir a Escala!");
                System.out.println("Utilize as setas para Transladar a figura!");
                break;

            case 4: //Quadrilatero
                Quadrilatero q = new Quadrilatero();
                glcanvas.addGLEventListener(q);
                glcanvas.addKeyListener(q);
                System.out.println("Segure a tecla 'R' para rotacionar em torno do eixo Y!");
                System.out.println("Pressione '0' para aumentar a Escala ou '-'(Menos) para diminuir a Escala!");
                System.out.println("Utilize as setas para Transladar a figura!");
                break;

            case 5: //Triângulo2d
                Triangulo2d t = new Triangulo2d();
                glcanvas.addGLEventListener(t);
                glcanvas.addKeyListener(t);
                System.out.println("Segure a tecla 'R' para rotacionar em torno do eixo Y!");
                System.out.println("Pressione '0' para aumentar a Escala ou '-'(Menos) para diminuir a Escala!");
                System.out.println("Utilize as setas para Transladar a figura!");
                break;
        }

        JFrame frame = new JFrame ("Forma geométrica top");

        frame.getContentPane().add(glcanvas);
        frame.setLocationRelativeTo(null);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FPSAnimator animacao = new FPSAnimator(glcanvas, 300, true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                animacao.stop();
        }
        });

        animacao.start();
    }
}
