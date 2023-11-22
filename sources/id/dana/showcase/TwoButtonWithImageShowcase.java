package id.dana.showcase;

import android.app.Activity;
import android.view.View;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.TwoButtonWithImageContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\b\u0010\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b"}, d2 = {"Lid/dana/showcase/TwoButtonWithImageShowcase;", "Lid/dana/showcase/BaseShowcase;", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "Lid/dana/showcase/target/Target;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/showcase/target/Target;", "", "moveToNextValue", "()V", "Lid/dana/showcase/target/Target;", "Lid/dana/showcase/TwoButtonWithImageShowcaseParams;", "p0", "Landroid/app/Activity;", "p1", "p2", "Lid/dana/showcase/OnShowcaseStateListener;", "p3", "<init>", "(Lid/dana/showcase/TwoButtonWithImageShowcaseParams;Landroid/app/Activity;Lid/dana/showcase/target/Target;Lid/dana/showcase/OnShowcaseStateListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwoButtonWithImageShowcase extends BaseShowcase {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Target KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoButtonWithImageShowcase(TwoButtonWithImageShowcaseParams twoButtonWithImageShowcaseParams, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener) {
        super(twoButtonWithImageShowcaseParams, activity, onShowcaseStateListener);
        Intrinsics.checkNotNullParameter(target, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = target;
    }

    @Override // id.dana.showcase.BaseShowcase
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    protected final Target getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final void moveToNextValue() {
        KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static /* synthetic */ void getAuthRequestContext(TwoButtonWithImageShowcase twoButtonWithImageShowcase, TwoButtonWithImageShowcaseParams twoButtonWithImageShowcaseParams, View view) {
        Intrinsics.checkNotNullParameter(twoButtonWithImageShowcase, "");
        Intrinsics.checkNotNullParameter(twoButtonWithImageShowcaseParams, "");
        twoButtonWithImageShowcase.BuiltInFictitiousFunctionClassFactory(2);
        View.OnClickListener onClickListener = twoButtonWithImageShowcaseParams.BuiltInFictitiousFunctionClassFactory;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(TwoButtonWithImageShowcase twoButtonWithImageShowcase) {
        Intrinsics.checkNotNullParameter(twoButtonWithImageShowcase, "");
        twoButtonWithImageShowcase.BuiltInFictitiousFunctionClassFactory(2);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(TwoButtonWithImageShowcase twoButtonWithImageShowcase) {
        Intrinsics.checkNotNullParameter(twoButtonWithImageShowcase, "");
        twoButtonWithImageShowcase.BuiltInFictitiousFunctionClassFactory(2);
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final View KClassImpl$Data$declaredNonStaticMembers$2() {
        View.OnClickListener onClickListener;
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(activity, "");
        TwoButtonWithImageContentView twoButtonWithImageContentView = new TwoButtonWithImageContentView(activity, null, 0, 6, null);
        Params params = this.PlaceComponentResult;
        if (params == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.showcase.TwoButtonWithImageShowcaseParams");
        }
        final TwoButtonWithImageShowcaseParams twoButtonWithImageShowcaseParams = (TwoButtonWithImageShowcaseParams) params;
        twoButtonWithImageContentView.setImage(Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.PlaceComponentResult));
        twoButtonWithImageContentView.setTitle(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
        twoButtonWithImageContentView.setDescription(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getAuthRequestContext);
        String str = twoButtonWithImageShowcaseParams.scheduleImpl;
        if (twoButtonWithImageShowcaseParams.getPlaceComponentResult()) {
            onClickListener = new View.OnClickListener() { // from class: id.dana.showcase.TwoButtonWithImageShowcase$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TwoButtonWithImageShowcase.MyBillsEntityDataFactory(TwoButtonWithImageShowcase.this);
                }
            };
        } else {
            onClickListener = new View.OnClickListener() { // from class: id.dana.showcase.TwoButtonWithImageShowcase$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TwoButtonWithImageShowcase.getAuthRequestContext(TwoButtonWithImageShowcase.this, twoButtonWithImageShowcaseParams, view);
                }
            };
        }
        twoButtonWithImageContentView.setPositiveButton(str, onClickListener, twoButtonWithImageShowcaseParams.getAuthRequestContext);
        twoButtonWithImageContentView.setNegativeButton(twoButtonWithImageShowcaseParams.MyBillsEntityDataFactory, new View.OnClickListener() { // from class: id.dana.showcase.TwoButtonWithImageShowcase$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TwoButtonWithImageShowcase.BuiltInFictitiousFunctionClassFactory(TwoButtonWithImageShowcase.this);
            }
        }, twoButtonWithImageShowcaseParams.KClassImpl$Data$declaredNonStaticMembers$2);
        return twoButtonWithImageContentView;
    }
}
