import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromocaoDetalhesComponent } from './promocao-detalhes.component';

describe('PromocaoDetalhesComponent', () => {
  let component: PromocaoDetalhesComponent;
  let fixture: ComponentFixture<PromocaoDetalhesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromocaoDetalhesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromocaoDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
