import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class CreateEmployeeGuard implements CanActivate {

    constructor(private router: Router) { }
    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

        let depId: number = Number(route.paramMap.get("id"));

        if (depId % 2 == 0) {
            alert('you are not authorized to create employee here')
            this.router.navigate(["/home"])
        }
        
        return true;
    }



}