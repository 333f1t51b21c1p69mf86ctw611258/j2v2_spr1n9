import { BaseEntity } from './../../shared';

export class Workflow implements BaseEntity {
    constructor(
        public id?: number,
        public workflowName?: string,
        public description?: string,
        public createdBy?: number,
        public createdDate?: any,
        public lastModifiedBy?: number,
        public lastModifiedDate?: any,
        public workflowSteps?: BaseEntity[],
        public userId?: number,
    ) {
    }
}
