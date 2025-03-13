/**
 * Задания по теме "Обработка ошибок в Kotlin"
 */

/**
 * Задача 1: Try-Catch блок
 * 
 * Создайте функцию, которая пытается преобразовать строку в число.
 * Если преобразование невозможно, функция должна вернуть null.
 */
class Solution1 {
    fun parseIntSafely(input: String): Int? {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateParseIntSafely(): List<String> {
        // your solution
    }
}

/**
 * Задача 2: Множественные блоки catch
 * 
 * Создайте функцию, которая делит одно число на другое.
 * Обработайте отдельно исключения ArithmeticException (деление на ноль)
 * и NumberFormatException (если входные строки не являются числами).
 */
class Solution2 {
    fun divideStringSafely(numerator: String, denominator: String): String {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateDivideStringSafely(): List<String> {
        // your solution
    }
}

/**
 * Задача 3: Finally блок
 * 
 * Создайте функцию, которая имитирует работу с ресурсом (например, файлом).
 * Используйте блок finally для "закрытия" ресурса, независимо от того,
 * произошло исключение или нет.
 */
class Solution3 {
    class Resource(val name: String) {
        var isOpen = false
        
        fun open() {
            isOpen = true
            println("Ресурс $name открыт")
        }
        
        fun close() {
            isOpen = false
            println("Ресурс $name закрыт")
        }
        
        fun use(): String {
            if (!isOpen) throw IllegalStateException("Ресурс не открыт")
            return "Используется ресурс $name"
        }
    }
    
    fun useResourceSafely(resource: Resource): String {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateUseResourceSafely(): List<String> {
        // your solution
    }
}

/**
 * Задача 4: Use функция
 * 
 * Создайте класс, реализующий интерфейс Closeable.
 * Используйте функцию use для автоматического закрытия ресурса.
 */
class Solution4 {
    class AutoCloseableResource(val name: String) : java.io.Closeable {
        init {
            println("Ресурс $name создан")
        }
        
        fun use(): String {
            return "Используется ресурс $name"
        }
        
        override fun close() {
            println("Ресурс $name закрыт")
        }
    }
    
    fun useResourceWithUseFunction(name: String): String {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateUseFunction(): String {
        // your solution
    }
}

/**
 * Задача 5: Создание собственных исключений
 * 
 * Создайте собственный класс исключения InvalidAgeException.
 * Создайте функцию, которая проверяет возраст и выбрасывает это исключение,
 * если возраст отрицательный или больше 150.
 */
class Solution5 {
    class InvalidAgeException(message: String) : Exception(message)
    
    fun validateAge(age: Int): String {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateValidateAge(): List<String> {
        // your solution
    }
}

/**
 * Задача 6: Проброс исключений
 * 
 * Создайте функцию, которая вызывает другую функцию, которая может выбросить исключение.
 * Пробросьте это исключение вызывающему коду.
 */
class Solution6 {
    fun riskyOperation(input: String): Int {
        if (input.isEmpty()) throw IllegalArgumentException("Входная строка не может быть пустой")
        return input.length * 2
    }
    
    fun performOperation(input: String): Int {
        // your solution
    }
    
    // Пример использования функции
    fun demonstratePerformOperation(): List<String> {
        // your solution
    }
}

/**
 * Задача 7: Result класс
 * 
 * Создайте функцию, которая возвращает объект Result,
 * содержащий либо успешный результат, либо исключение.
 */
class Solution7 {
    fun divideWithResult(a: Int, b: Int): Result<Int> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateDivideWithResult(): List<String> {
        // your solution
    }
}

/**
 * Задача 8: runCatching функция
 * 
 * Используйте функцию runCatching для выполнения операции, которая может выбросить исключение.
 * Обработайте результат с помощью функций onSuccess и onFailure.
 */
class Solution8 {
    fun parseJson(json: String): Map<String, Any> {
        if (!json.startsWith("{") || !json.endsWith("}")) {
            throw IllegalArgumentException("Неверный формат JSON")
        }
        // Простая имитация парсинга JSON
        return mapOf("result" to "parsed")
    }
    
    fun parseJsonSafely(json: String): String {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateParseJsonSafely(): List<String> {
        // your solution
    }
}

/**
 * Задача 9: Преобразование Result
 * 
 * Создайте цепочку операций с использованием Result и функций map, flatMap и recover.
 */
class Solution9 {
    fun fetchUser(userId: Int): Result<String> {
        return if (userId > 0) {
            Result.success("User$userId")
        } else {
            Result.failure(IllegalArgumentException("Неверный ID пользователя"))
        }
    }
    
    fun fetchUserData(user: String): Result<Map<String, String>> {
        return if (user.startsWith("User")) {
            Result.success(mapOf("name" to user, "email" to "$user@example.com"))
        } else {
            Result.failure(IllegalArgumentException("Неверный пользователь"))
        }
    }
    
    fun processUserData(userId: Int): Result<String> {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateProcessUserData(): List<String> {
        // your solution
    }
}

/**
 * Задача 10: Null Safety
 * 
 * Создайте функцию, которая безопасно обрабатывает цепочку вызовов,
 * которые могут вернуть null, используя оператор ?. и функцию let.
 */
class Solution10 {
    data class Address(val street: String?, val city: String?, val zipCode: String?)
    data class User(val name: String, val address: Address?)
    data class Company(val name: String, val owner: User?)
    
    fun getZipCode(company: Company?): String {
        // your solution
    }
    
    // Пример использования функции
    fun demonstrateGetZipCode(): List<String> {
        // your solution
    }
} 