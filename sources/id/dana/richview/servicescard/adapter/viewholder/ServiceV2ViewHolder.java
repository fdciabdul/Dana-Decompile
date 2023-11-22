package id.dana.richview.servicescard.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.databinding.NewLayoutCustomGridviewRelativeBinding;
import id.dana.model.ThirdPartyService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000e"}, d2 = {"Lid/dana/richview/servicescard/adapter/viewholder/ServiceV2ViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/model/ThirdPartyService;", "Lid/dana/databinding/NewLayoutCustomGridviewRelativeBinding;", "", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;I)V", "getAuthRequestContext", "(Ljava/lang/String;)V", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "p2", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Ljava/lang/Runnable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceV2ViewHolder extends ViewBindingRecyclerViewHolder<ThirdPartyService, NewLayoutCustomGridviewRelativeBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Runnable KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bc, code lost:
    
        if ((r6.NetworkUserEntityData$$ExternalSyntheticLambda8.length() > 0) == false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.adapter.viewholder.ServiceV2ViewHolder.bindData(java.lang.Object):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ NewLayoutCustomGridviewRelativeBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        NewLayoutCustomGridviewRelativeBinding KClassImpl$Data$declaredNonStaticMembers$2 = NewLayoutCustomGridviewRelativeBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceV2ViewHolder(Context context, ViewGroup viewGroup, Runnable runnable) {
        super(context, R.layout.new_layout_custom_gridview_relative, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable;
    }

    private final void getAuthRequestContext(String p0) {
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = p0;
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.service_skeleton_circle;
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = getBinding().MyBillsEntityDataFactory;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, int p1) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(p0).getErrorConfigVersion((int) R.drawable.service_skeleton_circle).PlaceComponentResult(p1).MyBillsEntityDataFactory(getBinding().MyBillsEntityDataFactory);
    }
}
