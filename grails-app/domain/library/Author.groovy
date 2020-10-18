package library

class Author {

    String titleTH
    String titleENG
    int age

    static hasMany = [bookAuthors: BookAuthor]

    static constraints = {
    }
}
