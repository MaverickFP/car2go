package it.parisnews.web.mvc.controller;

import java.security.Permission;

public class MySecurityManager extends SecurityManager{
	@Override
    public void checkPermission(Permission perm) {
        return;
    }

}
