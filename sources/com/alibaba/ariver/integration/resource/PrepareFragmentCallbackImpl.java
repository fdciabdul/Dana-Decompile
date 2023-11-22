package com.alibaba.ariver.integration.resource;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;

/* loaded from: classes6.dex */
public class PrepareFragmentCallbackImpl extends PrepareCallbackImpl {

    /* renamed from: a  reason: collision with root package name */
    private Fragment f6064a;
    private RVMain.Callback b;

    public PrepareFragmentCallbackImpl(RVAppRecord rVAppRecord, PrepareContext prepareContext, RVMain.Callback callback) {
        super(rVAppRecord, prepareContext);
        this.b = callback;
    }

    @Override // com.alibaba.ariver.integration.resource.PrepareCallbackImpl, com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void startApp(PrepareCallbackParam prepareCallbackParam) {
        if ((this.mAlreadyStarted && this.f6064a != null) || this.mPrepareContext.getStartContext() == null || this.mAppRecord == null) {
            return;
        }
        this.mAlreadyStarted = true;
        final Intent intent = new Intent();
        intent.putExtra(RVConstants.EXTRA_ARIVER_START_BUNDLE, createStartClient(prepareCallbackParam));
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.integration.resource.PrepareFragmentCallbackImpl.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                PrepareFragmentCallbackImpl.this.f6064a = ((RVClientStarter) RVProxy.get(RVClientStarter.class)).createFragment(PrepareFragmentCallbackImpl.this.mPrepareContext.getStartContext(), PrepareFragmentCallbackImpl.this.mAppRecord, intent.getExtras());
                PrepareFragmentCallbackImpl.this.mAppRecord.setActivityClz(PrepareFragmentCallbackImpl.this.mPrepareContext.getStartContext().getClass());
                if (PrepareFragmentCallbackImpl.this.b != null) {
                    PrepareFragmentCallbackImpl.this.b.onFragmentCreate(PrepareFragmentCallbackImpl.this.f6064a);
                }
            }
        });
    }
}
