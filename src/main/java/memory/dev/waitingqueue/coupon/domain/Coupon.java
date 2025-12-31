package memory.dev.waitingqueue.coupon.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "coupons")
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "고유 ID")
    private Long id;

    @Column(nullable = false)
    @Comment(value = "쿠폰 이름")
    private String name;

    @Comment(value = "총 발행 가능 개수")
    private Integer totalQuantity;

    @Comment(value = "현재 발급된 개수")
    private Integer issuedQuantity;

    @Comment(value = "할인 금액")
    private Integer discountAmount;

    @Comment(value = "쿠폰 사용 시작일")
    private LocalDateTime validFrom;

    @Comment(value = "쿠폰 사용 종료일")
    private LocalDateTime validTo;
}
