package com.adobe.prj.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int oid;
        
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name="order_date")
        private Date orderDate = new Date();
        
        @ManyToOne
        @JoinColumn(name="customer_email") // Foreign Key
        private Customer customer;
        
        private double total;
        
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name="order_fk") // Foreign Key
        private List<Item> items = new ArrayList<>();

        public int getOid() {
                return oid;
        }

        public void setOid(int oid) {
                this.oid = oid;
        }

        public Date getOrderDate() {
                return orderDate;
        }

        public void setOrderDate(Date orderDate) {
                this.orderDate = orderDate;
        }

        public Customer getCustomer() {
                return customer;
        }

        public void setCustomer(Customer customer) {
                this.customer = customer;
        }

        public double getTotal() {
                return total;
        }

        public void setTotal(double total) {
                this.total = total;
        }

        public List<Item> getItems() {
                return items;
        }

        public void setItems(List<Item> items) {
                this.items = items;
        }
        
}