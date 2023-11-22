package id.dana.lib.drawbitmap.invoice.orderdetail;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import id.dana.lib.drawbitmap.invoice.BaseInvoiceView;
import id.dana.lib.drawbitmap.invoice.model.OrderDetailEntity;
import id.dana.lib.drawbitmap.style.Brush;
import id.dana.lib.drawbitmap.style.Pallette;
import id.dana.lib.drawbitmap.style.typeface.TypeFaceVariant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class DrawOrderDetail implements BaseInvoiceView {
    private static final int MAX_VALUE = 20;
    private Brush brush;
    private Canvas canvas;
    private Context context;
    private int firstY;
    private int lastY;
    private int numberY;
    private OrderDetailEntity orderDetailEntity;
    private Paint paint = new Paint();
    private float yDataPosition;

    public DrawOrderDetail(Context context, OrderDetailEntity orderDetailEntity) {
        this.context = context;
        this.orderDetailEntity = orderDetailEntity;
    }

    public void constructOrderDetail() {
        drawTitle();
        drawNumber();
        drawTopDashedBorder();
        if (this.orderDetailEntity.getData().size() > 0) {
            drawData();
            drawBottomDashedBorder();
        }
    }

    private void drawTitle() {
        this.brush.text(this.orderDetailEntity.getTitle(), 64.0f, this.firstY, TypeFaceVariant.CAPTION_12_SECONDARY);
    }

    private void drawNumber() {
        this.numberY = this.firstY + 44;
        if (this.orderDetailEntity.getNumber().length() < 37) {
            this.brush.text(this.orderDetailEntity.getNumber(), 64.0f, this.numberY, TypeFaceVariant.BODY_14_ACTIVE);
            return;
        }
        String substring = this.orderDetailEntity.getNumber().substring(0, 38);
        String substring2 = this.orderDetailEntity.getNumber().substring(39);
        this.brush.text(substring, 64.0f, this.numberY, TypeFaceVariant.BODY_14_ACTIVE, Paint.Align.LEFT);
        int i = this.numberY + 40;
        this.numberY = i;
        this.brush.text(substring2, 64.0f, i, TypeFaceVariant.BODY_14_ACTIVE, Paint.Align.LEFT);
    }

    private void drawData() {
        this.yDataPosition = this.numberY + 100;
        for (int i = 0; i < this.orderDetailEntity.getData().size(); i++) {
            this.brush.text(this.orderDetailEntity.getData().get(i).getTitle(), 64.0f, this.yDataPosition, TypeFaceVariant.BODY_14_SECONDARY, Paint.Align.LEFT);
            if (this.orderDetailEntity.getData().get(i).getValue().length() < (this.orderDetailEntity.getData().get(i).getTitle().length() < 21 ? this.orderDetailEntity.getData().get(i).getTitle().length() : 0) + 20) {
                this.brush.text(this.orderDetailEntity.getData().get(i).getValue(), 686.0f, this.yDataPosition, TypeFaceVariant.BODY_14_NORMAL, Paint.Align.RIGHT);
            } else {
                String trim = this.orderDetailEntity.getData().get(i).getValue().trim();
                Matcher matcher = Pattern.compile("([\\S]+\\s*){1,3}").matcher(trim);
                matcher.find();
                String trim2 = matcher.group().trim();
                String substring = trim.substring(trim2.length());
                this.brush.text(trim2, 686.0f, this.yDataPosition, TypeFaceVariant.BODY_14_NORMAL, Paint.Align.RIGHT);
                float f = this.yDataPosition + 40.0f;
                this.yDataPosition = f;
                this.brush.text(substring, 686.0f, f, TypeFaceVariant.BODY_14_NORMAL, Paint.Align.RIGHT);
            }
            this.yDataPosition += 80.0f;
        }
    }

    private void drawTopDashedBorder() {
        float f = this.numberY + 36;
        this.brush.strokeDash(this.paint, Pallette.GREY_20, 2.0f);
        Path path = new Path();
        path.moveTo(64.0f, f);
        path.lineTo(686.0f, f);
        this.canvas.drawPath(path, this.paint);
    }

    private void drawBottomDashedBorder() {
        float f = this.yDataPosition - 40.0f;
        this.brush.strokeDash(this.paint, Pallette.GREY_20, 2.0f);
        Path path = new Path();
        path.moveTo(64.0f, f);
        path.lineTo(686.0f, f);
        this.canvas.drawPath(path, this.paint);
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
        this.lastY = i;
        OrderDetailEntity orderDetailEntity = this.orderDetailEntity;
        if (orderDetailEntity != null) {
            if (orderDetailEntity.getNumber().length() <= 37) {
                this.numberY = this.lastY + 44;
            } else {
                this.numberY = this.lastY + 44 + 40;
            }
            int i2 = this.numberY;
            this.yDataPosition = 0.0f;
            if (this.orderDetailEntity.getData() != null && this.orderDetailEntity.getData().size() > 0) {
                this.yDataPosition = 30.0f;
                for (int i3 = 0; i3 < this.orderDetailEntity.getData().size(); i3++) {
                    if (this.orderDetailEntity.getData().get(i3).getValue().length() > (this.orderDetailEntity.getData().get(i3).getTitle().length() < 21 ? this.orderDetailEntity.getData().get(i3).getTitle().length() : 0) + 20) {
                        this.yDataPosition += 40.0f;
                    }
                    this.yDataPosition += 80.0f;
                }
            }
            this.lastY = (int) (i2 + 36 + this.yDataPosition);
        }
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.brush = new Brush(this.context, canvas);
    }
}
