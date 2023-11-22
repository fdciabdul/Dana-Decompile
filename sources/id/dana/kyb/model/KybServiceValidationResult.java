package id.dana.kyb.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015"}, d2 = {"Lid/dana/kyb/model/KybServiceValidationResult;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Z", "getAuthRequestContext", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/model/KybServiceMessageModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/model/KybServiceMessageModel;", "PlaceComponentResult", "Ljava/lang/String;", "p1", "p2", "<init>", "(Ljava/lang/String;ZLid/dana/kyb/model/KybServiceMessageModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybServiceValidationResult {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final KybServiceMessageModel PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof KybServiceValidationResult) {
            KybServiceValidationResult kybServiceValidationResult = (KybServiceValidationResult) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, kybServiceValidationResult.MyBillsEntityDataFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2 == kybServiceValidationResult.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.PlaceComponentResult, kybServiceValidationResult.PlaceComponentResult);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        KybServiceMessageModel kybServiceMessageModel = this.PlaceComponentResult;
        return (((hashCode * 31) + i) * 31) + (kybServiceMessageModel == null ? 0 : kybServiceMessageModel.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybServiceValidationResult(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public KybServiceValidationResult(String str, boolean z, KybServiceMessageModel kybServiceMessageModel) {
        Intrinsics.checkNotNullParameter(str, "");
        this.MyBillsEntityDataFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.PlaceComponentResult = kybServiceMessageModel;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/kyb/model/KybServiceValidationResult$Companion;", "", "Lid/dana/kyb/model/KybServiceValidationResult;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/kyb/model/KybServiceValidationResult;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static KybServiceValidationResult BuiltInFictitiousFunctionClassFactory() {
            return new KybServiceValidationResult("NONE", true, new KybServiceMessageModel("", "", ""));
        }
    }
}
