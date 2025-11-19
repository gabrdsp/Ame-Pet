package br.edu.amepet.gerenciador;

import br.edu.amepet.modelo.atendimento.Atendimento;
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

    public void adicionarPessoa(Pessoa p) {
        if (p != null) pessoas.add(p);
    }

    public void adicionarPet(Pet p) {
        if (p != null) pets.add(p);
    }

    public void adicionarProduto(Produto p) {
        if (p != null) produtos.add(p);
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }

    public boolean venderProduto(String cpfCliente, String codigoProduto, int quantidade) {
        Produto produto = buscarProdutoPorCodigo(codigoProduto);
        if (produto == null) return false;

        Cliente cliente = buscarClientePorCpf(cpfCliente);
        if (cliente == null) return false;

        double total = produto.getPreco() * quantidade;

        // tenta reduzir estoque
        if (!produto.reduzirEstoque(quantidade)) return false;

        // tenta debitar do cliente; se não conseguir, restaura estoque
        if (!cliente.debitarCredito(total)) {
            produto.adicionarEstoque(quantidade);
            return false;
        }

        return true;
    }

    public Produto buscarProdutoPorCodigo(String codigo) {
        if (codigo == null) return null;
        for (Produto p : produtos) {
            if (codigo.equals(p.getCodigo())) return p;
        }
        return null;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        if (cpf == null) return null;
        for (Pessoa p : pessoas) {
            if (p instanceof Cliente) {
                Cliente c = (Cliente) p;
                if (cpf.equals(c.getCpf())) return c;
            }
        }
        return null;
    }

    public Pessoa buscarPessoaPorCpf(String cpf) {
        if (cpf == null) return null;
        for (Pessoa p : pessoas) {
            if (cpf.equals(p.getCpf())) return p;
        }
        return null;
    }

    public List<Pet> buscarPetsPorDono(String cpfDono) {
        List<Pet> res = new ArrayList<>();
        if (cpfDono == null) return res;
        for (Pet pet : pets) {
            if (cpfDono.equals(pet.getCpfDono())) res.add(pet);
        }
        return res;
    }

    public void adicionarAtendimento(Atendimento a) {
        if (a != null) {
            atendimentos.add(a);
            if (a.getCliente() instanceof Cliente) {
                ((Cliente) a.getCliente()).incrementarServicosContratados();
            }
        }
    }

    // Métodos de listagem (simples) — imprimem no console
    public void listarTodasPessoas() {
        System.out.println("\n>>> LISTA DE PESSOAS <<<");
        for (Pessoa p : pessoas) {
            System.out.println(p.exibirDetalhes());
        }
    }

    public void listarClientes() {
        System.out.println("\n>>> CLIENTES <<<");
        for (Pessoa p : pessoas) if (p instanceof Cliente) System.out.println(p.exibirDetalhes());
    }

    public void listarFuncionarios() {
        System.out.println("\n>>> FUNCIONÁRIOS <<<");
        for (Pessoa p : pessoas) if (p instanceof Funcionario) System.out.println(p.exibirDetalhes());
    }

    public void listarPets() {
        System.out.println("\n>>> PETS <<<");
        for (Pet pet : pets) System.out.println(pet.exibirInformacoes());
    }

    public void listarProdutos() {
        System.out.println("\n>>> PRODUTOS <<<");
        for (Produto p : produtos) System.out.println(p.exibirInformacoes());
    }

    public void listarAtendimentos() {
        System.out.println("\n>>> ATENDIMENTOS <<<");
        for (Atendimento a : atendimentos) System.out.println(a.exibirInformacoes());
    }

    public Cliente login(String usuario, String senha) {
        for (Pessoa p : pessoas) {
            if (p instanceof Cliente f) {
                if (f.getUsuario().equals(usuario) && f.getSenha().equals(senha)) {
                    return f; // login OK
                }
            }
        }
        return null; // login falhou
    }

    public Funcionario loginFuncionario(String usuario, String senha) {
        for (Pessoa p : pessoas) {
            if (p instanceof Funcionario f) {
                if (f.getUsuarioFuncionario().equals(usuario) && f.getSenhaFuncionario().equals(senha)) {
                    return f; // login OK
                }
            }
        }
        return null; // login falhou
    }
}