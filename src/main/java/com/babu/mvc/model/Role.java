package com.babu.mvc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @Id
    private Long roleId;

    private String roleName;

    // Getters and Setters
    public Long getId() {
        return roleId;
    }

    public void setId(Long roleId) {
        this.roleId= roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
