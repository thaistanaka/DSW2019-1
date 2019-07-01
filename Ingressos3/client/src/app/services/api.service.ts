import { Injectable } from '@angular/core';

import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Site } from '../models/site';
import { Teatro } from '../models/teatro';
import { Promocao } from '../models/promocao';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = "http://localhost:8080/Ingressos3";
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  getTeatros (): Observable<Teatro[]> {
    const url = `${apiUrl}/teatros`;
    return this.http.get<Teatro[]>(url)
      .pipe(
        tap(heroes => console.log('getTeatros')),
        catchError(this.handleError('getTeatros', []))
      );
  }
  
  getTeatro(id: number): Observable<Teatro> {
    const url = `${apiUrl}/teatros/${id}`;
    return this.http.get<Teatro>(url).pipe(
      tap(_ => console.log(`getTeatro id=${id}`)),
      catchError(this.handleError<Teatro>(`getTeatro id=${id}`))
    );
  }
  
  addTeatro (teatro): Observable<Teatro> {
    const url = `${apiUrl}/teatros`;
    return this.http.post<Teatro>(url, teatro, httpOptions).pipe(
      tap((Teatro: Teatro) => console.log(`addTeatro w/id=${teatro.id}`)),
      catchError(this.handleError<Teatro>('addTeatro'))
    );
  }
  
  updateTeatro (id, teatro): Observable<any> {
    const url = `${apiUrl}/Teatros/${id}`;
    return this.http.put(url, teatro, httpOptions).pipe(
      tap(_ => console.log(`updateTeatro id=${id}`)),
      catchError(this.handleError<any>('updateTeatro'))
    );
  }
  
  deleteTeatro (id): Observable<Teatro> {
    const url = `${apiUrl}/Teatros/${id}`;
    return this.http.delete<Teatro>(url, httpOptions).pipe(
      tap(_ => console.log(`deleteTeatro id=${id}`)),
      catchError(this.handleError<Teatro>('deleteTeatro'))
    );
  }

  getSites (): Observable<Site[]> {
    const url = `${apiUrl}/sites`;
    return this.http.get<Site[]>(url)
      .pipe(
        tap(heroes => console.log('getSites')),
        catchError(this.handleError('getSites', []))
      );
  }
  
  getSite(id: number): Observable<Site> {
    const url = `${apiUrl}/sites/${id}`;
    return this.http.get<Site>(url).pipe(
      tap(_ => console.log(`getSite id=${id}`)),
      catchError(this.handleError<Site>(`getSite id=${id}`))
    );
  }
  
  addSite (site): Observable<Site> {
    const url = `${apiUrl}/sites`;
    return this.http.post<Site>(url, site, httpOptions).pipe(
      tap((site: Site) => console.log(`addSite w/id=${site.id}`)),
      catchError(this.handleError<Site>('addSite'))
    );
  }
  
  updateSite (id, site): Observable<any> {
    const url = `${apiUrl}/sites/${id}`;
    return this.http.put(url, site, httpOptions).pipe(
      tap(_ => console.log(`updateSite id=${id}`)),
      catchError(this.handleError<any>('updateSite'))
    );
  }
  
  deleteSite (id): Observable<Site> {
    const url = `${apiUrl}/sites/${id}`;
    return this.http.delete<Site>(url, httpOptions).pipe(
      tap(_ => console.log(`deleteSite id=${id}`)),
      catchError(this.handleError<Site>('deleteSite'))
    );
  }

  getPromocoes (): Observable<Promocao[]> {
    const url = `${apiUrl}/promocoes`;
    return this.http.get<Promocao[]>(url)
      .pipe(
        tap(heroes => console.log('getPromocoes')),
        catchError(this.handleError('getPromocoes', []))
      );
  }
  
  getPromocao(id: number): Observable<Promocao> {
    const url = `${apiUrl}/promocoes/${id}`;
    return this.http.get<Promocao>(url).pipe(
      tap(_ => console.log(`getPromocao id=${id}`)),
      catchError(this.handleError<Promocao>(`getPromocao id=${id}`))
    );
  }
  
  addPromocao (promocao): Observable<Promocao> {
    const url = `${apiUrl}/promocoes`;
    return this.http.post<Promocao>(url, promocao, httpOptions).pipe(
      tap((promocao: Promocao) => console.log(`addPromocao w/id=${promocao.id}`)),
      catchError(this.handleError<Promocao>('addPromocao'))
    );
  }


}
