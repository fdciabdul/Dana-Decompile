package id.dana.drawable.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.mobile.zebra.data.ZebraData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.extension.view.InputExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.SizeUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001)B'\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&B+\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\u0006\u0010'\u001a\u00020\u0007¢\u0006\u0004\b%\u0010(J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0004R*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\rR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/nearbyrevamp/view/NearbySearchToolbar;", "Lid/dana/base/BaseRichView;", "", "clearFocusFromSearchBox", "()V", "clearText", "focusEditText", "", "getLayout", "()I", "", "keyword", "setText", "(Ljava/lang/String;)V", ZebraData.ATTR_PADDING, "setTopPadding", "(I)V", "setup", "KClassImpl$Data$declaredNonStaticMembers$2", "value", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "setKeyword", "Lid/dana/nearbyrevamp/view/NearbySearchToolbar$Listener;", "MyBillsEntityDataFactory", "Lid/dana/nearbyrevamp/view/NearbySearchToolbar$Listener;", "getListener", "()Lid/dana/nearbyrevamp/view/NearbySearchToolbar$Listener;", "setListener", "(Lid/dana/nearbyrevamp/view/NearbySearchToolbar$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbySearchToolbar extends BaseRichView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String keyword;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Listener listener;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0003\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0006\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyrevamp/view/NearbySearchToolbar$Listener;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p0", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Listener {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void MyBillsEntityDataFactory();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbySearchToolbar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbySearchToolbar(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_nearby_toolbar_search;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbySearchToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.keyword = "";
    }

    public /* synthetic */ NearbySearchToolbar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbySearchToolbar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.keyword = "";
    }

    @JvmName(name = "getListener")
    public final Listener getListener() {
        return this.listener;
    }

    @JvmName(name = "setListener")
    public final void setListener(Listener listener) {
        this.listener = listener;
    }

    @JvmName(name = "getKeyword")
    public final String getKeyword() {
        return this.keyword;
    }

    @JvmName(name = "setKeyword")
    public final void setKeyword(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.keyword = str;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.addOnSelectionChangedListener);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(this.keyword.length() > 0 ? 0 : 8);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.tbSearchView);
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.view.NearbySearchToolbar$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbySearchToolbar.$r8$lambda$Vjjfrw43O8WaRX4K6p3QdMduhiY(NearbySearchToolbar.this, view);
                }
            });
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.logWithTime);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.view.NearbySearchToolbar$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbySearchToolbar.$r8$lambda$KImKpS2Xs7K7bJiH8ylcCDxTGlw(NearbySearchToolbar.this, view);
                }
            });
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.addOnSelectionChangedListener);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.view.NearbySearchToolbar$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbySearchToolbar.$r8$lambda$1s9A5HLTyAZsGFp46gsm2Ca2Gzc(NearbySearchToolbar.this, view);
                }
            });
        }
        final EditText editText = (EditText) _$_findCachedViewById(R.id.parseLineAndAppendValue);
        if (editText != null) {
            RxTextView.textChangeEvents(editText).debounce(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new DisposableObserver<TextViewTextChangeEvent>() { // from class: id.dana.nearbyrevamp.view.NearbySearchToolbar$getSearchObserver$1
                @Override // io.reactivex.Observer
                public final void onComplete() {
                }

                @Override // io.reactivex.Observer
                public final void onError(Throwable p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    TextViewTextChangeEvent textViewTextChangeEvent = (TextViewTextChangeEvent) obj;
                    Intrinsics.checkNotNullParameter(textViewTextChangeEvent, "");
                    EditText editText2 = (EditText) NearbySearchToolbar.this._$_findCachedViewById(R.id.parseLineAndAppendValue);
                    if (editText2 != null && editText2.isFocused()) {
                        NearbySearchToolbar.access$onSearchToolbarTextChanged(NearbySearchToolbar.this, textViewTextChangeEvent.text().toString());
                    }
                }
            });
            editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.nearbyrevamp.view.NearbySearchToolbar$setupEditText$lambda-7$$inlined$onTextAfterChanged$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    String obj = p0 != null ? p0.toString() : null;
                    if (obj == null) {
                        obj = "";
                    }
                    NearbySearchToolbar.this.setKeyword(obj);
                }
            });
            editText.setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.nearbyrevamp.view.NearbySearchToolbar$$ExternalSyntheticLambda3
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    boolean BuiltInFictitiousFunctionClassFactory;
                    BuiltInFictitiousFunctionClassFactory = NearbySearchToolbar.BuiltInFictitiousFunctionClassFactory(editText, this, i, keyEvent);
                    return BuiltInFictitiousFunctionClassFactory;
                }
            });
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.nearbyrevamp.view.NearbySearchToolbar$$ExternalSyntheticLambda4
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    NearbySearchToolbar.$r8$lambda$8It1W3YWkRF1dIN2XphsdCAi17w(NearbySearchToolbar.this, view, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(EditText editText, NearbySearchToolbar nearbySearchToolbar, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(editText, "");
        Intrinsics.checkNotNullParameter(nearbySearchToolbar, "");
        if (i == 66 && keyEvent.getAction() == 1) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(editText);
            Listener listener = nearbySearchToolbar.listener;
            if (listener != null) {
                listener.BuiltInFictitiousFunctionClassFactory(((EditText) editText.findViewById(R.id.parseLineAndAppendValue)).getText().toString());
                return false;
            }
            return false;
        }
        return false;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.logWithTime);
        if (textView != null) {
            textView.setVisibility(0);
        }
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.tbSearchView);
        if (toolbar != null) {
            toolbar.setNavigationIcon((Drawable) null);
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.onLooperPrepared);
        if (linearLayout != null) {
            ViewExtKt.MyBillsEntityDataFactory(linearLayout, Integer.valueOf(SizeUtil.getAuthRequestContext(16)), null, null, null, 14);
        }
    }

    public final void clearText() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.parseLineAndAppendValue);
        if (editText != null) {
            InputExtKt.MyBillsEntityDataFactory(editText);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.logWithTime);
        if (textView != null) {
            textView.setVisibility(8);
        }
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.tbSearchView);
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.arrow_left_white);
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.onLooperPrepared);
        if (linearLayout != null) {
            ViewExtKt.MyBillsEntityDataFactory(linearLayout, Integer.valueOf(SizeUtil.getAuthRequestContext(44)), null, null, null, 14);
        }
        clearFocusFromSearchBox();
    }

    public final void clearFocusFromSearchBox() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.parseLineAndAppendValue);
        if (editText != null) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(editText);
            editText.clearFocus();
        }
    }

    public final void focusEditText() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.parseLineAndAppendValue);
        if (editText != null) {
            editText.requestFocus();
            KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(editText);
        }
    }

    public final void setText(String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "");
        setKeyword(keyword);
        EditText editText = (EditText) _$_findCachedViewById(R.id.parseLineAndAppendValue);
        if (editText != null) {
            editText.setText(keyword);
        }
        EditText editText2 = (EditText) _$_findCachedViewById(R.id.parseLineAndAppendValue);
        if (editText2 != null) {
            editText2.clearFocus();
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final void setTopPadding(int padding) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.FamilyManageAvailableServicesAdapter_res_0x7f0a03e4);
        if (constraintLayout != null) {
            ViewExtKt.BuiltInFictitiousFunctionClassFactory(constraintLayout, null, Integer.valueOf(padding), null, null, 13);
        }
    }

    public static /* synthetic */ void $r8$lambda$1s9A5HLTyAZsGFp46gsm2Ca2Gzc(NearbySearchToolbar nearbySearchToolbar, View view) {
        Intrinsics.checkNotNullParameter(nearbySearchToolbar, "");
        EditText editText = (EditText) nearbySearchToolbar._$_findCachedViewById(R.id.parseLineAndAppendValue);
        if (editText != null) {
            InputExtKt.MyBillsEntityDataFactory(editText);
        }
        Listener listener = nearbySearchToolbar.listener;
        if (listener != null) {
            listener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static /* synthetic */ void $r8$lambda$8It1W3YWkRF1dIN2XphsdCAi17w(NearbySearchToolbar nearbySearchToolbar, View view, boolean z) {
        Intrinsics.checkNotNullParameter(nearbySearchToolbar, "");
        if (z) {
            nearbySearchToolbar.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static /* synthetic */ void $r8$lambda$KImKpS2Xs7K7bJiH8ylcCDxTGlw(NearbySearchToolbar nearbySearchToolbar, View view) {
        Intrinsics.checkNotNullParameter(nearbySearchToolbar, "");
        Listener listener = nearbySearchToolbar.listener;
        if (listener != null) {
            listener.MyBillsEntityDataFactory();
        }
    }

    public static /* synthetic */ void $r8$lambda$Vjjfrw43O8WaRX4K6p3QdMduhiY(NearbySearchToolbar nearbySearchToolbar, View view) {
        Intrinsics.checkNotNullParameter(nearbySearchToolbar, "");
        Listener listener = nearbySearchToolbar.listener;
        if (listener != null) {
            listener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static final /* synthetic */ void access$onSearchToolbarTextChanged(NearbySearchToolbar nearbySearchToolbar, CharSequence charSequence) {
        Listener listener = nearbySearchToolbar.listener;
        if (listener != null) {
            listener.KClassImpl$Data$declaredNonStaticMembers$2(String.valueOf(charSequence));
        }
    }
}
