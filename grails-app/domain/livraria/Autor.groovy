package livraria

class Autor {

    String nome
    Date nascimento
    Integer toLivros

    static transients = ["toLivros"]

    static hasMany = [livros: Livro]


    static constraints = {
        nome maxSize: 80, blank: false
        nascimento nullable: false
    }

    Integer getToLivtos(){
        def autor = findByNome(this.nome)
        def livro = Livro.findAllByAutor(autor)

        return livro.size()
    }

    private void setToLivros(Integer i){}

    String toString(){
        nome
    }
}
