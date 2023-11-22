package com.alibaba.griver.image.capture;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.activity.GriverCaptureActivity;
import com.alibaba.griver.image.activity.GriverVideoPreviewActivity;
import com.alibaba.griver.image.capture.listener.CaptureListener;
import com.alibaba.griver.image.capture.meta.CaptureParam;
import com.alibaba.griver.image.capture.meta.MediaInfo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class CaptureServiceImpl extends CaptureService {
    public static final String EXTRA_KEY_BUSINESS_ID = "businessId";

    /* renamed from: a  reason: collision with root package name */
    private static CaptureSession f6560a;

    public static void setUpCurrentSession(CaptureListener captureListener) {
        synchronized (CaptureServiceImpl.class) {
            CaptureSession captureSession = f6560a;
            if (captureSession != null) {
                if (captureSession.getListener() == captureListener) {
                    RVLogger.w("CaptureServiceImpl", "CaptureListener is same,do nothing.");
                } else {
                    RVLogger.w("CaptureServiceImpl", "Capture job concurrent,cancel the old one!");
                }
            }
            RVLogger.w("CaptureServiceImpl", "Update CaptureSession");
            f6560a = new CaptureSession(captureListener);
        }
    }

    public static void notifyAction(boolean z, MediaInfo mediaInfo, boolean z2) {
        synchronized (CaptureServiceImpl.class) {
            RVLogger.w("CaptureServiceImpl", "notifyAction called");
            CaptureSession captureSession = f6560a;
            if (captureSession != null) {
                captureSession.notifyAction(z, mediaInfo);
                if (z2) {
                    RVLogger.w("CaptureServiceImpl", "Clear session");
                    f6560a = null;
                }
                return;
            }
            RVLogger.w("CaptureServiceImpl", "notifyAction called when captureSession is Null!");
        }
    }

    @Override // com.alibaba.griver.image.capture.CaptureService
    public void capture(App app, CaptureListener captureListener, String str, Bundle bundle) {
        Intent intent;
        if (a(str, captureListener)) {
            setUpCurrentSession(captureListener);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("businessId", str);
            if (bundle.getInt(CaptureParam.CAPTURE_MODE, 2) == 2) {
                intent = new Intent(app.getAppContext().getContext(), GriverCaptureActivity.class);
            } else {
                intent = new Intent(app.getAppContext().getContext(), GriverVideoPreviewActivity.class);
            }
            intent.putExtras(bundle);
            app.getAppContext().getContext().startActivity(intent);
            return;
        }
        RVLogger.d("CaptureServiceImpl", "CaptureService action called,but args is not valid!");
    }

    private boolean a(String str, CaptureListener captureListener) {
        return (TextUtils.isEmpty(str) || captureListener == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CaptureSession {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<CaptureListener> f6561a;
        public List<MediaInfo> mediaInfos = new LinkedList();

        public CaptureSession(CaptureListener captureListener) {
            this.f6561a = new WeakReference<>(captureListener);
        }

        public CaptureListener getListener() {
            return this.f6561a.get();
        }

        public void notifyAction(boolean z, MediaInfo mediaInfo) {
            if (mediaInfo == null) {
                notifyAction(z, null, null);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(mediaInfo);
            notifyAction(z, linkedList, null);
        }

        public void notifyAction(boolean z, List<MediaInfo> list, Map<String, Object> map) {
            CaptureListener captureListener = this.f6561a.get();
            if (captureListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Is canceled : ");
                sb.append(z);
                RVLogger.d("CaptureServiceImpl", sb.toString());
                captureListener.onAction(z, (list == null || list.isEmpty()) ? null : list.get(0));
            }
        }
    }
}
