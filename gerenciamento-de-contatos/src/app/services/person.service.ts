import { Injectable } from '@angular/core';
import axios from 'axios';
import { Person } from '../models/person';

@Injectable({
  providedIn: 'root',
})
export class PersonService {
  private apiUrl = 'http://localhost:8080/api';

  constructor() {}

  async getAllPersons(): Promise<Person[]> {
    try {
      const response = await axios.get(`${this.apiUrl}/pessoas`);
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar pessoas:', error);
      throw error;
    }
  }

  async getPersonForDirectMail(personId: number): Promise<Person> {
    try {
      const response = await axios.get(
        `${this.apiUrl}/pessoas/maladireta/${personId}`
      );
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar maladireta:', error);
      throw error;
    }
  }

  async createPerson(person: Person): Promise<Person> {
    try {
      const response = await axios.post(`${this.apiUrl}/pessoas`, person);
      return response.data;
    } catch (error) {
      console.error('Erro ao criar pessoa:', error);
      throw error;
    }
  }

  async updatePerson(person: Person): Promise<Person> {
    const personOrdered = {
      name: person.name,
      address: person.address,
      zipCode: person.zipCode,
      city: person.city,
      state: person.state,
    };
    try {
      const response = await axios.put(
        `${this.apiUrl}/pessoas/${person.id}`,
        personOrdered
      );
      return response.data;
    } catch (error) {
      console.error('Erro ao atualizar pessoa:', error);
      throw error;
    }
  }

  async deletePerson(personId: number): Promise<void> {
    try {
      await axios.delete(`${this.apiUrl}/pessoas/${personId}`);
    } catch (error) {
      console.error('Erro ao excluir pessoa:', error);
      throw error;
    }
  }
}
