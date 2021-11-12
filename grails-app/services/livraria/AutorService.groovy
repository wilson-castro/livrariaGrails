package livraria

import grails.gorm.services.Service

@Service(Autor)
interface AutorService {

    Autor get(Serializable id)

    List<Autor> list(Map args)

    Long count()

    void delete(Serializable id)

    Autor save(Autor autor)

}