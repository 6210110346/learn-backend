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
    def show() {
        def result = [valid: false]
        def id = params.id as long
        def book = Book.get(id)

        result.data = book
        result.valid = true
        
        render(result as JSON)
    }

    def save(){
        def result = [valid: false]
        def book = new Book(request.JSON)

        book.save(failonError: true)
        result.data = book.save()
        result.valid = true

        render(result as JSON)   
    }

    def update(){
        def result = [valid: false]
        def id = params.id as long
        def book = Book.get(id)

        bindData(book, request.JSON)
        book.save(flush: true)
        result.valid = true
        result.data = book
        
        render(result as JSON)
    }

    def delete(){
        def result = [valid: false]
        def id = params.id as long
        def book = Book.get(id)
        book.delete(flush: true)
        result.valid = true
        render(result as JSON)
    }
}
