package id.dana.showcase;

import android.animation.TimeInterpolator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/showcase/TextOnlyShowcaseBuilder;", "Lid/dana/showcase/AbstractShowcaseBuilder;", "", "DatabaseTableConfigUtil", "Ljava/lang/String;", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TextOnlyShowcaseBuilder extends AbstractShowcaseBuilder<TextOnlyShowcaseBuilder> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String PlaceComponentResult;

    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ TextOnlyShowcaseBuilder MyBillsEntityDataFactory() {
        return this;
    }

    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* synthetic */ Params getAuthRequestContext() {
        long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        TimeInterpolator timeInterpolator = this.PlaceComponentResult;
        int i = this.getErrorConfigVersion;
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = this.PlaceComponentResult;
        if (str == null) {
            str = "";
        }
        return new TextOnlyParams(j, timeInterpolator, i, z, str, this.lookAheadTest, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory);
    }
}
