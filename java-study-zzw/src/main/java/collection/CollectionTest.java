package collection;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.sun.scenario.effect.Identity;
import helloWorld.HelloWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by zunzunwang
 * Date: 09/06/2022
 */
public class CollectionTest {
    /**
     * Difference between collection and array
     * 1. array is for fixed range. collection is for dynamic range.
     * 2. array can't be used for mapping. collection could be useful for mapping.
     * 3. array could be used for basic type or object. collection only for object.
     */

    /**
     * Collection and Map is the two roots.
     *
     * Sous Collection:
     * List, Set, Queue
     *
     *
     * Sous Map
     *
     * @param args
     */


    public static void main(String[] args) {

        HelloWorld[] hla = new HelloWorld[10];
        String[] strArray = new String[]{"h", "e", "l", "l", "o"};
        //Array can't use stream.

        List<String> strList = new ArrayList<>();
        String t = new String();
        t = "test";
        strList.add(t);
        System.out.println(strList.contains("test"));






    }
}
