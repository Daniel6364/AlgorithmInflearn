package com.inflearn.category3.no1두배열합치기;


import java.util.*;

/**
 * @Package : com.inflearn.category3.no1두배열합치기
 * @Class : Main 
 * @Description :   설명
 *
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 *
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 *
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 *
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 *
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 *
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 *
 * @Date : 2022/03/12 10:12
 * @Author : Daniel
 * @Comment : 
 */
public class Main {

    public int[] solution(int[] input1, int[] input2) {

        int[] answer = new int[input1.length + input2.length - 1];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int input : input1) treeSet.add(input);
        for (int input : input2) treeSet.add(input);

        int count = 0;
        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            answer[count] = (int) iterator.next();
            count++;
        }

        return answer;
    }


    public static void main(String[] args) {
//        int[] input1 = {1, 3, 5};
//        int[] input2 = {2, 3, 6, 7, 9};
//
//        Main main = new Main();
//        System.out.println(Arrays.toString(main.solution(input1, input2)));

        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] inputArr1 = new int[input1];
        for (int i = 0; i < inputArr1.length; i++) {
            System.out.println("arr1 : " + i);
            inputArr1[i] = in.nextInt();
        }


        int input2 = in.nextInt();
        int[] inputArr2 = new int[input2];
        for (int i = 0; i < inputArr2.length; i++) {
            System.out.println("arr2 : " + i);
            inputArr2[i] = in.nextInt();
        }
        System.out.println(input1 + input2);


        Main main = new Main();
        System.out.println(Arrays.toString(main.solution(inputArr1, inputArr2)));

        return ;

    }
    
}
