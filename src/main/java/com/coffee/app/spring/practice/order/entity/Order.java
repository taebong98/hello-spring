package com.coffee.app.spring.practice.order.entity;

import com.coffee.app.spring.practice.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private OrderStatus orderStatus = OrderStatus.ORDER_REQUEST;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderCoffee> orderCoffees = new ArrayList<>();

    public enum OrderStatus {
        ORDER_REQUEST(1, "주문 요청"),
        ORDER_CONFIRM(2, "주문 확정"),
        ORDER_COMPLETE(3, "주문 완료"),
        ORDER_CANCEL(4, "주문 취소");

        @Getter
        private int stepNumber;

        @Getter
        private String status;

        OrderStatus(int stepNumber, String status) {
            this.stepNumber = stepNumber;
            this.status = status;
        }
    }
}
