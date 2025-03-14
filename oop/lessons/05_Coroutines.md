# Урок 5: Корутины и асинхронное программирование в Kotlin

## Введение

Корутины в Kotlin - это мощный инструмент для асинхронного и неблокирующего программирования. Они позволяют писать асинхронный код в последовательном стиле, делая его более читаемым и поддерживаемым, избегая при этом проблем с обратными вызовами (callback hell).

Для использования корутин в Kotlin необходимо добавить зависимость:

```kotlin
// Gradle
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4'
```

## Основы корутин

### Создание и запуск корутин

Корутины запускаются с помощью билдеров корутин, таких как `launch`, `async` и `runBlocking`:

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking { // Создает корутину, блокирующую основной поток
    println("Начало программы")
    
    // Запуск корутины
    launch { // Создает новую корутину без блокирования текущей
        delay(1000L) // Неблокирующая задержка на 1 секунду
        println("Корутина выполнена")
    }
    
    println("Конец программы")
}

// Вывод:
// Начало программы
// Конец программы
// Корутина выполнена
```

### Билдеры корутин

#### launch

`launch` запускает новую корутину без блокирования текущей и возвращает `Job`, который можно использовать для управления корутиной:

```kotlin
val job = launch {
    delay(1000L)
    println("Корутина выполнена")
}

// Ожидание завершения корутины
job.join()
```

#### async

`async` запускает новую корутину и возвращает `Deferred<T>`, который представляет будущий результат:

```kotlin
val deferred = async {
    delay(1000L)
    "Результат корутины"
}

// Ожидание результата
val result = deferred.await()
println(result)
```

#### runBlocking

`runBlocking` блокирует текущий поток до завершения всех корутин внутри блока:

```kotlin
runBlocking {
    delay(1000L)
    println("Блок runBlocking завершен")
}
```

#### coroutineScope

`coroutineScope` создает новую область видимости корутин и ожидает завершения всех корутин внутри блока, не блокируя текущий поток:

```kotlin
suspend fun doSomething() = coroutineScope {
    launch {
        delay(1000L)
        println("Корутина 1 завершена")
    }
    
    launch {
        delay(2000L)
        println("Корутина 2 завершена")
    }
    
    "Результат функции"
}
```

## Контекст и диспетчеры корутин

Контекст корутины - это набор элементов, определяющих поведение корутины. Диспетчер корутины - один из элементов контекста, определяющий, в каком потоке (или потоках) будет выполняться корутина.

### Диспетчеры

#### Dispatchers.Default

Используется для вычислительно-интенсивных задач:

```kotlin
launch(Dispatchers.Default) {
    // Вычислительно-интенсивная задача
    val result = (1..1000000).sum()
    println("Сумма: $result")
}
```

#### Dispatchers.IO

Используется для операций ввода-вывода:

```kotlin
launch(Dispatchers.IO) {
    // Операция ввода-вывода
    val data = fetchDataFromNetwork()
    println("Данные: $data")
}
```

#### Dispatchers.Main

Используется для операций пользовательского интерфейса (в Android):

```kotlin
launch(Dispatchers.Main) {
    // Обновление UI
    updateUI(data)
}
```

#### newSingleThreadContext

Создает новый однопоточный контекст:

```kotlin
val dispatcher = newSingleThreadContext("MyThread")
launch(dispatcher) {
    println("Выполняется в ${Thread.currentThread().name}")
}
```

### Переключение контекста

Для переключения контекста внутри корутины используется `withContext`:

```kotlin
launch(Dispatchers.Default) {
    // Вычислительно-интенсивная задача
    val result = computeResult()
    
    withContext(Dispatchers.Main) {
        // Обновление UI
        updateUI(result)
    }
}
```

## Job и структурированная конкурентность

`Job` представляет отменяемую задачу с жизненным циклом. Структурированная конкурентность означает, что корутины образуют иерархию, где дочерние корутины отменяются при отмене родительской.

### Создание и управление Job

```kotlin
val job = launch {
    // Корутина
}

// Ожидание завершения
job.join()

// Отмена корутины
job.cancel()

// Проверка активности
if (job.isActive) {
    println("Корутина активна")
}
```

### Структурированная конкурентность

```kotlin
val parentJob = launch {
    val childJob = launch {
        try {
            repeat(1000) { i ->
                println("Дочерняя корутина: $i")
                delay(500L)
            }
        } catch (e: CancellationException) {
            println("Дочерняя корутина отменена")
        }
    }
    
    delay(1500L)
    println("Отмена родительской корутины")
    // Отмена родительской корутины также отменяет дочернюю
}

// Ожидание завершения
parentJob.join()
```

## Отмена и таймауты

Корутины можно отменять явно или с использованием таймаутов.

### Явная отмена

```kotlin
val job = launch {
    try {
        repeat(1000) { i ->
            println("Корутина: $i")
            delay(500L)
        }
    } catch (e: CancellationException) {
        println("Корутина отменена")
    } finally {
        println("Освобождение ресурсов")
    }
}

delay(1500L)
println("Отмена корутины")
job.cancel()
job.join()
```

### Таймауты

```kotlin
try {
    withTimeout(1500L) {
        repeat(1000) { i ->
            println("Корутина: $i")
            delay(500L)
        }
    }
} catch (e: TimeoutCancellationException) {
    println("Таймаут")
}

// Или с возвращением null при таймауте
val result = withTimeoutOrNull(1500L) {
    repeat(1000) { i ->
        println("Корутина: $i")
        delay(500L)
    }
    "Результат"
}

println("Результат: $result")
```

## Каналы

Каналы (Channels) - это примитивы для передачи потоков значений между корутинами.

### Базовое использование каналов

```kotlin
val channel = Channel<Int>()

launch {
    // Отправка значений в канал
    for (i in 1..5) {
        channel.send(i)
        delay(100L)
    }
    channel.close() // Закрытие канала
}

// Получение значений из канала
for (value in channel) {
    println("Получено: $value")
}
```

### Производители и потребители

```kotlin
// Производитель
fun CoroutineScope.produceNumbers() = produce<Int> {
    for (i in 1..5) {
        send(i)
        delay(100L)
    }
}

// Потребитель
launch {
    val channel = produceNumbers()
    channel.consumeEach { value ->
        println("Получено: $value")
    }
}
```

### Несколько производителей

```kotlin
val channel = Channel<String>()

// Несколько производителей
launch {
    for (i in 1..5) {
        channel.send("Производитель 1: $i")
        delay(100L)
    }
}

launch {
    for (i in 1..5) {
        channel.send("Производитель 2: $i")
        delay(150L)
    }
}

// Потребитель
launch {
    for (value in channel) {
        println("Получено: $value")
    }
}

delay(2000L)
channel.close()
```

### Несколько потребителей

```kotlin
val channel = Channel<Int>()

// Производитель
launch {
    for (i in 1..10) {
        channel.send(i)
        delay(100L)
    }
    channel.close()
}

// Несколько потребителей
repeat(3) { consumerId ->
    launch {
        for (value in channel) {
            println("Потребитель $consumerId получил: $value")
            delay(200L)
        }
    }
}
```

## Flow

Flow - это холодный асинхронный поток данных, который последовательно испускает значения и завершается успешно или с ошибкой.

### Создание Flow

```kotlin
val flow = flow {
    for (i in 1..5) {
        delay(100L)
        emit(i) // Испускание значения
    }
}
```

### Сбор значений из Flow

```kotlin
flow.collect { value ->
    println("Получено: $value")
}
```

### Операторы Flow

```kotlin
flow
    .map { it * it } // Преобразование значений
    .filter { it > 10 } // Фильтрация значений
    .collect { value ->
        println("Получено: $value")
    }
```

### Изменение контекста

```kotlin
flow
    .flowOn(Dispatchers.Default) // Выполнение Flow в указанном контексте
    .collect { value ->
        println("Получено: $value в ${Thread.currentThread().name}")
    }
```

### Обработка ошибок

```kotlin
flow
    .catch { e -> // Обработка ошибок
        println("Ошибка: ${e.message}")
    }
    .collect { value ->
        println("Получено: $value")
    }
```

### Объединение Flow

```kotlin
val flow1 = flowOf(1, 2, 3)
val flow2 = flowOf("A", "B", "C")

flow1.zip(flow2) { a, b -> "$a$b" }
    .collect { value ->
        println("Получено: $value")
    }
```

## Исключения и обработка ошибок

### try-catch внутри корутины

```kotlin
launch {
    try {
        // Код, который может вызвать исключение
        throw Exception("Ошибка в корутине")
    } catch (e: Exception) {
        println("Поймано исключение: ${e.message}")
    }
}
```

### CoroutineExceptionHandler

```kotlin
val handler = CoroutineExceptionHandler { _, exception ->
    println("Поймано исключение: ${exception.message}")
}

val job = launch(handler) {
    throw Exception("Ошибка в корутине")
}
```

### supervisorScope

`supervisorScope` позволяет дочерним корутинам завершаться независимо друг от друга:

```kotlin
supervisorScope {
    val job1 = launch {
        try {
            delay(500L)
            throw Exception("Ошибка в корутине 1")
        } catch (e: CancellationException) {
            println("Корутина 1 отменена")
        }
    }
    
    val job2 = launch {
        try {
            delay(1000L)
            println("Корутина 2 завершена")
        } catch (e: CancellationException) {
            println("Корутина 2 отменена")
        }
    }
}
```

## Совместное использование состояния

### Mutex

Mutex (взаимное исключение) используется для защиты доступа к общему ресурсу:

```kotlin
val mutex = Mutex()
var counter = 0

repeat(1000) {
    launch {
        mutex.withLock {
            counter++
        }
    }
}

delay(1000L)
println("Счетчик: $counter")
```

### Атомарные операции

```kotlin
val counter = AtomicInteger(0)

repeat(1000) {
    launch {
        counter.incrementAndGet()
    }
}

delay(1000L)
println("Счетчик: ${counter.get()}")
```

### Конфайнмент

Конфайнмент (ограничение доступа к состоянию одним потоком) - это подход, при котором доступ к общему состоянию ограничивается одним потоком:

```kotlin
val counterContext = newSingleThreadContext("CounterContext")
var counter = 0

repeat(1000) {
    launch(counterContext) {
        counter++
    }
}

delay(1000L)
withContext(counterContext) {
    println("Счетчик: $counter")
}
```

## Практический пример: Асинхронная загрузка данных

```kotlin
// Имитация сервиса для загрузки данных
class DataService {
    suspend fun fetchData(id: Int): String {
        delay(1000L) // Имитация сетевого запроса
        return "Данные для ID $id"
    }
}

// Имитация кэша
class Cache {
    private val cache = mutableMapOf<Int, String>()
    
    fun get(id: Int): String? {
        return cache[id]
    }
    
    fun put(id: Int, data: String) {
        cache[id] = data
    }
}

// Репозиторий, использующий кэш и сервис
class Repository(private val service: DataService, private val cache: Cache) {
    suspend fun getData(id: Int): String {
        // Проверка кэша
        cache.get(id)?.let { return it }
        
        // Загрузка данных
        return withContext(Dispatchers.IO) {
            val data = service.fetchData(id)
            cache.put(id, data)
            data
        }
    }
    
    suspend fun getMultipleData(ids: List<Int>): List<String> = coroutineScope {
        ids.map { id ->
            async {
                getData(id)
            }
        }.awaitAll()
    }
}

// Использование
val service = DataService()
val cache = Cache()
val repository = Repository(service, cache)

runBlocking {
    // Загрузка одного элемента
    val data = repository.getData(1)
    println("Данные: $data")
    
    // Загрузка нескольких элементов параллельно
    val multipleData = repository.getMultipleData(listOf(2, 3, 4))
    println("Множественные данные: $multipleData")
}
```

## Лучшие практики

1. **Используйте структурированную конкурентность**: Создавайте корутины в соответствующей области видимости, чтобы они автоматически отменялись при необходимости.

2. **Обрабатывайте отмену корутин**: Проверяйте `isActive` и обрабатывайте `CancellationException` для корректной отмены.

3. **Используйте подходящие диспетчеры**: Выбирайте диспетчеры в зависимости от типа задачи (вычисления, ввод-вывод, UI).

4. **Избегайте блокирующих операций**: Используйте suspend-функции вместо блокирующих операций.

5. **Обрабатывайте исключения**: Используйте try-catch или CoroutineExceptionHandler для обработки исключений.

6. **Используйте Flow для потоков данных**: Flow предоставляет богатый API для работы с асинхронными потоками данных.

7. **Защищайте общее состояние**: Используйте Mutex, атомарные операции или конфайнмент для безопасного доступа к общему состоянию.

## Заключение

Корутины в Kotlin предоставляют мощный и элегантный способ работы с асинхронным кодом. Они позволяют писать асинхронный код в последовательном стиле, делая его более читаемым и поддерживаемым. Корутины особенно полезны для операций ввода-вывода, сетевых запросов и других задач, которые могут занимать значительное время.

Использование корутин вместе с другими возможностями Kotlin, такими как расширения и функциональное программирование, позволяет создавать элегантные и эффективные решения для асинхронных задач. 