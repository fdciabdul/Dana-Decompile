package com.iap.ac.android.loglite.log;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes8.dex */
public class PageInfo {
    private boolean isEnd = false;
    private String pageId;
    private long pageStartTime10;
    private String pageStartTime64;
    private long pageStayTime;
    private String refer;
    private PageInfo referPageInfo;
    private String spm;

    public static PageInfo clonePageInfo(PageInfo pageInfo) {
        PageInfo pageInfo2 = new PageInfo();
        pageInfo2.pageStartTime10 = pageInfo.pageStartTime10;
        pageInfo2.pageStartTime64 = pageInfo.pageStartTime64;
        pageInfo2.pageId = pageInfo.pageId;
        pageInfo2.pageStayTime = pageInfo.pageStayTime;
        pageInfo2.spm = pageInfo.spm;
        pageInfo2.refer = pageInfo.refer;
        pageInfo2.isEnd = pageInfo.isEnd;
        pageInfo2.referPageInfo = pageInfo.referPageInfo;
        return pageInfo2;
    }

    public String getPageId() {
        return this.pageId;
    }

    public long getPageStartTime10() {
        return this.pageStartTime10;
    }

    public String getPageStartTime64() {
        return this.pageStartTime64;
    }

    public long getPageStayTime() {
        return this.pageStayTime;
    }

    public String getRefer() {
        if (this.referPageInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.referPageInfo.spm);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(this.referPageInfo.pageId);
            return sb.toString();
        }
        return "first";
    }

    public PageInfo getReferPageInfo() {
        return this.referPageInfo;
    }

    public String getSpm() {
        return this.spm;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void setEnd(boolean z) {
        this.isEnd = z;
    }

    public void setPageId(String str) {
        this.pageId = str;
    }

    public void setPageStartTime10(long j) {
        this.pageStartTime10 = j;
    }

    public void setPageStartTime64(String str) {
        this.pageStartTime64 = str;
    }

    public void setPageStayTime(long j) {
        this.pageStayTime = j;
    }

    public void setRefer(String str) {
        this.refer = str;
    }

    public void setReferPageInfo(PageInfo pageInfo) {
        this.referPageInfo = pageInfo;
    }

    public void setSpm(String str) {
        this.spm = str;
    }
}
