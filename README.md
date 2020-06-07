# cvc-backend-hotel

# Jonatas Almeida

-------- Recursos Utilizados ----------
Java 8;
Spring;
TDD;
Webclient (Async api)
Server Compression (Melhorias de performance)
Json non-nullable (Melhorias de performance)

--------Resultados obtidos --------------
Teste 1 (Obter valores de hotéis por estadia e Cidade) 
localhost:8080/hotels-available?cityCode=1032&checkIn=2020-06-01&checkOut=2020-06-04&adultNumber=2&childNumber=1

[
    {
        "cityName": "Porto Seguro",
        "rooms": [
            {
                "roomID": 0,
                "categoryName": "Standard",
                "totalPrice": 15401.52,
                "priceDetail": {
                    "pricePerDayAdult": 1960.77,
                    "pricePerDayChild": 1212.3
                }
            }
        ],
        "id": 1
    },
    {
        "cityName": "Porto Seguro",
        "rooms": [
            {
                "roomID": 0,
                "categoryName": "Standard",
                "totalPrice": 6281.4,
                "priceDetail": {
                    "pricePerDayAdult": 488.23,
                    "pricePerDayChild": 1117.34
                }
            },
            {
                "roomID": 1,
                "categoryName": "Luxo",
                "totalPrice": 6674.46,
                "priceDetail": {
                    "pricePerDayAdult": 690.03,
                    "pricePerDayChild": 844.76
                }
            }
        ],
    ...]

Status 200OK
Time 693 ms
Size: 297.46 KB

---------------------------------------------------------------------------------------------------------------------
Teste 2 (Obter valores de hotel por estadia e código de hotel) 

localhost:8080/hotel-available?hotelID=1&checkIn=2020-06-01&checkOut=2020-06-04&adultNumber=2&childNumber=1

Status: 200OK
Time: 458 ms
Size: 387 B

[
    {
        "cityName": "Porto Seguro",
        "rooms": [
            {
                "roomID": 0,
                "categoryName": "Standard",
                "totalPrice": 15401.52,
                "priceDetail": {
                    "pricePerDayAdult": 1960.77,
                    "pricePerDayChild": 1212.3
                }
            }
        ],
        "id": 1
    }
]
