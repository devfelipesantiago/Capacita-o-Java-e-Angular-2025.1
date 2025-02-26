import { Injectable } from '@angular/core';
import axios from 'axios';
import { Contact } from '../models/contact';

@Injectable({
  providedIn: 'root',
})
export class ContactService {
  private apiUrl = 'http://localhost:8080/api/';
  constructor() {}

  async getContacts(): Promise<Contact[]> {
    try {
      const response = await axios.get(`${this.apiUrl}/contatos`);
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar contatos:', error);
      throw error;
    }
  }

  async createContact(contact: Contact): Promise<Contact> {
    try {
      const response = await axios.post(`${this.apiUrl}/contatos`, contact);
      return response.data;
    } catch (error) {
      console.error('Erro ao criar contatos:', error);
      throw error;
    }
  }

  async updateContact(contact: Contact): Promise<Contact> {
    try {
      const response = await axios.put(
        `${this.apiUrl}/contatos/${contact.id}`,
        contact
      );
      return response.data;
    } catch (error) {
      console.error('Erro ao atualizar contatos:', error);
      throw error;
    }
  }

  async deleteContact(contactId: number): Promise<void> {
    try {
      await axios.delete(`${this.apiUrl}/contatos/${contactId}`);
    } catch (error) {
      console.error('Erro ao deletar contato:', error);
      throw error;
    }
  }

  async getContact(contactId: number): Promise<Contact> {
    try {
      const response = await axios.get(`${this.apiUrl}/contatos/${contactId}`);
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar contato:', error);
      throw error;
    }
  }

  async getContactsByPersonId(personId: number): Promise<Contact[]> {
    try {
      const response = await axios.get(
        `${this.apiUrl}/contatos/pessoa/${personId}`
      );
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar contatos de uma pessoa:', error);
      throw error;
    }
  }
}
