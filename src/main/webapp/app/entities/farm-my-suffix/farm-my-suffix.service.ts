import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { JhiDateUtils } from 'ng-jhipster';

import { FarmMySuffix } from './farm-my-suffix.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<FarmMySuffix>;

@Injectable()
export class FarmMySuffixService {

    private resourceUrl =  SERVER_API_URL + 'api/farms';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils) { }

    create(farm: FarmMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(farm);
        return this.http.post<FarmMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(farm: FarmMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(farm);
        return this.http.put<FarmMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<FarmMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<FarmMySuffix[]>> {
        const options = createRequestOption(req);
        return this.http.get<FarmMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<FarmMySuffix[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: FarmMySuffix = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<FarmMySuffix[]>): HttpResponse<FarmMySuffix[]> {
        const jsonResponse: FarmMySuffix[] = res.body;
        const body: FarmMySuffix[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to FarmMySuffix.
     */
    private convertItemFromServer(farm: FarmMySuffix): FarmMySuffix {
        const copy: FarmMySuffix = Object.assign({}, farm);
        copy.createDate = this.dateUtils
            .convertDateTimeFromServer(farm.createDate);
        return copy;
    }

    /**
     * Convert a FarmMySuffix to a JSON which can be sent to the server.
     */
    private convert(farm: FarmMySuffix): FarmMySuffix {
        const copy: FarmMySuffix = Object.assign({}, farm);

        copy.createDate = this.dateUtils.toDate(farm.createDate);
        return copy;
    }
}
