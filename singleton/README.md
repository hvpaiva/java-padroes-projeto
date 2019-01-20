---
layout: pattern
title: Singleton
folder: singleton
permalink: /patterns/singleton/
categories: Creational
tags:
 - Java
 - Gang Of Four
 - Difficulty-Beginner
---

## Intenção
Garantir que uma classe tenha somente uma instância e fornecer um ponto global de acesso para a mesma.

## Explicação
Exemplo real

> Em um concurso de culinária, só pode existir um vencedor. Logo, a classe Vencedor será um singleton.

Em palavras simples

> Garantir que apenas um objeto de determinada classe seja criada.

Wikipedia diz

> Este padrão garante a existência de apenas uma instância de uma classe, mantendo um ponto global de acesso ao seu objeto.

**Examplo implementado**

Existem muitas maneiras de implementar o Singleton. A primeira é a `eagerly initialized singleton`. Esta implementação é thread-safe. Se você puder deixar de dar o controle do momento da instanciação, então esta implementação será adequada para você.

Exemplo: 

```java
final class Vencedor {
	
	/**
	* Construtor privado para evitar instanciação.
    */
	private Vencedor() { }
	
	/**
	* Instancia estática da classe. 
    */
	private static final Vencedor INSTANCE = new Vencedor();
	
	/**
    * @return A instância da classe.
    */
	public static Vencedor getInstance() {
		return INSTANCE;
	}
}

```

A outra opção para implementar o `eagerly initialized singleton` é o singleton baseado em enum. À primeira vista, o código parece curto e simples. No entanto, você deve estar ciente das desvantagens, incluindo o comprometimento com a estratégia de implementação, estendendo a classe enum, serializability e restrições à codificação. 

> Eles são amplamente discutidos no [Stack Overflow](http://programmers.stackexchange.com/questions/179386/what-are-the-downsides-of-implementing-a-singleton-with-javas-enum) 

Exemplo: 

```java
public enum EnumVencedor {

  INSTANCE;

  @Override
  public String toString() {
    return getDeclaringClass().getCanonicalName() + "@" + hashCode();
  }
}
```


`ThreadSafeLazyLoadedVencedor` é uma Implementação Singleton que é inicializada sob demanda. A desvantagem é que é muito lento para acessar, pois todo o método de acesso é sincronizado.

```java
public final class ThreadSafeLazyLoadedVencedor {

  private static ThreadSafeLazyLoadedVencedor instance;

  private ThreadSafeLazyLoadedVencedor() {
    // proteção contra instanciação via reflection
    if (instance == null) {
      instance = this;
    } else {
      throw new IllegalStateException("Já inicializado.");
    }
  }

  /**
   * A instância será criada apenas quando chamada pela primeira vez. Lazy-loading.
   * 
   * @return A instância
   */
  public static synchronized ThreadSafeLazyLoadedVencedor getInstance() {
    if (instance == null) {
      instance = new ThreadSafeLazyLoadedVencedor();
    }

    return instance;
  }
}
```

Outra implementação Singleton que é inicializada sob demanda é `ThreadSafeDoubleCheckLocking`. Ele é um pouco mais rápido do que `ThreadSafeLazyLoadedVencedor`, pois não sincroniza o método de acesso inteiro, mas apenas o método interno em condições específicas.

```java
public final class ThreadSafeDoubleCheckLocking {

  private static volatile ThreadSafeDoubleCheckLocking instance;

  /**
   * Construtor privado para prevenir instanciação.
   */
  private ThreadSafeDoubleCheckLocking() {
    // proteção contra instanciação via reflection
    if (instance != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /**
   * Acessor publico.
   *
   * @return a instância da classe
   */
  public static ThreadSafeDoubleCheckLocking getInstance() {
    // Vairaveis locais aumentam a performance em 25 porcento
    // Joshua Bloch "Effective Java, Second Edition", p. 283-284
    ThreadSafeDoubleCheckLocking result = instance;
    
    // Checa se a instância singleton foi inicializada. 
    // Se estiver inicializada, então podemos retornar a instância
    if (result == null) {
      // Não é inicializado, mas não podemos ter certeza porque alguma 
      // outra thread pode ter inicializado no mesmo período. 
      // Então, para garantir, precisamos bloquear um objeto para 
      // obter exclusão mútua.
      synchronized (ThreadSafeDoubleCheckLocking.class) {
        // Novamente, atribua a instância à variável local para verificar se 
        // ela foi inicializada por alguma outra Thread enquanto a Thread
        // atual foi bloqueado para entrar na zona bloqueada. Se ele foi
        // inicializado, podemos retornar a instância criada anteriormente, 
        // assim como na verificação de nula anterior.
        result = instance;
        if (result == null) {
          // A instância ainda não foi inicializada, assim podemos
          // com segurança (nenhuma outra thread pode entrar nessa zona) 
          // criar uma instância e torná-la nossa instância singleton.
          instance = result = new ThreadSafeDoubleCheckLocking();
        }
      }
    }
    return result;
  }
}

```

Outra maneira de implementar o Singleton inicializado com segurança por thread pode ser encontrada em `InitializingOnDemandHolderIdiom`. No entanto, essa implementação requer pelo menos o Java 8 para funcionar.

```java
public final class InitializingOnDemandHolderIdiom {

  /**
   * Construtor privado para evitar instanciação.
   */
  private InitializingOnDemandHolderIdiom() {}

  /**
   * @return A instÂncia Singleton
   */
  public static InitializingOnDemandHolderIdiom getInstance() {
    return HelperHolder.INSTANCE;
  }

  /**
   * Provém a instância Singleton lazy-loaded.
   */
  private static class HelperHolder {
    private static final InitializingOnDemandHolderIdiom INSTANCE =
        new InitializingOnDemandHolderIdiom();
  }
}
```

Agora quando o clente precisar da instância Singleton, basta:

```java
// eagerly initialized singleton
Vencedor vencedor = Vencedor.getInstance();

// lazily initialized singleton
ThreadSafeLazyLoadedVencedor threadSafeVencedor1 = ThreadSafeLazyLoadedVencedor.getInstance();

// enum singleton
EnumVencedor enumVencedor = EnumVencedor.INSTANCE;

// double checked locking
ThreadSafeDoubleCheckLocking dcl = ThreadSafeDoubleCheckLocking.getInstance();

// demand holder idiom
InitializingOnDemandHolderIdiom demandHolderIdiom =
    InitializingOnDemandHolderIdiom.getInstance();

```

## Applicabilidade

Use o padrão Singleton quando:

* for preciso haver apenas uma instância de uma classe, e essa instância tiver que dar acesso aos clientes através de um ponto bem conhecido;

* a única instância tiver de ser extensível através de subclasses, possibilitando aos clientes usar uma instância estendida sem alterar o seu código.

## Consequências:

O padrão Singleton apresenta vários benefícios:

1. _Acesso controlado à instância única._ Como a classe Singleton encapsula a sua única instância, possui controle total sobre como e quando os clientes a acessam.

2. _Espaço de nomes reduzido._ O padrão Singleton representa uma melhoria em relação ao uso de variáveis globais. Ele evita a poluição do espaço de nomes com variáveis globais que armazenam instâncias únicas.

3. _Permite um refinamento de operações e da representação._ A classe Singleton pode ter subclasses e é fácil configurar uma aplicação com uma instância dessa classe estendida. Você pode configurar a aplicação com uma instância da classe de que necessita em tempo de execução.

4. _Permite um número variável de instâncias._ O padrão torna fácil mudar de idéia, permitindo mais de uma instância da classe Singleton. Além disso, você pode usar a mesma abordagem para controlar o número de instâncias que a aplicação utiliza. Somente a operação que permite acesso à instância de Singleton necessita ser mudada.

5. _Mais flexível do que operações de classe._ Uma outra maneira de empacotar a funcionalidade de um singleton é usando operações de classe (ou seja, funções-membro estáticas em C++ ou métodos de classe em Smalltalk). Porém, as técnicas de ambas as linguagens tornam difícil mudar um projeto para permitir mais que uma instância de uma classe. Além disso, as funções- membro estáticas em C++ nunca são virtuais, o que significa que as subclasses não podem redefini-las polimorficamente.

# Padrões relacionados

- Muitos padrões podem ser implementados usando Singleton. Como **Abstract Factory**, **Builder** e **Prototype**.

## Tutorial
* [Padrão de Projeto: Singleton](https://www.thiengo.com.br/padrao-de-projeto-singleton)
* [Padrão de Projeto Singleton em Java](https://www.devmedia.com.br/padrao-de-projeto-singleton-em-java/26392)

## Exemplos reais

* [java.lang.Runtime#getRuntime()](http://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html#getRuntime%28%29)
* [java.awt.Desktop#getDesktop()](http://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html#getDesktop--)
* [java.lang.System#getSecurityManager()](http://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getSecurityManager--)

## Créditos

* [Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos - GoF](https://www.amazon.com.br/Padr%C3%B5es-Projetos-Solu%C3%A7%C3%B5es-Reutiliz%C3%A1veis-Orientados/dp/8573076100?tag=goog0ef-20&smid=A1ZZFT5FULY4LN&ascsubtag=go_729680143_34002717090_172477348789_pla-386979319859_c_) _(livro)_
* [Effective Java (2nd Edition)](http://www.amazon.com/Effective-Java-Edition-Joshua-Bloch/dp/0321356683) _(livro)_
* [Design patterns implemented in Java](https://github.com/iluwatar/java-design-patterns/tree/master/singleton) _(Repositório)_