package id.dana.data.globalnetwork;

import id.dana.data.globalnetwork.model.PaymentResult;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class GnPaymentUtil {
    private static long getDifferentDate(Date date, Date date2) {
        return TimeUnit.MINUTES.convert(Math.abs(date.getTime() - date2.getTime()), TimeUnit.MILLISECONDS);
    }

    public static boolean isPaymentExpired(PaymentResult paymentResult) {
        return getDifferentDate(new Date(), paymentResult.getGenerateDate()) > 1;
    }
}
