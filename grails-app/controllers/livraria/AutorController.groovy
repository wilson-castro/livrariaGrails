package livraria

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AutorController {

    AutorService autorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond autorService.list(params), model:[autorCount: autorService.count()]
    }

    def show(Long id) {
        respond autorService.get(id)
    }

    def create() {
        respond new Autor(params)
    }

    def save(Autor autor) {
        if (autor == null) {
            notFound()
            return
        }

        try {
            autorService.save(autor)
        } catch (ValidationException e) {
            respond autor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'autor.label', default: 'Autor'), autor.id])
                redirect autor
            }
            '*' { respond autor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond autorService.get(id)
    }

    def update(Autor autor) {
        if (autor == null) {
            notFound()
            return
        }

        try {
            autorService.save(autor)
        } catch (ValidationException e) {
            respond autor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'autor.label', default: 'Autor'), autor.id])
                redirect autor
            }
            '*'{ respond autor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        autorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'autor.label', default: 'Autor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'autor.label', default: 'Autor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
