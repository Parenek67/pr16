package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws OrderAlreadyAddedException, IllegalTableNumber {
	Item d = new Drink("Пиво", "алкогольный напиток", 300);
	Item whiskey = new Drink("Виски", "алкогольный напиток", 1000);
	Item sosiska = new Dish("Сосиска", "натуральная", 500);
	Item buter = new Dish("Бутер", "с маслом", 150);
	Item sosiska2 = new Dish("Сосиска", "ыыы", 200);

	InternetOrder i = new InternetOrder(new Item[]{whiskey,sosiska,buter,sosiska2});
	System.out.println(i.getNodeByIndex(1).value);
	System.out.println(i.itemQuantity());
	i.add(d);
	System.out.println((Arrays.toString(i.names_without_equals())));
	System.out.println(i.removeAll("Сосиска"));
	System.out.println(Arrays.toString(i.itemsNames()));
	System.out.println(i.costTotal());
	System.out.println(Arrays.toString(i.sort_by_price()));

	System.out.println("---------");

	RestaurantOrder a = new RestaurantOrder();
	a.add(buter);
	a.add(sosiska);
	a.add(whiskey);
	for(Item it: a.sort_by_price())
		System.out.print(it.getName() + " " + it.getCost()+"; ");
	System.out.println("\n" + a.costTotal());
	for(Item it: a.getItems())
		System.out.print(it.getName() + ", " + it.getCost()+ "; ");
	System.out.println("\n" + Arrays.toString(a.itemsNames()));
	a.removeAll("Сосиска");
	System.out.println(a.itemQuantity());
	System.out.println(a.itemQuantity("Бутер"));
	RestaurantOrder b = new RestaurantOrder();
	b.add(d);
	b.add(sosiska2);

	System.out.println("---------");

	OrderManager ordm = new OrderManager();
	ordm.add(a, 1);
	ordm.add(b, 2);
	System.out.println(Arrays.toString(ordm.freeTableNumbers()));
	System.out.println(ordm.dishQuantity("Сосиска"));
	System.out.println(Arrays.toString(ordm.getOrder(1).itemsNames()));
	System.out.println(ordm.orderCostSummary());
	//System.out.println(Arrays.toString(ordm.getOrders()));
	for(RestaurantOrder ord: ordm.getOrders()){
		System.out.println(Arrays.toString(ord.itemsNames()));
	}
	ordm.removeOrder(1);
	System.out.println(ordm.orderCostSummary());
	ordm.addDish(sosiska, 2);
	System.out.println(ordm.orderCostSummary());

	System.out.println("---------ы");

	InternetOrder i1 = new InternetOrder(new Item[]{whiskey,sosiska,buter,sosiska2});
	InternetOrder i2 = new InternetOrder(new Item[]{d,sosiska});
	ordm.add("ул Пушкина 1", i1);
	ordm.add("ул Пушкина 2", i2);
	System.out.println(Arrays.toString(ordm.getOrder("ул Пушкина 1").itemsNames()));
	ordm.removeOrder("ул Пушкина 2");
	ordm.addDish("ул Пушкина 1", d);
	for(InternetOrder ord: ordm.get_int_ord())
		System.out.println(Arrays.toString(ord.sort_by_price()));
	System.out.println(ordm.int_ord_sum());
	System.out.println(ordm.func("Сосиска"));
    }
}
