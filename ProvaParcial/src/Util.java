import java.util.ArrayList;
import java.util.Scanner;

public class Util {

    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    private static TipoPessoa inputTipoCliente() {
       
        Scanner scan = new Scanner(System.in);
        String tp = "";
        while (!tp.equals("j") && !tp.equals("f")) {
            System.out.print("Tipo do Cliente? [F|J] ");
            tp = scan.nextLine().toLowerCase();    
            if (!tp.equals("j") && !tp.equals("f")) {
                System.err.println("F: Física | J: Jurídica");
            }
        }
        return tp.equals("f") ? TipoPessoa.Fisica : TipoPessoa.Juridica;
    }


    public static boolean inputFormaPagamento(){
        
        Scanner scan = new Scanner(System.in);
        String tp = "";
        while (!tp.equals("a") && !tp.equals("p")) {
            System.out.print("Forma de pagamento(à vista ou parcelado)? [A|P] ");
            tp = scan.nextLine().toLowerCase();    
            if (!tp.equals("a") && !tp.equals("p")) {
                System.err.println("A: À vista | P: Parcelado");
            }
        }
        return tp.equals("a") ? true: false;
    }

    public static void reservarMesa() {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Indique o seu nome: ");
        String nome = scan.nextLine();

        TipoPessoa tipoPessoa = inputTipoCliente();
        
        Cliente c = null;
        
        switch(tipoPessoa) {
            case Fisica:
                System.out.print("CPF: ");
                String cpf = scan.nextLine();

                PessoaFisica pf = new PessoaFisica(nome, cpf);

                c = pf;
                break;

            case Juridica:
                System.out.print("CNPJ: ");
                String cnpj = scan.nextLine();
                
                PessoaJuridica pj = new PessoaJuridica(nome, cnpj);
                
                c = pj;
                break;
        }

        boolean pagamento = inputFormaPagamento();
        
        Reserva reserva = new Reserva(c, pagamento);
        
        clientes.add(c);
        reservas.add(reserva);

        if(reservas.size() <= 6){
            System.out.println("Reserva efetuada com sucesso!");
        } else {
            System.out.println("Você está na lista de espera...");
        }
        
    }

    public static void pesquisarReserva() {
        Scanner scan = new Scanner(System.in);
        String dado;

        System.out.print("Informe o seu CPF ou CNPJ -> ");
        dado = scan.nextLine();

        boolean existencia = false;

        for(int i = 0; i < reservas.size(); i++){
            if(reservas.get(i).getCliente() instanceof PessoaFisica){
                Cliente c = reservas.get(i).getCliente();
                PessoaFisica pf = (PessoaFisica) c;
                if(pf.getCpf().equals(dado)){
                    existencia = true;
                }
            } else if(reservas.get(i). getCliente() instanceof PessoaJuridica){
                Cliente c = reservas.get(i).getCliente();
                PessoaJuridica pj = (PessoaJuridica) c;
                if(pj.getCnpj().equals(dado)){
                    existencia = true;
                }
            }
        }

        if (existencia == false){
            System.out.println("Você não possui nenhuma reserva.");
        } else {
            System.out.println("Você possui uma reserva para o jantar.");
        }
    }

    public static void imprimirReservas() {
        for(int i = 0; i < 6 && i < reservas.size(); i++){
            System.out.println(reservas.get(i));
        }
    }

    public static void imprimirListaEspera() {
        for(int i = 6; i < reservas.size(); i++){
            System.out.println(reservas.get(i));
            System.out.println("Posição na lista de espera -> " + (i-5));
        }
    }

    public static void cancelarReserva() {
        Scanner scan = new Scanner(System.in);
        String dado;

        System.out.print("Informe o seu CPF ou CNPJ -> ");
        dado = scan.nextLine();
        boolean existencia = false;

        for(int i = 0; i < reservas.size(); i++){
            if(reservas.get(i).getCliente() instanceof PessoaFisica){
                Cliente c = reservas.get(i).getCliente();
                PessoaFisica pf = (PessoaFisica) c;
                if(pf.getCpf().equals(dado)){
                    reservas.remove(i);
                    existencia = true;
                }
            } else if(reservas.get(i). getCliente() instanceof PessoaJuridica){
                Cliente c = reservas.get(i).getCliente();
                PessoaJuridica pj = (PessoaJuridica) c;
                if(pj.getCnpj().equals(dado)){
                    reservas.remove(i);
                    existencia = true;
                }
            }
        }

        if (existencia == true){
            System.out.println("Reserva cancelada.");
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }
    
}
