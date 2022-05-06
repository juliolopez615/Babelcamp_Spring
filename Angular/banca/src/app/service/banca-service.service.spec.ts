import { TestBed } from '@angular/core/testing';

import { BancaServiceService } from './banca-service.service';

describe('BancaServiceService', () => {
  let service: BancaServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BancaServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
