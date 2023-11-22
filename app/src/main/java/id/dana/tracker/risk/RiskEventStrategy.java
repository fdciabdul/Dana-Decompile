package id.dana.tracker.risk;

import androidx.fragment.app.FragmentActivity;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.analytics.tracker.EventStrategy;
import id.dana.biometric.domain.model.RiskEventMapper;
import id.dana.di.ComponentHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u001eBA\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0013\u0010\n\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011"}, d2 = {"Lid/dana/tracker/risk/RiskEventStrategy;", "Lid/dana/analytics/tracker/EventStrategy;", "", "PlaceComponentResult", "()V", "", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", "MyBillsEntityDataFactory", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "", "J", "", "moveToNextValue", LogConstants.RESULT_FALSE, "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FFLandroidx/fragment/app/FragmentActivity;J)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RiskEventStrategy implements EventStrategy {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final FragmentActivity MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final long getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0 */
    public final float getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: moveToNextValue */
    public final float scheduleImpl;

    public RiskEventStrategy(String str, String str2, String str3, float f, float f2, FragmentActivity fragmentActivity, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.scheduleImpl = f;
        this.getErrorConfigVersion = f2;
        this.MyBillsEntityDataFactory = fragmentActivity;
        this.getAuthRequestContext = j;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012"}, d2 = {"Lid/dana/tracker/risk/RiskEventStrategy$Builder;", "", "Lid/dana/tracker/risk/RiskEventStrategy;", "getAuthRequestContext", "()Lid/dana/tracker/risk/RiskEventStrategy;", "", "Ljava/lang/String;", "Landroidx/fragment/app/FragmentActivity;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/fragment/app/FragmentActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "scheduleImpl", "PlaceComponentResult", "", "Ljava/lang/Long;", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/lang/Float;", "moveToNextValue", "p0", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public Float NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public Float moveToNextValue;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        private FragmentActivity KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public Long BuiltInFictitiousFunctionClassFactory;
        public String getAuthRequestContext;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        private String PlaceComponentResult;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, androidx.fragment.app.FragmentActivity] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Builder() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.tracker.risk.RiskEventStrategy.Builder.<init>():void");
        }

        public Builder(FragmentActivity fragmentActivity) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentActivity;
        }

        public /* synthetic */ Builder(FragmentActivity fragmentActivity, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : fragmentActivity);
        }

        public final RiskEventStrategy getAuthRequestContext() {
            String str = this.PlaceComponentResult;
            String str2 = str == null ? "" : str;
            String str3 = this.MyBillsEntityDataFactory;
            String str4 = str3 == null ? "" : str3;
            String str5 = this.getAuthRequestContext;
            String str6 = str5 == null ? "" : str5;
            Float f = this.moveToNextValue;
            float floatValue = f != null ? f.floatValue() : 0.0f;
            Float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            float floatValue2 = f2 != null ? f2.floatValue() : 0.0f;
            FragmentActivity fragmentActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Long l = this.BuiltInFictitiousFunctionClassFactory;
            return new RiskEventStrategy(str2, str4, str6, floatValue, floatValue2, fragmentActivity, l != null ? l.longValue() : 0L);
        }
    }

    @Override // id.dana.analytics.tracker.EventStrategy
    public final void PlaceComponentResult() {
        ComponentHolder.getAuthRequestContext().getDefaultSenderId().MyBillsEntityDataFactory(new RiskEventMapper(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, this.getErrorConfigVersion, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
    }
}
