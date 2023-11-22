package id.dana.data.otp;

import id.dana.data.otp.repository.source.network.result.SendOtpResult;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class OtpRetryManager {
    private String phoneNumber;
    private long retryTimestamp;
    private SendOtpResult sendOtpResult;

    @Inject
    public OtpRetryManager() {
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public SendOtpResult getSendOtpResult() {
        if (this.sendOtpResult != null && isNotOverRetry()) {
            this.sendOtpResult.retrySendSeconds = (int) TimeUnit.MILLISECONDS.toSeconds(this.retryTimestamp - System.currentTimeMillis());
        }
        return this.sendOtpResult;
    }

    public void setSendOtpResult(SendOtpResult sendOtpResult) {
        this.retryTimestamp = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(sendOtpResult.retrySendSeconds);
        this.sendOtpResult = sendOtpResult;
    }

    public boolean isNotOverRetry() {
        return this.retryTimestamp >= System.currentTimeMillis();
    }

    public void clear() {
        this.phoneNumber = null;
        this.sendOtpResult = null;
        this.retryTimestamp = -1L;
    }
}
