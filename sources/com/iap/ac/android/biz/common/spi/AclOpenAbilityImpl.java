package com.iap.ac.android.biz.common.spi;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.iap.android.wallet.acl.base.BaseResult;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.foundation.code.CodeService;
import com.alipay.iap.android.wallet.foundation.code.CodeType;
import com.alipay.iap.android.wallet.foundation.code.ScannerResult;
import com.alipay.iap.android.wallet.foundation.deeplink.DeeplinkService;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.callback.OpenBizSceneCallback;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.ScanCallback;
import com.iap.ac.android.biz.common.model.ScanErrorCode;
import com.iap.ac.android.biz.common.model.ScanType;
import com.iap.ac.android.biz.common.model.ScannerOption;
import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AclOpenAbilityImpl extends AclBaseImpl {
    public CodeService mCodeService;
    public DeeplinkService mDeepLinkService;

    public AclOpenAbilityImpl() {
        if (isAclAvailable()) {
            this.mDeepLinkService = (DeeplinkService) getAclService(DeeplinkService.class);
            this.mCodeService = (CodeService) getAclService(CodeService.class);
        }
    }

    public void openBizScene(String str, Map<String, String> map, AclAPIContext aclAPIContext, final OpenBizSceneCallback openBizSceneCallback) {
        DeeplinkService deeplinkService = this.mDeepLinkService;
        if (deeplinkService != null) {
            deeplinkService.open(str, map, APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<BaseResult>() { // from class: com.iap.ac.android.biz.common.spi.AclOpenAbilityImpl.2
                {
                    AclOpenAbilityImpl.this = this;
                }

                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(BaseResult baseResult) {
                    JSONObject jSONObject;
                    try {
                        jSONObject = new JSONObject(JsonUtils.toJson(baseResult));
                    } catch (JSONException e) {
                        e = e;
                        jSONObject = null;
                    }
                    try {
                        jSONObject.put("success", !baseResult.isHasError());
                    } catch (JSONException e2) {
                        e = e2;
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("openBizScene json error: ");
                        sb.append(e);
                        ACLog.w(Constants.TAG, sb.toString());
                        openBizSceneCallback.sendJSONResponse(jSONObject);
                    }
                    openBizSceneCallback.sendJSONResponse(jSONObject);
                }
            });
            return;
        }
        StringBuilder a2 = a.a("implementation of ACL cannot be found, isAclAvailable: ");
        a2.append(isAclAvailable());
        handleForAclCallError("openBizScene", a2.toString());
    }

    public boolean openScheme(Uri uri, AclAPIContext aclAPIContext) {
        DeeplinkService deeplinkService = this.mDeepLinkService;
        if (deeplinkService != null) {
            return deeplinkService.open(uri, APIContextFactory.convertToAPIContext(aclAPIContext));
        }
        StringBuilder a2 = a.a("implementation of ACL cannot be found, isAclAvailable: ");
        a2.append(isAclAvailable());
        handleForAclCallError("openScheme", a2.toString());
        return false;
    }

    public void scan(ScannerOption scannerOption, AclAPIContext aclAPIContext, final ScanCallback scanCallback) {
        if (this.mCodeService != null) {
            CodeType codeType = CodeType.QRCODE;
            if (scannerOption != null && scannerOption.type == ScanType.BAR) {
                codeType = CodeType.BARCODE;
            }
            this.mCodeService.scan(new com.alipay.iap.android.wallet.foundation.code.ScannerOption(codeType, scannerOption != null ? scannerOption.hideAlbum : false, null), APIContextFactory.convertToAPIContext(aclAPIContext), new Callback<ScannerResult>() { // from class: com.iap.ac.android.biz.common.spi.AclOpenAbilityImpl.1
                {
                    AclOpenAbilityImpl.this = this;
                }

                @Override // com.alipay.iap.android.wallet.acl.base.Callback
                public void result(ScannerResult scannerResult) {
                    if (scannerResult != null && !TextUtils.isEmpty(scannerResult.getCode())) {
                        scanCallback.onSuccess(scannerResult.getCode());
                        return;
                    }
                    ScanCallback scanCallback2 = scanCallback;
                    if (scanCallback2 != null) {
                        scanCallback2.onFailure(ScanErrorCode.OPERATION_FAIL, "Oops! System busy. Try again later!");
                    }
                }
            });
            return;
        }
        StringBuilder a2 = a.a("implementation of ACL cannot be found, isAclAvailable: ");
        a2.append(isAclAvailable());
        handleForAclCallError("scan", a2.toString());
    }
}
