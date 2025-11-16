package src.br.edu.amepet.gerenciador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import src.br.edu.amepet.modelo.produto.Produto;
import src.br.edu.amepet.modelo.pessoa.Pessoa;
import src.br.edu.amepet.modelo.pet.Pet;
import src.br.edu.amepet.modelo.pessoa.Cliente;
import src.br.edu.amepet.modelo.pessoa.Funcionario;

public class GerenciadorPetShop {
    // POLIMORFISMO: Lista da superclasse abstrata (requisito 4.2)
    private List<Pessoa> pessoas;

    private List<Pet> pets;
    private List<Servico> servicos;
    private List<Produto> produtos;

    //COntrutor do Gerenciador
    //Inicializa todas as coleções e adiciona dados de exemplo
    public GerenciadorPetShop(){
        this.pessoas = new ArrayList<>();
        this.pets = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.produtos = new ArrayList<>();

        //Inicializa com dados de exemplo
        inicializarDadosExemplo();
    }

    //Inicializa o sistema com dados de exemplo para testes
    private void inicializarDadosExemplo(){
        //Clientes de exemplo
        try{
            Cliente c1 = new Cliente(
                "Bruno",
                "123.456.789-00",
                "(84) 9 9999-9999",
                "Rua dos Digimons, 12"
            );
            c1.adicionarCredito(500.0);
            pessoas.add(c1);

            Cliente c2 = new Cliente(
              "Alexandre",
              "987.654.321-00",
              "(84) 9 8888-2222",
              "Av. Principal, 743"  
            );
            c2.adicionarCredito(300.0);
            pessoas.add(c2);

            //Funcionários de exemplo
            Funcionario f1 = new Funcionario(
                "Gabriel",
                "111.222.333.44",
                "(84) 9 7777-3333",
                "Veterinário",
                5500.0,
                "01/01/2023"
            );
            pessoas.add(f1);

            Funcionario f2 = new Funcionario(    
                "Ikaro",
                "555.666.777-88",
                "(84) 9 6666-4444",
                "Tosador",
                2500.0,
                "15/03/2023"
            );

            //Pets de exemplo
            Pet pet1 = new Pet("Zoe", "Cachorro", "Poodle", 7, 13.0, "123.456.789-00");
            Pet pet2 = new Pet("Kira", "Gato", "Siamês", 3, 4.2, "123.456.789-00");
            Pet pet3 = new Pet("Luna","Cachorro","Poodle",7,11,"555.666.777-88");

            pets.add(pet1);
            pets.add(pet2);
            pets.add(pet3);

            //Adiciona pets aos clientes
            c1.adicionaPet(pet1);
            c1.adicionaPet(pet2);
            c2.adicionaPet(pet3);

            //Produtoa de exemplo
            produtos.add(new Produto("PRD001", "Ração Premium Cães", "Ração", 120.0, 50));
            produtos.add(new Produto("PRD002", "Ração Premium Gatos", "Ração", 95.0, 30));
            produtos.add(new Produto("PRD003", "Antipulgas", "Medicamento", 45.0, 20));
            produtos.add(new Produto("PRD004", "Vermífugo", "Medicamento", 30.0, 25));
            produtos.add(new Produto("PRD005", "Mordedor", "Briquedo", 25.0, 50));
            produtos.add(new Produto("PRD006", "Coleira", "Acessório", 35.0, 15));
            produtos.add(new Produto("PRD007", "Shampoo Pelos Longos", "Higiene", 38.0, 35));
            produtos.add(new Produto("PRD008", "Petiscos Naturais", "Alimentação", 22.0, 60)); 

        } catch (Exception e){
            System.err.println("Erro ao inicializar dados: " + e.getMessage());
        }
    }

    // ========== MÉTODOS DE GERENCIAMENTO DE PESSOAS ==========
    
    //Adiciona uma pessoa, cliente ou funcionário, ao sistema
    public void adicionarPessoa(Pessoa pessoa){
        if(pessoa != null){
            pessoas.add(pessoa);
        }
    }

    //Buscar uma pessoa pelo CPF
    public Pessoa buscarPessoaPorCpf(String cpf){
        for(Pessoa p : pessoas){
            if(p.getCpf().equals(cpf)){
                return p;
            }
        }
        return null;
    }

    //Buscar cliente pelo CPF
    public Cliente buscarClientePorCpf(String cpf){
        Pessoa p = buscarPessoaPorCpf(cpf);
        if(p instanceof Cliente){
            return (Cliente) p;
        }
        return null;
    }

    //Lista todas as pessoas cadastradas sem distinção
    public void listarTodasPessoas(){
        System.out.println("LISTAGEM DE TODAS AS PESSOAS (POLIMORFISMO)");

        if(pessoas.isEmpty()){
            System.out.println("Nenhuma pessoa cadastrada. Por favor, cadastre!");
            return;
        }

        for(Pessoa pessoa : pessoas){
            System.out.println(pessoa.exibirDetalhes());
        }

        System.out.println("=".repeat(60));
        System.out.println("Total: " + pessoas.size() + " pessoa(s)");
    }

    //Lista apenas clientes
    public void listarClientes(){
        System.out.println("\n>>> CLIENTES CADASTRADOS <<<");

        int count = 0;

        for(Pessoa p : pessoas){
            if(p instanceof Cliente){
                System.out.println(p.exibirDetalhes());
                count++;
            }
        }

        System.out.println("Total: " + count + " Cliente(s)");
    }

    //Lista apenas Funcionários
    public void listarFuncionarios(){
        System.out.println("\n>>> FUNCIONÁRIOS CADASTRADOS <<<");

        int count = 0;

        for(Pessoa p : pessoas){
            if(p instanceof Funcionario){
                System.out.print(p.exibirDetalhes());
                count++;
            }
        }

        System.out.println("Total: " + count + " Funcionário(s)");
    }

    // ========== MÉTODOS DE GERENCIAMENTO DE PETS ==========
    
    //Adicionar um pet ao sistema
    public void adicionarPet(Pet pet){
        if(pet != null){
            pets.add(pet);
        }
    }

    // Buscar pets de um cliente pelo CPF do dono
    public List<Pet> buscarPetsPorDono(String cpfDono){
        List<Pet> petsDoDono = new ArrayList<>();

        for(Pet pet : pets){
            if(pet.getCpfDono().equals(cpfDono)){
                petsDoDono.add(pet);
            }
        }
        return petsDoDono;
    }

    //Buscar pet pelo nome e CPF do dono
    public Pet buscarPetPorNome(String nomePet, String cpfDono){
        for(Pet pet : pets){
            if(pet.getNome().equalsIgnoreCase(nomePet) &&
               pet.getCpfDono().equals(cpfDono)){
                return pet;
            }
        }
        return null;
    }

    //Lista todos os pets cadastrados
    public void listarPets(){
        System.out.println("\n>>> PETS CADASTRADOS <<<");

        if(pets.isEmpty()){
            System.out.println("Nenhum pet cadastrado. Porfavor, Cadastre!");
            return;
        }

        for(Pet pet : pets){
            System.out.println(pet.exibirInformacoes());
        }

        System.out.println("Total: " + pets.size() + " pet(s)");
    }

    // ========== MÉTODOS DE GERENCIAMENTO DE SERVIÇOS ==========

    //Buscar um serviço pelo código
    public Servico buscarServicoPorCodigo(String codigo){
        for(Servico s : servicos){
            if(s.getCodigo().equals(codigo)){
                return s;
            }
        }
        return null;
    }

    //Listar todos os serviços disponíveis
    public void listarServicos(){
        System.out.println("\n>>> SERVIÇOS DISPONÍVEIS <<<");

        if(servicos.isEmpty()){
            System.out.println("Nenhum serviço cadastrado.");
            return;
        }

        for(Servico s : servicos){
            System.out.println(s.exibirInformacoes());
        }
    }

    //Contrata um serviço para um cliente
    public boolean contratarServico(String cpfCliente, String codigoServico){
        Cliente cliente = buscarClientePorCpf(cpfCliente):
        Servico servico = buscarServicoPorCodigo(codigoServico);

        if(cliente == null){
            System.out.println("Cliente não encontrado!");
            return false;
        }

        if(Servico == null){
            System.out.println("Serviço não encontrado!");
            return false;
        }

        if(cliente.debitarCredito(servico.getPreco())){
            cliente.incrementarServicosContratados();

            System.out.println("\nServiço contratado com sucesso!");
            System.out.println("Serviço: " + servico.getnome());
            System.out.println("Preço: R$ " + servico.getPreco());
            System.out.println("Crédito restante: R$ " + cliente.getSaldoCredito());
            return true;
        } else {
            System.out.println("\nSaldo insuficiente para contratar o serviço.");
            System.out.println("Saldo atual: R$ " + cliente.getSaldoDoCliente());
            System.out.println("Preço do serviço: R$ " + servico.getPreco());
            return false;
        }
    }

    // ========== MÉTODOS DE GERENCIAMENTO DE PRODUTOS ==========

    //Buscar um produto pelo código
    public Produto buscarProdutoPorCodigo(String codigo){
        for(Produto p : produtos){
            if(p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }

    //Listar todos os produtos disponíveis
    public void listarProdutos(){
        System.out.println("\n>>> PRODUTOS DISPONÍVEIS <<<");

        if(produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for(Produto p : produtos){
            System.out.println(p.exibirInformacoes());
        }
    }

    //Realiza a venda de um produto
    public boolean venderProduto(String cpfCliente, String CodigoProduto, int quantidade){
        Cliente cliente = buscarClientePorCpf(cpfCliente);
        Produto produto = buscarProdutoPorCodigo(codigoProduto);

        if(cliente == null){
            System.out.println("Cliente não encontrado!");
            return false;
        }
        if(produto == null){
            System.out.println("Produto não encontrado!");
            return false;
        }

        double valorTotal = produto.getPreco() * quantidade;

        if(!produto.reduzirEstoque(quantidade)){
            System.out.println("\nEstoque insuficiente!");
            System.out.println("Disponível: " + produto.getQuantidadeEstoque() + " unidade(s).");
            return false;
        }

        if(cliente.debitarCredito(valorTotal)){
            System.out.println("\nCompra realizada com sucesso!");
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Quantidade: " + quantidade);
            System.out.println("Valor total: R$ " + valorTotal);
            System.out.println("Saldo restante: R$ " + cliente.getSaldoDoCliente());
            return true;
        } else {
            //Devolve ao estoque se não conseguir debitar

            produto.adicionarEstoque(quantidade);
            System.out.println("\nSaldo insuficiente para realizar a compra.");
            System.out.println("Saldo atual: R$ " + cliente.getSaldoDoCliente());
            System.out.println("Valor da compra: R$ " + valorTotal);
            return false;
        }
    }

    // ========== GETTERS PARA ACESSO ÀS COLEÇÕES ==========

    public List<Pessoa> getPessoas(){
        return new ArrayList<>(pessoas);
    }

    public List<Pet> getPets(){
        return new ArrayList<>(pets);
    }

    public List<Servico> getServicos(){
        return new ArrayList<>(servicos);
    }

    public List<Produto> getProdutos(){
        return new ArrayList<>(produtos);
    }
}
