package hello.demos.basic.service;

import hello.demos.basic.bean.UserDetail;
import hello.demos.basic.entity.User;
import hello.demos.basic.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Nereus Yi
 */
public class JdbcUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public JdbcUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user can't found by username : " + username));

        return new UserDetail(user.getUsername(), user.getPassword());
    }

}
