import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Orders } from './orders';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class OrdersService {

    private apiServerURL =environment.ApiBaseURL;

    constructor(private http: HttpClient) { }

    public getAllOrders(): Observable < Orders[] > {
        return this.http.get<Orders[]>(`${this.apiServerURL}8080/api/v1/order`);
    }

    public addAnOrder(order: Orders): Observable < Orders > {
        return this.http.post<Orders>(`${this.apiServerURL}8080/api/v1/order`, order);
    }
}
