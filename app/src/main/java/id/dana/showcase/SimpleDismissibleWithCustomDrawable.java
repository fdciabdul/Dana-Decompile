package id.dana.showcase;

import android.animation.TimeInterpolator;
import android.app.Activity;
import id.dana.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\n"}, d2 = {"Lid/dana/showcase/SimpleDismissibleWithCustomDrawable;", "Lid/dana/showcase/SimpleShowcaseBuilder;", "Lid/dana/showcase/Params;", "getAuthRequestContext", "()Lid/dana/showcase/Params;", "Lid/dana/showcase/Showcase;", "PlaceComponentResult", "()Lid/dana/showcase/Showcase;", "", "PrepareContext", "I", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/lang/Integer;", "KClassImpl$Data$declaredNonStaticMembers$2", "newProxyInstance", "BuiltInFictitiousFunctionClassFactory", "Landroid/app/Activity;", "p0", "p1", "p2", "p3", "<init>", "(Landroid/app/Activity;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SimpleDismissibleWithCustomDrawable extends SimpleShowcaseBuilder {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Integer KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final int MyBillsEntityDataFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final int BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDismissibleWithCustomDrawable(Activity activity, Integer num) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "");
        this.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_pointer_blue_10;
        this.MyBillsEntityDataFactory = R.drawable.rounded_blue_10_bg;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = num;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.showcase.SimpleShowcaseBuilder, id.dana.showcase.AbstractShowcaseBuilder
    public final Params getAuthRequestContext() {
        long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        TimeInterpolator timeInterpolator = this.PlaceComponentResult;
        Integer num = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return new SimpleParams(j, timeInterpolator, num != null ? num.intValue() : this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.isLayoutRequested, this.lookAheadTest, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.showcase.SimpleShowcaseBuilder
    public final Showcase PlaceComponentResult() {
        Params authRequestContext = getAuthRequestContext();
        Activity activity = this.MyBillsEntityDataFactory.get();
        Intrinsics.checkNotNull(activity);
        Showcase NetworkUserEntityData$$ExternalSyntheticLambda0 = new SimpleDismissibleShowcase(authRequestContext, activity, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, this.GetContactSyncConfig, this.initRecordTimeStamp, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory).NetworkUserEntityData$$ExternalSyntheticLambda0();
        Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda0, "");
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
