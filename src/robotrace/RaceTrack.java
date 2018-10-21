package robotrace;

import static com.jogamp.opengl.GL.GL_TEXTURE0;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import static com.jogamp.opengl.GL2.*;

/**
 * Implementation of a race track that is made from Bezier segments.
 */
abstract class RaceTrack {
    
    /** The width of one lane. The total width of the track is 4 * laneWidth. */
    private final static float laneWidth = 1.22f;
    
    private final static float interval = 1f/1000;
    
    /**
     * Constructor for the default track.
     */
    public RaceTrack() {
    }


    
    /**
     * Draws this track, based on the control points.
     */
    public void draw(GL2 gl, GLU glu, GLUT glut) {
        Vector normal = getTangent(0).cross(Vector.Z).normalized();
        
        //DRAW SURFACE
        Textures.track.bind(gl);
        gl.glBegin(GL2.GL_TRIANGLE_STRIP);
         gl.glNormal3d(normal.x(), normal.y(), normal.z());
        
        for(float t = 0; t < 1; t += interval){
           Vector center = getPoint(t);
           normal = getTangent(t).cross(Vector.Z).normalized();
           
           Vector in = center.subtract(normal.scale(2*laneWidth));
           Vector out = center.add(normal.scale(2*laneWidth));
           
            gl.glMultiTexCoord2d(GL_TEXTURE0, 0, 0);
                gl.glVertex3d(in.x, in.y,  1);
                gl.glMultiTexCoord2d(GL_TEXTURE0, 1, 0);
                gl.glVertex3d(out.x, out.y, 1);
        }
        gl.glEnd();
        
        //DRAW INSIDE WALL
         Textures.brick.bind(gl);
        gl.glBegin(GL2.GL_TRIANGLE_STRIP);
         gl.glNormal3d(normal.x(), normal.y(), normal.z());
        
        for(float t = 0; t < 1; t += interval){
           Vector center = getPoint(t);
           normal = getTangent(t).cross(Vector.Z).normalized();
           
           Vector in = center.subtract(normal.scale(2*laneWidth));
           
            gl.glMultiTexCoord2d(GL_TEXTURE0, 0, 0);
                gl.glVertex3d(in.x, in.y,  1);
                gl.glMultiTexCoord2d(GL_TEXTURE0, 1, 0);
                gl.glVertex3d(in.x, in.y,  -1);
        }
        gl.glEnd();
        
         //DRAW OUTSIDE WALL
        Textures.brick.bind(gl);
        gl.glBegin(GL2.GL_TRIANGLE_STRIP);
         gl.glNormal3d(normal.x(), normal.y(), normal.z());
        
        for(float t = 0; t < 1; t += interval){
           Vector center = getPoint(t);
           normal = getTangent(t).cross(Vector.Z).normalized();
           
           Vector out = center.add(normal.scale(2*laneWidth));
           
            gl.glMultiTexCoord2d(GL_TEXTURE0, 0, 0);
                gl.glVertex3d(out.x, out.y,  1);
                gl.glMultiTexCoord2d(GL_TEXTURE0, 1, 0);
                gl.glVertex3d(out.x, out.y, -1);
        }
        gl.glEnd();
    }
    
    /**
     * Returns the center of a lane at 0 <= t < 1.
     * Use this method to find the position of a robot on the track.
     */
    public Vector getLanePoint(int lane, double t){

        return Vector.O;

    }
    
    /**
     * Returns the tangent of a lane at 0 <= t < 1.
     * Use this method to find the orientation of a robot on the track.
     */
    public Vector getLaneTangent(int lane, double t){
        
        return Vector.O;

    }
    
    
    // Returns a point on the test track at 0 <= t < 1.
    protected abstract Vector getPoint(double t);
    
    
    // Returns a tangent on the test track at 0 <= t < 1.
    protected abstract Vector getTangent(double t);
}
