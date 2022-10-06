package com.LabHeaps;

import java.util.Scanner;

public class Heap {
    private int array[];
    public int numbEntered;
    private int start = 1;
    private int end = 1;
    private int goingUp;
    private int goingDown;


    public Heap(){
        array = new int[25];
        UserInputNumber();
        array[start] = numbEntered;
    }

    public void UserInputNumber(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a Number");
        numbEntered = Integer.parseInt(myObj.nextLine());
    }

    public boolean LowToHighAdd(){
        if(numbEntered >= array[goingUp/2]){
            array[goingUp] = numbEntered;
            return false;
        }
        else if(numbEntered < array[goingUp/2]){
            array[goingUp] = array[goingUp/2];
            array[goingUp/2] = numbEntered;
            goingUp = goingUp/2;
            return true;
        }
        else {
            return false;
        }
    }

    public void PyramidPrint(){
        for(int i = start; array[i] != 0; i++) {
            if (i == 1) {
                System.out.println("              " + array[i]);
            }

            if (i == 2) {
                System.out.print("            " + array[i]);
            }
            if (i == 3) {
                System.out.println("  " + array[i]);
            }

            if (i == 4) {
                System.out.print("        " + array[i]);
            }
            if (i == 5) {
                System.out.print("  " + array[i]);
            }
            if (i == 6) {
                System.out.print("  " + array[i]);
            }
            if (i == 7) {
                System.out.println("  " + array[i]);
            }

            if (i == 8) {
                System.out.print("      " + array[i]);
            }
            if (i == 9) {
                System.out.print(" " + array[i]);
            }
        }
    }

    public void PrintAddHeap(String numberIn){
        Add(numberIn);
        PyramidPrint();
    }

    public void PrintRemoveHeap(){
        Remove();
        PyramidPrint();
    }

    public void Add(String numberIn){
        end++;
        goingUp = end;
        numbEntered = Integer.parseInt(numberIn);
        while(LowToHighAdd() == true) {
            LowToHighAdd();
        }
    }

    public void Remove(){
        goingDown = 1;
        array[start] = array[end];
        array[end] = 0;
        end--;
        while(PriorityHighToLow() == true) {
            PriorityHighToLow();
        }
    }

    public boolean PriorityHighToLow(){
        int temporary = array[goingDown];
        if(array[goingDown*2] < array[goingDown] && 0 != array[(goingDown*2)+1] && array[goingDown*2] < array[(goingDown*2)+1]){
            array[goingDown] = array[goingDown*2];
            array[goingDown*2] = temporary;
            goingDown = goingDown*2;
            return true;
        }
        else if(array[(goingDown*2)+1] < array[goingDown] && 0 != array[(goingDown*2)+1]){
            array[goingDown] = array[(goingDown*2)+1];
            array[(goingDown*2)+1] = temporary;
            if(array[goingDown] > array[(goingDown*2)+1])
                goingDown = goingDown*2;
            return true;
        }
        else{
            return false;
        }

    }
}
