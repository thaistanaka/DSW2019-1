package br.ufscar.dc.dsw

import grails.rest.Resource

@Resource(uri='/promocao', readOnly = false, formats = ['json', 'xml'])
class Promocao {

    static constraints = {
         site nullable: false
         teatro nullable: false
         nome blank: false
         preco blank: false
         dia blank: false
         hora blank: false
    }

    Site site
    Teatro teatro
    String nome
    String preco
    String dia
    String hora
}