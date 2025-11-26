package br.edu.amepet.gerenciador;

import br.edu.amepet.modelo.atendimento.*;
import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pessoa.Funcionario;
import br.edu.amepet.modelo.pessoa.Pessoa;
import br.edu.amepet.modelo.pet.Pet;
import br.edu.amepet.modelo.pet.PetAdocao;
import br.edu.amepet.modelo.pet.PetsVenda;
import br.edu.amepet.modelo.produto.Produto;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorPetShop {

    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();
    private List<PetsVenda> petsVenda = new ArrayList<>();
    private List<PetAdocao> petsAdoção = new ArrayList<>();
    private List<br.edu.amepet.modelo.venda.Venda> vendas = new ArrayList<>();
    private int proximoIdVenda = 1;

    public GerenciadorPetShop() {
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais() {

        // ------------------------------------------------------------
        // FUNCIONÁRIO PADRÃO PARA LOGIN
        // ------------------------------------------------------------
        Funcionario admin = new Funcionario(
                "Administrador do Sistema",
                "000.000.000-00",
                "(00) 00000-0000",
                "Gerente",
                3000.00,
                "01/01/2024",
                "admin",   // usuário
                "1234"     // senha
        );
        pessoas.add(admin);

        // ------------------------------------------------------------
        // CLIENTE PADRÃO PARA TESTES
        // ------------------------------------------------------------
        Cliente clienteTeste = new Cliente(
                "ClienteTeste",
                "123",
                "(84) 90000-0000",
                "Rua Exemplo, 123"
        );
        pessoas.add(clienteTeste);
    }

    // ============================================================
    //                   CADASTROS BÁSICOS
    // ============================================================

    public void adicionarFuncionario(Funcionario f) {
        if (f != null) pessoas.add(f);
    }

    public void adicionarCliente(Cliente c) {
        if (c != null) pessoas.add(c);
    }

    public void adicionarPet(String cpfDono, Pet p) {
        Cliente c = buscarClientePorCpf(cpfDono);
        if (c == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        p.setCpfDono(cpfDono);
        pets.add(p);
    }

    public void cadastrarProduto(Produto p) {
        produtos.add(p);
    }

    // ============================================================
    //                   LISTAGENS PRONTAS
    // ============================================================

    public void listarFuncionarios() {
        System.out.println("\n>>> FUNCIONÁRIOS <<<");
        for (Pessoa p : pessoas)
            if (p instanceof Funcionario f)
                System.out.println(f.exibirDetalhes());
    }

    public void listarClientes() {
        System.out.println("\n>>> CLIENTES <<<");
        for (Pessoa p : pessoas)
            if (p instanceof Cliente c)
                System.out.println(c.exibirDetalhes());
    }

    public void listarPets() {
        System.out.println("\n>>> PETS <<<");
        for (Pet p : pets)
            System.out.println(p.exibirInformacoes());
    }

    public void listarProdutos() {
        System.out.println("\n>>> PRODUTOS <<<");
        for (Produto p : produtos)
            System.out.println(p.exibirInformacoes());
    }

    public void listarAtendimentos() {
        System.out.println("\n>>> ATENDIMENTOS <<<");
        for (Atendimento a : atendimentos)
            System.out.println(a.exibirInformacoes());
    }

    // ============================================================
    //                      LOGIN
    // ============================================================

    public Funcionario loginFuncionario(String usuario, String senha) {
        for (Pessoa p : pessoas) {
            if (p instanceof Funcionario f) {
                if (f.getUsuarioFuncionario().equals(usuario)
                        && f.getSenhaFuncionario().equals(senha)) {
                    return f;
                }
            }
        }
        return null;
    }

    // ============================================================
    //                      BUSCAS
    // ============================================================

    public Cliente buscarClientePorCpf(String cpf) {
        for (Pessoa p : pessoas)
            if (p instanceof Cliente c)
                if (c.getCpf().equals(cpf)) return c;
        return null;
    }

    public Pet buscarPetPorNome(String nomePet) {
        for (Pet p : pets)
            if (p.getNome().equalsIgnoreCase(nomePet))
                return p;
        return null;
    }

    public Produto buscarProduto(String nome) {
        for (Produto p : produtos)
            if (p.getNome().equalsIgnoreCase(nome))
                return p;
        return null;
    }

    public void buscarServicos(String cpf, String nomePet) {
        for (Atendimento a : atendimentos) {
            if (a.getCliente().getCpf().equals(cpf)
                    && a.getPet().getNome().equalsIgnoreCase(nomePet)) {
                System.out.println(a.exibirInformacoes());
            }
        }
    }

    // ============================================================
    //                      REMOÇÕES
    // ============================================================

    public void removerFuncionario(String cpf) {
        Pessoa alvo = null;

        for (Pessoa p : pessoas)
            if (p instanceof Funcionario f && f.getCpf().equals(cpf))
                alvo = p;

        if (alvo != null) {
            pessoas.remove(alvo);
            System.out.println("Funcionário removido!");
        } else System.out.println("Funcionário não encontrado.");
    }

    public void removerCliente(String cpf) {
        Pessoa alvo = null;

        for (Pessoa p : pessoas)
            if (p instanceof Cliente c && c.getCpf().equals(cpf))
                alvo = p;

        if (alvo != null) {
            pessoas.remove(alvo);
            System.out.println("Cliente removido!");
        } else System.out.println("Cliente não encontrado.");
    }

    public void removerPet(String cpfDono, String nomePet) {
        Pet alvo = null;

        for (Pet p : pets) {
            if (p.getCpfDono().equals(cpfDono)
                    && p.getNome().equalsIgnoreCase(nomePet)) {
                alvo = p;
                break;
            }
        }

        if (alvo != null) {
            pets.remove(alvo);
            System.out.println("Pet removido!");
        } else System.out.println("Pet não encontrado.");
    }

    // ============================================================
    //                      SERVIÇOS
    // ============================================================

    private void registrarAtendimento(Atendimento a) {
        atendimentos.add(a);
        System.out.println("✔ Serviço registrado com sucesso!");
    }

    public void registrarBanho(String codigo, String nome, double preco, Cliente cliente, Pet pet, String data, String tipoBanho, int tempoBanho) {


        registrarAtendimento(new Banho(codigo, nome, preco, cliente, pet, data, tipoBanho,  tempoBanho));
    }

    public void registrarTosa(String codigo, String nome, double preco, Cliente cliente, Pet pet, String data, String tipoTosa, int duracaoHoras) {
        registrarAtendimento(new Tosa(codigo, nome, preco, cliente, pet, data, tipoTosa,duracaoHoras));
    }

    public void registrarExame(String codigo, double preco, Cliente cliente, Pet pet, String data, String tipoExame) {
       Exame exame = new Exame(codigo,preco, cliente, pet, data,tipoExame);
    }

    public void registrarConsulta(String codigo, double preco, Cliente cliente, Pet pet, String data, String veterinario) {
              Consulta consulta = new Consulta(codigo, preco, cliente, pet, data, veterinario);
              registrarAtendimento(consulta);
    }

    public void registrarVacina(String codigo, double preco, Cliente cliente, Pet pet, String data, String tipoVacina) {
          Vacina vacina = new Vacina(codigo, preco, cliente, pet, data, tipoVacina);
          registrarAtendimento(vacina);
    }

    public void registrarCirurgia(String codigo, double preco, Cliente cliente, Pet pet, String data, String procedimento, int duracaoHoras) {

        Cirurgia cirurgia = new Cirurgia(codigo, preco, cliente, pet, data, procedimento, duracaoHoras
        );
        registrarAtendimento(cirurgia);
    }


    public void registrarInternacao(String codigo, double preco, Cliente cliente, Pet pet, String data, String motivo, int diasInternado) {
       Internacao internacao = new Internacao(codigo,preco,cliente,pet,data,motivo,diasInternado);
       registrarAtendimento(internacao);
    }

    // ============================================================
    //                      HISTÓRICO
    // ============================================================

    public void mostrarHistoricoServicos(String cpf, String nomePet) {

    }

    public void mostrarHistoricoMedico(String cpf, String nomePet) {
        for (Atendimento a : atendimentos) {
                if (a.getCliente().getCpf().equals(cpf)
                        && a.getPet().getNome().equalsIgnoreCase(nomePet)) {
                    System.out.println(a.exibirInformacoes());
                }
        }
    }
    // ============================================================
    //                      RELATÓRIOS
    // ============================================================

    public void relatorioClientes() {
        listarClientes();
    }

    public void relatorioPets() {
        listarPets();
    }

    public void relatorioServicos() {
        listarAtendimentos();
    }

    public void relatorioVendas() {
        System.out.println("\n>>> VENDAS <<<");
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }

        double totalReceita = 0.0;
        System.out.println("Relatório de vendas (recibos):");
        for (br.edu.amepet.modelo.venda.Venda v : vendas) {
            System.out.println(v.gerarRecibo());
            totalReceita += v.getValorFinal();
        }

        System.out.printf("Total de vendas: %d\n", vendas.size());
        System.out.printf("Receita total: R$%.2f\n", totalReceita);
    }

    // ============================================================
    //                      ESTOQUE E VENDAS
    // ============================================================

    public void atualizarPrecoProduto(String nome, double novoPreco) {
        Produto p = buscarProduto(nome);

        if (p != null) {
            p.setPreco(novoPreco);
            System.out.println("Preço atualizado!");
        } else System.out.println("Produto não encontrado.");
    }

    public void atualizarEstoque(String nome, int quantidade) {
        Produto p = buscarProduto(nome);

        if (p != null) {
            p.adicionarEstoque(quantidade);
            System.out.println("Estoque atualizado!");
        } else System.out.println("Produto não encontrado.");
    }

    public void removerProduto(String nome) {
        Produto alvo = buscarProduto(nome);

        if (alvo != null) {
            produtos.remove(alvo);
            System.out.println("Produto removido!");
        } else System.out.println("Produto não encontrado.");
    }

    public void registrarVenda(String nomeProduto, int qtd) {
        Produto p = buscarProduto(nomeProduto);

        if (p == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        if (p.getQuantidadeEstoque() < qtd) {
            System.out.println("Estoque insuficiente.");
            return;
        }

        p.reduzirEstoque(qtd);
        System.out.println("Venda registrada!");
    }

    public void emitirRecibo() {
        System.out.println("---- Recibo emitido ----");
    }

    // ============================================================
    //                      COMPRA E ADOÇÕES
    // ============================================================
    
    
    public void cadastrarPetVenda(PetsVenda pv) {
        petsVenda.add(pv);
        System.out.println("Pet para compra cadastrado com sucesso!");
    }

    public PetsVenda obterPetVendaPorNome(String nome) {
        for (PetsVenda pv : petsVenda) {
            if (pv.getNome().equalsIgnoreCase(nome)) {
                return pv;
            }
        }
        return null;
    }

    public void listarpetsvenda(){
        if (petsVenda.isEmpty()) {
            System.out.println("Nenhum pet disponível para venda no momento.");
            return;
        }

        System.out.println("Pets disponíveis para compra");
        for(int i = 0; i < petsVenda.size(); i++) {
            PetsVenda pet = petsVenda.get(i);
            System.out.println((i + 1) + ". " + petsVenda.get(i).detalhes());
        }
    }

    public void comprarPet(String nome){
        for (int i = 0; i < petsVenda.size(); i++) {
            PetsVenda pet = petsVenda.get(i);
            if (pet.getNome().equalsIgnoreCase(nome)) {
                petsVenda.remove(i);
                System.out.println("Você comprou o pet com sucesso!");
                System.out.println(pet.detalhes());
                return;
            }
        }
    }

    public void comprarPetComVenda(String nome, String cpfComprador, String formaPagamento, double valorFinal) {
        for (int i = 0; i < petsVenda.size(); i++) {
            PetsVenda pet = petsVenda.get(i);
            if (pet.getNome().equalsIgnoreCase(nome)) {
                petsVenda.remove(i);

                String id = String.format("V%06d", proximoIdVenda++);
                java.time.LocalDateTime now = java.time.LocalDateTime.now();
                br.edu.amepet.modelo.venda.Venda v = new br.edu.amepet.modelo.venda.Venda(
                        id,
                        cpfComprador,
                        pet.getNome(),
                        pet.getPreco(),
                        formaPagamento,
                        valorFinal,
                        now,
                        "PAGO"
                );
                vendas.add(v);

                System.out.println("Compra registrada com sucesso!");
                System.out.println(v.gerarRecibo());
                return;
            }
        }
        System.out.println("Pet não encontrado para compra.");
    }

    public void cadastrarPetParaAdoção(PetAdocao pa) {
        petsAdoção.add(pa);
        System.out.println("Pet para adoção cadastrado com sucesso!");
}

    public void listarPetsadocao(){
        if (petsAdoção.isEmpty()) {
            System.out.println("Nenhum pet disponível para adoção no momento.");
            return;
        }

        System.out.println("Pets disponíveis para adoção");
        for(int i = 0; i < petsAdoção.size(); i++) {
            PetAdocao pet = petsAdoção.get(i);
            System.out.println((i + 1) + ". " + petsAdoção.get(i).detalhes());
        }
    }

    public void adotarPet(String nome){
        for (int i = 0; i < petsAdoção.size(); i++) {
        PetAdocao pet = petsAdoção.get(i);
        if (pet.getNome().equalsIgnoreCase(nome)) {
            petsAdoção.remove(i);
            System.out.println("Você adotou o pet com sucesso!");
            System.out.println(pet.detalhes());
            return;
        }
    }

}
}