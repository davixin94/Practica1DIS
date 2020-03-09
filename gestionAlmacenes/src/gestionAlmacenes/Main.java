package gestionAlmacenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = -1;
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
		
		while(menu != 4) {
			generarMenu();
			menu = Integer.parseInt(in.readLine());
			switch (menu) {
			case 1:
				Producto p = subMenuProducto();
				productos.add(p);
				break;
			case 2:
				Clientes c = subMenuCliente();
				clientes.add(c);
				break;
			case 3:
				Pedidos ped = subMenuPedidos();
				pedidos.add(ped);
				break;
			case 4:
				break;
			default:
				System.out.println("Por favor, elija una opción válida.");
			}
		}
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\">\n";
		String root = "<almacen>\n";
		String xml = "";
		xml += header + root;
		for(Producto p: productos) {
			xml += p;
		}
		for(Clientes c: clientes) {
			xml += c;
		}
		for(Pedidos ped: pedidos) {
			xml += ped;
		}
		String close_root = "\n</almacen>";
		
		xml += close_root;
		writeToFile(xml, "xmlAlmacen.xml");
	}
	
	public static void generarMenu() {
		System.out.println("---------------");
		System.out.println("Elija una opción:");
		System.out.println("1.- Introducir producto");
		System.out.println("2.- Introducir datos de cliente.");
		System.out.println("3.- Introducir datos de pedido");
		System.out.println("4.- Salir");
	}
	
	public static Producto subMenuProducto() throws NumberFormatException, IOException {
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Inicializacion de datos de producto
		int codigo = 0;
		String nombre = null;
		String descripcion = null;
		int stock = 0;
		char pasillo = ' ';
		int estanteria = 0;
		int estante = 0;
		boolean estado = false;
		System.out.println("Introduce datos del producto:");
		//Introducción de datos por el usuario
		System.out.println("Introduce codigo de 10 números:");
		codigo = in.read();
		System.out.println("Introduce nombre:");
		nombre = in.readLine();
		System.out.println("Introduce descripcion:");
		descripcion = in.readLine();
		System.out.println("Introduce stock:");
		stock = in.read();
		System.out.println("Introduce la localización del producto en el almacen:");
		System.out.println("Pasillo (A-Z):");
		pasillo = (in.readLine()).charAt(0);
		System.out.println("Estanteria (0-10):");
		estanteria = in.read();
		System.out.println("Introduce estante (0-5):");
		estante = in.read();
		System.out.println("---Fin de localización---");
		System.out.println("Introduce si el producto está en almacen (y/n):");
		do {
			if (in.readLine() == "y" || in.readLine() == "yes" || in.readLine() == "si") {
				estado = true;
			}else if(in.readLine() == "n" || in.readLine() == "no"){
				estado = false;
			}else {
				System.out.println("Por favor introduzca una opción válida.");
			}
		}while(in.readLine() != "y" || in.readLine() != "yes" || in.readLine() != "si" || in.readLine() != "n" || in.readLine() != "no");
		System.out.println("---FIN DE PRODUCTO---");
		
		Producto p = new Producto(codigo, nombre, descripcion, stock, pasillo,
				estanteria, estante, estado);
		return p;
	}
	
	public static Clientes subMenuCliente() throws IOException {
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Inicialización datos cliente
		String nombre = null;
		String apellido = null;
		String email = null;
		int telefono = 0;
		String calle = null;
		int numero = 0;
		int cp = 0;
		String poblacion = null;
		String pais = null;
		
		System.out.println("Introduce datos del cliente:");
		//Introducción de datos cliente por el usuario
		System.out.println("Introduce nombre:");
		nombre = in.readLine();
		System.out.println("Introduce apellidos:");
		apellido = in.readLine();
		System.out.println("Introduce email:");
		do {
			if (in.readLine().contains("@")) {
				email = in.readLine();
			}else {
				System.out.println("Email no válido");
			}
		}while(!in.readLine().contains("@"));
		System.out.println("Introduce teléfono:");
		telefono = in.read();
		System.out.println("Introduce dirección");
		System.out.println("Calle:");
		calle = in.readLine();
		System.out.println("Número:");
		numero = in.read();
		System.out.println("Código Postal:");
		cp = in.read();
		System.out.println("Población:");
		poblacion = in.readLine();
		System.out.println("Pais:");
		pais = in.readLine();
		System.out.println("---FIN DE CLIENTE---");
		
		Clientes c = new Clientes(nombre, apellido, email, telefono, calle, numero, cp, poblacion, pais);
		return c;
		
	}
	
	public static Pedidos subMenuPedidos() throws IOException {
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Inicializacion datos pedido
		String producto = null;
		ArrayList<String> productos = null;
		String calle = null;
		int numero = 0;
		int cp = 0;
		String poblacion = null;
		String pais = null;
		String destinatario = null;
		String fecha = null;
		
		
		System.out.println("Introduce datos del pedido:");
		//Introducción de datos del pedido por el usuario
		System.out.println("Introduce productos (presionar 0 para finalizar introducción de productos):");
		do {
			producto = in.readLine();
			productos.add(producto);
		}while(in.read() != 0);
		System.out.println("Productos introducidos.");
		System.out.println("Hay un total de " + productos.size() + " productos.");
		System.out.println("Introduce dirección de entrega:");
		System.out.println("Calle:");
		calle = in.readLine();
		System.out.println("Número:");
		numero = in.read();
		System.out.println("Código Postal:");
		cp = in.read();
		System.out.println("Población:");
		poblacion = in.readLine();
		System.out.println("Pais:");
		pais = in.readLine();
		System.out.println("---FIN de dirección de entrega---");
		System.out.println("Introduce nombre del destinatario:");
		destinatario = in.readLine();
		System.out.println("Introduce de fecha estimada de entrega:");
		System.out.println("Introduce día previsto (dd):");
		fecha += in.readLine();
		System.out.println("Introduce mes previsto (MM):");
		fecha += in.readLine();
		System.out.println("Introduce año previsto (yyyy):");
		fecha += in.readLine();
		System.out.println("---FIN DE PEDIDO---");
		
		Pedidos p = new Pedidos(productos, productos.size(), calle, numero, cp,
				poblacion, pais, destinatario,fecha);
		
		return p;
	}

}
