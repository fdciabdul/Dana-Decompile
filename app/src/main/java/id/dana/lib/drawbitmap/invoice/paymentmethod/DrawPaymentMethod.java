package id.dana.lib.drawbitmap.invoice.paymentmethod;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
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
import id.dana.analytics.tracker.TrackerKey;
import id.dana.lib.drawbitmap.R;
import id.dana.lib.drawbitmap.invoice.BaseInvoiceView;
import id.dana.lib.drawbitmap.invoice.model.PaymentMethodEntity;
import id.dana.lib.drawbitmap.style.Brush;
import id.dana.lib.drawbitmap.style.Pallette;
import id.dana.lib.drawbitmap.style.typeface.TypeFaceVariant;
import io.reactivex.ObservableEmitter;

/* loaded from: classes5.dex */
public class DrawPaymentMethod implements BaseInvoiceView {
    private int bgY;
    private Brush brush;
    private Canvas canvas;
    private Context context;
    private ObservableEmitter<Integer> emitter;
    private int firstY;
    private int iconY;
    private int lastY;
    private PaymentMethodEntity paymentMethodEntity;
    private int descX = 84;
    private Paint paint = new Paint();

    public DrawPaymentMethod(Context context, PaymentMethodEntity paymentMethodEntity) {
        this.context = context;
        this.paymentMethodEntity = paymentMethodEntity;
    }

    public void setEmitter(ObservableEmitter<Integer> observableEmitter) {
        this.emitter = observableEmitter;
    }

    public void constructPaymentMethod() {
        drawTitle();
        drawWrapperBg();
        drawProtectionIcon();
        if (this.paymentMethodEntity.getPaymentIconUrl() != null && TrackerKey.DanaBalanceRecipientTypeProperty.DANA.equals(this.paymentMethodEntity.getPaymentIconUrl())) {
            drawPayMethodDANA();
        } else {
            drawPayMethodIcon();
        }
    }

    private void drawTitle() {
        this.brush.text(this.paymentMethodEntity.getTitle(), 64.0f, this.firstY, TypeFaceVariant.TITLE_12_NORMAL);
    }

    private void drawWrapperBg() {
        int i = this.firstY + 26;
        this.bgY = i;
        this.brush.fill(this.paint, Pallette.BLUE_10, new CornerPathEffect(8.0f));
        this.canvas.drawRect(64.0f, this.bgY, 686.0f, i + 96.0f, this.paint);
    }

    private void drawProtectionIcon() {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.dana_protection);
        int i = this.bgY + 26;
        this.canvas.drawBitmap(decodeResource, (Rect) null, new Rect(624, i, 664, i + 40), this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawPayMethodDANA() {
        int i = this.bgY + 22;
        this.iconY = i;
        this.canvas.drawBitmap(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.dana_coin), (Rect) null, new Rect(84, this.iconY, 132, i + 48), this.paint);
        this.descX = 150;
        drawDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawDescription() {
        this.brush.text(this.paymentMethodEntity.getDesc(), this.descX, this.iconY + 36, TypeFaceVariant.BODY_14_NORMAL);
        this.emitter.onNext(Integer.valueOf(this.lastY));
    }

    private void drawPayMethodIcon() {
        try {
            int i = this.bgY + 22;
            this.iconY = i;
            RequestBuilder<Bitmap> PlaceComponentResult = Glide.KClassImpl$Data$declaredNonStaticMembers$2(this.context).PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            sb.append(this.paymentMethodEntity.getPaymentIconUrl());
            sb.append("?test=");
            sb.append(System.currentTimeMillis());
            final int i2 = i + 54;
            PlaceComponentResult.PlaceComponentResult(sb.toString()).MyBillsEntityDataFactory((BaseRequestOptions<?>) new RequestOptions().MyBillsEntityDataFactory(R.drawable.dana_coin).BuiltInFictitiousFunctionClassFactory(R.drawable.dana_coin).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.MyBillsEntityDataFactory).getAuthRequestContext(true).scheduleImpl().KClassImpl$Data$declaredNonStaticMembers$2(new ObjectKey(Long.valueOf(System.currentTimeMillis())))).KClassImpl$Data$declaredNonStaticMembers$2(new RequestListener<Bitmap>() { // from class: id.dana.lib.drawbitmap.invoice.paymentmethod.DrawPaymentMethod.1
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException glideException, Object obj, Target<Bitmap> target, boolean z) {
                    DrawPaymentMethod.this.drawPayMethodDANA();
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                    DrawPaymentMethod.this.canvas.drawBitmap(bitmap, (Rect) null, new Rect(84, DrawPaymentMethod.this.iconY, 158, i2), DrawPaymentMethod.this.paint);
                    DrawPaymentMethod.this.descX = 176;
                    DrawPaymentMethod.this.drawDescription();
                    return false;
                }
            }).KClassImpl$Data$declaredNonStaticMembers$2();
        } catch (Exception unused) {
        }
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public int getLastY() {
        return this.lastY;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setFirstY(int i) {
        int i2 = i + 56;
        this.firstY = i2;
        calculateHeight(i2);
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void calculateHeight(int i) {
        this.lastY = i + 26 + 22 + 36;
    }

    @Override // id.dana.lib.drawbitmap.invoice.BaseInvoiceView
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.brush = new Brush(this.context, canvas);
    }
}
