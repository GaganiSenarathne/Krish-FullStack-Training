import { HttpErrorResponse } from '@angular/common/http';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DispatchService } from './dispatch.service';
import { Orders } from './orders';
import { OrdersService } from './orders.service';
import { Scheduled } from './scheduled';


@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

    title = 'Fuel Management App';

    public order: Orders[];
    public scheduled: Scheduled[];
    editData:any = {};

    constructor(private orderService: OrdersService, private dispatchService: DispatchService) { }

    ngOnInit() {
        this.getOrders();
        this.getScheduledOrders();
    }

    public getOrders(): void {
        this.orderService.getAllOrders().subscribe(
            (response: Orders[]) => {
                this.order = response;
                console.log(this.order);
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            }
        );
    }

    public getScheduledOrders(): void {
        this.dispatchService.getScheduledOrders().subscribe(
            (response: Scheduled[]) => {
                this.scheduled = response;
                console.log(this.scheduled);
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            }
        );
    }

    public onAddOrder(addForm: NgForm): void{
        document.getElementById('add-order-close').click();
        this.orderService.addAnOrder(addForm.value).subscribe(
            (response: Orders) => {
                console.log(response);
                alert('Your order Reference ID is: '+response.refId);
                this.getOrders();
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            }
        );

    }

    public onClickSchedule(addFormSchedule: NgForm): void{

        this.dispatchService.addAdipatch(addFormSchedule.value).subscribe(
            (response: Scheduled) => {
                console.log(response);
                this.getScheduledOrders();
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            }
        );

    }

    addDatatoForm = (schedule) => {
        this.editData = Object.assign(schedule);
        this.dispatchService.addAdipatch(schedule).subscribe(
            (response: Scheduled) => {
                console.log(response);
                alert('Your order (Reference ID: '+response.refID+') Dispatched.');
                this.getScheduledOrders();
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            }
        );
        
     }

    // public onOpenModal(): void {
    //     const containerButton = document.getElementById('buttonCotainer');

    //     const button = document.createElement('button');
    //     button.type = 'button';
    //     button.style.display = 'none';
    //     button.setAttribute('data-toggle', 'modal');
    //     button.setAttribute('data-target', 'addOrderModal');
    //     containerButton.appendChild(button);
    //     button.click();
    // }
}
