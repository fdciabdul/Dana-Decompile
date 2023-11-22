package id.dana.richview.servicescard.adapter.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.databinding.LayoutCustomGridviewBinding;
import id.dana.model.ThirdPartyService;
import id.dana.richview.servicescard.helper.ServiceCardHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/richview/servicescard/adapter/viewholder/ServiceViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/model/ThirdPartyService;", "Lid/dana/databinding/LayoutCustomGridviewBinding;", "", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;I)V", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/model/ThirdPartyService;)V", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceViewHolder extends ViewBindingRecyclerViewHolder<ThirdPartyService, LayoutCustomGridviewBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        ThirdPartyService thirdPartyService = (ThirdPartyService) obj;
        Intrinsics.checkNotNullParameter(thirdPartyService, "");
        super.bindData(thirdPartyService);
        ServiceCardHelper serviceCardHelper = ServiceCardHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        String BuiltInFictitiousFunctionClassFactory = ServiceCardHelper.BuiltInFictitiousFunctionClassFactory(context, thirdPartyService);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(BuiltInFictitiousFunctionClassFactory);
        }
        int i = thirdPartyService.D;
        if (i == 1) {
            AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.ic_more);
            } else {
                appCompatImageView.setImageResource(R.drawable.ic_more);
            }
            getBinding().moveToNextValue.setContentDescription(getContext().getString(R.string.btnViewAllServices));
        } else if (i != 2) {
            String str = thirdPartyService.GetContactSyncConfig;
            ServiceCardHelper serviceCardHelper2 = ServiceCardHelper.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            int BuiltInFictitiousFunctionClassFactory2 = ServiceCardHelper.BuiltInFictitiousFunctionClassFactory(context2, thirdPartyService.FragmentBottomSheetPaymentSettingBinding);
            if (SvgLoader.getAuthRequestContext(str)) {
                MyBillsEntityDataFactory(str != null ? str : "");
            } else {
                BuiltInFictitiousFunctionClassFactory(str != null ? str : "", BuiltInFictitiousFunctionClassFactory2);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyService);
        } else {
            String str2 = thirdPartyService.GetContactSyncConfig;
            ServiceCardHelper serviceCardHelper3 = ServiceCardHelper.INSTANCE;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "");
            int BuiltInFictitiousFunctionClassFactory3 = ServiceCardHelper.BuiltInFictitiousFunctionClassFactory(context3, thirdPartyService.FragmentBottomSheetPaymentSettingBinding);
            if (SvgLoader.getAuthRequestContext(str2)) {
                MyBillsEntityDataFactory(str2 != null ? str2 : "");
            } else {
                BuiltInFictitiousFunctionClassFactory(str2 != null ? str2 : "", BuiltInFictitiousFunctionClassFactory3);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyService);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ LayoutCustomGridviewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        LayoutCustomGridviewBinding BuiltInFictitiousFunctionClassFactory = LayoutCustomGridviewBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.layout_custom_gridview, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    private final void MyBillsEntityDataFactory(String p0) {
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = p0;
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.service_skeleton_circle;
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = getBinding().MyBillsEntityDataFactory;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, int p1) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(p0).getErrorConfigVersion((int) R.drawable.service_skeleton_circle).PlaceComponentResult(p1).MyBillsEntityDataFactory((ImageView) getBinding().MyBillsEntityDataFactory);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(ThirdPartyService p0) {
        String str = p0.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String;
        if (TextUtils.isEmpty(str)) {
            getBinding().PlaceComponentResult.setVisibility(8);
        } else {
            getBinding().PlaceComponentResult.setText(str);
            getBinding().PlaceComponentResult.setVisibility(0);
        }
        AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(p0.getIsLayoutRequested() ? 0 : 8);
        AppCompatImageView appCompatImageView2 = getBinding().getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        appCompatImageView2.setVisibility(p0.getNetworkUserEntityData$$ExternalSyntheticLambda1() ^ true ? 0 : 8);
        String str2 = p0.AppCompatEmojiTextHelper;
        String str3 = str2;
        if ((str3 == null || str3.length() == 0) || !Intrinsics.areEqual(str2, "mobilerecharge")) {
            return;
        }
        getBinding().moveToNextValue.setContentDescription(getContext().getString(R.string.btnMobileRecharge));
    }
}
