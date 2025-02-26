import { Contact } from './contact';

export interface Person {
  id: number;
  name: string;
  address: string;
  zipCode: string;
  city: string;
  state: string;
  contactList: Contact[];
}
