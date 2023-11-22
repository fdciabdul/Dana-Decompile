package id.dana.notification;

import android.content.Context;
import android.text.TextUtils;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class NotificationDirectorFactory {
    private final DynamicUrlWrapper BuiltInFictitiousFunctionClassFactory;

    @Inject
    public NotificationDirectorFactory(DynamicUrlWrapper dynamicUrlWrapper) {
        this.BuiltInFictitiousFunctionClassFactory = dynamicUrlWrapper;
    }

    public final NotificationDirector PlaceComponentResult(Context context, NotificationData notificationData) {
        String str = notificationData.getErrorConfigVersion;
        if (str != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -2035039290:
                    if (str.equals("INNER_URL")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1983828400:
                    if (str.equals(RedirectType.TWILIO_CHALLENGE)) {
                        c = 1;
                        break;
                    }
                    break;
                case -805752590:
                    if (str.equals("TRANSACTION_DETAIL")) {
                        c = 2;
                        break;
                    }
                    break;
                case 66575:
                    if (str.equals("CDP")) {
                        c = 3;
                        break;
                    }
                    break;
                case 191796002:
                    if (str.equals("VOUCHER_DETAIL")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1411860198:
                    if (str.equals("DEEPLINK")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1469380567:
                    if (str.equals(RedirectType.OCR_RECEIPT)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1544398073:
                    if (str.equals("ipgRegistration")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (!TextUtils.isEmpty(notificationData.DatabaseTableConfigUtil) && notificationData.DatabaseTableConfigUtil.contains(DanaUrl.KYB) && notificationData.DatabaseTableConfigUtil.contains("directTo=native")) {
                        return new KybNativeNotificationDirector(context, notificationData);
                    }
                    return new SpinTheWheelNotificationDirector(context, notificationData);
                case 1:
                    return new TwilioChallengeDirector(context, notificationData);
                case 2:
                    return new SendMoneyNotificationDirector(context, notificationData);
                case 3:
                    return new InboxNotificationDirector(context, notificationData);
                case 4:
                    return new VoucherNotificationDirector(context, notificationData, this.BuiltInFictitiousFunctionClassFactory);
                case 5:
                    if (!TextUtils.isEmpty(notificationData.DatabaseTableConfigUtil) && notificationData.DatabaseTableConfigUtil.contains(DanaUrl.PUSH_VERIFY)) {
                        return new PushVerifyNotificationDirector(context, notificationData);
                    }
                    return new DeeplinkNotificationDirector(context, notificationData);
                case 6:
                    return new PersistentNotificationDirector(context, notificationData);
                case 7:
                    if (notificationData.MyBillsEntityDataFactory()) {
                        return new LazadaNotificationDirector(context, notificationData);
                    }
                    return new GlobalNotificationDirector(context, notificationData);
                default:
                    return new GlobalNotificationDirector(context, notificationData);
            }
        }
        return null;
    }
}
