package id.dana.danah5.tooltip.listener;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes8.dex */
public interface FragmentResultListener {
    void onActivityResult(int i, int i2, Intent intent);

    void onFragmentCreated(FragmentResultHandler fragmentResultHandler, Bundle bundle);
}
