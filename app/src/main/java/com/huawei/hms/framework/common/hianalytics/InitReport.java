package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes7.dex */
public class InitReport {
    private static List<Runnable> MyBillsEntityDataFactory = new CopyOnWriteArrayList();
    private static boolean PlaceComponentResult;

    public static void reportWhenInit(Runnable runnable) {
        if (PlaceComponentResult) {
            try {
                HianalyticsHelper.getInstance().getReportExecutor().execute(runnable);
            } catch (RejectedExecutionException unused) {
                Logger.e("HaReport", "the thread submit has rejectedExecutionException!");
            } catch (Throwable unused2) {
                Logger.e("HaReport", "the thread submit has fatal error!");
            }
        } else if (MyBillsEntityDataFactory.size() > 10) {
            Logger.e("TAG", "the event to be report when init exceed the limit!");
        } else {
            MyBillsEntityDataFactory.add(runnable);
        }
    }

    public static void enableConnectNet() {
        PlaceComponentResult = true;
        try {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new Runnable() { // from class: com.huawei.hms.framework.common.hianalytics.InitReport.1
                @Override // java.lang.Runnable
                public final void run() {
                    InitReport.access$000();
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e("HaReport", "the thread submit has rejectedExecutionException!");
        } catch (Throwable unused2) {
            Logger.e("HaReport", "the thread submit has fatal error!");
        }
    }

    static /* synthetic */ void access$000() {
        try {
            Iterator<Runnable> it = MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                HianalyticsHelper.getInstance().getReportExecutor().submit(it.next());
            }
            MyBillsEntityDataFactory.clear();
        } catch (NullPointerException unused) {
            Logger.e("HaReport", "event is null occured");
        } catch (RejectedExecutionException unused2) {
            Logger.e("HaReport", "submit failed of rejected execution exception");
        } catch (Exception unused3) {
            Logger.e("HaReport", "submit failed because of some exception");
        }
    }
}
