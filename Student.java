import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {


    public class Book{
        String name;
        int year;
        int pages;
        int index;


        public boolean equals(Object obj){
            Book book = (Book) obj;
            return this.name == book.name &&
                    this.year == book.year &&
                    this.pages == book.pages &&
                    this.index == book.index;
        }

        public int hashCode() {
            int ret;
            ret = Objects.hash(year);
            ret+= Objects.hash(name);
            ret+= Objects.hash(pages);
            ret+= Objects.hash(index);
            return ret;
        }

        Book(String name,int year, int pages,int index) {
            this.name = name;
            this.year = year;
            this.pages = pages;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        public int getPages() {
            return pages;
        }

        public int getIndex() {
            return index;
        }

    }


    String name;
    List<Book> books=new ArrayList<>();;



    Student(String name, int[] BookIndex){
        this.name=name;
        this.giveBooks(BookIndex);
    }

    public static void main(String[] args) {
        Student[] schoolars=new Student[10];

        schoolars[0]=new Student("Вася", new int[]{0});
        schoolars[1]=new Student("Вика", new int[]{6, 7, 8, 9, 10});
        schoolars[2]=new Student("Коля", new int[]{4, 2, 10, 9, 3, 2,7,1});
        schoolars[3]=new Student("Даша", new int[]{1, 5, 2, 4, 3});
        schoolars[4]=new Student("Настя", new int[]{1, 2, 2, 4, 5, 4,2,2,1});
        schoolars[5]=new Student("Кирил", new int[]{5, 3, 9, 8, 8, 3});
        schoolars[6]=new Student("Ваcя", new int[]{1, 10, 2, 7, 6, 4,2});
        schoolars[7]=new Student("Денис", new int[]{1, 2, 9, 10, 3, 4,5,6});
        schoolars[8]=new Student("Рита", new int[]{1, 2, 3, 4, 5, 6,7,8,9,10});
        schoolars[9]=new Student("Никита", new int[]{0,3, 3, 3, 10, 9});





        List<Student> students = List.of(schoolars);


        Stream.of(schoolars)
                .peek(student -> System.out.println(student))
                .peek(student -> student.giveBooks(new int[]{0}))
                .flatMap(student -> student.books.stream())
                .distinct()
                .sorted(Comparator.comparing(Book::getPages))
                .toList()
                .stream().filter(book -> book.year>2000)
                //.peek(book -> System.out.println(book.name + " " + book.pages))

                .limit(3)

                //.peek(book -> System.out.println(book.year))

                .map(Book::getYear)

                .findFirst()
                .map(year -> "Год выпуска найденной книги: " + year)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Книга отсутствует")
                );




                //.forEach(book -> {});




        //schoolars[0].show(schoolars);
        //schoolars[0].dev_show(schoolars);
    }

    public Student giveBooks( int[] BookIndex)
    {
        for(int i:BookIndex)
        {
            switch (i){
                case 0:
                    books.add(new Book("Комикс Человек Паук", 2001, 17 ,0));break;
                case 1:
                    books.add(new Book("Учебник по Литературе", 2007, 127,1 ));break;
                case 2:
                    books.add(new Book("Учебник по Математике", 2010, 64 ,2));break;
                case 3:
                    books.add(new Book("Учебник по Русскому языку", 1999, 75 ,3));break;
                case 4:
                    books.add(new Book("Учебник по обществознанию", 2022, 113 ,4));break;
                case 5:
                    books.add(new Book("Учебник по ОБЖ", 1987, 88 ,5));break;
                case 6:
                    books.add(new Book("Учебник по Физике", 2010, 69 ,6));break;
                case 7:
                    books.add(new Book("Учебник по Химии", 2017, 54 ,7));break;
                case 8:
                    books.add(new Book("Учебник по Геометрии", 2000, 82 ,8));break;
                case 9:
                    books.add(new Book("Учебник по Биологии", 1996, 107 ,9));break;
                case 10:
                    books.add(new Book("Учебник по Географии", 2025, 91 ,10));break;
            }
        }
        return this;
    }


    public String toString(){
        String bookCollection = "Коллекция книг: ";
        for(Book j: books)
        {
            bookCollection+= "{ Название книги: "+ j.getName() + "; Год выпуска: "+j.getYear()+"; Кол-во страниц: "+j.getPages()+". }  ";
        }
        return "Имя студент(а/ки): " + name +";   "+bookCollection;
    }

    public String dev_toString(){
        String bookCollection = " ";
        for(Book j: books)
        {
            bookCollection+= "{"+ j.getIndex() + " "+j.getYear()+" "+j.getPages()+"}  ";
        }
        return bookCollection;
    }

    public void show(Student[] schoolars){
        for(Student std:schoolars)
        {
            System.out.println(std.toString());
        }
    }


    public void dev_show(Student[] schoolars){
        for(Student std:schoolars)
        {
            System.out.println(std.name+" "+std.dev_toString());
        }
    }
}
