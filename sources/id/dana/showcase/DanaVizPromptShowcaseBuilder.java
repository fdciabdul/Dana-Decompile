package id.dana.showcase;

import android.animation.TimeInterpolator;
import android.app.Activity;
import id.dana.showcase.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0006\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u0003\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/showcase/DanaVizPromptShowcaseBuilder;", "Lid/dana/showcase/AbstractShowcaseBuilder;", "Lid/dana/showcase/TextOnlyParams;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/showcase/TextOnlyParams;", "Lid/dana/showcase/Showcase;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/showcase/Showcase;", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Z", "DatabaseTableConfigUtil", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda1", "MyBillsEntityDataFactory", "initRecordTimeStamp", "Lid/dana/showcase/target/Target;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/showcase/target/Target;", "getAuthRequestContext", "", "GetContactSyncConfig", "Ljava/lang/String;", "moveToNextValue", "Landroid/app/Activity;", "p0", "p1", "<init>", "(Landroid/app/Activity;Lid/dana/showcase/target/Target;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaVizPromptShowcaseBuilder extends AbstractShowcaseBuilder<DanaVizPromptShowcaseBuilder> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Target getAuthRequestContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ DanaVizPromptShowcaseBuilder MyBillsEntityDataFactory() {
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaVizPromptShowcaseBuilder(Activity activity, Target target) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(target, "");
        this.getAuthRequestContext = target;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.PlaceComponentResult = true;
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public TextOnlyParams getAuthRequestContext() {
        long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        TimeInterpolator timeInterpolator = this.PlaceComponentResult;
        int i = this.getErrorConfigVersion;
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = this.moveToNextValue;
        if (str == null) {
            str = "";
        }
        return new TextOnlyParams(j, timeInterpolator, i, z, str, this.lookAheadTest, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory);
    }

    public final Showcase KClassImpl$Data$declaredNonStaticMembers$2() {
        Showcase NetworkUserEntityData$$ExternalSyntheticLambda0 = new DanaVizPromptShowcase(getAuthRequestContext(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory).NetworkUserEntityData$$ExternalSyntheticLambda0();
        Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda0, "");
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
