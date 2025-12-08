# 🐾 Projeto Ame-Pet - Sistema de Gerenciamento de PetShop

## 👥 Integrantes do Projeto

- Alexsandro Rocha dos Santos - 2024010299
- Antonio Andson de Oliveira Rocha - 2024010349
- Ikaro Ferreira Brito - 2024010233
- Levi Filgueira Chagas - 2022022050
- Lucas Vieres Araujo Farias - 2025022531
- Paulo Gabriel Vieira de Souza Paiva - 2024010420
- Sophia Hellen Pires da Silveira - 2024010321

---

## 📋 Descrição do Projeto

O **Ame-Pet** é um sistema completo de gerenciamento para petshops e clínicas veterinárias, desenvolvido em **Java** com arquitetura **orientada a objetos**. O projeto foi desenvolvido para a discilipna de **Programação Orientada a Objetos** na **UFERSA**. O sistema integra todas as funcionalidades essenciais para um estabelecimento de cuidados com animais, permitindo:

- Gerenciamento de funcionários e clientes
- Cadastro e controle de pets
- Oferecimento de serviços veterinários e gerais
- Operação de loja online com produtos para animais
- Sistema de adoção e venda de pets
- Relatórios detalhados e buscas avançadas

---

## 🎯 Principais Funcionalidades

### 1️⃣ **Gestão de Pessoas**
- **Funcionários**: Cadastro de funcionários com cargo, salário e data de admissão
- **Clientes**: Registro de clientes com nome, CPF, telefone e endereço
- **Autenticação**: Sistema de login com usuário e senha para funcionários

### 2️⃣ **Gerenciamento de Pets**
- Cadastro de animais associados a clientes específicos
- Registro de espécie, raça, idade e peso do pet
- Listagem de pets disponíveis para compra e adoção
- Rastreamento do proprietário através do CPF

### 3️⃣ **Serviços Veterinários e Gerais**
- **Serviços Básicos**: Banho e Tosa
- **Serviços Clínicos**: Consultas médicas, exames e vacinação
- **Serviços Avançados**: Internações e cirurgias
- Registro de atendimentos com data, cliente, pet e preço

### 4️⃣ **Loja de Produtos**
- Catálogo de produtos para animais (rações, brinquedos, acessórios)
- Controle de estoque
- Sistema de preços com desconto/taxas
- Múltiplas formas de pagamento (Dinheiro, Pix, Cartão de Crédito, Cartão de Débito)

### 5️⃣ **Adoção e Venda de Pets**
- Formulários de compra/adoção com validação de informações
- Sistema de pagamento com cálculo de descontos e taxas automáticas
- Emissão de recibos
- Histórico completo de transações

### 6️⃣ **Relatórios e Buscas**
- Relatórios de vendas e serviços realizados
- Histórico de clientes e pets
- Histórico de compras e adoções
- Busca avançada por cliente, pet ou serviço

---

## 🏗️ Arquitetura do Projeto

### Estrutura de Diretórios

```
Ame-Pet/
├── src/br/edu/amepet/
│   ├── Main.java                          # Ponto de entrada da aplicação
│   ├── gerenciador/
│   │   └── GerenciadorPetShop.java       # Classe principal de negócio
│   ├── menu/
│   │   ├── MenuFuncionario.java          # Menu de cadastro de funcionários
│   │   ├── MenuLogin.java                # Menu de autenticação
│   │   ├── MenuCliente.java              # Menu de clientes
│   │   ├── MenuServicos.java             # Menu de serviços
│   │   ├── MenuLoja.java                 # Menu da loja
│   │   ├── MenuCompraAdocao.java         # Menu de compra/adoção de pets
│   │   ├── MenuHistorico.java            # Menu de histórico
│   │   ├── MenuRelatorios.java           # Menu de relatórios
│   │   ├── MenuBuscar.java               # Menu de buscas
│   │   └── CancelarAcao.java             # Utilitários de entrada
│   └── modelo/
│       ├── pessoa/
│       │   ├── Pessoa.java               # Classe abstrata base
│       │   ├── Cliente.java              # Subclasse Cliente
│       │   └── Funcionario.java          # Subclasse Funcionário
│       ├── pet/
│       │   ├── Pet.java                  # Classe base de pets
│       │   ├── PetAdocao.java            # Pets para adoção
│       │   └── PetsVenda.java            # Pets à venda
│       ├── atendimento/
│       │   ├── Atendimento.java          # Classe abstrata
│       │   ├── Consulta.java
│       │   ├── Exame.java
│       │   ├── Vacina.java
│       │   ├── Banho.java
│       │   ├── Tosa.java
│       │   ├── Cirurgia.java
│       │   └── Internacao.java
│       ├── produto/
│       │   └── Produto.java              # Classe de produtos
│       ├── pagamento/
│       │   ├── FormaDePagamento.java     # Interface
│       │   ├── CartaoCredito.java
│       │   ├── CartaoDebito.java
│       │   ├── Dinheiro.java
│       │   └── Pix.java
│       ├── venda/
│       │   ├── Venda.java                # Registro de vendas
│       │   └── Transacao.java            # Registro de transações
│       └── ...
└── README.md
```

---

## 💡 Conceitos de POO Implementados

### 1. **Encapsulamento**
- Atributos privados com getters e setters
- Validação de dados nos setters
- Métodos abstratos para garantir implementação em subclasses

### 2. **Herança**
- Classe abstrata `Pessoa` com subclasses `Cliente` e `Funcionario`
- Classe abstrata `Atendimento` com múltiplas subclasses (Consulta, Exame, Cirurgia, etc.)
- Classe abstrata `FormaDePagamento` com implementações concretas

### 3. **Polimorfismo**
- Método `exibirDetalhes()` implementado diferentemente em Cliente e Funcionario
- Método `exibirInformacoes()` implementado em diferentes tipos de Atendimento
- Método `processar()` implementado em diferentes formas de pagamento

### 4. **Abstração**
- Classes abstratas definem contratos que subclasses devem seguir
- Interfaces para múltiplas formas de pagamento
- Métodos abstratos forçam implementação em subclasses

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **Java Development Kit (JDK) 21** ou superior
- **Git** para clonar o repositório
- **VS Code** (opcional) com extensão Java

### 1. Clonar o Repositório

```powershell
git clone https://github.com/gabrdsp/Ame-Pet.git
cd Ame-Pet
```

### 2. Compilar o Projeto

#### Usando VS Code:
1. Abra a pasta do projeto em VS Code
2. A extensão Java detectará o projeto automaticamente
3. Clique em "Run" → "Run Without Debugging" ou use o atalho `Ctrl+F5`

#### Usando Terminal (PowerShell):
```powershell
cd src
javac -d ../bin br/edu/amepet/Main.java br/edu/amepet/**/*.java
```

### 3. Executar a Aplicação

#### Usando VS Code:
- Clique no botão "Run" (Play) ou pressione `F5`

#### Usando Terminal (PowerShell):
```powershell
java -cp bin br.edu.amepet.Main
```

---

## 📖 Guia de Uso

### Menu Principal
Ao executar a aplicação, você verá o menu principal com as seguintes opções:

```
╔════════════════════════════════════════════════╗
║            AME PET - MENU PRINCIPAL            ║
╠════════════════════════════════════════════════╣
║ 1. Cadastrar Funcionáro                        ║
║ 2. Login (Funcionário)                         ║
║ 3. Cliente                                     ║
║ 4. Loja                                        ║
║ 5. Relatórios                                  ║
║ 6. Buscar                                      ║
║ 0. Sair                                        ║
╚════════════════════════════════════════════════╝
```

### Credenciais Padrão para Teste
Para acessar as funcionalidades do sistema, use as seguintes credenciais padrão:

- **Usuário**: `admin`
- **Senha**: `1234`

### Fluxos Principais

#### 🔐 **Fluxo de Login**
1. Selecione opção `2` no menu principal
2. Digite o usuário (`admin`)
3. Digite a senha (`1234`)
4. Agora você terá acesso a todas as funcionalidades

#### 👤 **Cadastrar Cliente**
1. Faça login com as credenciais padrão
2. Selecione opção `3` (Cliente)
3. Selecione `1` (Cadastro de Cliente)
4. Preencha os dados:
   - Nome
   - CPF (apenas números)
   - Telefone (apenas números)
   - Endereço
5. Digite `*` para cancelar a operação a qualquer momento

#### 🐕 **Cadastrar Pet**
1. Faça login primeiro
2. Vá para menu Cliente → Cadastro de Pet
3. Preencha os dados do pet:
   - Nome do pet
   - Espécie (Cão, Gato, etc.)
   - Raça
   - Idade
   - Peso (em kg)
   - CPF do proprietário

#### 💇 **Contratar Serviços**
1. Faça login
2. Vá para Cliente → Serviços do Petshop
3. Escolha o tipo de serviço:
   - Banho e Tosa
   - Consulta Médica
   - Exame
   - Vacinação
   - Internação
   - Cirurgia
4. Selecione o cliente e pet
5. Confirme a data e valor

#### 🛒 **Comprar na Loja**
1. Faça login
2. Selecione opção `4` (Loja)
3. Escolha produtos disponíveis
4. Finalize a compra selecionando a forma de pagamento

#### 📊 **Gerar Relatórios**
1. Faça login
2. Selecione opção `5` (Relatórios)
3. Escolha o tipo de relatório desejado:
   - Relatório de Vendas
   - Histórico de Serviços
   - Estatísticas de Clientes

#### 🔍 **Realizar Buscas**
1. Faça login
2. Selecione opção `6` (Buscar)
3. Digite os critérios de busca:
   - Buscar Cliente por CPF ou Nome
   - Buscar Pet por Nome
   - Buscar Histórico de Compras

---

## 🔧 Funcionalidades Técnicas

### Sistema de Validação
- Validação de entrada de dados com feedback em tempo real
- Tratamento de exceções para CPF, telefone e campos obrigatórios
- Cancelamento de operações com comando especial `*`

### Sistema de Pagamento
- Suporte a múltiplas formas de pagamento
- Cálculo automático de taxa para cartão de crédito
- Desconto automático para Pix
- Recibo detalhado após cada transação

### Gerenciamento de Dados
- Armazenamento em memória durante a execução
- Lista dinâmica para todos os objetos
- IDs únicos para transações
- Rastreamento de histórico de serviços

### Interface de Usuário
- Menus estruturados com bordas ASCII
- Mensagens de confirmação e erro
- Formatação de valores monetários
- Exibição de dados em tabelas formatadas

---

## 📝 Exemplos de Uso

### Exemplo 1: Cadastrar um Cliente
```
Escolha uma opção: 3
Escolha uma opção: 1
Nome: João Silva
CPF: 12345678901
Telefone: 84987654321
Endereço: Rua das Flores, 123

Cliente cadastrado com sucesso!
```

### Exemplo 2: Contratar Serviço de Banho
```
Escolha uma opção: 3
Escolha uma opção: 3
[Sistema exibe lista de serviços]
Escolha o serviço: 1 (Banho)
CPF do cliente: 12345678901
Nome do pet: Fluffy
Data do serviço: 10/12/2024

Serviço agendado com sucesso!
Valor: R$ 80.00
```

### Exemplo 3: Comprar Produto
```
Escolha uma opção: 4
[Sistema exibe produtos disponíveis]
Código do produto: P001
Quantidade: 2
Forma de pagamento: 1 (Dinheiro)

Compra realizada com sucesso!
Valor total: R$ 150.00
```

---

## 🐛 Possíveis Problemas e Soluções

### Problema: "Unresolved compilation problem"
**Solução**: Certifique-se de que todos os arquivos `.java` foram compilados corretamente. Recompile o projeto.

### Problema: "Scanner não encontrado"
**Solução**: Verifique se a extensão Java está instalada no VS Code.

### Problema: "Erro ao cadastrar cliente"
**Solução**: Verifique se o CPF está no formato correto (apenas números).

---

## 🎓 Conceitos Aplicados

1. **Programação Orientada a Objetos (POO)**
   - Classes abstratas e concretas
   - Herança de classes
   - Polimorfismo de métodos
   - Encapsulamento de dados

2. **Padrões de Design**
   - Pattern Factory para criar atendimentos
   - Pattern Strategy para formas de pagamento
   - Pattern Observer para notificações

3. **Estruturas de Dados**
   - ArrayList para armazenar dados
   - Uso eficiente de Strings
   - Conversão entre tipos de dados

4. **Boas Práticas de Programação**
   - Nomes significativos de variáveis
   - Métodos com responsabilidade única
   - Tratamento de exceções
   - Validação de entrada

---

## 📚 Referências

- **Java Documentation**: https://docs.oracle.com/javase/21/docs/api/
- **POO em Java**: https://www.oracle.com/java/
- **Padrões de Design**: https://refactoring.guru/design-patterns

---

## 📄 Licença

Este projeto foi desenvolvido como atividade acadêmica e está disponível para fins educacionais.

---

## 💬 Suporte

Para dúvidas ou problemas, abra uma issue no repositório do GitHub:
[Ame-Pet Issues](https://github.com/gabrdsp/Ame-Pet/issues)

---

**Desenvolvido com ❤️ pela equipe Ame-Pet** 🐾
Espere alguns momentos enquanto o projeto é adicionado ao seu computador, depois procure pela File Main.java e execute ela.
