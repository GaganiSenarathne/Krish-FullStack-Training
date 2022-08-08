import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Orders } from './orders';
import { OrdersService } from './orders.service';


@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

    title = 'Fuel Management App';

    public order: Orders[];

    constructor(private orderService: OrdersService) { }

    ngOnInit() {
        this.getOrders();
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

    public onAddOrder(addForm: NgForm): void{
        document.getElementById('add-order-close').click();
        this.orderService.addAnOrder(addForm.value).subscribe(
            (response: Orders) => {
                console.log(response);
                alert('Your order Reference ID is: '+response.refId)
                this.getOrders();
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
