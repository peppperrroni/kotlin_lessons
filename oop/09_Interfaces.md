# Урок 9: Интерфейсы в Kotlin

## Введение

Интерфейсы в Kotlin представляют собой мощный инструмент для определения контрактов, которым должны следовать классы. Они позволяют описать, что класс должен делать, не указывая, как именно это должно быть реализовано. Интерфейсы также обеспечивают возможность множественного наследования поведения, что невозможно с обычными классами.

В этом уроке мы рассмотрим, как объявлять и реализовывать интерфейсы в Kotlin, а также изучим их особенности и применение в реальных проектах.

## Основы интерфейсов

### Объявление интерфейса

Интерфейс в Kotlin объявляется с помощью ключевого слова `interface`:

```kotlin
interface Clickable {
    // Абстрактный метод (без реализации)
    fun click()
    
    // Метод с реализацией по умолчанию
    fun showInfo() {
        println("Это кликабельный элемент")
    }
}
```

### Реализация интерфейса

Класс может реализовать один или несколько интерфейсов, используя двоеточие (`:`):

```kotlin
class Button(val text: String) : Clickable {
    // Реализация абстрактного метода интерфейса
    override fun click() {
        println("Кнопка '$text' была нажата")
    }
}
```

### Использование интерфейса

```kotlin
val button = Button("OK")
button.click()  // Вызов реализованного метода
button.showInfo()  // Вызов метода с реализацией по умолчанию
```

## Реализация нескольких интерфейсов

Класс в Kotlin может реализовывать несколько интерфейсов одновременно:

```kotlin
interface Displayable {
    fun display()
    
    fun showInfo() {
        println("Это отображаемый элемент")
    }
}

class ImageButton(val text: String, val imageUrl: String) : Clickable, Displayable {
    override fun click() {
        println("Кнопка с изображением '$text' была нажата")
    }
    
    override fun display() {
        println("Отображение кнопки с изображением: $imageUrl")
    }
    
    // При наличии одинаковых методов в интерфейсах необходимо явно переопределить их
    override fun showInfo() {
        super<Clickable>.showInfo()  // Вызов реализации из Clickable
        super<Displayable>.showInfo()  // Вызов реализации из Displayable
        println("Это кнопка с изображением и текстом '$text'")
    }
}
```

## Методы с реализацией по умолчанию

Интерфейсы в Kotlin могут содержать методы с реализацией по умолчанию, которые классы могут использовать или переопределять:

```kotlin
class Checkbox(val text: String, var checked: Boolean = false) : Clickable {
    override fun click() {
        checked = !checked
        println("Чекбокс '$text' ${if (checked) "отмечен" else "снят"}")
    }
    
    // Используем реализацию по умолчанию из интерфейса
    // override fun showInfo() не требуется
}
```

## Разрешение конфликтов при множественной реализации

Когда класс реализует несколько интерфейсов с одинаковыми методами, необходимо явно переопределить эти методы:

```kotlin
class MenuItem(val text: String) : Clickable, Displayable {
    override fun click() {
        println("Пункт меню '$text' был выбран")
    }
    
    override fun display() {
        println("Отображение пункта меню: $text")
    }
    
    // Явное разрешение конфликта
    override fun showInfo() {
        // Выбираем одну из реализаций или создаем свою
        super<Clickable>.showInfo()
        println("Это пункт меню '$text'")
    }
}
```

## Свойства в интерфейсах

Интерфейсы в Kotlin могут содержать абстрактные свойства или свойства с геттерами:

```kotlin
interface Progressable {
    // Абстрактное свойство (должно быть реализовано)
    var progress: Int
    
    // Свойство с геттером
    val isComplete: Boolean
        get() = progress >= 100
    
    fun updateProgress(value: Int)
}

class ProgressBar(val name: String) : Progressable {
    // Реализация абстрактного свойства
    override var progress: Int = 0
        set(value) {
            field = value.coerceIn(0, 100)  // Ограничиваем значение от 0 до 100
        }
    
    override fun updateProgress(value: Int) {
        progress += value
        println("Прогресс '$name': $progress% ${if (isComplete) "(завершено)" else ""}")
    }
}
```

## Функциональные интерфейсы (SAM)

Функциональный интерфейс (Single Abstract Method, SAM) — это интерфейс, содержащий только один абстрактный метод. Kotlin позволяет использовать лямбда-выражения для реализации таких интерфейсов:

```kotlin
// Функциональный интерфейс
fun interface OnClickListener {
    fun onClick(view: String)
}

// Использование с лямбда-выражением
val listener = OnClickListener { view ->
    println("Клик по $view")
}

// Передача лямбда-выражения в функцию
fun setClickListener(listener: OnClickListener) {
    listener.onClick("Кнопка")
}

// Вызов с лямбда-выражением
setClickListener { view ->
    println("Обработка клика по $view")
}
```

## Наследование интерфейсов

Интерфейсы могут наследоваться от других интерфейсов:

```kotlin
interface AdvancedClickable : Clickable {
    fun longClick()
    
    // Переопределение метода базового интерфейса
    override fun showInfo() {
        println("Это продвинутый кликабельный элемент")
    }
}

class AdvancedButton(val text: String) : AdvancedClickable {
    override fun click() {
        println("Кнопка '$text' была нажата")
    }
    
    override fun longClick() {
        println("Долгое нажатие на кнопку '$text'")
    }
}
```

## Делегирование интерфейсов

Kotlin поддерживает делегирование реализации интерфейса другому объекту с помощью ключевого слова `by`:

```kotlin
interface Storage {
    fun save(data: String)
    fun load(): String
}

class FileStorage : Storage {
    override fun save(data: String) {
        println("Сохранение в файл: $data")
    }
    
    override fun load(): String {
        return "Данные из файла"
    }
}

class CacheStorage : Storage {
    override fun save(data: String) {
        println("Сохранение в кэш: $data")
    }
    
    override fun load(): String {
        return "Данные из кэша"
    }
}

// Класс, делегирующий реализацию интерфейса другим объектам
class HybridStorage(
    private val fileStorage: Storage,
    private val cacheStorage: Storage
) : Storage by fileStorage {  // Делегирование по умолчанию fileStorage
    
    // Переопределение некоторых методов
    override fun save(data: String) {
        fileStorage.save(data)  // Сохраняем в файл
        cacheStorage.save(data)  // И в кэш
    }
}
```

## Практические примеры

### Пример 1: Система уведомлений

```kotlin
// Интерфейс для системы уведомлений
interface Notifier {
    fun notify(message: String)
}

// Различные реализации
class EmailNotifier(val email: String) : Notifier {
    override fun notify(message: String) {
        println("Отправка email на $email: $message")
    }
}

class SMSNotifier(val phoneNumber: String) : Notifier {
    override fun notify(message: String) {
        println("Отправка SMS на $phoneNumber: $message")
    }
}

class PushNotifier(val deviceId: String) : Notifier {
    override fun notify(message: String) {
        println("Отправка push-уведомления на устройство $deviceId: $message")
    }
}

// Использование
val notifiers = listOf(
    EmailNotifier("user@example.com"),
    SMSNotifier("+7-123-456-7890"),
    PushNotifier("device-123")
)

val message = "Важное уведомление о системе"
notifiers.forEach { notifier ->
    notifier.notify(message)
}
```

### Пример 2: Система фильтрации

```kotlin
// Интерфейс для фильтрации
interface Filter<T> {
    fun apply(items: List<T>): List<T>
}

// Класс продукта
data class Product(val name: String, val price: Double, val category: String)

// Различные фильтры
class PriceFilter(val maxPrice: Double) : Filter<Product> {
    override fun apply(items: List<Product>): List<Product> {
        return items.filter { it.price <= maxPrice }
    }
}

class CategoryFilter(val category: String) : Filter<Product> {
    override fun apply(items: List<Product>): List<Product> {
        return items.filter { it.category == category }
    }
}

// Комбинированный фильтр
class CompositeFilter<T>(private val filters: List<Filter<T>>) : Filter<T> {
    override fun apply(items: List<T>): List<T> {
        var result = items
        for (filter in filters) {
            result = filter.apply(result)
        }
        return result
    }
}

// Использование
val products = listOf(
    Product("Ноутбук", 65000.0, "Электроника"),
    Product("Смартфон", 35000.0, "Электроника"),
    Product("Книга", 500.0, "Книги"),
    Product("Футболка", 1500.0, "Одежда")
)

val priceFilter = PriceFilter(40000.0)
val categoryFilter = CategoryFilter("Электроника")
val compositeFilter = CompositeFilter(listOf(priceFilter, categoryFilter))

val filteredProducts = compositeFilter.apply(products)
println("Отфильтрованные продукты:")
filteredProducts.forEach { println("${it.name} - ${it.price} руб. (${it.category})") }
```

### Пример 3: Система плагинов

```kotlin
// Интерфейс для плагинов
interface Plugin {
    val name: String
    val version: String
    
    fun initialize()
    fun shutdown()
    
    fun getInfo(): String {
        return "Плагин: $name v$version"
    }
}

// Реализации плагинов
class LoggerPlugin : Plugin {
    override val name: String = "Logger"
    override val version: String = "1.0.0"
    
    override fun initialize() {
        println("Инициализация плагина логирования")
    }
    
    override fun shutdown() {
        println("Завершение работы плагина логирования")
    }
}

class DatabasePlugin : Plugin {
    override val name: String = "Database"
    override val version: String = "2.1.0"
    
    override fun initialize() {
        println("Подключение к базе данных")
    }
    
    override fun shutdown() {
        println("Закрытие соединения с базой данных")
    }
}

// Приложение, использующее плагины
class Application {
    private val plugins = mutableListOf<Plugin>()
    
    fun registerPlugin(plugin: Plugin) {
        plugins.add(plugin)
        println("Зарегистрирован плагин: ${plugin.getInfo()}")
    }
    
    fun start() {
        println("Запуск приложения")
        plugins.forEach { it.initialize() }
    }
    
    fun stop() {
        println("Остановка приложения")
        plugins.forEach { it.shutdown() }
    }
}

// Использование
val app = Application()
app.registerPlugin(LoggerPlugin())
app.registerPlugin(DatabasePlugin())
app.start()
// ... работа приложения ...
app.stop()
```

## Заключение

Интерфейсы в Kotlin являются мощным инструментом для определения контрактов и обеспечения множественного наследования поведения. Они позволяют создавать гибкие и расширяемые системы, следуя принципу "программирования на уровне интерфейсов, а не реализаций".

Ключевые особенности интерфейсов в Kotlin:
- Интерфейсы могут содержать абстрактные методы и методы с реализацией по умолчанию
- Класс может реализовывать несколько интерфейсов
- Интерфейсы могут содержать свойства (абстрактные или с геттерами)
- Функциональные интерфейсы (SAM) могут быть реализованы с помощью лямбда-выражений
- Интерфейсы могут наследоваться от других интерфейсов
- Kotlin поддерживает делегирование реализации интерфейса другому объекту

Использование интерфейсов способствует созданию слабосвязанного кода, что облегчает тестирование, поддержку и расширение приложений. 