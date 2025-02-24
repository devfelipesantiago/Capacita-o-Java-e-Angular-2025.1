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

  async ngOnInit() {
    this.people = await this.personService.getAllPersons();
  }

  onEdit(id: number) {
    this.router.navigate(['/edit', id]);
  }

  async onDelete(id: number) {
    if (confirm('Are you sure you want to delete this person?')) {
      await this.personService.deletePerson(id);
      this.people = this.people.filter((person) => person.id !== id);
    }
  }
}
