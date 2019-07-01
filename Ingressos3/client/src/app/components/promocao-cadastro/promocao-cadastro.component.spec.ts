import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromocaoCadastroComponent } from './promocao-cadastro.component';

describe('PromocaoCadastroComponent', () => {
  let component: PromocaoCadastroComponent;
  let fixture: ComponentFixture<PromocaoCadastroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromocaoCadastroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromocaoCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
