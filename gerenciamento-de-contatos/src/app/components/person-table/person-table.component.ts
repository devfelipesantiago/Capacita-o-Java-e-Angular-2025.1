import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Person } from 'src/app/models/person';

@Component({
  selector: 'app-person-table',
  templateUrl: './person-table.component.html',
  styleUrls: ['./person-table.component.css'],
})
export class PersonTableComponent {
  @Input() people: Person[] = [];
  @Output() edit = new EventEmitter<number>();
  @Output() delete = new EventEmitter<number>();

  onEdit(id: number) {
    this.edit.emit(id);
  }

  onDelete(id: number) {
    this.delete.emit(id);
  }
}
