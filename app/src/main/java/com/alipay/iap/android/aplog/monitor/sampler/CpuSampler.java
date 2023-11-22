package com.alipay.iap.android.aplog.monitor.sampler;

import android.os.Process;
import com.iap.ac.android.common.task.threadpool.ProcessCpuTracker;
import id.dana.cashier.view.InputCardNumberView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class CpuSampler extends AbstractSampler {
    private final int c;
    private final LinkedHashMap<Long, String> d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;

    public CpuSampler(long j) {
        super(j);
        this.d = new LinkedHashMap<>();
        this.e = 0;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.c = (int) (((float) this.b) * 1.2f);
    }

    @Override // com.alipay.iap.android.aplog.monitor.sampler.AbstractSampler
    public void a() {
        super.a();
        e();
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.d) {
            for (Map.Entry<Long, String> entry : this.d.entrySet()) {
                sb.append(this.f6933a.format(Long.valueOf(entry.getKey().longValue())));
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(entry.getValue());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public boolean a(long j, long j2) {
        if (j2 - j > this.b) {
            long j3 = this.b;
            long j4 = this.b;
            synchronized (this.d) {
                Iterator<Map.Entry<Long, String>> it = this.d.entrySet().iterator();
                long j5 = 0;
                while (it.hasNext()) {
                    long longValue = it.next().getKey().longValue();
                    if (j - j3 < longValue && longValue < j + j4) {
                        if (j5 != 0 && longValue - j5 > this.c) {
                            return true;
                        }
                        j5 = longValue;
                    }
                }
                return false;
            }
        }
        return false;
    }

    @Override // com.alipay.iap.android.aplog.monitor.sampler.AbstractSampler
    protected void c() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String readLine;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(new FileInputStream(ProcessCpuTracker.TOTAL_STAT_FILE)), 1000);
                try {
                    readLine = bufferedReader4.readLine();
                    if (readLine == null) {
                        readLine = "";
                    }
                    if (this.e == 0) {
                        this.e = Process.myPid();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("/proc/");
                    sb.append(this.e);
                    sb.append("/stat");
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(sb.toString())), 1000);
                } catch (Throwable unused) {
                }
                try {
                    String readLine2 = bufferedReader2.readLine();
                    a(readLine, readLine2 != null ? readLine2 : "");
                    bufferedReader4.close();
                } catch (Throwable unused2) {
                    bufferedReader3 = bufferedReader2;
                    bufferedReader = bufferedReader3;
                    bufferedReader3 = bufferedReader4;
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    if (bufferedReader == null) {
                        return;
                    }
                    bufferedReader2 = bufferedReader;
                    bufferedReader2.close();
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
            bufferedReader2.close();
        } catch (Throwable unused4) {
        }
    }

    private void e() {
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
    }

    void a(String str, String str2) {
        long j;
        long j2;
        String[] split = str.split(" ");
        if (split.length < 9) {
            return;
        }
        long parseLong = Long.parseLong(split[2]);
        long parseLong2 = Long.parseLong(split[3]);
        long parseLong3 = Long.parseLong(split[4]);
        long parseLong4 = Long.parseLong(split[5]);
        long parseLong5 = Long.parseLong(split[6]);
        long parseLong6 = parseLong2 + parseLong + parseLong3 + parseLong4 + parseLong5 + Long.parseLong(split[7]) + Long.parseLong(split[8]);
        String[] split2 = str2.split(" ");
        if (split2.length < 17) {
            return;
        }
        long parseLong7 = Long.parseLong(split2[13]);
        long parseLong8 = Long.parseLong(split2[14]);
        long parseLong9 = parseLong7 + parseLong8 + Long.parseLong(split2[15]) + Long.parseLong(split2[16]);
        if (this.j != 0) {
            StringBuilder sb = new StringBuilder();
            long j3 = this.h;
            j2 = parseLong5;
            long j4 = parseLong6 - this.j;
            j = parseLong6;
            sb.append("cpu:");
            sb.append(((j4 - (parseLong4 - j3)) * 100) / j4);
            sb.append("% ");
            sb.append("app:");
            sb.append(((parseLong9 - this.k) * 100) / j4);
            sb.append("% ");
            sb.append("[");
            sb.append("user:");
            sb.append(((parseLong - this.f) * 100) / j4);
            sb.append("% ");
            sb.append("system:");
            sb.append(((parseLong3 - this.g) * 100) / j4);
            sb.append("% ");
            sb.append("ioWait:");
            sb.append(((j2 - this.i) * 100) / j4);
            sb.append("% ]");
            synchronized (this.d) {
                this.d.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
                if (this.d.size() > 10) {
                    Iterator<Map.Entry<Long, String>> it = this.d.entrySet().iterator();
                    if (it.hasNext()) {
                        this.d.remove(it.next().getKey());
                    }
                }
            }
        } else {
            j = parseLong6;
            j2 = parseLong5;
        }
        this.f = parseLong;
        this.g = parseLong3;
        this.h = parseLong4;
        this.i = j2;
        this.j = j;
        this.k = parseLong9;
    }
}
