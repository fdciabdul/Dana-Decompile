package id.dana.feeds.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.contract.feeds.UserFeedsContract;
import id.dana.contract.feeds.UserFeedsModule;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFeedsComponent;
import id.dana.di.component.FeedsComponent;
import id.dana.feeds.FeedsAdapter;
import id.dana.feeds.model.ActivityModel;
import id.dana.feeds.model.FeedsModel;
import id.dana.utils.OSUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class UserFeedsActivity extends BaseActivity implements UserFeedsContract.View {
    private List<ActivityModel> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private FeedsAdapter NetworkUserEntityData$$ExternalSyntheticLambda2;
    private FeedsComponent getErrorConfigVersion;
    private String lookAheadTest;
    @Inject
    UserFeedsContract.Presenter presenter;
    @BindView(R.id.feeds_rcview)
    RecyclerView rcFeeds;
    private List<ActivityModel> scheduleImpl;
    public static final byte[] $$a = {107, 3, 14, 112, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 119;
    public static final byte[] getAuthRequestContext = {114, -79, -70, 22, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 7;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda1 = 13492;
    private static long DatabaseTableConfigUtil = -81983205400200948L;
    private static int initRecordTimeStamp = -956812108;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.feeds.views.UserFeedsActivity.getAuthRequestContext
            int r6 = r6 + 4
            int r8 = 23 - r8
            int r7 = r7 + 97
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2b
        L13:
            r3 = 0
        L14:
            r5 = r7
            r7 = r6
            r6 = r5
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r5
        L2b:
            int r4 = -r4
            int r6 = r6 + 1
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.views.UserFeedsActivity.b(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.feeds.views.UserFeedsActivity.$$a
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r8 = 47 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L34:
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.views.UserFeedsActivity.c(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0749  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x074d  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0919  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x091e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0922  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0ae6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x029b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x028e  */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r29) {
        /*
            Method dump skipped, instructions count: 3198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.views.UserFeedsActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        return R.layout.activity_user_feeds;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x03b3 A[Catch: all -> 0x04f4, TryCatch #1 {all -> 0x04f4, blocks: (B:38:0x039b, B:42:0x0406, B:41:0x03b3), top: B:84:0x039b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x041d  */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r24) {
        /*
            Method dump skipped, instructions count: 1778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.views.UserFeedsActivity.onCreate(android.os.Bundle):void");
    }

    @Override // id.dana.contract.feeds.UserFeedsContract.View
    public void onDeleteFailed(String str) {
    }

    @Override // id.dana.contract.feeds.UserFeedsContract.View
    public void onDeletingFeeds(String str) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(new char[]{36280, 17002, 59059, 49753}, new char[]{36294, 57203, 47165, 64766}, super.getResources().getString(R.string.passkey_enrollment_tnc_description_tnc_link).substring(18, 19).length() - 1, (char) (super.getResources().getString(R.string.location_access_description).substring(12, 13).length() + 65207), new char[]{7193, 17584, 37990, 52504, 59212, 49817, 22072, 25180, 17977, 15792, 17438, 35910, 54680, 54042, 29613, 16416, 41802, 61949, 20672, 3505, 59867, 54508, 58871, 'x', 29482, 2036}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(new char[]{36280, 17002, 59059, 49753}, new char[]{64036, 13402, 59362, 6673}, super.getResources().getString(R.string.tuesday).substring(5, 6).length() - 1, (char) (super.getResources().getString(R.string.feeds_empty).substring(21, 22).codePointAt(0) + 4482), new char[]{23946, 24671, 4761, 57243, 3590, 38019, 34350, 56672, 20203, 30806, 31531, 18258, 9252, 37684, 24559, 37296, 26519, 48932}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), View.MeasureSpec.getMode(0) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, TextUtils.lastIndexOf("", '0') + 19, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {36280, 17002, 59059, 49753};
            char[] cArr2 = {36294, 57203, 47165, 64766};
            try {
                byte b = getAuthRequestContext[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                b(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[5], getAuthRequestContext[41], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(cArr, cArr2, ((ApplicationInfo) cls.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 65207), new char[]{7193, 17584, 37990, 52504, 59212, 49817, 22072, 25180, 17977, 15792, 17438, 35910, 54680, 54042, 29613, 16416, 41802, 61949, 20672, 3505, 59867, 54508, 58871, 'x', 29482, 2036}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                char[] cArr3 = {36280, 17002, 59059, 49753};
                char[] cArr4 = {64036, 13402, 59362, 6673};
                int i = (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1;
                try {
                    byte b3 = getAuthRequestContext[25];
                    byte b4 = b3;
                    Object[] objArr3 = new Object[1];
                    b(b3, b4, b4, objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    b((byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[5], getAuthRequestContext[41], objArr4);
                    Object[] objArr5 = new Object[1];
                    a(cArr3, cArr4, i, (char) (((ApplicationInfo) cls3.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 4550), new char[]{23946, 24671, 4761, 57243, 3590, 38019, 34350, 56672, 20203, 30806, 31531, 18258, 9252, 37684, 24559, 37296, 26519, 48932}, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) View.MeasureSpec.getMode(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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
        super.onResume();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        setCenterTitle(getString(R.string.my_feeds));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    @Override // id.dana.base.BaseActivity
    public void onClickLeftMenuButton(View view) {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showDeleteFeedsDialog$0$id-dana-feeds-views-UserFeedsActivity  reason: not valid java name */
    public /* synthetic */ void m2606x891d9677(int i, DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        FeedsAdapter feedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (feedsAdapter != null) {
            feedsAdapter.MyBillsEntityDataFactory.getAuthRequestContext.MyBillsEntityDataFactory(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showDeleteFeedsDialog$1$id-dana-feeds-views-UserFeedsActivity  reason: not valid java name */
    public /* synthetic */ void m2607x521e8db8(int i, DialogInterface dialogInterface, int i2) {
        FeedsAdapter feedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (feedsAdapter != null) {
            feedsAdapter.MyBillsEntityDataFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$showDeleteFeedsDialog$2$id-dana-feeds-views-UserFeedsActivity  reason: not valid java name */
    public /* synthetic */ void m2608x1b1f84f9(int i, DialogInterface dialogInterface) {
        FeedsAdapter feedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (feedsAdapter != null) {
            feedsAdapter.MyBillsEntityDataFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(i, true);
        }
    }

    @Override // id.dana.contract.feeds.UserFeedsContract.View
    public void onGetFeeds(FeedsModel feedsModel) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList();
        }
        if (feedsModel != null && feedsModel.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.addAll(feedsModel.KClassImpl$Data$declaredNonStaticMembers$2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext = feedsModel.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        FeedsAdapter feedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        List<ActivityModel> list = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        feedsAdapter.getItems().clear();
        feedsAdapter.getItems().addAll(list);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.notifyDataSetChanged();
        if (feedsModel != null) {
            this.lookAheadTest = feedsModel.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Override // id.dana.contract.feeds.UserFeedsContract.View
    public void onDeleted(String str) {
        FeedsAdapter feedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int i = 0;
        while (true) {
            if (i >= feedsAdapter.getItems().size()) {
                i = -1;
                break;
            } else if (feedsAdapter.MyBillsEntityDataFactory(str, i)) {
                break;
            } else {
                i++;
            }
        }
        this.scheduleImpl.remove(i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.notifyDataSetChanged();
    }

    static /* synthetic */ void access$100(final UserFeedsActivity userFeedsActivity, Context context, final int i) {
        AlertDialog.Builder builder;
        if (OSUtil.scheduleImpl()) {
            builder = new AlertDialog.Builder(context, R.style.f47202132017159);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(R.string.feeds_delete_dialog);
        builder.setPositiveButton(R.string.option_yes, new DialogInterface.OnClickListener() { // from class: id.dana.feeds.views.UserFeedsActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UserFeedsActivity.this.m2606x891d9677(i, dialogInterface, i2);
            }
        });
        builder.setNegativeButton(R.string.option_cancel, new DialogInterface.OnClickListener() { // from class: id.dana.feeds.views.UserFeedsActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UserFeedsActivity.this.m2607x521e8db8(i, dialogInterface, i2);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: id.dana.feeds.views.UserFeedsActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                UserFeedsActivity.this.m2608x1b1f84f9(i, dialogInterface);
            }
        });
        builder.create().show();
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        byte b = 0;
        if (this.getErrorConfigVersion == null) {
            DaggerFeedsComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerFeedsComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (UserFeedsModule) Preconditions.getAuthRequestContext(new UserFeedsModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, UserFeedsModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
            this.getErrorConfigVersion = new DaggerFeedsComponent.FeedsComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, b);
        }
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(this.presenter);
        this.presenter.MyBillsEntityDataFactory(null);
        this.scheduleImpl = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new FeedsAdapter(this.scheduleImpl);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.rcFeeds.addItemDecoration(new FeedsDividerDecoration(this));
        this.rcFeeds.setLayoutManager(linearLayoutManager);
        this.rcFeeds.setAdapter(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        FeedsAdapter feedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        feedsAdapter.PlaceComponentResult = 0;
        feedsAdapter.notifyDataSetChanged();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2 = new FeedsAdapter.FeedsActions() { // from class: id.dana.feeds.views.UserFeedsActivity.1
            @Override // id.dana.feeds.FeedsAdapter.FeedsActions
            public final void PlaceComponentResult(int i) {
                UserFeedsActivity.this.presenter.KClassImpl$Data$declaredNonStaticMembers$2(((ActivityModel) UserFeedsActivity.this.scheduleImpl.get(i)).PlaceComponentResult);
            }

            @Override // id.dana.feeds.FeedsAdapter.FeedsActions
            public final void PlaceComponentResult(Context context, int i) {
                UserFeedsActivity.access$100(UserFeedsActivity.this, context, i);
            }

            @Override // id.dana.feeds.FeedsAdapter.FeedsActions
            public final void getAuthRequestContext() {
                UserFeedsActivity.this.presenter.MyBillsEntityDataFactory(UserFeedsActivity.this.lookAheadTest);
            }

            @Override // id.dana.feeds.FeedsAdapter.FeedsActions
            public final void PlaceComponentResult(String str) {
                DanaH5.startContainerFullUrl(str);
            }
        };
    }

    private static void a(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (DatabaseTableConfigUtil ^ 4360990799332652212L)) ^ ((int) (initRecordTimeStamp ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
