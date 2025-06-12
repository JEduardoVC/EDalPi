import { TestBed } from '@angular/core/testing';

import { DeliveryTimeService } from './delivery-time-service';

describe('DeliveryTimeService', () => {
  let service: DeliveryTimeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeliveryTimeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
