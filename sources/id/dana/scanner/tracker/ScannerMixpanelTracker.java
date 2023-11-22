package id.dana.scanner.tracker;

import android.content.Context;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.model.TrackScanQrModel;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0003\u001a\u00020\u0006X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/scanner/tracker/ScannerMixpanelTracker;", "Lid/dana/scanner/tracker/ScannerAnalyticTracker;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "PlaceComponentResult", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "getAuthRequestContext", "Lkotlin/Lazy;", "p0", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScannerMixpanelTracker implements ScannerAnalyticTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    @Inject
    public ScannerMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.scanner.tracker.ScannerMixpanelTracker$sendMoneyFeatureTime$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SendMoneyFeatureTime invoke() {
                return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
            }
        });
    }

    public static final /* synthetic */ void getAuthRequestContext(ScannerMixpanelTracker scannerMixpanelTracker, TrackScanQrModel trackScanQrModel) {
        String str;
        String str2 = trackScanQrModel.moveToNextValue;
        if (!(str2 == null || str2.length() == 0) || (str = trackScanQrModel.PlaceComponentResult) == null) {
            return;
        }
        switch (str.hashCode()) {
            case -922877266:
                if (!str.equals(DecodeQrBizType.TRANSFER_BANK_ACCOUNT_CODE)) {
                    return;
                }
                break;
            case -724740381:
                if (!str.equals(DecodeQrBizType.PROFILE_CODE)) {
                    return;
                }
                break;
            case -276560242:
                if (!str.equals(DecodeQrBizType.USER_BANK_ACCOUNT_CODE)) {
                    return;
                }
                break;
            case 1131344321:
                if (!str.equals(DecodeQrBizType.TRANSFER_CODE)) {
                    return;
                }
                break;
            default:
                return;
        }
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) scannerMixpanelTracker.BuiltInFictitiousFunctionClassFactory.getValue();
        Intrinsics.checkNotNullParameter(trackScanQrModel, "");
        String str3 = trackScanQrModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str3 == null) {
            str3 = "";
        }
        sendMoneyFeatureTime.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        Long l = trackScanQrModel.getAuthRequestContext;
        long longValue = l != null ? l.longValue() : 0L;
        Intrinsics.checkNotNullParameter("SCANNER READY", "");
        sendMoneyFeatureTime.getAuthRequestContext.put("SCANNER READY", Long.valueOf(longValue));
        Long l2 = trackScanQrModel.initRecordTimeStamp;
        long longValue2 = l2 != null ? l2.longValue() : 0L;
        Intrinsics.checkNotNullParameter("SCAN TIME", "");
        sendMoneyFeatureTime.getAuthRequestContext.put("SCAN TIME", Long.valueOf(longValue2));
        Long l3 = trackScanQrModel.BuiltInFictitiousFunctionClassFactory;
        long longValue3 = l3 != null ? l3.longValue() : 0L;
        Intrinsics.checkNotNullParameter("DECODE TIME", "");
        sendMoneyFeatureTime.getAuthRequestContext.put("DECODE TIME", Long.valueOf(longValue3));
    }
}
