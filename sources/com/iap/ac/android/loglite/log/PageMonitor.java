package com.iap.ac.android.loglite.log;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.log.spm.SpmTrackIntegrator;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import com.iap.ac.android.loglite.utils.LoggingUtil;
import com.iap.ac.android.loglite.utils.PageUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class PageMonitor {
    public static PageMonitor c;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, PageInfo> f7594a = new HashMap();
    public PageInfo b;

    public static PageMonitor a() {
        if (c == null) {
            c = new PageMonitor();
        }
        return c;
    }

    public void a(Object obj) {
        if (obj != null) {
            String a2 = PageUtil.a(obj);
            if (this.f7594a.get(a2) != null) {
                this.f7594a.remove(a2);
            }
        }
    }

    public void a(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            String a2 = PageUtil.a(obj);
            PageInfo pageInfo = this.f7594a.get(a2);
            if (pageInfo != null && !pageInfo.isEnd()) {
                LoggerWrapper.i("PageMonitor", "Start_not call end,and start twice,update spm");
                if (TextUtils.isEmpty(str)) {
                    LoggerWrapper.i("PageMonitor", "updateLastInfoSpm spm or lastInfo is null");
                    return;
                } else {
                    pageInfo.setSpm(str);
                    return;
                }
            }
            PageInfo pageInfo2 = this.f7594a.get(a2);
            if (pageInfo2 == null) {
                pageInfo2 = new PageInfo();
                PageInfo pageInfo3 = this.b;
                if (pageInfo3 != null) {
                    pageInfo2.setReferPageInfo(PageInfo.clonePageInfo(pageInfo3));
                }
            }
            PageInfo pageInfo4 = pageInfo2;
            pageInfo4.setEnd(false);
            pageInfo4.setPageStartTime10(LoggingUtil.getServerTime());
            long pageStartTime10 = pageInfo4.getPageStartTime10();
            int pow = (int) Math.pow(2.0d, 6.0d);
            char[] cArr = new char[pow];
            int i = pow;
            do {
                i--;
                cArr[i] = PageUtil.f7604a[(int) (63 & pageStartTime10)];
                pageStartTime10 >>>= 6;
            } while (pageStartTime10 != 0);
            pageInfo4.setPageStartTime64(new String(cArr, i, pow - i));
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(SpmTrackIntegrator.SEPARATOR_CHAR);
            sb.append(pageInfo4.getPageStartTime64());
            sb.append("_");
            pageInfo4.setPageId(sb.toString());
            pageInfo4.setSpm(str);
            this.f7594a.put(a2, pageInfo4);
            this.b = pageInfo4;
            return;
        }
        LoggerWrapper.i("PageMonitor", "Start_view is null or spm is null");
    }

    public final void a(Object obj, String str, String str2, String str3, Map<String, String> map) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            PageInfo pageInfo = this.f7594a.get(PageUtil.a(obj));
            if (pageInfo == null) {
                LoggerWrapper.i("PageMonitor", "End_pageInfo is null");
                return;
            } else if (pageInfo.isEnd()) {
                LoggerWrapper.i("PageMonitor", "is already call pageEnd");
                return;
            } else {
                pageInfo.setEnd(true);
                PageLog pageLog = new PageLog(str, map);
                pageLog.i = pageInfo.getRefer();
                pageLog.h = LoggingUtil.getServerTime() - pageInfo.getPageStartTime10();
                pageLog.j = pageInfo.getPageId();
                pageLog.k = pageInfo.getPageStartTime64();
                if (!TextUtils.isEmpty(str3)) {
                    pageLog.e = str3;
                }
                if (!TextUtils.isEmpty(str2)) {
                    pageLog.c = str2;
                }
                AnalyticsContext.getInstance().getStorageManager().a(pageLog, str3);
                return;
            }
        }
        LoggerWrapper.i("PageMonitor", "End_View is null or spm is null");
    }
}
