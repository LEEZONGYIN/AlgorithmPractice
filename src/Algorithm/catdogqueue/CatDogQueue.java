package Algorithm.catdogqueue;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
    private int index ;
    private Queue<PetEnter> cat;
    private Queue<PetEnter> dog;


    public CatDogQueue(){
        cat = new LinkedList<>();
        dog = new LinkedList<>();
        index = 0;
    }

    public void add(Pet pet){
        if (pet.getPetType().equals("CAT")){
            cat.add(new PetEnter(pet,this.index++));
        }
        if (pet.getPetType().equals("DOG")){
            dog.add(new PetEnter(pet,this.index++));
        }
    }

    public Pet pollAll(){
       if (!this.cat.isEmpty() && !this.dog.isEmpty()){
           if (this.cat.peek().getCount()<this.dog.peek().getCount()){
               return cat.poll().getPet();
           }else {
               return dog.poll().getPet();
           }
       }else if (!this.dog.isEmpty()){
           return this.dog.poll().getPet();
       }else if (!this.cat.isEmpty()){
           return this.cat.poll().getPet();
       }else {
           throw new RuntimeException("error");
       }
    }

    public Dog pollDog(){
        if (!dog.isEmpty()){
           return (Dog) dog.poll().getPet();
        }else {
            throw new RuntimeException("error");
        }
    }

    public Cat pollCat(){
        if (!cat.isEmpty()){
            return (Cat) cat.poll().getPet();
        }else {
            throw new RuntimeException("error");
        }
    }

    public boolean isEmpty(){
        if (cat.isEmpty()&&dog.isEmpty()){
            return true;
        }else return false;
    }

    public boolean isCatEmpty(){
        if (cat.isEmpty()){
            return true;
        }else return false;
    }

    public boolean isDogEmpty(){
        if (dog.isEmpty()){
            return true;
        }else return false;
    }

}
