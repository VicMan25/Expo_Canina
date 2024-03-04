import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Expo_Canina {

/*
 * Autor: Victor Manuel Velasquez Benavides
 */
			public static void main(String[] args) {
			   Expo_Canina expo = new Expo_Canina();
			   expo.mostrarMenu();
			}
	
		    private ArrayList<Perro> misPerros = new ArrayList<>();
		    private Scanner lector = new Scanner(System.in);
		    
		    public void mostrarMenu() { 
		    boolean activo=true;
		    do {
		    System.out.println("========== EXPOSICIÓN CANINA ========== \n \n"
		    		
		            + "1. Registrar perro. \n"
		            + "2. Consulta personalizada. \n"
		            + "3. Listado de los perros. \n"
		            + "4. Modificar información del perro. \n"
		            + "5. Eliminar informacion del perro. \n"
		            + "6. Cerrar Programa.\n \n"
		            + "Digite su opción");
		    
		    System.out.println("=======================================");
		    
		    int opcion=lector.nextInt();
		    lector.nextLine();
		    
		    switch(opcion){
		        case 1:
				try {
					agregarPerro();
				} catch (NombreDuplicadoException e) {
					System.out.println(e.getMessage());
				}
		        break;
		           
		        case 2:
		            consultarPerro(); 
		        break;
		        
		        case 3:
		        	listarPerros();
		        break;
		        
		        case 4:
		        	mostrarMenuModificaciones();
		        break;
		        
		        case 5:
		        	eliminarPerro();
		        break;
		        
		        case 6:
		        	activo=false;
		            System.out.println("Programa terminado.");
		        break;
		        
		        default:
		            System.out.println("Opción Incorrecta, intenta nuevamente.");
		        }
		    }
		    while (activo);  
			}
		    
		    public void agregarPerro() throws NombreDuplicadoException {
		    	
		    	lector.nextLine();
		    	System.out.println("Ingresa el nombre del perro: ");
		    	String nombrePerro = lector.nextLine();
		    	
		    	if (!misPerros.isEmpty()) {
		    		for (Perro p : misPerros) {
				        if (p.getNombrePerro().equalsIgnoreCase(nombrePerro)){
				        throw new NombreDuplicadoException();
				        } 
		    	}
		    	}
		    	System.out.println("Ingresa la edad en meses del perro: ");
		        int edadMeses = lector.nextInt();
		        lector.nextLine();
		        System.out.println("Ingresa la raza del perro: ");
		        String raza = lector.nextLine();
		        System.out.println("Ingrese el puntaje del perro: ");
		        int puntaje = lector.nextInt();
		        lector.nextLine();
		        System.out.println("Ingresa la foto del perro: ");
		        String foto = lector.nextLine();
		        Perro nuevoPerro = new Perro(nombrePerro, edadMeses, raza, puntaje, foto);
		        misPerros.add(nuevoPerro);
		        System.out.println("El perro fue agregado exitosamente");
		    	
		    }
		    
		    public void consultarPerro() {
		    	if (misPerros.isEmpty()) {
		            System.out.println("No hay perros registrados en el sistema.");
		        }
		    	else {
		    	
		    		mostrarMenuConsultas();
		    	}
		     }
		    
		    public void listarPerros() {
		    	for (Perro p : misPerros) {
		    		System.out.println("============== LISTADO ===============");
                    System.out.println(" Nombre: "+p.getNombrePerro()+"\n Edad En Meses: "+p.getEdadMeses() + " \n Raza: " +
                    p.getRaza()+ " \n Puntaje: " + p.getPuntaje()+ " \n Foto: "+p.getFoto()); 
                    System.out.println("======================================");
                } 
		    }
		    
		    public void eliminarPerro() {
		        if (misPerros.isEmpty()) {
		            System.out.println("No hay perros registrados en el sistema.");
		        } else {
		            System.out.println("Digite el nombre del perro que quiere eliminar: ");
		            String nombrePerro = lector.nextLine();
		            Iterator<Perro> iterador = misPerros.iterator();
		            boolean encontrado = false;

		            while (iterador.hasNext()) {
		                Perro p = iterador.next();
		                if (p.getNombrePerro().equalsIgnoreCase(nombrePerro)) {
		                    System.out.println("¿Estás seguro que quieres eliminar a " + nombrePerro + " del sistema?");
		                    System.out.println("Ingrese: 1 para confirmar o 2 para cancelar: ");
		                    int confirmacion = lector.nextInt();
		                    if (confirmacion == 1) {
		                        iterador.remove();
		                        System.out.println("El perro: " + nombrePerro + " ha sido eliminado.");
		                    } else {
		                        System.out.println("El perro no ha sido eliminado.");
		                    }
		                    encontrado = true;
		                    break;
		                }
		            }

		            if (!encontrado) {
		                System.out.println("El perro: " + nombrePerro + " no está disponible para eliminar");
		            }
		        }
		    }

		    public void mostrarMenuConsultas() { 
			    boolean activo=true;
			    do {
			    System.out.println("========== CONSULTAR PERROS ==========\n"
			    		
			            + "Según que clasificación quieres realizar la consulta: \n \n"
			            + "1. Perro Ganador. \n"
			            + "2. Perro con menor puntaje. \n"
			            + "3. Perro de mayor edad. \n"
			            + "4. Salir del menú de consultas. \n \n"
			            + "Digite su opción");
			   
			    System.out.println("=======================================");
			    
			    int opcion=lector.nextInt();
			    lector.nextLine();
			    
			    switch(opcion){
			        case 1:
			        	perroGanador();
			        break;
			           
			        case 2:
			            minPuntaje(); 
			        break;
			
			        case 3:
			        	mayorEdad();
			        break;
			        
			        case 4:
			        	activo=false;
			            System.out.println("Menú de consultas cerrado.");
			        break;
			        
			        default:
			            System.out.println("Opción Incorrecta, intenta nuevamente.");
			        }
			    }
			    while (activo);  
				}
		    
		    public void perroGanador(){
            System.out.println("========== PERRO GANADOR ==========");
		  
	        for (int i = 0; i < misPerros.size() - 1; i++) {
	            for (int j = i + 1; j < misPerros.size(); j++) {
	                Perro perro1 = misPerros.get(i);
	                Perro perro2 = misPerros.get(j);
	                if (perro1.getPuntaje() < perro2.getPuntaje()) {
	                   
	                	misPerros.set(i, perro2);
	                    misPerros.set(j, perro1);
	                }
	            }
	        }
	        
	        Perro ganador = misPerros.get(0);
	        System.out.println(" Perro ganador: " + ganador.getNombrePerro() 
	        		      + "\n Puntuación: " + ganador.getPuntaje());
		    }
		    
		    public void minPuntaje(){
	            System.out.println("========== PERRO CON MENOR PUNTAJE ==========");
			  
		        for (int i = 0; i < misPerros.size() - 1; i++) {
		            for (int j = i + 1; j < misPerros.size(); j++) {
		                Perro perro1 = misPerros.get(i);
		                Perro perro2 = misPerros.get(j);
		                if (perro1.getPuntaje() > perro2.getPuntaje()) {
		                   
		                	misPerros.set(i, perro2);
		                    misPerros.set(j, perro1);
		                }
		            }
		        }
		        
		        Perro minPuntaje = misPerros.get(0);
		        System.out.println(" Perro con menor puntaje: " + minPuntaje.getNombrePerro() 
		        		      + "\n Puntuación: " + minPuntaje.getPuntaje());
			  }
		    
		    public void mayorEdad(){
	            System.out.println("========== PERRO CON MAYOR EDAD ==========");
			  
		        for (int i = 0; i < misPerros.size() - 1; i++) {
		            for (int j = i + 1; j < misPerros.size(); j++) {
		                Perro perro1 = misPerros.get(i);
		                Perro perro2 = misPerros.get(j);
		                if (perro1.getEdadMeses() < perro2.getEdadMeses()) {
		                   
		                	misPerros.set(i, perro2);
		                    misPerros.set(j, perro1);
		                }
		            }
		        }
		        
		        Perro minPuntaje = misPerros.get(0);
		        System.out.println(" Perro con mayor edad: " + minPuntaje.getNombrePerro() 
		        		      + "\n Edad: " + minPuntaje.getEdadMeses());
			  }
		    
		    public void mostrarMenuModificaciones() {
	            boolean activo = true;
	            Perro perroEncontrado = null;

	            do {
	                System.out.println("Ingrese el nombre del perro que desea modificar:");
	                String nombrePerro = lector.nextLine();
	                lector.nextLine();

	                perroEncontrado = buscarPerro(nombrePerro);

	                if (perroEncontrado != null) {
	                    boolean activoM = true;

	                    do {
	                        System.out.println("\n======== MODIFICAR INFORMACIÓN ========");
	                        System.out.println("Que dato deseas modificar: \n \n"
	                                + "1. Edad. \n"
	                                + "2. Raza. \n"
	                                + "3. Puntaje. \n"
	                                + "4. Foto. \n"
	                                + "5. Salir del menú de Modificaciones. \n \n"
	                                + "Digite su opción");

	                        int opcion = lector.nextInt();
	                        lector.nextLine();

	                        switch (opcion) {
	                            case 1:
	                                modificarEdad(perroEncontrado);
	                                break;
	                            case 2:
	                                modificarRaza(perroEncontrado);
	                                break;
	                            case 3:
	                                modificarPuntaje(perroEncontrado);
	                                break;
	                            case 4:
	                                modificarFoto(perroEncontrado);
	                                break;
	                            case 5:
	                                activo = false;
	                                activoM = false;
	                                System.out.println("Menú de modificaciones cerrado.");
	                                break;
	                            default:
	                                System.out.println("Opción no válida");
	                                break;
	                        }
	                    } while (activoM);
	                } else {
	                    System.out.println("No se encontró un perro con ese nombre. Intente nuevamente.");
	                }
	            } while (activo);
	        }
		    
		    public Perro buscarPerro(String nombrePerro) {
	            for (Perro perro : misPerros) {
	                if (perro.getNombrePerro().equalsIgnoreCase(nombrePerro)) {
	                return perro;
	             }
	             }
	            return null;
	        }    

		    public void modificarEdad(Perro perro) {
		    	  System.out.println("============= MODIFICAR EDAD =============");
	              System.out.println("Ingrese la nueva edad del perro en meses:");
	              int nuevaEdadMeses = lector.nextInt();
	              perro.setEdadMeses(nuevaEdadMeses);
	              System.out.println("Edad modificada con éxito.");
	        }
	
	        public void modificarRaza(Perro perro) {
	        	  System.out.println("============= MODIFICAR RAZA =============");
	              System.out.println("Ingrese la nueva raza del perro:");
	              String nuevaRaza = lector.nextLine();
	              perro.setRaza(nuevaRaza);
	              System.out.println("Raza modificada con éxito.");
	        }
	
	        public void modificarPuntaje(Perro perro) {
	        	  System.out.println("============ MODIFICAR PUNTAJE ============");
	              System.out.println("Ingrese el nuevo puntaje para el perro:");
	              int nuevoPuntaje = lector.nextInt();
	              perro.setPuntaje(nuevoPuntaje);
	              System.out.println("Puntaje modificado con éxito.");
	        }
	          
	        public void modificarFoto(Perro perro) {
		        	  System.out.println("============= MODIFICAR FOTO =============");
		              System.out.println("Ingrese la nueva foto para el perro:");
		              String nuevaFoto = lector.nextLine();
		              perro.setFoto(nuevaFoto);
		              System.out.println("Foto modificada con éxito.");
		    }
		    
}
		  