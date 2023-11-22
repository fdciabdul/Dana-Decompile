package com.alipay.mobile.verifyidentity.business.security_verification.product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.base.product.SecVIModule;
import com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes7.dex */
public class SecurityVerifyModule extends SecVIModule {
    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public String getProductName() {
        return "Security";
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public void setProductName() {
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public void stop() {
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.SecVIModule
    public void start(Context context, Message message, IProduct.ICallback iCallback) {
        VerifySecurityActivity.setCallback(iCallback);
        VerifySecurityActivity.setPinProduct(this);
        Intent intent = new Intent(context, VerifySecurityActivity.class);
        intent.putExtra("message", message);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }
}
