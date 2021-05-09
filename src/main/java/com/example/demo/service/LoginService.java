package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Member;
import com.example.demo.dto.MemberDetails;
import com.example.demo.dto.MemberEntity;
import com.example.demo.dto.MemberRoleEntity;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		System.out.println("userId : "+userId);
		MemberEntity memberEntity = memberService.getMember(userId);
		if(memberEntity == null){
			throw new UsernameNotFoundException("해당 사용자를 찾을 수 없음");
		}
		
		MemberDetails memberDetails = new MemberDetails();
		memberDetails.setUsername(memberEntity.getUserId());
		memberDetails.setPassword(memberEntity.getUserPwd());
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<MemberRoleEntity> memberRoleEntities = memberService.getMemberRoles(userId);
		if(memberRoleEntities != null) {
			for(MemberRoleEntity memberRoleEntity : memberRoleEntities) {
				authorities.add(new SimpleGrantedAuthority(memberRoleEntity.getRoleName()));
			}
		}
		
		memberDetails.setAuthorities(authorities);
		memberDetails.setEnabled(true);
		memberDetails.setAccountNonExpired(true);
		memberDetails.setAccountNonLocked(true);
		memberDetails.setCredentialsNonExpired(true);
		
		System.out.println(memberDetails);
		System.out.println(passwordEncoder.matches("1234", memberDetails.getPassword()));
		return memberDetails;
	}

}
