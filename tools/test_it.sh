#!/bin/bash

create_new_cart() {
    local cart_data="$1"

    curl -s -X POST http://localhost:8080/cart -H "Content-Type: application/json" -d "$cart_data"
}

# Main function to run the test script
main() {
    local cart_data

    echo "Create an example cart"
    echo "-------------------"

    cart_data='{
        "cart": {
            "cartItems": [
                {
                    "equipmentTypeId": "alpine_medium",
                    "ageCategoryId": "adult",
                    "quantity": 2
                },
                {
                    "equipmentTypeId": "alpine_advanced",
                    "ageCategoryId": "adult",
                    "quantity": 2
                },
                {
                    "equipmentTypeId": "alpine_medium",
                    "ageCategoryId": "youth",
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_beginner",
                    "ageCategoryId": "child",
                    "quantity": 3
                }
            ]
        }
    }'

    create_new_cart "$cart_data" | jq
    echo "-------------------"

    echo "Same(?) cart but resolve age category from age in years"
    echo "-------------------"
    cart_data='{
        "cart": {
            "cartItems": [
                {
                    "equipmentTypeId": "alpine_medium",
                    "ageInYears": 35,
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_medium",
                    "ageInYears": 40,
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_advanced",
                    "ageInYears": 80,
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_advanced",
                    "ageInYears": 63,
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_medium",
                    "ageInYears": 13,
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_beginner",
                    "ageInYears": 3,
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_beginner",
                    "ageInYears": 5,
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_beginner",
                    "ageInYears": 9,
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_beginner",
                    "ageInYears": 11,
                    "quantity": 1
                }
            ]
        }
    }'

    create_new_cart "$cart_data" | jq
    echo "-------------------"

    echo "Same cart but with location based discounts"
    echo "-------------------"
    cart_data='{
        "discountData": {
            "location": {
                "latitude": 56.6759,
                "longitude": 12.8582
            }
        },
        "cart": {
            "cartItems": [
                {
                    "equipmentTypeId": "alpine_medium",
                    "ageCategoryId": "adult",
                    "quantity": 2
                },
                {           
                    "equipmentTypeId": "alpine_advanced",
                    "ageCategoryId": "adult",
                    "quantity": 2
                },
                {
                    "equipmentTypeId": "alpine_medium",
                    "ageCategoryId": "youth",
                    "quantity": 1
                },
                {
                    "equipmentTypeId": "alpine_beginner",
                    "ageCategoryId": "child",
                    "quantity": 3
                }
            ]
        }
    }'

    create_new_cart "$cart_data" | jq
    echo "-------------------"
}

main "$@"