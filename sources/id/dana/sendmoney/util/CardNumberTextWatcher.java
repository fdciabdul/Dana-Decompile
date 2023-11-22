package id.dana.sendmoney.util;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B#\u0012\u0006\u0010\u0003\u001a\u00020\u0015\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\rR\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013"}, d2 = {"Lid/dana/sendmoney/util/CardNumberTextWatcher;", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "p0", "", "afterTextChanged", "(Landroid/text/Editable;)V", "", "", "p1", "p2", "p3", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "", "", "PlaceComponentResult", "(Landroid/text/Editable;)Z", "onTextChanged", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/widget/EditText;", "getAuthRequestContext", "Landroid/widget/EditText;", "Lkotlin/Function1;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "<init>", "(Landroid/widget/EditText;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CardNumberTextWatcher implements TextWatcher {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<String, Unit> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final EditText getAuthRequestContext;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardNumberTextWatcher(EditText editText, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(editText, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.getAuthRequestContext = editText;
        this.MyBillsEntityDataFactory = function1;
        this.PlaceComponentResult = "";
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.getSelectionStart();
        this.BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.getText().toString().length() - this.KClassImpl$Data$declaredNonStaticMembers$2;
        this.PlaceComponentResult = String.valueOf(p0);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable p0) {
        String str;
        boolean z;
        String valueOf = String.valueOf(p0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < valueOf.length(); i++) {
            char charAt = valueOf.charAt(i);
            if (!CharsKt.isWhitespace(charAt)) {
                sb.append(charAt);
            }
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        this.MyBillsEntityDataFactory.invoke(obj);
        Editable editable = p0;
        if (!(editable == null || editable.length() == 0)) {
            if ((this.PlaceComponentResult.length() > 0) && (p0.length() > 5 || this.PlaceComponentResult.length() >= 5)) {
                boolean z2 = this.PlaceComponentResult.length() < p0.length();
                int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2 - 1;
                if (i2 >= 0) {
                    char[] charArray = this.PlaceComponentResult.toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray, "");
                    if (charArray[i2] == ' ') {
                        z = true;
                        if (!z2 && z) {
                            p0.delete(this.KClassImpl$Data$declaredNonStaticMembers$2 - 2, i2);
                        }
                    }
                }
                z = false;
                if (!z2) {
                    p0.delete(this.KClassImpl$Data$declaredNonStaticMembers$2 - 2, i2);
                }
            }
        }
        if (p0 == null || PlaceComponentResult(p0)) {
            return;
        }
        CardNumberTextWatcher cardNumberTextWatcher = this;
        this.getAuthRequestContext.removeTextChangedListener(cardNumberTextWatcher);
        String replace = new Regex("[^\\d.]").replace(p0.toString(), "");
        int length = replace.length();
        String substring = replace.substring(length);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        String substring2 = replace.substring(0, length);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < 4; i3++) {
            sb2.append(".");
        }
        StringBuilder sb3 = new StringBuilder();
        String obj2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(obj2, "");
        sb3.append(new Regex(obj2).replace(substring2, "$0 "));
        sb3.append(substring);
        String obj3 = sb3.toString();
        if (obj3 != null) {
            int length2 = p0.length();
            if (obj3.length() > 19) {
                str = obj3.substring(0, 19);
                Intrinsics.checkNotNullExpressionValue(str, "");
            } else {
                str = obj3;
            }
            p0.replace(0, length2, str);
            this.getAuthRequestContext.setText(obj3);
            if (obj3.length() > 19) {
                this.getAuthRequestContext.setSelection(Math.max(19 - this.BuiltInFictitiousFunctionClassFactory, 0));
            } else {
                this.getAuthRequestContext.setSelection(Math.max(obj3.length() - this.BuiltInFictitiousFunctionClassFactory, 0));
            }
        }
        this.getAuthRequestContext.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
        this.getAuthRequestContext.addTextChangedListener(cardNumberTextWatcher);
    }

    private static boolean PlaceComponentResult(Editable editable) {
        boolean isDigit;
        boolean z = editable.length() <= 19;
        int length = editable.length();
        for (int i = 0; i < length; i++) {
            if (i > 0 && (i + 1) % 5 == 0) {
                isDigit = ' ' == editable.charAt(i);
            } else {
                isDigit = Character.isDigit(editable.charAt(i));
            }
            z &= isDigit;
        }
        return z;
    }
}
