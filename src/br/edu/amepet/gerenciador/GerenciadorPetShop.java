package br.edu.amepet.gerenciador;

import br.edu.amepet.modelo.atendimento.*;
import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pessoa.Funcionario;
import br.edu.amepet.modelo.pessoa.Pessoa;
import br.edu.amepet.modelo.pet.Pet;
import br.edu.amepet.modelo.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPetShop {

    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();

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

    public void registrarBanho(String cpf, String nomePet) {
        Cliente c = buscarClientePorCpf(cpf);
        Pet p = buscarPetPorNome(nomePet);

        registrarAtendimento(new Banho(c, p));
    }

    public void registrarTosa(String cpf, String nomePet) {
        Cliente c = buscarClientePorCpf(cpf);
        Pet p = buscarPetPorNome(nomePet);

        registrarAtendimento(new Tosa(c, p));
    }

    public void registrarExame(String cpf, String nomePet) {
        Cliente c = buscarClientePorCpf(cpf);
        Pet p = buscarPetPorNome(nomePet);

        registrarAtendimento(new Exame(c, p));
    }

    public void registrarConsulta(String cpf, String nomePet) {
        Cliente c = buscarClientePorCpf(cpf);
        Pet p = buscarPetPorNome(nomePet);

        registrarAtendimento(new Consulta(c, p));
    }

    public void registrarVacina(String cpf, String nomePet) {
        Cliente c = buscarClientePorCpf(cpf);
        Pet p = buscarPetPorNome(nomePet);

        registrarAtendimento(new Vacina(c, p));
    }

    public void registrarCirurgia(String cpf, String nomePet) {
        Cliente c = buscarClientePorCpf(cpf);
        Pet p = buscarPetPorNome(nomePet);

        registrarAtendimento(new Cirurgia(c, p));
    }

    public void registrarInternacao(String cpf, String nomePet) {
        Cliente c = buscarClientePorCpf(cpf);
        Pet p = buscarPetPorNome(nomePet);

        registrarAtendimento(new Internacao(c, p));
    }

    // ============================================================
    //                      HISTÓRICO
    // ============================================================

    public void mostrarHistoricoServicos(String cpf, String nomePet) {
        for (Atendimento a : atendimentos) {
            if (a.getCliente().getCpf().equals(cpf)
                    && a.getPet().getNome().equalsIgnoreCase(nomePet)) {
                System.out.println(a.exibirInformacoes());
            }
        }
    }

    public void mostrarHistoricoMedico(String cpf, String nomePet) {
        for (Atendimento a : atendimentos) {
            if (a instanceof AtendimentoMedico) {
                if (a.getCliente().getCpf().equals(cpf)
                        && a.getPet().getNome().equalsIgnoreCase(nomePet)) {
                    System.out.println(a.exibirInformacoes());
                }
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
        // caso você queira armazenar vendas futuramente
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
}
