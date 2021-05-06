# Projeto 3 - Simulação de um servidor de Proxy

Neste projeto você irá encontrar a implementação de:

1. Simulação de um servidor Proxy
2. Testes na simulação de um servidor Proxy

As quais estão presentes nas classes ProxyServerSimulation e ProxyServerSimulationTests respectivamente no package com.proxyserver.proxyserver

Para a elaboração deste projeto, foi utilizado o Apache Maven e também o Spring Boot Framework, acesse [Tutorial maven](https://www.devmedia.com.br/introducao-ao-maven/25128) para mais informações, que torna o processo de compilação, gerenciamento do projeto, execução e validação muito mais simples, se você não utilizar o maven, pode seguir os passos abaixo

## Baixar os jars das dependências presentes no pom 

Acesse [mvnrepository](https://mvnrepository.com/) para baixar os jars

## Compilando os arquivos .java

Em Java a compilação também existe, só que não é gerado um arquivo contendo código em linguagem de máquina. É gerado uma forma intermediária entre o código de máquina e a linguagem de programação Java, chamado de Bytecode.
Os Bytecodes não são executados diretamente pelo sistema operacional, e sim interpretados por uma máquina virtual, a JVM (Java Virtual Machine). O arquivo .class pode ser interpretado em qualquer versão do Windows, Mac, Linux e Unix em geral, desde que se tenha uma JVM específica para aquela plataforma instalada.
Após a compilação, o segundo passo é o carregador de classes ler os arquivos .class que contém bytecodes a partir do disco rígido e colocar esses bytecodes na memória; após o carregamento, a próxima etapa é de verificação: o verificador de bytecode confirma que todos os bytecodes  são válidos e não  violam as restrições  de segurança do Java; por último, para executar  o programa, a JVM lê os bytecodes  e os compila (isto é, traduz) no momento certo (ou Just-in-Time) para uma linguagem que o computador possa entender. Fonte: [Compilando e Executando um Arquivo Java pela Linha de Comando](https://autociencia.blogspot.com/2016/09/compilando-e-executando-um-arquivo-java.html). Agora vamos ao passo a passo:

1. abrir o prompt de Comando(cmd);
1. `cd Desktop` , para acessar o diretório do desktop;
1. `java -version`, para saber a versão do Java instalado;
1. `dir`, lista todos os arquivos e pastas do diretório atual;
1. Identificando que o arquivo ProxyServerSimulation.java está presente no seu diretório atual, execute o próximo comando;
1. `javac -cp . ProxyServerSimulation.java`, o argumento `-cp` (classpath) destina em qual diretório a classe deverá ser armazenada. Nesse caso -cp aponta para o "." que é o diretório atual. Se nenhum diretório for especificado, com a omissão do argumento, então é armazenado no diretório atual.

Esses comandos são para windows, mas você pode ler em [Compilando e Executando um Arquivo Java pela Linha de Comando](https://autociencia.blogspot.com/2016/09/compilando-e-executando-um-arquivo-java.html) sobre os comandos no Linux e no Mac.

Os mesmos passos devem ser seguidos para compilar a classe ProxyServerSimulationTests, porém o comando 6 deve ser executado um pouco diferente: `javac -cp junit-4.12.jar;`. ProxyServerSimulationTests.java


## Executar os testes do JUnit Test

1. `java -cp junit-4.12.jar;jasperreports-6.4.0.jar;. org.junit.runner.JUnitCore ProxyServerSimulationTests`


## O que irei obter com a execução dos testes?

Como vimos a classe ProxyServerSimulationTests, é responsável por executar testes para simular um servidor proxy.

###Simulação de um servidor Proxy

O projeto é a implementação de uma simulação de um servidor Proxy para serviço de cache de internet. Um servidor proxy é normalmente utilizado para conectar a origem e o destino de uma requisição. O serviço de cache serve para evitar requisições desnecessárias. Quando a requisição é feita ela é enviada para o cache e lá é procurada em sua coleção local e caso encontre é devolvida a cópia, caso não encontre é feita a requisição e armazenada uma cópia na coleção local.
	O projeto simula isso de uma maneira simplificada, as requisições têm a estrutura “<tempo da requisição> <nome do recurso solicitado> <quantidade de bytes>” e estão em um arquivo do tipo txt, com essa base de dados é criado um dicionário que armazena o nome do recurso e o tempo da requisição mais recente, também é armazenado o tamanho final do cache e a quantidade de bytes que foram economizados em requisições.

```
    @Test
    public void Simulation() {
        String cacheDocumentName = "wikipedia.txt";
        HashMap<String, Long> results = proxyServerSimulation.dictionary(cacheDocumentName);

        System.out.println("tamanho final do cache: " + results.get("tamanho final do cache"));
        System.out.println("quantidade de bytes economizados em requisições: "
                + results.get("quantidade de bytes economizados em requisições"));
    }
```
A execução do teste resulta na saída:

tamanho final do cache: 7420112651
quantidade de bytes economizados em requisições: 332818743628

No teste:
```
    @Test
    public void primaryTest() {
        String cacheDocumentName = "teste.txt";
        HashMap<String, Long> results = proxyServerSimulation.dictionary(cacheDocumentName);

        assertEquals(results.get("tamanho final do cache"), 216724L);
        assertEquals(results.get("quantidade de bytes economizados em requisições"), 506714L);

    }
```

É igual ao teste anterior, mas com um documento txt de tamanho reduzido.
