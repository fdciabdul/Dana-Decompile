package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney_v2.recipient.view.RecipientSourceType;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.SizeUtil;
import io.reactivex.subjects.PublishSubject;

/* loaded from: classes3.dex */
public class SearchView extends BaseRichView {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private RecipientSourceType NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Drawable PlaceComponentResult;
    @BindView(R.id.et_search_contact)
    EditText etSearchContact;
    private PublishSubject<Boolean> getAuthRequestContext;
    private boolean getErrorConfigVersion;
    @BindView(R.id.iv_clear)
    ImageView ivClear;
    @BindView(R.id.iv_right_icon)
    ImageView ivRightIcon;
    private Drawable lookAheadTest;
    private String moveToNextValue;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;
    private PublishSubject<String> scheduleImpl;
    public static final byte[] MyBillsEntityDataFactory = {Ascii.EM, 108, 7, 61, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 132;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_search;
    }

    public SearchView(Context context) {
        super(context);
        this.scheduleImpl = PublishSubject.PlaceComponentResult();
        this.getAuthRequestContext = PublishSubject.PlaceComponentResult();
        this.lookAheadTest = null;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scheduleImpl = PublishSubject.PlaceComponentResult();
        this.getAuthRequestContext = PublishSubject.PlaceComponentResult();
        this.lookAheadTest = null;
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scheduleImpl = PublishSubject.PlaceComponentResult();
        this.getAuthRequestContext = PublishSubject.PlaceComponentResult();
        this.lookAheadTest = null;
    }

    public SearchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.scheduleImpl = PublishSubject.PlaceComponentResult();
        this.getAuthRequestContext = PublishSubject.PlaceComponentResult();
        this.lookAheadTest = null;
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.onGetActiveNotifications);
            try {
                this.PlaceComponentResult = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 4);
                this.moveToNextValue = obtainStyledAttributes.getString(18);
                this.lookAheadTest = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 13);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        Drawable drawable = this.PlaceComponentResult;
        if (drawable != null) {
            this.etSearchContact.setBackground(drawable);
        }
        this.etSearchContact.setImeOptions(6);
        this.etSearchContact.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.richview.SearchView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SearchView.this.m2822lambda$setup$0$iddanarichviewSearchView(view, z);
            }
        });
        this.etSearchContact.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.SearchView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchView.this.m2823lambda$setup$1$iddanarichviewSearchView(view);
            }
        });
        String str = this.moveToNextValue;
        if (str != null) {
            this.etSearchContact.setHint(str);
        }
        setRightIcon(this.lookAheadTest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setup$0$id-dana-richview-SearchView  reason: not valid java name */
    public /* synthetic */ void m2822lambda$setup$0$iddanarichviewSearchView(View view, boolean z) {
        this.getAuthRequestContext.onNext(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setup$1$id-dana-richview-SearchView  reason: not valid java name */
    public /* synthetic */ void m2823lambda$setup$1$iddanarichviewSearchView(View view) {
        this.getAuthRequestContext.onNext(Boolean.TRUE);
    }

    public void setSearchHint(String str) {
        EditText editText = this.etSearchContact;
        if (editText == null) {
            return;
        }
        editText.setHint(str);
    }

    public void enableNewNumberFormat(boolean z) {
        this.getErrorConfigVersion = z;
    }

    public void setSearchViewType(RecipientSourceType recipientSourceType) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recipientSourceType;
    }

    public void focusEtSearchContact() {
        this.etSearchContact.requestFocus();
        this.etSearchContact.setFocusableInTouchMode(true);
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
    }

    public boolean isClearImageViewRect(int i, int i2) {
        Rect rect = new Rect();
        this.ivClear.getGlobalVisibleRect(rect);
        return rect.contains(i, i2);
    }

    public PublishSubject<String> getKeyword() {
        return this.scheduleImpl;
    }

    public PublishSubject<Boolean> getOnSearchClickedEvent() {
        return this.getAuthRequestContext;
    }

    public EditText getEditText() {
        return this.etSearchContact;
    }

    public void showLoading(boolean z) {
        if (z) {
            this.ivClear.setVisibility(8);
            this.pbLoading.setVisibility(0);
            return;
        }
        this.ivClear.setVisibility(TextUtils.isEmpty(this.etSearchContact.getText()) ? 8 : 0);
        this.pbLoading.setVisibility(8);
    }

    @OnClick({R.id.iv_clear})
    public void clearKeyword() {
        this.ivClear.setVisibility(8);
        this.etSearchContact.setText("");
    }

    public void clearSearchFocus() {
        this.etSearchContact.clearFocus();
    }

    public void setSearchViewContentDescription(String str) {
        this.etSearchContact.setContentDescription(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnTextChanged(callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED, value = {R.id.et_search_contact})
    public void afterBankNumberChange(Editable editable) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        String obj = editable.toString();
        if (this.getErrorConfigVersion) {
            if (RecipientSourceType.Bank.INSTANCE.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                KClassImpl$Data$declaredNonStaticMembers$2(obj);
            } else if (RecipientSourceType.Contact.INSTANCE.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                BuiltInFictitiousFunctionClassFactory(obj);
            } else if (RecipientSourceType.All.INSTANCE.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                if (obj.replace("-", "").replaceAll("[.,\\\"]+", "").replace(" ", "").length() <= 13) {
                    BuiltInFictitiousFunctionClassFactory(obj);
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2(obj);
                }
            }
        } else {
            this.scheduleImpl.onNext(obj.replace("-", ""));
        }
        this.ivClear.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
        this.etSearchContact.setPadding(SizeUtil.getAuthRequestContext(16), SizeUtil.getAuthRequestContext(8), SizeUtil.getAuthRequestContext(TextUtils.isEmpty(editable) ^ true ? 28 : 16), SizeUtil.getAuthRequestContext(8));
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }

    public void setSearchViewInputType(int i) {
        this.etSearchContact.setInputType(i);
    }

    public void setRightIcon(Drawable drawable) {
        this.lookAheadTest = drawable;
        this.ivRightIcon.setImageDrawable(drawable);
        this.ivRightIcon.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:15:0x0046). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = id.dana.richview.SearchView.MyBillsEntityDataFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 3
            r3 = 97
            r4 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r5 = 3
            r6 = 97
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L46
        L15:
            r2 = r1
            r5 = 3
            r6 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1b:
            byte r7 = (byte) r3
            int r5 = r5 + 1
            r2[r6] = r7
            int r7 = r6 + 1
            r8 = 22
            if (r6 != r8) goto L41
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3c
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3c:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L41:
            r6 = r1[r5]
            r9 = r3
            r3 = r2
            r2 = r9
        L46:
            int r6 = -r6
            int r2 = r2 + r6
            int r2 = r2 + (-8)
            r6 = r7
            r9 = r3
            r3 = r2
            r2 = r9
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.SearchView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        String replace = str.replace("-", "");
        String replaceAll = replace.replaceAll("[.,\\\"]+", "");
        if (replaceAll.replace(" ", "").matches("^\\d+$")) {
            this.etSearchContact.getText().clear();
            EditText editText = this.etSearchContact;
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            editText.append(NumberUtil.moveToNextValue(replaceAll.replace(" ", "")));
            EditText editText2 = this.etSearchContact;
            editText2.setSelection(editText2.getText().length());
            this.scheduleImpl.onNext(replaceAll.replace(" ", ""));
            return;
        }
        this.etSearchContact.getText().clear();
        EditText editText3 = this.etSearchContact;
        NumberUtil numberUtil2 = NumberUtil.INSTANCE;
        editText3.append(NumberUtil.getErrorConfigVersion(replace));
        EditText editText4 = this.etSearchContact;
        editText4.setSelection(editText4.getText().length());
        this.scheduleImpl.onNext(replace);
    }

    private void BuiltInFictitiousFunctionClassFactory(String str) {
        String replace = str.replace("-", "");
        String replaceAll = replace.replaceAll("[.,\\\"]+", "");
        if (replaceAll.replace(" ", "").matches("^(?:\\+?62|0)[2-9]\\d{0,11}$") && this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.etSearchContact.getText().clear();
            EditText editText = this.etSearchContact;
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            editText.append(NumberUtil.DatabaseTableConfigUtil(replaceAll.replace(" ", "")));
            EditText editText2 = this.etSearchContact;
            editText2.setSelection(editText2.getText().length());
            this.scheduleImpl.onNext(replaceAll.replace(" ", ""));
            return;
        }
        this.etSearchContact.getText().clear();
        this.etSearchContact.append(str.replace("-", ""));
        EditText editText3 = this.etSearchContact;
        editText3.setSelection(editText3.getText().length());
        this.scheduleImpl.onNext(replace);
    }
}
