package id.dana.lib.drawbitmap.invoice.wrapper;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.lib.drawbitmap.R;
import id.dana.lib.drawbitmap.invoice.BaseInvoiceView;
import id.dana.lib.drawbitmap.style.Brush;
import id.dana.lib.drawbitmap.style.Pallette;
import id.dana.lib.drawbitmap.style.font.FontTypeVariant;
import id.dana.lib.drawbitmap.style.typeface.TypeFaceVariant;

/* loaded from: classes5.dex */
public class DrawWrapper implements BaseInvoiceView {
    private static final int START_HEADER_Y = 132;
    private Brush brush;
    private Canvas canvas;
    private Context context;
    private int fillBottom;
    private int firstY;
    private int fixedHeight;
    private int lastY;
    private String pageTitle;
    private Paint paintFill = new Paint();
    private Paint paintStroke = new Paint();

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public int getLastY() {
        return START_HEADER_Y;
    }

    public DrawWrapper(Context context, String str) {
        this.context = context;
        this.pageTitle = str;
    }

    public void constructWrapper() {
        drawWrapperBackground();
        drawActiveBackground();
        drawTopHalfCircle();
        drawBottomHalfCircle();
        drawFooter();
    }

    private void drawWrapperBackground() {
        this.paintFill.setColor(Color.parseColor(Pallette.BLUE_50));
        Canvas canvas = this.canvas;
        float f = this.firstY;
        canvas.drawRect(f, f, 750.0f, this.fixedHeight + BlobStatic.MONITOR_IMAGE_WIDTH, this.paintFill);
        this.brush.text(this.pageTitle, 375.0f, 87.0f, 17, Pallette.WHITE, FontTypeVariant.SF_PRO_REGULAR, Paint.Align.CENTER);
    }

    private void drawActiveBackground() {
        int i = this.fixedHeight - 174;
        this.fillBottom = i;
        float f = i;
        CornerPathEffect cornerPathEffect = new CornerPathEffect(10.0f);
        this.brush.fill(this.paintFill, Pallette.WHITE, cornerPathEffect);
        this.brush.stroke(this.paintStroke, Pallette.GREY_20, 2.0f, cornerPathEffect);
        this.canvas.drawRoundRect(new RectF(32.0f, 174.0f, 718.0f, this.fillBottom), 8.0f, 8.0f, this.paintFill);
        this.canvas.drawRect(32.0f, 174.0f, 718.0f, f, this.paintStroke);
    }

    private void drawTopHalfCircle() {
        RectF rectF = new RectF();
        rectF.set(325.0f, 126.0f, 425.0f, 226.0f);
        RectF rectF2 = new RectF();
        rectF2.set(325.0f, 126.0f, 425.0f, 226.0f);
        this.brush.fill(this.paintFill, Pallette.WHITE);
        this.canvas.drawArc(rectF2, 180.0f, 180.0f, false, this.paintFill);
        this.canvas.drawArc(rectF, 180.0f, 180.0f, false, this.paintStroke);
    }

    private void drawBottomHalfCircle() {
        float f = (float) (this.fixedHeight - 174);
        RectF rectF = new RectF();
        float f2 = 60.0f;
        float f3 = 92.0f;
        for (double d = 750.0d; d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE; d = (d - 60.0d) - 8.2d) {
            rectF.set(f2, f - 15.0f, f3, f + 15.0f + 2.0f);
            this.brush.fill(this.paintFill, Pallette.BLUE_50, null);
            this.brush.stroke(this.paintStroke, Pallette.GREY_20, 2.0f, null);
            this.canvas.drawArc(rectF, 180.0f, 180.0f, false, this.paintFill);
            this.canvas.drawArc(rectF, 180.0f, 180.0f, false, this.paintStroke);
            f2 = (f2 + 75.0f) - 15.0f;
            f3 = (f3 + 75.0f) - 15.0f;
        }
    }

    private void drawFooter() {
        int i = this.fillBottom + 60;
        int i2 = i - 22;
        this.brush.text("Powered by ", 315.0f, i, TypeFaceVariant.CAPTION_12_INVERTED, Paint.Align.CENTER);
        this.canvas.drawBitmap(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.white_dana), (Rect) null, new Rect(389, i2, 495, i2 + 32), this.paintFill);
    }

    public void setWrapperHeight(int i) {
        this.fixedHeight = i + BlobStatic.MONITOR_IMAGE_WIDTH;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.brush = new Brush(this.context, canvas);
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setFirstY(int i) {
        this.firstY = i;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void calculateHeight(int i) {
        this.lastY = getLastY();
    }
}
