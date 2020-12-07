package com.company;

public class OrderAlreadyAddedException extends Throwable{
    public String Error(RestaurantOrder order) {
        return "Этот столик уже занят!";
    }
    public String Error(InternetOrder order) {
        return "Этот столик уже занят!";
    }
}
