package com.journeyapps.barcodescanner.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.fullstory.instrumentation.InstrumentInjector;
import com.journeyapps.barcodescanner.camera.AutoFocusManager;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class AutoFocusManager {
    private static final Collection<String> MyBillsEntityDataFactory;
    private static final String PlaceComponentResult = "AutoFocusManager";
    private final Camera BuiltInFictitiousFunctionClassFactory;
    private final Camera.AutoFocusCallback KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int getAuthRequestContext = 1;
    private boolean getErrorConfigVersion;
    private boolean lookAheadTest;
    private final Handler.Callback moveToNextValue;
    private Handler scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean MyBillsEntityDataFactory(AutoFocusManager autoFocusManager) {
        autoFocusManager.getErrorConfigVersion = false;
        return false;
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        MyBillsEntityDataFactory = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.journeyapps.barcodescanner.camera.AutoFocusManager$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements Camera.AutoFocusCallback {
        AnonymousClass2() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            AutoFocusManager.this.scheduleImpl.post(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.AutoFocusManager$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AutoFocusManager.AnonymousClass2 anonymousClass2 = AutoFocusManager.AnonymousClass2.this;
                    AutoFocusManager.MyBillsEntityDataFactory(AutoFocusManager.this);
                    AutoFocusManager.this.MyBillsEntityDataFactory();
                }
            });
        }
    }

    public AutoFocusManager(Camera camera, CameraSettings cameraSettings) {
        Handler.Callback callback = new Handler.Callback() { // from class: com.journeyapps.barcodescanner.camera.AutoFocusManager.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == AutoFocusManager.this.getAuthRequestContext) {
                    AutoFocusManager.this.PlaceComponentResult();
                    return true;
                }
                return false;
            }
        };
        this.moveToNextValue = callback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new AnonymousClass2();
        this.scheduleImpl = new Handler(callback);
        this.BuiltInFictitiousFunctionClassFactory = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = cameraSettings.BuiltInFictitiousFunctionClassFactory() && MyBillsEntityDataFactory.contains(focusMode);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        String str = PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append("Current focus mode '");
        sb.append(focusMode);
        sb.append("'; use auto focus? ");
        sb.append(z);
        InstrumentInjector.log_i(str, sb.toString());
        this.lookAheadTest = false;
        PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MyBillsEntityDataFactory() {
        synchronized (this) {
            if (!this.lookAheadTest && !this.scheduleImpl.hasMessages(this.getAuthRequestContext)) {
                Handler handler = this.scheduleImpl;
                handler.sendMessageDelayed(handler.obtainMessage(this.getAuthRequestContext), 2000L);
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        this.lookAheadTest = false;
        PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 || this.lookAheadTest || this.getErrorConfigVersion) {
            return;
        }
        try {
            this.BuiltInFictitiousFunctionClassFactory.autoFocus(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.getErrorConfigVersion = true;
        } catch (RuntimeException e) {
            InstrumentInjector.log_w(PlaceComponentResult, "Unexpected exception while focusing", e);
            MyBillsEntityDataFactory();
        }
    }

    public final void getAuthRequestContext() {
        this.lookAheadTest = true;
        this.getErrorConfigVersion = false;
        this.scheduleImpl.removeMessages(this.getAuthRequestContext);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            try {
                this.BuiltInFictitiousFunctionClassFactory.cancelAutoFocus();
            } catch (RuntimeException e) {
                InstrumentInjector.log_w(PlaceComponentResult, "Unexpected exception while cancelling focusing", e);
            }
        }
    }
}
