package id.dana.richview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import id.dana.R;
import id.dana.model.CurrencyAmountModel;
import id.dana.sendmoney.Amount;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class CurrencyTextView extends AppCompatTextView {
    public static final String DEFAULT_COUNTRY_CODE = "ID";
    public static final String DEFAULT_LANGUAGE_CODE = "in";
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Locale MyBillsEntityDataFactory;
    private String PlaceComponentResult;
    private Context getAuthRequestContext;

    public CurrencyTextView(Context context) {
        super(context);
        this.PlaceComponentResult = "";
        this.getAuthRequestContext = context;
        initLocale();
        setSymbol(context.getString(R.string.rupiah_short));
        setText(KClassImpl$Data$declaredNonStaticMembers$2(getText().toString()));
    }

    public void initLocale() {
        setLocale("in", "ID");
    }

    public void setSymbol(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.PlaceComponentResult = str;
        setText(getText().toString(), TextView.BufferType.NORMAL);
        postInvalidate();
    }

    private String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Amount amount;
        String format;
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        try {
            amount = new Amount(str);
        } catch (NumberFormatException unused) {
            amount = new Amount((byte) 0);
        }
        format = NumberFormat.getNumberInstance(this.MyBillsEntityDataFactory).format(amount.getAuthRequestContext);
        return format;
    }

    public void setLocale(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = "in";
            str2 = "ID";
        }
        this.MyBillsEntityDataFactory = new Locale(str, str2);
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.MyBillsEntityDataFactory == null) {
            initLocale();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.PlaceComponentResult);
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2(charSequence.toString()));
        String obj = sb.toString();
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("-");
            sb2.append(obj);
            obj = sb2.toString();
        }
        if (TextUtils.isEmpty(obj)) {
            obj = "";
        }
        super.setText(obj, bufferType);
    }

    public void setMinus(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    public CurrencyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PlaceComponentResult = "";
        this.getAuthRequestContext = context;
        initLocale();
        setSymbol(context.getString(R.string.rupiah_short));
        setText(KClassImpl$Data$declaredNonStaticMembers$2(getText().toString()));
    }

    public CurrencyTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PlaceComponentResult = "";
        this.getAuthRequestContext = context;
        setSymbol(context.getString(R.string.rupiah_short));
        setText(KClassImpl$Data$declaredNonStaticMembers$2(getText().toString()));
    }

    public String getCurrencySymbol() {
        return this.PlaceComponentResult;
    }

    public CurrencyAmountModel getAmountModel() {
        return new CurrencyAmountModel(getAmount(), this.PlaceComponentResult);
    }

    public String getAmount() {
        return getText().toString().replaceAll("[^0-9]", "");
    }

    public void setSymbol(Drawable drawable) {
        if (drawable != null) {
            setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            setCompoundDrawablePadding(this.getAuthRequestContext.getResources().getDimensionPixelSize(R.dimen.f28472131165349));
        }
    }

    public Observable<String> listenOriginalValue() {
        return RxTextView.textChanges(this).skipInitialValue().subscribeOn(Schedulers.MyBillsEntityDataFactory()).map(new Function() { // from class: id.dana.richview.CurrencyTextView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CurrencyTextView.this.m2804lambda$listenOriginalValue$0$iddanarichviewCurrencyTextView((CharSequence) obj);
            }
        }).debounce(100L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$listenOriginalValue$0$id-dana-richview-CurrencyTextView  reason: not valid java name */
    public /* synthetic */ String m2804lambda$listenOriginalValue$0$iddanarichviewCurrencyTextView(CharSequence charSequence) throws Exception {
        return charSequence.toString().replace(this.PlaceComponentResult, "").replace(".", "");
    }
}
