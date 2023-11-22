package id.dana.richview.servicescard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.model.ThirdPartyService;
import id.dana.richview.servicescard.adapter.viewholder.PromotedServiceV2ViewHolder;
import id.dana.richview.servicescard.adapter.viewholder.ServiceV2ViewHolder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\b\u0001\u0012\u00020\f0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/richview/servicescard/adapter/ServiceV2ViewHolderFactory;", "", "", "p0", "Landroid/view/ViewGroup;", "p1", "Landroid/view/View$OnClickListener;", "p2", "Ljava/lang/Runnable;", "p3", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/model/ThirdPartyService;", "Landroidx/viewbinding/ViewBinding;", "BuiltInFictitiousFunctionClassFactory", "(ILandroid/view/ViewGroup;Landroid/view/View$OnClickListener;Ljava/lang/Runnable;)Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(IZ)I", "<init>", "()V", "ServiceViewHolderType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServiceV2ViewHolderFactory {
    public static final ServiceV2ViewHolderFactory INSTANCE = new ServiceV2ViewHolderFactory();

    public static int KClassImpl$Data$declaredNonStaticMembers$2(int p0, boolean p1) {
        return (p1 && p0 == 0) ? 0 : 1;
    }

    private ServiceV2ViewHolderFactory() {
    }

    public static ViewBindingRecyclerViewHolder<ThirdPartyService, ? extends ViewBinding> BuiltInFictitiousFunctionClassFactory(int p0, ViewGroup p1, View.OnClickListener p2, Runnable p3) {
        Intrinsics.checkNotNullParameter(p1, "");
        Context context = p1.getContext();
        if (p0 == 0) {
            Intrinsics.checkNotNullExpressionValue(context, "");
            return new PromotedServiceV2ViewHolder(context, p1, p2, p3);
        }
        Intrinsics.checkNotNullExpressionValue(context, "");
        return new ServiceV2ViewHolder(context, p1, p3);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/richview/servicescard/adapter/ServiceV2ViewHolderFactory$ServiceViewHolderType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ServiceViewHolderType {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
        public static final int VIEW_TYPE_PROMOTED_SERVICE = 0;
        public static final int VIEW_TYPE_SERVICE = 1;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/richview/servicescard/adapter/ServiceV2ViewHolderFactory$ServiceViewHolderType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

            private Companion() {
            }
        }
    }
}
