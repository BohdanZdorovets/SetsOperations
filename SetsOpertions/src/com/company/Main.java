package com.company;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static ArrayList<Integer> createMainSet(int numbers) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i <= numbers; i++) {
            set.add(i);
        }
        return set;

    }

    public static ArrayList<Integer>
    createSubset(ArrayList<Integer> U) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < U.size(); i++) {
            if ((int) (Math.random() * 2) == 1) {
                set.add(U.get(i));
            }
        }
        return set;
    }

    public static void printSet(ArrayList<Integer> set) {
        System.out.print("[");
        for (int i = 0; i < set.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(set.get(i));
        }
        System.out.println("]");
        System.out.println();
    }

    public static ArrayList<Integer>
    toBinarySet(ArrayList<Integer> U, ArrayList<Integer> set) {
        ArrayList<Integer> binary = new ArrayList<>();
        for (int i = 0; i < U.size(); i++) {
            if (set.indexOf(U.get(i)) != -1) {
                binary.add(1);
            } else {
                binary.add(0);
            }
        }
        return binary;
    }

    public static ArrayList<Integer> toSet(ArrayList<Integer> U, ArrayList<Integer> binarySet) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < binarySet.size(); i++) {
            if (binarySet.get(i) == 1) {
                set.add(U.get(i));
            }
        }
        return set;
    }

    public static ArrayList<Integer> union(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> U){
        ArrayList<Integer> buffer = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i =0; i < A.size(); i++){
            buffer.add(A.get(i) | B.get(i));
        }

        for(int i = 0; i < U.size(); i++){
            if(buffer.get(i) == 1){
                res.add(U.get(i));
            }
        }

        return res;
    }

   public static ArrayList<Integer> addition(ArrayList<Integer> set, ArrayList<Integer> U){
       ArrayList<Integer> buffer = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

       for(int i = 0; i < set.size(); i++){
           if(set.get(i) == 1){
               buffer.add(0);
           }else{
               buffer.add(1);
           }
       }

       for(int i = 0; i < U.size(); i++){
           if(buffer.get(i) == 1){
               res.add(U.get(i));
           }
       }
       return res;
   }

    public static ArrayList<Integer> intersection(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> U){
        ArrayList<Integer> buffer = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i =0; i < A.size(); i++){
            buffer.add(A.get(i) & B.get(i));
        }

        for(int i = 0; i < U.size(); i++){
            if(buffer.get(i) == 1){
                res.add(U.get(i));
            }
        }

        return res;
    }

    public static ArrayList<Integer> sysDifference(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> U){
        ArrayList<Integer> buffer = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i =0; i < A.size(); i++){
            buffer.add(A.get(i) ^ B.get(i));
        }

        for(int i = 0; i < U.size(); i++){
            if(buffer.get(i) == 1){
                res.add(U.get(i));
            }
        }

        return res;
    }



    public static void main(String[] args) {
        ArrayList<Integer> U = createMainSet(20); //U: [0..20]
        ArrayList<Integer> A = createSubset(U);
        ArrayList<Integer> B = createSubset(U);
        ArrayList<Integer> binaryA = toBinarySet(U, A);
        ArrayList<Integer> binaryB = toBinarySet(U, B);

        System.out.print("U: ");
        printSet(U);

        System.out.print("A: ");
        printSet(A);
        System.out.print("B: ");
        printSet(B);

        System.out.print("Binary A: ");
        printSet(binaryA);
        System.out.print("Binary B: ");
        printSet(binaryB);

        System.out.print("A union B: ");
        printSet(union(binaryA, binaryB, U));

        System.out.print("Addition(A,U): ");
        printSet(addition(binaryA, U));

        System.out.print("Addition(B,U): ");
        printSet(addition(binaryB, U));

        System.out.print("Intersection: ");
        printSet(intersection(binaryA, binaryB, U));

        System.out.print("Systemric Differnce:");
        printSet(sysDifference(binaryA, binaryB, U));



    }
}