import java.util.Scanner;

class Hotel{
    public static void main(String[] args) {

        Scanner entradaDados = new Scanner (System.in);

        String[] hospedes = new String[300];
        int[] dias = new int[100];
        String[] quartos = new String[200];
        int consumoFrigobar[][] = new int [100][4];

        
        int reserva = 0;
        int numeroQuarto = 0;
        int numero = 0;
        String nome;
        int i = 0;
        
        
        int nQuarto=0;

        int op = 1;

        while (op != 0){

            System.out.println("\n\n===== MENU DO HOTEL =====");
            System.out.println("0 - Sair");
            System.out.println("1 - Reservar Quarto");
            System.out.println("2 - Cancelar Reserva");
            System.out.println("3 - Listar Reservas");
            System.out.println("4 - Consultar Hóspede");
            System.out.println("5 - Editar Hóspede");
            System.out.println("6 - Registrar Consumo do Frigobar");
            System.out.println("7 - Check-out");
            System.out.println("==========================");
            System.out.print("\n-> Escolha uma opcao: ");
            op = entradaDados.nextInt();
            entradaDados.nextLine();

            if (op == 1){

                System.out.print("\nDigite o nome do hóspede: ");
                nome = entradaDados.nextLine();
                reserva++;
                
                hospedes [i] = nome;
                hospedes [i+1] = String.valueOf(reserva);

                for (int y = 1; y < 200; y += 2){

                    if (quartos[y] == null || quartos[y] == "Disponível"){
                        if (quartos[y] == null){
                            numeroQuarto += 1;
                            //pegando quantos dias o hospede vai ficar
                            System.out.print("\nDigite quantos dias de estadia: ");
                            dias[numeroQuarto-1] = entradaDados.nextInt();
                            quartos [y-1] = String.valueOf(numeroQuarto);
                            quartos [y] = "Ocupado"; 
                            hospedes [i+2] = String.valueOf(numeroQuarto);
                        }else{
                            quartos [y] = "Ocupado"; 
                            hospedes [i+2] = quartos [y-1];
                        }

                        break;
                    }
                }
                System.out.print("\nNúmero do quarto: "+ hospedes[i+2]);
                System.out.print("\n\n-> Hóspede cadastrado com sucesso!");
                i+=3;

            }

            else if (op == 2){

                System.out.print("\nDigite o número do quarto: ");
                nQuarto = entradaDados.nextInt();

                while (nQuarto > 100 || nQuarto < 1){
                    System.out.println("\nDigite um número entre 1 e 100 : ");
                    nQuarto = entradaDados.nextInt();
                }

                numero = nQuarto;

                int indiceNumero = (nQuarto * 2) - 2;
                int indiceStatus = (nQuarto * 2) - 1;

                if (quartos[indiceStatus] == "Ocupado"){

                    quartos[indiceStatus] = "Disponível";

                    for (int x = 2; x < 300; x += 3){

                        if (String.valueOf(numero).equals(hospedes[x])){

                            hospedes[x-2] = null;
                            hospedes[x-1] = null;
                            hospedes[x] = null;
                        }
                    }
                    for (int j = 0; j < 4; j++){
                        consumoFrigobar[numero-1][j] = 0;
                    }
                    dias[nQuarto-1] = 0;
                    System.out.println("\nCancelamento feito com SUCESSO!");

                }else{
                    System.out.println("\nEste quarto já está disponível!");
                }

            }else if (op == 3){
                System.out.println("\n===== LISTAR RESERVAS =====");
                String numeroDoQuarto = "";
                for (int x = 1; x < 200; x+=2){

                    if (quartos[x] != null && quartos[x].equals("Ocupado")){
                        numeroDoQuarto = quartos[x-1];
                        nQuarto = Integer.parseInt(numeroDoQuarto);

                        for (int y = 2; y < 300; y+=3){
                            if (hospedes[y] != null && hospedes[y].equals(numeroDoQuarto)){
                                System.out.println("\nQuarto: "+numeroDoQuarto);
                                System.out.println("Nome do hóspede: "+ hospedes[y-2]);
                                System.out.println("Dias de estadia: "+ dias[nQuarto-1]);
                                System.out.println("Número de reserva: "+hospedes[y-1]);
                                System.out.print("-----------------------------------------------\n");
                            }
                        }

                    }
                }
            }else if (op == 4){
                int cond = 0;
                System.out.println("\n===== CONSULTAR HÓSPEDE =====");
                System.out.print("\nDigite o número do quarto: ");
                nQuarto = entradaDados.nextInt();
                while (nQuarto > 100 || nQuarto < 1){
                    System.out.print("\nDigite um número entre 1 e 100 : ");
                    nQuarto = entradaDados.nextInt();
                }

                for (int x = 2; x < 300; x+=3){
                    if (hospedes[x]!=null && hospedes[x].equals(String.valueOf(nQuarto))){
                        System.out.println("\nNome do hóspede: "+hospedes[x-2]);
                        System.out.println("Número da reserva: "+hospedes[x-1]);
                        System.out.println("Número do Quarto: "+hospedes[x]);
                        cond = 1;
                    }
                }
                if (cond == 0){
                    System.out.print("\nHóspede não encontrado!");
                }
            }
            else if (op == 5){
                System.out.println("\n===== EDITAR HÓSPEDE =====");
                System.out.print("\nDigite o número do quarto: ");
                nQuarto = entradaDados.nextInt();
    
                while (nQuarto > 100 || nQuarto < 1){
                    System.out.print("\nDigite um número entre 1 e 100: ");
                    nQuarto = entradaDados.nextInt();
                }
    
                int indiceStatus = (nQuarto * 2) - 1;

                if (quartos[indiceStatus] != null && quartos[indiceStatus].equals("Ocupado")){
                    System.out.println("Quarto está ocupado!");
        
        
                    String nomeHospede = "";
                    int posicaoEncontrada = -1;

                     for (int x = 2; x < 300; x += 3){
                        if (hospedes[x] != null && hospedes[x].equals(String.valueOf(nQuarto))){
                            nomeHospede = hospedes[x-2];
                            posicaoEncontrada = x;
                            break;
                        }
                    }
        
                    if (posicaoEncontrada != -1) {
                        System.out.println("\nHóspede encontrado: " + nomeHospede);
                        System.out.println("Quarto: " + hospedes[posicaoEncontrada]);
                        System.out.println("Reserva: " + hospedes[posicaoEncontrada-1]);
                        System.out.println("\n-----------------------------------------");
                        System.out.println("O que deseja editar?");
                        System.out.println("1 - Nome do hóspede");
                        System.out.println("2 - Número da reserva");
                        System.out.print("\n-> Escolha: ");
                        int opcaoEdicao = entradaDados.nextInt();
                        entradaDados.nextLine();

                        if (opcaoEdicao == 1) {
                            System.out.print("\nDigite o novo nome: ");
                            String novoNome = entradaDados.nextLine();
                            hospedes[posicaoEncontrada-2] = novoNome;  
                            System.out.println("\n-> Nome alterado com sucesso!");
                        }
                        else if (opcaoEdicao == 2) {
                            System.out.print("\nDigite o novo número da reserva: ");
                            String novaReserva = entradaDados.next();
                            hospedes[posicaoEncontrada-1] = novaReserva;  
                            System.out.println("\n-> Reserva alterada com sucesso!");
                        } 
                        else {
                            System.out.println("Opção inválida!");
                        }
                    } 
                    else {
                         System.out.println("\n-> Erro: Hóspede não encontrado para este quarto!");
                    }
                } else {
                    System.out.println("Quarto não está ocupado!");
                }
                //entradaDados.nextLine();
            }
            else if (op == 6){
                System.out.println("\n===== CONSUMO DO FRIGOBAR =====");
                System.out.print("\nDigite o número do quarto: ");
                nQuarto = entradaDados.nextInt();
             
                while (nQuarto > 100 || nQuarto < 1){
                System.out.print("\nDigite um número entre 1 e 100: ");
                nQuarto = entradaDados.nextInt();
                }
                
                int indiceStatus = (nQuarto * 2) - 1;

                if (quartos[indiceStatus] != null && quartos[indiceStatus].equals("Ocupado")){
                    System.out.println("Quarto está ocupado!");
                
                    System.out.println("\n--- PRODUTOS DO FRIGOBAR ---");
                    System.out.println("1 - Água (R$5,00)");
                    System.out.println("2 - Refrigerante (R$6,50)");
                    System.out.println("3 - Suco (R$9,00)");
                    System.out.println("4 - Chocolate (R$12,00)");
                    System.out.print("\n-> Escolha o produto (1-4): ");
                    int produto = entradaDados.nextInt();
        
                    if (produto >= 1 && produto <= 4) {
            
                        System.out.print("\n-> Quantidade consumida: ");
                        int quantidade = entradaDados.nextInt();
            
                        //vendo a quantidade de produtos consumidos
                        if (quantidade > 0) {
                            consumoFrigobar[nQuarto-1][produto-1] += quantidade;
                            System.out.println("\nConsumo registrado com sucesso!");
                            System.out.println("Total atual deste produto: " + consumoFrigobar[nQuarto-1][produto-1] + " unidade(s)");
                
                        } else {
                            System.out.println("Quantidade inválida!");
                        }
            
                    } else {
                        System.out.println("Produto inválido!");
                        }
        
        
                } else {
                    System.out.println("Quarto não está ocupado!");
                    }
                
                System.out.print("\n\nARRAY CONSUMO:\n\n");
                //for (int x = 0; x < consumoFrigobar.length; x++){
                //    for (int y = 0; y < consumoFrigobar[x].length; y++){
                //        System.out.print(consumoFrigobar[x][y] + " ");
                //    }
                //    System.out.println();
                //}
            }
            else if (op == 7){
                System.out.println("\n===== CHECK OUT =====");
                int validacaoOcupado = 0;
                System.out.print("\nDigite o nome do hóspede: ");
                String nomeHospede = entradaDados.next();
                for (int x = 0; x < 300; x+=3){
                    if(hospedes[x] != null && hospedes[x].equals(String.valueOf(nQuarto))){
                        nomeHospede = hospedes[x-2];
                        break;
                    }
                }
                System.out.print("Digite o número do quarto: ");
                nQuarto = entradaDados.nextInt();
                int indiceStatus = (nQuarto * 2) - 1;
                while(validacaoOcupado == 0){
                    if(quartos[indiceStatus] != null && quartos[indiceStatus].equals("Ocupado")){
                        validacaoOcupado = 1;
                    }
                    else{
                        System.out.print("ERRO, status do quarto (Disponível). Digite novamente o número do quarto: ");
                        nQuarto = entradaDados.nextInt();
                        validacaoOcupado = 0;
                    }
                }
                //CALCULO FINAL
                double precoDiaria = 850.00;
                double[] precos = {5.00, 6.50, 9.00, 12.00};
                double totalFrigobar = 0;
                double totalDiaria = 0;
                double valor = 0;
                double totalConta = 0;
                for (int x = 0; x < 4; x++){
                    if(consumoFrigobar[nQuarto-1][x] > 0){
                        int qtd = consumoFrigobar[nQuarto-1][x];
                        valor = qtd * precos[x];
                        totalFrigobar += valor;
                    }
                }
                int qtdDiaria = dias[nQuarto-1];
                totalDiaria = qtdDiaria * precoDiaria;
                totalConta = totalDiaria + totalFrigobar;
                //mostrando o total
                System.out.println("\n===== RESUMO DA CONTA =====");
                System.out.println("\nNome do Hóspede: " + nomeHospede);
                System.out.println("Número do Quarto: " + nQuarto);
                System.out.println("Total das diárias: R$" + totalDiaria);
                System.out.println("Total do Frigobar: R$" + totalFrigobar);
                System.out.println("Valor total a pagar: R$" + totalConta);
                //limpando consumo do frigobar
                for (int x = 0; x < 4; x++){
                    consumoFrigobar[nQuarto-1][x] = 0;
                }
                //mudando status do quarto
                indiceStatus = (nQuarto * 2) - 1;
                if(quartos[indiceStatus] != null && quartos[indiceStatus].equals("Ocupado")){
                    quartos[indiceStatus] = "Disponível";
                }
                else{
                    System.out.print("ERRO ao mudar status do quarto!");
                }
                //limpando dados do hospede
                nomeHospede = "";
                for (int x = 0; x < 300; x++){
                    if(hospedes[x] != null && hospedes[x].equals(String.valueOf(nQuarto))){
                        //hospedes[x-2] = null;
                        //hospedes[x-1] = null;
                        hospedes[x] = null; 
                        break;
                    }
                }
                dias[nQuarto-1] = 0;
            }
            
            
        }
        System.out.println("\n\n====== Sistema fechado! ======");
    }
}
