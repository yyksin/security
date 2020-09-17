package com.yyk.security.auth;

import com.yyk.security.model.User;
import com.yyk.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//시큐리티 설정에서 loginProcessingUrl("/login");
//로그인 요청이 오면 자동으로 UserDetailsService 타입으로 IOC되어 있는 loadUserByUsername 메서드를 실행
//input 파라미터명을 바꿀때는 .usernameParameter("username2") 설정을 해야한다. 기본설정은 username
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //input 값과 메서드의 인자값(String username)을 동일하게 해야함.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user != null){
            return new PrincipalDetails(user);
        }

        return null;
    }
}
