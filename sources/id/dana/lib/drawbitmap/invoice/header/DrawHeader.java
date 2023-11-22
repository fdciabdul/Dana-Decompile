package id.dana.lib.drawbitmap.invoice.header;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import id.dana.lib.drawbitmap.R;
import id.dana.lib.drawbitmap.invoice.BaseInvoiceView;
import id.dana.lib.drawbitmap.invoice.model.HeaderEntity;
import id.dana.lib.drawbitmap.style.Brush;
import id.dana.lib.drawbitmap.style.typeface.TypeFaceVariant;

/* loaded from: classes5.dex */
public class DrawHeader implements BaseInvoiceView {
    private Brush brush;
    private Canvas canvas;
    private Context context;
    private int firstY;
    private HeaderEntity headerEntity;
    private int lastY;
    private Paint paint = new Paint();

    public DrawHeader(Context context, HeaderEntity headerEntity) {
        this.context = context;
        this.headerEntity = headerEntity;
    }

    public void constructHeader() {
        drawIcon();
        drawAmount();
        drawDescription();
        drawTimestamp();
    }

    private void drawIcon() {
        this.canvas.drawBitmap(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.success), (Rect) null, new Rect(331, this.firstY, 419, WheelView.DIVIDER_ALPHA), this.paint);
    }

    private void drawAmount() {
        this.brush.text(this.headerEntity.getAmount(), 375.0f, 274.0f, TypeFaceVariant.TITLE_22_HIGHLIGHT, Paint.Align.CENTER);
    }

    private void drawDescription() {
        this.brush.text(this.headerEntity.getDesc(), 375.0f, 320.0f, TypeFaceVariant.BODY_14_NORMAL, Paint.Align.CENTER);
    }

    private void drawTimestamp() {
        Brush brush = this.brush;
        StringBuilder sb = new StringBuilder();
        sb.append(this.headerEntity.getDate());
        sb.append(" • ");
        sb.append(this.headerEntity.getTime());
        brush.text(sb.toString(), 375.0f, 364.0f, TypeFaceVariant.CAPTION_12_SECONDARY, Paint.Align.CENTER);
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public int getLastY() {
        return this.lastY;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setFirstY(int i) {
        this.firstY = i;
        calculateHeight(i);
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void calculateHeight(int i) {
        this.lastY = 388;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.brush = new Brush(this.context, canvas);
    }
}
