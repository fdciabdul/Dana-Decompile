package id.dana.electronicmoney;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tR\u0012\u0010\u000b\u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/electronicmoney/ElectronicMoneyCallback;", "", "Lid/dana/electronicmoney/ElectronicMoneyException;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/electronicmoney/ElectronicMoneyException;)V", "Lid/dana/electronicmoney/BalanceResult;", "MyBillsEntityDataFactory", "(Lid/dana/electronicmoney/BalanceResult;)V", "Lkotlinx/coroutines/CoroutineScope;", "getAuthRequestContext", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class ElectronicMoneyCallback {
    public CoroutineScope getAuthRequestContext;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ElectronicMoneyCallback() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.ElectronicMoneyCallback.<init>():void");
    }

    public abstract void BuiltInFictitiousFunctionClassFactory(ElectronicMoneyException p0);

    public abstract void MyBillsEntityDataFactory(BalanceResult p0);

    private ElectronicMoneyCallback(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        this.getAuthRequestContext = coroutineScope;
    }

    public /* synthetic */ ElectronicMoneyCallback(GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalScope.INSTANCE : globalScope);
    }
}
