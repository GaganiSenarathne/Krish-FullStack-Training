import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Scheduled } from './scheduled';

@Injectable({
    providedIn: 'root'
})
export class DispatchService {

    private apiServerURL = environment.ApiBaseURL;

    constructor(private http: HttpClient) { }

    public getScheduledOrders(): Observable <Scheduled[]> {
        return this.http.get<Scheduled[]>(`${this.apiServerURL}8082/Schedule`)
    }

    public addAdipatch(scheduled: Scheduled): Observable <Scheduled> {
        return this.http.post<Scheduled>(`${this.apiServerURL}8084/Dispatch`, scheduled);
    }
}
