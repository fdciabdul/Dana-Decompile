package id.dana.showcase;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/showcase/SimpleShowcaseWithShadowBuilder;", "Lid/dana/showcase/SimpleShowcaseBuilder;", "Lid/dana/showcase/Showcase;", "PlaceComponentResult", "()Lid/dana/showcase/Showcase;", "Landroid/app/Activity;", "p0", "<init>", "(Landroid/app/Activity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SimpleShowcaseWithShadowBuilder extends SimpleShowcaseBuilder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleShowcaseWithShadowBuilder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "");
    }

    @Override // id.dana.showcase.SimpleShowcaseBuilder
    public final Showcase PlaceComponentResult() {
        Showcase NetworkUserEntityData$$ExternalSyntheticLambda0 = new SimpleShowcase(getAuthRequestContext(), this.MyBillsEntityDataFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, this.GetContactSyncConfig, this.initRecordTimeStamp, (byte) 0).NetworkUserEntityData$$ExternalSyntheticLambda0();
        Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda0, "");
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
