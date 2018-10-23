#version 120

uniform bool ambient, diffuse, specular, useTexture;
varying vec3 N;
varying vec3 P;


void main() {
	// pick up light LIGHT0 and material properties set in ShaderMaker
        gl_LightSourceParameters light = gl_LightSource[0];
	gl_MaterialParameters mat = gl_FrontMaterial;

	
	N = normalize(gl_NormalMatrix*gl_Normal); 
	P = (gl_ModelViewMatrix*gl_Vertex).xyz; 

	// output of vertex shader
	gl_TexCoord[0] = gl_MultiTexCoord0;
	//gl_FrontColor = shading(P, N, light, mat);
	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
}
