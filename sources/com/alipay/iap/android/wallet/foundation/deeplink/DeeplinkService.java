package com.alipay.iap.android.wallet.foundation.deeplink;

import android.net.Uri;
import com.alipay.iap.android.wallet.acl.base.APIContext;
import com.alipay.iap.android.wallet.acl.base.BaseResult;
import com.alipay.iap.android.wallet.acl.base.BaseService;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.base.ServiceCategory;
import com.alipay.iap.android.wallet.acl.base.ServiceMetaInfo;
import com.alipay.iap.android.wallet.acl.base.ServiceType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@ServiceMetaInfo(category = ServiceCategory.FOUNDATION, serviceName = "aplus.service.deeplink", type = ServiceType.DEEPLINK)
/* loaded from: classes.dex */
public interface DeeplinkService extends BaseService {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Scene {
        public static final String BIND_CARD = "BIND_CARD";
        public static final String QR_PAY = "QR_PAY";
        public static final String SCAN = "SCAN";
        public static final String SCHEME = "SCHEME";
        public static final String TOP_UP = "TOP_UP";
        public static final String WEB_PAGE = "WEB_PAGE";
    }

    void open(String str, Map<String, String> map, APIContext aPIContext, Callback<BaseResult> callback);

    boolean open(Uri uri, APIContext aPIContext);
}
