package src.br.edu.amepet.modelo.produto;

import java.util.List;
import java.util.Scanner;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import src.br.edu.amepet.gerenciador.GerenciadorPetShop;
import src.br.edu.amepet.modelo.pessoa.Cliente;

public class Produto {
    private String codigo;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, String categoria, double preco, int quantidadeEstoque) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setCategoria(categoria);
        this.setPreco(preco);
        this.setQuantidadeEstoque(quantidadeEstoque);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("O código do produto não pode ser vazio!");
        }
        this.codigo = codigo.trim();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio!");
        }
        this.nome = nome.trim();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("A categoria do produto não pode ser vazia!");
        }
        this.categoria = categoria.trim();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço deve ser maior do que zero!");
        }
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa!");
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean reduzirEstoque(int quantidade) {
        if (quantidade > 0 && this.quantidadeEstoque >= quantidade) {
            this.quantidadeEstoque -= quantidade;
            return true;
        }
        return false;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEstoque += quantidade;
        }
    }

    public String exibirInformacoes() {
        return String.format("Código: %s | Nome: %s | Categoria: %s | Preço: R$ %.2f | Estoque: %d",
                codigo, nome, categoria, preco, quantidadeEstoque);
    }

    public static class MenuProduto {
        private GerenciadorPetShop gerenciador;
        private Scanner scanner;

        public MenuProduto(GerenciadorPetShop gerenciador, Scanner scanner) {
            this.gerenciador = gerenciador;
            this.scanner = scanner;

            try {
                if (this.gerenciador.getProdutos().isEmpty()) {
                    adicionarProdutosExemplo(this.gerenciador);
                }
            } catch (Exception e) {
                System.err.println(
                        "Aviso: não foi possível adicionar produtos de exemplo automaticamente: " + e.getMessage());
            }
        }

        public void exibirMenu() {
            int opcao = -1;

            while (opcao != 0) {
                System.out.println("\n╔═════════════════════════════════════════════════════════╗");
                System.out.println("║                     MENU DE PRODUTOS                      ║");
                System.out.println("╠═══════════════════════════════════════════════════════════╣");
                System.out.println("║  1. Cadastrar Produto                                     ║");
                System.out.println("║  2. Listar Produtos                                       ║");
                System.out.println("║  3. Comprar produto                                       ║");
                System.out.println("║  4. Buscar produto por código                             ║");
                System.out.println("║  0. Voltar ao Menu Principal                              ║");
                System.out.println("╚═══════════════════════════════════════════════════════════╝");
                System.out.print("Escolha uma opção: ");

                try {
                    String linha = scanner.nextLine();
                    opcao = Integer.parseInt(linha.trim());
                } catch (Exception e) {
                    opcao = -1;
                }

                switch (opcao) {

                    case 1:
                        adicionarProduto();
                        break;

                    case 2:
                        listarProdutos();
                        break;

                    case 3:
                        comprarProduto();
                        break;

                    case 4:
                        buscarProdutoPorCodigo();
                        break;

                    case 0:
                        System.out.println("Retornando ao Menu Principal...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }

            }
        }

        private void adicionarProduto() {
            System.out.println("\n>>> CADASTRAR NOVO PRODUTO <<<");

            System.out.print("Código: ");
            String codigo = scanner.nextLine().trim();

            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            System.out.print("Categoria: ");
            String categoria = scanner.nextLine().trim();

            double preco = 0.0;
            while (true) {
                System.out.print("Preço: ");
                String precoStr = scanner.nextLine().trim();
                try {
                    preco = Double.parseDouble(precoStr.replace(",", "."));
                    if (preco < 0) {
                        System.out.println("Preço inválido. Deve ser maior ou igual a 0.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número para o preço (ex: 39.90).");
                }
            }

            int quantidade = 0;
            while (true) {
                System.out.print("Quantidade em estoque: ");
                String qtdStr = scanner.nextLine().trim();
                try {
                    quantidade = Integer.parseInt(qtdStr);
                    if (quantidade < 0) {
                        System.out.println("Quantidade não pode ser negativa.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número inteiro para a quantidade.");
                }
            }

            try {
                Produto produto = new Produto(codigo, nome, categoria, preco, quantidade);

                // Tenta adicionar via método público do gerenciador (se existir)
                boolean adicionado = tentarAdicionarViaMetodo(gerenciador, produto);

                // Se não conseguiu, usa reflection para acessar a lista interna 'produtos'
                if (!adicionado) {
                    adicionado = adicionarViaReflection(gerenciador, produto);
                }

                if (adicionado) {
                    System.out.println("Produto cadastrado com sucesso!");
                } else {
                    System.out.println("Erro: não foi possível cadastrar o produto no gerenciador.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar produto: " + e.getMessage());
            }
        }

        private void listarProdutos() {
            System.out.println("\n>>> LISTA DE PRODUTOS <<<");
            gerenciador.listarProdutos();
        }

        private void comprarProduto() {
            System.out.print("CPF do cliente: ");
            String cpf = scanner.nextLine().trim();

            Cliente cliente = gerenciador.buscarClientePorCpf(cpf);

            if (cliente == null) {
                System.out.println("Cliente não encontrado.");
                return;
            }

            // Obtém a cópia da lista de produtos do gerenciador
            List<Produto> lista = gerenciador.getProdutos();

            if (lista.isEmpty()) {
                System.out.println("Nenhum produto disponível no momento.");
                return;
            }

            System.out.println("\n>>> PRODUTOS DISPONÍVEIS <<<");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + ". " + lista.get(i).exibirInformacoes());
            }

            int escolhaIndex = -1;
            while (true) {
                System.out.print("\nEscolha o número do produto que deseja comprar: ");
                String escolhaStr = scanner.nextLine().trim();
                try {
                    escolhaIndex = Integer.parseInt(escolhaStr);
                    if (escolhaIndex < 1 || escolhaIndex > lista.size()) {
                        System.out.println("Escolha inválida. Digite um número entre 1 e " + lista.size() + ".");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite o número do produto.");
                }
            }

            Produto produtoSelecionado = lista.get(escolhaIndex - 1);
            String codigo = produtoSelecionado.getCodigo();

            int quantidade = 0;
            while (true) {
                System.out.print("Quantidade desejada: ");
                String qtdStr = scanner.nextLine().trim();
                try {
                    quantidade = Integer.parseInt(qtdStr);
                    if (quantidade <= 0) {
                        System.out.println("Digite uma quantidade positiva.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                }
            }

            boolean sucesso = gerenciador.venderProduto(cpf, codigo, quantidade);

            if (sucesso) {
                System.out.println("Compra realizada!");
            } else {
                System.out.println("Falha na compra. Verifique saldo ou estoque.");
            }
        }

        private void buscarProdutoPorCodigo() {
            System.out.print("Código do produto: ");
            String codigo = scanner.nextLine().trim();

            Produto p = gerenciador.buscarProdutoPorCodigo(codigo);

            if (p != null) {
                System.out.println("\n " + p.exibirInformacoes());
            } else {
                System.out.println("\nProduto não encontrado.");
            }
        }

        // ----------------------------------------------------------
        // Helpers para adicionar produtos ao Gerenciador (seguro)
        // ----------------------------------------------------------

        /**
         * Tenta invocar um método público adicionarProduto(Produto) no gerenciador.
         * Retorna true se conseguiu invocar e adicionar.
         */
        private boolean tentarAdicionarViaMetodo(GerenciadorPetShop ger, Produto produto) {
            try {
                Method m = ger.getClass().getMethod("adicionarProduto", Produto.class);
                if (m != null) {
                    m.invoke(ger, produto);
                    return true;
                }
            } catch (NoSuchMethodException nsme) {
            } catch (Exception e) {
                System.err.println("Erro ao tentar adicionar produto via método: " + e.getMessage());
            }
            return false;
        }

        // Usa reflection para acessar o campo privado 'produtos' do GerenciadorPetShop
        // e
        // adicionar o produto diretamente na lista interna.
        // Retorna true se adicionou com sucesso.
        private boolean adicionarViaReflection(GerenciadorPetShop ger, Produto produto) {
            try {
                Field f = null;
                Class<?> cls = ger.getClass();

                // Tenta achar campo 'produtos' na classe ou em superclasses
                while (cls != null) {
                    try {
                        f = cls.getDeclaredField("produtos");
                        break;
                    } catch (NoSuchFieldException e) {
                        cls = cls.getSuperclass();
                    }
                }

                if (f == null) {
                    System.err.println("Campo 'produtos' não encontrado via reflection.");
                    return false;
                }

                f.setAccessible(true);
                Object value = f.get(ger);
                if (value instanceof List) {
                    List<Produto> listaInterna = (List<Produto>) value;
                    listaInterna.add(produto);
                    return true;
                } else {
                    System.err.println("Campo 'produtos' não é uma List.");
                    return false;
                }
            } catch (Exception e) {
                System.err.println("Erro ao adicionar produto via reflection: " + e.getMessage());
                return false;
            }
        }

        // Adiciona um conjunto de produtos de exemplo ao gerenciador. Usa as mesmas
        // rotinas seguras de adição (método/reflection).

        private void adicionarProdutosExemplo(GerenciadorPetShop ger) {
            Produto[] exemplos = new Produto[] {
                    new Produto("PRD001", "Ração Premium Cães", "Ração", 120.0, 50),
                    new Produto("PRD002", "Ração Premium Gatos", "Ração", 95.0, 30),
                    new Produto("PRD003", "Antipulgas", "Medicamento", 45.0, 20),
                    new Produto("PRD004", "Vermífugo", "Medicamento", 30.0, 25),
                    new Produto("PRD005", "Mordedor", "Brinquedo", 25.0, 50),
                    new Produto("PRD006", "Coleira", "Acessório", 35.0, 15),
                    new Produto("PRD007", "Shampoo Pelos Longos", "Higiene", 38.0, 35),
                    new Produto("PRD008", "Petiscos Naturais", "Alimentação", 22.0, 60)
            };

            for (Produto p : exemplos) {
                boolean added = tentarAdicionarViaMetodo(ger, p);
                if (!added) {
                    adicionarViaReflection(ger, p);
                }
            }
        }
    }
}
