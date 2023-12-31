package id.dana.data.otp.repository.source.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import io.reactivex.subjects.PublishSubject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class OtpReceiver extends BroadcastReceiver {
    public static final String EXTRA_CONSENT_INTENT = "com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT";
    private static final int LENGTH_DIGITS = 4;
    private static final String PATTERN = "DANA|(\\d+)";
    private static final String SENDER = "DANA";
    public static final int SMS_CONSENT_REQUEST = 1;
    public static PublishSubject<String> publishSubjectOtp = PublishSubject.PlaceComponentResult();
    public static PublishSubject<Bundle> publishSubjectSmsReceived = PublishSubject.PlaceComponentResult();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        Status status;
        String otpNumber;
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction()) && (extras = intent.getExtras()) != null && (status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")) != null && status.getStatusCode() == 0) {
            String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
            if (str != null && (otpNumber = getOtpNumber(str)) != null && otpNumber.length() == 4) {
                publishSubjectOtp.onNext(otpNumber);
            }
            publishSubjectSmsReceived.onNext(extras);
        }
    }

    private String getOtpNumber(String str) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(str);
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (matcher.find()) {
            String group = matcher.group();
            if (group != null) {
                if ("DANA".equals(group)) {
                    z = true;
                } else if (group.length() > sb.length()) {
                    sb.append(group);
                }
            }
        }
        if (z) {
            return sb.toString();
        }
        return null;
    }
}
