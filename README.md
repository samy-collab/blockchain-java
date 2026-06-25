# ChainNote — Mini Blockchain em Java

## Sobre o Projeto

O **ChainNote** é uma aplicação em Java que simula uma blockchain simplificada.
O sistema permite adicionar conteúdos em blocos, encadear esses blocos por meio de hashes, validar a integridade da cadeia e detectar adulterações.

O projeto foi desenvolvido com foco em:

* Encadeamento de blocos usando hash
* Validação da integridade da blockchain
* Persistência em arquivo JSON
* Aplicação dos princípios SOLID
* Testes automatizados

---

## Tecnologias Utilizadas

* Java 17
* Maven
* JUnit 5
* Gson
* SHA-256
* MD5
* JSON

---

## Funcionalidades

A aplicação possui um menu interativo no terminal com as seguintes opções:

* Adicionar nota de texto
* Adicionar imagem
* Adicionar transação
* Listar a blockchain
* Validar a blockchain
* Adulterar um bloco
* Salvar a blockchain em JSON
* Carregar a blockchain salva

---

## Como a Blockchain Funciona

Cada bloco possui um conteúdo, um hash próprio e o hash do bloco anterior.

Exemplo:

```text
Bloco 1
Conteúdo: Nota de texto
Hash anterior: 0
Hash atual: abc123

Bloco 2
Conteúdo: Transação
Hash anterior: abc123
Hash atual: def456
```

Se o conteúdo de um bloco for alterado, o hash dele muda.
Com isso, o próximo bloco deixa de apontar corretamente para ele, e a blockchain passa a ser considerada inválida.

Esse comportamento permite detectar adulterações na cadeia.

---

## Estrutura de Pastas

```text
blockchain-java/
├── pom.xml
├── README.md
├── blockchain.json
└── src/
    ├── main/
    │   └── java/
    │       └── chainnote/
    │           ├── Main.java
    │           ├── content/
    │           │   ├── Conteudo.java
    │           │   ├── NotaTexto.java
    │           │   ├── ImagemConteudo.java
    │           │   └── TransacaoConteudo.java
    │           ├── hash/
    │           │   ├── CalculadoraHash.java
    │           │   ├── SHA256Hash.java
    │           │   └── MD5Hash.java
    │           ├── model/
    │           │   ├── Bloco.java
    │           │   └── Blockchain.java
    │           ├── persistencia/
    │           │   ├── RepositorioCadeia.java
    │           │   ├── RepositorioEmMemoria.java
    │           │   └── RepositorioEmArquivoJson.java
    │           └── validacao/
    │               └── ValidadorBlockchain.java
    └── test/
        └── java/
            └── chainnote/
                └── BlockchainTest.java
```

---

## Explicação da Estrutura

### `Main.java`

Classe principal da aplicação.
Contém o menu interativo utilizado pelo usuário para adicionar conteúdos, listar blocos, validar a blockchain, salvar, carregar e adulterar blocos.

### `content/`

Pacote responsável pelos tipos de conteúdo que podem ser armazenados nos blocos.

* `Conteudo.java`: interface base para os conteúdos.
* `NotaTexto.java`: representa uma nota de texto.
* `ImagemConteudo.java`: representa um conteúdo de imagem.
* `TransacaoConteudo.java`: representa uma transação.

### `hash/`

Pacote responsável pelo cálculo de hashes.

* `CalculadoraHash.java`: interface para os algoritmos de hash.
* `SHA256Hash.java`: implementação usando SHA-256.
* `MD5Hash.java`: implementação usando MD5.

### `model/`

Pacote com as principais classes da blockchain.

* `Bloco.java`: representa um bloco da cadeia.
* `Blockchain.java`: controla a lista de blocos e o encadeamento entre eles.

### `persistencia/`

Pacote responsável por salvar e carregar a blockchain.

* `RepositorioCadeia.java`: interface de persistência.
* `RepositorioEmMemoria.java`: implementação em memória.
* `RepositorioEmArquivoJson.java`: implementação em arquivo JSON.

### `validacao/`

Pacote responsável pela validação da blockchain.

* `ValidadorBlockchain.java`: verifica se os hashes dos blocos continuam corretos e se a cadeia não foi adulterada.

### `test/`

Pasta que contém os testes automatizados do projeto.

* `BlockchainTest.java`: testa criação de blocos, encadeamento, validação e adulteração.

---

## Como Executar

### Clonar o repositório

```bash
git clone https://github.com/samy-collab/blockchain-java.git
```

### Entrar na pasta

```bash
cd blockchain-java
```

### Compilar o projeto

```bash
mvn compile
```

### Executar os testes

```bash
mvn test
```

### Executar a aplicação

```bash
mvn exec:java
```

---

## Menu da Aplicação

Ao executar o projeto, o seguinte menu é exibido:

```text
===== CHAINNOTE =====
1 - Adicionar nota de texto
2 - Adicionar imagem
3 - Adicionar transação
4 - Listar blockchain
5 - Validar blockchain
6 - Adulterar bloco
7 - Salvar blockchain
8 - Carregar blockchain
0 - Sair
```

---

## Aplicação dos Princípios SOLID

### SRP — Single Responsibility Principle

Cada classe possui uma responsabilidade bem definida.

Exemplos:

* `Bloco` representa os dados de um bloco.
* `Blockchain` controla a cadeia de blocos.
* `ValidadorBlockchain` valida a integridade da cadeia.
* `RepositorioEmArquivoJson` cuida da persistência em JSON.

---

### OCP — Open/Closed Principle

O projeto permite adicionar novos tipos de conteúdo ou novos algoritmos de hash sem alterar a lógica principal da blockchain.

Exemplos:

* Para criar um novo algoritmo de hash, basta implementar `CalculadoraHash`.
* Para criar um novo tipo de conteúdo, basta implementar `Conteudo`.

---

### LSP — Liskov Substitution Principle

As implementações podem substituir suas interfaces sem quebrar o funcionamento do sistema.

Exemplos:

* `SHA256Hash` e `MD5Hash` podem ser usados no lugar de `CalculadoraHash`.
* `NotaTexto`, `ImagemConteudo` e `TransacaoConteudo` podem ser usados no lugar de `Conteudo`.

---

### ISP — Interface Segregation Principle

As interfaces do projeto são pequenas e específicas.

Exemplos:

* `CalculadoraHash` trata apenas do cálculo de hash.
* `Conteudo` trata apenas da representação do conteúdo.
* `RepositorioCadeia` trata apenas da persistência.

Assim, nenhuma classe é obrigada a implementar métodos desnecessários.

---

### DIP — Dependency Inversion Principle

As classes principais dependem de abstrações, não de implementações concretas.

Exemplo:

```java
CalculadoraHash calculadoraHash = new SHA256Hash();
Blockchain blockchain = new Blockchain(calculadoraHash);
```

A classe `Blockchain` não depende diretamente de `SHA256Hash`, mas sim da interface `CalculadoraHash`.

Isso facilita a troca do algoritmo de hash e melhora a flexibilidade do projeto.

---

## Persistência em JSON

A blockchain pode ser salva em um arquivo JSON e carregada novamente depois.

Isso permite encerrar a aplicação e manter os blocos adicionados anteriormente.

Arquivo utilizado:

```text
blockchain.json
```

---

## Testes Automatizados

O projeto possui testes com JUnit.

Para executar:

```bash
mvn test
```

Os testes verificam:

* Criação da blockchain
* Adição de blocos
* Encadeamento dos hashes
* Validação de uma blockchain íntegra
* Detecção de adulteração

---

## Roteiro de Demonstração

Uma forma simples de demonstrar o projeto é:

1. Executar a aplicação.
2. Adicionar uma nota de texto.
3. Adicionar uma transação.
4. Listar a blockchain.
5. Validar a blockchain.
6. Salvar a blockchain.
7. Adulterar um bloco.
8. Validar novamente e verificar que a blockchain ficou inválida.

---

## Fora de Escopo

Este projeto não implementa recursos avançados de blockchains reais, como:

* Mineração
* Proof-of-work
* Rede P2P
* Criptomoedas reais
* Smart contracts
* Carteiras digitais
* Interface gráfica

O foco é demonstrar o funcionamento básico de uma blockchain e a aplicação dos princípios SOLID em Java.

---

## Conclusão

O **ChainNote** demonstra uma blockchain simplificada em Java, com encadeamento por hash, validação de integridade, persistência em JSON, testes automatizados e organização baseada nos princípios SOLID.

O projeto mostra de forma prática como alterações em blocos podem ser detectadas e como uma arquitetura simples pode ser organizada de maneira limpa e extensível.

