package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.sendmoney_v2.x2l.view.SendToLinkBannerView;
import id.dana.sendmoney_v2.x2l.view.SendToLinkSelectorView;

/* loaded from: classes4.dex */
public final class ActivitySendToLinkBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final SendToLinkBannerView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final SendToLinkSelectorView getAuthRequestContext;

    private ActivitySendToLinkBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, SendToLinkBannerView sendToLinkBannerView, SendToLinkSelectorView sendToLinkSelectorView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = sendToLinkBannerView;
        this.getAuthRequestContext = sendToLinkSelectorView;
    }

    public static ActivitySendToLinkBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_send_to_link, (ViewGroup) null, false);
        int i = R.id.ivBackground;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivBackground);
        if (appCompatImageView != null) {
            SendToLinkBannerView sendToLinkBannerView = (SendToLinkBannerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSendToChatBanner);
            if (sendToLinkBannerView != null) {
                SendToLinkSelectorView sendToLinkSelectorView = (SendToLinkSelectorView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSendToLinkSelector);
                if (sendToLinkSelectorView != null) {
                    return new ActivitySendToLinkBinding((ConstraintLayout) inflate, appCompatImageView, sendToLinkBannerView, sendToLinkSelectorView);
                }
                i = R.id.viewSendToLinkSelector;
            } else {
                i = R.id.viewSendToChatBanner;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
