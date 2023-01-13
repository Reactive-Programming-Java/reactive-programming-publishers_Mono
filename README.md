# reactive-programming-publishers_Mono
## 1-Reactor

Reactor est une librairie qui fournit les spécification pour les traitements asynchrones et non-bloquants

### Reactor Publisher

```java
public interface Publisher<T>{
	public void subscribe(Subscriber<? super T> s);
}
```

```java
public interface Subscriber<T>{
	public void onSubscribe(Subscription s);
  public void onNext(T t);
  public void onError(Throwable t);
  public void onComplete();
}
```

C’est une interface à travers laquelle **Reactor** fournit 2 implémentations:

- Mono<T>
- Flux<T>

### Mono

Cours ⇒ [Ici](https://www.udemy.com/course/complete-java-reactive-programming/learn/lecture/24543414#search)

Example code ⇒ [Ici](https://github.com/elfn-spring5/reactive-programming-publishers_Mono/blob/main/src/main/java/com/rp/MonoSubscribe.java)

- Il émet 0 ou 1 éléments via la méthode `onNext`
- Il appel ensuite `onComplete` ou `onError`

### Flux

Cours ⇒ [Ici](https://www.udemy.com/course/complete-java-reactive-programming/learn/lecture/24543414#search)

Flux peut être un Stream infini.

- Il émet 0 ou N éléments
- Il appel ensuite onComplete ou onError

### Lazy Stream

Code ⇒ [Ici](https://github.com/elfn-spring5/reactive-programming-publishers_Mono/blob/main/src/main/java/com/rp/LazyStream.java)

C’est un stream auquel on ajoute aucun opérateur terminal

### Future

C’est une interface utilisée lorsqu’on travail avec des appels asynchrones et des traitement concurrents, Elle représente le futur résultat d’un calcul asynchrone, le résultat de ce calcul doit apparaître dans le futur après la fin du traitement. Et permet de traiter plusieurs processus indépendamment dans une méthode.

Implémentation d’un Future

```java
public class SquareCalculator {    
    
    private ExecutorService executor 
      = Executors.newSingleThreadExecutor();
    
    public Future<Integer> calculate(Integer input) {        
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
}
```

Consommation du Future implémenté, en utilisant les méthode `isDone` et `get`  pour récupérer le résultat.

```java
Future<Integer> future = new SquareCalculator().calculate(10);

while(!future.isDone()) {
    System.out.println("Calculating...");
    Thread.sleep(300);
}

Integer result = future.get();
```

On peut aussi ajouter du timeout à la méthode `get`  pour lui permettre de lancer un `TimeoutException` au cas ou la tache `future`  ne retourne aucun résultat avant le timeout spécifié.

```java
Integer result = future.get(500, TimeUnit.MILLISECONDS);
```

Source ⇒ [https://www.baeldung.com/java-future](https://www.baeldung.com/java-future)

### CompletableFuture

C’est une classe qui implémente l’interface Future

Example ⇒ [Ici](https://github.com/elfn-spring5/reactive-programming-publishers_Mono/blob/main/src/main/java/com/rp/MonoFromFuture.java)

### Runnable

C’est une interface qui ne prend rien en entrée et qui ne retourne rien non plus

Example ⇒ Ici

## Assignment

Enoncé  ⇒ [Ici](https://www.udemy.com/course/complete-java-reactive-programming/learn/lecture/24543474#search) 

Aide ⇒ [Ici](https://github.com/Elfn/Java-SE-11-1Z0-819-Prep/tree/main/Oracle%20Official%20course/12-JAVA_IO_API)

Résultat code ⇒ [Ici](https://github.com/Reactive-Programming-Java/reactive-programming-publishers_Mono/blob/main/src/main/java/com/rp/assignment/FileService.java)
