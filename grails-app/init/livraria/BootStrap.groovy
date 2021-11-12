package livraria

class BootStrap {

    def init = { servletContext ->

        new Usuario(nome: "Administrador", login: "admin", senha: "grails").save()

        def usuario = Usuario.findAll()
        println usuario.size()
    }
    def destroy = {
    }
}
