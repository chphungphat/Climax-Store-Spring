package com.codegym.ClimaxStoreSpring.entity.product;

//import com.codegym.ClimaxStoreSpring.entity.business.CartDetail;
//import com.codegym.ClimaxStoreSpring.entity.business.BoughtProduct;
import com.codegym.ClimaxStoreSpring.entity.business.BoughtProduct;
import com.codegym.ClimaxStoreSpring.entity.business.CartDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @Column(name = "product_cover_url")
    private String productCoverUrl;

    @Column(name = "product_detail_description")
    private String productDetailDescription;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "reduction_rate")
    private Double reductionRate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne(targetEntity = Developer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "developer_id", referencedColumnName = "developer_id")
    private Developer developer;

    @OneToMany(targetEntity = ProductImage.class, fetch = FetchType.LAZY, mappedBy = "product",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ProductImage> productImageList;

    @ManyToMany(targetEntity = Category.class, fetch = FetchType.EAGER, mappedBy = "productList")
    private List<Category> categoryList;

    @OneToMany(targetEntity = CartDetail.class, fetch = FetchType.LAZY, mappedBy = "product",
            cascade = {CascadeType.PERSIST, CascadeType.PERSIST})
    private List<CartDetail> cartDetailList;

    @OneToMany(targetEntity = BoughtProduct.class, fetch = FetchType.LAZY, mappedBy = "product")
    private List<BoughtProduct> boughtProductList;
}
