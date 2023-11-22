package id.dana.lib.drawbitmap.invoice;

import android.graphics.Canvas;

/* loaded from: classes5.dex */
public interface BaseInvoiceView {
    void calculateHeight(int i);

    int getLastY();

    void setCanvas(Canvas canvas);

    void setFirstY(int i);
}
