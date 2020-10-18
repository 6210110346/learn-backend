package library


import grails.rest.*
import grails.converters.*

class BookController {
	static responseFormats = ['json']
	
    def index() { 
        def result = [valid: false]
        def books = Book.list()
        def totalCount = Book.count()

        result.data = books
        result.totalCount = totalCount
        result.valid = true

        render(result as JSON)
    }
    def show(long id) {
        def result = [valid: false]        
        def book = Book.get(id)

        result.data = book
        result.valid = true

        render(result as JSON)
    }

    def save(Book book){
        def result = [valid: false]

        book.save(failonError: true)
        result.data = book.save()
        result.valid = true

        render(result as JSON)   
    }

    def update(Book book){
        def result = [valid: false]

        book.save(flush: true)
        result.valid = true
        result.data = book
        
        render(result as JSON)
    }

    def delete(long id){
        def result = [valid: false]
        def book = Book.get(id)
        book.delete(flush: true)
        result.valid = true
        render(result as JSON)
    }
}
