package id.dana.social.model;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012$\b\u0002\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0011j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u0012\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\b\b\u0002\u0010!\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR-\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0011j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/social/model/FeedHighlightModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "MyBillsEntityDataFactory", "Ljava/util/HashMap;", "getErrorConfigVersion", "Z", "()Z", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/HashMap;ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeedHighlightModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final HashMap<String, String> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final int lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final boolean scheduleImpl;

    public FeedHighlightModel() {
        this(null, null, null, false, null, 0, null, 127, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof FeedHighlightModel) {
            FeedHighlightModel feedHighlightModel = (FeedHighlightModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, feedHighlightModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, feedHighlightModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, feedHighlightModel.BuiltInFictitiousFunctionClassFactory) && this.scheduleImpl == feedHighlightModel.scheduleImpl && Intrinsics.areEqual(this.MyBillsEntityDataFactory, feedHighlightModel.MyBillsEntityDataFactory) && this.lookAheadTest == feedHighlightModel.lookAheadTest && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, feedHighlightModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.getAuthRequestContext.hashCode();
        int hashCode2 = this.PlaceComponentResult.hashCode();
        int hashCode3 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        boolean z = this.scheduleImpl;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.lookAheadTest) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedHighlightModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    private FeedHighlightModel(String str, String str2, String str3, boolean z, HashMap<String, String> hashMap, int i, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.scheduleImpl = z;
        this.MyBillsEntityDataFactory = hashMap;
        this.lookAheadTest = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getScheduleImpl() {
        return this.scheduleImpl;
    }

    public /* synthetic */ FeedHighlightModel(String str, String str2, String str3, boolean z, HashMap hashMap, int i, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? new HashMap() : hashMap, (i2 & 32) != 0 ? 2 : i, (i2 & 64) != 0 ? "" : str4);
    }
}
