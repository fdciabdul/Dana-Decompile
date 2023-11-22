package id.dana.core.ui.showcase;

import android.app.Activity;
import id.dana.core.ui.showcase.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/core/ui/showcase/SkipShowCaseBuilder;", "Lid/dana/core/ui/showcase/SimpleShowcaseBuilder;", "Lid/dana/core/ui/showcase/Showcase;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/core/ui/showcase/Showcase;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SkipShowCaseBuilder extends SimpleShowcaseBuilder {
    @Override // id.dana.core.ui.showcase.SimpleShowcaseBuilder
    public final Showcase BuiltInFictitiousFunctionClassFactory() {
        Params authRequestContext = getAuthRequestContext();
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Target target = this.GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(target, "");
        Showcase moveToNextValue = new SkipShowCase(authRequestContext, activity, target, this.getErrorConfigVersion).moveToNextValue();
        Intrinsics.checkNotNullExpressionValue(moveToNextValue, "");
        return moveToNextValue;
    }
}
