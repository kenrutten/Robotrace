#version 120
uniform bool ambient, diffuse, specular;
uniform sampler2D robotTexture;

varying vec3 N;
varying vec3 P;


vec4 shading(vec3 P, vec3 N, gl_LightProducts light, gl_MaterialParameters mat) {

	vec4 result = vec4(0,0,0,1); // opaque black

        for(int i = 0; i < 5; i++) {
	result += gl_LightSource[i].ambient * mat.ambient ; 
	//compute ambient contribution
		

	vec3 L = normalize(gl_LightSource[i].position.xyz - P); // vector towards light source
	result += mat.diffuse*gl_LightSource[i].diffuse*max(dot(L, N), 0.0); 
	// Done: compute diffuse contribution

	vec3 E = vec3(0); // position of camera in View space
	vec3 V = normalize(-P);
	
	/*Determine specular contribution by calculating the angle between:
		- the lightray reflected by the test model at the vertex
		- the direction of the camera view on the vertex
	 k and n are meant to change the specular reflection*/

		vec3 R = normalize(2.0*dot(N, L) * N - L);
		float cosa = max(dot(R, V), 0.0);
		result += mat.specular * gl_LightSource[i].specular*pow(cosa,mat.shininess); }
        
	return result;
}



void main()
{
	gl_LightProducts light = gl_FrontLightProduct[0];
	gl_MaterialParameters mat = gl_FrontMaterial;
	gl_FragColor = texture2D(robotTexture, gl_TexCoord[0].st)+ shading(P, N, light, mat);
}
