package memory.dev.waitingqueue.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "상품 고유 ID")
    private Long id;
    
    @Comment(value = "상품 이름")
    private String name;
    
    @Comment(value = "상품 가격")
    private Long price;
    
    @Comment(value = "상품 재고 수량")
    private Long stock;
    
    @Comment(value = "판매 시작 시간")
    private LocalDateTime saleStartTime;

    @Comment(value = "판매 종료 시간")
    private LocalDateTime saleEndTime;

    @Comment(value = "판매 생성일")
    private LocalDateTime createAt;

    @PrePersist
    public void onCreate() {
        createAt = LocalDateTime.now();
    }

}
