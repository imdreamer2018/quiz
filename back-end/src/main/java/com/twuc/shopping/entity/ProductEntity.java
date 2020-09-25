package com.twuc.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer price;

    private String unit;

    private String imgLink;

    @JsonIgnore
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.REMOVE)
    private List<OrderEntity> order;
}
