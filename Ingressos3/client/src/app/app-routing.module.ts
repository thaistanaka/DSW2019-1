import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TeatrosComponent } from './components/teatros/teatros.component';
import { TeatroCadastroComponent } from './components/teatro-cadastro/teatro-cadastro.component';
import { TeatroDetalhesComponent } from './components/teatro-detalhes/teatro-detalhes.component';
import { TeatroEdicaoComponent } from './components/teatro-edicao/teatro-edicao.component';
import { SitesComponent } from './components/sites/sites.component';
import { SiteCadastroComponent } from './components/site-cadastro/site-cadastro.component';
import { SiteDetalhesComponent } from './components/site-detalhes/site-detalhes.component';
import { SiteEdicaoComponent } from './components/site-edicao/site-edicao.component';
import { PromocoesComponent } from './components/promocoes/promocoes.component';
import { PromocaoCadastroComponent } from './components/promocao-cadastro/promocao-cadastro.component';
import { PromocaoDetalhesComponent } from './components/promocao-detalhes/promocao-detalhes.component';

const routes: Routes = [{
  path: 'teatros', component: TeatrosComponent, data: { title: 'Lista de Teatros' }
},
{
  path: 'teatro-detalhes/:id', component: TeatroDetalhesComponent, data: { title: 'Detalhes do Teatro' }
},
{
  path: 'teatro-cadastro', component: TeatroCadastroComponent, data: { title: 'Cadastro Teatro' }
},
{
  path: 'teatro-edicao/:id', component: TeatroEdicaoComponent, data: { title: 'Edição Teatro' }
},
{
  path: 'sites', component: SitesComponent, data: { title: 'Lista de Sites' }
},
{
  path: 'site-detalhes/:id', component: SiteDetalhesComponent, data: { title: 'Detalhes do Site' }
},
{
  path: 'site-cadastro', component: SiteCadastroComponent, data: { title: 'Cadastro Site' }
},
{
  path: 'site-edicao/:id', component: SiteEdicaoComponent, data: { title: 'Edição Site' }
},
{
  path: 'promocoes', component: PromocoesComponent, data: { title: 'Lista de Promocoes' }
},
{
  path: 'promocao-detalhes/:id', component: PromocaoDetalhesComponent, data: { title: 'Detalhes do Promocao' }
},
{
  path: 'promocao-cadastro', component: PromocaoCadastroComponent, data: { title: 'Cadastro Promocao' }
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
