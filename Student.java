import java.util.List;

public class Student {


    public class Book{
        String name;
        int year;
        int pages;





        Book(String name,int year, int pages) {
            this.name = name;
            this.year = year;
            this.pages = pages;
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
    }


    String name;
    List<Book> books;



    Student(String name, int[] BookIndex){
        this.name=name;
        this.giveBooks(BookIndex);
    }

    public static void main(String[] args) {
        Student[] schoolars=new Student[10];
        schoolars[0]=new Student("Вася", new int[]{1, 2, 6, 4, 5, 2});
        schoolars[1]=new Student("Вика", new int[]{6, 7, 8, 9, 10});
        schoolars[2]=new Student("Коля", new int[]{4, 2, 10, 9, 3, 2,7,1});
        schoolars[3]=new Student("Даша", new int[]{1, 5, 2, 4, 3});
        schoolars[4]=new Student("Настя", new int[]{1, 2, 2, 4, 5, 4,2,2,1});
        schoolars[5]=new Student("Кирил", new int[]{5, 3, 9, 8, 8, 3});
        schoolars[6]=new Student("Ваня", new int[]{1, 10, 2, 7, 6, 4,2});
        schoolars[7]=new Student("Денис", new int[]{1, 2, 9, 10, 3, 4,5,6});
        schoolars[8]=new Student("Рита", new int[]{1, 2, 3, 4, 5, 6,7,8,9,10});
        schoolars[9]=new Student("Никита", new int[]{0,3, 3, 3, 10, 9});

        System.out.println(schoolars[3].toString());
    }

    public void giveBooks( int[] BookIndex)
    {
        for(int i:BookIndex)
        {
            switch (i){
                case 0:
                    books.add(new Book("Комикс Человек Паук", 2001, 17 ));
                case 1:
                    books.add(new Book("Учебник по Литературе", 2007, 127 ));
                case 2:
                    books.add(new Book("Учебник по Математике", 2010, 64 ));
                case 3:
                    books.add(new Book("Учебник по Русскому языку", 1999, 75 ));
                case 4:
                    books.add(new Book("Учебник по обществознанию", 2022, 113 ));
                case 5:
                    books.add(new Book("Учебник по ОБЖ", 1987, 88 ));
                case 6:
                    books.add(new Book("Учебник по Физике", 2010, 69 ));
                case 7:
                    books.add(new Book("Учебник по Химии", 2017, 54 ));
                case 8:
                    books.add(new Book("Учебник по Геометрии", 2000, 82 ));
                case 9:
                    books.add(new Book("Учебник по Биологии", 1996, 107 ));
                case 10:
                    books.add(new Book("Учебник по Географии", 2025, 91 ));
            }
        }
    }


    public String toString(){
        String bookCollection = "Коллекция книг: ";
        for(Book j: books)
        {
            bookCollection+= "{ Название книги: "+ j.getName() + "; Год выпуска: "+j.getYear()+"; Кол-во страниц: "+j.getPages()+". }";
        }
        return "Student name: " + name +";   "+bookCollection;
    }
}
