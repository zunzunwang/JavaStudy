package IBM;

public class Base {
    public String baseName = setFatherBaseName();
    public Base(){
        System.out.println("This is base constructor.");
        callName();
    }

    private String setFatherBaseName(){
        System.out.println("Set Father base name");
        return "base";
    }

    public void callName(){
        System.out.println(baseName);
    }
}

class Sub extends Base{
    //public String baseName;// = setSonBaseName();
    public void callName(){
        System.out.println(baseName);
    }

    private String setSonBaseName(){
        System.out.println("set Son base name");
        return "sub";
    }

    public Sub(){
        System.out.println("This is sub constructor.");
    }
}

class Main{
    public static void main(String[] args){
        Base b = new Sub();
    }
}

