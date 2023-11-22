package id.dana.lib.drawbitmap.invoice.summary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.ObjectKey;
import id.dana.lib.drawbitmap.R;
import id.dana.lib.drawbitmap.base.DrawUtil;
import id.dana.lib.drawbitmap.invoice.BaseInvoiceView;
import id.dana.lib.drawbitmap.invoice.model.SummaryEntity;
import id.dana.lib.drawbitmap.style.Brush;
import id.dana.lib.drawbitmap.style.Pallette;
import id.dana.lib.drawbitmap.style.font.FontTypeVariant;
import id.dana.lib.drawbitmap.style.typeface.TypeFaceVariant;
import io.reactivex.ObservableEmitter;

/* loaded from: classes5.dex */
public class DrawSummary implements BaseInvoiceView {
    private int biztextY;
    private int biztypeY;
    private Brush brush;
    private Canvas canvas;
    private Context context;
    private int countY;
    private int dashedLineY;
    private ObservableEmitter<Integer> emitter;
    private int firstY;
    private int lastY;
    private Paint paint = new Paint();
    private float strokeBottom;
    private float strokeRight;
    private float strokeTop;
    private SummaryEntity summaryEntity;
    private int titleLastY;
    private int titleY;

    public DrawSummary(Context context, SummaryEntity summaryEntity) {
        this.context = context;
        this.summaryEntity = summaryEntity;
    }

    public void setEmitter(ObservableEmitter<Integer> observableEmitter) {
        this.emitter = observableEmitter;
    }

    public void constructSummary() {
        drawBizIconWrapper();
        drawTitle();
        drawBizIcon();
        if (this.summaryEntity.getBizType() != null) {
            drawBizTypeBg();
            drawBizTypeText();
        }
        if (this.summaryEntity.getOrderStatus() != null) {
            drawOrderStatusBg();
            drawOrderStatusText();
        }
        drawDashedBorder();
        if (this.summaryEntity.getExtInfo() != null) {
            drawExtInfo();
        }
        drawSideCircle();
    }

    private void drawBizIconWrapper() {
        float f = this.firstY + 104;
        this.brush.stroke(this.paint, Pallette.GREY_20, 2.0f, new CornerPathEffect(8.0f));
        this.canvas.drawRect(64.0f, this.firstY, 168.0f, f, this.paint);
    }

    private void drawTitle() {
        this.titleY = this.firstY + 30;
        this.titleLastY = this.brush.multilineText(this.summaryEntity.getTitle(), 200, this.titleY, 32, TypeFaceVariant.TITLE_14_NORMAL, Paint.Align.LEFT);
    }

    private void drawBizIcon() {
        try {
            int i = this.firstY;
            RequestBuilder<Bitmap> PlaceComponentResult = Glide.KClassImpl$Data$declaredNonStaticMembers$2(this.context).PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            sb.append(this.summaryEntity.getIconUrl());
            sb.append("?test=");
            sb.append(System.currentTimeMillis());
            final int i2 = i + 104;
            PlaceComponentResult.PlaceComponentResult(sb.toString()).MyBillsEntityDataFactory((BaseRequestOptions<?>) new RequestOptions().MyBillsEntityDataFactory(R.drawable.dana_coin).BuiltInFictitiousFunctionClassFactory(R.drawable.dana_coin).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.MyBillsEntityDataFactory).getAuthRequestContext(true).scheduleImpl().KClassImpl$Data$declaredNonStaticMembers$2(new ObjectKey(Long.valueOf(System.currentTimeMillis())))).KClassImpl$Data$declaredNonStaticMembers$2(new RequestListener<Bitmap>() { // from class: id.dana.lib.drawbitmap.invoice.summary.DrawSummary.1
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException glideException, Object obj, Target<Bitmap> target, boolean z) {
                    DrawSummary.this.canvas.drawBitmap(BitmapFactory.decodeResource(DrawSummary.this.context.getResources(), R.drawable.dana_coin), (Rect) null, new Rect(88, DrawSummary.this.firstY + 24, 144, i2 - 24), DrawSummary.this.paint);
                    DrawSummary.this.emitter.onNext(Integer.valueOf(DrawSummary.this.lastY));
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                    DrawSummary.this.canvas.drawBitmap(bitmap, (Rect) null, new Rect(88, DrawSummary.this.firstY + 24, 144, i2 - 24), DrawSummary.this.paint);
                    DrawSummary.this.emitter.onNext(Integer.valueOf(DrawSummary.this.lastY));
                    return false;
                }
            }).KClassImpl$Data$declaredNonStaticMembers$2();
        } catch (Exception unused) {
        }
    }

    private void drawBizTypeBg() {
        this.biztypeY = this.titleLastY + 20;
        this.strokeRight = this.brush.textLenght(this.summaryEntity.getBizType(), TypeFaceVariant.CAPTION_12_SECONDARY) + 200.0f + 48.0f;
        int i = this.biztypeY;
        this.brush.fill(this.paint, Pallette.GREY_10, new CornerPathEffect(4.0f));
        this.canvas.drawRect(200.0f, this.biztypeY, this.strokeRight, i + 48, this.paint);
        int i2 = ((this.titleLastY + 48) + 20) - this.firstY;
        this.countY = i2;
        if (104 > i2) {
            i2 = 104;
        }
        this.dashedLineY = i2;
    }

    private void drawBizTypeText() {
        this.biztextY = this.biztypeY + 32;
        this.brush.text(this.summaryEntity.getBizType(), 224.0f, this.biztextY, TypeFaceVariant.CAPTION_12_SECONDARY);
    }

    private void drawOrderStatusBg() {
        float textLenght = this.brush.textLenght(this.summaryEntity.getOrderStatus().getTitle(), TypeFaceVariant.CAPTION_12_SECONDARY);
        float f = this.strokeRight;
        int i = this.biztypeY;
        this.brush.fill(this.paint, Pallette.GREEN_10, new CornerPathEffect(4.0f));
        this.canvas.drawRect(f + 8.0f, this.biztypeY, f + textLenght + 48.0f, i + 48, this.paint);
    }

    private void drawOrderStatusText() {
        this.brush.text(this.summaryEntity.getOrderStatus().getTitle(), 24.0f + this.strokeRight + 8.0f, this.biztextY, 12, Pallette.GREEN_50, FontTypeVariant.OPEN_SANS_SEMIBOLD);
    }

    private void drawDashedBorder() {
        int i = this.firstY;
        this.strokeBottom = this.dashedLineY + i + 36;
        this.strokeTop = (float) (i - 36);
        this.brush.strokeDash(this.paint, Pallette.GREY_20, 2.0f);
        Path path = new Path();
        path.moveTo(32.0f, this.strokeTop);
        path.lineTo(718.0f, this.strokeTop);
        this.canvas.drawPath(path, this.paint);
        Path path2 = new Path();
        path2.moveTo(32.0f, this.strokeBottom);
        path2.lineTo(718.0f, this.strokeBottom);
        this.canvas.drawPath(path2, this.paint);
    }

    private void drawExtInfo() {
        float f = this.strokeBottom + 50.0f;
        float f2 = 28.0f + f;
        this.brush.text(this.summaryEntity.getExtInfo().getTitle(), 64.0f, f, TypeFaceVariant.TITLE_12_NORMAL);
        this.brush.fill(this.paint, Pallette.YELLOW_10, new CornerPathEffect(8.0f));
        this.canvas.drawRect(64.0f, f2, 686.0f, f2 + 96.0f, this.paint);
        this.brush.text(this.summaryEntity.getExtInfo().getValue(), 88.0f, f2 + 60.0f, TypeFaceVariant.TITLE_16_HIGHLIGHT);
    }

    private void drawSideCircle() {
        int i = this.firstY;
        RectF rectF = new RectF();
        int i2 = i - 36;
        float f = (float) (i2 - 15);
        float f2 = i2 + 15;
        rectF.set(17.0f, f, 45.0f, f2);
        RectF rectF2 = new RectF();
        rectF2.set(705.0f, f, 733.0f, f2);
        this.brush.fill(this.paint, Pallette.BLUE_50, null);
        this.canvas.drawArc(rectF, 270.0f, 180.0f, false, this.paint);
        this.canvas.drawArc(rectF2, 270.0f, -180.0f, false, this.paint);
        this.brush.stroke(this.paint, Pallette.GREY_20, 2.0f, null);
        this.canvas.drawArc(rectF, 270.0f, 180.0f, false, this.paint);
        this.canvas.drawArc(rectF2, 270.0f, -180.0f, false, this.paint);
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public int getLastY() {
        return this.lastY;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setFirstY(int i) {
        int i2 = i + 36;
        this.firstY = i2;
        calculateHeight(i2);
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void calculateHeight(int i) {
        int calculateMultiline = DrawUtil.calculateMultiline(this.summaryEntity.getTitle(), 200, this.titleY, 32);
        this.titleLastY = calculateMultiline;
        int i2 = this.firstY;
        int i3 = ((calculateMultiline + 48) + 20) - i2;
        this.countY = i3;
        if (104 > i3) {
            i3 = 104;
        }
        this.dashedLineY = i3;
        this.lastY = i2 + i3 + 40;
        if (this.summaryEntity.getExtInfo() != null) {
            this.lastY = ((int) (r0 + 50 + 28.0f + 96.0f)) + 40;
        }
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.brush = new Brush(this.context, canvas);
    }
}
