package br.ufscar.dc.dsw

import grails.rest.Resource

@Resource(uri='/teatro', readOnly = false, formats = ['json', 'xml'])
class Teatro {

    static constraints = {
         email blank: false
         senha blank: false
         cnpj blank: false
         nome blank: false
         cidade blank: false
    }

    String email
    String senha
    String cnpj
    String nome
    String cidade
}