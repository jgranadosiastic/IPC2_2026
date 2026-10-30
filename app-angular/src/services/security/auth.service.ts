import { Injectable } from "@angular/core";
import { RestConstants } from "../../shared/rest-api/rest-constants";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { LoginRequest } from "../../models/login-reques";
import { LoginResponse } from "../../models/login-response";

@Injectable({
    providedIn: 'root'
})
export class AuthService {

    private tokenKey: string = 'token';

    restConstants = new RestConstants();

    constructor(private httpClient: HttpClient) { }

    login(dataToSend: LoginRequest): Observable<LoginResponse> {
        return this.httpClient.post<LoginResponse>(`${this.restConstants.getApiURL()}/auth/login`, dataToSend);
    }

    saveToken(token: string) : void {
        localStorage.setItem(this.tokenKey, token);
    }

    getToken() : string {
        return localStorage.getItem(this.tokenKey) as string;
    }

    logout() : void {
        localStorage.removeItem(this.tokenKey);
    }

    isLoggedIn(): boolean {
        const token = this.getToken();
        if (!token) return false;
        const payload = JSON.parse(atob(token.split('.')[1]));
        return payload.exp * 1000 > Date.now();
    }

    hasRole(role: string): boolean {
        const token = this.getToken();
        if (!token) return false;
        const payload = JSON.parse(atob(token.split('.')[1]));
        return payload.roles?.includes(role);
    }

    getRoles(): string[] {
        if (!this.isLoggedIn()) {
            return [];
        }
        const token = this.getToken();
        const payload = JSON.parse(atob(token!.split('.')[1]));
        return payload.roles;
    }

    getUserName(): string | undefined {
        if (!this.isLoggedIn()) {
            return undefined;
        }
        const token = this.getToken();
        const payload = JSON.parse(atob(token!.split('.')[1]));
        return payload.sub;
    }
}