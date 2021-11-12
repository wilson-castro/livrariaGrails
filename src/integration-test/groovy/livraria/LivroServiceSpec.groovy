package livraria

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LivroServiceSpec extends Specification {

    LivroService livroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Livro(...).save(flush: true, failOnError: true)
        //new Livro(...).save(flush: true, failOnError: true)
        //Livro livro = new Livro(...).save(flush: true, failOnError: true)
        //new Livro(...).save(flush: true, failOnError: true)
        //new Livro(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //livro.id
    }

    void "test get"() {
        setupData()

        expect:
        livroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Livro> livroList = livroService.list(max: 2, offset: 2)

        then:
        livroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        livroService.count() == 5
    }

    void "test delete"() {
        Long livroId = setupData()

        expect:
        livroService.count() == 5

        when:
        livroService.delete(livroId)
        sessionFactory.currentSession.flush()

        then:
        livroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Livro livro = new Livro()
        livroService.save(livro)

        then:
        livro.id != null
    }
}
