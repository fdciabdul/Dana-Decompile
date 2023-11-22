package id.dana.showcase;

import android.app.Activity;
import android.view.View;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import id.dana.showcase.constant.PointerViewPositioningConstant;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.TextOnlyContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012"}, d2 = {"Lid/dana/showcase/TextOnlyShowcase;", "Lid/dana/showcase/BaseShowcase;", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "Lid/dana/showcase/target/Target;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/showcase/target/Target;", "", "MyBillsEntityDataFactory", "()I", "Lid/dana/showcase/constant/PointerViewPositioningConstant;", "getAuthRequestContext", "()Lid/dana/showcase/constant/PointerViewPositioningConstant;", "scheduleImpl", "", "moveToNextValue", "()V", "Lid/dana/showcase/target/Target;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TextOnlyShowcase extends BaseShowcase {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Target KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.showcase.BaseShowcase
    public final int MyBillsEntityDataFactory() {
        return -2;
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

    @Override // id.dana.showcase.BaseShowcase
    public final PointerViewPositioningConstant getAuthRequestContext() {
        return PointerViewPositioningConstant.BOTTOM_OF_HIGHLIGHT;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final View KClassImpl$Data$declaredNonStaticMembers$2() {
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(activity, "");
        TextOnlyContentView textOnlyContentView = new TextOnlyContentView(activity, null, 0, 6, null);
        Params params = this.PlaceComponentResult;
        if (params != null) {
            textOnlyContentView.setText(((TextOnlyParams) params).PlaceComponentResult);
            return textOnlyContentView;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.showcase.TextOnlyParams");
    }

    @Override // id.dana.showcase.BaseShowcase
    public final int scheduleImpl() {
        return ConvertUtils.toPx(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), 215.0f);
    }
}
