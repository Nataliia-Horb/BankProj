package com.project.bankproj.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "com.project.bankproj.generator.UuidTimeSequenceGenerator")
    private UUID id;

    @Column(name = "type")
    private int type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt; //дата

    @ManyToOne()
    @JoinColumn(name = "debit_account_id",
            referencedColumnName = "id")
    private Account debitAccountId;

    @ManyToOne()
    @JoinColumn(name = "credit_account_id",
            referencedColumnName = "id")
    private Account creditAccountId;


    // уникальные id debit_id credit_id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id.equals(that.id) && createdAt.equals(that.createdAt) && debitAccountId.equals(that.debitAccountId) &&
                creditAccountId.equals(that.creditAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, debitAccountId, creditAccountId);
    }
}