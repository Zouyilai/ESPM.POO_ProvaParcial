import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String menu = menu();

        boolean exit = false;

        while (!exit) {
            System.out.println(menu);
            System.out.print("Escolha uma opção -> ");
            String opcao = scan.nextLine().trim();
            try {
                switch(opcao) {
					case "1":
						Util.reservarMesa();
						break;
					case "2":
						Util.pesquisarReserva();
						break;
					case "3":
						Util.imprimirReservas();
						break;
					case "4":
						Util.imprimirListaEspera();
						break;
					case "5":
						Util.cancelarReserva();
						break;
                    case "6":
                        exit = true;
                        break;
                    default:
                        System.err.println("Comando inválido!");
                }
            } catch (UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Aplicação finalizada!");
    }
    

	public static String menu() {
	
		String aux = "";
        aux += "-----------------------------";
		aux += "\nRestaurante SABOR SOFISTICADO";
		aux += "\n1. Reservar mesa";
		aux += "\n2. Pesquisar reserva";
		aux += "\n3. Imprimir reserva";
		aux += "\n4. Imprimir lista de espera";
		aux += "\n5. Cancelar reserva";
		aux += "\n6. Finalizar";
        aux += "\n-----------------------------";
		
		return aux;
	}
}
