package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public class ar implements LoggerInterface {
    private static volatile ar MyBillsEntityDataFactory;
    private Context PlaceComponentResult;
    private String getErrorConfigVersion;
    private Handler lookAheadTest;
    private String moveToNextValue = "";
    private static final SimpleDateFormat KClassImpl$Data$declaredNonStaticMembers$2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
    public static String BuiltInFictitiousFunctionClassFactory = "/MiPushLog";
    private static List<Pair<String, Throwable>> getAuthRequestContext = Collections.synchronizedList(new ArrayList());

    private ar(Context context) {
        this.PlaceComponentResult = context;
        if (context.getApplicationContext() != null) {
            this.PlaceComponentResult = context.getApplicationContext();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.PlaceComponentResult.getPackageName());
        sb.append("-");
        sb.append(Process.myPid());
        this.getErrorConfigVersion = sb.toString();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.lookAheadTest = new Handler(handlerThread.getLooper());
    }

    public static ar BuiltInFictitiousFunctionClassFactory(Context context) {
        if (MyBillsEntityDataFactory == null) {
            synchronized (ar.class) {
                if (MyBillsEntityDataFactory == null) {
                    MyBillsEntityDataFactory = new ar(context);
                }
            }
        }
        return MyBillsEntityDataFactory;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void PlaceComponentResult(String str, Throwable th) {
        this.lookAheadTest.post(new as(this, str, th));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void MyBillsEntityDataFactory(ar arVar) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        File externalFilesDir;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (TextUtils.isEmpty(arVar.moveToNextValue) && (externalFilesDir = arVar.PlaceComponentResult.getExternalFilesDir(null)) != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(externalFilesDir.getAbsolutePath());
                    arVar.moveToNextValue = sb.toString();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(arVar.moveToNextValue);
                sb2.append(BuiltInFictitiousFunctionClassFactory);
                File file = new File(sb2.toString());
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                    InstrumentInjector.log_w(arVar.getErrorConfigVersion, "Create mipushlog directory fail.");
                    return;
                }
                File file2 = new File(file, "log.lock");
                if (!file2.exists() || file2.isDirectory()) {
                    file2.createNewFile();
                }
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        try {
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                            while (!getAuthRequestContext.isEmpty()) {
                                try {
                                    Pair<String, Throwable> remove = getAuthRequestContext.remove(0);
                                    String str = (String) remove.first;
                                    if (remove.second != null) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append(str);
                                        sb3.append("\n");
                                        String obj = sb3.toString();
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append(obj);
                                        sb4.append(Log.getStackTraceString((Throwable) remove.second));
                                        str = sb4.toString();
                                    }
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(str);
                                    sb5.append("\n");
                                    bufferedWriter2.write(sb5.toString());
                                } catch (Exception e) {
                                    e = e;
                                    bufferedWriter = bufferedWriter2;
                                    InstrumentInjector.log_e(arVar.getErrorConfigVersion, "", e);
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e2) {
                                            InstrumentInjector.log_e(arVar.getErrorConfigVersion, "", e2);
                                        }
                                    }
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e3) {
                                            InstrumentInjector.log_e(arVar.getErrorConfigVersion, "", e3);
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        randomAccessFile.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedWriter = bufferedWriter2;
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e4) {
                                            InstrumentInjector.log_e(arVar.getErrorConfigVersion, "", e4);
                                        }
                                    }
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e5) {
                                            InstrumentInjector.log_e(arVar.getErrorConfigVersion, "", e5);
                                        }
                                    }
                                    if (randomAccessFile == null) {
                                        throw th;
                                    }
                                    try {
                                        randomAccessFile.close();
                                        throw th;
                                    } catch (IOException e6) {
                                        InstrumentInjector.log_e(arVar.getErrorConfigVersion, "", e6);
                                        throw th;
                                    }
                                }
                            }
                            bufferedWriter2.flush();
                            bufferedWriter2.close();
                            File file3 = new File(file, "log1.txt");
                            if (file3.length() >= ConvertUtils.MB) {
                                File file4 = new File(file, "log0.txt");
                                if (file4.exists() && file4.isFile()) {
                                    file4.delete();
                                }
                                file3.renameTo(file4);
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e7) {
                                    InstrumentInjector.log_e(arVar.getErrorConfigVersion, "", e7);
                                }
                            }
                            randomAccessFile.close();
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile = randomAccessFile;
                            bufferedWriter = bufferedWriter;
                        }
                    } catch (Exception e8) {
                        e = e8;
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileLock = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock = null;
                }
            } catch (Exception e10) {
                e = e10;
                fileLock = null;
                randomAccessFile = null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
                randomAccessFile = null;
            }
        } catch (IOException e11) {
            InstrumentInjector.log_e(arVar.getErrorConfigVersion, "", e11);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        this.lookAheadTest.post(new as(this, str, null));
    }
}
