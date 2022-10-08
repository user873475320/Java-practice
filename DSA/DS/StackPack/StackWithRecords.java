package DSA.DS.StackPack;

record Result(BlockArrowCaseDemo.ShipMethod shipping, boolean extraCharge) { }

// Use blocks with the arrow case.
class BlockArrowCaseDemo {
    public enum ShipMethod {STANDARD, TRUCK, AIR, OVERNIGHT}

    public static void main(String[] args) {
        Result[] sourceArr = new Result[42];
        Result[] filledArr = {new Result(ShipMethod.STANDARD, true),
                new Result(ShipMethod.OVERNIGHT, false),
                new Result(ShipMethod.TRUCK, true),
                new Result(ShipMethod.AIR, false)};

        FixedStack<Result> stack = new FixedStack<>(sourceArr, filledArr, filledArr.length - 1);

        try {
            stack.pop();
            stack.pop();
            stack.push(new Result(ShipMethod.AIR, false));

        } catch (EmptyStackExc | FullStackExc e) {
            throw new RuntimeException(e);
        }

        stack.printStack();
    }
}