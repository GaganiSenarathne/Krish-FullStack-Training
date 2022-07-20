import { Component, OnInit } from '@angular/core';
import employees from './data/employees.json';
import {Employee} from './Employees.model';

@Component({
    selector: 'em-employees',
    templateUrl: './employees.component.html',
    styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {

    title: string = "Employee Management Solution"
    employees: Employee[] = employees;
    filteredEmployees: Employee[] = employees;
    showIcon: boolean = false;
    private _designationFilter: string = '';
    message: string = '';


    constructor() { }

    ngOnInit() {
    }

    toggleIcon(){
        this.showIcon = !this.showIcon;
    }

    set designationFilter(value: string){
        this._designationFilter=value;
        this.filterByDesignation();
    }

    get designationFilter(): string{
        return this._designationFilter;
    }

    filterByDesignation(){

        this.filteredEmployees = this.employees.filter(emplyee => emplyee.designation.includes(this._designationFilter))

    }

    onMessageRecieved(value: string){
        this.message = value;
    }


}
