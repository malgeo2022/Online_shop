package org.Online_Shop.dto.converter;

import org.Online_Shop.dto.RoleDto;

public class RoleDtoToRoleConverter {

	public RoleDto convertRoleNameToRoleDtoWithOnlyRoleName(String roleName) {
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleName(roleName);
		return roleDto;
	}

}
