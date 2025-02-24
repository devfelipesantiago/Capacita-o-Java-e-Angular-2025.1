import { Person } from './person';

export interface Contact {
  id?: number;
  contactType: string;
  contact: string;
  person: Person;
}
