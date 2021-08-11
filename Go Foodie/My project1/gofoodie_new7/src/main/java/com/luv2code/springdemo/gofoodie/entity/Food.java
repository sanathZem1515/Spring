package com.luv2code.springdemo.gofoodie.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="food")
public class Food
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private int id;

    @NotNull
    @Size(min=1, message="is required")
    @Column(name="item_name")
    private String itemName;

    @NotNull
    @Min(value = 1,message = "minimum is 1")
    @Max(value=5,message="maximum is 5")
    @Column(name = "item_rating")
    private float itemRating;

    @NotNull
    @Column(name="item_price")
    private int itemPrice;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="hotel_food",
            joinColumns = @JoinColumn(name="item_id"),
            inverseJoinColumns=@JoinColumn(name="hotel_id")
    )
    @ToString.Exclude
    private List<Hotel> hotels;

    public Food() {
    }

    public Food(String itemName, float itemRating, int itemPrice) {
        this.itemName = itemName;
        this.itemRating = itemRating;
        this.itemPrice = itemPrice;
    }

    public void addHotel(Hotel hotel)
    {
        if (hotels==null)
        {
            hotels = new ArrayList<>();
        }
        hotels.add(hotel);
    }


}
