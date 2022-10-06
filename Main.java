package com.LabHeaps;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String user = "";
        boolean heap = false;

        Heap array = new Heap();
        do{
            Scanner myObj = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter a Number, 'Remove', or 'Quit': ");
            user = myObj.nextLine();

            if(user.equals("Remove"))
                array.PrintRemoveHeap();
            else if(user.equals("Quit")){
                heap = true;
            }
            else{
                array.PrintAddHeap(user);
            }

        }while(heap == false);
    }
}
