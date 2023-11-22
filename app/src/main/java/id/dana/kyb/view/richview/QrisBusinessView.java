package id.dana.kyb.view.richview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.util.OSUtil;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import id.dana.kyb.helper.ShareQrHelper;
import id.dana.kyb.mapper.KybModelMapperKt;
import id.dana.kyb.model.KybQrisModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.util.MediaStoreUtil;
import id.dana.utils.BarcodeUtil;
import id.dana.utils.FileUtil;
import id.dana.utils.ImageResize;
import id.dana.utils.android.IntentUtil;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0005¢\u0006\u0004\b+\u0010,B+\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u0005¢\u0006\u0004\b+\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u001f\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010$"}, d2 = {"Lid/dana/kyb/view/richview/QrisBusinessView;", "Lid/dana/base/BaseRichView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "getLayout", "()I", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "kybCompressQrConfig", "setCompressQrConfig", "(Lid/dana/kyb/domain/model/KybCompressQrConfig;)V", "Landroidx/fragment/app/Fragment;", "fragment", "Lid/dana/kyb/model/KybQrisModel;", "kybQrisModel", "setData", "(Landroidx/fragment/app/Fragment;Lid/dana/kyb/model/KybQrisModel;)V", "setup", "Lid/dana/component/buttoncomponent/DanaButtonSecondaryView;", "PlaceComponentResult", "Lid/dana/component/buttoncomponent/DanaButtonSecondaryView;", "getAuthRequestContext", "Landroidx/fragment/app/Fragment;", "Landroidx/appcompat/widget/AppCompatImageView;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/appcompat/widget/AppCompatImageView;", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "MyBillsEntityDataFactory", "Lid/dana/kyb/model/KybQrisModel;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "scheduleImpl", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "lookAheadTest", "Landroid/widget/TextView;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/widget/TextView;", "getErrorConfigVersion", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QrisBusinessView extends BaseRichView {
    private AppCompatImageView BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Fragment PlaceComponentResult;
    private KybQrisModel MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private TextView scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private DanaButtonSecondaryView getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private KybCompressQrConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private TextView getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private FragmentPermissionRequest lookAheadTest;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QrisBusinessView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QrisBusinessView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_qris_business;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrisBusinessView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ QrisBusinessView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrisBusinessView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void setData(Fragment fragment, KybQrisModel kybQrisModel) {
        Intrinsics.checkNotNullParameter(fragment, "");
        this.PlaceComponentResult = fragment;
        this.MyBillsEntityDataFactory = kybQrisModel;
        Unit unit = null;
        AppCompatImageView appCompatImageView = null;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragment = null;
        }
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(fragment);
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.kyb.view.richview.QrisBusinessView$initPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    QrisBusinessView.this.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (QrisBusinessView.this.getBaseActivity() != null) {
                    BaseActivity baseActivity = QrisBusinessView.this.getBaseActivity();
                    Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                    PermissionHelper.MyBillsEntityDataFactory(baseActivity);
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.continueToPermissionRequest();
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.lookAheadTest = builder.PlaceComponentResult();
        KybQrisModel kybQrisModel2 = this.MyBillsEntityDataFactory;
        if (kybQrisModel2 != null) {
            TextView textView = this.scheduleImpl;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView = null;
            }
            textView.setText(kybQrisModel2.BuiltInFictitiousFunctionClassFactory);
            TextView textView2 = this.getErrorConfigVersion;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView2 = null;
            }
            textView2.setText(getResources().getString(R.string.kyb_qris_poster_nmid, kybQrisModel2.getAuthRequestContext));
            Bitmap bitmap = kybQrisModel2.moveToNextValue;
            if (bitmap != null) {
                AppCompatImageView appCompatImageView2 = this.BuiltInFictitiousFunctionClassFactory;
                if (appCompatImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    appCompatImageView = appCompatImageView2;
                }
                appCompatImageView.setImageBitmap(bitmap);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                addDisposable(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(kybQrisModel2.KClassImpl$Data$declaredNonStaticMembers$2).subscribe(new Consumer() { // from class: id.dana.kyb.view.richview.QrisBusinessView$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        QrisBusinessView.m2639$r8$lambda$Pq5CICj3XpxkqUUyrJxpmLPf7E(QrisBusinessView.this, (Bitmap) obj);
                    }
                }, new Consumer() { // from class: id.dana.kyb.view.richview.QrisBusinessView$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        QrisBusinessView.$r8$lambda$kxQ1HJiK5MNf7XlzWmzuTgJlxwo(QrisBusinessView.this, (Throwable) obj);
                    }
                }));
            }
        }
    }

    public final void setCompressQrConfig(KybCompressQrConfig kybCompressQrConfig) {
        Intrinsics.checkNotNullParameter(kybCompressQrConfig, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = kybCompressQrConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Pair authRequestContext;
        KybQrisModel kybQrisModel = this.MyBillsEntityDataFactory;
        if (kybQrisModel != null) {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_QRIS_SHARE;
            builder.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
            ShareQrHelper shareQrHelper = ShareQrHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            KybCompressQrConfig KClassImpl$Data$declaredNonStaticMembers$2 = KybModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(kybQrisModel, "");
            Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
            View inflate = LayoutInflater.from(context).inflate(R.layout.view_kyb_share_qr, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.f4438tv_merchant_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "");
            TextView textView = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.tv_nmid);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "");
            TextView textView2 = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.tv_printed_by);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "");
            TextView textView3 = (TextView) findViewById3;
            View findViewById4 = inflate.findViewById(R.id.iv_qris);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "");
            AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById4;
            String str = kybQrisModel.BuiltInFictitiousFunctionClassFactory;
            if (str.length() > 20) {
                StringBuilder sb = new StringBuilder();
                String substring = str.substring(0, 20);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                sb.append(new Regex("[\\s]+$").replace(substring, ""));
                sb.append("...");
                str = sb.toString();
            }
            textView.setText(str);
            textView2.setText(context.getString(R.string.kyb_qris_poster_nmid, kybQrisModel.getAuthRequestContext));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("1.0.");
            sb2.append(kybQrisModel.MyBillsEntityDataFactory());
            textView3.setText(context.getString(R.string.qris_printed_by, kybQrisModel.MyBillsEntityDataFactory, sb2.toString()));
            appCompatImageView.setImageBitmap(kybQrisModel.moveToNextValue);
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
            Bitmap authRequestContext2 = ImageResize.getAuthRequestContext(FileUtil.getAuthRequestContext(inflate, inflate.getMeasuredWidth(), inflate.getMeasuredHeight()), 2480);
            Intrinsics.checkNotNullExpressionValue(authRequestContext2, "");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("qr_");
            sb3.append(kybQrisModel.BuiltInFictitiousFunctionClassFactory);
            sb3.append('_');
            sb3.append(kybQrisModel.MyBillsEntityDataFactory());
            sb3.append('_');
            sb3.append(kybQrisModel.scheduleImpl);
            authRequestContext = MediaStoreUtil.getAuthRequestContext(context, sb3.toString(), "jpeg", authRequestContext2, "", KClassImpl$Data$declaredNonStaticMembers$2.getEnabled(), KClassImpl$Data$declaredNonStaticMembers$2.getCompressRate());
            File file = (File) authRequestContext.component1();
            Uri uri = (Uri) authRequestContext.component2();
            if (file != null) {
                Intent authRequestContext3 = IntentUtil.getAuthRequestContext(uri);
                Intent createChooser = Intent.createChooser(authRequestContext3, getContext().getString(R.string.share_qr_text));
                Context context2 = getContext();
                if (context2 != null) {
                    Intrinsics.checkNotNullExpressionValue(context2, "");
                    if (authRequestContext3.resolveActivity(context2.getPackageManager()) != null) {
                        context2.startActivity(createChooser);
                    }
                }
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$0KC6QboE1RbvNLXH2lIgFbmrOho(QrisBusinessView qrisBusinessView, View view) {
        Intrinsics.checkNotNullParameter(qrisBusinessView, "");
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (!OSUtil.PlaceComponentResult()) {
            FragmentPermissionRequest fragmentPermissionRequest = qrisBusinessView.lookAheadTest;
            if (fragmentPermissionRequest == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                fragmentPermissionRequest = null;
            }
            fragmentPermissionRequest.check();
            return;
        }
        qrisBusinessView.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: $r8$lambda$Pq5CICj3XpxkqUUyrJxpmL-Pf7E  reason: not valid java name */
    public static /* synthetic */ void m2639$r8$lambda$Pq5CICj3XpxkqUUyrJxpmLPf7E(QrisBusinessView qrisBusinessView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(qrisBusinessView, "");
        Intrinsics.checkNotNullExpressionValue(bitmap, "");
        AppCompatImageView appCompatImageView = qrisBusinessView.BuiltInFictitiousFunctionClassFactory;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            appCompatImageView = null;
        }
        appCompatImageView.setImageBitmap(bitmap);
    }

    public static /* synthetic */ void $r8$lambda$kxQ1HJiK5MNf7XlzWmzuTgJlxwo(QrisBusinessView qrisBusinessView, Throwable th) {
        Intrinsics.checkNotNullParameter(qrisBusinessView, "");
        qrisBusinessView.dispose();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        View findViewById = findViewById(R.id.iv_qris_poster_qris);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.BuiltInFictitiousFunctionClassFactory = (AppCompatImageView) findViewById;
        View findViewById2 = findViewById(R.id.tv_qris_poster_merchant_name);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        this.scheduleImpl = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_qris_poster_nmid);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        this.getErrorConfigVersion = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.btn_share_qris);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "");
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) findViewById4;
        this.getAuthRequestContext = danaButtonSecondaryView;
        if (danaButtonSecondaryView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaButtonSecondaryView = null;
        }
        danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.richview.QrisBusinessView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrisBusinessView.$r8$lambda$0KC6QboE1RbvNLXH2lIgFbmrOho(QrisBusinessView.this, view);
            }
        });
    }
}
