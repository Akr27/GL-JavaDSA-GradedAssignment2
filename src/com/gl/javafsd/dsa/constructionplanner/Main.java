package com.gl.javafsd.dsa.constructionplanner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private int totalFloors;
    private ArrayList<Integer> floorSizeArray=new ArrayList<>();

    public Main(int totalFloors, ArrayList<Integer> floorSizeArray) {
        this.totalFloors = totalFloors;
        this.floorSizeArray = floorSizeArray;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public ArrayList<Integer> getFloorSizeArray() {
        return floorSizeArray;
    }

    public void setFloorSizeArray(ArrayList<Integer> floorSizeArray) {
        this.floorSizeArray = floorSizeArray;
    }

    private int generateTotalFloors(){
        System.out.println("Welcome to Construction Planner!");
        System.out.println("Enter the total number of floors: ");
        Scanner sc=new Scanner(System.in);
        int floors= sc.nextInt();
        return floors;
    }

    private ArrayList<Integer> generateWorkDist(){
        for (int i=0;i<totalFloors;i++){
            int day=i+1;
            System.out.println("Enter the floor on day "+day+" : ");
            Scanner sc=new Scanner(System.in);
            int flr= sc.nextInt();
            floorSizeArray.add(i,flr);
        }

        return floorSizeArray;
    }

    private ArrayList<ArrayList<Integer>> calculateFloors(){
        ArrayList<Integer> dayArray = new ArrayList<>();
        ArrayList<ArrayList<Integer>> calculatedFloorSize = new ArrayList<>();

        for(int i=0;i<totalFloors;i++){
            if(floorSizeArray.get(i)== Collections.max(floorSizeArray)){
                dayArray.add(floorSizeArray.get(i));
                floorSizeArray.remove(i);
                floorSizeArray.add(i,0);
                calculatedFloorSize.add(i,dayArray);
                dayArray.clear();

            }

            else {
                dayArray.add(floorSizeArray.get(i));
                floorSizeArray.remove(i);
                floorSizeArray.add(i,0);
                ArrayList<Integer> nullArray=new ArrayList<>();
                nullArray.add(0);
                calculatedFloorSize.add(i,nullArray);
            }
        }

        return calculatedFloorSize;

    }


    public static void main(String[] args) {
        Main constructionPlan=new Main();
        int n=constructionPlan.generateTotalFloors();
        ArrayList<ArrayList<Integer>> dayWiseWork=constructionPlan.calculateFloors();

        for (int i=0;i< constructionPlan.totalFloors;i++){
            int day=i+1;
            System.out.println("Floor(s) assembled on Day "+day+" : "+dayWiseWork.get(i));
        }


    }
}

