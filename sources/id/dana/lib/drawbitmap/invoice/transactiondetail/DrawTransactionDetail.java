package id.dana.lib.drawbitmap.invoice.transactiondetail;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import id.dana.lib.drawbitmap.base.DrawUtil;
import id.dana.lib.drawbitmap.invoice.BaseInvoiceView;
import id.dana.lib.drawbitmap.invoice.model.TransactionDetailEntity;
import id.dana.lib.drawbitmap.style.Brush;
import id.dana.lib.drawbitmap.style.Pallette;
import id.dana.lib.drawbitmap.style.typeface.TypeFaceVariant;
import java.util.List;

/* loaded from: classes5.dex */
public class DrawTransactionDetail implements BaseInvoiceView {
    private static final int MAX_LENGTH = 35;
    private Brush brush;
    private Canvas canvas;
    private Context context;
    private int firstY;
    private int lastY;
    private Paint paint = new Paint();
    private List<TransactionDetailEntity> transactionDetailEntity;
    private int yLastPosition;
    private int yStroke;
    private int yValuePosition;

    public DrawTransactionDetail(Context context, List<TransactionDetailEntity> list) {
        this.context = context;
        this.transactionDetailEntity = list;
    }

    public void constructTransactionDetail() {
        drawData();
        drawWrapperDashedBorder();
    }

    private void drawData() {
        for (TransactionDetailEntity transactionDetailEntity : this.transactionDetailEntity) {
            this.yValuePosition = this.firstY + 48;
            this.brush.text(transactionDetailEntity.getTitle(), 64.0f, this.firstY, TypeFaceVariant.CAPTION_12_SECONDARY, Paint.Align.LEFT);
            if (transactionDetailEntity.getValue().length() > 35 && !isContainsSplitter(transactionDetailEntity.getValue())) {
                this.yLastPosition = this.brush.multilineTextChar(transactionDetailEntity.getValue(), 64, this.yValuePosition, 35, TypeFaceVariant.BODY_14_NORMAL, Paint.Align.LEFT);
            } else {
                this.yLastPosition = this.brush.multilineText(transactionDetailEntity.getValue(), 64, this.yValuePosition, 64, TypeFaceVariant.BODY_14_NORMAL, Paint.Align.LEFT);
            }
            this.firstY = this.yLastPosition + 50;
        }
    }

    private void drawWrapperDashedBorder() {
        this.yStroke = this.yLastPosition + 40;
        this.brush.strokeDash(this.paint, Pallette.GREY_20, 2.0f);
        Path path = new Path();
        path.moveTo(32.0f, this.yStroke);
        path.lineTo(718.0f, this.yStroke);
        this.canvas.drawPath(path, this.paint);
    }

    private boolean isContainsSplitter(String str) {
        return str.contains(" ") || str.contains("\t");
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public int getLastY() {
        return this.lastY;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setFirstY(int i) {
        int i2 = i + 60;
        this.firstY = i2;
        calculateHeight(i2);
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void calculateHeight(int i) {
        int i2 = this.firstY;
        for (TransactionDetailEntity transactionDetailEntity : this.transactionDetailEntity) {
            this.yValuePosition = i2 + 48;
            int calculateMultiline = DrawUtil.calculateMultiline(transactionDetailEntity.getValue(), 64, this.yValuePosition, 64);
            this.yLastPosition = calculateMultiline;
            i2 = calculateMultiline + 50;
        }
        this.lastY = this.yLastPosition + 80;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.brush = new Brush(this.context, canvas);
    }
}
