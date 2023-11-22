package com.apiguard3.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setSaveFromParentEnabled extends setHovered implements Iterable<setHovered> {
    private static int AGState = 0;
    private static int APIGuard = 1;
    private final List<setHovered> values = new ArrayList();

    public final void getSharedInstance(setHovered sethovered) {
        int i = AGState + 79;
        APIGuard = i % 128;
        if (!(i % 2 != 0)) {
            throw new ArithmeticException();
        }
        if (!(sethovered != null)) {
            sethovered = setAccessibilityLiveRegion.getSharedInstance;
            APIGuard = (AGState + 125) % 128;
        }
        this.values.add(sethovered);
    }

    @Override // java.lang.Iterable
    public final Iterator<setHovered> iterator() {
        APIGuard = (AGState + 97) % 128;
        Iterator<setHovered> it = this.values.iterator();
        int i = AGState + 95;
        APIGuard = i % 128;
        if ((i % 2 == 0 ? 'D' : 'B') != 'D') {
            return it;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if ((r4.values.size() != 0 ? 'W' : 1) != 'W') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r4.values.size() == 1) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        com.apiguard3.internal.setSaveFromParentEnabled.AGState = (com.apiguard3.internal.setSaveFromParentEnabled.APIGuard + 59) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        return r4.values.get(0).AGState();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        throw new java.lang.IllegalStateException();
     */
    @Override // com.apiguard3.internal.setHovered
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Number AGState() {
        /*
            r4 = this;
            int r0 = com.apiguard3.internal.setSaveFromParentEnabled.APIGuard
            int r0 = r0 + 61
            int r1 = r0 % 128
            com.apiguard3.internal.setSaveFromParentEnabled.AGState = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L23
            java.util.List<com.apiguard3.internal.setHovered> r0 = r4.values
            int r0 = r0.size()
            r3 = 87
            if (r0 != 0) goto L1e
            goto L20
        L1e:
            r2 = 87
        L20:
            if (r2 == r3) goto L40
            goto L2b
        L23:
            java.util.List<com.apiguard3.internal.setHovered> r0 = r4.values
            int r0 = r0.size()
            if (r0 != r2) goto L40
        L2b:
            int r0 = com.apiguard3.internal.setSaveFromParentEnabled.APIGuard
            int r0 = r0 + 59
            int r0 = r0 % 128
            com.apiguard3.internal.setSaveFromParentEnabled.AGState = r0
            java.util.List<com.apiguard3.internal.setHovered> r0 = r4.values
            java.lang.Object r0 = r0.get(r1)
            com.apiguard3.internal.setHovered r0 = (com.apiguard3.internal.setHovered) r0
            java.lang.Number r0 = r0.AGState()
            return r0
        L40:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setSaveFromParentEnabled.AGState():java.lang.Number");
    }

    @Override // com.apiguard3.internal.setHovered
    public final String getSharedInstance() {
        AGState = (APIGuard + 15) % 128;
        if (this.values.size() == 1) {
            String sharedInstance = this.values.get(0).getSharedInstance();
            APIGuard = (AGState + 97) % 128;
            return sharedInstance;
        }
        throw new IllegalStateException();
    }

    @Override // com.apiguard3.internal.setHovered
    public final boolean valueOf() {
        AGState = (APIGuard + 83) % 128;
        if ((this.values.size() == 1 ? ',' : '3') != '3') {
            int i = APIGuard + 43;
            AGState = i % 128;
            return (!(i % 2 == 0) ? this.values.get(1) : this.values.get(0)).valueOf();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if ((obj != this ? (char) 27 : '\f') != '\f') {
            int i = AGState + 51;
            int i2 = i % 128;
            APIGuard = i2;
            if ((i % 2 == 0 ? 'A' : Typography.greater) == 'A') {
                throw new NullPointerException();
            } else if ((!(obj instanceof setSaveFromParentEnabled)) == true) {
                return false;
            } else {
                AGState = (i2 + 39) % 128;
                if ((!((setSaveFromParentEnabled) obj).values.equals(this.values)) == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = APIGuard + 39;
        AGState = i % 128;
        if (i % 2 == 0) {
            return this.values.hashCode();
        }
        this.values.hashCode();
        throw new ArithmeticException();
    }
}
