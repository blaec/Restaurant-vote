package com.github.votes.to;

import com.github.votes.model.AbstractBaseEntity;

/*
  It solves Lazy - Eager fetch type, but increases the number of queries from 1 complex to 3 simple

  curl -s http://localhost:8080/votes/rest/menu_items/100021
  {"id":100021,"added":"2001-01-01","dish":{"id":100006,"description":"dish_02","price":200},"restaurant":{"id":100015,"name":"restaurant_1"}}


  EAGER fetch type
  Hibernate:
    select
        menuitem0_.id as id1_1_0_,
        menuitem0_.added as added2_1_0_,
        menuitem0_.dish_id as dish_id3_1_0_,
        menuitem0_.restaurant_id as restaura4_1_0_,
        dish1_.id as id1_0_1_,
        dish1_.description as descript2_0_1_,
        dish1_.price as price3_0_1_,
        restaurant2_.id as id1_2_2_,
        restaurant2_.name as name2_2_2_
    from
        menu_items menuitem0_
    inner join
        dishes dish1_
            on menuitem0_.dish_id=dish1_.id
    inner join
        restaurants restaurant2_
            on menuitem0_.restaurant_id=restaurant2_.id
    where
        menuitem0_.id=?
.

   LAZY fetch type with MenuItemTo
   [1] Hibernate:
    select
        menuitem0_.id as id1_1_0_,
        menuitem0_.added as added2_1_0_,
        menuitem0_.dish_id as dish_id3_1_0_,
        menuitem0_.restaurant_id as restaura4_1_0_
    from
        menu_items menuitem0_
    where
        menuitem0_.id=?
    [2] Hibernate:
        select
            dish0_.id as id1_0_0_,
            dish0_.description as descript2_0_0_,
            dish0_.price as price3_0_0_
        from
            dishes dish0_
        where
            dish0_.id=?
    [3] Hibernate:
        select
            restaurant0_.id as id1_2_0_,
            restaurant0_.name as name2_2_0_
        from
            restaurants restaurant0_
        where
            restaurant0_.id=?
* */
public class MenuItemTo extends AbstractBaseEntity {

    private String DishDescription;

    private String RestaurantName;

    public MenuItemTo() {
    }

    public MenuItemTo(Integer id, String dishDescription, String restaurantName) {
        super(id);
        DishDescription = dishDescription;
        RestaurantName = restaurantName;
    }

    public String getDishDescription() {
        return DishDescription;
    }

    public void setDishDescription(String dishDescription) {
        DishDescription = dishDescription;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    @Override
    public String toString() {
        return "MenuItemTo{" +
                "DishDescription='" + DishDescription + '\'' +
                ", RestaurantName='" + RestaurantName + '\'' +
                ", id=" + id +
                '}';
    }
}
