package com.codegym.ClimaxStoreSpring.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Double price;

    @Column(name = "reduction_rate")
    private Double reductionRate;

    @OneToOne(targetEntity = ProductDetail.class, fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "product")
    @JoinColumn(name = "product_detail_id", referencedColumnName = "product_detail_id")
    private ProductDetail productDetail;

    @ManyToOne(targetEntity = Developer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id", referencedColumnName = "developer_id")
    private Developer developer;

    @OneToMany(targetEntity = ProductImage.class, fetch = FetchType.LAZY, mappedBy = "product",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<ProductImage> productImageList;
}
