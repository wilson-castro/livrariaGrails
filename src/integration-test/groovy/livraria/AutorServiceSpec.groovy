package livraria

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AutorServiceSpec extends Specification {

    AutorService autorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Autor(...).save(flush: true, failOnError: true)
        //new Autor(...).save(flush: true, failOnError: true)
        //Autor autor = new Autor(...).save(flush: true, failOnError: true)
        //new Autor(...).save(flush: true, failOnError: true)
        //new Autor(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //autor.id
    }

    void "test get"() {
        setupData()

        expect:
        autorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Autor> autorList = autorService.list(max: 2, offset: 2)

        then:
        autorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        autorService.count() == 5
    }

    void "test delete"() {
        Long autorId = setupData()

        expect:
        autorService.count() == 5

        when:
        autorService.delete(autorId)
        sessionFactory.currentSession.flush()

        then:
        autorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Autor autor = new Autor()
        autorService.save(autor)

        then:
        autor.id != null
    }
}
