package id.dana.myprofile.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.databinding.ViewProfileSettingChatbotBinding;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.utils.extension.LanguageExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/myprofile/viewholder/NewProfileMenuChatbotViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/databinding/ViewProfileSettingChatbotBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileMenuChatbotViewHolder extends ViewBindingRecyclerViewHolder<SettingModel, ViewProfileSettingChatbotBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String titleEn;
        String subtitleEn;
        SettingModel settingModel = (SettingModel) obj;
        super.bindData(settingModel);
        if (LanguageExtKt.getAuthRequestContext()) {
            if (settingModel != null) {
                titleEn = settingModel.getTitle();
            }
            titleEn = null;
        } else {
            if (settingModel != null) {
                titleEn = settingModel.getTitleEn();
            }
            titleEn = null;
        }
        if (LanguageExtKt.getAuthRequestContext()) {
            if (settingModel != null) {
                subtitleEn = settingModel.getSubtitle();
            }
            subtitleEn = null;
        } else {
            if (settingModel != null) {
                subtitleEn = settingModel.getSubtitleEn();
            }
            subtitleEn = null;
        }
        getBinding().lookAheadTest.setText(titleEn);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(subtitleEn);
        String iconUrl = settingModel != null ? settingModel.getIconUrl() : null;
        if (TextUtils.isEmpty(iconUrl)) {
            return;
        }
        if (SvgLoader.getAuthRequestContext(iconUrl)) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(context);
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = iconUrl;
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.res_0x7f0808da_kclassimpl_data_declarednonstaticmembers_2;
            KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new CircleCrop();
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = getBinding().getAuthRequestContext;
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
            return;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        GlideApp.getAuthRequestContext(context2).PlaceComponentResult(iconUrl).getErrorConfigVersion((int) R.drawable.res_0x7f0808da_kclassimpl_data_declarednonstaticmembers_2).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult((int) R.drawable.res_0x7f0808da_kclassimpl_data_declarednonstaticmembers_2).MyBillsEntityDataFactory(getBinding().getAuthRequestContext);
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewProfileSettingChatbotBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewProfileSettingChatbotBinding authRequestContext = ViewProfileSettingChatbotBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NewProfileMenuChatbotViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560007(0x7f0d0647, float:1.8745374E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.viewholder.NewProfileMenuChatbotViewHolder.<init>(android.view.ViewGroup):void");
    }
}
