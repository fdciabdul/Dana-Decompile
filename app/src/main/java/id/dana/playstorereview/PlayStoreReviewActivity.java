package id.dana.playstorereview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPlayStoreReviewComponent;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.domain.playstorereview.PlayStoreReviewActionKey;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.util.RaspUtils;
import id.dana.utils.showcase.Utils;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.getCallingPid;
import o.getOnBoardingScenario;

/* loaded from: classes9.dex */
public class PlayStoreReviewActivity extends BaseActivity {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int DatabaseTableConfigUtil;
    private static final long NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static char lookAheadTest;
    private static char[] scheduleImpl;
    @BindView(R.id.cl_dialog)
    ConstraintLayout clDialog;
    @BindView(R.id.main_root)
    ConstraintLayout clMainRoot;
    @Inject
    PlayStoreReviewContract.Presenter presenter;
    public static final byte[] $$a = {75, -23, 102, -23, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 252;
    private static int GetContactSyncConfig = 0;
    private static long getErrorConfigVersion = 5953725258592892227L;
    public static final byte[] PlaceComponentResult = {18, -87, -121, -123, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 205;

    static void BuiltInFictitiousFunctionClassFactory() {
        int i = GetContactSyncConfig + 105;
        DatabaseTableConfigUtil = i % 128;
        int i2 = i % 2;
        lookAheadTest = (char) 42066;
        scheduleImpl = new char[]{37375, 37282, 37348, 37280, 37369, 37283, 37311, 37286, 37291, 37305, 37309, 37372, 37371, 37308, 37310, 37287, 37347, 37351, 37367, 37289, 37281, 37279, 37357, 37359, 37293, 37374, 37350, 37344, 37353, 37294, 37262, 37275, 37290, 37307, 37288, 37370, 37274, 37345, 37368, 37358, 37366, 37356, 37346, 37306, 37365, 37292, 37302, 37373, 37349};
        int i3 = DatabaseTableConfigUtil + 1;
        GetContactSyncConfig = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0049 -> B:24:0x004e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r8, int r9, int r10, java.lang.Object[] r11) {
        /*
            int r0 = id.dana.playstorereview.PlayStoreReviewActivity.GetContactSyncConfig
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.playstorereview.PlayStoreReviewActivity.DatabaseTableConfigUtil = r1
            int r0 = r0 % 2
            int r8 = r8 + 4
            int r9 = 106 - r9
            int r10 = r10 + 16
            byte[] r0 = id.dana.playstorereview.PlayStoreReviewActivity.PlaceComponentResult
            byte[] r1 = new byte[r10]
            r2 = -1
            int r10 = r10 + r2
            r3 = 18
            if (r0 != 0) goto L1d
            r4 = 18
            goto L1f
        L1d:
            r4 = 93
        L1f:
            r5 = 0
            r6 = 1
            if (r4 == r3) goto L2c
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r11
            r11 = r10
            r7 = r9
            r9 = r8
            r8 = r7
            goto L4e
        L2c:
            int r3 = id.dana.playstorereview.PlayStoreReviewActivity.DatabaseTableConfigUtil     // Catch: java.lang.Exception -> L5f
            int r3 = r3 + 103
            int r4 = r3 % 128
            id.dana.playstorereview.PlayStoreReviewActivity.GetContactSyncConfig = r4     // Catch: java.lang.Exception -> L5f
            int r3 = r3 % 2
            if (r3 == 0) goto L3a
            r3 = 1
            goto L3b
        L3a:
            r3 = 0
        L3b:
            if (r3 == 0) goto L42
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L40
            goto L42
        L40:
            r8 = move-exception
            throw r8
        L42:
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r11
            r11 = r10
            r10 = r9
            r9 = r8
        L49:
            int r10 = -r10
            int r8 = r8 + r10
            int r9 = r9 + r6
            int r8 = r8 + (-4)
        L4e:
            int r3 = r3 + r6
            byte r10 = (byte) r8
            r2[r3] = r10
            if (r3 != r11) goto L5c
            java.lang.String r8 = new java.lang.String
            r8.<init>(r2, r5)
            r0[r5] = r8
            return
        L5c:
            r10 = r1[r9]
            goto L49
        L5f:
            r8 = move-exception
            goto L62
        L61:
            throw r8
        L62:
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.playstorereview.PlayStoreReviewActivity.a(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r6 = 47 - r6
            byte[] r0 = id.dana.playstorereview.PlayStoreReviewActivity.$$a
            int r7 = r7 * 2
            int r7 = r7 + 75
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
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.playstorereview.PlayStoreReviewActivity.b(short, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0090, code lost:
    
        if ((r4 <= 99999) != true) goto L14;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r26) {
        /*
            Method dump skipped, instructions count: 3008
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.playstorereview.PlayStoreReviewActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        int i = DatabaseTableConfigUtil + 35;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        int i = GetContactSyncConfig + 77;
        DatabaseTableConfigUtil = i % 128;
        int i2 = i % 2;
        Context applicationContext = super.getApplicationContext();
        int i3 = GetContactSyncConfig + 89;
        DatabaseTableConfigUtil = i3 % 128;
        int i4 = i3 % 2;
        return applicationContext;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        try {
            int i = GetContactSyncConfig + 119;
            DatabaseTableConfigUtil = i % 128;
            int i2 = i % 2;
            Context baseContext = super.getBaseContext();
            int i3 = GetContactSyncConfig + 9;
            DatabaseTableConfigUtil = i3 % 128;
            int i4 = i3 % 2;
            return baseContext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        int i = GetContactSyncConfig + 83;
        DatabaseTableConfigUtil = i % 128;
        if ((i % 2 == 0 ? 'b' : '`') != '`') {
            int i2 = 19 / 0;
        }
        int i3 = GetContactSyncConfig + 71;
        DatabaseTableConfigUtil = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 4 : '\n') != '\n') {
            Object[] objArr = null;
            int length = objArr.length;
            return R.layout.activity_play_store_review;
        }
        return R.layout.activity_play_store_review;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        try {
            int i = DatabaseTableConfigUtil + 49;
            GetContactSyncConfig = i % 128;
            if (i % 2 == 0) {
                return super.getResources();
            }
            Resources resources = super.getResources();
            Object[] objArr = null;
            int length = objArr.length;
            return resources;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if ((r0 == null ? 14 : 'C') != 'C') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        if ((r0 == null ? '\b' : kotlin.text.Typography.amp) != '&') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        r9 = new java.lang.Object[1];
        c((byte) (super.getResources().getString(id.dana.R.string.family_account_text_organizer_summary_btn_negative).substring(1, 2).length() + 4), new char[]{kotlin.text.Typography.quote, 15, '\t', 11, 0, '\n', '\t', kotlin.text.Typography.dollar, kotlin.text.Typography.quote, 1, 2, ')', 31, ',', 28, '\f', '\n', '\b', id.dana.cashier.view.InputCardNumberView.DIVIDER, '/', 29, 17, 11, 31, kotlin.text.Typography.dollar, 15}, super.getResources().getString(id.dana.R.string.merchant_info_twenty_four_hour_value).substring(0, 3).codePointAt(0) - 24, r9);
        r0 = java.lang.Class.forName((java.lang.String) r9[0]);
        r9 = new java.lang.Object[1];
        c((byte) (getPackageName().codePointAt(3) - 42), new char[]{'.', ',', 13858, 13858, kotlin.text.Typography.quote, 18, kotlin.text.Typography.quote, 31, 13860, 13860, 0, '\f', '+', 31, 28, '\f', 6, 17}, super.getResources().getString(id.dana.R.string.qr_profile_scanner_alert_message).substring(0, 1).length() + 17, r9);
        r0 = (android.content.Context) r0.getMethod((java.lang.String) r9[0], new java.lang.Class[0]).invoke(null, null);
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.playstorereview.PlayStoreReviewActivity.onResume():void");
    }

    static {
        DatabaseTableConfigUtil = 1;
        BuiltInFictitiousFunctionClassFactory();
        NetworkUserEntityData$$ExternalSyntheticLambda0 = System.currentTimeMillis();
        int i = GetContactSyncConfig + 69;
        DatabaseTableConfigUtil = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x010e, code lost:
    
        if ((r0 > 99999) != false) goto L18;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 1816
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.playstorereview.PlayStoreReviewActivity.onCreate(android.os.Bundle):void");
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        int i = DatabaseTableConfigUtil + 119;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        getAuthRequestContext();
        int i3 = GetContactSyncConfig + 43;
        DatabaseTableConfigUtil = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if ((r0 == null ? 5 : 28) != 5) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        r8 = new java.lang.Object[1];
        c((byte) ((android.view.ViewConfiguration.getTapTimeout() >> 16) + 5), new char[]{kotlin.text.Typography.quote, 15, '\t', 11, 0, '\n', '\t', kotlin.text.Typography.dollar, kotlin.text.Typography.quote, 1, 2, ')', 31, ',', 28, '\f', '\n', '\b', id.dana.cashier.view.InputCardNumberView.DIVIDER, '/', 29, 17, 11, 31, kotlin.text.Typography.dollar, 15}, getPackageName().length() + 19, r8);
        r0 = java.lang.Class.forName((java.lang.String) r8[0]);
        r9 = new java.lang.Object[1];
        c((byte) (57 - android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0')), new char[]{'.', ',', 13858, 13858, kotlin.text.Typography.quote, 18, kotlin.text.Typography.quote, 31, 13860, 13860, 0, '\f', '+', 31, 28, '\f', 6, 17}, 17 - android.os.Process.getGidForName(""), r9);
        r0 = (android.content.Context) r0.getMethod((java.lang.String) r9[0], new java.lang.Class[0]).invoke(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r0 == null) goto L18;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPause() {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.playstorereview.PlayStoreReviewActivity.onPause():void");
    }

    private void getAuthRequestContext() {
        DaggerPlayStoreReviewComponent.Builder PlaceComponentResult2 = DaggerPlayStoreReviewComponent.PlaceComponentResult();
        PlaceComponentResult2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult2.PlaceComponentResult = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(this)));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.PlaceComponentResult, PlayStoreReviewModules.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getAuthRequestContext, ApplicationComponent.class);
        new DaggerPlayStoreReviewComponent.PlayStoreReviewComponentImpl(PlaceComponentResult2.PlaceComponentResult, PlaceComponentResult2.getAuthRequestContext, (byte) 0).MyBillsEntityDataFactory(this);
        registerPresenter(this.presenter);
        int i = GetContactSyncConfig + 37;
        DatabaseTableConfigUtil = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.btn_play_store_review_yes})
    public void btnPlayStoreReviewYesClicked() {
        int i = GetContactSyncConfig + 37;
        DatabaseTableConfigUtil = i % 128;
        int i2 = i % 2;
        Utils.getAuthRequestContext((Activity) this);
        lookAheadTest();
        try {
            int i3 = GetContactSyncConfig + 77;
            try {
                DatabaseTableConfigUtil = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void lookAheadTest() {
        int i = GetContactSyncConfig + 61;
        DatabaseTableConfigUtil = i % 128;
        if ((i % 2 == 0 ? 'P' : (char) 21) != 'P') {
            getAuthRequestContext(PlayStoreReviewActionKey.OPEN);
            return;
        }
        getAuthRequestContext(PlayStoreReviewActionKey.OPEN);
        Object[] objArr = null;
        int length = objArr.length;
    }

    private void getAuthRequestContext(String str) {
        int i = DatabaseTableConfigUtil + 19;
        GetContactSyncConfig = i % 128;
        if (!(i % 2 == 0)) {
            this.presenter.BuiltInFictitiousFunctionClassFactory(str, System.currentTimeMillis(), NetworkUserEntityData$$ExternalSyntheticLambda0);
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            try {
                this.presenter.BuiltInFictitiousFunctionClassFactory(str, System.currentTimeMillis(), NetworkUserEntityData$$ExternalSyntheticLambda0);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i = DatabaseTableConfigUtil + 23;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        try {
            btnPlayStoreReviewNoClicked();
            int i3 = GetContactSyncConfig + 59;
            DatabaseTableConfigUtil = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.btn_play_store_review_no})
    public void btnPlayStoreReviewNoClicked() {
        int i = GetContactSyncConfig + 93;
        DatabaseTableConfigUtil = i % 128;
        if (i % 2 != 0) {
            getAuthRequestContext(PlayStoreReviewActionKey.SKIP);
            return;
        }
        getAuthRequestContext(PlayStoreReviewActionKey.SKIP);
        Object[] objArr = null;
        int length = objArr.length;
    }

    private boolean moveToNextValue() {
        Intent intent;
        boolean z;
        int i = GetContactSyncConfig + 11;
        DatabaseTableConfigUtil = i % 128;
        if ((i % 2 == 0 ? 'M' : Typography.quote) != 'M') {
            intent = getIntent();
            z = false;
        } else {
            intent = getIntent();
            z = true;
        }
        return intent.getBooleanExtra("in_app_review", z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        if (id.dana.utils.OSUtil.scheduleImpl() != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        if (moveToNextValue() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        r0 = new id.dana.playstorereview.AppReviewManager(r6, new id.dana.playstorereview.PlayStoreReviewActivity.AnonymousClass1(r6));
        r0.BuiltInFictitiousFunctionClassFactory.requestReviewFlow().addOnCompleteListener(new id.dana.playstorereview.AppReviewManager$$ExternalSyntheticLambda1(r0));
        lookAheadTest();
        r0 = id.dana.playstorereview.PlayStoreReviewActivity.GetContactSyncConfig + 89;
        id.dana.playstorereview.PlayStoreReviewActivity.DatabaseTableConfigUtil = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if ((r0 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r2 == true) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        r6.clMainRoot.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if ((r0) != true) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void PlaceComponentResult() {
        /*
            r6 = this;
            int r0 = id.dana.playstorereview.PlayStoreReviewActivity.DatabaseTableConfigUtil
            int r0 = r0 + 27
            int r1 = r0 % 128
            id.dana.playstorereview.PlayStoreReviewActivity.GetContactSyncConfig = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L20
            boolean r0 = id.dana.utils.OSUtil.scheduleImpl()
            r1.hashCode()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 == r3) goto L26
            goto L5e
        L1e:
            r0 = move-exception
            throw r0
        L20:
            boolean r0 = id.dana.utils.OSUtil.scheduleImpl()     // Catch: java.lang.Exception -> L64
            if (r0 == 0) goto L5e
        L26:
            boolean r0 = r6.moveToNextValue()
            if (r0 == 0) goto L5e
            id.dana.playstorereview.AppReviewManager r0 = new id.dana.playstorereview.AppReviewManager
            id.dana.playstorereview.PlayStoreReviewActivity$1 r4 = new id.dana.playstorereview.PlayStoreReviewActivity$1
            r4.<init>()
            r0.<init>(r6, r4)
            com.google.android.play.core.review.ReviewManager r4 = r0.BuiltInFictitiousFunctionClassFactory
            com.google.android.gms.tasks.Task r4 = r4.requestReviewFlow()
            id.dana.playstorereview.AppReviewManager$$ExternalSyntheticLambda1 r5 = new id.dana.playstorereview.AppReviewManager$$ExternalSyntheticLambda1
            r5.<init>()
            r4.addOnCompleteListener(r5)
            r6.lookAheadTest()
            int r0 = id.dana.playstorereview.PlayStoreReviewActivity.GetContactSyncConfig
            int r0 = r0 + 89
            int r4 = r0 % 128
            id.dana.playstorereview.PlayStoreReviewActivity.DatabaseTableConfigUtil = r4
            int r0 = r0 % 2
            if (r0 != 0) goto L54
            goto L55
        L54:
            r2 = 1
        L55:
            if (r2 == r3) goto L5d
            r1.hashCode()     // Catch: java.lang.Throwable -> L5b
            return
        L5b:
            r0 = move-exception
            throw r0
        L5d:
            return
        L5e:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r6.clMainRoot     // Catch: java.lang.Exception -> L64
            r0.setVisibility(r2)     // Catch: java.lang.Exception -> L64
            return
        L64:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.playstorereview.PlayStoreReviewActivity.PlaceComponentResult():void");
    }

    public static void aMBvRjvNlI(long j, long j2) {
        long j3 = j ^ (j2 << 32);
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        g(TextUtils.lastIndexOf("", '0') + 9872, new char[]{58473, 49889, 43384, 38850, 32262, 9451}, objArr);
        sb.append((String) objArr[0]);
        sb.append(j3);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
        RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
        Intrinsics.checkNotNullParameter(dexguardException, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(dexguardException);
        RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.HOOKED);
        UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.HOOKED);
        int i = DatabaseTableConfigUtil + 123;
        GetContactSyncConfig = i % 128;
        if ((i % 2 != 0 ? '\n' : '^') != '^') {
            int i2 = 90 / 0;
        }
    }

    private static void c(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = scheduleImpl;
        if ((cArr2 != null ? (char) 1 : '\b') == 1) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ lookAheadTest);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i4 = $11 + 123;
            $10 = i4 % 128;
            if ((i4 % 2 != 0 ? 'X' : (char) 11) != 11) {
                i2 = i + 67;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            }
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    int i5 = $11 + 75;
                    $10 = i5 % 128;
                    if (i5 % 2 != 0) {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory >>> b);
                        cArr4[getcallingpid.getAuthRequestContext >>> 1] = (char) (getcallingpid.PlaceComponentResult + b);
                    } else {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    }
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        int i6 = $10 + 97;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i10 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i11 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i10];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i11];
                    } else {
                        try {
                            try {
                                int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                                int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i14 = 0; i14 < i; i14++) {
            cArr4[i14] = (char) (cArr4[i14] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    private static void g(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        try {
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            int i2 = $11 + 45;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                    break;
                }
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getErrorConfigVersion ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            }
            char[] cArr2 = new char[length];
            try {
                getonboardingscenario.getAuthRequestContext = 0;
                int i4 = $10 + 25;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                while (true) {
                    if ((getonboardingscenario.getAuthRequestContext < cArr.length ? InputCardNumberView.DIVIDER : (char) 14) == ' ') {
                        cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                        getonboardingscenario.getAuthRequestContext++;
                    } else {
                        objArr[0] = new String(cArr2);
                        return;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
