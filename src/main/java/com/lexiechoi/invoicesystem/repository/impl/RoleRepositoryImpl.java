package com.lexiechoi.invoicesystem.repository.impl;

import com.lexiechoi.invoicesystem.domain.Role;
import com.lexiechoi.invoicesystem.exception.ApiException;
import com.lexiechoi.invoicesystem.repository.RoleRepository;
import com.lexiechoi.invoicesystem.rowmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

import static com.lexiechoi.invoicesystem.enumeration.RoleType.ROLE_USER;
import static com.lexiechoi.invoicesystem.query.RoleQuery.INSERT_ROLE_TO_USER;
import static com.lexiechoi.invoicesystem.query.RoleQuery.SELECT_ROLE_BY_NAME_QUERY;
import static java.util.Objects.requireNonNull;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImpl implements RoleRepository<Role> {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Role create(Role data) {
        return null;
    }

    @Override
    public Collection<Role> list(int page, int pageSize) {
        return null;
    }

    @Override
    public Role get(Long id) {
        return null;
    }

    @Override
    public Role update(Role data) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void addRoleToUser(Long userId, String roleName) {
        log.info("Adding role {} to user id: {}", roleName, userId);
        try {
            Role role = jdbcTemplate.queryForObject(
                    SELECT_ROLE_BY_NAME_QUERY,
                    Map.of("roleName", roleName),
                    new RoleRowMapper());
            jdbcTemplate.update(INSERT_ROLE_TO_USER, Map.of("userId", userId, "roleId", requireNonNull(role).getId()));
        } catch (EmptyResultDataAccessException exception) {
            throw new ApiException("No role found by name: " + ROLE_USER.name());
        } catch(Exception exception) {
            throw new ApiException("An error occurred. Please try again.");
        }
    }

    @Override
    public Role getRoleByUserId(Long userId) {
        return null;
    }

    @Override
    public Role getRoleByUserEmail(String Email) {
        return null;
    }

    @Override
    public void updateUserRole(Long userId, String roleName) {

    }
}
