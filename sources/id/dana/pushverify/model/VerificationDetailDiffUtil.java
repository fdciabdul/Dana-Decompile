package id.dana.pushverify.model;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007"}, d2 = {"Lid/dana/pushverify/model/VerificationDetailDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lid/dana/pushverify/model/VerificationDetailModel;", "p0", "p1", "", "PlaceComponentResult", "(Lid/dana/pushverify/model/VerificationDetailModel;Lid/dana/pushverify/model/VerificationDetailModel;)Z", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationDetailDiffUtil extends DiffUtil.ItemCallback<VerificationDetailModel> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(VerificationDetailModel verificationDetailModel, VerificationDetailModel verificationDetailModel2) {
        return PlaceComponentResult(verificationDetailModel, verificationDetailModel2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final /* bridge */ /* synthetic */ boolean getAuthRequestContext(VerificationDetailModel verificationDetailModel, VerificationDetailModel verificationDetailModel2) {
        return getAuthRequestContext2(verificationDetailModel, verificationDetailModel2);
    }

    private static boolean PlaceComponentResult(VerificationDetailModel p0, VerificationDetailModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return p0.scheduleImpl == p1.scheduleImpl && Intrinsics.areEqual(p0.getAuthRequestContext, p1.getAuthRequestContext) && Intrinsics.areEqual(p0.lookAheadTest, p1.lookAheadTest) && Intrinsics.areEqual(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, p1.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, p1.BuiltInFictitiousFunctionClassFactory);
    }

    /* renamed from: getAuthRequestContext  reason: avoid collision after fix types in other method */
    private static boolean getAuthRequestContext2(VerificationDetailModel p0, VerificationDetailModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return Intrinsics.areEqual(p0.getAuthRequestContext, p1.getAuthRequestContext);
    }
}
