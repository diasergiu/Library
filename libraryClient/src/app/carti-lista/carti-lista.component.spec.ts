import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CartiListaComponent } from './carti-lista.component';

describe('CartiListaComponent', () => {
  let component: CartiListaComponent;
  let fixture: ComponentFixture<CartiListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CartiListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CartiListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
