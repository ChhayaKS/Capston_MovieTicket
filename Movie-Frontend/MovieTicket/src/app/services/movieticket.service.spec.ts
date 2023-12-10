import { TestBed } from '@angular/core/testing';

import { MovieticketService } from './movieticket.service';

describe('MovieticketService', () => {
  let service: MovieticketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieticketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
