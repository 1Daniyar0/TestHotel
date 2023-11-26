package com.example.entity

data class HotelResponse (
        val id: Int,
        val name: String,
        val adress: String,
        val minimal_price: Int,
        val price_for_it: String,
        val rating: Int,
        val rating_name: String,
        val image_urls: List<String>,
        val about_the_hotel: AboutHotel
)

data class AboutHotel(
        val description: String,
        val peculiarities: List<String>
)

data class RoomsResponse(
        val rooms: List<Room>
)

data class Room(
        val id: Int,
        val name: String,
        val price: String,
        val price_per: String,
        val peculiarities: List<String>,
        val image_urls: List<String>,
)

data class PaymentDetails(
        val id: Int,
        val hotel_name: String,
        val hotel_adress: String,
        val horating: String,
        val rating_name: String,
        val departure: String,
        val arrival_country: String,
        val tour_date_start: String,
        val tour_date_stop: String,
        val number_of_nights: String,
        val room: String,
        val nutrition: String,
        val tour_price: Int,
        val fuel_charge: Int,
        val service_charge: Int
)

