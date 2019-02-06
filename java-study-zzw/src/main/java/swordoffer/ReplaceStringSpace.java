package swordoffer;

import java.util.List;

public class ReplaceStringSpace {
    public String replaceSpace(StringBuffer str) {
        //return str.toString().replaceAll(" ", "%20");
        int length = str.length();
        StringBuffer subString = new StringBuffer();
        for (int i = 0; i < length; i++) {
            subString.append(str.charAt(i) != ' ' ? str.charAt(i) : "%20");
        }
        return subString.toString();

    }

    public String replaceSpaceTime(StringBuffer str) {
        int spacenum = 0;//spacenum为计算空格数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spacenum++;
        }
        int indexold = str.length()-1; //indexold为为替换前的str下标
        int newlength = str.length() + spacenum*2;//计算空格转换成%20之后的str长度
        int indexnew = newlength-1;//indexold为为把空格替换为%20后的str下标
        str.setLength(newlength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
        for(;indexold>=0 && indexold<newlength;--indexold){
            if(str.charAt(indexold) == ' '){  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }

    public static void main(String[] args){
        ReplaceStringSpace r = new ReplaceStringSpace();

        System.out.println(r.replaceSpaceTime(new StringBuffer("hello world")));

    }

}
