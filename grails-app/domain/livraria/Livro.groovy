package livraria

class Livro {

    String titulo
    Float valor
    Autor autor

    static belongsTo = [Autor]

    static constraints = {
        titulo maxSize: 80, blank: false
        valor min: 1.0f
    }

    String toString(){
        titulo
    }
}
