package id.dana.expresspurchase.view;

import android.os.Bundle;
import com.alipay.mobile.zebra.data.ZebraData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zhuinden.simplestack.Backstack;
import id.dana.base.OnActivityNavigationManager;
import id.dana.base.SingleBaseActivity;
import id.dana.danah5.DanaH5;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseNavigationManager;", "Lid/dana/base/OnActivityNavigationManager;", "singleBaseActivity", "Lid/dana/base/SingleBaseActivity;", "backstack", "Lcom/zhuinden/simplestack/Backstack;", "(Lid/dana/base/SingleBaseActivity;Lcom/zhuinden/simplestack/Backstack;)V", "expressPurchaseLoadingScreen", "Lid/dana/expresspurchase/view/ExpressPurchaseLoadingScreen;", "goToLoadingScreen", "", ZebraData.ATTR_HEIGHT, "", "goToResultPurchase", HummerConstants.BUNDLE, "Landroid/os/Bundle;", "openContainer", "url", "", "isCloseAfterOpenContainer", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExpressPurchaseNavigationManager extends OnActivityNavigationManager {
    ExpressPurchaseLoadingScreen MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressPurchaseNavigationManager(SingleBaseActivity<?> singleBaseActivity, Backstack backstack) {
        super(backstack, singleBaseActivity);
        Intrinsics.checkNotNullParameter(singleBaseActivity, "");
        Intrinsics.checkNotNullParameter(backstack, "");
    }

    public final void getAuthRequestContext(String str, final boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        String authRequestContext = UrlUtil.getAuthRequestContext(str);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext, new DanaH5Listener() { // from class: id.dana.expresspurchase.view.ExpressPurchaseNavigationManager$openContainer$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerDestroyed(Bundle bundle) {
                DanaH5Listener.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
                if (z) {
                    this.MyBillsEntityDataFactory.finish();
                }
            }
        });
    }
}
