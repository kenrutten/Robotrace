package robotrace;

import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.GL2ES3.GL_QUADS;
import static com.jogamp.opengl.fixedfunc.GLLightingFunc.*;

/**
* Represents a Robot, to be implemented according to the Assignments.
*/
class Robot {
    
    /** The position of the robot. */
    public Vector position = new Vector(0, 0, 0);
    
    /** The direction in which the robot is running. */
    public Vector direction = new Vector(1, 0, 0);

    /** The material from which this robot is built. */
    private final Material material;
    
    

    /**
     * Constructs the robot with initial parameters.
     */
    public Robot(Material material
            
    ) {
        this.material = material;

        
    }

    /**
     * Draws this robot (as a {@code stickfigure} if specified).
     */
    public void draw(GL2 gl, GLU glu, GLUT glut, float tAnim) {
        gl.glColor3d(255,0,0);
        gl.glPushMatrix(); 
            //Draw right leg
            gl.glTranslated(0.12, 0.15,0.05);
            gl.glScaled(0.2, 0.3, 0.1);
            glut.glutSolidCube(1); //foot
            gl.glScaled(5, 3.33, 10);
            gl.glTranslated(0, -0.07, 0.09);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.08, 20, 20);//ancle
            gl.glTranslated(0,0,0.19);
            gl.glScaled(0.12, 0.12, 0.34);
            gl.glColor3d(255,0,0);
            glut.glutSolidCube(1);//lower leg
            gl.glScaled(8.333, 8.333, 2.941);
            gl.glTranslated(0, 0.01, 0.19);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.1, 20, 20);//knee
            gl.glTranslated(0, -0.01, 0.19);
            gl.glScaled(0.14, 0.14, 0.34);
            gl.glColor3d(255,0,0);
            glut.glutSolidCube(1);//upper leg
            gl.glScaled(7.143, 7.143, 2.941);
            
            //Draw left leg
            gl.glTranslated(-0.24, 0.08, -0.66);
            gl.glScaled(0.2, 0.3, 0.1);
            glut.glutSolidCube(1);
            gl.glScaled(5, 3.33, 10);
            gl.glTranslated(0, -0.07, 0.09);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.08, 20, 20);
            gl.glTranslated(0,0,0.19);
            gl.glScaled(0.12, 0.12, 0.34);
            gl.glColor3d(255,0,0);
            glut.glutSolidCube(1);
            gl.glScaled(8.333, 8.333, 2.941);
            gl.glTranslated(0, 0.01, 0.19);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.1, 20, 20);
            gl.glTranslated(0, -0.01, 0.19);
            gl.glScaled(0.14, 0.14, 0.34);
            gl.glColor3d(255,0,0);
            glut.glutSolidCube(1);
            gl.glScaled(7.143, 7.143, 2.941);
            
            //draw torso
            gl.glTranslated(0.12, 0, 0.4);
            gl.glScaled(0.4, 0.2, 0.5);
            glut.glutSolidCube(1);//Belly
            gl.glScaled(2.5, 5, 2);
            gl.glTranslated(0, 0, 0.41);
            gl.glScaled(0.6, 0.26, 0.32);
            glut.glutSolidCube(1);//Shoulders
            gl.glScaled(1.667, 3.846, 3.125);
            
            //draw left arm
            gl.glTranslated(0.32, 0, 0);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.1, 20, 20);
            //gl.glRotated(70, 0, 1, 0);
            //gl.glRotated(40, 0, 0, 1);
            gl.glTranslated(0.2, 0, 0);
            gl.glScaled(0.28, 0.12, 0.12);
            gl.glColor3d(255,0,0);
            glut.glutSolidCube(1);//upper arm
            gl.glScaled(3.751, 8.333, 8.333);
            gl.glTranslated(0.15, 0, 0);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.08, 20, 20);//elbow
           // gl.glRotated(40, 0, 0, 1);
            gl.glTranslated(0.16, 0, 0);
            gl.glScaled(0.3, 0.1, 0.1);
            gl.glColor3d(255,0,0);
            glut.glutSolidCube(1);//lower arm
            gl.glScaled(3.333, 10, 10);
            gl.glTranslated(0.16, 0, 0);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.06, 20, 20);
            gl.glTranslated(-0.94, 0, 0);
            
            //draw right arm
              gl.glTranslated(-0.32, 0, 0);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.1, 20, 20);
            //gl.glRotated(70, 0, 1, 0);
            //gl.glRotated(40, 0, 0, 1);
            gl.glTranslated(-0.2, 0, 0);
            gl.glScaled(0.28, 0.12, 0.12);
            gl.glColor3d(255,0,0);
            glut.glutSolidCube(1);//upper arm
            gl.glScaled(3.751, 8.333, 8.333);
            gl.glTranslated(-0.15, 0, 0);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.08, 20, 20);//elbow
            //gl.glRotated(40, 0, 0, 1);
            gl.glTranslated(-0.16, 0, 0);
            gl.glScaled(0.3, 0.1, 0.1);
            gl.glColor3d(255,0,0);
            glut.glutSolidCube(1);//lower arm
            gl.glScaled(3.333, 10, 10);
            gl.glTranslated(-0.16, 0, 0);
            gl.glColor3d(0,0,255);
            glut.glutSolidSphere(0.06, 20, 20);
            gl.glTranslated(0.94, 0, 0);
            
            //draw head
            gl.glTranslated(0, 0, 0.26);
            gl.glScaled(0.2, 0.2, 0.2);
            glut.glutSolidCube(1);
        gl.glPopMatrix();
    }
    
    
}
