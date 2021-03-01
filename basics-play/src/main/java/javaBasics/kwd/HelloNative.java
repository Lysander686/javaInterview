package javaBasics.kwd;

public class HelloNative
{
    static
    {
        System.loadLibrary("HelloNative");
    }

    // 使用native关键字说明这个方法是原生函数，也就是这个方法是用C/C++语言实现的，并且被编译成了DLL，由java去调用。
    public static native void sayHello();
     
    @SuppressWarnings("static-access")
    public static void main(String[] args)
    {
        new HelloNative().sayHello();
    }
}