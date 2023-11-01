package com.bae.admintemp.data.entity;

import com.bae.admintemp.data.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "product")
public class Product extends BaseEntity{

    @Id
    String id;

    String name;

    Integer price;

    Integer stock;

  /*
  @Column
  String sellerId;

  @Column
  String sellerPhoneNumber;
   */

    public ProductDto toDto() {
        return ProductDto.builder()
                .productId(id)
                .productName(name)
                .productPrice(price)
                .productStock(stock)
                .build();
    }

}