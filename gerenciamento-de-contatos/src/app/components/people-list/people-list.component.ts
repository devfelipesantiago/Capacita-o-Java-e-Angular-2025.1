import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Person } from '../../models/person';
import { PersonService } from '../../services/person.service';

@Component({
  selector: 'app-people-list',
  templateUrl: './people-list.component.html',
  styleUrls: ['./people-list.component.css'],
})
export class PeopleListComponent implements OnInit {
  people: Person[] = [];

  constructor(private personService: PersonService, private router: Router) {}

  ngOnInit(): void {
    this.loadPeople();
  }

  async loadPeople(): Promise<void> {
    try {
      this.people = await this.personService.getAllPersons();
    } catch (error) {
      console.error('Erro ao carregar pessoas:', error);
    }
  }

  getPhoneContacts(person: Person): string {
    return person.contactList
      .filter((contact) => contact.contactType === 'PHONE')
      .map((contact) => contact.contact)
      .join(', ');
  }

  async deletePerson(id: number) {
    if (confirm('Tem certeza que deseja excluir esta pessoa?')) {
      try {
        await this.personService.deletePerson(id);
        this.people = this.people.filter((p) => p.id !== id);
      } catch (error) {
        console.error('Erro ao excluir pessoa:', error);
        alert('Erro ao excluir pessoa. Por favor, tente novamente.');
      }
    }
  }

  editPerson(id: number) {
    this.router.navigate(['/edit-person', id]);
  }

  addNewPerson(): void {
    this.router.navigate(['/add-person']);
  }
}
