package flink.practice.practice;

import flink.practice.practice.entity.MemberTest;
import flink.practice.practice.repository.memberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test extends PracticeApplicationTests {
    @Autowired
    private memberRepository memberRepository;
@Test
    public void create(){
        MemberTest membertest = new MemberTest();
    membertest.setUserEmail("ddww");
    membertest.setUserName("ddwww");
    membertest.setUserNickname("dd");
        MemberTest result = memberRepository.save(membertest);
        System.out.println("-------------@@@@@@@@@@@@@@@_-----------------");
        System.out.println(result.getUserName());
//
    System.out.println("텟그");

    }
    @Test
    public void read(){
System.out.println("텟그");
    }
    public void update(){

    }
    public void delete(){

    }
}
