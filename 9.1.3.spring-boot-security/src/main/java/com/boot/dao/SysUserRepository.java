package com.boot.dao;

import com.boot.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by XJX on 2017/6/14.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);
}
