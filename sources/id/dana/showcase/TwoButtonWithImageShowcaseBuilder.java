package id.dana.showcase;

import android.app.Activity;
import android.view.View;
import id.dana.showcase.target.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020 \u0012\u0006\u0010\b\u001a\u00020\u001c¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/showcase/TwoButtonWithImageShowcaseBuilder;", "Lid/dana/showcase/AbstractShowcaseBuilder;", "Lid/dana/showcase/TwoButtonWithImageShowcaseParams;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/showcase/TwoButtonWithImageShowcaseParams;", "", "p0", "Landroid/view/View$OnClickListener;", "p1", "p2", "MyBillsEntityDataFactory", "(Ljava/lang/String;Landroid/view/View$OnClickListener;Ljava/lang/String;)Lid/dana/showcase/TwoButtonWithImageShowcaseBuilder;", "Lid/dana/showcase/Showcase;", "PlaceComponentResult", "()Lid/dana/showcase/Showcase;", "", "initRecordTimeStamp", "Z", "getAuthRequestContext", "DatabaseTableConfigUtil", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/view/View$OnClickListener;", "GetContactSyncConfig", "BuiltInFictitiousFunctionClassFactory", "isLayoutRequested", "scheduleImpl", "Lid/dana/showcase/target/Target;", "PrepareContext", "Lid/dana/showcase/target/Target;", "getErrorConfigVersion", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;Lid/dana/showcase/target/Target;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwoButtonWithImageShowcaseBuilder extends AbstractShowcaseBuilder<TwoButtonWithImageShowcaseBuilder> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private View.OnClickListener MyBillsEntityDataFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Target getErrorConfigVersion;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public boolean getAuthRequestContext;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String scheduleImpl;

    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ TwoButtonWithImageShowcaseBuilder MyBillsEntityDataFactory() {
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoButtonWithImageShowcaseBuilder(Activity activity, Target target) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(target, "");
        this.getErrorConfigVersion = target;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public TwoButtonWithImageShowcaseParams getAuthRequestContext() {
        return new TwoButtonWithImageShowcaseParams(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult, this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, this.scheduleImpl, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
    }

    public final Showcase PlaceComponentResult() {
        Showcase NetworkUserEntityData$$ExternalSyntheticLambda0 = new TwoButtonWithImageShowcase(getAuthRequestContext(), this.MyBillsEntityDataFactory.get(), this.getErrorConfigVersion, this.moveToNextValue).NetworkUserEntityData$$ExternalSyntheticLambda0();
        Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda0, "");
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final TwoButtonWithImageShowcaseBuilder MyBillsEntityDataFactory(String p0, View.OnClickListener p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.scheduleImpl = p0;
        this.MyBillsEntityDataFactory = p1;
        this.BuiltInFictitiousFunctionClassFactory = p2;
        return this;
    }
}
