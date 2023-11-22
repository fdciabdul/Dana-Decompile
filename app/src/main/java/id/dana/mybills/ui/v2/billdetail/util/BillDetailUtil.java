package id.dana.mybills.ui.v2.billdetail.util;

import android.content.Context;
import id.dana.mybills.R;
import id.dana.mybills.ui.constant.BizProductCode;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/mybills/ui/v2/billdetail/util/BillDetailUtil;", "", "Landroid/content/Context;", "p0", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "p1", "", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/mybills/ui/model/BillPaymentStatusModel;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class BillDetailUtil {
    public static final BillDetailUtil INSTANCE = new BillDetailUtil();

    private BillDetailUtil() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getAuthRequestContext(Context p0, BillPaymentStatusModel p1) {
        int i;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String goodsType = p1.getGoodsType();
        if (goodsType != null) {
            switch (goodsType.hashCode()) {
                case -1557196247:
                    if (goodsType.equals(BizProductCode.DIGITAL_TV)) {
                        i = R.string.mybills_title_internet_cable_tv;
                        break;
                    }
                    break;
                case -1435322694:
                    if (goodsType.equals("INSURANCE")) {
                        i = R.string.mybills_title_insurance;
                        break;
                    }
                    break;
                case -1183873455:
                    if (goodsType.equals("ELECTRICITY")) {
                        i = R.string.mybills_title_electricity;
                        break;
                    }
                    break;
                case -932963067:
                    if (goodsType.equals("PULSA_PREPAID")) {
                        i = R.string.mybills_title_mobile_recharge;
                        break;
                    }
                    break;
                case -691577239:
                    if (goodsType.equals("MOBILE_POSTPAID")) {
                        i = R.string.mybills_title_mobile_postpaid;
                        break;
                    }
                    break;
                case 79159:
                    if (goodsType.equals("PGN")) {
                        i = R.string.mybills_title_gas;
                        break;
                    }
                    break;
                case 2045463:
                    if (goodsType.equals("BPJS")) {
                        i = R.string.res_0x7f130f5e_summaryvoucherview_externalsyntheticlambda1;
                        break;
                    }
                    break;
                case 2263385:
                    if (goodsType.equals("INSTALLMENT")) {
                        i = R.string.mybills_title_installment;
                        break;
                    }
                    break;
                case 76105038:
                    if (goodsType.equals("PHONE")) {
                        i = R.string.my_bills_label_service_telkom;
                        break;
                    }
                    break;
                case 82365687:
                    if (goodsType.equals("WATER")) {
                        i = R.string.mybills_title_water;
                        break;
                    }
                    break;
                case 216862158:
                    if (goodsType.equals("ELECTRICITY_POST")) {
                        i = R.string.mybills_title_electricity;
                        break;
                    }
                    break;
                case 1046672193:
                    if (goodsType.equals("GAME_VOUCHER")) {
                        i = R.string.my_bills_label_service_digital_voucher;
                        break;
                    }
                    break;
                case 1353037633:
                    if (goodsType.equals("INTERNET")) {
                        i = R.string.mybills_title_internet_cable_tv;
                        break;
                    }
                    break;
            }
            String string = p0.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }
        i = R.string.mybills_title_default;
        String string2 = p0.getString(i);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return string2;
    }
}
