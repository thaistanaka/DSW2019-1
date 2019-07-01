import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SiteEdicaoComponent } from './site-edicao.component';

describe('SiteEdicaoComponent', () => {
  let component: SiteEdicaoComponent;
  let fixture: ComponentFixture<SiteEdicaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SiteEdicaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SiteEdicaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
