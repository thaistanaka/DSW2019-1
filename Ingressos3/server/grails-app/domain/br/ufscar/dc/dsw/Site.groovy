package br.ufscar.dc.dsw

import grails.rest.Resource

@Resource(uri='/site', readOnly = false, formats = ['json', 'xml'])
class Site {

    static constraints = {
         email blank: false
         senha blank: false
         endereco blank: false
         nome blank: false
         telefone blank: false
    }

    String email
    String senha
    String endereco
    String nome
    String telefone
}