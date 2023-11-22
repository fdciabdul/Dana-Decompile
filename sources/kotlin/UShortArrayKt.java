package kotlin;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\u00052\n\u0010\b\u001a\u00020\u0005\"\u00020\u0003H\u0086\bø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019"}, d2 = {"", GriverMonitorConstants.KEY_SIZE, "Lkotlin/Function1;", "Lkotlin/UShort;", IAPSyncCommand.COMMAND_INIT, "Lkotlin/UShortArray;", "UShortArray", "(ILkotlin/jvm/functions/Function1;)[S", "elements", "ushortArrayOf-rL5Bavg", "([S)[S", "ushortArrayOf"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class UShortArrayKt {
    /* renamed from: ushortArrayOf-rL5Bavg  reason: not valid java name */
    private static final short[] m3525ushortArrayOfrL5Bavg(short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "");
        return sArr;
    }

    private static final short[] UShortArray(int i, Function1<? super Integer, UShort> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = function1.invoke(Integer.valueOf(i2)).getData();
        }
        return UShortArray.m3509constructorimpl(sArr);
    }
}
