package com.google.common.base;

import com.google.common.base.CharMatcher;
import java.util.BitSet;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.table = cArr;
        this.filter = j;
        this.containsZero = z;
    }

    static int smear(int i) {
        return Integer.rotateLeft(i * C1, 15) * C2;
    }

    private boolean checkFilter(int i) {
        return 1 == ((this.filter >> i) & 1);
    }

    static int chooseTableSize(int i) {
        if (i == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i - 1) << 1;
        while (true) {
            double d = highestOneBit;
            Double.isNaN(d);
            if (d * DESIRED_LOAD_FACTOR >= i) {
                return highestOneBit;
            }
            highestOneBit <<= 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharMatcher from(BitSet bitSet, String str) {
        int i;
        int cardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        int chooseTableSize = chooseTableSize(cardinality);
        char[] cArr = new char[chooseTableSize];
        int nextSetBit = bitSet.nextSetBit(0);
        long j = 0;
        while (nextSetBit != -1) {
            int smear = smear(nextSetBit);
            while (true) {
                i = smear & (chooseTableSize - 1);
                if (cArr[i] == 0) {
                    break;
                }
                smear = i + 1;
            }
            cArr[i] = (char) nextSetBit;
            j |= 1 << nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
        }
        return new SmallCharMatcher(cArr, j, z, str);
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        if (c == 0) {
            return this.containsZero;
        }
        if (checkFilter(c)) {
            int length = this.table.length - 1;
            int smear = smear(c) & length;
            int i = smear;
            do {
                char c2 = this.table[i];
                if (c2 == 0) {
                    return false;
                }
                if (c2 == c) {
                    return true;
                }
                i = (i + 1) & length;
            } while (i != smear);
            return false;
        }
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    final void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c : this.table) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }
}
