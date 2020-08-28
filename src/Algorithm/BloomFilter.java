package Algorithm;

import test.Main;

public class BloomFilter {
    byte[] data;
    public BloomFilter(int size){
        this.data = new byte[size];
    }

    public void add(int key){
        int loc1 = Math.abs(hash1(key) % data.length);
        int loc2 = Math.abs(hash2(key) % data.length);
        int loc3 = Math.abs(hash3(key) % data.length);
        data[loc1] = data[loc2] = data[loc3] = 1;
    }

    public boolean contains(int key){
        int loc1 = Math.abs(hash1(key) % data.length);
        int loc2 = Math.abs(hash2(key) % data.length);
        int loc3 = Math.abs(hash3(key) % data.length);

        return data[loc1]*data[loc2]*data[loc3] == 1;
    }

    private int hash1(Integer key){
        int hashCode = key.hashCode();
        return hashCode;
    }
    private int hash2(Integer key){
        int hashCode = key.hashCode();
        return hashCode ^ (hashCode>>3);
    }
    private int hash3(Integer key){
        int hashCode = key.hashCode();
        return hashCode ^ (hashCode>>16);
    }

}
