package com.dasanzhone.seawind.swweb.service.mapper;

import com.dasanzhone.seawind.swweb.domain.*;
import com.dasanzhone.seawind.swweb.service.dto.WorkflowStepDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity WorkflowStep and its DTO WorkflowStepDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, WorkflowMapper.class, })
public interface WorkflowStepMapper extends EntityMapper <WorkflowStepDTO, WorkflowStep> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")

    @Mapping(source = "workflow.id", target = "workflowId")
    @Mapping(source = "workflow.workflowName", target = "workflowWorkflowName")
    WorkflowStepDTO toDto(WorkflowStep workflowStep); 

    @Mapping(source = "userId", target = "user")

    @Mapping(source = "workflowId", target = "workflow")
    WorkflowStep toEntity(WorkflowStepDTO workflowStepDTO); 
    default WorkflowStep fromId(Long id) {
        if (id == null) {
            return null;
        }
        WorkflowStep workflowStep = new WorkflowStep();
        workflowStep.setId(id);
        return workflowStep;
    }
}
