package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.mixpanel.android.R;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.ViewUtils;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppFragment extends Fragment {
    public static final byte[] $$a = {116, -27, -60, 115, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 246;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {84, -107, -124, 66, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 207;
    private Activity GetContactSyncConfig;
    MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2;
    UpdateDisplayState.DisplayState.InAppNotificationState MyBillsEntityDataFactory;
    private AtomicBoolean NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicBoolean();
    private Runnable NetworkUserEntityData$$ExternalSyntheticLambda1;
    int PlaceComponentResult;
    private GestureDetector getErrorConfigVersion;
    private View lookAheadTest;
    private Runnable moveToNextValue;
    private Handler scheduleImpl;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r0 = com.mixpanel.android.mpmetrics.InAppFragment.BuiltInFictitiousFunctionClassFactory
            int r7 = 106 - r7
            int r6 = r6 * 15
            int r6 = 19 - r6
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L35:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r7 + 1
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.InAppFragment.a(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002d -> B:23:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r8 = r8 * 3
            int r8 = 4 - r8
            byte[] r0 = com.mixpanel.android.mpmetrics.InAppFragment.$$a
            int r7 = r7 * 3
            int r7 = r7 + 75
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L39
        L1c:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L20:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L39:
            int r6 = -r6
            int r8 = r8 + r6
            int r8 = r8 + (-7)
            int r6 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.InAppFragment.b(byte, int, short, java.lang.Object[]):void");
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.GetContactSyncConfig = activity;
        if (this.MyBillsEntityDataFactory == null) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            return;
        }
        this.scheduleImpl = new Handler();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Runnable() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.1
            {
                InAppFragment.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                InAppFragment.getAuthRequestContext(InAppFragment.this);
            }
        };
        this.moveToNextValue = new Runnable() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.2
            {
                InAppFragment.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                InAppFragment.this.lookAheadTest.setVisibility(0);
                InAppFragment.this.lookAheadTest.setOnTouchListener(new View.OnTouchListener() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.2.1
                    {
                        AnonymousClass2.this = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return InAppFragment.this.getErrorConfigVersion.onTouchEvent(motionEvent);
                    }
                });
                ImageView imageView = (ImageView) InAppFragment.this.lookAheadTest.findViewById(R.id.com_mixpanel_android_notification_image);
                float applyDimension = TypedValue.applyDimension(1, 65.0f, InAppFragment.this.GetContactSyncConfig.getResources().getDisplayMetrics());
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, applyDimension, 0.0f);
                translateAnimation.setInterpolator(new DecelerateInterpolator());
                translateAnimation.setDuration(200L);
                InAppFragment.this.lookAheadTest.startAnimation(translateAnimation);
                float f = applyDimension / 2.0f;
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, f, f);
                scaleAnimation.setInterpolator(new SineBounceInterpolator());
                scaleAnimation.setDuration(400L);
                scaleAnimation.setStartOffset(200L);
                imageView.startAnimation(scaleAnimation);
            }
        };
        this.getErrorConfigVersion = new GestureDetector(activity, new GestureDetector.OnGestureListener() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.3
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            {
                InAppFragment.this = this;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (f2 > 0.0f) {
                    InAppFragment.getAuthRequestContext(InAppFragment.this);
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                JSONObject jSONObject;
                MiniInAppNotification miniInAppNotification = (MiniInAppNotification) InAppFragment.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                String str = miniInAppNotification.GetContactSyncConfig;
                JSONObject jSONObject2 = null;
                if (str != null && str.length() > 0) {
                    try {
                        Uri parse = Uri.parse(str);
                        try {
                            InAppFragment.this.GetContactSyncConfig.startActivity(new Intent("android.intent.action.VIEW", parse));
                        } catch (ActivityNotFoundException unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("User doesn't have an activity for notification URI ");
                            sb.append(parse);
                            MPLog.MyBillsEntityDataFactory("MixpanelAPI.InAppFrag", sb.toString());
                        }
                        try {
                            jSONObject = new JSONObject();
                        } catch (JSONException unused2) {
                        }
                        try {
                            jSONObject.put("url", str);
                            jSONObject2 = jSONObject;
                        } catch (JSONException unused3) {
                            jSONObject2 = jSONObject;
                            MPLog.getAuthRequestContext("MixpanelAPI.InAppFrag", "Can't put url into json properties");
                            InAppFragment.this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2("$campaign_open", miniInAppNotification, jSONObject2);
                            InAppFragment.getAuthRequestContext(InAppFragment.this);
                            return true;
                        }
                    } catch (IllegalArgumentException e) {
                        MPLog.PlaceComponentResult("MixpanelAPI.InAppFrag", "Can't parse notification URI, will not take any action", e);
                        return true;
                    }
                }
                InAppFragment.this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2("$campaign_open", miniInAppNotification, jSONObject2);
                InAppFragment.getAuthRequestContext(InAppFragment.this);
                return true;
            }
        });
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = BuiltInFictitiousFunctionClassFactory[5];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 494, (KeyEvent.getMaxKeyCode() >> 16) + 4, (char) (KeyEvent.getMaxKeyCode() >> 16));
                    byte b5 = (byte) ($$a[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1929215237, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.set(false);
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

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.MyBillsEntityDataFactory == null) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            View inflate = layoutInflater.inflate(R.layout.com_mixpanel_android_activity_notification_mini, viewGroup, false);
            this.lookAheadTest = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.res_0x7f0a04f6_networkuserentitydata_externalsyntheticlambda0);
            ImageView imageView = (ImageView) this.lookAheadTest.findViewById(R.id.com_mixpanel_android_notification_image);
            MiniInAppNotification miniInAppNotification = (MiniInAppNotification) this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
            textView.setText(miniInAppNotification.BuiltInFictitiousFunctionClassFactory);
            textView.setTextColor(miniInAppNotification.getAuthRequestContext);
            imageView.setImageBitmap(miniInAppNotification.getErrorConfigVersion);
            this.scheduleImpl.postDelayed(this.NetworkUserEntityData$$ExternalSyntheticLambda1, 10000L);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(miniInAppNotification.PlaceComponentResult);
            gradientDrawable.setCornerRadius(ViewUtils.KClassImpl$Data$declaredNonStaticMembers$2(7.0f, getActivity()));
            gradientDrawable.setStroke((int) ViewUtils.KClassImpl$Data$declaredNonStaticMembers$2(2.0f, getActivity()), miniInAppNotification.moveToNextValue);
            if (Build.VERSION.SDK_INT < 16) {
                this.lookAheadTest.setBackgroundDrawable(gradientDrawable);
            } else {
                this.lookAheadTest.setBackground(gradientDrawable);
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion);
            bitmapDrawable.setColorFilter(miniInAppNotification.NetworkUserEntityData$$ExternalSyntheticLambda1, PorterDuff.Mode.SRC_ATOP);
            imageView.setImageDrawable(bitmapDrawable);
        }
        return this.lookAheadTest;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.get()) {
            this.GetContactSyncConfig.getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.scheduleImpl.postDelayed(this.moveToNextValue, 500L);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.get()) {
            Handler handler = this.scheduleImpl;
            if (handler != null) {
                handler.removeCallbacks(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                this.scheduleImpl.removeCallbacks(this.moveToNextValue);
            }
            UpdateDisplayState.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
            FragmentManager fragmentManager = this.GetContactSyncConfig.getFragmentManager();
            try {
                fragmentManager.beginTransaction().remove(this).commit();
            } catch (IllegalStateException unused) {
                fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.set(true);
    }

    /* loaded from: classes.dex */
    class SineBounceInterpolator implements Interpolator {
        public SineBounceInterpolator() {
            InAppFragment.this = r1;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return ((float) (-(Math.pow(2.718281828459045d, (-8.0f) * f) * Math.cos(f * 12.0f)))) + 1.0f;
        }
    }

    static /* synthetic */ void getAuthRequestContext(InAppFragment inAppFragment) {
        boolean isDestroyed = Build.VERSION.SDK_INT >= 17 ? inAppFragment.GetContactSyncConfig.isDestroyed() : false;
        Activity activity = inAppFragment.GetContactSyncConfig;
        if (activity == null || activity.isFinishing() || isDestroyed || inAppFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.get()) {
            return;
        }
        inAppFragment.scheduleImpl.removeCallbacks(inAppFragment.NetworkUserEntityData$$ExternalSyntheticLambda1);
        inAppFragment.scheduleImpl.removeCallbacks(inAppFragment.moveToNextValue);
        FragmentManager fragmentManager = inAppFragment.GetContactSyncConfig.getFragmentManager();
        try {
            fragmentManager.beginTransaction().setCustomAnimations(0, R.animator.res_0x7f020004_kclassimpl_data_declarednonstaticmembers_2).remove(inAppFragment).commit();
        } catch (IllegalStateException unused) {
            fragmentManager.beginTransaction().setCustomAnimations(0, R.animator.res_0x7f020004_kclassimpl_data_declarednonstaticmembers_2).remove(inAppFragment).commitAllowingStateLoss();
        }
        UpdateDisplayState.BuiltInFictitiousFunctionClassFactory(inAppFragment.PlaceComponentResult);
        inAppFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.set(true);
    }
}
