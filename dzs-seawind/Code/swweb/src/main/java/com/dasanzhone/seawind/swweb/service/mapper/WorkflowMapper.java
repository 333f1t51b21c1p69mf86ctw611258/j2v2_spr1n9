package com.dasanzhone.seawind.swweb.service.mapper;

import com.dasanzhone.seawind.swweb.domain.*;
import com.dasanzhone.seawind.swweb.service.dto.WorkflowDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Workflow and its DTO WorkflowDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, })
public interface WorkflowMapper extends EntityMapper <WorkflowDTO, Workflow> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")
    WorkflowDTO toDto(Workflow workflow); 
    @Mapping(target = "workflowSteps", ignore = true)

    @Mapping(source = "userId", target = "user")
    Workflow toEntity(WorkflowDTO workflowDTO); 
    default Workflow fromId(Long id) {
        if (id == null) {
            return null;
        }
        Workflow workflow = new Workflow();
        workflow.setId(id);
        return workflow;
    }
}
