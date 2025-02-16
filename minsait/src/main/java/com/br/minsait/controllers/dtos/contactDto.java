package com.br.minsait.controllers.dtos;

import com.br.minsait.models.entities.ContactType;

public record contactDto(ContactType contactType, String contact, int Person) {

}
