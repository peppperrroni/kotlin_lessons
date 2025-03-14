package oop.exercises

/**
 * Упражнения по теме "Углубленное изучение классов и объектов в Kotlin"
 */

/**
 * Упражнение 1: Порядок инициализации
 * 
 * Создайте класс ConfigurationManager со следующими требованиями:
 * - Первичный конструктор принимает параметр configPath: String
 * - Класс имеет свойство settings: Map<String, String>, которое инициализируется в блоке инициализации
 *   путем "загрузки" из файла (имитируйте загрузку, возвращая фиктивные данные)
 * - Класс имеет свойство isLoaded: Boolean, которое устанавливается в true после загрузки настроек
 * - Добавьте второй блок инициализации, который выводит сообщение о количестве загруженных настроек
 * - Добавьте вторичный конструктор, который принимает готовую карту настроек вместо пути к файлу
 */
class Exercise1 {
    // your solution
    
    // Демонстрация использования класса ConfigurationManager
    fun demonstrateConfigurationManager() {
        // your solution
    }
}

/**
 * Упражнение 2: Фабричные методы
 * 
 * Создайте класс Document со следующими требованиями:
 * - Приватный конструктор, принимающий параметры: id: Int, title: String, content: String, 
 *   author: String, createdAt: Long, isPublic: Boolean
 * - Объект-компаньон с фабричными методами:
 *   - createPublicDocument(title: String, content: String, author: String): создает публичный документ с текущим временем
 *   - createPrivateDocument(title: String, content: String, author: String): создает приватный документ с текущим временем
 *   - fromJson(json: String): парсит JSON-строку и создает документ (можно использовать простую имитацию парсинга)
 *   - fromDatabase(id: Int): имитирует загрузку документа из базы данных по ID
 */
class Exercise2 {
    // your solution
    
    // Демонстрация использования фабричных методов
    fun demonstrateFactoryMethods() {
        // your solution
    }
}

/**
 * Упражнение 3: Ленивая инициализация и делегаты свойств
 * 
 * Создайте класс UserProfile со следующими требованиями:
 * - Свойство basicInfo: Map<String, String> с базовой информацией о пользователе
 * - Ленивое свойство extendedInfo: Map<String, Any>, которое "загружается" только при первом обращении
 * - Наблюдаемое свойство lastLoginTime: Long, которое логирует изменения
 * - Проверяемое свойство email: String, которое проверяет корректность email-адреса (должен содержать @)
 * - Свойство settings: UserSettings, делегированное в отдельный класс
 */
class Exercise3 {
    // your solution
    
    // Демонстрация работы с делегатами свойств
    fun demonstratePropertyDelegates() {
        // your solution
    }
}

/**
 * Упражнение 4: Объекты и объекты-компаньоны
 * 
 * Реализуйте следующие классы и объекты:
 * 1. Объект-синглтон Logger с методами:
 *    - log(message: String, level: LogLevel)
 *    - error(message: String)
 *    - warn(message: String)
 *    - info(message: String)
 *    - debug(message: String)
 *    
 * 2. Перечисление LogLevel с уровнями логирования: ERROR, WARN, INFO, DEBUG
 * 
 * 3. Класс HttpClient с приватным конструктором и объектом-компаньоном, который:
 *    - Реализует интерфейс ClientFactory
 *    - Имеет метод getInstance(): HttpClient, возвращающий единственный экземпляр
 *    - Имеет методы для выполнения HTTP-запросов (имитация)
 */
class Exercise4 {
    // your solution
    
    // Демонстрация использования объектов и объектов-компаньонов
    fun demonstrateObjectsAndCompanions() {
        // your solution
    }
}

/**
 * Упражнение 5: Вложенные и внутренние классы
 * 
 * Создайте класс FileSystem со следующими требованиями:
 * - Вложенный класс Permission с полями read, write, execute
 * - Внутренний класс File, имеющий доступ к методам внешнего класса
 * - Внутренний класс Directory, содержащий список файлов и поддиректорий
 * - Методы для работы с файлами и директориями
 */
class Exercise5 {
    // your solution
    
    // Демонстрация работы с вложенными и внутренними классами
    fun demonstrateNestedAndInnerClasses() {
        // your solution
    }
}

/**
 * Упражнение 6: Инлайн-классы и деструктурирующие объявления
 * 
 * 1. Создайте инлайн-классы:
 *    - UserId(val id: Int)
 *    - Password(val value: String) с проверкой сложности пароля
 *    - Percentage(val value: Double) с проверкой диапазона 0-100
 * 
 * 2. Создайте класс Coordinates с полями latitude и longitude, поддерживающий деструктурирующие объявления.
 * 
 * 3. Создайте класс TimeRange с полями start и end, поддерживающий деструктурирующие объявления.
 */
class Exercise6 {
    // your solution
    
    // Демонстрация использования инлайн-классов и деструктурирующих объявлений
    fun demonstrateInlineClassesAndDestructuring() {
        // your solution
    }
}

/**
 * Упражнение 7: Делегирование классов
 * 
 * Реализуйте следующую структуру классов с использованием делегирования:
 * 1. Интерфейс Repository<T> с методами:
 *    - getById(id: Int): T?
 *    - getAll(): List<T>
 *    - save(item: T): Boolean
 *    - delete(id: Int): Boolean
 * 
 * 2. Класс BaseRepository<T>, реализующий базовую логику интерфейса Repository<T>
 * 
 * 3. Классы, делегирующие реализацию BaseRepository:
 *    - LoggingRepository<T>: добавляет логирование операций
 *    - CachingRepository<T>: добавляет кеширование результатов
 *    - ValidatingRepository<T>: добавляет валидацию данных
 */
class Exercise7 {
    // your solution
    
    // Демонстрация использования делегирования классов
    fun demonstrateClassDelegation() {
        // your solution
    }
}

/**
 * Упражнение 8: Реализация паттернов проектирования
 * 
 * Реализуйте следующие паттерны проектирования:
 * 
 * 1. Строитель (Builder):
 *    - Создайте класс EmailMessage с множеством полей (отправитель, получатели, тема, содержание, вложения и т.д.)
 *    - Реализуйте строитель для удобного создания объектов EmailMessage
 * 
 * 2. Наблюдатель (Observer):
 *    - Создайте класс WeatherStation, который отслеживает изменения погоды
 *    - Создайте различные наблюдатели: PhoneDisplay, WebsiteDisplay, EmailNotifier
 * 
 * 3. Стратегия (Strategy):
 *    - Создайте интерфейс SortingStrategy с методом sort(list: List<Int>): List<Int>
 *    - Реализуйте различные стратегии сортировки: BubbleSort, QuickSort, MergeSort
 *    - Создайте класс Sorter, который использует выбранную стратегию
 */
class Exercise8 {
    // your solution
    
    // Демонстрация использования паттернов проектирования
    fun demonstrateDesignPatterns() {
        // your solution
    }
}

/**
 * Упражнение 9: Типобезопасные строители (DSL)
 * 
 * Создайте DSL для построения HTML-документов:
 * - Функции верхнего уровня: html, head, body
 * - Функции для элементов: h1, h2, p, a, div, span, ul, li
 * - Атрибуты для элементов: id, class, href, style
 * 
 * Пример использования:
 * 
 * val htmlContent = html {
 *     head {
 *         title("Моя страница")
 *     }
 *     body {
 *         h1("Заголовок")
 *         p("Параграф текста")
 *         div {
 *             id = "main-content"
 *             classes = listOf("container", "mt-4")
 *             
 *             p("Текст внутри div")
 *             a("Ссылка", href = "https://example.com")
 *             
 *             ul {
 *                 li("Пункт 1")
 *                 li("Пункт 2")
 *                 li("Пункт 3")
 *             }
 *         }
 *     }
 * }
 */
class Exercise9 {
    // your solution
    
    // Демонстрация использования DSL
    fun demonstrateHtmlDsl() {
        // your solution
    }
}

/**
 * Упражнение 10: Комплексное задание
 * 
 * Разработайте систему управления задачами (Task Management System) с использованием изученных концепций:
 * 
 * 1. Классы и интерфейсы:
 *    - Task: класс с полями id, title, description, dueDate, priority, status, assignee
 *    - User: класс с полями id, name, email, role
 *    - TaskRepository: интерфейс для работы с задачами
 *    - UserRepository: интерфейс для работы с пользователями
 *    - TaskService: сервис для управления задачами
 *    - NotificationService: сервис для отправки уведомлений
 * 
 * 2. Используйте:
 *    - Инлайн-классы для идентификаторов и типов
 *    - Делегаты свойств для ленивой инициализации и наблюдения
 *    - Объекты-синглтоны для сервисов
 *    - Делегирование классов для репозиториев
 *    - Паттерны проектирования: Builder, Observer, Strategy
 *    - DSL для создания отчетов
 */
class Exercise10 {
    // your solution
    
    // Демонстрация работы системы управления задачами
    fun demonstrateTaskManagementSystem() {
        // your solution
    }
} 