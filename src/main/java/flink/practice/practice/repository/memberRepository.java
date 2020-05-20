package flink.practice.practice.repository;

import flink.practice.practice.entity.MemberTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface memberRepository extends JpaRepository<MemberTest,Long> {

        MemberTest findByUserEmail(String email);
}
