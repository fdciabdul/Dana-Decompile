package id.dana.lib.drawbitmap.invoice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import id.dana.lib.drawbitmap.invoice.header.DrawHeader;
import id.dana.lib.drawbitmap.invoice.model.HeaderEntity;
import id.dana.lib.drawbitmap.invoice.model.OrderDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.PaymentMethodEntity;
import id.dana.lib.drawbitmap.invoice.model.PriceDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.SummaryEntity;
import id.dana.lib.drawbitmap.invoice.model.TransactionDetailEntity;
import id.dana.lib.drawbitmap.invoice.orderdetail.DrawOrderDetail;
import id.dana.lib.drawbitmap.invoice.paymentmethod.DrawPaymentMethod;
import id.dana.lib.drawbitmap.invoice.pricedetail.DrawPriceDetail;
import id.dana.lib.drawbitmap.invoice.summary.DrawSummary;
import id.dana.lib.drawbitmap.invoice.transactiondetail.DrawTransactionDetail;
import id.dana.lib.drawbitmap.invoice.wrapper.DrawWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public class DrawInvoice extends View {
    private Canvas canvas;
    private Context context;
    private DrawHeader drawHeader;
    private DrawOrderDetail drawOrderDetail;
    private DrawPaymentMethod drawPaymentMethod;
    private DrawPriceDetail drawPriceDetail;
    private DrawSummary drawSummary;
    private DrawTransactionDetail drawTransactionDetail;
    private DrawWrapper drawWrapper;
    private int fixedHeight;
    private HeaderEntity headerEntity;
    private OrderDetailEntity orderDetailEntity;
    private String pageTitle;
    private PaymentMethodEntity paymentMethodEntity;
    private List<PriceDetailEntity> priceDetailEntity;
    private Bitmap returnedBitmap;
    private SummaryEntity summaryEntity;
    private List<TransactionDetailEntity> transactionDetailEntity;

    public DrawInvoice(Context context) {
        super(context);
        this.context = context;
        initComponent();
    }

    private void initComponent() {
        DrawWrapper drawWrapper = new DrawWrapper(this.context, this.pageTitle);
        this.drawWrapper = drawWrapper;
        drawWrapper.setFirstY(0);
        DrawHeader drawHeader = new DrawHeader(this.context, this.headerEntity);
        this.drawHeader = drawHeader;
        drawHeader.setFirstY(this.drawWrapper.getLastY());
        DrawPriceDetail drawPriceDetail = new DrawPriceDetail(this.context, this.priceDetailEntity);
        this.drawPriceDetail = drawPriceDetail;
        drawPriceDetail.setFirstY(this.drawHeader.getLastY());
        DrawSummary drawSummary = new DrawSummary(this.context, this.summaryEntity);
        this.drawSummary = drawSummary;
        drawSummary.setFirstY(this.drawPriceDetail.getLastY());
        DrawOrderDetail drawOrderDetail = new DrawOrderDetail(this.context, this.orderDetailEntity);
        this.drawOrderDetail = drawOrderDetail;
        drawOrderDetail.setFirstY(this.drawSummary.getLastY());
        DrawTransactionDetail drawTransactionDetail = new DrawTransactionDetail(this.context, this.transactionDetailEntity);
        this.drawTransactionDetail = drawTransactionDetail;
        drawTransactionDetail.setFirstY(this.drawOrderDetail.getLastY());
        DrawPaymentMethod drawPaymentMethod = new DrawPaymentMethod(this.context, this.paymentMethodEntity);
        this.drawPaymentMethod = drawPaymentMethod;
        drawPaymentMethod.setFirstY(this.drawTransactionDetail.getLastY());
        int lastY = this.drawPaymentMethod.getLastY() + 100;
        this.fixedHeight = lastY;
        this.drawWrapper.setWrapperHeight(lastY);
    }

    public DrawInvoice(Context context, String str, HeaderEntity headerEntity, OrderDetailEntity orderDetailEntity, PaymentMethodEntity paymentMethodEntity, List<PriceDetailEntity> list, SummaryEntity summaryEntity, List<TransactionDetailEntity> list2) {
        super(context);
        this.context = context;
        this.pageTitle = str;
        this.headerEntity = headerEntity;
        this.orderDetailEntity = orderDetailEntity;
        this.paymentMethodEntity = paymentMethodEntity;
        this.priceDetailEntity = list;
        this.summaryEntity = summaryEntity;
        this.transactionDetailEntity = list2;
        initComponent();
        int i = this.fixedHeight;
        this.returnedBitmap = Bitmap.createBitmap(Config.WIDTH, i + BlobStatic.MONITOR_IMAGE_WIDTH, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.returnedBitmap);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        this.canvas = canvas;
    }

    public Observable<Bitmap> constructInvoice() {
        return drawWrapper().flatMap(new Function<Integer, ObservableSource<? extends Integer>>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.7
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public ObservableSource<? extends Integer> apply(Integer num) throws Exception {
                return DrawInvoice.this.drawHeader(num.intValue());
            }
        }).flatMap(new Function<Integer, ObservableSource<? extends Integer>>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.6
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public ObservableSource<? extends Integer> apply(Integer num) throws Exception {
                return DrawInvoice.this.drawPriceDetail(num.intValue());
            }
        }).flatMap(new Function<Integer, ObservableSource<? extends Integer>>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.5
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public ObservableSource<? extends Integer> apply(Integer num) throws Exception {
                return DrawInvoice.this.drawSummary(num.intValue());
            }
        }).flatMap(new Function<Integer, ObservableSource<? extends Integer>>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.4
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public ObservableSource<? extends Integer> apply(Integer num) throws Exception {
                return DrawInvoice.this.drawOrderDetail(num.intValue());
            }
        }).flatMap(new Function<Integer, ObservableSource<? extends Integer>>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.3
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public ObservableSource<? extends Integer> apply(Integer num) throws Exception {
                return DrawInvoice.this.drawTransactionDetail(num.intValue());
            }
        }).flatMap(new Function<Integer, ObservableSource<? extends Integer>>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.2
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public ObservableSource<? extends Integer> apply(Integer num) throws Exception {
                return DrawInvoice.this.drawPaymentMethod(num.intValue());
            }
        }).map(new Function<Integer, Bitmap>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.1
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public Bitmap apply(Integer num) throws Exception {
                return DrawInvoice.this.returnedBitmap;
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).observeOn(Schedulers.getAuthRequestContext());
    }

    private Observable<Integer> drawWrapper() {
        return Observable.fromCallable(new Callable<Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.9
            {
                DrawInvoice.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                DrawInvoice.this.drawWrapper.setCanvas(DrawInvoice.this.canvas);
                DrawInvoice.this.drawWrapper.constructWrapper();
                return Integer.valueOf(DrawInvoice.this.drawWrapper.getLastY());
            }
        }).onErrorReturn(new Function<Throwable, Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.8
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public Integer apply(Throwable th) throws Exception {
                return 0;
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).observeOn(Schedulers.getAuthRequestContext());
    }

    public Observable<Integer> drawHeader(final int i) {
        return Observable.fromCallable(new Callable<Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.11
            {
                DrawInvoice.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                DrawInvoice.this.drawHeader.setFirstY(i);
                DrawInvoice.this.drawHeader.setCanvas(DrawInvoice.this.canvas);
                DrawInvoice.this.drawHeader.constructHeader();
                return Integer.valueOf(DrawInvoice.this.drawHeader.getLastY());
            }
        }).onErrorReturn(new Function<Throwable, Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.10
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public Integer apply(Throwable th) throws Exception {
                return Integer.valueOf(i);
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).observeOn(Schedulers.getAuthRequestContext());
    }

    public Observable<Integer> drawPriceDetail(final int i) {
        return Observable.fromCallable(new Callable<Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.13
            {
                DrawInvoice.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                DrawInvoice.this.drawPriceDetail.setFirstY(i);
                DrawInvoice.this.drawPriceDetail.setCanvas(DrawInvoice.this.canvas);
                DrawInvoice.this.drawPriceDetail.constructPriceDetail();
                return Integer.valueOf(DrawInvoice.this.drawPriceDetail.getLastY());
            }
        }).onErrorReturn(new Function<Throwable, Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.12
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public Integer apply(Throwable th) throws Exception {
                return Integer.valueOf(i);
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).observeOn(Schedulers.getAuthRequestContext());
    }

    public Observable<Integer> drawSummary(final int i) {
        return Observable.create(new ObservableOnSubscribe<Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.15
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                DrawInvoice.this.drawSummary.setFirstY(i);
                DrawInvoice.this.drawSummary.setCanvas(DrawInvoice.this.canvas);
                DrawInvoice.this.drawSummary.constructSummary();
                DrawInvoice.this.drawSummary.setEmitter(observableEmitter);
            }
        }).onErrorReturn(new Function<Throwable, Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.14
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public Integer apply(Throwable th) throws Exception {
                return Integer.valueOf(i);
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).observeOn(Schedulers.getAuthRequestContext());
    }

    public Observable<Integer> drawOrderDetail(final int i) {
        return Observable.fromCallable(new Callable<Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.17
            {
                DrawInvoice.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                DrawInvoice.this.drawOrderDetail.setFirstY(i);
                DrawInvoice.this.drawOrderDetail.setCanvas(DrawInvoice.this.canvas);
                DrawInvoice.this.drawOrderDetail.constructOrderDetail();
                return Integer.valueOf(DrawInvoice.this.drawOrderDetail.getLastY());
            }
        }).onErrorReturn(new Function<Throwable, Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.16
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public Integer apply(Throwable th) throws Exception {
                return Integer.valueOf(i);
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).observeOn(Schedulers.getAuthRequestContext());
    }

    public Observable<Integer> drawTransactionDetail(final int i) {
        return Observable.fromCallable(new Callable<Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.19
            {
                DrawInvoice.this = this;
            }

            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                DrawInvoice.this.drawTransactionDetail.setFirstY(i);
                DrawInvoice.this.drawTransactionDetail.setCanvas(DrawInvoice.this.canvas);
                DrawInvoice.this.drawTransactionDetail.constructTransactionDetail();
                return Integer.valueOf(DrawInvoice.this.drawTransactionDetail.getLastY());
            }
        }).onErrorReturn(new Function<Throwable, Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.18
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public Integer apply(Throwable th) throws Exception {
                return Integer.valueOf(i);
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).observeOn(Schedulers.getAuthRequestContext());
    }

    public Observable<Integer> drawPaymentMethod(final int i) {
        return Observable.create(new ObservableOnSubscribe<Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.21
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<Integer> observableEmitter) throws Exception {
                DrawInvoice.this.drawPaymentMethod.setFirstY(i);
                DrawInvoice.this.drawPaymentMethod.setCanvas(DrawInvoice.this.canvas);
                DrawInvoice.this.drawPaymentMethod.constructPaymentMethod();
                DrawInvoice.this.drawPaymentMethod.setEmitter(observableEmitter);
            }
        }).onErrorReturn(new Function<Throwable, Integer>() { // from class: id.dana.lib.drawbitmap.invoice.DrawInvoice.20
            {
                DrawInvoice.this = this;
            }

            @Override // io.reactivex.functions.Function
            public Integer apply(Throwable th) throws Exception {
                return Integer.valueOf(i);
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).observeOn(Schedulers.getAuthRequestContext());
    }
}
