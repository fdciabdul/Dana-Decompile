package id.dana.lib.drawbitmap.invoice.pricedetail;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import id.dana.lib.drawbitmap.invoice.BaseInvoiceView;
import id.dana.lib.drawbitmap.invoice.model.PriceDetailEntity;
import id.dana.lib.drawbitmap.style.Brush;
import id.dana.lib.drawbitmap.style.Pallette;
import id.dana.lib.drawbitmap.style.typeface.TypeFaceVariant;
import java.util.List;

/* loaded from: classes5.dex */
public class DrawPriceDetail implements BaseInvoiceView {
    private float bgHeight;
    private Brush brush;
    private Canvas canvas;
    private Context context;
    private int firstY;
    private int lastY;
    private Paint paint = new Paint();
    private List<PriceDetailEntity> priceDetailEntity;

    public DrawPriceDetail(Context context, List<PriceDetailEntity> list) {
        this.priceDetailEntity = list;
        this.context = context;
    }

    public void constructPriceDetail() {
        List<PriceDetailEntity> list = this.priceDetailEntity;
        if (list == null || list.size() <= 0) {
            return;
        }
        drawBackground();
        drawDashedBgBorder();
        drawData();
    }

    private void drawBackground() {
        this.bgHeight = this.firstY;
        for (PriceDetailEntity priceDetailEntity : this.priceDetailEntity) {
            this.bgHeight += 66.0f;
        }
        this.brush.fill(this.paint, Pallette.GREY_10);
        this.canvas.drawRect(32.0f, this.firstY, 718.0f, this.bgHeight, this.paint);
    }

    private void drawDashedBgBorder() {
        this.brush.strokeDash(this.paint, Pallette.GREY_20, 2.0f);
        Path path = new Path();
        path.moveTo(32.0f, this.firstY);
        path.lineTo(718.0f, this.firstY);
        this.canvas.drawPath(path, this.paint);
    }

    private void drawData() {
        float f = this.firstY + 52;
        for (PriceDetailEntity priceDetailEntity : this.priceDetailEntity) {
            float f2 = f;
            this.brush.text(priceDetailEntity.getTitle(), 66.0f, f2, TypeFaceVariant.BODY_14_NORMAL, Paint.Align.LEFT);
            this.brush.text(amountOperator(priceDetailEntity), 688.0f, f2, amountTypeVariant(priceDetailEntity), Paint.Align.RIGHT);
            f += 52.0f;
        }
    }

    private String amountOperator(PriceDetailEntity priceDetailEntity) {
        if ("deduction".equals(priceDetailEntity.getType())) {
            StringBuilder sb = new StringBuilder();
            sb.append("-");
            sb.append(priceDetailEntity.getAmount());
            return sb.toString();
        }
        return priceDetailEntity.getAmount();
    }

    private String amountTypeVariant(PriceDetailEntity priceDetailEntity) {
        return "addition".equals(priceDetailEntity.getType()) ? TypeFaceVariant.TITLE_14_NORMAL : TypeFaceVariant.TITLE_14_HIGHLIGHT;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public int getLastY() {
        return this.lastY;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setFirstY(int i) {
        int i2 = i + 24;
        this.firstY = i2;
        calculateHeight(i2);
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void calculateHeight(int i) {
        this.lastY = i;
        List<PriceDetailEntity> list = this.priceDetailEntity;
        if (list != null) {
            for (PriceDetailEntity priceDetailEntity : list) {
                this.lastY = (int) (this.lastY + 66.0f);
            }
        }
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.brush = new Brush(this.context, canvas);
    }
}
