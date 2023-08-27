# Virtual Store Console Application

This project aims to create an application for managing the shopping cart of a virtual IT product store, along with the customers associated with each shopping cart.
## Table of Contents
- [Description](#description)
- [Functionalities](#functionalities)
- [Notes](#Notes)
- [Usage](#usage)
- [Implementation Details](#implementation-details)


## Description

Each customer has a name and a registration year, and the virtual store offers three types of products: laptops, phones, and televisions. Each product type has specific attributes such as price, stock quantity, and manufacturer. Laptops also have the number of processors and whether they have a touchscreen, phones have battery size and megapixel count, and televisions have screen diagonal and whether they are "Smart."

The store manages a shopping cart for each of its customers, containing products they wish to purchase. Customers who registered before 2018 receive a 10% discount on all products.

## Functionalities

The application have the following functionalities:

- Adding a new customer.
- Adding a product to a customer's shopping cart.
- Removing a product from a customer's shopping cart by product name.
- Removing all products from a customer's shopping cart.
- Displaying all customers along with their registration years.
- Displaying a customer's shopping cart (products and total price).
- Displaying all customers with their associated shopping carts (products and total price).

## Notes

- The total price for a customer's shopping cart is calculated by summing the prices of all products in the cart.
- All add/remove operations in the cart should update the store's stock 
- A customer cannot be added multiple times to the store.
- If operations like adding a product or displaying the shopping cart are performed for a customer who does not exist in the store, a ClientInexistentException should be thrown.
- If a customer tries to add a product that is out of stock for that product type, an appropriate error message should be displayed.

## Usage

To use the application, you can execute the following commands:

- `ADD_CLIENT <name>`
- `ADD_PRODUCT <clientName> <productType>`
  - For laptops: `<price> <stock> <manufacturer> <numProcessors> <hasTouchScreen>`
  - For phones: `<price> <stock> <manufacturer> <batterySize> <megapixels>`
  - For televisions: `<price> <stock> <manufacturer> <diagonal> <isSmart>`
- `REMOVE_PRODUCT <clientName> <productName>`
- `REMOVE_ALL_PRODUCTS <clientName>`
- `DISPLAY_CUSTOMERS`
- `DISPLAY_CART <clientName>`
- `DISPLAY_COMPLETE`
- `EXIT`

## Implementation Details

- Follow the principles of class encapsulation.
- Use a thread that displays the stock of all products in the store at an interval of 15 seconds.
