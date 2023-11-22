package id.dana.onboarding.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.dana.base.extension.UnbinderKtx;
import id.dana.base.extension.UnbinderKtx$$ExternalSyntheticLambda0;
import id.dana.onboarding.view.SimpleView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message = "BaseSimpleView is deprecated because using kotlinx.android.synthetic and butterknife.BindView. It should be view binding", replaceWith = @ReplaceWith(expression = "id.dana.onboarding.view.BaseSimpleViewBinding", imports = {}))
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0003\u0010\nJ\u000f\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0012\u0010\u0003\u001a\u00020\u0005X\u0096\"¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00128\u0017X\u0096&¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/onboarding/view/BaseSimpleView;", "Lid/dana/onboarding/view/SimpleView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "Landroid/content/Context;", "p0", "Landroid/view/ViewGroup;", "p1", "", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "n_", "()V", "PlaceComponentResult", "Landroid/content/Context;", "Lbutterknife/Unbinder;", "Lbutterknife/Unbinder;", "getAuthRequestContext", "Landroid/view/View;", "scheduleImpl", "Landroid/view/View;", "m_", "()Landroid/view/View;", "MyBillsEntityDataFactory", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseSimpleView implements SimpleView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Unbinder getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public View MyBillsEntityDataFactory;

    public abstract int KClassImpl$Data$declaredNonStaticMembers$2();

    @Override // id.dana.onboarding.view.SimpleView
    @JvmName(name = "m_")
    public final View m_() {
        View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, ViewGroup p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        View inflate = LayoutInflater.from(p1.getContext()).inflate(KClassImpl$Data$declaredNonStaticMembers$2(), p1, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        Intrinsics.checkNotNullParameter(inflate, "");
        this.MyBillsEntityDataFactory = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            inflate = null;
        }
        this.getAuthRequestContext = ButterKnife.BuiltInFictitiousFunctionClassFactory(this, inflate);
        SimpleView.CC.BuiltInFictitiousFunctionClassFactory(this, p0, p1);
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void n_() {
        Unbinder unbinder = this.getAuthRequestContext;
        if (unbinder != null) {
            UnbinderKtx.getAuthRequestContext(unbinder, new UnbinderKtx$$ExternalSyntheticLambda0());
        }
    }
}
