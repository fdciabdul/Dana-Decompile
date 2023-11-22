package id.dana.nearbyme.merchantdetail.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0007¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantReviewResultModel;", "", "", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "p0", "p1", "<init>", "(ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewResultModel {
    public final List<MerchantReviewModel> BuiltInFictitiousFunctionClassFactory;
    private final boolean PlaceComponentResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MerchantReviewResultModel() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r1, r0, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.model.MerchantReviewResultModel.<init>():void");
    }

    public MerchantReviewResultModel(boolean z, List<MerchantReviewModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = z;
        this.BuiltInFictitiousFunctionClassFactory = list;
    }

    public /* synthetic */ MerchantReviewResultModel(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
