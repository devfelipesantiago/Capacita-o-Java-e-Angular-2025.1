import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonService } from '../../services/person.service';
import { Person } from '../../models/person';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css'],
})
export class PersonFormComponent implements OnInit {
  personForm: FormGroup;
  isEditMode: boolean = false;
  personId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private personService: PersonService,
    private route: ActivatedRoute,
    public router: Router
  ) {
    this.personForm = this.fb.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      zipCode: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
    });
  }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      if (params['id']) {
        this.isEditMode = true;
        this.personId = +params['id'];
        this.loadPerson(this.personId);
      }
    });
  }

  async loadPerson(id: number) {
    try {
      const person = await this.personService.getPersonForDirectMail(id);
      this.personForm.patchValue(person);
    } catch (error) {
      console.error('Erro ao carregar pessoa:', error);
      alert('Erro ao carregar dados da pessoa. Por favor, tente novamente.');
    }
  }

  async onSubmit() {
    if (this.personForm.valid) {
      try {
        const personData = this.personForm.value as Person;
        if (this.isEditMode && this.personId) {
          personData.id = this.personId;
          await this.personService.updatePerson(personData);
        } else {
          await this.personService.createPerson(personData);
        }
        this.router.navigate(['/']);
      } catch (error) {
        console.error('Erro ao salvar pessoa:', error);
        alert('Erro ao salvar pessoa. Por favor, tente novamente.');
      }
    }
  }
}
