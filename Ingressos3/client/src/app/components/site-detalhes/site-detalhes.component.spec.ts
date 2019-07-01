import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SiteDetalhesComponent } from './site-detalhes.component';

describe('SiteDetalhesComponent', () => {
  let component: SiteDetalhesComponent;
  let fixture: ComponentFixture<SiteDetalhesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SiteDetalhesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SiteDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
