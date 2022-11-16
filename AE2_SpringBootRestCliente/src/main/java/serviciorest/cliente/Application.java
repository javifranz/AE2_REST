package serviciorest.cliente;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import serviciorest.cliente.entidad.Videojuego;
import serviciorest.cliente.servicio.ServicioProxyMensaje;
import serviciorest.cliente.servicio.ServicioProxyVideojuego;

@SpringBootApplication
public class Application implements CommandLineRunner{

	
	@Autowired
	private ServicioProxyMensaje spm;
	
	@Autowired
	private ServicioProxyVideojuego spv;
	
	

	@Autowired
	private ApplicationContext context;
	
    //El objeto restTemplate será usado por los objetos ServicioProxy 
	//para hacer las peticiones HTTP a nuestro servicio REST. 

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	//Método main que lanza la aplicación
	public static void main(String[] args) {
		System.out.println("Cliente -> Cargando el contexto de Spring");
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("****** Arrancando el cliente REST ******");
		System.out.println("*************  MENSAJE *****************");
		String mensaje = spm.obtener("mensaje");
		System.out.println("run -> Mensaje: " + mensaje);
		
		System.out.println("***********  MENSAJE HTML **************");
		String mensajeHTML = spm.obtener("mensajeHTML");
		System.out.println("run -> Mensaje: " + mensajeHTML);
		
		try (Scanner sc = new Scanner(System.in)) {
			
			boolean continuar = true;
			do{ 		
				 
			   String codeOpc = "";		
			   System.out.println("¿Qué desea hacer?: \n 1. Dar de alta un videojuego \n " 
			           + "2. Dar de baja un videojuego por ID \n "
					   + "3. Modificar un videojuego por ID \n " 
			           + "4. Obtener un videojuego por ID \n "
			           + "5. Listar todos los videojuegos"
					   + "0. Salir \n");
		    	System.out.println("CLIENTE: Introduzca la opcion");
		    	codeOpc = sc.nextLine();
		    	int codeOpcInt = Integer.parseInt(codeOpc);
		    	
		    	switch (codeOpcInt) {
				case 0:
					System.out.println("CLIENTE: Se va a cerrar la conexion");
					pararAplicacion();
					break;

				case 1:


				case 2:

				case 3:

				case 4:
					
				case 5:

				default:
					break;
				}
			   
			    
			} while (continuar);
			
			
		} 
		
		catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			

		}
	}
	
	public void pararAplicacion() {
		//Para el servidor cuando acabemos
		SpringApplication.exit(context, () -> 0);
		
	}
}