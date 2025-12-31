package memory.dev.waitingqueue.membercoupon.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import memory.dev.waitingqueue.coupon.domain.Coupon;
import memory.dev.waitingqueue.global.converter.BooleanToYNConverter;
import memory.dev.waitingqueue.member.domain.Member;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "member_coupons")
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "고유 ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @Comment(value = "발급받은 유저 고유 ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    @Comment(value = "발급받은 쿠폰 고유 ID")
    private Coupon coupon;

    @Comment("발급일")
    private LocalDateTime issuedAt;

    @Comment("사용여부")
    @Convert(converter = BooleanToYNConverter.class)
    private boolean usedYn;
}
