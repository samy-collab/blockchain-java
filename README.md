# ChainNote - Blockchain em Java

Projeto acadêmico desenvolvido em Java puro com Maven, simulando uma blockchain simples capaz de armazenar diferentes tipos de conteúdo, calcular hashes, validar a integridade da cadeia e salvar/carregar os blocos em arquivo JSON.

## Objetivo

O objetivo do projeto é demonstrar, de forma didática, os principais conceitos de uma blockchain:

- Criação de blocos encadeados;
- Uso de hash atual e hash anterior;
- Validação da integridade da cadeia;
- Detecção de adulteração em blocos;
- Persistência dos dados em arquivo JSON;
- Organização do código utilizando interfaces e separação de responsabilidades.

## Tecnologias utilizadas

- Java 17
- Maven
- Gson
- JUnit 5

## Funcionalidades

O sistema possui um menu via terminal com as seguintes opções:

1. Adicionar nota de texto
2. Adicionar imagem
3. Adicionar transação
4. Listar blockchain
5. Validar blockchain
6. Adulterar bloco
7. Salvar blockchain
8. Carregar blockchain
0. Sair

## Estrutura de pastas

```txt
blockchain-java/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── chainnote/
│   │           │
│   │           ├── Main.java
│   │           │
│   │           ├── content/
│   │           │   ├── Conteudo.java
│   │           │   ├── NotaTexto.java
│   │           │   ├── ImagemConteudo.java
│   │           │   └── TransacaoConteudo.java
│   │           │
│   │           ├── hash/
│   │           │   ├── CalculadoraHash.java
│   │           │   ├── SHA256Hash.java
│   │           │   └── MD5Hash.java
│   │           │
│   │           ├── model/
│   │           │   ├── Bloco.java
│   │           │   └── Blockchain.java
│   │           │
│   │           ├── persistencia/
│   │           │   ├── RepositorioCadeia.java
│   │           │   ├── RepositorioEmArquivoJson.java
│   │           │   └── RepositorioEmMemoria.java
│   │           │
│   │           └── validacao/
│   │               └── ValidadorCadeia.java
│   │
│   └── test/
│       └── java/
│           └── chainnote/
│               └── BlockchainTest.java
│
├── pom.xml
├── .gitignore
└── README.md
