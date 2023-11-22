package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatTextHelper {
    private TintInfo BuiltInFictitiousFunctionClassFactory;
    private TintInfo KClassImpl$Data$declaredNonStaticMembers$2;
    private TintInfo MyBillsEntityDataFactory;
    private TintInfo NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean PlaceComponentResult;
    private final AppCompatTextViewAutoSizeHelper getAuthRequestContext;
    private Typeface getErrorConfigVersion;
    private final TextView initRecordTimeStamp;
    private TintInfo lookAheadTest;
    private TintInfo moveToNextValue;
    private TintInfo scheduleImpl;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    private int DatabaseTableConfigUtil = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextHelper(TextView textView) {
        this.initRecordTimeStamp = textView;
        this.getAuthRequestContext = new AppCompatTextViewAutoSizeHelper(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet attributeSet, int i) {
        String str;
        ColorStateList colorStateList;
        String str2;
        boolean z;
        boolean z2;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        boolean z3;
        int i2;
        Context context = this.initRecordTimeStamp.getContext();
        AppCompatDrawableManager KClassImpl$Data$declaredNonStaticMembers$2 = AppCompatDrawableManager.KClassImpl$Data$declaredNonStaticMembers$2();
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(context, attributeSet, R.styleable.Q, i, 0);
        TextView textView = this.initRecordTimeStamp;
        ViewCompat.MyBillsEntityDataFactory(textView, textView.getContext(), R.styleable.Q, attributeSet, authRequestContext.BuiltInFictitiousFunctionClassFactory, i, 0);
        int resourceId = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda1, -1);
        if (authRequestContext.getAuthRequestContext(R.styleable.S)) {
            this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2(context, KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.S, 0));
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.R)) {
            this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2(context, KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.R, 0));
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda2)) {
            this.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2(context, KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda2, 0));
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.O)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(context, KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.O, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (authRequestContext.getAuthRequestContext(R.styleable.isAuth)) {
                this.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2(context, KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.isAuth, 0));
            }
            if (authRequestContext.getAuthRequestContext(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda0)) {
                this.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(context, KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda0, 0));
            }
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        boolean z4 = this.initRecordTimeStamp.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (resourceId != -1) {
            TintTypedArray authRequestContext2 = TintTypedArray.getAuthRequestContext(context, resourceId, R.styleable.access$getFeaturedBankListAdapter$p);
            if (z4 || !authRequestContext2.getAuthRequestContext(R.styleable.ImageWithDescriptionView$showImage$1)) {
                z = false;
                z2 = false;
            } else {
                z = authRequestContext2.getAuthRequestContext(R.styleable.ImageWithDescriptionView$showImage$1, false);
                z2 = true;
            }
            getAuthRequestContext(context, authRequestContext2);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateList3 = authRequestContext2.getAuthRequestContext(R.styleable.connectionSpecs) ? authRequestContext2.PlaceComponentResult(R.styleable.connectionSpecs) : null;
                colorStateList = authRequestContext2.getAuthRequestContext(R.styleable.TwilioRepository) ? authRequestContext2.PlaceComponentResult(R.styleable.TwilioRepository) : null;
                colorStateList2 = authRequestContext2.getAuthRequestContext(R.styleable.getSavingConfigPresenter) ? authRequestContext2.PlaceComponentResult(R.styleable.getSavingConfigPresenter) : null;
            } else {
                colorStateList = null;
                colorStateList2 = null;
                colorStateList3 = null;
            }
            str2 = authRequestContext2.getAuthRequestContext(R.styleable.getNrCsiRsrq) ? authRequestContext2.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.getNrCsiRsrq) : null;
            str = (Build.VERSION.SDK_INT < 26 || !authRequestContext2.getAuthRequestContext(R.styleable.onLayoutDirectionChanged)) ? null : authRequestContext2.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.onLayoutDirectionChanged);
            authRequestContext2.BuiltInFictitiousFunctionClassFactory.recycle();
        } else {
            str = null;
            colorStateList = null;
            str2 = null;
            z = false;
            z2 = false;
            colorStateList2 = null;
            colorStateList3 = null;
        }
        TintTypedArray authRequestContext3 = TintTypedArray.getAuthRequestContext(context, attributeSet, R.styleable.access$getFeaturedBankListAdapter$p, i, 0);
        if (z4 || !authRequestContext3.getAuthRequestContext(R.styleable.ImageWithDescriptionView$showImage$1)) {
            z3 = z2;
        } else {
            z = authRequestContext3.getAuthRequestContext(R.styleable.ImageWithDescriptionView$showImage$1, false);
            z3 = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (authRequestContext3.getAuthRequestContext(R.styleable.connectionSpecs)) {
                colorStateList3 = authRequestContext3.PlaceComponentResult(R.styleable.connectionSpecs);
            }
            if (authRequestContext3.getAuthRequestContext(R.styleable.TwilioRepository)) {
                colorStateList = authRequestContext3.PlaceComponentResult(R.styleable.TwilioRepository);
            }
            if (authRequestContext3.getAuthRequestContext(R.styleable.getSavingConfigPresenter)) {
                colorStateList2 = authRequestContext3.PlaceComponentResult(R.styleable.getSavingConfigPresenter);
            }
        }
        if (authRequestContext3.getAuthRequestContext(R.styleable.getNrCsiRsrq)) {
            str2 = authRequestContext3.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.getNrCsiRsrq);
        }
        if (Build.VERSION.SDK_INT >= 26 && authRequestContext3.getAuthRequestContext(R.styleable.onLayoutDirectionChanged)) {
            str = authRequestContext3.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.onLayoutDirectionChanged);
        }
        if (Build.VERSION.SDK_INT >= 28 && authRequestContext3.getAuthRequestContext(R.styleable.getNrCsiRsrp)) {
            if (authRequestContext3.BuiltInFictitiousFunctionClassFactory.getDimensionPixelSize(R.styleable.getNrCsiRsrp, -1) == 0) {
                this.initRecordTimeStamp.setTextSize(0, 0.0f);
            }
        }
        getAuthRequestContext(context, authRequestContext3);
        authRequestContext3.BuiltInFictitiousFunctionClassFactory.recycle();
        if (colorStateList3 != null) {
            this.initRecordTimeStamp.setTextColor(colorStateList3);
        }
        if (colorStateList != null) {
            this.initRecordTimeStamp.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.initRecordTimeStamp.setLinkTextColor(colorStateList2);
        }
        if (!z4 && z3) {
            BuiltInFictitiousFunctionClassFactory(z);
        }
        Typeface typeface = this.getErrorConfigVersion;
        if (typeface != null) {
            if (this.DatabaseTableConfigUtil == -1) {
                this.initRecordTimeStamp.setTypeface(typeface, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            } else {
                this.initRecordTimeStamp.setTypeface(typeface);
            }
        }
        if (str != null) {
            Api26Impl.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp, str);
        }
        if (str2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Api24Impl.getAuthRequestContext(this.initRecordTimeStamp, Api24Impl.MyBillsEntityDataFactory(str2));
            } else if (Build.VERSION.SDK_INT >= 21) {
                Api17Impl.PlaceComponentResult(this.initRecordTimeStamp, Locale.forLanguageTag(str2.split(",")[0]));
            }
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, i);
        if (AutoSizeableTextView.BuiltInFictitiousFunctionClassFactory && this.getAuthRequestContext.lookAheadTest() != 0) {
            int[] KClassImpl$Data$declaredNonStaticMembers$22 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$22.length > 0) {
                if (Api26Impl.MyBillsEntityDataFactory(this.initRecordTimeStamp) != -1.0f) {
                    Api26Impl.getAuthRequestContext(this.initRecordTimeStamp, this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(), this.getAuthRequestContext.MyBillsEntityDataFactory(), this.getAuthRequestContext.getAuthRequestContext(), 0);
                } else {
                    Api26Impl.PlaceComponentResult(this.initRecordTimeStamp, KClassImpl$Data$declaredNonStaticMembers$22, 0);
                }
            }
        }
        TintTypedArray MyBillsEntityDataFactory = TintTypedArray.MyBillsEntityDataFactory(context, attributeSet, R.styleable.V);
        int resourceId2 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.Z, -1);
        Drawable authRequestContext4 = resourceId2 != -1 ? KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(context, resourceId2) : null;
        int resourceId3 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.b, -1);
        Drawable authRequestContext5 = resourceId3 != -1 ? KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(context, resourceId3) : null;
        int resourceId4 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.isAuto, -1);
        Drawable authRequestContext6 = resourceId4 != -1 ? KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(context, resourceId4) : null;
        int resourceId5 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.flip, -1);
        Drawable authRequestContext7 = resourceId5 != -1 ? KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(context, resourceId5) : null;
        int resourceId6 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.f5937a, -1);
        Drawable authRequestContext8 = resourceId6 != -1 ? KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(context, resourceId6) : null;
        int resourceId7 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.Y, -1);
        BuiltInFictitiousFunctionClassFactory(authRequestContext4, authRequestContext5, authRequestContext6, authRequestContext7, authRequestContext8, resourceId7 != -1 ? KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(context, resourceId7) : null);
        if (MyBillsEntityDataFactory.getAuthRequestContext(R.styleable.c)) {
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp, MyBillsEntityDataFactory.PlaceComponentResult(R.styleable.c));
        }
        if (MyBillsEntityDataFactory.getAuthRequestContext(R.styleable.d)) {
            i2 = -1;
            TextViewCompat.MyBillsEntityDataFactory(this.initRecordTimeStamp, DrawableUtils.MyBillsEntityDataFactory(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.d, -1), null));
        } else {
            i2 = -1;
        }
        int dimensionPixelSize = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getDimensionPixelSize(R.styleable.f, i2);
        int dimensionPixelSize2 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getDimensionPixelSize(R.styleable.FillAnimation, i2);
        int dimensionPixelSize3 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getDimensionPixelSize(R.styleable.TypeProjectionImpl, i2);
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.recycle();
        if (dimensionPixelSize != i2) {
            TextViewCompat.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != i2) {
            TextViewCompat.MyBillsEntityDataFactory(this.initRecordTimeStamp, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != i2) {
            TextViewCompat.getAuthRequestContext(this.initRecordTimeStamp, dimensionPixelSize3);
        }
    }

    private void getAuthRequestContext(Context context, TintTypedArray tintTypedArray) {
        int i;
        String string;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = tintTypedArray.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.roundToPowerOfTwo, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        if (Build.VERSION.SDK_INT >= 28) {
            int i2 = tintTypedArray.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.setAkuEntranceOpen, -1);
            this.DatabaseTableConfigUtil = i2;
            if (i2 != -1) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (this.NetworkUserEntityData$$ExternalSyntheticLambda1 & 2) | 0;
            }
        }
        if (tintTypedArray.getAuthRequestContext(R.styleable.ISO8601Utils) || tintTypedArray.getAuthRequestContext(R.styleable.SplitReferralConfigEntityData_Factory)) {
            Typeface typeface = null;
            this.getErrorConfigVersion = null;
            if (tintTypedArray.getAuthRequestContext(R.styleable.SplitReferralConfigEntityData_Factory)) {
                i = R.styleable.SplitReferralConfigEntityData_Factory;
            } else {
                i = R.styleable.ISO8601Utils;
            }
            final int i3 = this.DatabaseTableConfigUtil;
            final int i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.initRecordTimeStamp);
                ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    /* renamed from: onFontRetrievalFailed */
                    public void m7xb24343b7(int i5) {
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    /* renamed from: onFontRetrieved */
                    public void m8x46c88379(Typeface typeface2) {
                        int i5;
                        if (Build.VERSION.SDK_INT >= 28 && (i5 = i3) != -1) {
                            typeface2 = Api28Impl.getAuthRequestContext(typeface2, i5, (i4 & 2) != 0);
                        }
                        AppCompatTextHelper.this.BuiltInFictitiousFunctionClassFactory(weakReference, typeface2);
                    }
                };
                try {
                    int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    int resourceId = tintTypedArray.BuiltInFictitiousFunctionClassFactory.getResourceId(i, 0);
                    if (resourceId != 0) {
                        if (tintTypedArray.MyBillsEntityDataFactory == null) {
                            tintTypedArray.MyBillsEntityDataFactory = new TypedValue();
                        }
                        typeface = ResourcesCompat.MyBillsEntityDataFactory(tintTypedArray.getAuthRequestContext, resourceId, tintTypedArray.MyBillsEntityDataFactory, i5, fontCallback);
                    }
                    if (typeface != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.DatabaseTableConfigUtil != -1) {
                            this.getErrorConfigVersion = Api28Impl.getAuthRequestContext(InstrumentInjector.typefaceCreateDerived(typeface, 0), this.DatabaseTableConfigUtil, (this.NetworkUserEntityData$$ExternalSyntheticLambda1 & 2) != 0);
                        } else {
                            this.getErrorConfigVersion = typeface;
                        }
                    }
                    this.PlaceComponentResult = this.getErrorConfigVersion == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.getErrorConfigVersion != null || (string = tintTypedArray.BuiltInFictitiousFunctionClassFactory.getString(i)) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && this.DatabaseTableConfigUtil != -1) {
                this.getErrorConfigVersion = Api28Impl.getAuthRequestContext(Typeface.create(string, 0), this.DatabaseTableConfigUtil, (this.NetworkUserEntityData$$ExternalSyntheticLambda1 & 2) != 0);
            } else {
                this.getErrorConfigVersion = Typeface.create(string, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
        } else if (tintTypedArray.getAuthRequestContext(R.styleable.allowedTargets)) {
            this.PlaceComponentResult = false;
            int i6 = tintTypedArray.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.allowedTargets, 1);
            if (i6 == 1) {
                this.getErrorConfigVersion = Typeface.SANS_SERIF;
            } else if (i6 == 2) {
                this.getErrorConfigVersion = Typeface.SERIF;
            } else if (i6 == 3) {
                this.getErrorConfigVersion = Typeface.MONOSPACE;
            }
        }
    }

    void BuiltInFictitiousFunctionClassFactory(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.PlaceComponentResult) {
            this.getErrorConfigVersion = typeface;
            final TextView textView = weakReference.get();
            if (textView != null) {
                if (ViewCompat.C(textView)) {
                    final int i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            textView.setTypeface(typeface, i);
                        }
                    });
                    return;
                }
                textView.setTypeface(typeface, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PlaceComponentResult(Context context, int i) {
        ColorStateList PlaceComponentResult;
        ColorStateList PlaceComponentResult2;
        ColorStateList PlaceComponentResult3;
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(context, i, R.styleable.access$getFeaturedBankListAdapter$p);
        if (authRequestContext.getAuthRequestContext(R.styleable.ImageWithDescriptionView$showImage$1)) {
            BuiltInFictitiousFunctionClassFactory(authRequestContext.getAuthRequestContext(R.styleable.ImageWithDescriptionView$showImage$1, false));
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (authRequestContext.getAuthRequestContext(R.styleable.connectionSpecs) && (PlaceComponentResult3 = authRequestContext.PlaceComponentResult(R.styleable.connectionSpecs)) != null) {
                this.initRecordTimeStamp.setTextColor(PlaceComponentResult3);
            }
            if (authRequestContext.getAuthRequestContext(R.styleable.getSavingConfigPresenter) && (PlaceComponentResult2 = authRequestContext.PlaceComponentResult(R.styleable.getSavingConfigPresenter)) != null) {
                this.initRecordTimeStamp.setLinkTextColor(PlaceComponentResult2);
            }
            if (authRequestContext.getAuthRequestContext(R.styleable.TwilioRepository) && (PlaceComponentResult = authRequestContext.PlaceComponentResult(R.styleable.TwilioRepository)) != null) {
                this.initRecordTimeStamp.setHintTextColor(PlaceComponentResult);
            }
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.getNrCsiRsrp)) {
            if (authRequestContext.BuiltInFictitiousFunctionClassFactory.getDimensionPixelSize(R.styleable.getNrCsiRsrp, -1) == 0) {
                this.initRecordTimeStamp.setTextSize(0, 0.0f);
            }
        }
        getAuthRequestContext(context, authRequestContext);
        if (Build.VERSION.SDK_INT >= 26 && authRequestContext.getAuthRequestContext(R.styleable.onLayoutDirectionChanged)) {
            String string = authRequestContext.BuiltInFictitiousFunctionClassFactory.getString(R.styleable.onLayoutDirectionChanged);
            if (string != null) {
                Api26Impl.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp, string);
            }
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        Typeface typeface = this.getErrorConfigVersion;
        if (typeface != null) {
            this.initRecordTimeStamp.setTypeface(typeface, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.initRecordTimeStamp.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void GetContactSyncConfig() {
        MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory() {
        if (this.BuiltInFictitiousFunctionClassFactory != null || this.scheduleImpl != null || this.moveToNextValue != null || this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            Drawable[] compoundDrawables = this.initRecordTimeStamp.getCompoundDrawables();
            PlaceComponentResult(compoundDrawables[0], this.BuiltInFictitiousFunctionClassFactory);
            PlaceComponentResult(compoundDrawables[1], this.scheduleImpl);
            PlaceComponentResult(compoundDrawables[2], this.moveToNextValue);
            PlaceComponentResult(compoundDrawables[3], this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.lookAheadTest == null && this.MyBillsEntityDataFactory == null) {
                return;
            }
            Drawable[] BuiltInFictitiousFunctionClassFactory = Api17Impl.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp);
            PlaceComponentResult(BuiltInFictitiousFunctionClassFactory[0], this.lookAheadTest);
            PlaceComponentResult(BuiltInFictitiousFunctionClassFactory[2], this.MyBillsEntityDataFactory);
        }
    }

    private void PlaceComponentResult(Drawable drawable, TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        AppCompatDrawableManager.BuiltInFictitiousFunctionClassFactory(drawable, tintInfo, this.initRecordTimeStamp.getDrawableState());
    }

    private static TintInfo KClassImpl$Data$declaredNonStaticMembers$2(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList PlaceComponentResult = appCompatDrawableManager.PlaceComponentResult(context, i);
        if (PlaceComponentResult != null) {
            TintInfo tintInfo = new TintInfo();
            tintInfo.PlaceComponentResult = true;
            tintInfo.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
            return tintInfo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory(boolean z, int i, int i2, int i3, int i4) {
        if (AutoSizeableTextView.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAuthRequestContext(int i, float f) {
        if (AutoSizeableTextView.BuiltInFictitiousFunctionClassFactory || moveToNextValue()) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BuiltInFictitiousFunctionClassFactory() {
        this.getAuthRequestContext.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean moveToNextValue() {
        return this.getAuthRequestContext.getErrorConfigVersion();
    }

    private void BuiltInFictitiousFunctionClassFactory(int i, float f) {
        this.getAuthRequestContext.PlaceComponentResult(i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAuthRequestContext(int i) {
        this.getAuthRequestContext.getAuthRequestContext(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.getAuthRequestContext.MyBillsEntityDataFactory(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAuthRequestContext(int[] iArr, int i) throws IllegalArgumentException {
        this.getAuthRequestContext.getAuthRequestContext(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int scheduleImpl() {
        return this.getAuthRequestContext.lookAheadTest();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAuthRequestContext() {
        return this.getAuthRequestContext.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int PlaceComponentResult() {
        return this.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList lookAheadTest() {
        TintInfo tintInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (tintInfo != null) {
            return tintInfo.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory(ColorStateList colorStateList) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new TintInfo();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2 = colorStateList;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult = colorStateList != null;
        initRecordTimeStamp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getErrorConfigVersion() {
        TintInfo tintInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (tintInfo != null) {
            return tintInfo.getAuthRequestContext;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BuiltInFictitiousFunctionClassFactory(PorterDuff.Mode mode) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new TintInfo();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext = mode;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory = mode != null;
        initRecordTimeStamp();
    }

    private void initRecordTimeStamp() {
        TintInfo tintInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.BuiltInFictitiousFunctionClassFactory = tintInfo;
        this.scheduleImpl = tintInfo;
        this.moveToNextValue = tintInfo;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = tintInfo;
        this.lookAheadTest = tintInfo;
        this.MyBillsEntityDataFactory = tintInfo;
    }

    private void BuiltInFictitiousFunctionClassFactory(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        Drawable[] BuiltInFictitiousFunctionClassFactory;
        Drawable drawable7;
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] BuiltInFictitiousFunctionClassFactory2 = Api17Impl.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp);
            TextView textView = this.initRecordTimeStamp;
            if (drawable5 == null) {
                drawable5 = BuiltInFictitiousFunctionClassFactory2[0];
            }
            if (drawable2 == null) {
                drawable2 = BuiltInFictitiousFunctionClassFactory2[1];
            }
            if (drawable6 == null) {
                drawable6 = BuiltInFictitiousFunctionClassFactory2[2];
            }
            if (drawable4 == null) {
                drawable4 = BuiltInFictitiousFunctionClassFactory2[3];
            }
            Api17Impl.getAuthRequestContext(textView, drawable5, drawable2, drawable6, drawable4);
        } else if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
        } else {
            if (Build.VERSION.SDK_INT >= 17 && ((drawable7 = (BuiltInFictitiousFunctionClassFactory = Api17Impl.BuiltInFictitiousFunctionClassFactory(this.initRecordTimeStamp))[0]) != null || BuiltInFictitiousFunctionClassFactory[2] != null)) {
                TextView textView2 = this.initRecordTimeStamp;
                if (drawable2 == null) {
                    drawable2 = BuiltInFictitiousFunctionClassFactory[1];
                }
                Drawable drawable8 = BuiltInFictitiousFunctionClassFactory[2];
                if (drawable4 == null) {
                    drawable4 = BuiltInFictitiousFunctionClassFactory[3];
                }
                Api17Impl.getAuthRequestContext(textView2, drawable7, drawable2, drawable8, drawable4);
                return;
            }
            Drawable[] compoundDrawables = this.initRecordTimeStamp.getCompoundDrawables();
            TextView textView3 = this.initRecordTimeStamp;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAuthRequestContext(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        EditorInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2(editorInfo, textView.getText());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static boolean BuiltInFictitiousFunctionClassFactory(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }

        static int MyBillsEntityDataFactory(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void getAuthRequestContext(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        static void PlaceComponentResult(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static void getAuthRequestContext(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }

        static LocaleList MyBillsEntityDataFactory(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static void PlaceComponentResult(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }

        static void getAuthRequestContext(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static Drawable[] BuiltInFictitiousFunctionClassFactory(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static Typeface getAuthRequestContext(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }
}
