package com.otaliastudios.cameraview.internal.utils;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.google.firebase.messaging.Constants;

/* loaded from: classes2.dex */
public class OrientationHelper {
    public final Context BuiltInFictitiousFunctionClassFactory;
    public final OrientationEventListener PlaceComponentResult;
    public final DisplayManager.DisplayListener getAuthRequestContext;
    private final Callback moveToNextValue;
    public int MyBillsEntityDataFactory = -1;
    public int KClassImpl$Data$declaredNonStaticMembers$2 = -1;

    /* loaded from: classes8.dex */
    public interface Callback {
        void KClassImpl$Data$declaredNonStaticMembers$2(int i);

        void MyBillsEntityDataFactory(int i, boolean z);
    }

    public OrientationHelper(Context context, Callback callback) {
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.moveToNextValue = callback;
        this.PlaceComponentResult = new OrientationEventListener(context.getApplicationContext()) { // from class: com.otaliastudios.cameraview.internal.utils.OrientationHelper.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                int i2 = 0;
                if (i == -1) {
                    if (OrientationHelper.this.MyBillsEntityDataFactory != -1) {
                        i2 = OrientationHelper.this.MyBillsEntityDataFactory;
                    }
                } else if (i < 315 && i >= 45) {
                    if (i >= 45 && i < 135) {
                        i2 = 90;
                    } else if (i >= 135 && i < 225) {
                        i2 = 180;
                    } else if (i >= 225 && i < 315) {
                        i2 = 270;
                    }
                }
                if (i2 != OrientationHelper.this.MyBillsEntityDataFactory) {
                    OrientationHelper.this.MyBillsEntityDataFactory = i2;
                    OrientationHelper.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(OrientationHelper.this.MyBillsEntityDataFactory);
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 17) {
            this.getAuthRequestContext = new DisplayManager.DisplayListener() { // from class: com.otaliastudios.cameraview.internal.utils.OrientationHelper.2
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i) {
                    int i2 = OrientationHelper.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    int KClassImpl$Data$declaredNonStaticMembers$2 = OrientationHelper.this.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (KClassImpl$Data$declaredNonStaticMembers$2 != i2) {
                        OrientationHelper.this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
                        OrientationHelper.this.moveToNextValue.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, Math.abs(KClassImpl$Data$declaredNonStaticMembers$2 - i2) != 180);
                    }
                }
            };
        } else {
            this.getAuthRequestContext = null;
        }
    }

    public final void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (Build.VERSION.SDK_INT >= 17) {
            ((DisplayManager) this.BuiltInFictitiousFunctionClassFactory.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)).registerDisplayListener(this.getAuthRequestContext, null);
        }
        this.PlaceComponentResult.enable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int KClassImpl$Data$declaredNonStaticMembers$2() {
        int rotation = ((WindowManager) this.BuiltInFictitiousFunctionClassFactory.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                return rotation != 3 ? 0 : 270;
            }
            return 180;
        }
        return 90;
    }
}
