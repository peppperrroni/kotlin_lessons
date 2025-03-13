/**
 * Урок 9: Интерфейсы в Kotlin
 * 
 * В этом уроке мы рассмотрим интерфейсы в Kotlin, которые позволяют определять
 * контракты для классов и обеспечивают множественное наследование поведения.
 */

fun main() {
    println("Урок 9: Интерфейсы в Kotlin")
    println("===========================")
    
    // ======== Основы интерфейсов ========
    
    println("\n=== Основы интерфейсов ===")
    
    // Создание объекта класса, реализующего интерфейс
    val button = Button("Кнопка входа")
    button.click()  // Метод из интерфейса
    button.showInfo()  // Метод из интерфейса
    
    // Использование переменной типа интерфейса
    val clickable: Clickable = button
    clickable.click()  // Можно вызвать только методы интерфейса
    
    // ======== Реализация нескольких интерфейсов ========
    
    println("\n=== Реализация нескольких интерфейсов ===")
    
    val imageButton = ImageButton("Кнопка с изображением", "icon.png")
    imageButton.click()  // Из Clickable
    imageButton.showInfo()  // Из Clickable
    imageButton.display()  // Из Displayable
    
    // ======== Интерфейсы с реализацией по умолчанию ========
    
    println("\n=== Интерфейсы с реализацией по умолчанию ===")
    
    val checkbox = Checkbox("Согласие с условиями")
    checkbox.click()  // Собственная реализация
    checkbox.showInfo()  // Реализация по умолчанию из интерфейса
    
    // ======== Разрешение конфликтов при множественной реализации ========
    
    println("\n=== Разрешение конфликтов при множественной реализации ===")
    
    val menuItem = MenuItem("Файл", "Открыть файл")
    menuItem.showInfo()  // Явное разрешение конфликта
    
    // ======== Свойства в интерфейсах ========
    
    println("\n=== Свойства в интерфейсах ===")
    
    val progressBar = ProgressBar(0)
    println("Начальный прогресс: ${progressBar.progress}%")
    
    progressBar.progress = 50
    println("Текущий прогресс: ${progressBar.progress}%")
    
    println("Максимальный прогресс: ${progressBar.maxProgress}%")
    
    // ======== Функциональные интерфейсы ========
    
    println("\n=== Функциональные интерфейсы ===")
    
    // Использование функционального интерфейса с лямбда-выражением
    val printer: Printer = { message -> println("Печать: $message") }
    printer("Привет, мир!")
    
    // Передача лямбда-выражения в функцию, ожидающую функциональный интерфейс
    processPrinting("Важное сообщение") { message ->
        println("*** $message ***")
    }
    
    // ======== Интерфейсы и наследование ========
    
    println("\n=== Интерфейсы и наследование ===")
    
    val advancedButton = AdvancedButton("Расширенная кнопка")
    advancedButton.click()  // Из Clickable
    advancedButton.longClick()  // Из AdvancedClickable
    
    // ======== Делегирование интерфейсов ========
    
    println("\n=== Делегирование интерфейсов ===")
    
    val fileStorage = FileStorage()
    val cacheStorage = CacheStorage()
    
    // Класс, использующий делегирование интерфейсов
    val hybridStorage = HybridStorage(fileStorage, cacheStorage)
    
    hybridStorage.save("user.dat", "Данные пользователя")
    hybridStorage.load("user.dat")
    hybridStorage.cache("user.dat", "Кэшированные данные")
    hybridStorage.retrieve("user.dat")
    
    // ======== Практические примеры ========
    
    println("\n=== Практические примеры ===")
    
    // Пример 1: Система уведомлений
    val notifiers = listOf(
        EmailNotifier("user@example.com"),
        SMSNotifier("+7-123-456-7890"),
        PushNotifier("device-token-123")
    )
    
    val notificationService = NotificationService(notifiers)
    notificationService.notifyAll("Важное уведомление!")
    
    // Пример 2: Система фильтров
    val filters = listOf(
        AgeFilter(18),
        CategoryFilter("Электроника"),
        PriceFilter(1000.0, 5000.0)
    )
    
    val products = listOf(
        Product("Смартфон", "Электроника", 15000.0, 21),
        Product("Наушники", "Электроника", 3000.0, 16),
        Product("Книга", "Литература", 500.0, 12),
        Product("Ноутбук", "Электроника", 45000.0, 18)
    )
    
    println("\nПрименение фильтров к товарам:")
    val filteredProducts = products.filter { product ->
        filters.all { filter -> filter.apply(product) }
    }
    
    filteredProducts.forEach { product ->
        println("${product.name} (${product.category}, ${product.price} руб., ${product.ageRestriction}+)")
    }
    
    // Пример 3: Система плагинов
    val plugins = listOf(
        LoggerPlugin(),
        StatisticsPlugin(),
        SecurityPlugin()
    )
    
    val application = Application(plugins)
    application.start()
    application.processRequest("GET /api/users")
    application.stop()
}

// ======== Определения интерфейсов и классов ========

// Простой интерфейс
interface Clickable {
    // Абстрактный метод (без реализации)
    fun click()
    
    // Метод с реализацией по умолчанию
    fun showInfo() {
        println("Это кликабельный элемент")
    }
}

// Класс, реализующий интерфейс
class Button(val text: String) : Clickable {
    // Реализация абстрактного метода
    override fun click() {
        println("Кнопка '$text' была нажата")
    }
}

// Еще один интерфейс
interface Displayable {
    fun display()
    
    // Метод с реализацией по умолчанию
    fun showInfo() {
        println("Это отображаемый элемент")
    }
}

// Класс, реализующий несколько интерфейсов
class ImageButton(val text: String, val imageUrl: String) : Clickable, Displayable {
    override fun click() {
        println("Кнопка с изображением '$text' была нажата")
    }
    
    override fun display() {
        println("Отображение кнопки с изображением из $imageUrl")
    }
    
    // Необходимо явно разрешить конфликт методов с одинаковым именем
    override fun showInfo() {
        super<Clickable>.showInfo()  // Вызов реализации из Clickable
        super<Displayable>.showInfo()  // Вызов реализации из Displayable
        println("Это кнопка с изображением '$text'")
    }
}

// Класс, использующий реализацию по умолчанию
class Checkbox(val label: String) : Clickable {
    override fun click() {
        println("Флажок '$label' был переключен")
    }
    
    // Не переопределяем showInfo(), используем реализацию по умолчанию
}

// Класс с явным разрешением конфликта
class MenuItem(val name: String, val action: String) : Clickable, Displayable {
    override fun click() {
        println("Пункт меню '$name' был выбран, действие: $action")
    }
    
    override fun display() {
        println("Отображение пункта меню '$name'")
    }
    
    // Явное разрешение конфликта
    override fun showInfo() {
        println("Это пункт меню '$name' с действием '$action'")
    }
}

// Интерфейс со свойствами
interface Progressable {
    // Абстрактное свойство (должно быть реализовано)
    var progress: Int
    
    // Свойство с геттером по умолчанию
    val maxProgress: Int
        get() = 100
    
    // Метод, использующий свойства
    fun isComplete(): Boolean {
        return progress >= maxProgress
    }
}

// Класс, реализующий интерфейс со свойствами
class ProgressBar(override var progress: Int) : Progressable {
    // Реализация абстрактного свойства
    
    // Можно переопределить свойство с геттером по умолчанию
    // override val maxProgress: Int = 100
    
    fun increment(amount: Int) {
        progress = minOf(progress + amount, maxProgress)
        println("Прогресс увеличен до $progress%")
        
        if (isComplete()) {
            println("Прогресс завершен!")
        }
    }
}

// Функциональный интерфейс (SAM - Single Abstract Method)
fun interface Printer {
    fun print(message: String)
}

// Функция, принимающая функциональный интерфейс
fun processPrinting(message: String, printer: Printer) {
    printer.print(message)
}

// Наследование интерфейсов
interface AdvancedClickable : Clickable {
    fun longClick()
}

// Класс, реализующий расширенный интерфейс
class AdvancedButton(val text: String) : AdvancedClickable {
    override fun click() {
        println("Обычный клик по кнопке '$text'")
    }
    
    override fun longClick() {
        println("Долгий клик по кнопке '$text'")
    }
}

// Интерфейсы для делегирования
interface Storage {
    fun save(fileName: String, data: String)
    fun load(fileName: String): String
}

interface Cache {
    fun cache(key: String, data: String)
    fun retrieve(key: String): String
}

// Реализации интерфейсов
class FileStorage : Storage {
    override fun save(fileName: String, data: String) {
        println("Сохранение данных в файл $fileName")
    }
    
    override fun load(fileName: String): String {
        println("Загрузка данных из файла $fileName")
        return "Данные из файла"
    }
}

class CacheStorage : Cache {
    override fun cache(key: String, data: String) {
        println("Кэширование данных с ключом $key")
    }
    
    override fun retrieve(key: String): String {
        println("Получение данных из кэша по ключу $key")
        return "Данные из кэша"
    }
}

// Класс с делегированием интерфейсов
class HybridStorage(
    private val fileStorage: Storage,
    private val cacheStorage: Cache
) : Storage by fileStorage, Cache by cacheStorage

// Классы для примера с системой уведомлений
interface Notifier {
    fun notify(message: String)
}

class EmailNotifier(private val email: String) : Notifier {
    override fun notify(message: String) {
        println("Отправка email на $email: $message")
    }
}

class SMSNotifier(private val phoneNumber: String) : Notifier {
    override fun notify(message: String) {
        println("Отправка SMS на $phoneNumber: $message")
    }
}

class PushNotifier(private val deviceToken: String) : Notifier {
    override fun notify(message: String) {
        println("Отправка Push-уведомления на устройство $deviceToken: $message")
    }
}

class NotificationService(private val notifiers: List<Notifier>) {
    fun notifyAll(message: String) {
        println("\nОтправка уведомления всем получателям:")
        notifiers.forEach { it.notify(message) }
    }
}

// Классы для примера с системой фильтров
interface Filter<T> {
    fun apply(item: T): Boolean
}

data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val ageRestriction: Int
)

class AgeFilter(private val minAge: Int) : Filter<Product> {
    override fun apply(item: Product): Boolean {
        return item.ageRestriction >= minAge
    }
}

class CategoryFilter(private val category: String) : Filter<Product> {
    override fun apply(item: Product): Boolean {
        return item.category == category
    }
}

class PriceFilter(private val minPrice: Double, private val maxPrice: Double) : Filter<Product> {
    override fun apply(item: Product): Boolean {
        return item.price in minPrice..maxPrice
    }
}

// Классы для примера с системой плагинов
interface Plugin {
    fun initialize()
    fun process(request: String)
    fun shutdown()
}

class LoggerPlugin : Plugin {
    override fun initialize() {
        println("Инициализация плагина логирования")
    }
    
    override fun process(request: String) {
        println("Логирование запроса: $request")
    }
    
    override fun shutdown() {
        println("Завершение работы плагина логирования")
    }
}

class StatisticsPlugin : Plugin {
    override fun initialize() {
        println("Инициализация плагина статистики")
    }
    
    override fun process(request: String) {
        println("Сбор статистики по запросу: $request")
    }
    
    override fun shutdown() {
        println("Сохранение статистики и завершение работы плагина")
    }
}

class SecurityPlugin : Plugin {
    override fun initialize() {
        println("Инициализация плагина безопасности")
    }
    
    override fun process(request: String) {
        println("Проверка безопасности запроса: $request")
    }
    
    override fun shutdown() {
        println("Завершение работы плагина безопасности")
    }
}

class Application(private val plugins: List<Plugin>) {
    fun start() {
        println("\nЗапуск приложения:")
        plugins.forEach { it.initialize() }
    }
    
    fun processRequest(request: String) {
        println("\nОбработка запроса '$request':")
        plugins.forEach { it.process(request) }
    }
    
    fun stop() {
        println("\nОстановка приложения:")
        plugins.forEach { it.shutdown() }
    }
} 