package com.iap.ac.android.gol.biz;

import android.os.SystemClock;
import com.iap.ac.android.biz.common.callback.IAuthCallback;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.AcBaseResult;
import com.iap.ac.android.biz.common.model.AcCallback;
import com.iap.ac.android.biz.common.model.AuthResult;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;

/* loaded from: classes3.dex */
public class AuthUrlProcessor extends BaseAuthProcessor {
    public AuthUrlProcessor(boolean z) {
        super(z);
    }

    public void handleAuthUrl(final String str, boolean z, AcCallback<AcBaseResult> acCallback) {
        ACLog.i(Constants.TAG, "signContract handleAuthUrl enter");
        this.mNeedCallback = z;
        this.mCallback = acCallback;
        this.mStartTime = SystemClock.elapsedRealtime();
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.gol.biz.AuthUrlProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                ACLog.i(Constants.TAG, "signContract handleAuthUrl enter in thread");
                SPIManager.getInstance().getAuthCode(str, new IAuthCallback() { // from class: com.iap.ac.android.gol.biz.AuthUrlProcessor.1.1
                    @Override // com.iap.ac.android.biz.common.callback.IAuthCallback
                    public void onResult(AuthResult authResult) {
                        if (authResult == null) {
                            authResult = new AuthResult();
                        }
                        AuthUrlProcessor.this.handleAuthResult(authResult);
                    }
                });
            }
        });
    }
}
