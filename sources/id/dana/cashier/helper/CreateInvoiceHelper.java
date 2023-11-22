package id.dana.cashier.helper;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.lib.drawbitmap.invoice.CreateInvoice;
import id.dana.lib.drawbitmap.invoice.CreateInvoiceResultHandler;
import id.dana.lib.drawbitmap.invoice.model.HeaderEntity;
import id.dana.lib.drawbitmap.invoice.model.OrderDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.PaymentMethodEntity;
import id.dana.lib.drawbitmap.invoice.model.PriceDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.SummaryEntity;
import id.dana.lib.drawbitmap.invoice.model.TransactionDetailEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/helper/CreateInvoiceHelper;", "", "Landroid/content/Context;", "p0", "Lid/dana/lib/drawbitmap/invoice/CreateInvoiceResultHandler;", "p1", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Lid/dana/lib/drawbitmap/invoice/CreateInvoiceResultHandler;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CreateInvoiceHelper {
    public static final CreateInvoiceHelper INSTANCE = new CreateInvoiceHelper();

    private CreateInvoiceHelper() {
    }

    public static void MyBillsEntityDataFactory(Context p0, CreateInvoiceResultHandler p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        CreateInvoice.Builder pageTitle = new CreateInvoice.Builder(p0).setPageTitle("Detail Transaksi");
        HeaderEntity headerEntity = new HeaderEntity();
        headerEntity.setAmount("Rp10.000");
        headerEntity.setDate("13 Maret 2019");
        headerEntity.setDesc("Anda telah berhasil membeli Pulsa");
        headerEntity.setIconUrl("iconUrl");
        headerEntity.setTime("12:30");
        CreateInvoice.Builder headerEntity2 = pageTitle.setHeaderEntity(headerEntity);
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        orderDetailEntity.setTitle("No. Invoice");
        orderDetailEntity.setNumber("INV/20170605/XVII/VI/86428176");
        OrderDetailEntity.Data data = new OrderDetailEntity.Data();
        data.setTitle("Nomor HP");
        data.setValue("082145377771");
        Unit unit = Unit.INSTANCE;
        OrderDetailEntity.Data data2 = new OrderDetailEntity.Data();
        data2.setTitle("Paket Data");
        data2.setValue("50.000");
        Unit unit2 = Unit.INSTANCE;
        OrderDetailEntity.Data data3 = new OrderDetailEntity.Data();
        data3.setTitle("Nomor Seri");
        data3.setValue("0041002100518027");
        Unit unit3 = Unit.INSTANCE;
        orderDetailEntity.setData(CollectionsKt.listOf((Object[]) new OrderDetailEntity.Data[]{data, data2, data3}));
        CreateInvoice.Builder orderDetailEntity2 = headerEntity2.setOrderDetailEntity(orderDetailEntity);
        PaymentMethodEntity paymentMethodEntity = new PaymentMethodEntity();
        paymentMethodEntity.setDesc("Debit BCA (7652)");
        paymentMethodEntity.setPaymentIconUrl("paymentIconUrl");
        paymentMethodEntity.setProtectionIconUrl("protectionIconUrl");
        paymentMethodEntity.setTitle("Metode Pembayaran");
        CreateInvoice.Builder paymentMethodEntity2 = orderDetailEntity2.setPaymentMethodEntity(paymentMethodEntity);
        SummaryEntity summaryEntity = new SummaryEntity();
        summaryEntity.setBizType(TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
        summaryEntity.setTitle("Kirim Uang");
        summaryEntity.setDesc("Rp200.000 to Ricky Contesso");
        SummaryEntity.ExtInfo extInfo = new SummaryEntity.ExtInfo();
        extInfo.setTitle("Nomor Token");
        extInfo.setValue("0041002100518027");
        summaryEntity.setExtInfo(extInfo);
        summaryEntity.setIconUrl("iconUrl");
        SummaryEntity.OrderStatus orderStatus = new SummaryEntity.OrderStatus();
        orderStatus.setTitle("Order Berhasil");
        orderStatus.setStatus("SUCCESS");
        summaryEntity.setOrderStatus(orderStatus);
        CreateInvoice.Builder summaryEntity2 = paymentMethodEntity2.setSummaryEntity(summaryEntity);
        TransactionDetailEntity transactionDetailEntity = new TransactionDetailEntity();
        transactionDetailEntity.setTitle("ID Transaksi");
        transactionDetailEntity.setValue("2019 0717 6543 2876 9176 0134");
        Unit unit4 = Unit.INSTANCE;
        TransactionDetailEntity transactionDetailEntity2 = new TransactionDetailEntity();
        transactionDetailEntity2.setTitle("ID Order Merchant");
        transactionDetailEntity2.setValue("GP0765432107587652820");
        Unit unit5 = Unit.INSTANCE;
        CreateInvoice.Builder transactionDetailEntity3 = summaryEntity2.setTransactionDetailEntity(CollectionsKt.listOf((Object[]) new TransactionDetailEntity[]{transactionDetailEntity, transactionDetailEntity2}));
        PriceDetailEntity priceDetailEntity = new PriceDetailEntity();
        priceDetailEntity.setTitle("total");
        priceDetailEntity.setAmount("Rp1.500");
        priceDetailEntity.setType("addition");
        Unit unit6 = Unit.INSTANCE;
        PriceDetailEntity priceDetailEntity2 = new PriceDetailEntity();
        priceDetailEntity2.setTitle("promo");
        priceDetailEntity2.setAmount("Rp500");
        priceDetailEntity2.setType("addition");
        Unit unit7 = Unit.INSTANCE;
        PriceDetailEntity priceDetailEntity3 = new PriceDetailEntity();
        priceDetailEntity3.setTitle("fee");
        priceDetailEntity3.setAmount("Rp1.000");
        priceDetailEntity3.setType("deduction");
        Unit unit8 = Unit.INSTANCE;
        transactionDetailEntity3.setPriceDetailEntity(CollectionsKt.listOf((Object[]) new PriceDetailEntity[]{priceDetailEntity, priceDetailEntity2, priceDetailEntity3})).setResultHandler(p1).build().draw();
    }
}
