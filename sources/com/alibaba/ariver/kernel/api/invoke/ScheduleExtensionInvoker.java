package com.alibaba.ariver.kernel.api.invoke;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import com.alibaba.exthub.common.ExtHubLogger;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class ScheduleExtensionInvoker extends ExtensionInvoker {

    /* renamed from: a  reason: collision with root package name */
    private RVExecutorService f6097a;

    public ScheduleExtensionInvoker(ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.f6097a = (RVExecutorService) RVProxy.get(RVExecutorService.class);
    }

    public String getAppId() {
        try {
            return (String) ReflectUtils.invokeStaticMethod("com.alibaba.ariver.app.AppUtils", "getAppIdFromNode", new Class[]{Node.class}, new Object[]{this.targetNode});
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    protected ExtensionInvoker.InvokeResult onInvoke(final ImmutableList<Extension> immutableList, final Object obj, final Method method, final Object[] objArr) throws Throwable {
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadType threadType = (ThreadType) method.getAnnotation(ThreadType.class);
        ExecutorType value = threadType != null ? threadType.value() : ExecutorType.SYNC;
        if (threadType != null && ExecutorUtils.currentThreadInArray(threadType.transSyncThreadNames()) && !a()) {
            value = ExecutorType.SYNC;
        }
        int i = AnonymousClass3.$SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[value.ordinal()];
        boolean z = true;
        if (i == 1) {
            if (RVKernelUtils.isDebug()) {
                StringBuilder sb = new StringBuilder();
                sb.append("method ");
                sb.append(method);
                sb.append(" cost ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                ExtHubLogger.d("AriverKernel:ExtensionInvoker:Schedule", sb.toString());
            }
            return ExtensionInvoker.InvokeResult.proceed();
        } else if (i == 2) {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.kernel.api.invoke.ScheduleExtensionInvoker.1
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("method ");
                    sb2.append(method);
                    sb2.append(" cost ");
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    ExtHubLogger.d("AriverKernel:ExtensionInvoker:Schedule", sb2.toString());
                    ScheduleExtensionInvoker.this.proceedSafe(immutableList, obj, method, objArr);
                }
            });
            return ExtensionInvoker.InvokeResult.pending();
        } else {
            if (i == 3) {
                Class<?> cls = obj.getClass().getInterfaces().length > 0 ? obj.getClass().getInterfaces()[0] : null;
                if (cls == null || (!cls.getName().startsWith("com.alipay.mobile.nebulax") && !cls.getName().startsWith("com.alibaba.ariver"))) {
                    z = false;
                }
                if (!z) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("extension ");
                    sb2.append(obj);
                    sb2.append(" want to execute on URGENT_DISPLAY but not nebulax class!");
                    ExtHubLogger.w("AriverKernel:ExtensionInvoker:Schedule", sb2.toString());
                    value = ExecutorType.URGENT;
                }
            }
            this.f6097a.getExecutor(value).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.invoke.ScheduleExtensionInvoker.2
                @Override // java.lang.Runnable
                public void run() {
                    if (RVKernelUtils.isDebug()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("method ");
                        sb3.append(method);
                        sb3.append(" cost ");
                        sb3.append(System.currentTimeMillis() - currentTimeMillis);
                        sb3.append(" appId: ");
                        sb3.append(ScheduleExtensionInvoker.this.getAppId());
                        ExtHubLogger.d("AriverKernel:ExtensionInvoker:Schedule", sb3.toString());
                    }
                    ScheduleExtensionInvoker.this.proceedSafe(immutableList, obj, method, objArr);
                }
            });
            return ExtensionInvoker.InvokeResult.pending();
        }
    }

    /* renamed from: com.alibaba.ariver.kernel.api.invoke.ScheduleExtensionInvoker$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType;

        static {
            int[] iArr = new int[ExecutorType.values().length];
            $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType = iArr;
            try {
                iArr[ExecutorType.SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.UI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.URGENT_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean a() {
        return TextUtils.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_disable_trans_sync_thread", null), "yes");
    }
}
