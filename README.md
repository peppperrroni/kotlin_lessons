# Курс по Kotlin

Этот репозиторий содержит материалы для изучения языка программирования Kotlin, включая базовые концепции и углубленное изучение объектно-ориентированного программирования.

## Структура курса

### Базовые уроки

Основы языка Kotlin находятся в директории `basics/lessons`:

1. [Переменные и типы данных](basics/lessons/01_Variables_and_DataTypes.md)
2. [Операторы](basics/lessons/02_Operators.md)
3. [Условные выражения](basics/lessons/03_Conditionals.md)
4. [Циклы](basics/lessons/04_Loops.md)
5. [Функции](basics/lessons/05_Functions.md)
6. [Лямбда-выражения](basics/lessons/06_Lambdas.md)
7. [Коллекции](basics/lessons/07_Collections.md)
8. [Обработка ошибок](basics/lessons/08_ErrorHandling.md)
9. [Классы и объекты](basics/lessons/09_Classes.md)

### Углубленное ООП

Теоретические материалы по углубленному ООП находятся в директории `oop/lessons`:

1. [Углубленное изучение классов и объектов](oop/lessons/01_Advanced_Classes_and_Objects.md)
2. [Наследование и интерфейсы](oop/lessons/02_Inheritance_and_Interfaces.md)
3. [Дженерики (обобщения)](oop/lessons/03_Generics.md)
4. [Расширения и функциональное программирование](oop/lessons/04_Extensions_and_Functional.md)
5. [Корутины и асинхронное программирование](oop/lessons/05_Coroutines.md)

### Практические задания

Задания для самостоятельной работы находятся в директориях:

#### Базовые задания
1. [Задания по переменным и типам данных](basics/exercises/01_Variables_and_DataTypes.kt)
2. [Задания по операторам](basics/exercises/02_Operators.kt)
3. [Задания по условным выражениям](basics/exercises/03_Conditionals.kt)
4. [Задания по циклам](basics/exercises/04_Loops.kt)
5. [Задания по функциям](basics/exercises/05_Functions.kt)
6. [Задания по лямбда-выражениям](basics/exercises/06_Lambdas.kt)
7. [Задания по коллекциям](basics/exercises/07_Collections.kt)
8. [Задания по обработке ошибок](basics/exercises/08_ErrorHandling.kt)
9. [Задания по классам и объектам](basics/exercises/09_Classes.kt)

#### Углубленные задания по ООП
1. [Задания по углубленному изучению классов и объектов](oop/exercises/01_Advanced_Classes.kt)
2. [Задания по наследованию и интерфейсам](oop/exercises/02_Inheritance_and_Interfaces.kt)
3. [Задания по дженерикам (обобщениям)](oop/exercises/03_Generics.kt)
4. [Задания по расширениям и функциональному программированию](oop/exercises/04_Extensions_and_Functional.kt)
5. [Задания по корутинам и асинхронному программированию](oop/exercises/05_Coroutines.kt)

## Как использовать материалы

1. Начните с изучения базовых концепций Kotlin в директории `basics/lessons`
2. После освоения основ переходите к углубленному изучению ООП в директории `oop/lessons`
3. Выполняйте практические задания для закрепления материала
4. Используйте дополнительные ресурсы для расширения знаний

## Требования

- Kotlin 1.5.0 или выше
- JDK 11 или выше
- Любая IDE с поддержкой Kotlin (рекомендуется IntelliJ IDEA)
- Для заданий по корутинам: библиотека kotlinx-coroutines-core версии 1.6.4 или выше

## Темы курса

### Базовые темы

1. **Переменные и типы данных**
   - Объявление переменных (val, var)
   - Базовые типы данных
   - Преобразование типов
   - Строки и операции со строками
   - Шаблоны строк

2. **Операторы**
   - Арифметические операторы
   - Операторы сравнения
   - Логические операторы
   - Побитовые операторы
   - Операторы присваивания

3. **Условные выражения**
   - Условные выражения (if-else)
   - Выражение when
   - Условные выражения как выражения

4. **Циклы**
   - Циклы for
   - Циклы while и do-while
   - Диапазоны и прогрессии
   - Операторы перехода (break, continue, return)

5. **Функции**
   - Объявление и вызов функций
   - Параметры и возвращаемые значения
   - Функции с переменным числом аргументов
   - Параметры по умолчанию
   - Именованные аргументы
   - Однострочные функции
   - Локальные функции

6. **Лямбда-выражения**
   - Основы лямбда-выражений
   - Функции высшего порядка
   - Замыкания
   - Встроенные функции высшего порядка

7. **Коллекции**
   - Списки, множества, словари
   - Изменяемые и неизменяемые коллекции
   - Операции с коллекциями
   - Последовательности

8. **Обработка ошибок**
   - Исключения и их типы
   - Блоки try-catch-finally
   - Выбрасывание исключений
   - Проверяемые и непроверяемые исключения

9. **Классы и объекты**
   - Объявление классов
   - Конструкторы
   - Свойства и методы
   - Модификаторы доступа
   - Наследование
   - Интерфейсы
   - Абстрактные классы
   - Data классы
   - Enum классы

### Углубленные темы ООП

1. **Углубленное изучение классов и объектов**
   - Порядок инициализации
   - Фабричные методы
   - Ленивая инициализация
   - Делегирование свойств
   - Объекты и объекты-компаньоны
   - Вложенные и внутренние классы
   - Инлайн-классы
   - Деструктурирующие объявления
   - Делегирование классов
   - Типобезопасные строители (DSL)

2. **Наследование и интерфейсы**
   - Базовое наследование
   - Переопределение свойств
   - Абстрактные классы
   - Интерфейсы
   - Множественные интерфейсы
   - Интерфейсы с реализацией по умолчанию
   - Разрешение конфликтов при множественном наследовании
   - Делегирование интерфейсов
   - Запечатанные классы
   - Комбинирование наследования и интерфейсов

3. **Дженерики (обобщения)**
   - Базовые дженерики
   - Ограничения типов
   - Обобщенные функции
   - Вариантность
   - Звездочная проекция
   - Обобщенные расширения
   - Обобщенные делегаты свойств
   - Обобщенные алгоритмы
   - Рекурсивные обобщенные типы
   - Практическое применение дженериков

4. **Расширения и функциональное программирование**
   - Функции-расширения
   - Свойства-расширения
   - Функции высшего порядка
   - Лямбда-выражения и анонимные функции
   - Функции-ссылки и ссылки на конструкторы
   - Встроенные функции высшего порядка
   - Последовательности и ленивые вычисления
   - Функциональные интерфейсы и SAM-преобразования
   - Комбинирование функциональных подходов

5. **Корутины и асинхронное программирование**
   - Основы корутин
   - Билдеры корутин
   - Контекст и диспетчеры
   - Job и структурированная конкурентность
   - Отмена и таймауты
   - Каналы
   - Flow
   - Исключения и обработка ошибок
   - Совместное использование состояния
   - Практическое применение корутин

## Дополнительные ресурсы

- [Официальная документация Kotlin](https://kotlinlang.org/docs/home.html)
- [Kotlin Koans](https://play.kotlinlang.org/koans/overview)
- [Kotlin by Example](https://play.kotlinlang.org/byExample/overview)
- [Kotlin Design Patterns](https://github.com/dbacinski/Design-Patterns-In-Kotlin)
- [Документация по корутинам](https://kotlinlang.org/docs/coroutines-overview.html)

## Лицензия

Материалы курса распространяются под лицензией MIT. Подробности в файле [LICENSE](LICENSE). 