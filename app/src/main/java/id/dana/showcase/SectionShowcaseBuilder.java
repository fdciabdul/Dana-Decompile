package id.dana.showcase;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/showcase/SectionShowcaseBuilder;", "Lid/dana/showcase/AbstractShowcaseBuilder;", "Lid/dana/showcase/Params;", "getAuthRequestContext", "()Lid/dana/showcase/Params;", "Lid/dana/showcase/Showcase;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/showcase/Showcase;", "", "GetContactSyncConfig", "Z", "MyBillsEntityDataFactory", "", "DatabaseTableConfigUtil", "I", "Landroidx/recyclerview/widget/RecyclerView;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroidx/recyclerview/widget/RecyclerView;", "PlaceComponentResult", "Landroid/view/View;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/view/View;", "Landroid/app/Activity;", "p0", "p1", "<init>", "(Landroid/app/Activity;Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionShowcaseBuilder extends AbstractShowcaseBuilder<SectionShowcaseBuilder> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public RecyclerView PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final View getAuthRequestContext;

    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SectionShowcaseBuilder MyBillsEntityDataFactory() {
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SectionShowcaseBuilder(Activity activity, View view) {
        super(activity);
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Override // id.dana.showcase.AbstractShowcaseBuilder
    protected final Params getAuthRequestContext() {
        return new SectionParams(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult, this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory);
    }

    public final Showcase BuiltInFictitiousFunctionClassFactory() {
        Showcase NetworkUserEntityData$$ExternalSyntheticLambda0 = new SectionShowcase(getAuthRequestContext(), this.moveToNextValue, this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext).NetworkUserEntityData$$ExternalSyntheticLambda0();
        Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda0, "");
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
