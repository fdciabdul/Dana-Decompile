package id.dana.showcase;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.showcase.shape.RectangleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.showcase.view.EmptyContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/showcase/SectionShowcase;", "Lid/dana/showcase/BaseShowcase;", "", "initRecordTimeStamp", "()V", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "Lid/dana/showcase/target/Target;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/showcase/target/Target;", "", "lookAheadTest", "()Z", "moveToNextValue", "Landroid/app/Activity;", "Landroid/app/Activity;", "MyBillsEntityDataFactory", "getErrorConfigVersion", "Lid/dana/showcase/target/Target;", "scheduleImpl", "Landroid/view/View;", "getAuthRequestContext", "Lid/dana/showcase/Params;", "p0", "Lid/dana/showcase/OnShowcaseStateListener;", "p1", "p2", "p3", "<init>", "(Lid/dana/showcase/Params;Lid/dana/showcase/OnShowcaseStateListener;Landroid/app/Activity;Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionShowcase extends BaseShowcase {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Activity MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private Target BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private View getAuthRequestContext;

    public SectionShowcase(Params params, OnShowcaseStateListener onShowcaseStateListener, Activity activity, View view) {
        super(params, activity, onShowcaseStateListener, (byte) 0);
        this.MyBillsEntityDataFactory = activity;
        this.getAuthRequestContext = view;
        Params params2 = this.PlaceComponentResult;
        if (params2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.showcase.SectionParams");
        }
        SectionParams sectionParams = (SectionParams) params2;
        initRecordTimeStamp();
        if (sectionParams.getKClassImpl$Data$declaredNonStaticMembers$2()) {
            RecyclerView recyclerView = sectionParams.MyBillsEntityDataFactory;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(sectionParams.BuiltInFictitiousFunctionClassFactory);
            }
            RecyclerView recyclerView2 = sectionParams.MyBillsEntityDataFactory;
            if (recyclerView2 != null) {
                recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.showcase.SectionShowcase$createListener$1

                    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
                    public int PlaceComponentResult;

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public final void onScrolled(RecyclerView p0, int p1, int p2) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        super.onScrolled(p0, p1, p2);
                        this.PlaceComponentResult += p2;
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public final void onScrollStateChanged(RecyclerView p0, int p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        super.onScrollStateChanged(p0, p1);
                        if (p1 != 0 || this.PlaceComponentResult <= 0) {
                            return;
                        }
                        SectionShowcase.this.initRecordTimeStamp();
                        p0.clearOnScrollListeners();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.showcase.BaseShowcase
    public final boolean lookAheadTest() {
        return super.lookAheadTest() || this.BuiltInFictitiousFunctionClassFactory == null;
    }

    @Override // id.dana.showcase.BaseShowcase
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    protected final Target getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final void moveToNextValue() {
        Target target = this.BuiltInFictitiousFunctionClassFactory;
        if (target != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(target);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initRecordTimeStamp() {
        View view = this.getAuthRequestContext;
        if (view != null) {
            this.BuiltInFictitiousFunctionClassFactory = new TargetBuilder(this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory(view).BuiltInFictitiousFunctionClassFactory(new RectangleShape(view, 0.0f, 0.0f)).KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final View KClassImpl$Data$declaredNonStaticMembers$2() {
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(activity, "");
        return new EmptyContentView(activity, null, 0, 6, null);
    }
}
