package flink.practice.practice.service;

import flink.practice.practice.entity.MemberTest;
import flink.practice.practice.repository.memberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService2 implements UserDetailsService {


        private memberRepository memberRepository;

        @Transactional
        public MemberTest joinUser(MemberTest memberDto) {
            // 비밀번호 암호화
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            memberDto.setUserPassword(passwordEncoder.encode(memberDto.getUserPassword()));

            return memberRepository.save(memberDto);
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            System.out.println("///dddd"+username);
           MemberTest memberTest = memberRepository.findByUserEmail(username);


            List<GrantedAuthority> authorities = new ArrayList<>();

            if (("test@test.com").equals(username)) {
                authorities.add(new SimpleGrantedAuthority("ㅇ"));
            } else {
                authorities.add(new SimpleGrantedAuthority("ㅇㅇ"));
            }

            return new User(memberTest.getUserEmail(), memberTest.getUserPassword(), authorities);
        }
    }