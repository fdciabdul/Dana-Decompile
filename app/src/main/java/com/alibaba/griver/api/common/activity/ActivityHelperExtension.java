package com.alibaba.griver.api.common.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.alibaba.griver.api.common.GriverExtension;

/* loaded from: classes3.dex */
public interface ActivityHelperExtension extends GriverExtension {
    void bindActivity(Activity activity);

    void dispatchTouchEvent(MotionEvent motionEvent);

    void finish();

    void onActivityResult(int i, int i2, Intent intent);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onNewIntent(Intent intent);

    void onPause();

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    void onResume();

    void onStop();
}
