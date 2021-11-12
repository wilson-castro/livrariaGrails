package livraria

import grails.gorm.services.Service

@Service(Livro)
interface LivroService {

    Livro get(Serializable id)

    List<Livro> list(Map args)

    Long count()

    void delete(Serializable id)

    Livro save(Livro livro)

}