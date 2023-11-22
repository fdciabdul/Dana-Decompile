package id.dana.sendmoney_v2.x2l.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ViewSendToLinkBannerBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerContract;
import id.dana.sendmoney_v2.x2l.di.DaggerSendToLinkBannerComponent;
import id.dana.sendmoney_v2.x2l.di.SendToLinkBannerModule;
import id.dana.sendmoney_v2.x2l.model.BannerConfigModel;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eB+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010 J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/sendmoney_v2/x2l/view/SendToLinkBannerView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewSendToLinkBannerBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewSendToLinkBannerBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "setup", "()V", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkBannerContract$Presenter;", "sendToLinkBannerPresenter", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkBannerContract$Presenter;", "getSendToLinkBannerPresenter", "()Lid/dana/sendmoney_v2/x2l/contract/SendToLinkBannerContract$Presenter;", "setSendToLinkBannerPresenter", "(Lid/dana/sendmoney_v2/x2l/contract/SendToLinkBannerContract$Presenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendToLinkBannerView extends ViewBindingRichView<ViewSendToLinkBannerBinding> {
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public SendToLinkBannerContract.Presenter sendToLinkBannerPresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendToLinkBannerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendToLinkBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_send_to_link_banner;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendToLinkBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SendToLinkBannerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendToLinkBannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getSendToLinkBannerPresenter")
    public final SendToLinkBannerContract.Presenter getSendToLinkBannerPresenter() {
        SendToLinkBannerContract.Presenter presenter = this.sendToLinkBannerPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendToLinkBannerPresenter")
    public final void setSendToLinkBannerPresenter(SendToLinkBannerContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.sendToLinkBannerPresenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewSendToLinkBannerBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewSendToLinkBannerBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewSendToLinkBannerBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerSendToLinkBannerComponent.Builder authRequestContext = DaggerSendToLinkBannerComponent.getAuthRequestContext();
        authRequestContext.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.getAuthRequestContext = (SendToLinkBannerModule) Preconditions.getAuthRequestContext(new SendToLinkBannerModule(new SendToLinkBannerContract.View() { // from class: id.dana.sendmoney_v2.x2l.view.SendToLinkBannerView$sendToLinkBannerModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(BannerConfigModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SendToLinkBannerView.access$renderBanner(SendToLinkBannerView.this, p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                SendToLinkBannerView sendToLinkBannerView = SendToLinkBannerView.this;
                SendToLinkBannerView.access$renderBanner(sendToLinkBannerView, SendToLinkBannerView.access$getDefaultBannerConfigModel(sendToLinkBannerView));
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, SendToLinkBannerModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PlaceComponentResult, ApplicationComponent.class);
        new DaggerSendToLinkBannerComponent.SendToLinkBannerComponentImpl(authRequestContext.getAuthRequestContext, authRequestContext.PlaceComponentResult, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(getSendToLinkBannerPresenter());
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        getSendToLinkBannerPresenter().BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ BannerConfigModel access$getDefaultBannerConfigModel(SendToLinkBannerView sendToLinkBannerView) {
        Context context = sendToLinkBannerView.getContext();
        String string = context.getString(R.string.sendmoney_to_link_banner_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = context.getString(R.string.sendmoney_to_link_banner_desc);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return new BannerConfigModel(string, string2, "");
    }

    public static final /* synthetic */ void access$renderBanner(SendToLinkBannerView sendToLinkBannerView, BannerConfigModel bannerConfigModel) {
        sendToLinkBannerView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(bannerConfigModel.BuiltInFictitiousFunctionClassFactory);
        sendToLinkBannerView.getBinding().BuiltInFictitiousFunctionClassFactory.setText(bannerConfigModel.MyBillsEntityDataFactory);
        AppCompatImageView appCompatImageView = sendToLinkBannerView.getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(bannerConfigModel.PlaceComponentResult).getErrorConfigVersion((int) R.drawable.bg_illustration_send_to_chat_banner).PlaceComponentResult((int) R.drawable.bg_illustration_send_to_chat_banner).MyBillsEntityDataFactory((ImageView) appCompatImageView);
    }
}
