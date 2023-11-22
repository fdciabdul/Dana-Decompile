package id.dana.social.onboarding.model;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0011\u0010\u0019\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\r"}, d2 = {"Lid/dana/social/onboarding/model/FeedOnboardingModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "I", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeedOnboardingModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Function0<Unit> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final int getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String lookAheadTest;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof FeedOnboardingModel) {
            FeedOnboardingModel feedOnboardingModel = (FeedOnboardingModel) p0;
            return this.getAuthRequestContext == feedOnboardingModel.getAuthRequestContext && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, feedOnboardingModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, feedOnboardingModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, feedOnboardingModel.PlaceComponentResult) && Intrinsics.areEqual(this.lookAheadTest, feedOnboardingModel.lookAheadTest) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, feedOnboardingModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, feedOnboardingModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.getAuthRequestContext * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.lookAheadTest.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedOnboardingModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    private FeedOnboardingModel(int i, String str, String str2, Function0<Unit> function0, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.getAuthRequestContext = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.PlaceComponentResult = function0;
        this.lookAheadTest = str3;
        this.MyBillsEntityDataFactory = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
    }

    public /* synthetic */ FeedOnboardingModel(int i, String str, String str2, Function0 function0, String str3, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, (i2 & 8) != 0 ? new Function0<Unit>() { // from class: id.dana.social.onboarding.model.FeedOnboardingModel.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function0, str3, str4, str5);
    }
}
