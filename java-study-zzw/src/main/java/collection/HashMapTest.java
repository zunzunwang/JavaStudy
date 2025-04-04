package collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zunzunwang
 * Date: 09/06/2022
 */
public class HashMapTest {
    /**
     * https://blog.51cto.com/u_15080000/2587944
     * https://blog.csdn.net/weixin_42373997/article/details/112085344
     * https://www.bilibili.com/read/cv11252491
     * https://www.cnblogs.com/skywang12345/p/3324958.html (to read)
     * HashMap is for dictionary structure.
     * key value is saved in Entry<key, value>
     * the structure of the HashMap is an Entry Array + linkedlist
     * (at java 1.8 if the size of linkedlist > 8 and  table length > 64)
     *
     * Why array and linkedList
     * array is easy for insert with index.
     * we can calculate the index of the object by his hashcode.
     * index = h ^ (h >>> 16) & (tab.length - 1).
     * the linkedList is for the collison of the hash.
     * if the index has already taken, we compare the two keys objects by equals()
     * if the equals is not true, we save in linkedlist (or reb black tree).
     * ArrayList resize is by 1.5, we prefer array to customize the resize by 2.
     *
     * Default capacity: 1 << 4 = 16
     * Max capacity 1 << 30
     * Default load factory 0.75f.
     * the resize is happened when the number of the elements is > length x load factor.
     *
     * why use the h ^ (h >>> 16)
     * avoid the collision
     *
     * just one Entry his key is null
     * HashTable not key null
     * HashTable is synchronized HashMap is not thread safe.
     * Red black Tree
     *
     * 二的幂次次作为数组长度的意义
     * 1. 方便计算index h^(h>>>16) & (tab.length - 1);
     * 2. 方便扩容 new index = old index + old table length
     * each time just use hash & old table length来确定是否要从新index
     *
     * 链表长度大于等于8 转化为红黑树 table数组长度大于等于64 (刚开始利用扩容)
     * 红黑树转链表为6 avoid retransferer beaucoup entre linkedlist et tree
     *
     * 1.8使用尾插法 尾插法可以避免多线程扩容的时候生成环
     * 复杂度 O(1) O(n) O(logn)
     *
     * find:
     * 1. get hashcode of the key object.
     * 2. calculate the index at the array
     * 3. if not object at the index return null.
     * 4. if yes check the object key equals to given key
     * 5. if not check by method red black tree or check the linkedlist
     * Tree log(N)
     * linkedList O(N)
     *
     * insert
     * 1. get hashcode of the key object.
     * 2. calculate the index at the array.
     * 3. if is null at the array insert the Entry
     * 4. if not null, check the linkedlist or red black tree to ensure the key existed or not
     * if yes replace it, if not insert at the end
     * 5. check if necessary to transfer to red black tree
     * 6. check if necessary to resize
     *
     * Why use String or Integer as key
     * we prefer to use immutable object as key.
     * String is immutable, once the object is created, his hashcode is already saved in the object.
     * each time we modify the string we will create a new object.
     * an immutable object his hash is fixed and can't be changed.
     * if you change the key object in the hashmap, generally his hashcode is also changed
     * you could lose it in the map.
     * (if you want to use mutable object as key, and you want to modify this object
     * have to ensure when you change the object the hashcode doesn't change.)
     * h*31 + val[i]
     *
     * Key need override hashcode and equals function.
     * otherwise can't find the right index
     *
     * 线程不安全:
     * 1. 1.7 will create the boucle when resize with multi thread
     * 2. multi thread put can lose data
     * 3. put not null element however get null
     *
     * solution:
     * HashTable ConcurrentHashMap
     *
     * Other Hash: MurmurHash MD4 MD5
     *
     *ConcurrentHashMap
     *
     *
     */

    public static void main(String[] args) {

        //delete element
        Map<String, String> m = new HashMap<>();
        //m.entrySet();
        String test = m.put("A","hello");
        m.put("B","bonjour");
        m.put("C","hello");
        m.put("D","hello");
        m.put("E","Bonjour");

        System.out.println(test);


        /**
         * 5 ways to iterate the HashMap:
         * 1. Iterator of EntrySet
         * 2. Iterator of keySet
         * 3. for-each of EntrySet
         * 4. for each lamda
         * 5. stream
         */

        //Iterator of EntrySet
        // Delete the french one
        System.out.println("------------------------Entry Set--------------------------");
        Iterator iterator1 = m.entrySet().iterator();
        while(iterator1.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator1.next();
            if(entry.getValue().equalsIgnoreCase("bonjour")){
                iterator1.remove();
            }
        }
        System.out.println(m.size());

        //Iterator of keySet
        System.out.println("------------------------Key Set--------------------------");
        Iterator iterator2 = m.keySet().iterator();
        while(iterator2.hasNext()) {
            iterator2.next();
        }

        //for each
        System.out.println("------------------------for each--------------------------");
        Integer i = 0;
        for(Map.Entry<String, String> e : m.entrySet()){
            //fast-fail
            //m.put(i.toString(), i.toString());
            i ++;
        }

        //lambda
        System.out.println("------------------------lambda--------------------------");
        m.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

        //stream
        System.out.println("------------------------stream--------------------------");
        m.entrySet().stream().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });







        /**
         * hashtable 的方法都是synchronized的， 并且不能接受 key value null
         * public synchronized V get(Object key)
         * public synchronized V put(K key, V value)
         * concurrentHashMap 1.8以前使用segment
         * 1.8使用synchronized +
         *
         */
        Map hashTable = new Hashtable();
        Map concurrentMap = new ConcurrentHashMap();
        Map linkedHashMap = new LinkedHashMap();
        List<String> l = new LinkedList();

        Map weakedHashMap = new WeakHashMap();
        Map identityHashMap = new IdentityHashMap();

    }
}
