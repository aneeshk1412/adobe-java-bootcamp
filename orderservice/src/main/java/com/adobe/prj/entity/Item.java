package com.adobe.prj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int itemid;
        
        @ManyToOne
        @JoinColumn(name="product_fk")
        private Product product;
        
        private int qty;
        
        private double price;

        public int getItemid() {
                return itemid;
        }

        public void setItemid(int itemid) {
                this.itemid = itemid;
        }

        public Product getProduct() {
                return product;
        }

        public void setProduct(Product product) {
                this.product = product;
        }

        public int getQty() {
                return qty;
        }

        public void setQty(int qty) {
                this.qty = qty;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }
        
}
