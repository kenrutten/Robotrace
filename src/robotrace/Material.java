package robotrace;

/**
* Materials that can be used for the robots.
*/
public enum Material {

    /** 
     * Gold material properties.
     * Modify the default values to make it look like gold.
     */
    GOLD (

            new float[] {0.752f, 0.619f, 0.196f, 1},
            new float[] {0.628f, 0.5712f, 0.3435f, 1},
            22f

    ),

    /**
     * Silver material properties.
     * Modify the default values to make it look like silver.
     */
    SILVER (

            new float[] {0.507f, 0.507f, 0.507f, 1},
            new float[] {0.508f, 0.508f, 0.508f, 1},
            22f

    ),

    /** 
     * Orange material properties.
     * Modify the default values to make it look like orange.
     */
    ORANGE (

            new float[] {0.992f, 0.514f, 0, 1},
            new float[] {0.0225f, 0.0225f, 0.0225f, 1},
            11f

    ),

    /**
     * Wood material properties.
     * Modify the default values to make it look like Wood.
     */
    WOOD (

            new float[] {0.992f, 0.514f, 0, 1},
            new float[] {0.0225f, 0.0225f, 0.0225f, 1},
            // same as Orange but with much less shininess
            100f

    );

    /** The diffuse RGBA reflectance of the material. */
    float[] diffuse;

    /** The specular RGBA reflectance of the material. */
    float[] specular;
    
    /** The specular exponent of the material. */
    float shininess;

    /**
     * Constructs a new material with diffuse and specular properties.
     */
    private Material(float[] diffuse, float[] specular, float shininess) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
    }
}
