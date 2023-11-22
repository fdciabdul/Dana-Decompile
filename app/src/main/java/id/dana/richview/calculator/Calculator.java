package id.dana.richview.calculator;

/* loaded from: classes5.dex */
public class Calculator {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Operation KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1902665991:
                if (str.equals(OperandType.DIVIDER)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2459034:
                if (str.equals(OperandType.PLUS)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 73363536:
                if (str.equals(OperandType.MINUS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1750165953:
                if (str.equals(OperandType.MULTIPLIER)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c == 3) {
                        return Operation.TIMES;
                    }
                    return Operation.DEFAULT;
                }
                return Operation.MINUS;
            }
            return Operation.PLUS;
        }
        return Operation.DIVIDE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum Operation {
        PLUS("+") { // from class: id.dana.richview.calculator.Calculator.Operation.1
            @Override // id.dana.richview.calculator.Calculator.Operation
            final long apply(long j, long j2) {
                return j + j2;
            }
        },
        MINUS("-") { // from class: id.dana.richview.calculator.Calculator.Operation.2
            @Override // id.dana.richview.calculator.Calculator.Operation
            final long apply(long j, long j2) {
                return j - j2;
            }
        },
        TIMES("*") { // from class: id.dana.richview.calculator.Calculator.Operation.3
            @Override // id.dana.richview.calculator.Calculator.Operation
            final long apply(long j, long j2) {
                return j2 == 0 ? j : j * j2;
            }
        },
        DIVIDE("/") { // from class: id.dana.richview.calculator.Calculator.Operation.4
            @Override // id.dana.richview.calculator.Calculator.Operation
            final long apply(long j, long j2) {
                if (j2 == 0) {
                    return j;
                }
                if (j < j2) {
                    return 1L;
                }
                return j / j2;
            }
        },
        DEFAULT("") { // from class: id.dana.richview.calculator.Calculator.Operation.5
            @Override // id.dana.richview.calculator.Calculator.Operation
            final long apply(long j, long j2) {
                return j;
            }
        };

        private final String symbol;

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long apply(long j, long j2);

        Operation(String str) {
            this.symbol = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.symbol;
        }
    }
}
