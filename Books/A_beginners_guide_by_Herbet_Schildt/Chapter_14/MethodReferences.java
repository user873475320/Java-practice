package Books.A_beginners_guide_by_Herbet_Schildt.Chapter_14;


class FunctionalInterfaces {
    interface DefaultFuncInterface{
        boolean test(int a, int b);
    }

    interface MethodReferencesThroughClassName {
        boolean test(MethodImplementations ob, int a, int b);
    }

    interface GenericFuncInterface<T extends Number> {
        boolean test(T a, T b);
    }

    interface ConstructorReference {
        MethodImplementations func(String s);
    }

}

class MethodImplementations {
    private String forConstructorReference;

    public MethodImplementations() {
    }

    public MethodImplementations(String forConstructorReference) {
        this.forConstructorReference = forConstructorReference;
        System.out.println(forConstructorReference);
    }

    public boolean instanceIsFactor(int a, int b) {
        return (a % b) == 0;
    }

    public static boolean staticIsFactor(int a, int b) {
        return (a % b) == 0;
    }

    public static <T extends Number> boolean genericIsFactor(T a, T b) {
        return (a.intValue() % b.intValue()) == 0;
    }
}

class TestAll {
    public static void main(String[] args) {
        {
            // Method Reference to the static Method
            FunctionalInterfaces.DefaultFuncInterface imp = MethodImplementations::staticIsFactor;
            System.out.println(imp.test(10, 2));
        }

        {
            // Method Reference to the instance method through the object reference
            MethodImplementations objRef = new MethodImplementations();
            FunctionalInterfaces.DefaultFuncInterface imp = objRef::instanceIsFactor;
            System.out.println(imp.test(10, 2));
        }

        {
            // Method Reference to the instance method through the class name
            MethodImplementations objRef = new MethodImplementations();
            FunctionalInterfaces.MethodReferencesThroughClassName imp = MethodImplementations::instanceIsFactor;
            System.out.println(imp.test(objRef, 10, 2));
        }

        {
            // Method Reference to the generic method
            // Explicit type arguments(<Integer> on the right side) can be inferred
            FunctionalInterfaces.GenericFuncInterface<Integer> imp = MethodImplementations::<Integer>genericIsFactor;
            System.out.println(imp.test(10, 2));
        }

        {
            // Constructor Reference
            FunctionalInterfaces.ConstructorReference imp = MethodImplementations::new;
            MethodImplementations mi = imp.func("Hello!");
        }

    }
}