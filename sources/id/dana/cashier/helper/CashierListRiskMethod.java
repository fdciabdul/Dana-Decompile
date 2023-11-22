package id.dana.cashier.helper;

import id.dana.cashier.VerificationMethod;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0005j\b\u0012\u0004\u0012\u00020\u0002`\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/helper/CashierListRiskMethod;", "", "", "toString", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAuthRequestContext", "Ljava/util/ArrayList;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierListRiskMethod {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public ArrayList<String> PlaceComponentResult;

    public CashierListRiskMethod() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.PlaceComponentResult = arrayList;
        arrayList.add(VerificationMethod.NO_RISK);
    }

    public final String toString() {
        String obj = this.PlaceComponentResult.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
