import { BaseEntity } from './../../shared';

export class FarmMySuffix implements BaseEntity {
    constructor(
        public id?: number,
        public companyName?: string,
        public companyLocation?: string,
        public companyLegalPerson?: string,
        public registeredCapital?: string,
        public email?: string,
        public phoneNumber?: string,
        public createDate?: any,
        public address?: string,
        public webAddress?: string,
        public scope?: string,
        public longitude?: number,
        public latitude?: number,
        public province?: string,
    ) {
    }
}
