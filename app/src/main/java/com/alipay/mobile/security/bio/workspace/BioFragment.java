package com.alipay.mobile.security.bio.workspace;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.alipay.mobile.security.bio.exception.BioObjectNotInitialException;
import com.alipay.mobile.security.bio.service.BioServiceManager;

/* loaded from: classes7.dex */
public class BioFragment extends Fragment {
    protected BioFragmentCallBack mBioFragmentCallBack;
    protected BioServiceManager mBioServiceManager;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        BioServiceManager currentInstance = BioServiceManager.getCurrentInstance();
        this.mBioServiceManager = currentInstance;
        if (currentInstance == null) {
            new RuntimeException("null == BioServiceManager.getCurrentInstance()");
            ((BioFragmentContainer) activity).sendResponse(206);
            finish();
            return;
        }
        try {
            this.mBioFragmentCallBack = (BioFragmentCallBack) activity;
        } catch (ClassCastException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(activity.toString());
            sb.append(" must BioFragmentService");
            throw new ClassCastException(sb.toString());
        }
    }

    protected <T> T getSystemService(Class<T> cls) {
        BioServiceManager bioServiceManager = this.mBioServiceManager;
        if (bioServiceManager == null) {
            throw new BioObjectNotInitialException("");
        }
        return (T) bioServiceManager.getBioService(cls);
    }

    protected <T> T getExtService(Class<T> cls) {
        BioServiceManager bioServiceManager = this.mBioServiceManager;
        if (bioServiceManager == null) {
            throw new BioObjectNotInitialException("");
        }
        return (T) bioServiceManager.getBioService(cls);
    }

    public void backward() {
        BioFragmentCallBack bioFragmentCallBack = this.mBioFragmentCallBack;
        if (bioFragmentCallBack != null) {
            bioFragmentCallBack.backward(null);
        }
    }

    public void forward(BioFragment bioFragment) {
        BioFragmentCallBack bioFragmentCallBack = this.mBioFragmentCallBack;
        if (bioFragmentCallBack != null) {
            bioFragmentCallBack.forward(null, bioFragment);
        }
    }

    protected void finish() {
        BioFragmentCallBack bioFragmentCallBack = this.mBioFragmentCallBack;
        if (bioFragmentCallBack != null) {
            bioFragmentCallBack.finish(null);
        }
    }
}
