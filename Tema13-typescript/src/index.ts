import "./styles.css";
import {Student} from "./student";

class catalogElectronic{
    button: HTMLElement = document.getElementById("add_btn") as HTMLElement;
    inputNume: HTMLInputElement = document.getElementById(
        "nume"
    ) as HTMLInputElement;
    inputPrenume: HTMLInputElement = document.getElementById(
        "prenume"
    ) as HTMLInputElement;
    inputNota: HTMLInputElement = document.getElementById(
        "nota"
    ) as HTMLInputElement;
    studentsList: HTMLElement = document.getElementById("catalog-list") as HTMLElement;
    students: Array<Student> = [];
    studentCount: number = 0;

    constructor(){
        this.studentCount = 0;

        this.button.onclick = () => {
            const newStudent: Student = {
                nume: this.inputNume.value,
                prenume: this.inputPrenume.value,
                nota: parseInt(this.inputNota.value),
                id: this.studentCount++
            }
            this.addStudent(newStudent);
        };
    }

    clearListAndInput(): void {
        this.inputNume.value = "";
        this.inputPrenume.value = "";
        this.inputNota.value = "";
        this.studentsList.innerHTML = "";
    }

    renderList(students: Student[]):void{
        this.clearListAndInput();
        for(let student of students){
            const text = document.createTextNode(`${student.nume} ${student.prenume} ${student.nota} ${student.id}`);
            const li = document.createElement("li");
            li.appendChild(text);
            li.onclick = () => this.removeStudent(student);
            this.studentsList.appendChild(li);
        }
    }

    addStudent(student: Student): void{
        const newStudent: Student = {
            nume: student.nume,
            prenume: student.prenume,
            nota: student.nota,
            id: student.id
        }
        this.students.push(newStudent);
        this.renderList(this.students);
    }

    removeStudent(student: Student): void {
        const itemIndex: number = this.students.findIndex((i) => i.id === student.id);
        this.students.splice(itemIndex, 1);
        this.renderList(this.students);
      }
}

const app = new catalogElectronic();
