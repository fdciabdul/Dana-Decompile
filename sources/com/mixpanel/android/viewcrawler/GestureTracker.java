package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

/* loaded from: classes.dex */
public class GestureTracker {
    public GestureTracker(final MixpanelAPI mixpanelAPI, Activity activity) {
        activity.getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() { // from class: com.mixpanel.android.viewcrawler.GestureTracker.1
            private long moveToNextValue = -1;
            private long getErrorConfigVersion = -1;
            private int scheduleImpl = 0;
            private long NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
            private boolean lookAheadTest = false;
            private final int PlaceComponentResult = 100;
            private final int BuiltInFictitiousFunctionClassFactory = 1000;
            private final int KClassImpl$Data$declaredNonStaticMembers$2 = 2500;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getPointerCount() <= 2) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked != 0) {
                        if (actionMasked != 1) {
                            if (actionMasked != 5) {
                                if (actionMasked == 6) {
                                    if (!this.lookAheadTest) {
                                        this.getErrorConfigVersion = -1L;
                                        this.moveToNextValue = -1L;
                                        this.scheduleImpl = 0;
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1L;
                                        this.lookAheadTest = false;
                                    }
                                }
                            } else if (System.currentTimeMillis() - this.getErrorConfigVersion < 100) {
                                if (System.currentTimeMillis() - this.NetworkUserEntityData$$ExternalSyntheticLambda0 > 1000) {
                                    this.getErrorConfigVersion = -1L;
                                    this.moveToNextValue = -1L;
                                    this.scheduleImpl = 0;
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1L;
                                    this.lookAheadTest = false;
                                }
                                this.moveToNextValue = System.currentTimeMillis();
                                this.lookAheadTest = true;
                            } else {
                                this.getErrorConfigVersion = -1L;
                                this.moveToNextValue = -1L;
                                this.scheduleImpl = 0;
                                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1L;
                                this.lookAheadTest = false;
                            }
                        } else if (System.currentTimeMillis() - this.getErrorConfigVersion < 100) {
                            if (System.currentTimeMillis() - this.moveToNextValue >= 2500) {
                                if (this.scheduleImpl == 3) {
                                    mixpanelAPI.MyBillsEntityDataFactory("$ab_gesture1");
                                    this.getErrorConfigVersion = -1L;
                                    this.moveToNextValue = -1L;
                                    this.scheduleImpl = 0;
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1L;
                                    this.lookAheadTest = false;
                                }
                                this.scheduleImpl = 0;
                            } else {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = System.currentTimeMillis();
                                int i = this.scheduleImpl;
                                if (i < 4) {
                                    this.scheduleImpl = i + 1;
                                } else if (i == 4) {
                                    mixpanelAPI.MyBillsEntityDataFactory("$ab_gesture2");
                                    this.getErrorConfigVersion = -1L;
                                    this.moveToNextValue = -1L;
                                    this.scheduleImpl = 0;
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1L;
                                    this.lookAheadTest = false;
                                } else {
                                    this.getErrorConfigVersion = -1L;
                                    this.moveToNextValue = -1L;
                                    this.scheduleImpl = 0;
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1L;
                                    this.lookAheadTest = false;
                                }
                            }
                        }
                        return false;
                    }
                    this.getErrorConfigVersion = System.currentTimeMillis();
                    return false;
                }
                this.getErrorConfigVersion = -1L;
                this.moveToNextValue = -1L;
                this.scheduleImpl = 0;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1L;
                this.lookAheadTest = false;
                return false;
            }
        });
    }
}
