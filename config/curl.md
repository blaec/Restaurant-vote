### Test RestController (application deployed in application context `votes`).
> For windows use `Git Bash`
<hr />
-
#### get All Dishes
`curl -s http://localhost:8080/votes/rest/profile/dishes`

#### get Dish with id=100005
`curl -s http://localhost:8080/votes/rest/profile/dishes/100005`
<hr />
-
#### get All Restaurants
`curl -s http://localhost:8080/votes/rest/profile/restaurants`

#### get Restaurant with id=100017
`curl -s http://localhost:8080/votes/rest/profile/restaurants/100017`
<hr />
-
#### get All Users
`curl -s http://localhost:8080/votes/rest/profile/users`

#### get User with id=100001
`curl -s http://localhost:8080/votes/rest/profile/users/100001`
<hr />
-
#### get All Menu Items
`curl -s http://localhost:8080/votes/rest/profile/menu_items`

#### get Menu Item with id=100021
`curl -s http://localhost:8080/votes/rest/profile/menu_items/100021`

#### get Menu Item with restaurant id=100017
`curl -s http://localhost:8080/votes/rest/profile/menu_items/restaurant/100017`

#### get Menu Item not found
`curl -s -v http://localhost:8080/votes/rest/profile/menu_items/99999`

#### delete Menu Item with id=100021
`curl -s -X DELETE http://localhost:8080/votes/rest/profile/menu_items/100021`

#### create Menu Item
`curl -s -X POST -d '{"dish":{"id": 100005,"description": "dish_01","price": 100},"restaurant":{"id": 100017,"name": "restaurant_3"},"added":"2018-04-24T23:56"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votes/rest/profile/menu_items`

#### update Menu Item
`curl -s -X PUT -d '{"id":100021,"dish":{"id": 100013,"description": "dish_09","price": 1000},"restaurant":{"id": 100019,"name": "restaurant_5"},"added":"2018-04-25T23:00"}' -H 'Content-Type: application/json' http://localhost:8080/votes/rest/profile/menu_items/100021`