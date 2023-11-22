package id.dana.switchfaceauth;

import android.app.Activity;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.base.AbstractContract;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/switchfaceauth/SwitchFaceAuthContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SwitchFaceAuthContract {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/switchfaceauth/SwitchFaceAuthContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "", "p0", "", "p1", "Landroid/app/Activity;", "p2", "", "MyBillsEntityDataFactory", "(ZLjava/lang/String;Landroid/app/Activity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory(boolean p0, String p1, Activity p2);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/switchfaceauth/SwitchFaceAuthContract$View;", "Lid/dana/base/AbstractContract$AbstractView;", "", BioUtilityBridge.SECURITY_ID, RecordError.KEY_PUB_KEY, "", "faceAuthNew", "", "onFaceSwitchRiskChallenge", "(Ljava/lang/String;Ljava/lang/String;Z)V", "onFailFaceEnroll", "()V", "onFailToggle", "onSuccessFaceSwitch", "(Ljava/lang/Boolean;)V", "toKYC"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void onFaceSwitchRiskChallenge(String securityId, String pubKey, boolean faceAuthNew);

        void onFailFaceEnroll();

        void onFailToggle();

        void onSuccessFaceSwitch(Boolean faceAuthNew);

        void toKYC();
    }
}
