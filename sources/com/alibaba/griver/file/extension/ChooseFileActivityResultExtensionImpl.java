package com.alibaba.griver.file.extension;

import android.content.Intent;
import android.net.Uri;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension;

/* loaded from: classes6.dex */
public class ChooseFileActivityResultExtensionImpl implements ActivityResultPoint {
    private static final String TAG = "ChooseFileActivityResultExtensionImpl";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.activity.ActivityResultPoint
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 200) {
            return;
        }
        if (i2 == 0) {
            Intent intent2 = new Intent();
            intent2.setAction(ChooseFileBridgeExtension.ACTION_CHOOSE_FILE);
            intent2.putExtra("result", "cancel");
            LocalBroadcastManager.getInstance(GriverEnv.getApplicationContext()).sendBroadcastSync(intent2);
        } else if (i2 != -1 || intent == null) {
        } else {
            Uri data = intent.getData();
            StringBuilder sb = new StringBuilder();
            sb.append("user choose file uri: ");
            sb.append(data);
            GriverLogger.d(TAG, sb.toString());
            Intent intent3 = new Intent();
            intent3.setAction(ChooseFileBridgeExtension.ACTION_CHOOSE_FILE);
            intent3.putExtra(ChooseFileBridgeExtension.CHOOSE_FILE_RESULT_DATA_KEY, data);
            LocalBroadcastManager.getInstance(GriverEnv.getApplicationContext()).sendBroadcastSync(intent3);
        }
    }
}
