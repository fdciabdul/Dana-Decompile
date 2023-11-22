package id.dana.onboarding.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.onboarding.view.SimpleView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0018\u0010\fJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000\r8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00018\u00008\u0005X\u0085\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/onboarding/view/BaseSimpleViewBinding;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lid/dana/onboarding/view/SimpleView;", "Landroid/content/Context;", "p0", "Landroid/view/ViewGroup;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "n_", "()V", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "()Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "Landroid/view/View;", "m_", "()Landroid/view/View;", "PlaceComponentResult", "Landroidx/viewbinding/ViewBinding;", "lookAheadTest", "()Landroidx/viewbinding/ViewBinding;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseSimpleViewBinding<VB extends ViewBinding> implements SimpleView {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private VB KClassImpl$Data$declaredNonStaticMembers$2;

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public abstract Function1<LayoutInflater, VB> KClassImpl$Data$declaredNonStaticMembers$2();

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "lookAheadTest")
    public final VB lookAheadTest() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.onboarding.view.SimpleView
    @JvmName(name = "m_")
    public final View m_() {
        VB vb = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (vb != null) {
            return vb.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return null;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, ViewGroup p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        LayoutInflater from = LayoutInflater.from(p1.getContext());
        Function1<LayoutInflater, VB> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(from, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.invoke(from);
        SimpleView.CC.BuiltInFictitiousFunctionClassFactory(this, p0, p1);
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void n_() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
