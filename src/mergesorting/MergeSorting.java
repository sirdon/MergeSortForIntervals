/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesorting;

import java.util.Scanner;

/**
 *
 * @author AMIT
 */
public class MergeSorting {

    /**
     * @param args the command line arguments
     */
    static class Node{
        int left;
        int right;
    }
    static void mergesort(Node arr[], int l, int mid, int r){
        int leftsize = mid-l+1; //left array size
        int rightsize = r-mid;  //right array size
        Node leftarr[] = new Node[leftsize];  //laft array initialization
        Node rightarr[] = new Node[rightsize];    //right array initialization
        //coping data into left and right array
        for(int i=0;i<leftsize;++i){
            leftarr[i] = new Node();
            leftarr[i].left = arr[l+i].left;
            leftarr[i].right = arr[l+i].right;
        }
        for(int i=0;i<rightsize;++i){
            rightarr[i] = new Node();
            rightarr[i].left = arr[mid+1+i].left;
            rightarr[i].right = arr[mid+1+i].right;
        }
        //merge
        int i=0,j=0;
        int k=l; //initial index of the array
        while(i<leftsize&&j<rightsize){
            if(leftarr[i].left<=rightarr[j].left){
                arr[k].left=leftarr[i].left;
                arr[k].right=leftarr[i].right;
                i++;
            }
            else if(leftarr[i].left>rightarr[j].left){
                arr[k].left=rightarr[j].left;
                arr[k].right=rightarr[j].right;
                j++;
            }
            k++;
        }
        while(i<leftsize){
            arr[k].left=leftarr[i].left;
            arr[k].right=leftarr[i].right;
            i++;
            k++;
        }
        while(j<rightsize){
            arr[k].left=rightarr[j].left;
            arr[k].right = rightarr[j].right;
            j++;
            k++;
        }
    }
    static void sort(Node arr[], int l,int r){
        if(l<r){
            int mid = (l+r)/2;
            sort(arr,l,mid);
            sort(arr,mid+1,r);
            mergesort(arr,l,mid,r);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter the size of the array ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Node arr[] = new Node[size];
        for(int i=0;i<size;i++){
            arr[i]=new Node();
            arr[i].left=sc.nextInt();
            arr[i].right=sc.nextInt();
        }
        sort(arr,0,size-1);
        for(int i=0;i<size;i++)
            System.out.println(arr[i].left +" "+arr[i].right);
    }
    
}
