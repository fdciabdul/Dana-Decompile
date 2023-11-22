package com.alibaba.griver.api.ui.splash;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.griver.api.common.GriverExtension;
import com.alibaba.griver.api.ui.GVSplashView;

/* loaded from: classes3.dex */
public interface GriverSplashFragmentExtension extends GriverExtension {
    AbstractSplashFragment createSplashFragment();

    /* loaded from: classes3.dex */
    public static abstract class AbstractSplashFragment extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        private GVSplashView.OnReloadListener f6275a;

        public abstract void exit();

        public abstract void showError(String str, String str2);

        public abstract void updateLoadingInfo(SplashEntryInfo splashEntryInfo);

        public void updateProgress(SplashEntryInfo splashEntryInfo) {
        }

        @Override // androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            boolean z = BundleUtils.getBoolean(getArguments(), "showError", false);
            String string = BundleUtils.getString(getArguments(), "errorCode", "");
            String string2 = BundleUtils.getString(getArguments(), "errorMessage", "");
            SplashEntryInfo splashEntryInfo = (SplashEntryInfo) BundleUtils.getParcelable(getArguments(), RVConstants.EXTRA_ENTRY_INFO);
            if (z) {
                showError(string, string2);
            } else if (splashEntryInfo != null) {
                updateLoadingInfo(splashEntryInfo);
                updateProgress(splashEntryInfo);
            }
        }

        public void setReloadListener(GVSplashView.OnReloadListener onReloadListener) {
            this.f6275a = onReloadListener;
        }

        public void reload() {
            GVSplashView.OnReloadListener onReloadListener = this.f6275a;
            if (onReloadListener != null) {
                onReloadListener.onReload();
            }
        }
    }
}
