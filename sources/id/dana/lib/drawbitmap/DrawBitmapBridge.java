package id.dana.lib.drawbitmap;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import id.dana.lib.drawbitmap.invoice.CreateInvoice;
import id.dana.lib.drawbitmap.invoice.CreateInvoiceResultHandler;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.lib.drawbitmap.invoice.InvoiceResultFactory;
import id.dana.lib.drawbitmap.invoice.model.HeaderEntity;
import id.dana.lib.drawbitmap.invoice.model.OrderDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.PaymentMethodEntity;
import id.dana.lib.drawbitmap.invoice.model.PriceDetailEntity;
import id.dana.lib.drawbitmap.invoice.model.SummaryEntity;
import id.dana.lib.drawbitmap.invoice.model.TransactionDetailEntity;
import id.dana.lib.gcontainer.GContainer;
import id.dana.util.media.FileUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/lib/drawbitmap/DrawBitmapBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", "event", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", DrawBitmapBridge.JSAPI_ACTION, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "handleInvoice", "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DrawBitmapBridge extends SimpleBridgeExtension {
    public static final String JSAPI_ACTION = "drawBitmap";
    private static final int MINIMUM_STORAGE_AVAILABLE = 100;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void drawBitmap(@BindingParam(name = {"event"}) String event, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkParameterIsNotNull(bridgeCallback, "");
        if (Intrinsics.areEqual(event, DrawBitmapEvent.INVOICE)) {
            if (FileUtil.getAuthRequestContext() <= 100) {
                bridgeCallback.sendJSONResponse(InvoiceResultFactory.getErrorResult(DrawBitmapResultType.RUN_OUT_OF_STORAGE));
            } else {
                handleInvoice(info, bridgeCallback);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleInvoice(JSONObject info, final BridgeCallback bridgeCallback) {
        Object obj;
        HeaderEntity headerEntity;
        Object obj2;
        OrderDetailEntity orderDetailEntity;
        Object obj3;
        PaymentMethodEntity paymentMethodEntity;
        Object obj4;
        SummaryEntity summaryEntity;
        ArrayList arrayList;
        JSONArray jSONArray;
        Object obj5;
        JSONArray jSONArray2;
        TransactionDetailEntity transactionDetailEntity;
        CreateInvoice.Builder builder = new CreateInvoice.Builder(GContainer.getApplicationContext());
        List<PriceDetailEntity> list = null;
        String string = info != null ? info.getString("pageTitle") : null;
        if (string == null) {
            string = "";
        }
        CreateInvoice.Builder pageTitle = builder.setPageTitle(string);
        if (info != null) {
            try {
                obj = JSONObject.parseObject(info.getJSONObject(InvoiceConstant.HEADER).toJSONString(), new TypeReference<HeaderEntity>() { // from class: id.dana.lib.drawbitmap.DrawBitmapBridge$handleInvoice$$inlined$toObject$1
                }, new Feature[0]);
            } catch (JSONException | NullPointerException unused) {
                obj = null;
            }
            headerEntity = (HeaderEntity) obj;
        } else {
            headerEntity = null;
        }
        CreateInvoice.Builder headerEntity2 = pageTitle.setHeaderEntity(headerEntity);
        if (info != null) {
            try {
                obj2 = JSONObject.parseObject(info.getJSONObject(InvoiceConstant.ORDER_DETAIL).toJSONString(), new TypeReference<OrderDetailEntity>() { // from class: id.dana.lib.drawbitmap.DrawBitmapBridge$handleInvoice$$inlined$toObject$2
                }, new Feature[0]);
            } catch (JSONException | NullPointerException unused2) {
                obj2 = null;
            }
            orderDetailEntity = (OrderDetailEntity) obj2;
        } else {
            orderDetailEntity = null;
        }
        CreateInvoice.Builder orderDetailEntity2 = headerEntity2.setOrderDetailEntity(orderDetailEntity);
        if (info != null) {
            try {
                obj3 = JSONObject.parseObject(info.getJSONObject(InvoiceConstant.PAYMENT_METHOD).toJSONString(), new TypeReference<PaymentMethodEntity>() { // from class: id.dana.lib.drawbitmap.DrawBitmapBridge$handleInvoice$$inlined$toObject$3
                }, new Feature[0]);
            } catch (JSONException | NullPointerException unused3) {
                obj3 = null;
            }
            paymentMethodEntity = (PaymentMethodEntity) obj3;
        } else {
            paymentMethodEntity = null;
        }
        CreateInvoice.Builder paymentMethodEntity2 = orderDetailEntity2.setPaymentMethodEntity(paymentMethodEntity);
        if (info != null) {
            try {
                obj4 = JSONObject.parseObject(info.getJSONObject(InvoiceConstant.SUMMARY).toJSONString(), new TypeReference<SummaryEntity>() { // from class: id.dana.lib.drawbitmap.DrawBitmapBridge$handleInvoice$$inlined$toObject$4
                }, new Feature[0]);
            } catch (JSONException | NullPointerException unused4) {
                obj4 = null;
            }
            summaryEntity = (SummaryEntity) obj4;
        } else {
            summaryEntity = null;
        }
        CreateInvoice.Builder summaryEntity2 = paymentMethodEntity2.setSummaryEntity(summaryEntity);
        if (info == null || (jSONArray2 = info.getJSONArray(InvoiceConstant.TRANSACTION_DETAIL)) == null) {
            arrayList = null;
        } else {
            try {
                arrayList = new ArrayList();
                int size = jSONArray2.size();
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject = jSONArray2.getJSONObject(i);
                    if (jSONObject != null) {
                        try {
                            transactionDetailEntity = JSONObject.parseObject(jSONObject.toJSONString(), new TypeReference<TransactionDetailEntity>() { // from class: id.dana.lib.drawbitmap.DrawBitmapBridge$handleInvoice$$inlined$toObjectList$1
                            }, new Feature[0]);
                        } catch (JSONException | NullPointerException unused5) {
                            transactionDetailEntity = null;
                        }
                        if (transactionDetailEntity != null) {
                            arrayList.add(transactionDetailEntity);
                        }
                    }
                }
            } catch (JSONException unused6) {
                arrayList = CollectionsKt.emptyList();
            }
        }
        CreateInvoice.Builder transactionDetailEntity2 = summaryEntity2.setTransactionDetailEntity(arrayList);
        if (info != null && (jSONArray = info.getJSONArray(InvoiceConstant.PRICE_DETAIL)) != null) {
            try {
                ArrayList arrayList2 = new ArrayList();
                int size2 = jSONArray.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        try {
                            obj5 = JSONObject.parseObject(jSONObject2.toJSONString(), new TypeReference<PriceDetailEntity>() { // from class: id.dana.lib.drawbitmap.DrawBitmapBridge$handleInvoice$$inlined$toObjectList$2
                            }, new Feature[0]);
                        } catch (JSONException | NullPointerException unused7) {
                            obj5 = null;
                        }
                        if (obj5 != null) {
                            arrayList2.add(obj5);
                        }
                    }
                }
                list = arrayList2;
            } catch (JSONException unused8) {
                list = CollectionsKt.emptyList();
            }
        }
        transactionDetailEntity2.setPriceDetailEntity(list).setResultHandler(new CreateInvoiceResultHandler() { // from class: id.dana.lib.drawbitmap.DrawBitmapBridge$handleInvoice$1
            @Override // id.dana.lib.drawbitmap.invoice.CreateInvoiceResultHandler
            public final void onResult(String filePath) {
                Intrinsics.checkParameterIsNotNull(filePath, "");
                BridgeCallback.this.sendJSONResponse(InvoiceResultFactory.getSuccessResult(filePath));
            }

            @Override // id.dana.lib.drawbitmap.invoice.CreateInvoiceResultHandler
            public final void onError(Throwable e) {
                Intrinsics.checkParameterIsNotNull(e, "");
                BridgeCallback.this.sendJSONResponse(InvoiceResultFactory.getGeneralErrorResult());
            }
        }).build().draw();
    }
}
