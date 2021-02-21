package javaAdvanced.javaVirtualMachine.csdn2;

import java.lang.instrument.Instrumentation;

/** package command:
 *  javac MySizeOf.java
 * */
public class MySizeOf {
    private static Instrumentation inst;
    /**
      *这个方法必须写，在agent调用时会被启用
      */
    public static void premain(String agentArgs, Instrumentation instP) {
        inst = instP;
    }
   
    //用来测量java对象的大小（这里先理解这个大小是正确的，后面再深化）
    public static long sizeOf(Object o) {
        if(inst == null) {
           throw new IllegalStateException("Can not access instrumentation environment.\n" +
              "Please check if jar file containing SizeOfAgent class is \n" +
              "specified in the java's \"-javaagent\" command line argument.");
         }
         return inst.getObjectSize(o);
     }
}