package trabalhopoo;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        /* Parte para adição dos vegetais que o programa está comprando */
        Instrucao instru = new Instrucao();
        Chamado chamado = new Chamado();
        Mercado mercado = new Mercado();
        String senhapenviar;
        String nomepenviar;
        Vegetais vegetais = new Vegetais();
        vegetais.addVege("Alface", "20");
        vegetais.addVege("Espinafre", "40");
        vegetais.addVege("Tomate cereja", "45");
        vegetais.addVege("Pepino", "50");
        vegetais.addVege("Cenoura", "25");
        vegetais.addVege("Rabanetes", "50");
        vegetais.addVege("Mini pimenta vermelha", "90");
        /* =============== vegetais ============== */

        /* =Adição das ervas a serem compradas pelo programa= */
        Ervas ervas = new Ervas();
        ervas.addErvas("Alecrim", "10");
        ervas.addErvas("Hortela", "20");
        ervas.addErvas("Manjericao", "15");
        ervas.addErvas("Salvia", "20");
        ervas.addErvas("Salsa", "25");
        ervas.addErvas("Cebolinha", "30");
        ervas.addErvas("Louro", "10");
        ervas.addErvas("Cerefólio", "40");

        /* ================ ervas ================ */
        Login log = new Login();
        /* Login */
        Scanner scan = new Scanner(System.in).useDelimiter("\\n");;
        int login = 0;
        String senha;
        String nome;
        String endereco;
        String CPF;
        while (login == 0) {
            System.out.println("\n----------------------------------------------------------------------------");
            System.out.println("CASO QUEIRA FAZER CADASTRO, DIGITAR 2 NO INICIO DO PROGRAMA");
            System.out.println("----------------------------------------------------------------------------\n\n\n");
            System.out.println("[LOGIN]");
            System.out.println("[login]SENHA:");
            senha = scan.next();
            /* Caso tenha digitado 2, entrara no cadastro */
            if (senha.equals("2")) {

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n [CADASTRO]\n\n\n\n\n\n\n");
                System.out.println("[cadastro] o seu endereco");
                endereco = scan.next();
                System.out.println("[cadastro] sua senha: ");
                senha = scan.next();
                System.out.println("[cadastro] seu nick: ");
                nome = scan.next();
                System.out.println("[cadastro] seu cpf");
                CPF = scan.next();

                log.gravarLogin(senha, nome, endereco, CPF);
            }
            System.out.println("[login]Nome:");
            nome = scan.next();
            
            int flag = log.consultarLogin(senha, nome);
            if (flag == 1) {
                senhapenviar = senha;
                nomepenviar = nome;
                /* ----------------------Menu do programa -----------------------------------*/
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n[Login bem sucedido]\n\n\n\n\n\n\n");
                int menu = 0;
                while (menu == 0) {
                    System.out.println("Digite 1 para Menu de usuario e 2 para Menu de mercado");
                    int us;
                    us = scan.nextInt();
                    
                    String desejo;
                    int infinito = 90;
                    if (us == 1) {
                        /* *********************************Menu de usuarios************************************ */
                        while (infinito == 90) {

                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nDigite o que deseja fazer, possibilidades:\n\n\n[Informacoes]\n[Ervas]\n[Vegetais]\n[Instruções]\n[Valor]\n[Chamado](iremos a sua residencia para comprar sua remessa)\n[Sair]");
                            desejo = scan.next().toLowerCase();

                            if (desejo.equals("sair")) {
                                infinito = 0;
                                menu = 1;
                                break;
                            } else if (desejo.equals("informacoes")) {
                                instru.info();
                                TimeUnit.SECONDS.sleep(28);
                            } else if (desejo.equals("ervas")) {
                                ervas.get();
                                TimeUnit.SECONDS.sleep(10);
                            } else if (desejo.equals("vegetais")) {
                                vegetais.get();
                                TimeUnit.SECONDS.sleep(10);
                            } else if (desejo.equals("instrucoes")) {
                                instru.instru();
                                TimeUnit.SECONDS.sleep(150);
                            } else if (desejo.equals("valor")) {
                                System.out.println("Ervas que estamos comprando[kg]:\n");
                                ervas.CalculaPreco();
                                System.out.println("\nVegetais que estamos comprando[kg]:\n");
                                vegetais.CalculaPreco();
                                TimeUnit.SECONDS.sleep(40);
                            } else if (desejo.equals("chamado")) {
                                String recebeend, recebeNome;
                                recebeend = log.consultaEnd(senhapenviar, nomepenviar);
                                recebeNome = log.pegaNome(senhapenviar, nomepenviar);
                                chamado.gravaChamado(recebeend, recebeNome);
                                TimeUnit.SECONDS.sleep(2);
                            }
                        }
                        /* *********************************Fim do Menu de usuarios************************************ */
                    }  /* *********************** Menu de mercado ********************************  */
                    else if (us == 2) {
                        String nomemercado;
                        String enderecomercado;
                        String CNPJ;
                        infinito = 90;
                        while (infinito == 90) {
                            System.out.println("\n\n\n\n\nDigite o que deseja fazer, possibilidades: \n[registrar] mercado\n[Consultar] todos os mercados registrados\n[sair]\n");
                            desejo = scan.next().toLowerCase();

                            if (desejo.equals("registrar")) {
                                System.out.println("Digite o nome do mercado");
                                nomemercado = scan.next();
                                System.out.println("Digite o endereco do mercado");
                                enderecomercado = scan.next();
                                System.out.println("Digite o CNPJ referente ao mercado");
                                CNPJ = scan.next();
                                mercado.gravarMercado(nomemercado, enderecomercado, CNPJ);
                            } else if (desejo.equals("consultar")) {
                                mercado.consultarMercados();
                                TimeUnit.SECONDS.sleep(10);
                            } else if (desejo.equals("sair")) {
                                infinito = 0;
                                menu = 1;
                                break;
                            }
                        }
                    } /* ********************* fim do menu de mercado **************************** */  else {
                        System.out.println("\n\n\n\n\n\n\n\n\n\nLOGIN FALHOU, CONSIDERE CADASTRAR OU TENTE NOVAMENTE");
                    }
                    
                }
                /* ---------------------- Fim do menu do programa -----------------------------------*/
            }
        }
    }
}
