package id.dana.danah5;

import android.content.Context;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.GriverExtension;
import com.alibaba.griver.api.common.page.GriverInterceptUrlEvent;
import com.alibaba.griver.api.common.page.GriverPageHelperEvent;
import com.alibaba.griver.api.common.view.GriverTitleBarEvent;
import com.alipay.iap.android.lbs.LBSLocation;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zoloz.builder.plugin.ZLZCommonH5PluginImpl;
import dagger.Lazy;
import id.dana.R;
import id.dana.danah5.akulaku.AkuDeviceInfoBridge;
import id.dana.danah5.akulaku.AkuLocationGuideBridge;
import id.dana.danah5.akulaku.LocationInfoBridge;
import id.dana.danah5.bca.BcaWebviewEventHandler;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.bottomsheet.BottomSheetBridge;
import id.dana.danah5.cardbinding.CardBindingBridge;
import id.dana.danah5.checksendevent.CheckSendEventBridge;
import id.dana.danah5.chrome.CustomTabBridge;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.contact.ContactBridge;
import id.dana.danah5.customdialog.CustomDialogBridge;
import id.dana.danah5.customnotificationsound.CustomNotificationSoundBridge;
import id.dana.danah5.customredirectto.CutomRedirectToBridge;
import id.dana.danah5.danacicil.DanaCicilWebViewEventHandler;
import id.dana.danah5.danaprotection.DanaProtectionBridge;
import id.dana.danah5.danaprotection.riskchallenge.RiskChallengeBridge;
import id.dana.danah5.deeplink.DeeplinkCatcherEventHandler;
import id.dana.danah5.deeplink.scanQr.OpenScanQrBridge;
import id.dana.danah5.easteregg.EasterEggsEventHandler;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationBridge;
import id.dana.danah5.getconfigforh5.GetConfigForH5Bridge;
import id.dana.danah5.getonlineconfig.GetOnlineConfigBridge;
import id.dana.danah5.globalnetwork.GlobalNetworkBridge;
import id.dana.danah5.imagecapture.ImageCaptureBridge;
import id.dana.danah5.location.GetLocationNameBridge;
import id.dana.danah5.locationpicker.MapsUtilityBridge;
import id.dana.danah5.mixpanel.MixpanelBridge;
import id.dana.danah5.networkinfo.GetNetworkInfoBridge;
import id.dana.danah5.nfcutility.NfcUtilityBridge;
import id.dana.danah5.ocrreceipt.OCRReceiptBridge;
import id.dana.danah5.ocrreceipt.UploadLocalImageBridge;
import id.dana.danah5.openallshop.OpenAllShopBridge;
import id.dana.danah5.openapp.OpenNativeAppBridge;
import id.dana.danah5.opennativesetting.OpenNativeSetting;
import id.dana.danah5.opennearbyme.OpenNearbyMeBridge;
import id.dana.danah5.permission.CheckStoragePermissionBridge;
import id.dana.danah5.qrbinding.QrBindingCatcherEventHandler;
import id.dana.danah5.qrisinfo.GetNmidQrInfoBridge;
import id.dana.danah5.referralengagement.ShowReferralEngagementDialogBridge;
import id.dana.danah5.resetpin.GetPhoneNumberBridge;
import id.dana.danah5.resetpin.SelfUnfreezeEventHandler;
import id.dana.danah5.resocenter.OpenNativeChatBotBridge;
import id.dana.danah5.scanqr.ScanQrBridge;
import id.dana.danah5.screenshot.ScreenshotBridge;
import id.dana.danah5.sendevent.SendEventBridge;
import id.dana.danah5.sendmoney.SendMoneyBridge;
import id.dana.danah5.share.ShareBridge;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.danah5.showagreement.ShowAgreementBridge;
import id.dana.danah5.splitbill.SplitBillBridge;
import id.dana.danah5.splunk.SplunkWebViewPageListener;
import id.dana.danah5.subapp.CallSubAppBridge;
import id.dana.danah5.suggestlocations.SuggestLocationsBridge;
import id.dana.danah5.tnccardpayment.TncCardPaymentBridge;
import id.dana.danah5.tooltip.TooltipBridge;
import id.dana.danah5.tracker.GeneralTrackEventBridge;
import id.dana.danah5.tracker.StartTimeEventBridge;
import id.dana.danah5.tracker.TrackEventBridge;
import id.dana.danah5.transactionstatus.TransactionStatusBridge;
import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductBridge;
import id.dana.danah5.uploadfiles.UploadFilesBridge;
import id.dana.danah5.userinfo.GetUsernameBridge;
import id.dana.danah5.yellowai.YellowAiCatcherEventHandler;
import id.dana.domain.geocode.interactor.GetLatestSubdivision;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.lib.drawbitmap.DrawBitmapBridge;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInfo;
import id.dana.lib.gcontainer.app.bridge.deviceinfo.DeviceInformationBridge;
import id.dana.lib.gcontainer.app.bridge.deviceinfo.ILocationListener;
import id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadFileBridge;
import id.dana.lib.gcontainer.app.bridge.imagepicker.ImagePickerBridge;
import id.dana.lib.gcontainer.app.bridge.launchothersapp.DirectMessageBridge;
import id.dana.lib.gcontainer.app.bridge.requestpermissions.RequestPermissionsBridge;
import id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle;
import id.dana.mybills.danah5.BillerPortalBridge;
import id.dana.myprofile.GetEnvInfoBridge;
import id.dana.utils.LocationUtil;
import id.dana.utils.foundation.facede.LbsFacade;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJA\u0010\u0012\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\"\u0010\u0011\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b0\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\tJ3\u0010\u0016\u001a\u00020\u00072\"\u0010\u0011\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b0\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\tR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\r\u0010\u001e"}, d2 = {"Lid/dana/danah5/DanaH5Injector;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "detectFakeGpsAndGpsService", "(Landroid/content/Context;)Ljava/lang/String;", "", "implementLocationListener", "()V", "initView", "Ldagger/Lazy;", "Lid/dana/domain/geocode/interactor/GetLatestSubdivision;", "getLatestSubdivision", "", "Ljava/lang/Class;", "Lcom/alibaba/griver/api/common/GriverExtension;", "extensions", "inject", "(Ldagger/Lazy;Ljava/util/Map;)V", "provideBridges", "provideEventHandler", "provideExtension", "(Ljava/util/Map;)V", "provideGeocodeGetLatestSubdivision", "(Ldagger/Lazy;)V", "registerBridgeListener", "", "GET_CITY_NAME_TIMEOUT_IN_SECONDS", "J", "Ldagger/Lazy;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaH5Injector {
    private static final long GET_CITY_NAME_TIMEOUT_IN_SECONDS = 1;
    public static final DanaH5Injector INSTANCE = new DanaH5Injector();
    private static Lazy<GetLatestSubdivision> getLatestSubdivision;

    private DanaH5Injector() {
    }

    @JvmStatic
    public static final void inject(Lazy<GetLatestSubdivision> getLatestSubdivision2, Map<Class<? extends GriverExtension>, ? extends Lazy<? extends GriverExtension>> extensions) {
        Intrinsics.checkNotNullParameter(getLatestSubdivision2, "");
        Intrinsics.checkNotNullParameter(extensions, "");
        DanaH5Injector danaH5Injector = INSTANCE;
        danaH5Injector.initView();
        danaH5Injector.provideGeocodeGetLatestSubdivision(getLatestSubdivision2);
        danaH5Injector.provideBridges();
        danaH5Injector.provideEventHandler();
        danaH5Injector.provideExtension(extensions);
        danaH5Injector.registerBridgeListener();
    }

    private final void provideGeocodeGetLatestSubdivision(Lazy<GetLatestSubdivision> getLatestSubdivision2) {
        getLatestSubdivision = getLatestSubdivision2;
    }

    private final void initView() {
        ToolbarStyle toolbarStyle = GContainer.getToolbarStyle();
        toolbarStyle.setToolbarBackgroundColor(R.color.f23182131099816);
        toolbarStyle.getTitle().setTextColor(17170443);
        toolbarStyle.getBackButton().setIcon(R.drawable.btn_arrow_left);
        toolbarStyle.getBackButton().setColor(17170443);
        toolbarStyle.getCloseButton().setShow(false);
        toolbarStyle.getCloseButton().setColor(17170443);
    }

    private final void provideExtension(Map<Class<? extends GriverExtension>, ? extends Lazy<? extends GriverExtension>> extensions) {
        for (Map.Entry<Class<? extends GriverExtension>, ? extends Lazy<? extends GriverExtension>> entry : extensions.entrySet()) {
            Class<? extends GriverExtension> key = entry.getKey();
            GriverExtension griverExtension = entry.getValue().get();
            if (griverExtension != null) {
                GContainer.registerExtension(key, griverExtension);
            }
        }
    }

    private final void provideEventHandler() {
        GContainer gContainer = GContainer.INSTANCE;
        GContainer.registerEventHandler(Page.class, SplunkWebViewPageListener.class, ArraysKt.toList(new Class[]{SplunkWebViewPageListener.class, GriverInterceptUrlEvent.class}));
        GContainer gContainer2 = GContainer.INSTANCE;
        GContainer.registerEventHandler(Page.class, QrBindingCatcherEventHandler.class, ArraysKt.toList(new Class[]{GriverPageHelperEvent.class, GriverInterceptUrlEvent.class}));
        GContainer gContainer3 = GContainer.INSTANCE;
        GContainer.registerEventHandler(Page.class, DeeplinkCatcherEventHandler.class, ArraysKt.toList(new Class[]{GriverPageHelperEvent.class, GriverInterceptUrlEvent.class}));
        GContainer gContainer4 = GContainer.INSTANCE;
        GContainer.registerEventHandler(Page.class, EasterEggsEventHandler.class, ArraysKt.toList(new Class[]{GriverTitleBarEvent.class, GriverInterceptUrlEvent.class}));
        GContainer gContainer5 = GContainer.INSTANCE;
        GContainer.registerEventHandler(Page.class, BcaWebviewEventHandler.class, ArraysKt.toList(new Class[]{GriverTitleBarEvent.class, GriverInterceptUrlEvent.class}));
        GContainer gContainer6 = GContainer.INSTANCE;
        GContainer.registerEventHandler(Page.class, YellowAiCatcherEventHandler.class, ArraysKt.toList(new Class[]{GriverPageHelperEvent.class, GriverInterceptUrlEvent.class}));
        GContainer gContainer7 = GContainer.INSTANCE;
        GContainer.registerEventHandler(Page.class, DanaCicilWebViewEventHandler.class, ArraysKt.toList(new Class[]{GriverPageHelperEvent.class, GriverInterceptUrlEvent.class}));
        GContainer gContainer8 = GContainer.INSTANCE;
        GContainer.registerEventHandler(Page.class, SelfUnfreezeEventHandler.class, ArraysKt.toList(new Class[]{GriverPageHelperEvent.class, GriverInterceptUrlEvent.class}));
    }

    private final void provideBridges() {
        GContainer gContainer = GContainer.INSTANCE;
        GContainer.registerBridge(CheckSendEventBridge.class, ArraysKt.toList(new String[]{"checkSendEvent"}));
        GContainer gContainer2 = GContainer.INSTANCE;
        GContainer.registerBridge(CustomDialogBridge.class, ArraysKt.toList(new String[]{BridgeName.CUSTOM_DIALOG}));
        GContainer gContainer3 = GContainer.INSTANCE;
        GContainer.registerBridge(SendEventBridge.class, ArraysKt.toList(new String[]{"sendEvent"}));
        GContainer gContainer4 = GContainer.INSTANCE;
        GContainer.registerBridge(GetConfigForH5Bridge.class, ArraysKt.toList(new String[]{BridgeName.GET_CONFIG_FOR_H5}));
        GContainer gContainer5 = GContainer.INSTANCE;
        GContainer.registerBridge(CustomNotificationSoundBridge.class, ArraysKt.toList(new String[]{BridgeName.CUSTOM_NOTIFICATION_SOUND}));
        GContainer gContainer6 = GContainer.INSTANCE;
        GContainer.registerBridge(BioUtilityBridge.class, ArraysKt.toList(new String[]{BridgeName.BIO_UTILITY}));
        GContainer gContainer7 = GContainer.INSTANCE;
        GContainer.registerBridge(GlobalNetworkBridge.class, ArraysKt.toList(new String[]{BridgeName.FOREX}));
        GContainer gContainer8 = GContainer.INSTANCE;
        GContainer.registerBridge(TooltipBridge.class, ArraysKt.toList(new String[]{"tooltip"}));
        GContainer gContainer9 = GContainer.INSTANCE;
        GContainer.registerBridge(AkuDeviceInfoBridge.class, ArraysKt.toList(new String[]{BridgeName.GET_AKU_DEVICE_INFO}));
        GContainer gContainer10 = GContainer.INSTANCE;
        GContainer.registerBridge(AkuLocationGuideBridge.class, ArraysKt.toList(new String[]{BridgeName.LOCATION_PERMISSION_GUIDE}));
        GContainer gContainer11 = GContainer.INSTANCE;
        GContainer.registerBridge(LocationInfoBridge.class, ArraysKt.toList(new String[]{BridgeName.GET_LOCATION_INFO}));
        GContainer gContainer12 = GContainer.INSTANCE;
        GContainer.registerBridge(GetOnlineConfigBridge.class, ArraysKt.toList(new String[]{BridgeName.GET_ONLINE_CONFIG}));
        GContainer gContainer13 = GContainer.INSTANCE;
        GContainer.registerBridge(OCRReceiptBridge.class, ArraysKt.toList(new String[]{BridgeName.RECOGNIZE_TEXT_MERCHANT_RECEIPT}));
        GContainer gContainer14 = GContainer.INSTANCE;
        GContainer.registerBridge(UploadLocalImageBridge.class, ArraysKt.toList(new String[]{"uploadLocalImage"}));
        GContainer gContainer15 = GContainer.INSTANCE;
        GContainer.registerBridge(ScreenshotBridge.class, ArraysKt.toList(new String[]{"screenshot"}));
        GContainer gContainer16 = GContainer.INSTANCE;
        GContainer.registerBridge(ZLZCommonH5PluginImpl.class, ArraysKt.toList(new String[]{BridgeName.ZOLOZ_FOUNDATION, BridgeName.HUMMER_FOUNDATION, BridgeName.ZIM_IDENTITY}));
        GContainer gContainer17 = GContainer.INSTANCE;
        GContainer.registerBridge(ShareBridge.class, ArraysKt.toList(new String[]{"share", "shareFile"}));
        GContainer gContainer18 = GContainer.INSTANCE;
        GContainer.registerBridge(RequestPermissionsBridge.class, ArraysKt.toList(new String[]{"requestPermissions"}));
        GContainer gContainer19 = GContainer.INSTANCE;
        GContainer.registerBridge(ImagePickerBridge.class, ArraysKt.toList(new String[]{"imagePicker"}));
        GContainer gContainer20 = GContainer.INSTANCE;
        GContainer.registerBridge(DrawBitmapBridge.class, ArraysKt.toList(new String[]{DrawBitmapBridge.JSAPI_ACTION}));
        GContainer gContainer21 = GContainer.INSTANCE;
        GContainer.registerBridge(DownloadFileBridge.class, ArraysKt.toList(new String[]{"downloadFile", "download"}));
        GContainer gContainer22 = GContainer.INSTANCE;
        GContainer.registerBridge(DeviceInformationBridge.class, ArraysKt.toList(new String[]{"getDeviceInfo"}));
        GContainer gContainer23 = GContainer.INSTANCE;
        GContainer.registerBridge(DirectMessageBridge.class, ArraysKt.toList(new String[]{"directMessage"}));
        GContainer gContainer24 = GContainer.INSTANCE;
        GContainer.registerBridge(OpenNativeAppBridge.class, ArraysKt.toList(new String[]{BridgeName.OPEN_NATIVE_APP}));
        GContainer gContainer25 = GContainer.INSTANCE;
        GContainer.registerBridge(OpenAllShopBridge.class, ArraysKt.toList(new String[]{BridgeName.OPEN_ALL_SHOP}));
        GContainer gContainer26 = GContainer.INSTANCE;
        GContainer.registerBridge(OpenNearbyMeBridge.class, ArraysKt.toList(new String[]{BridgeName.OPEN_NEARBY_ME_APP}));
        GContainer gContainer27 = GContainer.INSTANCE;
        GContainer.registerBridge(CutomRedirectToBridge.class, ArraysKt.toList(new String[]{BridgeName.CUSTOM_REDIRECT_TO}));
        GContainer gContainer28 = GContainer.INSTANCE;
        GContainer.registerBridge(SuggestLocationsBridge.class, ArraysKt.toList(new String[]{BridgeName.SUGGEST_LOCATIONS}));
        GContainer gContainer29 = GContainer.INSTANCE;
        GContainer.registerBridge(MapsUtilityBridge.class, ArraysKt.toList(new String[]{BridgeName.MAP_UTILITY}));
        GContainer gContainer30 = GContainer.INSTANCE;
        GContainer.registerBridge(OpenScanQrBridge.class, ArraysKt.toList(new String[]{BridgeName.OPEN_SCAN_QR}));
        GContainer gContainer31 = GContainer.INSTANCE;
        GContainer.registerBridge(BottomSheetBridge.class, ArraysKt.toList(new String[]{"bottomSheet"}));
        GContainer gContainer32 = GContainer.INSTANCE;
        GContainer.registerBridge(NfcUtilityBridge.class, ArraysKt.toList(new String[]{BridgeName.NFC_UTILITY}));
        GContainer gContainer33 = GContainer.INSTANCE;
        GContainer.registerBridge(GetLocationNameBridge.class, ArraysKt.toList(new String[]{BridgeName.LOCATION_NAME}));
        GContainer gContainer34 = GContainer.INSTANCE;
        GContainer.registerBridge(ShowAgreementBridge.class, ArraysKt.toList(new String[]{BridgeName.SHOW_AGREEMENT, BridgeName.CONFIRM_USER_INFO}));
        GContainer gContainer35 = GContainer.INSTANCE;
        GContainer.registerBridge(FaceAuthenticationBridge.class, ArraysKt.toList(new String[]{BridgeName.FACE_VERIFICATION_ENABLEMENT, BridgeName.DANA_VIZ}));
        GContainer gContainer36 = GContainer.INSTANCE;
        GContainer.registerBridge(TwilioVerifySecurityProductBridge.class, ArraysKt.toList(new String[]{BridgeName.TWILIO_VERIFY_SECURITY_PRODUCT}));
        GContainer gContainer37 = GContainer.INSTANCE;
        GContainer.registerBridge(ShowReferralEngagementDialogBridge.class, ArraysKt.toList(new String[]{BridgeName.SHOW_REFERRAL_ENGAGEMENT_DIALOG}));
        GContainer gContainer38 = GContainer.INSTANCE;
        GContainer.registerBridge(CallSubAppBridge.class, ArraysKt.toList(new String[]{"callSubApp"}));
        GContainer gContainer39 = GContainer.INSTANCE;
        GContainer.registerBridge(GetUsernameBridge.class, ArraysKt.toList(new String[]{BridgeName.GET_USERNAME}));
        GContainer gContainer40 = GContainer.INSTANCE;
        GContainer.registerBridge(ScanQrBridge.class, ArraysKt.toList(new String[]{BridgeName.SCAN_QR}));
        GContainer gContainer41 = GContainer.INSTANCE;
        GContainer.registerBridge(RequestResultBridge.class, ArraysKt.toList(new String[]{"requestResult", "sendResult"}));
        GContainer gContainer42 = GContainer.INSTANCE;
        GContainer.registerBridge(CustomTabBridge.class, ArraysKt.toList(new String[]{BridgeName.OPEN_IN_CUSTOM_CONTAINER}));
        GContainer gContainer43 = GContainer.INSTANCE;
        GContainer.registerBridge(MixpanelBridge.class, ArraysKt.toList(new String[]{BridgeName.TRACK_EVENT}));
        GContainer gContainer44 = GContainer.INSTANCE;
        GContainer.registerBridge(UploadFilesBridge.class, ArraysKt.toList(new String[]{"uploadFiles"}));
        GContainer gContainer45 = GContainer.INSTANCE;
        GContainer.registerBridge(ShareToFeedBridge.class, ArraysKt.toList(new String[]{BridgeName.SHARE_TO_FEEDS}));
        GContainer gContainer46 = GContainer.INSTANCE;
        GContainer.registerBridge(ScreenOrientationBridge.class, ArraysKt.toList(new String[]{"changeScreenOrientation"}));
        GContainer gContainer47 = GContainer.INSTANCE;
        GContainer.registerBridge(CheckStoragePermissionBridge.class, ArraysKt.toList(new String[]{BridgeName.CHECK_STORAGE_PERMISSION}));
        GContainer gContainer48 = GContainer.INSTANCE;
        GContainer.registerBridge(SendMoneyBridge.class, ArraysKt.toList(new String[]{BridgeName.SEND_MONEY}));
        GContainer gContainer49 = GContainer.INSTANCE;
        GContainer.registerBridge(GetNetworkInfoBridge.class, ArraysKt.toList(new String[]{BridgeName.NETWORK_INFO}));
        GContainer gContainer50 = GContainer.INSTANCE;
        GContainer.registerBridge(TrackEventBridge.class, ArraysKt.toList(new String[]{BridgeName.TRACK_EVENT_H5}));
        GContainer gContainer51 = GContainer.INSTANCE;
        GContainer.registerBridge(GeneralTrackEventBridge.class, ArraysKt.toList(new String[]{BridgeName.GENERAL_TRACK_EVENT}));
        GContainer gContainer52 = GContainer.INSTANCE;
        GContainer.registerBridge(StartTimeEventBridge.class, ArraysKt.toList(new String[]{BridgeName.TRACK_EVENT_START_TIME_H5}));
        GContainer gContainer53 = GContainer.INSTANCE;
        GContainer.registerBridge(TrackEventBridge.class, ArraysKt.toList(new String[]{BridgeName.TRACK_EVENT_END_TIME_H5}));
        GContainer gContainer54 = GContainer.INSTANCE;
        GContainer.registerBridge(SplitBillBridge.class, ArraysKt.toList(new String[]{BridgeName.SPLIT_BILL_BRIDGE}));
        GContainer gContainer55 = GContainer.INSTANCE;
        GContainer.registerBridge(GetPhoneNumberBridge.class, ArraysKt.toList(new String[]{"getPhoneNumber"}));
        GContainer gContainer56 = GContainer.INSTANCE;
        GContainer.registerBridge(TncCardPaymentBridge.class, ArraysKt.toList(new String[]{BridgeName.TNC_CARD_PAYMENT}));
        GContainer gContainer57 = GContainer.INSTANCE;
        GContainer.registerBridge(OpenNativeSetting.class, ArraysKt.toList(new String[]{BridgeName.OPEN_NATIVE_SETTING}));
        GContainer gContainer58 = GContainer.INSTANCE;
        GContainer.registerBridge(GetEnvInfoBridge.class, ArraysKt.toList(new String[]{BridgeName.GET_ENV_INFO}));
        GContainer gContainer59 = GContainer.INSTANCE;
        GContainer.registerBridge(id.dana.danah5.requestpermissions.RequestPermissionsBridge.class, ArraysKt.toList(new String[]{"requestPermissions"}));
        GContainer gContainer60 = GContainer.INSTANCE;
        GContainer.registerBridge(CardBindingBridge.class, ArraysKt.toList(new String[]{BridgeName.OCR_CARD_BINDING_OCR}));
        GContainer gContainer61 = GContainer.INSTANCE;
        GContainer.registerBridge(DanaProtectionBridge.class, ArraysKt.toList(new String[]{BridgeName.DANA_PROTECTION}));
        GContainer gContainer62 = GContainer.INSTANCE;
        GContainer.registerBridge(GetNmidQrInfoBridge.class, ArraysKt.toList(new String[]{BridgeName.GET_NMID_QR_INFO}));
        GContainer gContainer63 = GContainer.INSTANCE;
        GContainer.registerBridge(BillerPortalBridge.class, ArraysKt.toList(new String[]{BillerPortalBridge.JSAPI_METHOD_NAME}));
        GContainer gContainer64 = GContainer.INSTANCE;
        GContainer.registerBridge(ContactBridge.class, ArraysKt.toList(new String[]{"contacts"}));
        GContainer gContainer65 = GContainer.INSTANCE;
        GContainer.registerBridge(TransactionStatusBridge.class, ArraysKt.toList(new String[]{"transactionStatus"}));
        GContainer gContainer66 = GContainer.INSTANCE;
        GContainer.registerBridge(OpenNativeChatBotBridge.class, ArraysKt.toList(new String[]{BridgeName.OPEN_CHATBOT_NATIVE}));
        GContainer gContainer67 = GContainer.INSTANCE;
        GContainer.registerBridge(ImageCaptureBridge.class, ArraysKt.toList(new String[]{BridgeName.CAPTURE}));
        GContainer gContainer68 = GContainer.INSTANCE;
        GContainer.registerBridge(RiskChallengeBridge.class, ArraysKt.toList(new String[]{BridgeName.RISK_CHALLENGE}));
    }

    private final void registerBridgeListener() {
        implementLocationListener();
    }

    private final void implementLocationListener() {
        DeviceInformationBridge.INSTANCE.setLocationListener(new ILocationListener() { // from class: id.dana.danah5.DanaH5Injector$$ExternalSyntheticLambda0
            @Override // id.dana.lib.gcontainer.app.bridge.deviceinfo.ILocationListener
            public final DeviceInfo.Gps getLatestLocation(Context context) {
                DeviceInfo.Gps m628implementLocationListener$lambda2;
                m628implementLocationListener$lambda2 = DanaH5Injector.m628implementLocationListener$lambda2(context);
                return m628implementLocationListener$lambda2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: implementLocationListener$lambda-2  reason: not valid java name */
    public static final DeviceInfo.Gps m628implementLocationListener$lambda2(Context context) {
        DeviceInfo.Gps gps = new DeviceInfo.Gps(null, null, 0, 0L, null, 31, null);
        LBSLocation authRequestContext = LbsFacade.getAuthRequestContext(context);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5Injector danaH5Injector = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "");
        gps.setCityName(danaH5Injector.detectFakeGpsAndGpsService(context));
        gps.setLatitude(String.valueOf(authRequestContext.getLatitude()));
        gps.setLongitude(String.valueOf(authRequestContext.getLongitude()));
        gps.setTime(authRequestContext.getTime());
        gps.setError(authRequestContext.getErrorCode());
        return gps;
    }

    private final String detectFakeGpsAndGpsService(Context context) {
        Lazy<GetLatestSubdivision> lazy = getLatestSubdivision;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        LocationSubdisivision execute = lazy.get().execute(new GetLatestSubdivision.Params(1L));
        return (execute.getIndoSubdivisions().isMockLocation() || !LocationUtil.getAuthRequestContext(context)) ? "" : execute.getIndoSubdivisions().getCityName();
    }
}
