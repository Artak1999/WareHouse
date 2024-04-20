In Sandship, the warehouse is a place where players can store their materials. It’s like an inventory. Players can have multiple warehouses, and each warehouse has a list of materials and their quantities.
Each material in the warehouse is of a certain material type, for example - iron, copper, bolt and so on. Each material type has some information about it like name, description, icon (all strings).
Materials can be added to the warehouse, or removed from it. Materials can also be moved from one warehouse to another as one transaction. Note that due to max material caps, moving a material can be either partial or fail altogether. So it needs a method that gets a warehouse reference to move items from (or to).

WareHouse view

![Скриншот 20-04-2024 220223](https://github.com/Artak1999/WareHouse/assets/75327821/eafc325e-2394-411a-ac58-35d8e99ac6d2)

Material view

![Скриншот 20-04-2024 220210](https://github.com/Artak1999/WareHouse/assets/75327821/c9e592d0-5f8f-4613-9306-a5b5f0cca4e1)
