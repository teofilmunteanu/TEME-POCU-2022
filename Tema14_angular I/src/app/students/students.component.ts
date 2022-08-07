import { Component, OnInit } from '@angular/core';
import { StudentsMocks } from 'src/assets/student-mock';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  studentList = StudentsMocks;
  constructor() { }

  ngOnInit(): void {
  }

  hasPassed(val: number): boolean {
    return val >= 5;
  }

}
