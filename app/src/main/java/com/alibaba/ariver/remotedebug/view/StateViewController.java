package com.alibaba.ariver.remotedebug.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.R;
import com.alibaba.ariver.remotedebug.core.RemoteDebugController;
import com.alibaba.ariver.remotedebug.core.RemoteDebugViewProxy;
import com.alibaba.ariver.remotedebug.core.state.RemoteDebugState;
import com.alibaba.ariver.remotedebug.extension.RemoteDebugStatePoint;

/* loaded from: classes6.dex */
public class StateViewController implements ActionEventListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6194a = "StateViewController";
    private Activity c;
    private IDebugStateView d;
    private IDebugInfoPanelView e;
    private RemoteDebugController.RemoteDebugExitClickListener h;
    private App i;
    private Dialog j;
    private boolean g = false;
    private RemoteDebugState b = RemoteDebugState.STATE_NON_REMOTE_DEBUG;
    private RemoteDebugViewProxy f = (RemoteDebugViewProxy) RVProxy.get(RemoteDebugViewProxy.class);

    public StateViewController(App app, RemoteDebugController.RemoteDebugExitClickListener remoteDebugExitClickListener) {
        this.i = app;
        this.h = remoteDebugExitClickListener;
    }

    public void setContext(Activity activity) throws NullPointerException {
        if (activity == null) {
            throw new NullPointerException("activity cannot be null!");
        }
        this.c = activity;
        i();
        j();
    }

    public void notifyStateChanged(RemoteDebugState remoteDebugState) {
        String str = f6194a;
        StringBuilder sb = new StringBuilder();
        sb.append("notifyStateChanged...state:");
        sb.append(remoteDebugState);
        sb.append(", old state: ");
        sb.append(this.b);
        RVLogger.d(str, sb.toString());
        if (this.b == remoteDebugState) {
            return;
        }
        this.b = remoteDebugState;
        switch (AnonymousClass10.$SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState[remoteDebugState.ordinal()]) {
            case 1:
                a();
                return;
            case 2:
                b();
                return;
            case 3:
                c();
                return;
            case 4:
                h();
                return;
            case 5:
                d();
                return;
            case 6:
                e();
                return;
            case 7:
                f();
                return;
            case 8:
                g();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.ariver.remotedebug.view.StateViewController$10  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState;

        static {
            int[] iArr = new int[RemoteDebugState.values().length];
            $SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState = iArr;
            try {
                iArr[RemoteDebugState.STATE_CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState[RemoteDebugState.STATE_CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState[RemoteDebugState.STATE_CONNECT_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState[RemoteDebugState.STATE_NETWORK_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState[RemoteDebugState.STATE_REMOTE_DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState[RemoteDebugState.STATE_HIT_BREAKPOINT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState[RemoteDebugState.STATE_RELEASE_BREAKPOINT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$remotedebug$core$state$RemoteDebugState[RemoteDebugState.STATE_EXITED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private void a() {
        if (this.b != RemoteDebugState.STATE_CONNECTING) {
            RVLogger.d(f6194a, "remoteDebugConnecting...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.StateViewController.1
                @Override // java.lang.Runnable
                public void run() {
                    StateViewController.this.e.setStateConnecting();
                }
            });
        }
    }

    private void b() {
        if (this.b != RemoteDebugState.STATE_CONNECTED) {
            RVLogger.d(f6194a, "remoteDebugConnected...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.StateViewController.2
                @Override // java.lang.Runnable
                public void run() {
                    StateViewController.this.e.setStateConnected();
                }
            });
        }
    }

    private void c() {
        if (this.b != RemoteDebugState.STATE_CONNECT_FAILED) {
            RVLogger.d(f6194a, "remoteDebugConnectFailed...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.StateViewController.3
                @Override // java.lang.Runnable
                public void run() {
                    if (StateViewController.this.d == null) {
                        StateViewController.this.d = new RemoteDebugStateView(StateViewController.this.c);
                        StateViewController.this.d.setActionEventListener(StateViewController.this);
                    }
                    StateViewController.this.d.setStateText(StateViewController.this.c.getString(R.string.tiny_remote_debug_connect_interrupt));
                    StateViewController.this.d.setShown(true);
                    StateViewController.this.e.setStateConnectFailed();
                }
            });
        }
    }

    private void d() {
        if (this.b != RemoteDebugState.STATE_REMOTE_DISCONNECTED) {
            RVLogger.d(f6194a, "remoteDisconnected...state error");
        } else if (((RemoteDebugStatePoint) ExtensionPoint.as(RemoteDebugStatePoint.class).create()).onDisconnected(this.i)) {
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.StateViewController.4
                @Override // java.lang.Runnable
                public void run() {
                    StateViewController.this.g = true;
                    if (StateViewController.this.d == null) {
                        StateViewController.this.d = new RemoteDebugStateView(StateViewController.this.c);
                        StateViewController.this.d.setActionEventListener(StateViewController.this);
                    }
                    StateViewController.this.d.setStateText(StateViewController.this.c.getResources().getString(R.string.tiny_remote_debug_connect_interrupt));
                    StateViewController.this.d.setShown(true);
                }
            });
        }
    }

    private void e() {
        if (this.b != RemoteDebugState.STATE_HIT_BREAKPOINT) {
            RVLogger.d(f6194a, "hitBreakpoint...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.StateViewController.5
                @Override // java.lang.Runnable
                public void run() {
                    if (StateViewController.this.d == null) {
                        StateViewController.this.d = new RemoteDebugStateView(StateViewController.this.c);
                        StateViewController.this.d.setActionEventListener(StateViewController.this);
                    }
                    StateViewController.this.d.setStateText(StateViewController.this.c.getResources().getString(R.string.tiny_remote_debug_hit_break_point));
                    StateViewController.this.d.setShown(true);
                }
            });
        }
    }

    private void f() {
        if (this.b != RemoteDebugState.STATE_RELEASE_BREAKPOINT) {
            RVLogger.d(f6194a, "releaseBreakpoint...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.StateViewController.6
                @Override // java.lang.Runnable
                public void run() {
                    if (StateViewController.this.d != null) {
                        StateViewController.this.d.setShown(false);
                    }
                }
            });
        }
    }

    private void g() {
        if (this.b != RemoteDebugState.STATE_EXITED) {
            RVLogger.d(f6194a, "exitDebugMode...state error");
            return;
        }
        RemoteDebugController.RemoteDebugExitClickListener remoteDebugExitClickListener = this.h;
        if (remoteDebugExitClickListener != null) {
            remoteDebugExitClickListener.onRemoteDebugExitClick();
        }
    }

    private void h() {
        if (this.b != RemoteDebugState.STATE_NETWORK_UNAVAILABLE) {
            RVLogger.d(f6194a, "handleNetworkUnavailable...state error");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.remotedebug.view.StateViewController.7
                @Override // java.lang.Runnable
                public void run() {
                    if (StateViewController.this.d == null) {
                        StateViewController.this.d = new RemoteDebugStateView(StateViewController.this.c);
                        StateViewController.this.d.setActionEventListener(StateViewController.this);
                    }
                    StateViewController.this.d.setStateText(StateViewController.this.c.getResources().getString(R.string.tiny_remote_debug_no_network));
                    StateViewController.this.d.setShown(true);
                }
            });
        }
    }

    @Override // com.alibaba.ariver.remotedebug.view.ActionEventListener
    public void exitRemoteDebug() {
        if (this.g) {
            notifyStateChanged(RemoteDebugState.STATE_EXITED);
        } else {
            k();
        }
    }

    private void i() {
        App app;
        Activity activity = this.c;
        if (activity == null || (app = this.i) == null) {
            return;
        }
        IDebugInfoPanelView createDebugInfoPanelView = this.f.createDebugInfoPanelView(activity, app);
        this.e = createDebugInfoPanelView;
        createDebugInfoPanelView.setActionEventListener(this);
        this.f.addDebugInfoPanelToUI(this.c, this.i, this.e);
    }

    private void j() {
        App app;
        Activity activity = this.c;
        if (activity == null || (app = this.i) == null) {
            return;
        }
        IDebugStateView createDebugStateView = this.f.createDebugStateView(activity, app);
        this.d = createDebugStateView;
        createDebugStateView.setActionEventListener(this);
        this.d.setShown(false);
        this.f.addDebugStateViewToUI(this.c, this.i, this.d);
    }

    private void k() {
        Dialog dialog = this.j;
        if (dialog != null) {
            dialog.show();
            return;
        }
        DialogPoint dialogPoint = (DialogPoint) ExtensionPoint.as(DialogPoint.class).node(this.i).create();
        Resources resources = this.c.getResources();
        CreateDialogParam createDialogParam = new CreateDialogParam(resources.getString(R.string.tiny_remote_debug_exit_dialog_title), null, resources.getString(R.string.tiny_remote_debug_exit_confirm), resources.getString(R.string.tiny_remote_debug_exit_cancel), null);
        createDialogParam.cancelable = false;
        createDialogParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.StateViewController.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (StateViewController.this.j != null) {
                    StateViewController.this.j.dismiss();
                }
            }
        };
        createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.StateViewController.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (StateViewController.this.j != null) {
                    StateViewController.this.notifyStateChanged(RemoteDebugState.STATE_EXITED);
                }
            }
        };
        Dialog createDialog = dialogPoint.createDialog(this.c, createDialogParam);
        this.j = createDialog;
        createDialog.show();
    }
}
