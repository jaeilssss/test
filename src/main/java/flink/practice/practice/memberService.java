package flink.practice.practice;

import flink.practice.practice.entity.MemberTest;
import flink.practice.practice.repository.memberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class memberService   {

    @Autowired
    private memberRepository memberRepository;

    public void create(MemberTest membertest){
    if(memberRepository==null){
        System.out.println("널이야??...");

    }
            MemberTest result = memberRepository.save(membertest);
            System.out.println("성공");

    }
    public void read(){

    }
    public void update(){

    }
    public void delete(){

    }
}
