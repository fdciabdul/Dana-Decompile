package id.dana.feeds.ui.model;

import id.dana.feeds.domain.profile.model.MyFeedsHeaderInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u001a\u0010\u0013\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0011\u0010\u0015\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\r"}, d2 = {"Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "scheduleImpl", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MyFeedHeaderModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;
    public final String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    public MyFeedHeaderModel() {
        this(null, null, null, false, false, null, 63, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MyFeedHeaderModel) {
            MyFeedHeaderModel myFeedHeaderModel = (MyFeedHeaderModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, myFeedHeaderModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, myFeedHeaderModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, myFeedHeaderModel.MyBillsEntityDataFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2 == myFeedHeaderModel.KClassImpl$Data$declaredNonStaticMembers$2 && this.BuiltInFictitiousFunctionClassFactory == myFeedHeaderModel.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, myFeedHeaderModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        int hashCode2 = this.getAuthRequestContext.hashCode();
        int hashCode3 = this.MyBillsEntityDataFactory.hashCode();
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.BuiltInFictitiousFunctionClassFactory;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyFeedHeaderModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(')');
        return sb.toString();
    }

    public MyFeedHeaderModel(String str, String str2, String str3, boolean z, boolean z2, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = str2;
        this.MyBillsEntityDataFactory = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.BuiltInFictitiousFunctionClassFactory = z2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
    }

    public /* synthetic */ MyFeedHeaderModel(String str, String str2, String str3, boolean z, boolean z2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? "" : str4);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0004¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/feeds/ui/model/MyFeedHeaderModel$Companion;", "", "Lid/dana/feeds/domain/profile/model/MyFeedsHeaderInfo;", "p0", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "MyBillsEntityDataFactory", "(Lid/dana/feeds/domain/profile/model/MyFeedsHeaderInfo;)Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "PlaceComponentResult", "(Lid/dana/feeds/ui/model/MyFeedHeaderModel;)Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static MyFeedHeaderModel MyBillsEntityDataFactory(MyFeedsHeaderInfo p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            String userId = p0.getUserId();
            String nickname = p0.getNickname();
            String profileAvatarUrl = p0.getProfileAvatarUrl();
            return new MyFeedHeaderModel(userId, nickname, profileAvatarUrl == null ? "" : profileAvatarUrl, p0.getShareFeed(), Intrinsics.areEqual(p0.getKycLevel(), "KYC2"), p0.getUsername());
        }

        public static ActivityReactionsUserModel PlaceComponentResult(MyFeedHeaderModel myFeedHeaderModel) {
            Intrinsics.checkNotNullParameter(myFeedHeaderModel, "");
            return new ActivityReactionsUserModel(myFeedHeaderModel.getAuthRequestContext, null, myFeedHeaderModel.PlaceComponentResult, myFeedHeaderModel.getAuthRequestContext, null, myFeedHeaderModel.MyBillsEntityDataFactory, myFeedHeaderModel.NetworkUserEntityData$$ExternalSyntheticLambda0, 18, null);
        }
    }
}
