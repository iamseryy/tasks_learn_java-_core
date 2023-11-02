## Задача 5 Тонкости работы

Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
В решении не использовать циклы! Только StreamAPI
```
class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

        public double getAverageGrade() {...}

        }
```

>В помощь -> https://struchkov.dev/blog/ru/java-stream-api/
http://www.arvifox.com/wp-content/uploads/2015/12/java-tips-4.pdf (оригинальная статья скрыта, есть только пдф)