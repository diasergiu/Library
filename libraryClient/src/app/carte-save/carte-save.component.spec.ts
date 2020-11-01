import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarteSaveComponent } from './carte-save.component';

describe('CarteSaveComponent', () => {
  let component: CarteSaveComponent;
  let fixture: ComponentFixture<CarteSaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarteSaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarteSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
