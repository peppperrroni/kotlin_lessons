# Урок 3: Дженерики (обобщения) в Kotlin

## Введение

Дженерики (обобщения) - это мощный инструмент, который позволяет создавать классы, интерфейсы и функции, работающие с разными типами данных, сохраняя при этом типобезопасность. Они позволяют писать более универсальный и повторно используемый код, избегая дублирования.

## Основы дженериков

### Обобщенные классы

Обобщенный класс определяется с одним или несколькими параметрами типа:

```kotlin
class Box<T>(var value: T) {
    fun getValue(): T {
        return value
    }
    
    fun setValue(newValue: T) {
        value = newValue
    }
}

// Использование
val intBox = Box<Int>(10)
val stringBox = Box<String>("Hello")

// Kotlin часто может вывести тип автоматически
val doubleBox = Box(3.14) // Box<Double>
```

### Обобщенные функции

Функции также могут быть обобщенными:

```kotlin
fun <T> printValue(value: T) {
    println(value)
}

// Использование
printValue<Int>(10)
printValue("Hello") // Тип выводится автоматически
```

## Ограничения типов

Можно ограничить параметры типа, указав верхнюю границу:

```kotlin
// T должен быть Number или его подтипом
class NumberBox<T : Number>(val value: T) {
    fun getDoubleValue(): Double {
        return value.toDouble()
    }
}

// Использование
val intBox = NumberBox(10) // OK
val doubleBox = NumberBox(3.14) // OK
// val stringBox = NumberBox("Hello") // Ошибка компиляции
```

### Множественные ограничения

Можно указать несколько ограничений с помощью where:

```kotlin
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<T>
    where T : Comparable<T>, T : Number {
    return list.filter { it > threshold }
}
```

## Вариантность

Вариантность определяет, как обобщенные типы с разными параметрами типа соотносятся друг с другом.

### Инвариантность

По умолчанию обобщенные типы в Kotlin инвариантны:

```kotlin
class Box<T>(var value: T)

fun main() {
    val intBox = Box<Int>(10)
    // val anyBox: Box<Any> = intBox // Ошибка компиляции
}
```

### Ковариантность (out)

Ковариантность позволяет использовать подтип вместо супертипа:

```kotlin
// Producer - ковариантный класс
class Producer<out T>(private val value: T) {
    fun get(): T {
        return value
    }
}

fun main() {
    val intProducer = Producer<Int>(10)
    val anyProducer: Producer<Any> = intProducer // OK, потому что Int - подтип Any
}
```

### Контравариантность (in)

Контравариантность позволяет использовать супертип вместо подтипа:

```kotlin
// Consumer - контравариантный класс
class Consumer<in T>(private var value: T) {
    fun set(newValue: T) {
        value = newValue
    }
}

fun main() {
    val anyConsumer = Consumer<Any>("Hello")
    val stringConsumer: Consumer<String> = anyConsumer // OK, потому что Any - супертип String
}
```

## Звездочная проекция

Звездочная проекция (`*`) используется, когда конкретный тип параметра не важен или неизвестен:

```kotlin
// Функция, которая работает с любым Box
fun printBoxInfo(box: Box<*>) {
    println("Box содержит значение: ${box.getValue()}")
}

// Использование
val intBox = Box<Int>(10)
val stringBox = Box<String>("Hello")
printBoxInfo(intBox)
printBoxInfo(stringBox)
```

## Обобщенные расширения

Можно создавать обобщенные функции-расширения:

```kotlin
// Функция-расширение для любого списка
fun <T> List<T>.secondOrNull(): T? {
    return if (size >= 2) this[1] else null
}

// Использование
val numbers = listOf(1, 2, 3)
val second = numbers.secondOrNull() // 2
```

## Reified типы

В Kotlin можно использовать reified типы с inline-функциями, чтобы получить доступ к информации о типе во время выполнения:

```kotlin
inline fun <reified T> isType(value: Any): Boolean {
    return value is T
}

// Использование
val result1 = isType<String>("Hello") // true
val result2 = isType<Int>("Hello") // false
```

## Обобщенные делегаты свойств

Можно создавать обобщенные делегаты свойств:

```kotlin
class Delegate<T>(private var value: T) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("Получение значения свойства ${property.name}")
        return value
    }
    
    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: T) {
        println("Установка значения свойства ${property.name} = $newValue")
        value = newValue
    }
}

// Использование
class User {
    var name: String by Delegate("John")
    var age: Int by Delegate(25)
}
```

## Типовые алиасы

Типовые алиасы позволяют создавать альтернативные имена для существующих типов, включая обобщенные:

```kotlin
typealias StringBox = Box<String>
typealias IntList = List<Int>
typealias MapWithStringKey<V> = Map<String, V>

// Использование
val box: StringBox = StringBox("Hello")
val numbers: IntList = listOf(1, 2, 3)
val map: MapWithStringKey<Int> = mapOf("one" to 1, "two" to 2)
```

## Рекурсивные обобщенные типы

Можно создавать рекурсивные обобщенные типы, например, для представления древовидных структур:

```kotlin
class TreeNode<T>(val value: T) {
    private val children = mutableListOf<TreeNode<T>>()
    
    fun addChild(child: TreeNode<T>) {
        children.add(child)
    }
    
    fun getChildren(): List<TreeNode<T>> {
        return children
    }
}

// Использование
val root = TreeNode<String>("Root")
val child1 = TreeNode<String>("Child 1")
val child2 = TreeNode<String>("Child 2")
root.addChild(child1)
root.addChild(child2)
```

## Практические примеры

### Пример 1: Обобщенный репозиторий

```kotlin
interface Repository<T> {
    fun getById(id: Int): T?
    fun getAll(): List<T>
    fun save(item: T): Boolean
    fun delete(id: Int): Boolean
}

class UserRepository : Repository<User> {
    private val users = mutableMapOf<Int, User>()
    
    override fun getById(id: Int): User? {
        return users[id]
    }
    
    override fun getAll(): List<User> {
        return users.values.toList()
    }
    
    override fun save(item: User): Boolean {
        users[item.id] = item
        return true
    }
    
    override fun delete(id: Int): Boolean {
        return users.remove(id) != null
    }
}
```

### Пример 2: Обобщенный адаптер для RecyclerView (Android)

```kotlin
class GenericAdapter<T>(
    private val items: List<T>,
    private val layoutId: Int,
    private val bindItem: (View, T) -> Unit
) : RecyclerView.Adapter<GenericAdapter.ViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindItem(holder.itemView, items[position])
    }
    
    override fun getItemCount(): Int = items.size
    
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

// Использование
val adapter = GenericAdapter<User>(
    users,
    R.layout.item_user,
    { view, user ->
        view.findViewById<TextView>(R.id.name).text = user.name
        view.findViewById<TextView>(R.id.email).text = user.email
    }
)
```

## Лучшие практики

1. **Используйте говорящие имена для параметров типа**: Вместо `T` используйте более описательные имена, например, `Element` или `Key`.

2. **Указывайте ограничения типов, когда это необходимо**: Это делает код более безопасным и выразительным.

3. **Правильно выбирайте вариантность**: Используйте `out` для типов, которые только производят значения, и `in` для типов, которые только потребляют значения.

4. **Избегайте чрезмерного использования обобщений**: Слишком сложные обобщенные типы могут сделать код трудным для понимания.

5. **Используйте reified типы с осторожностью**: Они увеличивают размер сгенерированного кода.

## Заключение

Дженерики (обобщения) в Kotlin - мощный инструмент для создания типобезопасного и повторно используемого кода. Они позволяют писать более абстрактные и гибкие классы, интерфейсы и функции, которые могут работать с разными типами данных.

В следующем уроке мы рассмотрим расширения и функциональное программирование в Kotlin, которые позволяют добавлять новую функциональность к существующим классам и писать более декларативный код. 