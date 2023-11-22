package id.dana.lib.drawbitmap.invoice;

import android.content.Context;
import android.graphics.Bitmap;
import id.dana.lib.drawbitmap.base.SaveBitmapImage;
import id.dana.lib.drawbitmap.invoice.model.HeaderEntity;
import id.dana.lib.drawbitmap.invoice.model.OrderDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.PaymentMethodEntity;
import id.dana.lib.drawbitmap.invoice.model.PriceDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.SummaryEntity;
import id.dana.lib.drawbitmap.invoice.model.TransactionDetailEntity;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.observers.DefaultObserver;
import java.util.List;

/* loaded from: classes2.dex */
public class CreateInvoice {
    private static final String FILE_NAME_FORMAT = "dana_invoice_";
    private Builder builder;
    private SaveBitmapImage saveBitmapImage;

    private CreateInvoice(Builder builder) {
        this.builder = builder;
        this.saveBitmapImage = new SaveBitmapImage(builder.context, FILE_NAME_FORMAT, ".png");
    }

    public void draw() {
        new DrawInvoice(this.builder.context, this.builder.pageTitle, this.builder.headerEntity, this.builder.orderDetailEntity, this.builder.paymentMethodEntity, this.builder.priceDetailEntity, this.builder.summaryEntity, this.builder.transactionDetailEntity).constructInvoice().flatMap(new Function<Bitmap, ObservableSource<? extends String>>() { // from class: id.dana.lib.drawbitmap.invoice.CreateInvoice.2
            @Override // io.reactivex.functions.Function
            public ObservableSource<? extends String> apply(Bitmap bitmap) throws Exception {
                return CreateInvoice.this.saveBitmapImage.saveToInternalStorage(bitmap);
            }
        }).subscribe(new DefaultObserver<String>() { // from class: id.dana.lib.drawbitmap.invoice.CreateInvoice.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(String str) {
                CreateInvoice.this.builder.handler.onResult(str);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                CreateInvoice.this.builder.handler.onError(th);
            }
        });
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private final Context context;
        private CreateInvoiceResultHandler handler;
        private HeaderEntity headerEntity;
        private OrderDetailEntity orderDetailEntity;
        private String pageTitle;
        private PaymentMethodEntity paymentMethodEntity;
        private List<PriceDetailEntity> priceDetailEntity;
        private SummaryEntity summaryEntity;
        private List<TransactionDetailEntity> transactionDetailEntity;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setPageTitle(String str) {
            this.pageTitle = str;
            return this;
        }

        public Builder setHeaderEntity(HeaderEntity headerEntity) {
            this.headerEntity = headerEntity;
            return this;
        }

        public Builder setOrderDetailEntity(OrderDetailEntity orderDetailEntity) {
            this.orderDetailEntity = orderDetailEntity;
            return this;
        }

        public Builder setPaymentMethodEntity(PaymentMethodEntity paymentMethodEntity) {
            this.paymentMethodEntity = paymentMethodEntity;
            return this;
        }

        public Builder setPriceDetailEntity(List<PriceDetailEntity> list) {
            this.priceDetailEntity = list;
            return this;
        }

        public Builder setSummaryEntity(SummaryEntity summaryEntity) {
            this.summaryEntity = summaryEntity;
            return this;
        }

        public Builder setTransactionDetailEntity(List<TransactionDetailEntity> list) {
            this.transactionDetailEntity = list;
            return this;
        }

        public Builder setResultHandler(CreateInvoiceResultHandler createInvoiceResultHandler) {
            this.handler = createInvoiceResultHandler;
            return this;
        }

        public CreateInvoice build() {
            return new CreateInvoice(this);
        }
    }
}
