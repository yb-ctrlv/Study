package LinkedList;

import java.util.LinkedList;

import LinkedList.Animal.AnimalShelter;
import LinkedList.Animal.Cat;
import LinkedList.Animal.Dog;
enum AnimalType{
	DOG, CAT
}
abstract class Animal{
	AnimalType type;
	String name;
	int order;
	Animal(AnimalType type, String name){
		this.type = type;
		this.name = name;
	}
	void setOrder(int order) {
		this.order = order;
	}
	int getOrder() {
		return order;
	}
	String info() {
		return order + ") type :" + type + ", name: "+ name;
	}
static class Dog extends Animal{
	Dog(String name){
		super(AnimalType.DOG, name);
	}
}
static class Cat extends Animal{
	Cat(String name){
		super(AnimalType.CAT, name);
	}
}
static class AnimalShelter{
	LinkedList<Dog> dogs = new LinkedList<Dog>() ;
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order;
	AnimalShelter(){
		order = 1;
	}
	void enqueue(Animal animal) {
		animal.setOrder(order);
		order++;
		if(animal.type == AnimalType.DOG) {
			dogs.addLast((Dog) animal);
		}else if(animal.type == AnimalType.CAT) {
			cats.addLast((Cat) animal);
		}
	}
	Animal dequeueDog() {
		return dogs.poll();
	}
	Animal dequeueCat() {
		return cats.poll();
	}
	Animal dequeue() {
		if(dogs.size() == 0 && cats.size() == 0) {
			return null;
		}else if(dogs.size() == 0) {
			return cats.poll();
		}else if(cats.size() == 0) {
			return dogs.poll();
		}
		
		Animal dog = dogs.peek();
		Animal cat = cats.peek();
		if(cat.order < dog.order) {
			return cats.poll();
		}else {
			return dogs.poll();
		}
	}
}
}
public class LinkedListToQueue {
	//개와 고양이만 분양하는 분양소가 있다.
	//분양받는 사람은 동물의 종류만 고를수 있고, 분양소에서
	//가장 오래 있은 순서로 자동으로 분양될 동물이 정해지는 클래스 구현
	//linkedList로만 구현 (선입선출를 구현하기!)
	
	public static void main(String[] args) {
		Dog d1 = new Dog("dog1");
		Dog d2 = new Dog("dog2");
		Dog d3 = new Dog("dog3");
		Cat c1 = new Cat("cat1");
		Cat c2 = new Cat("cat2");
		Cat c3 = new Cat("cat3");
		
		AnimalShelter as = new AnimalShelter();
		as.enqueue(d1);
		as.enqueue(c1);
		as.enqueue(d2);
		as.enqueue(c2);
		as.enqueue(d3);
		as.enqueue(c3);
		
		System.out.println(as.dequeueCat().info());
		System.out.println(as.dequeueDog().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
	}
}
