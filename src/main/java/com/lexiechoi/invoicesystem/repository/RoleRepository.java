package com.lexiechoi.invoicesystem.repository;

import com.lexiechoi.invoicesystem.domain.Role;

import java.util.Collection;

public interface RoleRepository <T extends Role> {
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    boolean delete(Long id);

    void addRoleToUser(Long userId, String roleName);
    Role getRoleByUserId(Long userId);
    Role getRoleByUserEmail(String Email);
    void updateUserRole(Long userId, String roleName);
}
