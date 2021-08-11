package com.luv2code.springdemo.gofoodie.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="hotel")
public class Hotel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hotel_id")
    @NotNull
    private int hotelId;

    @NotNull
    @Size(min=1, message="is required")
    @Column(name = "name")
    private String hotelName;

    @NotNull
    @Size(min=1, message="is required")
    @Column(name="hotel_address")
    private String hotelAddress;

    @NotNull
    @Pattern(regexp = "^[6-9]\\d{9}$",message = "phone number is not valid")
    @Column(name = "phone_num")
    private String phoneNum;

    @NotNull
    @Column(name="hotel_rating")
    @Min(value = 1,message = "minimum is 1")
    @Max(value=5,message="maximum is 5")
    private float hotelRating;

    @NotNull
    @Size(min=1,message="is required")
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="hotel_food",
            joinColumns = @JoinColumn(name="hotel_id"),
            inverseJoinColumns=@JoinColumn(name="item_id")
    )
    @ToString.Exclude
    private List<Food> items;

    public Hotel() {
    }

    public Hotel(String hotelName, String hotelAddress, String phoneNum, float hotelRating, String password) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.phoneNum = phoneNum;
        this.hotelRating = hotelRating;
        this.password = password;
    }

    public void addItem(Food food)
    {
        if (items==null)
        {
            items = new ArrayList<>();
        }
        items.add(food);
    }
}
