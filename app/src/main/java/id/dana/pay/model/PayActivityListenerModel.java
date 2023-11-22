package id.dana.pay.model;

import id.dana.cashier.CashierEventListener;
import id.dana.utils.danah5.DanaH5Listener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/pay/model/PayActivityListenerModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/cashier/CashierEventListener;", "PlaceComponentResult", "Lid/dana/cashier/CashierEventListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/danah5/DanaH5Listener;", "Lid/dana/utils/danah5/DanaH5Listener;", "p1", "<init>", "(Lid/dana/utils/danah5/DanaH5Listener;Lid/dana/cashier/CashierEventListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PayActivityListenerModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final DanaH5Listener PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final CashierEventListener BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.utils.danah5.DanaH5Listener, kotlin.jvm.internal.DefaultConstructorMarker, id.dana.cashier.CashierEventListener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PayActivityListenerModel() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pay.model.PayActivityListenerModel.<init>():void");
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PayActivityListenerModel) {
            PayActivityListenerModel payActivityListenerModel = (PayActivityListenerModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, payActivityListenerModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, payActivityListenerModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        DanaH5Listener danaH5Listener = this.PlaceComponentResult;
        int hashCode = danaH5Listener == null ? 0 : danaH5Listener.hashCode();
        CashierEventListener cashierEventListener = this.BuiltInFictitiousFunctionClassFactory;
        return (hashCode * 31) + (cashierEventListener != null ? cashierEventListener.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayActivityListenerModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public PayActivityListenerModel(DanaH5Listener danaH5Listener, CashierEventListener cashierEventListener) {
        this.PlaceComponentResult = danaH5Listener;
        this.BuiltInFictitiousFunctionClassFactory = cashierEventListener;
    }

    public /* synthetic */ PayActivityListenerModel(DanaH5Listener danaH5Listener, CashierEventListener cashierEventListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : danaH5Listener, (i & 2) != 0 ? null : cashierEventListener);
    }
}
