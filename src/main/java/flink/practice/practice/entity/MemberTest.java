package flink.practice.practice.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)

@Data

public class MemberTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String userEmail;

    String userPassword;

    String userName;

    String userNickname;

    String userYear;

    String userMonth;

    String userDate;

    String userPhoneNumber;


}
