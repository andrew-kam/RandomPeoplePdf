## RandomPeoplePdf  
Консольное приложения, которое создает PDF файл с данными случайных людей.

Генерируются следующие данные:
- Имя
- Фамилия
- Отчество
- Возраст
- Пол
- Дата рождения
- Место рождения
- _Место проживания_ (индекс, страна, область, город, улица, дом, квартира)

Количество людей для генерации данных задается пользователем, в пределах 30 человек.  
Сгенерированные данные выводятся на одном листе формата А4.

### Источник данных
Исходные данные для генерации представлены в виде констант и расположены в файле `Constants`  
Локальное расположение данных для генерации обеспечивает приложению стабильность и независимость от внешних источников.    
Независимая генерация полей позволяет создавать более чем достаточное количество уникальных наборов данных.

### Генерация данных
Генерацию данных производит метод `generateData` класса `GenerateDataPerson`,
который возвращает набор данных на одного человека.  
При генерации ФИО учитывается пол.  
Дата рождения и возраст генерируются вспомогательными функциями и соответствуют друг другу.  
Область и город проживания часто могут не соответствовать друг другу, по условиям задачи соответствие не требовалось.

### Создание PDF файла
Создание PDF файла производит метод `createFile` класса `CreateFilePdf`.  
Данный метод принимает:
- настройки для создания файла в виде объекта дата-класса `FileSettings`
- объект генератор данных, класса `GenerateData`
- количество строк таблицы

### Интерфейсы
Обращение к классам `GenerateDataPerson` и `CreateFilePdf` происходит через интерфейсы
`GenerateData` и `CreateFile` соответственно.

### Порядок работы приложения
Запуск приложения происходит стандартно, через функцию `main`  
Шаги:
- функция `main` вызывает вспомогательную функцию `inputIntNumber`, которая считывает данные из консоли и возвращает
  значение типа `Int` если введенное значение соответствует типу, если нет - ноль
- затем полученное значение проверяется на принадлежность диапазону 1..30, если нет - работа приложения завершается
- вызывается метод `createFile`
- метод `createFile` создает PDF файл, используя переданные настройки
- в файл первой строкой записываются наименования полей, затем в цикле вызывается метод `generateData`
  переданного генератора данных, возвращаемые данные записываются в файл построчно
- по завершению работы выводится сообщение с указанием абсолютного пути созданного файла, при повторном использовании
  приложения ранее созданный файл будет перезаписан
