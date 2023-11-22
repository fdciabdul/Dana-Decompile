package com.alibaba.ariver.app.api.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.R;
import com.alibaba.ariver.app.api.activity.AnimUtils;
import com.alibaba.ariver.app.api.point.fragment.FragmentPausePoint;
import com.alibaba.ariver.app.api.point.fragment.FragmentResumePoint;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.app.api.ui.RVViewFactory;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.ViewUtils;
import com.alibaba.ariver.app.api.ui.loading.LoadingView;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.ipc.RemoteCallClient;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.EventTrackStore;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes3.dex */
public class RVFragment extends Fragment implements PageContext {
    public static final byte[] $$a = {119, -93, -18, -42, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 164;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {63, Ascii.SUB, 111, -17, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 130;
    public static final String TRANSLATE_IN_LEFT_ID = "ariver_fragment_translate_in_left";
    public static final String TRANSLATE_IN_RIGHT_ID = "ariver_fragment_translate_in_right";
    public static final String TRANSLATE_OUT_LEFT_ID = "ariver_fragment_translate_out_left";
    public static final String TRANSLATE_OUT_RIGHT_ID = "ariver_fragment_translate_out_right";

    /* renamed from: a */
    private Page f5976a;
    private LoadingView b;
    private RelativeLayout c;
    private PageContainer d;
    private ErrorView e;
    private TitleBar f;
    private ViewSpecProvider g;
    private IEmbedViewManager h;
    private Page i = null;
    private final List<FragmentLifecycleListener> j = new ArrayList();
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private long n = 0;

    /* renamed from: o */
    private boolean f5977o = false;

    /* loaded from: classes3.dex */
    public static class FragmentLifecycleListener {
        public void onAttach(Context context, FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onCreate(Bundle bundle, FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onDestroy(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onDetach(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void p(int r5, short r6, short r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 + 4
            int r6 = r6 * 4
            int r6 = r6 + 16
            byte[] r0 = com.alibaba.ariver.app.api.ui.fragment.RVFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = 106 - r7
            byte[] r1 = new byte[r6]
            r2 = -1
            int r6 = r6 + r2
            if (r0 != 0) goto L17
            r7 = r5
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r6
            goto L37
        L17:
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L1b:
            int r2 = r2 + 1
            byte r3 = (byte) r5
            r1[r2] = r3
            if (r2 != r7) goto L2b
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2b:
            int r6 = r6 + 1
            r3 = r0[r6]
            r4 = r7
            r7 = r6
            r6 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r4
        L37:
            int r5 = r5 + r6
            int r5 = r5 + 2
            r6 = r7
            r7 = r8
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ui.fragment.RVFragment.p(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void q(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 4
            int r8 = r8 * 4
            int r8 = r8 + 75
            int r6 = r6 * 3
            int r6 = r6 + 42
            byte[] r0 = com.alibaba.ariver.app.api.ui.fragment.RVFragment.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r8
            r3 = 0
            r8 = r7
            goto L31
        L19:
            r3 = 0
        L1a:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
        L31:
            int r7 = r7 + 1
            int r4 = -r4
            int r8 = r8 + r4
            int r8 = r8 + (-7)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ui.fragment.RVFragment.q(short, int, byte, java.lang.Object[]):void");
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public boolean isAlreadyScheduleAdded() {
        return this.m;
    }

    public void setAlreadyScheduleAdded(boolean z) {
        this.m = z;
    }

    public Page getPage() {
        return this.f5976a;
    }

    public void addLifeCycleListener(FragmentLifecycleListener fragmentLifecycleListener) {
        synchronized (this.j) {
            this.j.add(fragmentLifecycleListener);
        }
    }

    public void removeLifeCycleListener(FragmentLifecycleListener fragmentLifecycleListener) {
        synchronized (this.j) {
            this.j.remove(fragmentLifecycleListener);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            Object[] objArr = new Object[1];
            p(14, b, b, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr2 = new Object[1];
            p(b2, (byte) (b2 + 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 494, 4 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) ExpandableListView.getPackedPositionGroup(0L));
                    byte b3 = (byte) ($$a[4] - 1);
                    byte b4 = b3;
                    Object[] objArr4 = new Object[1];
                    q(b3, b4, b4, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1955435363, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                super.onCreate(bundle);
                StringBuilder sb = new StringBuilder();
                sb.append("onCreate ");
                sb.append(this);
                RVLogger.d("AriverApp:RVFragment", sb.toString());
                synchronized (this.j) {
                    Iterator<FragmentLifecycleListener> it = this.j.iterator();
                    while (it.hasNext()) {
                        it.next().onCreate(bundle, getFragmentManager(), this);
                    }
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context != null && !ProcessUtils.isMainProcess()) {
            RemoteCallClient.bindContext(context);
        }
        synchronized (this.j) {
            Iterator<FragmentLifecycleListener> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().onAttach(context, getFragmentManager(), this);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        StringBuilder sb = new StringBuilder();
        sb.append("onDetach ");
        sb.append(this);
        RVLogger.d("AriverApp:RVFragment", sb.toString());
        synchronized (this.j) {
            Iterator<FragmentLifecycleListener> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().onDetach(getFragmentManager(), this);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        StringBuilder sb = new StringBuilder();
        sb.append("onDestroyView ");
        sb.append(this);
        RVLogger.d("AriverApp:RVFragment", sb.toString());
    }

    public RelativeLayout getRootView() {
        return this.c;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        App app;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_onCreateView);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onCreateView ");
            sb.append(this);
            RVLogger.d("AriverApp:RVFragment", sb.toString());
            Page page = this.f5976a;
            if (page == null || !page.isExited()) {
                RelativeLayout relativeLayout = this.c;
                if (relativeLayout != null) {
                    ViewParent parent = relativeLayout.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).endViewTransition(this.c);
                        ((ViewGroup) parent).removeAllViews();
                    }
                    return this.c;
                }
                long j = BundleUtils.getLong(getArguments(), RVConstants.EXTRA_APP_INSTANCE_ID, 0L);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onCreateView with appInstanceId: ");
                sb2.append(j);
                RVLogger.d("AriverApp:RVFragment", sb2.toString());
                if (j != 0) {
                    app = ((AppManager) RVProxy.get(AppManager.class)).findApp(j);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("findApp: ");
                    sb3.append(app);
                    RVLogger.d("AriverApp:RVFragment", sb3.toString());
                } else {
                    app = null;
                }
                if (app != null && app.getAppContext() != null) {
                    RelativeLayout relativeLayout2 = new RelativeLayout(getActivity());
                    this.c = relativeLayout2;
                    relativeLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.c.setBackgroundColor(0);
                    if (!BundleUtils.getBoolean(app.getStartParams(), RVStartParams.KEY_TRANSPARENT, false)) {
                        this.c.setBackgroundColor(-1);
                    }
                    this.g = ((AppUIContext) app.getAppContext()).getViewSpecProvider();
                    PageContainer createPageContainer = ((RVViewFactory) RVProxy.get(RVViewFactory.class)).createPageContainer(getActivity(), app, viewGroup);
                    this.d = createPageContainer;
                    createPageContainer.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.specToLayoutParam(this.g.getHeightSpec())));
                    long j2 = BundleUtils.getLong(getArguments(), RVConstants.EXTRA_PAGE_INSTANCE_ID, -1L);
                    if (j2 > 0) {
                        this.f = ((RVViewFactory) RVProxy.get(RVViewFactory.class)).createTitleBar(getActivity(), getPage(app, j2), app);
                    } else {
                        this.f = ((RVViewFactory) RVProxy.get(RVViewFactory.class)).createTitleBar(getActivity(), null, app);
                    }
                    TitleBar titleBar = this.f;
                    if (titleBar != null && titleBar.getContent() != null) {
                        RVLogger.d("AriverApp:RVFragment", "add nav bar");
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.addRule(10);
                        this.c.addView(this.f.getContent(), 0, layoutParams);
                    }
                    if (j2 > 0) {
                        Page page2 = getPage(app, j2);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("setPage in fragment onCreateView: ");
                        sb4.append(page2);
                        sb4.append(", ");
                        sb4.append(this);
                        RVLogger.d("AriverApp:RVFragment", sb4.toString());
                        if (page2 == null || page2.isExited()) {
                            RVLogger.w("AriverApp:RVFragment", "mPage already existed!");
                        } else {
                            setPage(page2);
                        }
                    }
                    return this.c;
                }
                return new FrameLayout(getActivity());
            }
            return null;
        } finally {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_onCreateView);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.n = SystemClock.elapsedRealtime();
        Page page = this.i;
        if (page != null) {
            setPage(page);
            this.i = null;
        }
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public PageContainer getPageContainer() {
        return this.d;
    }

    public Page getPage(App app, long j) {
        Page pageByNodeId = app.getPageByNodeId(j);
        if (pageByNodeId != null) {
            return pageByNodeId;
        }
        return null;
    }

    public void setPage(final Page page) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.api.ui.fragment.RVFragment.1
            {
                RVFragment.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RVFragment.this.c != null) {
                    RVFragment.this.a(page);
                    return;
                }
                RVFragment.this.i = page;
            }
        });
    }

    public void a(final Page page) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_bindContext);
        try {
            if (this.f5976a != null) {
                RVLogger.e("AriverApp:RVFragment", "cannot attachPage twice in NebulaFragment!");
                return;
            }
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_FragmentOnViewCreated, this.n);
            this.f5976a = page;
            this.b = ((RVViewFactory) RVProxy.get(RVViewFactory.class)).createLoadingView(getActivity(), page);
            page.bindContext(this);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_bindContext);
            if (page.getRender() != null) {
                b(page);
            } else {
                page.addRenderReadyListener(new Page.RenderReadyListener() { // from class: com.alibaba.ariver.app.api.ui.fragment.RVFragment.2
                    {
                        RVFragment.this = this;
                    }

                    @Override // com.alibaba.ariver.app.api.Page.RenderReadyListener
                    public void onRenderReady() {
                        RVFragment.this.b(page);
                    }
                });
            }
        } finally {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_bindContext);
        }
    }

    public void b(Page page) {
        boolean z;
        try {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_UICreate);
            this.d.attachPage(page);
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_PageShow);
            ((EventTrackStore) page.getData(EventTrackStore.class, true)).whiteScreenAttrMap.put(TrackId.Stub_PageShow, Long.valueOf(SystemClock.elapsedRealtime()));
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_applyTransparentTitle);
            if (!BundleUtils.getBoolean(page.getStartParams(), RVStartParams.KEY_TRANSPARENT, false)) {
                if (page.getStartParams() == null || !page.getStartParams().containsKey("transparentTitle")) {
                    z = false;
                } else {
                    z = ViewUtils.isTransparentTitle(page.getStartParams(), BundleUtils.getString(page.getStartParams(), "transparentTitle"));
                }
                applyTransparentTitle(z);
            }
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_applyTransparentTitle);
            ViewGroup view = this.d.getView();
            this.d.addRenderView(page.getRender().getView());
            this.c.addView(view, 0);
            if (this.f != null) {
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_titleBarAttachPage);
                this.f.attachPage(page);
                RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_titleBarAttachPage);
            }
            Page page2 = this.f5976a;
            if (page2 != null) {
                ParamUtils.processTransparent(page2.getStartParams());
            }
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_pageEnter);
            page.enter();
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_pageEnter);
        } finally {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_UICreate);
        }
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public void applyTransparentTitle(boolean z) {
        ViewGroup view = this.d.getView();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.specToLayoutParam(-1), ViewUtils.specToLayoutParam(this.g.getPageHeightSpec(z)));
        if (z) {
            RVLogger.d("AriverApp:RVFragment", "transTitle: true");
            layoutParams.addRule(6);
            layoutParams.height = ViewUtils.specToLayoutParam(this.g.getHeightSpec());
        } else {
            TitleBar titleBar = this.f;
            if (titleBar != null && titleBar.getContent() != null) {
                layoutParams.addRule(3, this.f.getContent().getId());
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void setShouldResumeWebView(boolean z) {
        this.f5977o = z;
    }

    public void pauseRender() {
        Page page = this.f5976a;
        if (page == null || page.getRender() == null) {
            return;
        }
        this.f5976a.getRender().onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        int animResId = AnimUtils.getAnimResId(getActivity(), TRANSLATE_IN_RIGHT_ID);
        if (animResId == 0) {
            animResId = R.anim.ariver_fragment_translate_in_right_default;
        }
        if (animResId == i2) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), i2);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.alibaba.ariver.app.api.ui.fragment.RVFragment.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                {
                    RVFragment.this = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RVLogger.d("AriverApp:RVFragment", "onAnimationEnd");
                    if (RVFragment.this.f5976a == null || !RVFragment.this.f5977o || RVFragment.this.f5976a.getRender() == null) {
                        return;
                    }
                    RVFragment.this.f5977o = false;
                    RVFragment.this.f5976a.getRender().onResume();
                }
            });
            return loadAnimation;
        }
        return super.onCreateAnimation(i, z, i2);
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public IEmbedViewManager getEmbedViewManager() {
        IEmbedViewManager iEmbedViewManager;
        synchronized (this) {
            if (this.h == null) {
                this.h = new DefaultEmbedViewManager(this.f5976a);
            }
            iEmbedViewManager = this.h;
        }
        return iEmbedViewManager;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        StringBuilder sb = new StringBuilder();
        sb.append("onStart ");
        sb.append(this);
        RVLogger.d("AriverApp:RVFragment", sb.toString());
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_onStart);
        super.onStart();
        this.l = true;
        if (!this.k) {
            this.k = true;
        } else {
            Page page = this.f5976a;
            if (page != null && !page.isExited()) {
                TitleBar titleBar = this.f;
                if (titleBar != null) {
                    titleBar.onPageResume();
                }
                this.f5976a.resume();
            }
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_onStart);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        StringBuilder sb = new StringBuilder();
        sb.append("pause ");
        sb.append(this);
        RVLogger.d("AriverApp:RVFragment", sb.toString());
        super.onPause();
        ((FragmentPausePoint) ExtensionPoint.as(FragmentPausePoint.class).node(this.f5976a).create()).onPause(this.f5976a, this);
        this.l = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        StringBuilder sb = new StringBuilder();
        sb.append("resume ");
        sb.append(this);
        RVLogger.d("AriverApp:RVFragment", sb.toString());
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_Fragment_onResume);
        ((FragmentResumePoint) ExtensionPoint.as(FragmentResumePoint.class).node(this.f5976a).create()).onResume(this.f5976a, this);
        super.onResume();
        Page page = this.f5976a;
        if (page != null && !page.isExited() && BundleUtils.getBoolean(this.f5976a.getStartParams(), "fullscreen", false) && !this.l) {
            TitleBar titleBar = this.f;
            if (titleBar != null) {
                titleBar.onPageResume();
            }
            this.f5976a.resume();
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_Fragment_onResume);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        StringBuilder sb = new StringBuilder();
        sb.append("onStop ");
        sb.append(this);
        RVLogger.d("AriverApp:RVFragment", sb.toString());
        super.onStop();
        Page page = this.f5976a;
        if (page == null || page.isExited()) {
            return;
        }
        this.f5976a.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StringBuilder sb = new StringBuilder();
        sb.append("onDestroy ");
        sb.append(this);
        RVLogger.d("AriverApp:RVFragment", sb.toString());
        super.onDestroy();
        synchronized (this.j) {
            Iterator<FragmentLifecycleListener> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().onDestroy(getFragmentManager(), this);
            }
        }
        if (this.k) {
            this.k = false;
            Page page = this.f5976a;
            if (page != null && !page.isExited()) {
                this.f5976a.exit(true);
            }
            TitleBar titleBar = this.f;
            if (titleBar != null) {
                titleBar.onDestroy();
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public ViewGroup getContentView() {
        PageContainer pageContainer = this.d;
        if (pageContainer == null) {
            return null;
        }
        return pageContainer.getView();
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public TitleBar getTitleBar() {
        return this.f;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public LoadingView getLoadingView() {
        return this.b;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public ErrorView getErrorView() {
        if (this.e == null) {
            RVViewFactory rVViewFactory = (RVViewFactory) RVProxy.get(RVViewFactory.class);
            if (rVViewFactory == null) {
                return null;
            }
            this.e = rVViewFactory.createErrorView(getActivity());
        }
        return this.e;
    }

    @Override // com.alibaba.ariver.app.api.PageContext
    public void destroy() {
        IEmbedViewManager embedViewManager = getEmbedViewManager();
        if (embedViewManager != null) {
            embedViewManager.releaseViews();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        DimensionUtil.resetDimensions();
        StringBuilder sb = new StringBuilder();
        sb.append("window resize onConfigurationChanged ");
        sb.append(configuration);
        RVLogger.d("AriverApp:RVFragment", sb.toString());
        FragmentActivity activity = getActivity();
        if (activity == null || this.f5976a == null || configuration == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("windowWidth", (Object) Integer.valueOf(DimensionUtil.dip2px(activity, configuration.screenWidthDp)));
        jSONObject.put("windowHeight", (Object) Integer.valueOf(DimensionUtil.dip2px(activity, configuration.screenHeightDp)));
        EngineUtils.sendToRender(this.f5976a.getRender(), RVEvents.WINDOW_RESIZE, jSONObject, null);
    }
}
