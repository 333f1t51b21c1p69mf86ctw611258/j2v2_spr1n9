import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Workflow } from './workflow.model';
import { WorkflowPopupService } from './workflow-popup.service';
import { WorkflowService } from './workflow.service';

import { Account, Principal } from '../../shared';
import { User, UserService } from '../../shared';

@Component({
    selector: 'jhi-workflow-dialog',
    templateUrl: './workflow-dialog.component.html'
})
export class WorkflowDialogComponent implements OnInit {

    workflow: Workflow;
    authorities: any[];
    isSaving: boolean;
    createdDateDp: any;
    lastModifiedDateDp: any;

    account: Account;
    user: User;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private workflowService: WorkflowService,
        private eventManager: JhiEventManager,

        private userService: UserService,
        private principal: Principal
    ) {
    }

    getCurrentDate() {
        var dateObj = new Date();
        var month = dateObj.getUTCMonth() + 1; //months from 1-12
        var day = dateObj.getUTCDate();
        var year = dateObj.getUTCFullYear();

        return {year, month, day};
    }

    initNewWorkflow() {
        this.workflow.createdDate = this.getCurrentDate();
        this.workflow.lastModifiedDate = this.workflow.createdDate;

        this.principal.identity().then((account) => {
            this.account = account;

            this.userService.find(this.account.login).subscribe((user) => {
                this.user = user;

                this.workflow.createdBy = this.user.id;
                this.workflow.lastModifiedBy = this.user.id;
            });
        });
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];

        this.initNewWorkflow();
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.workflow.id !== undefined) {
            this.subscribeToSaveResponse(
                this.workflowService.update(this.workflow), false);
        } else {
            this.subscribeToSaveResponse(
                this.workflowService.create(this.workflow), true);
        }
    }

    private subscribeToSaveResponse(result: Observable<Workflow>, isCreated: boolean) {
        result.subscribe((res: Workflow) =>
            this.onSaveSuccess(res, isCreated), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Workflow, isCreated: boolean) {
        this.alertService.success(
            isCreated ? `A new Workflow is created with identifier ${result.id}`
            : `A Workflow is updated with identifier ${result.id}`,
            null, null);

        this.eventManager.broadcast({ name: 'workflowListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError(error) {
        try {
            error.json();
        } catch (exception) {
            error.message = error.text();
        }
        this.isSaving = false;
        this.onError(error);
    }

    private onError(error) {
        this.alertService.error(error.message, null, null);
    }
}

@Component({
    selector: 'jhi-workflow-popup',
    template: ''
})
export class WorkflowPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private workflowPopupService: WorkflowPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.workflowPopupService
                    .open(WorkflowDialogComponent, params['id']);
            } else {
                this.modalRef = this.workflowPopupService
                    .open(WorkflowDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
