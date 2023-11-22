package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.State;

/* loaded from: classes6.dex */
public class HorizontalChainReference extends ChainReference {

    /* renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[State.Chain.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
