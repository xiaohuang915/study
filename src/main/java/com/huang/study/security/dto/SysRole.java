//package com.huang.study.security.dto;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @Auther: pc.huang
// * @Date: 2018/10/18 13:44
// * @Description:
// */
//@Entity
//@Table(name = "sys_role")
//public class SysRole {
//    @Id
//    @GeneratedValue
//    private long id;
//
//    private String name;
//    private String description;
//    @ManyToMany(mappedBy = "roles")
//    private Set<SysUser> sysUsers = new HashSet<>();
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "sys_permission",
//            joinColumns = {@JoinColumn(name = "role_id")},
//            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
//    private Set<SysPermission> permissions = new HashSet<>();
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Set<SysUser> getSysUsers() {
//        return sysUsers;
//    }
//
//    public void setSysUsers(Set<SysUser> sysUsers) {
//        this.sysUsers = sysUsers;
//    }
//
//    public Set<SysPermission> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(Set<SysPermission> permissions) {
//        this.permissions = permissions;
//    }
//}
