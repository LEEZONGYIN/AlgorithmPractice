package Algorithm.catdogqueue;

import java.util.Queue;

public class PetEnter {
    private Pet pet;
    private int count;

    public PetEnter(Pet pet,int count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType(){
        return this.pet.getPetType();
    }
}
