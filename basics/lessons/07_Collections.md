# Коллекции в Kotlin

Коллекции - это контейнеры, которые хранят группы объектов одного или разных типов. Kotlin предоставляет богатую библиотеку стандартных коллекций, которые можно разделить на две основные категории: изменяемые (mutable) и неизменяемые (immutable).

## Содержание

1. [Типы коллекций](#типы-коллекций)
2. [Списки (List)](#списки-list)
3. [Множества (Set)](#множества-set)
4. [Словари (Map)](#словари-map)
5. [Операции с коллекциями](#операции-с-коллекциями)
6. [Последовательности (Sequence)](#последовательности-sequence)
7. [Практические примеры](#практические-примеры)

## Типы коллекций

В Kotlin существуют следующие основные типы коллекций:

- **List** - упорядоченная коллекция элементов, доступ к которым осуществляется по индексу
- **Set** - коллекция уникальных элементов
- **Map** - коллекция пар "ключ-значение"

Каждый тип имеет две версии:
- **Неизменяемая (read-only)** - после создания нельзя изменить содержимое
- **Изменяемая (mutable)** - можно добавлять, удалять и изменять элементы

## Списки (List)

### Неизменяемые списки

```kotlin
// Создание неизменяемого списка
val numbers = listOf(1, 2, 3, 4, 5)
val emptyList = emptyList<String>() // Пустой список
val singletonList = listOf("только один элемент")

// Доступ к элементам
val firstElement = numbers[0] // 1
val secondElement = numbers.get(1) // 2

// Получение информации о списке
val size = numbers.size // 5
val containsThree = numbers.contains(3) // true
val indexOf = numbers.indexOf(4) // 3
```

### Изменяемые списки

```kotlin
// Создание изменяемого списка
val mutableNumbers = mutableListOf(1, 2, 3, 4, 5)
val arrayList = ArrayList<Int>() // Пустой ArrayList

// Изменение списка
mutableNumbers.add(6) // [1, 2, 3, 4, 5, 6]
mutableNumbers.add(0, 0) // [0, 1, 2, 3, 4, 5, 6]
mutableNumbers.remove(3) // [0, 1, 2, 4, 5, 6]
mutableNumbers[0] = 10 // [10, 1, 2, 4, 5, 6]
mutableNumbers.clear() // []
```

## Множества (Set)

Множества хранят уникальные элементы, то есть дубликаты автоматически удаляются.

### Неизменяемые множества

```kotlin
// Создание неизменяемого множества
val uniqueNumbers = setOf(1, 2, 3, 3, 4) // [1, 2, 3, 4]
val emptySet = emptySet<String>()

// Операции с множествами
val containsTwo = uniqueNumbers.contains(2) // true
val size = uniqueNumbers.size // 4
```

### Изменяемые множества

```kotlin
// Создание изменяемого множества
val mutableSet = mutableSetOf(1, 2, 3)
val hashSet = HashSet<Int>() // Пустой HashSet

// Изменение множества
mutableSet.add(4) // [1, 2, 3, 4]
mutableSet.add(2) // [1, 2, 3, 4] - дубликат не добавляется
mutableSet.remove(1) // [2, 3, 4]
```

### Операции над множествами

```kotlin
val set1 = setOf(1, 2, 3)
val set2 = setOf(3, 4, 5)

// Объединение множеств
val union = set1.union(set2) // [1, 2, 3, 4, 5]

// Пересечение множеств
val intersection = set1.intersect(set2) // [3]

// Разность множеств
val difference = set1.subtract(set2) // [1, 2]
```

## Словари (Map)

Словари хранят пары "ключ-значение", где каждый ключ уникален.

### Неизменяемые словари

```kotlin
// Создание неизменяемого словаря
val ages = mapOf(
    "Алиса" to 25,
    "Боб" to 30,
    "Карл" to 28
)
val emptyMap = emptyMap<String, Int>()

// Доступ к элементам
val bobAge = ages["Боб"] // 30
val carlAge = ages.get("Карл") // 28
val unknownAge = ages["Дэвид"] // null

// Безопасный доступ с значением по умолчанию
val davidAge = ages.getOrDefault("Дэвид", 0) // 0
val elenaAge = ages.getOrElse("Елена") { -1 } // -1

// Получение информации о словаре
val containsAlice = ages.containsKey("Алиса") // true
val containsAge35 = ages.containsValue(35) // false
val keys = ages.keys // [Алиса, Боб, Карл]
val values = ages.values // [25, 30, 28]
```

### Изменяемые словари

```kotlin
// Создание изменяемого словаря
val mutableAges = mutableMapOf(
    "Алиса" to 25,
    "Боб" to 30
)
val hashMap = HashMap<String, Int>() // Пустой HashMap

// Изменение словаря
mutableAges["Карл"] = 28 // Добавление новой пары
mutableAges.put("Дэвид", 35) // Альтернативный способ добавления
mutableAges["Алиса"] = 26 // Изменение значения
mutableAges.remove("Боб") // Удаление пары
```

## Операции с коллекциями

Kotlin предоставляет богатый набор функций для работы с коллекциями.

### Фильтрация

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// Фильтрация по условию
val evenNumbers = numbers.filter { it % 2 == 0 } // [2, 4, 6, 8, 10]
val oddNumbers = numbers.filterNot { it % 2 == 0 } // [1, 3, 5, 7, 9]

// Фильтрация не-null значений
val mixedList = listOf(1, 2, null, 4, null)
val nonNullValues = mixedList.filterNotNull() // [1, 2, 4]
```

### Преобразование

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// Преобразование каждого элемента
val doubled = numbers.map { it * 2 } // [2, 4, 6, 8, 10]
val squares = numbers.map { it * it } // [1, 4, 9, 16, 25]

// Преобразование с фильтрацией
val evenSquares = numbers.filter { it % 2 == 0 }.map { it * it } // [4, 16]
```

### Сортировка

```kotlin
val numbers = listOf(5, 2, 8, 1, 9)
val names = listOf("Зоя", "Алиса", "Дмитрий", "Борис")

// Сортировка по возрастанию
val sortedNumbers = numbers.sorted() // [1, 2, 5, 8, 9]
val sortedNames = names.sorted() // [Алиса, Борис, Дмитрий, Зоя]

// Сортировка по убыванию
val descendingNumbers = numbers.sortedDescending() // [9, 8, 5, 2, 1]

// Сортировка по заданному критерию
val sortedByLength = names.sortedBy { it.length } // [Зоя, Алиса, Борис, Дмитрий]
val sortedByLastChar = names.sortedByDescending { it.last() } // [Дмитрий, Борис, Алиса, Зоя]
```

### Агрегация

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// Суммирование
val sum = numbers.sum() // 15

// Среднее значение
val average = numbers.average() // 3.0

// Минимальное и максимальное значения
val min = numbers.minOrNull() // 1
val max = numbers.maxOrNull() // 5

// Подсчет элементов по условию
val evenCount = numbers.count { it % 2 == 0 } // 2

// Проверка условий
val allPositive = numbers.all { it > 0 } // true
val anyGreaterThan10 = numbers.any { it > 10 } // false
val noneNegative = numbers.none { it < 0 } // true
```

### Группировка

```kotlin
val people = listOf(
    Person("Алиса", 25),
    Person("Боб", 30),
    Person("Карл", 25),
    Person("Дэвид", 30)
)

// Группировка по возрасту
val byAge = people.groupBy { it.age }
// {
//   25: [Person(name=Алиса, age=25), Person(name=Карл, age=25)],
//   30: [Person(name=Боб, age=30), Person(name=Дэвид, age=30)]
// }

// Группировка с преобразованием
val namesByAge = people.groupBy({ it.age }, { it.name })
// {
//   25: [Алиса, Карл],
//   30: [Боб, Дэвид]
// }
```

### Объединение и разделение

```kotlin
val list1 = listOf(1, 2, 3)
val list2 = listOf(4, 5, 6)

// Объединение списков
val combined = list1 + list2 // [1, 2, 3, 4, 5, 6]

// Разделение списка
val (even, odd) = numbers.partition { it % 2 == 0 }
// even = [2, 4, 6, 8, 10], odd = [1, 3, 5, 7, 9]

// Объединение элементов в строку
val joined = numbers.joinToString(", ") // "1, 2, 3, 4, 5"
val customJoined = numbers.joinToString(
    separator = " | ",
    prefix = "[",
    postfix = "]"
) // "[1 | 2 | 3 | 4 | 5]"
```

## Последовательности (Sequence)

Последовательности похожи на коллекции, но обрабатывают элементы лениво (по одному), что может быть более эффективно для больших наборов данных и цепочек операций.

```kotlin
val numbers = sequenceOf(1, 2, 3, 4, 5)
val fromList = listOf(1, 2, 3).asSequence()

// Генерация последовательности
val fibonacci = generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }
    .map { it.first }
    .take(10)
    .toList() // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]

// Эффективная обработка с помощью последовательностей
val result = numbers
    .filter { println("Фильтрация $it"); it % 2 == 0 }
    .map { println("Отображение $it"); it * it }
    .take(1)
    .toList() // Выполнится только необходимый минимум операций
```

## Практические примеры

### Пример 1: Анализ текста

```kotlin
fun analyzeText(text: String): Map<String, Any> {
    val words = text.split(Regex("\\s+"))
        .map { it.lowercase().trim(',', '.', '!', '?', '"', '\'') }
        .filter { it.isNotEmpty() }
    
    return mapOf(
        "wordCount" to words.size,
        "uniqueWords" to words.toSet().size,
        "mostFrequentWord" to words.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key,
        "wordLengths" to words.map { it.length }.average()
    )
}

val result = analyzeText("Kotlin - это современный язык программирования. Kotlin очень выразительный и безопасный.")
// {
//   wordCount: 11,
//   uniqueWords: 10,
//   mostFrequentWord: "kotlin",
//   wordLengths: 6.45
// }
```

### Пример 2: Обработка данных о студентах

```kotlin
data class Student(val name: String, val age: Int, val grades: List<Int>)

fun processStudents(students: List<Student>): Map<String, Any> {
    return mapOf(
        "averageAge" to students.map { it.age }.average(),
        "topStudents" to students
            .filter { it.grades.average() >= 4.5 }
            .sortedByDescending { it.grades.average() }
            .map { it.name },
        "gradeDistribution" to students
            .flatMap { it.grades }
            .groupingBy { it }
            .eachCount()
    )
}

val students = listOf(
    Student("Алиса", 20, listOf(5, 4, 5, 5)),
    Student("Боб", 22, listOf(3, 4, 3, 4)),
    Student("Карл", 21, listOf(5, 5, 5, 4))
)

val analysis = processStudents(students)
// {
//   averageAge: 21.0,
//   topStudents: [Карл, Алиса],
//   gradeDistribution: {3: 2, 4: 4, 5: 6}
// }
```

### Пример 3: Работа с вложенными коллекциями

```kotlin
data class Department(val name: String, val employees: List<Employee>)
data class Employee(val name: String, val salary: Double)

fun analyzeDepartments(departments: List<Department>): Map<String, Any> {
    return mapOf(
        "departmentCount" to departments.size,
        "totalEmployees" to departments.sumOf { it.employees.size },
        "averageSalaryByDepartment" to departments.associate { dept ->
            dept.name to dept.employees.map { it.salary }.average()
        },
        "highestPaidEmployee" to departments
            .flatMap { it.employees }
            .maxByOrNull { it.salary }?.name
    )
}

val departments = listOf(
    Department("IT", listOf(
        Employee("Алиса", 120000.0),
        Employee("Боб", 110000.0)
    )),
    Department("Маркетинг", listOf(
        Employee("Карл", 95000.0),
        Employee("Дэвид", 100000.0)
    ))
)

val analysis = analyzeDepartments(departments)
// {
//   departmentCount: 2,
//   totalEmployees: 4,
//   averageSalaryByDepartment: {IT: 115000.0, Маркетинг: 97500.0},
//   highestPaidEmployee: Алиса
// }
```

## Заключение

Коллекции в Kotlin предоставляют мощный и гибкий инструментарий для работы с группами данных. Благодаря богатой стандартной библиотеке и функциональному подходу, вы можете писать лаконичный и выразительный код для решения сложных задач обработки данных.

Важно выбирать подходящий тип коллекции в зависимости от требований вашей задачи:
- Используйте `List`, когда важен порядок элементов и возможны дубликаты
- Используйте `Set`, когда нужно хранить только уникальные элементы
- Используйте `Map`, когда данные представлены в виде пар "ключ-значение"
- Используйте `Sequence` для эффективной обработки больших наборов данных

Также помните о различии между изменяемыми и неизменяемыми коллекциями, и предпочитайте неизменяемые коллекции, когда это возможно, для обеспечения безопасности и предсказуемости вашего кода. 