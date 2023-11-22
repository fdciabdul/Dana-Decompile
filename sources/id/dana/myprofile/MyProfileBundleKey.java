package id.dana.myprofile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/myprofile/MyProfileBundleKey;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface MyProfileBundleKey {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.getAuthRequestContext;
    public static final String FROM_FEEDS_SETTING_ICON = "fromFeedsSettingIcon";
    public static final String HIGHLIGHT_AUTO_ROUTING_FEATURE = "highlightAutoRoutingFeature";
    public static final String HIGHLIGHT_SECURITY_WALLET_PIN_FEATURE = "highlightSecurityWalletPinFeature";
    public static final String MIXPANEL_SOURCE = "mixpanelSource";
    public static final String OPEN_TRUSTED_DEVICE_PAGE = "openTrustedDevicePage";
    public static final String SETTING_MODEL = "settingModel";
    public static final String SHOW_ALWAYS_ASK_PIN_SUCCESS_DIALOG = "alwaysAskPinSuccessDialog";
    public static final String SWITCH_FACE_AUTH_ON = "switchFaceAuthOn";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/myprofile/MyProfileBundleKey$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion getAuthRequestContext = new Companion();

        private Companion() {
        }
    }
}
