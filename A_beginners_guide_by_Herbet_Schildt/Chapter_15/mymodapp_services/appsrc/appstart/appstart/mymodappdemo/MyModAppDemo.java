// Updated to use SupportFuncs.
package appstart.mymodappdemo;

import appfuncs.simplefuncs.SimpleMathFuncs;
import appsupport.supportfuncs.SupportFuncs;
import java.util.ServiceLoader;

import userfuncs.binaryfuncs.BinFuncProvider;
import userfuncs.binaryfuncs.BinaryFunc;


public class MyModAppDemo {
    private static BinaryFunc getBinaryFunc(ServiceLoader<BinFuncProvider> loader, String s) {
        for (BinFuncProvider bfp : loader) {
            if (bfp.get().getName().equals(s)) {
                return bfp.get();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Now, isFactor() is referred to via SupportFuncs, not SimpleMathFuncs.
        if (SupportFuncs.isFactor(2, 10))
            System.out.println("2 is a factor of 10");
        System.out.println("Smallest factor common to both 35 and 105 is " +
                SimpleMathFuncs.lcf(35, 105));
        System.out.println("Largest factor common to both 35 and 105 is " +
                SimpleMathFuncs.gcf(35, 105));

        ServiceLoader<BinFuncProvider> loader = ServiceLoader.load(BinFuncProvider.class);
        BinaryFunc binOp = null;
        binOp = getBinaryFunc(loader, "absPlus");

        if (binOp != null) {
            System.out.println("Result of absPlus function: " + binOp.func(12, -4));
        } else {
            System.out.println("absPlus function not found");
        }

        binOp = getBinaryFunc(loader, "absMinus");

        if (binOp != null) {
            System.out.println("Result of absPlus function: " + binOp.func(12, -4));
        } else {
            System.out.println("absPlus function not found");
        }
    }
}