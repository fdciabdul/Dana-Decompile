package com.alibaba.griver.file.jsapi;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.utils.OfficeFileType;
import com.alibaba.griver.file.R;
import com.alibaba.griver.file.ui.FileViewerActivity;
import com.alibaba.griver.file.utils.FileManager;
import com.alibaba.griver.image.photo.PhotoContext;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import java.io.File;

/* loaded from: classes2.dex */
public class OpenDocumentBridgeExtension extends SimpleBridgeExtension {
    private static final String TAG = "OpenDocumentBridgeExtension";

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void openDocument(@BindingApiContext(required = true) ApiContext apiContext, @BindingNode(App.class) App app, @BindingParam(name = {"filePath"}) String str, @BindingParam(name = {"fileType"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        int lastIndexOf;
        Activity activity = apiContext.getActivity();
        if (activity == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        String filePath = FileManager.getFilePath(str);
        boolean z = false;
        int i = 4013;
        if (TextUtils.isEmpty(filePath) || filePath.contains("../")) {
            i = 4011;
        } else {
            if (TextUtils.isEmpty(filePath) && (lastIndexOf = filePath.lastIndexOf(".")) > 0) {
                str2 = filePath.substring(lastIndexOf + 1);
            }
            String replace = filePath.replace(PhotoContext.FILE_SCHEME, "");
            if (!new File(replace).exists()) {
                i = 4012;
            } else if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_OPEN_DOCUMENT_APP_PREVIEW, true) || OfficeFileType.Pdf.checkType(str2)) {
                Intent intent = new Intent();
                intent.setClass(activity, FileViewerActivity.class);
                intent.putExtra("fileType", str2);
                intent.putExtra(BridgeKey.FILE_PATH, replace);
                activity.startActivity(intent);
                z = true;
                i = 0;
            } else if (!OfficeFileType.Doc.checkType(str2) && !OfficeFileType.Docx.checkType(str2) && !OfficeFileType.Xls.checkType(str2) && !OfficeFileType.Xlsx.checkType(str2) && !OfficeFileType.PPt.checkType(str2)) {
                OfficeFileType.PPtx.checkType(str2);
            }
        }
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            String string = activity.getString(R.string.griver_file_not_support_type);
            if (i == 4011) {
                string = activity.getString(R.string.griver_invalid_file_path);
            } else if (i == 4012) {
                string = activity.getString(R.string.griver_file_not_exist);
            }
            jSONObject.put("error", (Object) Integer.valueOf(i));
            jSONObject.put("errorMessage", (Object) string);
        } else {
            jSONObject.put("success", (Object) Boolean.valueOf(z));
        }
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
