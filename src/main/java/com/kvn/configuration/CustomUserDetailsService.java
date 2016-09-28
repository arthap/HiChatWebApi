package com.kvn.configuration;

/**
 * Created by sevo on 29.09.2016.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kvn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    //get user from the database, via Hibernate
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
Set<String> role = new HashSet<String>();
        role.add("ROLE_USER");
        role.add("ROLE_ADMIN");
        role.add("ROLE_DBA");
       com.kvn.entity.User user = userDao.findByEmail(username);
        List<GrantedAuthority> authorities =
                buildUserAuthority(role);

        return buildUserForAuthentication(user, authorities);

    }

    // Converts com.mkyong.users.model.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(com.kvn.entity.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getEmail(), user.getPassword(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<String> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (String userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}