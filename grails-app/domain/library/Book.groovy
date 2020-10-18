package library

class Book {
    String titleTH
    String titleENG
    String author
    double price

    static belongsTo = [category: BookCategory]
    static hasMany = [bookAuthors: BookAuthor]

    static constraints = {
    }
}