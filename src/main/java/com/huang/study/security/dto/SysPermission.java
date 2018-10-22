//package com.huang.study.security.dto;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @Auther: pc.huang
// * @Date: 2018/10/18 13:47
// * @Description:
// */
//@Entity
//@Table(name = "sys_permission")
//public class SysPermission {
//    @Id
//    @GeneratedValue
//    private long id;
//    private String name;
//    private String descritpion;
//    private String url;
//    private long pid;
//    @ManyToMany(mappedBy = "permissions")
//    private Set<SysRole> permissions = new HashSet<>();
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
//    public String getDescritpion() {
//        return descritpion;
//    }
//
//    public void setDescritpion(String descritpion) {
//        this.descritpion = descritpion;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public long getPid() {
//        return pid;
//    }
//
//    public void setPid(long pid) {
//        this.pid = pid;
//    }
//
//    public Set<SysRole> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(Set<SysRole> permissions) {
//        this.permissions = permissions;
//    }
//}
