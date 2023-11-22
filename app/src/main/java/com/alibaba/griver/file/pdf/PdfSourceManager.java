package com.alibaba.griver.file.pdf;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class PdfSourceManager {

    /* renamed from: a  reason: collision with root package name */
    private static PdfSourceManager f6537a;
    private Map<String, PdfImageSource> b = new HashMap();

    private PdfSourceManager() {
    }

    public static PdfSourceManager getInstance() {
        PdfSourceManager pdfSourceManager;
        synchronized (PdfSourceManager.class) {
            if (f6537a == null) {
                f6537a = new PdfSourceManager();
            }
            pdfSourceManager = f6537a;
        }
        return pdfSourceManager;
    }

    public PdfImageSource getOrCreate(String str, int i, int i2) {
        PdfImageSource pdfImageSource;
        synchronized (this) {
            if (!this.b.containsKey(str)) {
                PdfImageSource pdfImageSource2 = new PdfImageSource();
                pdfImageSource2.open(str, i, i2);
                this.b.put(str, pdfImageSource2);
            }
            pdfImageSource = this.b.get(str);
        }
        return pdfImageSource;
    }

    public void destory(String str) {
        synchronized (this) {
            if (this.b.containsKey(str)) {
                this.b.get(str).close();
                this.b.remove(str);
            }
        }
    }
}
