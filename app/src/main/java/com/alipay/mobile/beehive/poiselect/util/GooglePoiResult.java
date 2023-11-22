package com.alipay.mobile.beehive.poiselect.util;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class GooglePoiResult implements Serializable {
    private String next_page_token;
    private List<GooglePoiItem> results;
    private String status;

    public String getNext_page_token() {
        return this.next_page_token;
    }

    public void setNext_page_token(String str) {
        this.next_page_token = str;
    }

    public List<GooglePoiItem> getResults() {
        return this.results;
    }

    public void setResults(List<GooglePoiItem> list) {
        this.results = list;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
