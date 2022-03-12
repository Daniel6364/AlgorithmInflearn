package com.inflearn.category4.no1학급회장;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Package : com.inflearn.category4.no1학급회장
 * @Class : Main 
 * @Description :   설명
 *
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 *
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
 *
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
 *
 * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
 *
 *
 * 입력
 * 첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
 *
 * 두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
 *
 *
 * 출력
 * 학급 회장으로 선택된 기호를 출력합니다
 *
 * 15
 * BACBACCACCBDEDE
 *
 *
 * @Date : 2022/03/12 12:17
 * @Author : Daniel
 * @Comment : solution2로 풀이한 것이 더 효율적이라 생각한다.
 *
 * hashmap 을 이용하여 value로 key값을 찾는 연습이 핵심이다.
 */
public class Main {
    
    public String solution(String input2) {

        String answer = "";

        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < input2.length(); i++) {
            treeSet.add(String.valueOf(input2.charAt(i)));
        }

        int[] count = new int[treeSet.size()];
        String[] strList = new String[treeSet.size()];

        Iterator<String> iterator = treeSet.iterator();
        int cnt = 0;
        while (iterator.hasNext()) {
            strList[cnt] = iterator.next();
            cnt++;
        }

        for (int i = 0; i < input2.length(); i++) {
            for (int j = 0; j < strList.length; j++) {
                if (String.valueOf(input2.charAt(i)).equals(strList[j])) {
                    count[j]++;
                }
            }
        }

        int maxCountIndex = 0;
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
                maxCountIndex = i;
            }
        }

        answer = strList[maxCountIndex];

        return answer;

    }

    public String solution2(String input2) {

        String answer = "";

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < input2.length(); i++) {
            if (hashMap.containsKey(input2.charAt(i))) {
                hashMap.put(input2.charAt(i), hashMap.get(input2.charAt(i)) + 1);
            } else {
                hashMap.put(input2.charAt(i), 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int value : hashMap.values()) if(max < value) max = value;

        for (Character key : hashMap.keySet()) {
            Integer value = hashMap.get(key);
            if (value == max) answer = String.valueOf(key);
        }

        return answer;

    }

    public static void main(String[] args) {
        int input1 = 15;
        String input2 = "BACBACCACCBDEDE";

        Main main = new Main();
//        System.out.println(main.solution(input2));
        System.out.println(main.solution2(input2));
    }
    
}
