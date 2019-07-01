package server

import br.ufscar.dc.dsw.Teatro
import br.ufscar.dc.dsw.Site
import br.ufscar.dc.dsw.Promocao
class BootStrap {

    def init = { servletContext ->

    Teatro t = new Teatro(email:'a@a', senha:'a',cnpj:'123',nome:'a',cidade:'a')

    t.save()

    
    Site s = new Site(email:'a@bol', senha:'a',endereco:'zurprise.org',nome:'a',telefone:'a')

    s.save()

    
    Promocao p = new Promocao(site:s, teatro:t, nome:'Europa, um pais da europa',preco:'8000',dia:'23/2/1853',hora:'20:51')

    p.save()

    }
    def destroy = {
    }
}
