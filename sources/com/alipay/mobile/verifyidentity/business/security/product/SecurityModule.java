package com.alipay.mobile.verifyidentity.business.security.product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.MessageConstants;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.base.product.SecVIModule;
import com.alipay.mobile.verifyidentity.business.security.activity.SecurityListActivity;
import com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity;
import com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityActivity;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.uitools.JsonUtils;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SecurityModule extends SecVIModule {
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
        Intent intent;
        Intent intent2 = RequestConstants.BUILD_MENU.equalsIgnoreCase(message.getAction()) ? new Intent(context, SecurityListActivity.class) : null;
        String data = message.getData();
        if (!TextUtils.isEmpty(message.getData())) {
            try {
                String string = JsonUtils.getString(new JSONObject(JsonUtils.getString(new JSONObject(data), MessageConstants.KEY_PAGE_MODEL)), MessageConstants.KEY_SDKPAGENAME);
                if (string.equals(SecurityConstants.KEY_SQ_GUIDE_PAGE)) {
                    intent = new Intent(context, SecurityPrepareActivity.class);
                } else if (string.equals(SecurityConstants.KEY_SQ_SETUP_PAGE)) {
                    intent = new Intent(context, SetSecurityActivity.class);
                }
                intent2 = intent;
            } catch (JSONException unused) {
            }
        }
        if (intent2 == null && RequestConstants.QUERY_BIO_STATUS.equalsIgnoreCase(message.getAction())) {
            intent2 = new Intent(context, SecurityPrepareActivity.class);
        }
        if (intent2 == null) {
            return;
        }
        intent2.putExtra("message", message);
        if (!(context instanceof Activity)) {
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent2);
    }
}
