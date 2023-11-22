package id.dana.tracker.model;

import android.content.Context;
import android.text.TextUtils;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.confirmation.ConfirmationType;
import id.dana.sendmoney.model.ConfirmationModel;
import id.dana.sendmoney.model.ShareActivityModel;
import id.dana.tracker.EventTrackerModel;
import java.io.Serializable;

/* loaded from: classes9.dex */
public class TrackSendMoneyModel implements Serializable {
    private String claimLinkExpiry;
    private String danaBalanceRecipientType;
    private boolean hasComment;
    private boolean isFavorite;
    private String kycLevel;
    private int paidAmount;
    private String recipientDestinationType;
    private String recipientSource;
    private String recipientUserId;
    private int sendMoneyAmount;
    private int senderContactCount;
    private String senderPaymentMethod;
    private boolean shareToFeed;
    private String source;
    private int totalFreeTransfer;

    public TrackSendMoneyModel(ConfirmationModel confirmationModel) {
        this.source = confirmationModel.C();
        this.senderPaymentMethod = confirmationModel.readMicros();
        this.recipientDestinationType = confirmationModel.PrepareContext();
        this.recipientUserId = confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda5();
        this.senderContactCount = confirmationModel.B();
        this.recipientSource = getDashIfEmpty(confirmationModel.getSupportButtonTintMode());
        this.sendMoneyAmount = confirmationModel.moveToNextValue();
        this.hasComment = confirmationModel.F();
        this.kycLevel = reformatKycLevel(confirmationModel.FragmentBottomSheetPaymentSettingBinding());
        this.claimLinkExpiry = getDashIfEmpty(confirmationModel.newProxyInstance());
        this.totalFreeTransfer = confirmationModel.D();
        this.paidAmount = confirmationModel.SubSequence();
        this.danaBalanceRecipientType = confirmationModel.H() ? TrackerKey.DanaBalanceRecipientTypeProperty.DANA : TrackerKey.DanaBalanceRecipientTypeProperty.PHONE;
        this.shareToFeed = getShareToFeed(confirmationModel.A()).booleanValue();
        this.isFavorite = confirmationModel.I();
    }

    private String getDashIfEmpty(String str) {
        if (str == null) {
            str = "";
        }
        return TextUtils.isEmpty(str.trim()) ? "-" : str;
    }

    private String reformatKycLevel(String str) {
        if (str.contains("KYC") || TextUtils.isEmpty(str)) {
            return str;
        }
        char charAt = str.charAt(str.length() - 1);
        StringBuilder sb = new StringBuilder();
        sb.append("KYC");
        sb.append(charAt);
        return sb.toString();
    }

    private boolean isSendToContact() {
        return this.recipientDestinationType.equals(ConfirmationType.Destination.CONTACT);
    }

    public EventTrackerModel getSendMoneyCreateEvent(Context context) {
        EventTrackerModel.Builder sendMoneyProperties = getSendMoneyProperties(TrackerKey.Event.SEND_MONEY_CREATE, context, false);
        sendMoneyProperties.PlaceComponentResult();
        return new EventTrackerModel(sendMoneyProperties, (byte) 0);
    }

    public EventTrackerModel getSendMoneyConfirmEvent(Context context, boolean z) {
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = getSendMoneyProperties("Send Money Confirm", context, z).MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.PAID_AMOUNT, getPaidAmount(z)).PlaceComponentResult(TrackerKey.SendMoneyProperties.NUMBER_OF_FREE_TRANSFER, this.totalFreeTransfer).BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.IS_FAVORITE, this.isFavorite);
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        return new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0);
    }

    private EventTrackerModel.Builder getSendMoneyProperties(String str, Context context, boolean z) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(context);
        builder.MyBillsEntityDataFactory = str;
        return builder.MyBillsEntityDataFactory("Source", this.source).MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.SENDER_PAYMENT_METHOD, getSenderPaymentMethod(z)).MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, getRecipientDestinationType()).MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.P2P_RECIPIENT_TYPE, getDanaBalanceRecipientType()).MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_USER_ID, getRecipientUserId()).PlaceComponentResult(TrackerKey.SendMoneyProperties.SENDER_CONTACT_COUNT, this.senderContactCount).MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_SOURCE, this.recipientSource).PlaceComponentResult(TrackerKey.SendMoneyProperties.SEND_MONEY_AMOUNT, this.sendMoneyAmount).BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.HAS_COMMENT, this.hasComment).BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.SHARE_TO_FEED, this.shareToFeed).MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.SEND_MONEY_CLAIM_LINK_EXPIRY, this.claimLinkExpiry).MyBillsEntityDataFactory("KYC Level", this.kycLevel);
    }

    private String getSenderPaymentMethod(boolean z) {
        if (z) {
            return null;
        }
        return this.senderPaymentMethod;
    }

    private String getPaidAmount(boolean z) {
        if (z) {
            return null;
        }
        return this.senderPaymentMethod;
    }

    private String getRecipientUserId() {
        return isSendToContact() ? this.recipientUserId : "-";
    }

    private String getDanaBalanceRecipientType() {
        return isSendToContact() ? this.danaBalanceRecipientType : "Other";
    }

    private String getRecipientDestinationType() {
        return this.recipientDestinationType.equalsIgnoreCase(ConfirmationType.Destination.CONTACT) ? "DANA Balance" : this.recipientDestinationType.equalsIgnoreCase(ConfirmationType.Destination.OTC) ? "CASH" : this.recipientDestinationType.replace("destination_", "").toUpperCase();
    }

    private Boolean getShareToFeed(ShareActivityModel shareActivityModel) {
        if (shareActivityModel != null) {
            return Boolean.valueOf(shareActivityModel.getKClassImpl$Data$declaredNonStaticMembers$2());
        }
        return Boolean.FALSE;
    }
}
