package com.iap.ac.android.diagnoselog.core;

import android.content.Context;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.diagnoselog.api.OnLogUploadListener;
import com.iap.ac.android.diagnoselog.rpc.DlTaskStatus;
import com.iap.ac.android.diagnoselog.rpc.UpdateTaskStatusReq;
import com.iap.ac.android.diagnoselog.upload.IDiagnoseUploader;
import com.iap.ac.android.diagnoselog.upload.OSSUploader;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import id.dana.data.constant.BranchLinkConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UserDiagnosing {

    /* renamed from: a  reason: collision with root package name */
    public final OnLogUploadListener f7570a;
    public ThreadPoolExecutor b;
    public IDiagnoseUploader c;
    public SimpleDateFormat d;
    public Context e;

    /* loaded from: classes3.dex */
    public static class DiagnoseTask {
        public long b;
        public long c;
        public JSONObject e;

        /* renamed from: a  reason: collision with root package name */
        public String f7571a = "";
        public String d = "";
    }

    /* loaded from: classes3.dex */
    public interface UploadStatusChangeListener {
    }

    /* loaded from: classes3.dex */
    public class a implements UploadStatusChangeListener {
        public a() {
        }

        public void a(String str, String str2, String str3) {
            UserDiagnosing userDiagnosing = UserDiagnosing.this;
            userDiagnosing.b.execute(new b(str, str2, str3));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7573a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(String str, String str2, String str3) {
            this.f7573a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("before update -> ");
            sb.append(this.f7573a);
            sb.append(",status = ");
            sb.append(this.b);
            sb.append(",message = ");
            sb.append(this.c);
            LoggerWrapper.i("UserDiagnosing", sb.toString());
            String str = this.f7573a;
            String str2 = this.b;
            String str3 = this.c;
            try {
                DlTaskStatus dlTaskStatus = (DlTaskStatus) RPCProxyHost.getInstance(DiagnoseLogContext.b().h).getInterfaceProxy(DlTaskStatus.class);
                if (dlTaskStatus != null) {
                    UpdateTaskStatusReq updateTaskStatusReq = new UpdateTaskStatusReq();
                    updateTaskStatusReq.setTaskId(str);
                    updateTaskStatusReq.setTaskStatus(str2);
                    updateTaskStatusReq.setTaskStatusMessage(str3);
                    if (dlTaskStatus.updateTaskStatus(updateTaskStatusReq).isSuccess().booleanValue()) {
                        LoggerWrapper.i("UserDiagnosing", "updateTaskStatus success");
                    }
                }
            } catch (Exception e) {
                LoggerWrapper.w("UserDiagnosing", e);
            }
        }
    }

    public UserDiagnosing(Context context, ThreadPoolExecutor threadPoolExecutor, OnLogUploadListener onLogUploadListener) {
        new DecimalFormat("#0.00");
        this.d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        this.e = context;
        this.f7570a = onLogUploadListener;
        new SimpleDateFormat("yyyyMMddHH", Locale.getDefault());
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue(8), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.b = threadPoolExecutor2;
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        this.c = new OSSUploader(this.b, new a(), onLogUploadListener);
    }

    public static boolean a(List<File> list, File file, StringBuilder sb) {
        boolean z;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
            RandomAccessFile randomAccessFile = null;
            for (int i = 0; i < list.size(); i++) {
                randomAccessFile = new RandomAccessFile(list.get(i), BranchLinkConstant.PayloadKey.REFERRAL);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = randomAccessFile.read(bArr);
                    if (read != -1) {
                        gZIPOutputStream.write(bArr, 0, read);
                    }
                }
            }
            randomAccessFile.close();
            gZIPOutputStream.close();
            fileOutputStream.close();
            z = true;
        } catch (Exception e) {
            LoggerWrapper.w("FileUtil", e);
            z = false;
        }
        if (file.length() > 20971520) {
            sb.append("zipped file is ");
            sb.append((((float) file.length()) / 1024.0f) / 1024.0f);
            sb.append("MB,that is too large");
            return false;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.diagnoselog.core.UserDiagnosing.a(java.lang.String):void");
    }

    public final void a(String str, String str2, String str3) {
        this.b.execute(new b(str, str2, str3));
    }
}
