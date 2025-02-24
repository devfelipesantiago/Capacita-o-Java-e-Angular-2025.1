import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root',
})
export class CepService {
  private apiUrl = 'https://viacep.com.br/ws';

  constructor() {}

  async getAddressByCep(cep: string): Promise<any> {
    const response = await axios.get(`${this.apiUrl}/${cep}/json`);
    return response.data;
  }
}
