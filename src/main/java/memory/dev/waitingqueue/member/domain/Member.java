package memory.dev.waitingqueue.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import memory.dev.waitingqueue.global.converter.BooleanToYNConverter;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "고유 ID")
    private Long id;

    @Column(unique = true)
    @Comment(value = "로그인 ID")
    private String memberId;

    @Column(nullable = false)
    @Comment(value = "로그인 PW")
    private String password;

    @Comment(value = "닉네임")
    private String nickname;

    @Comment(value = "이메일")
    private String email;

    @Comment(value = "생성일")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "delete_yn", nullable = false, length = 1)
    private boolean deleteYn;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        deleteYn = false;
    }
}
