package com.smartshop.web.account;

import org.springframework.security.core.GrantedAuthority;

public class EnumGrantedAuthority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Role role;
	
	public EnumGrantedAuthority(Role role){
		this.role=role;
	}
	@Override
	public String getAuthority() {
		
		return this.role.getName();
	}
	
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof EnumGrantedAuthority) {
            return role.getName().equals(((EnumGrantedAuthority) obj).getAuthority());
        }

        return false;
    }

}
