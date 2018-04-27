### Test RestController (application deployed in application context `votes`).
> For windows use `Git Bash`

## Testing DishRestController
#### get All Dishes
`curl -s http://localhost:8080/votes/rest/dishes`

#### get Dish with id=100005
`curl -s http://localhost:8080/votes/rest/dishes/100005`

## Testing RestaurantRestController
#### get All Restaurants
`curl -s http://localhost:8080/votes/rest/restaurants`

#### get Restaurant with id=100017
`curl -s http://localhost:8080/votes/rest/restaurants/100017`

## Testing UserRestController
#### get All Users
`curl -s http://localhost:8080/votes/rest/users`

#### get User with id=100001
`curl -s http://localhost:8080/votes/rest/users/100001`

## Testing MenuItemRestController
#### get All Menu Items
`curl -s http://localhost:8080/votes/rest/menu_items`

#### get Menu Item with id=100021
`curl -s http://localhost:8080/votes/rest/menu_items/100021`

#### get Menu Item with restaurant id=100017
`curl -s http://localhost:8080/votes/rest/menu_items/restaurant/100017`

#### get Menu Item not found
`curl -s -v http://localhost:8080/votes/rest/menu_items/99999`

#### delete Menu Item with id=100021
`curl -s -X DELETE http://localhost:8080/votes/rest/menu_items/100021`

#### create Menu Item
`curl -s -X POST -d '{"dish":{"id": 100005,"description": "dish_01","price": 100},"restaurant":{"id": 100017,"name": "restaurant_3"},"added":"2018-04-24T23:56"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votes/rest/menu_items`

#### update Menu Item
`curl -s -X PUT -d '{"id":100021,"dish":{"id": 100013,"description": "dish_09","price": 1000},"restaurant":{"id": 100019,"name": "restaurant_5"},"added":"2018-04-25T23:00"}' -H 'Content-Type: application/json' http://localhost:8080/votes/rest/menu_items/100021`

## Testing VoteRestController
#### get Vote for Active User
`curl -s http://localhost:8080/votes/rest/votes`

#### delete Vote for Active User
`curl -s -X DELETE http://localhost:8080/votes/rest/votes`

#### take Vote for selected Restaurant by Active User
`curl -s -X PUT -d '{"id": 100018,"name": "restaurant_4"}' -H 'Content-Type: application/json' http://localhost:8080/votes/rest/votes`
