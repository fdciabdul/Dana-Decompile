package id.dana.sendmoney_v2.x2l;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemSocialLinkBinding;
import id.dana.sendmoney_v2.x2l.model.SocialLinkModel;
import id.dana.utils.ImageResize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney_v2/x2l/SocialLinkViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/sendmoney_v2/x2l/model/SocialLinkModel;", "Lid/dana/databinding/ItemSocialLinkBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialLinkViewHolder extends ViewBindingRecyclerViewHolder<SocialLinkModel, ItemSocialLinkBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        SocialLinkModel socialLinkModel = (SocialLinkModel) obj;
        Intrinsics.checkNotNullParameter(socialLinkModel, "");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        Intrinsics.checkNotNullParameter(context, "");
        String MyBillsEntityDataFactory = SocialLinkModel.MyBillsEntityDataFactory(context, socialLinkModel.MyBillsEntityDataFactory);
        if (MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory = "";
        }
        AppCompatTextView appCompatTextView = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        String str = MyBillsEntityDataFactory;
        appCompatTextView.setVisibility(StringsKt.isBlank(str) ^ true ? 0 : 8);
        appCompatTextView.setText(str);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        Intrinsics.checkNotNullParameter(context2, "");
        String MyBillsEntityDataFactory2 = SocialLinkModel.MyBillsEntityDataFactory(context2, socialLinkModel.BuiltInFictitiousFunctionClassFactory);
        if (MyBillsEntityDataFactory2 == null) {
            MyBillsEntityDataFactory2 = "";
        }
        AppCompatTextView appCompatTextView2 = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        String str2 = MyBillsEntityDataFactory2;
        appCompatTextView2.setVisibility(StringsKt.isBlank(str2) ^ true ? 0 : 8);
        appCompatTextView2.setText(str2);
        String str3 = socialLinkModel.PlaceComponentResult;
        SocialLinkUtil socialLinkUtil = SocialLinkUtil.INSTANCE;
        int PlaceComponentResult = SocialLinkUtil.PlaceComponentResult(socialLinkModel.getAuthRequestContext);
        AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
        GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(str3).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(PlaceComponentResult).PlaceComponentResult(PlaceComponentResult).MyBillsEntityDataFactory((ImageView) appCompatImageView);
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemSocialLinkBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemSocialLinkBinding MyBillsEntityDataFactory = ItemSocialLinkBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SocialLinkViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559271(0x7f0d0367, float:1.8743881E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.x2l.SocialLinkViewHolder.<init>(android.view.ViewGroup):void");
    }
}
