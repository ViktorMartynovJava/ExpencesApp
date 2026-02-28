package com.martynov.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@org.hibernate.annotations.NamedQuery(name = "User.totalSum", query = "SELECT sum(u.amount) FROM User u")
@Entity
@Table(name = "balance", schema = "expenses")
public class User {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_choice")
    @Enumerated(EnumType.STRING)
    private UserChoice userChoice;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private MoneyValue moneyValue;
    @Column(name = "amount")
    private double amount;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name = "modify_at")
    private LocalDate modifyAt;
    @ElementCollection
    @CollectionTable(name = "expenses_tags", schema = "expenses", joinColumns = @JoinColumn(name = "expenses_id"))
    @Column(name = "tag_name")
    private List<String> tags = new ArrayList<>();

}
