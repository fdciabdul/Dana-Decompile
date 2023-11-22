package com.alipay.mobile.verifyidentity.business.menu.product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.base.product.SecVIModule;
import com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes7.dex */
public class MenuModule extends SecVIModule {
    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public String getProductName() {
        return null;
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public void setProductName() {
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct
    public void stop() {
    }

    @Override // com.alipay.mobile.verifyidentity.base.product.SecVIModule
    public void start(Context context, Message message, IProduct.ICallback iCallback) {
        Intent intent = new Intent(context, MenuActivity.class);
        intent.putExtra("message", message);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }
}
