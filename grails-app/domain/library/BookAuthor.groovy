package library

class BookAuthor {

    static belongsTo = [book: Book, author: Author]
    
    static constraints = {
    }
}
