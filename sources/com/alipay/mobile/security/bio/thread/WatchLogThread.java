package com.alipay.mobile.security.bio.thread;

import android.content.Context;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import com.alipay.mobile.security.bio.service.BioSysBehavior;
import com.alipay.mobile.security.bio.service.BioSysBehaviorType;
import com.alipay.mobile.security.bio.utils.DateUtil;
import com.alipay.mobile.security.bio.utils.FileUtil;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class WatchLogThread extends WatchThread {
    private static final int SIZE = 30;
    private File mApiFile;
    private File mClickFile;
    private Context mContext;
    private File mEventFile;
    private File mLogDir;
    private File mMethodFile;
    private File mNetFile;
    private BlockingQueue<BioSysBehavior> mSysBehaviorCache;

    public WatchLogThread(Context context, String str) {
        super(str);
        this.mSysBehaviorCache = new LinkedBlockingQueue(30);
        this.mLogDir = null;
        this.mApiFile = null;
        this.mMethodFile = null;
        this.mClickFile = null;
        this.mNetFile = null;
        this.mEventFile = null;
        this.mContext = null;
        if (context == null) {
            throw new BioIllegalArgumentException();
        }
        this.mContext = context;
        this.mLogDir = context.getDir("BIO_LOGS", 0);
        String dateFormat = DateUtil.getDateFormat(System.currentTimeMillis());
        File file = this.mLogDir;
        StringBuilder sb = new StringBuilder();
        sb.append("BIO_API_");
        sb.append(dateFormat);
        sb.append(".txt");
        this.mApiFile = new File(file, sb.toString());
        File file2 = this.mLogDir;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("BIO_METHOD_");
        sb2.append(dateFormat);
        sb2.append(".txt");
        this.mMethodFile = new File(file2, sb2.toString());
        File file3 = this.mLogDir;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("BIO_CLICK_");
        sb3.append(dateFormat);
        sb3.append(".txt");
        this.mClickFile = new File(file3, sb3.toString());
        File file4 = this.mLogDir;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("BIO_NET_");
        sb4.append(dateFormat);
        sb4.append(".txt");
        this.mNetFile = new File(file4, sb4.toString());
        File file5 = this.mLogDir;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("BIO_EVENT_");
        sb5.append(dateFormat);
        sb5.append(".txt");
        this.mEventFile = new File(file5, sb5.toString());
    }

    public WatchLogThread(String str) {
        super(str);
        this.mSysBehaviorCache = new LinkedBlockingQueue(30);
        this.mLogDir = null;
        this.mApiFile = null;
        this.mMethodFile = null;
        this.mClickFile = null;
        this.mNetFile = null;
        this.mEventFile = null;
        this.mContext = null;
    }

    @Override // com.alipay.mobile.security.bio.thread.WatchThread
    protected void task() {
        try {
            writeContext(this.mSysBehaviorCache.poll(50L, TimeUnit.SECONDS));
        } catch (InterruptedException unused) {
        }
    }

    public void addThreadItem(BioSysBehavior bioSysBehavior) {
        try {
            this.mSysBehaviorCache.add(bioSysBehavior);
        } catch (Throwable unused) {
        }
    }

    private void writeContext(BioSysBehavior bioSysBehavior) {
        if (bioSysBehavior == null) {
            return;
        }
        HashMap<String, String> ext = bioSysBehavior.getExt();
        StringBuilder sb = new StringBuilder();
        if (!ext.isEmpty()) {
            for (String str : ext.keySet()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[key:");
                sb2.append(str);
                sb2.append(", value:");
                sb2.append(ext.get(str));
                sb2.append("]");
                sb.append(sb2.toString());
            }
        }
        BioSysBehaviorType type = bioSysBehavior.getType();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(bioSysBehavior.getMsg());
        sb3.append(sb.toString());
        writeContext(type, sb3.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.mobile.security.bio.thread.WatchLogThread$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alipay$mobile$security$bio$service$BioSysBehaviorType;

        static {
            int[] iArr = new int[BioSysBehaviorType.values().length];
            $SwitchMap$com$alipay$mobile$security$bio$service$BioSysBehaviorType = iArr;
            try {
                iArr[BioSysBehaviorType.API.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alipay$mobile$security$bio$service$BioSysBehaviorType[BioSysBehaviorType.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alipay$mobile$security$bio$service$BioSysBehaviorType[BioSysBehaviorType.NET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alipay$mobile$security$bio$service$BioSysBehaviorType[BioSysBehaviorType.EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alipay$mobile$security$bio$service$BioSysBehaviorType[BioSysBehaviorType.METHOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void writeContext(BioSysBehaviorType bioSysBehaviorType, String str) {
        int i = AnonymousClass1.$SwitchMap$com$alipay$mobile$security$bio$service$BioSysBehaviorType[bioSysBehaviorType.ordinal()];
        if (i == 1) {
            FileUtil.saveContent(this.mApiFile, str, true);
        } else if (i == 2) {
            FileUtil.saveContent(this.mClickFile, str, true);
        } else if (i == 3) {
            FileUtil.saveContent(this.mNetFile, str, true);
        } else if (i == 4) {
            FileUtil.saveContent(this.mEventFile, str, true);
        } else if (i == 5) {
            FileUtil.saveContent(this.mMethodFile, str, true);
        }
    }
}
