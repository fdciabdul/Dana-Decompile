package id.dana.sendmoney_v2.tracker;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.model.ConfirmationModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0003H&J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H&J\u0014\u0010\u001c\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!H&J\b\u0010\"\u001a\u00020\u0003H&J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0007H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H&J\b\u0010&\u001a\u00020\u0003H&J4\u0010'\u001a\u00020\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010)\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010*\u001a\u00020\u0007H&J)\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010.J\u001a\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u0005H&J\u001c\u00102\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u0005H&J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0015H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00066À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "", "trackRequestMoneyGenerateQr", "", "qrType", "", TrackerKey.Property.IS_SUCCESS, "", "hitTime", "", "isQris", "isDeeplink", "trackRequestMoneyOpen", "source", "trackSendAndWithdrawOpen", "trackSendAndWithdrawSelect", "channelName", "trackSendMoneyAddNewBankOpen", "trackSendMoneyBankAccountNumberInput", "failedReason", "retryCount", "", "trackSendMoneyBankListPageOpen", "trackSendMoneyChatOpen", "trackSendMoneyConfirm", "confirmationModel", "Lid/dana/sendmoney/model/ConfirmationModel;", "isCashierNativeEnable", "trackSendMoneyContactListPageOpen", "frictionType", "trackSendMoneyCreate", TrackerKey.SendMoneyProperties.IS_FAVORITE, "frictionsType", "", "trackSendMoneyHelpOpen", "trackSendMoneyOpen", "isInitFinish", "trackSendMoneyReceiverDataInput", "trackSendMoneySearch", "trackSendMoneySearchSelected", "destinationType", "isFromRecent", "isAddNewBank", "trackSendMoneySelect", "type", "lastTransaction", "(Ljava/lang/String;ZLjava/lang/Boolean;)V", "trackSmartFrictionConfirm", "isContinue", "scenario", "trackSmartFrictionOpen", "recipientDestination", "trackSubmitNameCheckCount", "count", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SendMoneyAnalyticTracker {
    void BuiltInFictitiousFunctionClassFactory();

    void BuiltInFictitiousFunctionClassFactory(String str);

    void BuiltInFictitiousFunctionClassFactory(String str, boolean z);

    void KClassImpl$Data$declaredNonStaticMembers$2();

    void KClassImpl$Data$declaredNonStaticMembers$2(String str);

    void KClassImpl$Data$declaredNonStaticMembers$2(String str, boolean z, Boolean bool);

    void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, String str);

    void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, String str, int i);

    void MyBillsEntityDataFactory();

    void MyBillsEntityDataFactory(ConfirmationModel confirmationModel, boolean z);

    void MyBillsEntityDataFactory(String str, boolean z);

    void MyBillsEntityDataFactory(String str, boolean z, String str2, boolean z2);

    void PlaceComponentResult();

    void PlaceComponentResult(int i);

    void PlaceComponentResult(String str);

    void PlaceComponentResult(String str, String str2);

    void getAuthRequestContext();

    void getAuthRequestContext(String str);

    void getAuthRequestContext(String str, boolean z, long j, boolean z2, boolean z3);

    void getAuthRequestContext(boolean z, String str, List<String> list);

    /* renamed from: id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void MyBillsEntityDataFactory(SendMoneyAnalyticTracker sendMoneyAnalyticTracker, String str, boolean z, String str2, boolean z2, int i) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                z2 = false;
            }
            sendMoneyAnalyticTracker.MyBillsEntityDataFactory(str, z, str2, z2);
        }
    }
}
