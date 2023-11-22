package id.dana.cashier;

import id.dana.domain.payasset.model.CardScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/cashier/CardAssetUtils;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/Integer;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardAssetUtils {
    public static final CardAssetUtils INSTANCE = new CardAssetUtils();

    private CardAssetUtils() {
    }

    public static Integer BuiltInFictitiousFunctionClassFactory(String p0) {
        if (p0 != null) {
            switch (p0.hashCode()) {
                case -1934979172:
                    if (p0.equals(CardScheme.VISA)) {
                        return Integer.valueOf((int) id.dana.R.drawable.ic_chip_visa);
                    }
                    break;
                case -1062451836:
                    if (p0.equals(CardScheme.JCB)) {
                        return Integer.valueOf((int) id.dana.R.drawable.ic_chip_jcb);
                    }
                    break;
                case -1003810246:
                    if (p0.equals(CardScheme.AMERICAN_EXPRESS)) {
                        return Integer.valueOf((int) id.dana.R.drawable.ic_chip_american_express);
                    }
                    break;
                case 70789:
                    if (p0.equals(CardScheme.GPN)) {
                        return Integer.valueOf((int) id.dana.R.drawable.ic_chip_gpn);
                    }
                    break;
                case 425933967:
                    if (p0.equals(CardScheme.BCA)) {
                        return Integer.valueOf((int) id.dana.R.drawable.ic_chip_bca);
                    }
                    break;
                case 1067049040:
                    if (p0.equals(CardScheme.MASTERCARD)) {
                        return Integer.valueOf((int) id.dana.R.drawable.ic_chip_mastercard);
                    }
                    break;
            }
        }
        return null;
    }

    public static Integer PlaceComponentResult(String p0) {
        if (Intrinsics.areEqual(p0, "CREDIT_CARD")) {
            return Integer.valueOf((int) id.dana.R.drawable.ic_chip_payment_credit);
        }
        if (Intrinsics.areEqual(p0, "DEBIT_CARD")) {
            return Integer.valueOf((int) id.dana.R.drawable.ic_chip_payment_debit);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        if (r1.equals(id.dana.domain.payasset.model.Institution.BCA_ONEKLIK) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d6, code lost:
    
        if (r1.equals(id.dana.domain.payasset.model.Institution.BCA) != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
    
        return java.lang.Integer.valueOf((int) id.dana.R.drawable.ic_landscape_small_bca);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Integer MyBillsEntityDataFactory(java.lang.String r1) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.CardAssetUtils.MyBillsEntityDataFactory(java.lang.String):java.lang.Integer");
    }
}
