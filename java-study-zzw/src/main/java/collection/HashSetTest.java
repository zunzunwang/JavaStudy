package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by zunzunwang
 * Date: 09/06/2022
 */
public class HashSetTest {
    private static class StudentWithoutHashCode{
        private String name;
        private int age;

        public StudentWithoutHashCode(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o){
            if (o == this){
                return true;
            }

            if (o instanceof StudentWithoutHashCode) {
                StudentWithoutHashCode s = (StudentWithoutHashCode) o;
                return s.name.equals(this.name) && s.age == (this.age);
            }

            return false;
        }
    }

    private static class StudentWithHashCode {
        private String name;
        private int age;
        public StudentWithHashCode (String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode(){
            return name.hashCode() + age;
        }

        @Override
        public boolean equals(Object o){
            if(o == this){
                return true;
            }

            if(o instanceof StudentWithHashCode){
                StudentWithHashCode s = (StudentWithHashCode) o;
                return s.name.equals(this.name) && s.age == this.age;
            }

            return false;
        }
    }

    /**
     * 1. Elements in HashSet can't be double.
     * 2. Elements in HashSet don't have order.
     * 3. HashSet is not thread save. should use code to synchronize.
     * 4. null can be an element.
     */

    /**
     * HashSet save structure.
     * HashSet use HashMap to save.
     * All elements are saved in the key of the HashMap. value is a static PRESENT.
     */
    public static void main(String[] args) {
        Set<StudentWithHashCode> hashSet1 = new HashSet<StudentWithHashCode>();
        Set<StudentWithoutHashCode> hashSet2 = new HashSet<StudentWithoutHashCode>();
        StudentWithHashCode student1 = new StudentWithHashCode("student1", 10);
        StudentWithHashCode student11 = new StudentWithHashCode("student1", 10);
        StudentWithoutHashCode student2 = new StudentWithoutHashCode("student2", 10);
        StudentWithoutHashCode student22 = new StudentWithoutHashCode("student2", 10);

        hashSet1.add(student1);
        hashSet1.add(student11);
        System.out.println("class with hashcode: " + hashSet1.size());

        hashSet2.add(student2);
        hashSet2.add(student22);
        System.out.println("class without hashcode: " + hashSet2.size()); //hashcode est different.

        /**
         * 遍历hashset
         * https://blog.csdn.net/weixin_44325444/article/details/102313412?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-102313412-blog-77757754.pc_relevant_aa&spm=1001.2101.3001.4242.1&utm_relevant_index=2
         * 内部存储是用的hashmap
         * 所以18在两次计算index的时候结果不一样
         * >>带符号右移 >>>无符号右移
         * 第一次 hash = h^(h>>>16)
         * (tab.length-1) & hash
         * 18第一次算下来为
         */
        Set<Integer> strSet = new HashSet<Integer>();
        strSet.add(1);
        strSet.add(18);
        strSet.add(2);
        strSet.add(3);
        strSet.add(4);
        //iterator
        Iterator iterator = strSet.iterator();
        Integer i;
        while(iterator.hasNext()) {
            i = (Integer) iterator.next();
            System.out.println(i);
        }
        System.out.println("---------------------------------");
        strSet.clear();
        strSet.add(1);
        strSet.add(18);
        for (int j = 1; j < 15; j++){
            strSet.add(j);
        }
        for(Integer iTmp : strSet) {
            System.out.println(iTmp);
        }

        LinkedHashSet linkedHashSet = new LinkedHashSet();
    }

}
