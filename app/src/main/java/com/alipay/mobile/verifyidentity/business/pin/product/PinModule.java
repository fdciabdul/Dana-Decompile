package com.alipay.mobile.verifyidentity.business.pin.product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.base.product.SecVIModule;
import com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes7.dex */
public class PinModule extends SecVIModule {
    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public String getProductName() {
        return "PIN";
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public void setProductName() {
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public void stop() {
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.SecVIModule
    public void start(Context context, Message message, IProduct.ICallback iCallback) {
        PinActivity.setCallback(iCallback);
        PinActivity.setPinProduct(this);
        Intent intent = new Intent(context, PinActivity.class);
        intent.putExtra("message", message);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }
}
