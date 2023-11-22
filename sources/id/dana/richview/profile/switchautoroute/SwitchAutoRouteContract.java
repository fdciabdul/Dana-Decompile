package id.dana.richview.profile.switchautoroute;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.customdialog.CustomDialogKey;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract;", "", "AnalyticsTracker", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SwitchAutoRouteContract {

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$AnalyticsTracker;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface AnalyticsTracker {
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006J'\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "isHaveAsset", "", "onCheckHavingAutorouteAsset", "(Z)V", CustomDialogKey.Response.IS_CHECKED, "onSwitchResultAccept", "onSwitchResultReject", "", BioUtilityBridge.SECURITY_ID, RecordError.KEY_PUB_KEY, "onSwitchResultRisk", "(ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onCheckHavingAutorouteAsset(boolean isHaveAsset);

        void onSwitchResultAccept(boolean isChecked);

        void onSwitchResultReject(boolean isChecked);

        void onSwitchResultRisk(boolean isChecked, String securityId, String pubKey);
    }
}
