package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes6.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final boolean DBG = false;
    static final String LOG_TAG = "SearchView";
    static final PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER;
    private final View A;
    private final Intent AppCompatEmojiTextHelper;
    private Rect B;
    private boolean BottomSheetCardBindingView$watcherCardNumberView$1;
    private Rect C;
    private final int D;
    private CharSequence DatabaseTableConfigUtil;
    private UpdatableTouchDelegate E;
    private boolean F;
    private OnSuggestionListener FragmentBottomSheetPaymentSettingBinding;
    private final Runnable G;
    private int GetContactSyncConfig;
    private final Intent H;
    private CharSequence I;
    private final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private OnQueryTextListener NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final WeakHashMap<String, Drawable.ConstantState> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private View.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda5;
    private CharSequence NetworkUserEntityData$$ExternalSyntheticLambda6;
    private OnCloseListener NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final TextView.OnEditorActionListener NetworkUserEntityData$$ExternalSyntheticLambda8;
    private Bundle PlaceComponentResult;
    private final AdapterView.OnItemSelectedListener PrepareContext;
    private boolean SubSequence;
    private final int VerifyPinStateManager$executeRiskChallenge$2$1;
    private int[] VerifyPinStateManager$executeRiskChallenge$2$2;
    private final View getCallingPid;
    private final ImageView getErrorConfigVersion;
    private int[] getOnBoardingScenario;
    private final View getSupportButtonTintMode;
    private TextWatcher getValueOfTouchPositionAbsolute;
    private boolean initRecordTimeStamp;
    private final View.OnClickListener isLayoutRequested;
    private final CharSequence lookAheadTest;
    final ImageView mCloseButton;
    final ImageView mGoButton;
    View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    final ImageView mSearchButton;
    final SearchAutoComplete mSearchSrcTextView;
    SearchableInfo mSearchable;
    CursorAdapter mSuggestionsAdapter;
    View.OnKeyListener mTextKeyListener;
    final ImageView mVoiceButton;
    private boolean moveToNextValue;
    private final AdapterView.OnItemClickListener newProxyInstance;
    private final Drawable readMicros;
    private int scheduleImpl;
    private Runnable whenAvailable;
    public static final byte[] MyBillsEntityDataFactory = {Ascii.RS, 119, -63, 113, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 63;

    /* loaded from: classes6.dex */
    public interface OnCloseListener {
        boolean getAuthRequestContext();
    }

    /* loaded from: classes6.dex */
    public interface OnQueryTextListener {
        boolean BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes6.dex */
    public interface OnSuggestionListener {
        boolean KClassImpl$Data$declaredNonStaticMembers$2();

        boolean PlaceComponentResult();
    }

    static {
        PRE_API_29_HIDDEN_METHOD_INVOKER = Build.VERSION.SDK_INT < 29 ? new PreQAutoCompleteTextViewReflector() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.getOnBoardingScenario);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = new Rect();
        this.C = new Rect();
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = new int[2];
        this.getOnBoardingScenario = new int[2];
        this.G = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.updateFocusedState();
            }
        };
        this.whenAvailable = new Runnable() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.mSuggestionsAdapter instanceof SuggestionsAdapter) {
                    SearchView.this.mSuggestionsAdapter.MyBillsEntityDataFactory(null);
                }
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new WeakHashMap<>();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SearchView.this.mSearchButton) {
                    SearchView.this.onSearchClicked();
                } else if (view == SearchView.this.mCloseButton) {
                    SearchView.this.onCloseClicked();
                } else if (view == SearchView.this.mGoButton) {
                    SearchView.this.onSubmitQuery();
                } else if (view == SearchView.this.mVoiceButton) {
                    SearchView.this.onVoiceClicked();
                } else if (view == SearchView.this.mSearchSrcTextView) {
                    SearchView.this.forceSuggestionQuery();
                }
            }
        };
        this.isLayoutRequested = onClickListener;
        this.mTextKeyListener = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.mSearchable == null) {
                    return false;
                }
                if (SearchView.this.mSearchSrcTextView.isPopupShowing() && SearchView.this.mSearchSrcTextView.getListSelection() != -1) {
                    return SearchView.this.onSuggestionsKey(view, i2, keyEvent);
                }
                if (!SearchView.this.mSearchSrcTextView.isEmpty() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i2 == 66) {
                    view.cancelLongPress();
                    SearchView searchView = SearchView.this;
                    searchView.launchQuerySearch(0, null, searchView.mSearchSrcTextView.getText().toString());
                    return true;
                }
                return false;
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.onSubmitQuery();
                return true;
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = onEditorActionListener;
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.onItemClicked(i2, 0, null);
            }
        };
        this.newProxyInstance = onItemClickListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.onItemSelected(i2);
            }
        };
        this.PrepareContext = onItemSelectedListener;
        this.getValueOfTouchPositionAbsolute = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.onTextChanged(charSequence);
            }
        };
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(context, attributeSet, R.styleable.MultiLanguageHttpClient, i, 0);
        ViewCompat.MyBillsEntityDataFactory(this, context, R.styleable.MultiLanguageHttpClient, attributeSet, authRequestContext.BuiltInFictitiousFunctionClassFactory, i, 0);
        LayoutInflater.from(context).inflate(authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.murmurHash64WithSeed, R.layout.NetworkUserEntityData$$ExternalSyntheticLambda7), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.VerifyPinStateManager$executeRiskChallenge$2$2);
        this.mSearchSrcTextView = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.getCallingPid = findViewById(R.id.BottomSheetCardBindingView$watcherCardNumberView$1);
        View findViewById = findViewById(R.id.C);
        this.getSupportButtonTintMode = findViewById;
        View findViewById2 = findViewById(R.id.F);
        this.A = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.getCallingPid);
        this.mSearchButton = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.VerifyPinStateManager$executeRiskChallenge$2$1);
        this.mGoButton = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.A);
        this.mCloseButton = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.getValueOfTouchPositionAbsolute);
        this.mVoiceButton = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.B);
        this.getErrorConfigVersion = imageView5;
        ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(findViewById, __fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.storeUserConfig));
        ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(findViewById2, __fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0));
        imageView.setImageDrawable(__fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl));
        imageView2.setImageDrawable(__fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.onTooManyRedirects));
        imageView3.setImageDrawable(__fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.checkMarmotConfig));
        imageView4.setImageDrawable(__fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.f1$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM));
        imageView5.setImageDrawable(__fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.DaggerEmergencyNotifComponent$EmergencyNotifComponentImpl));
        this.readMicros = __fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.TypeToken$TypeSet);
        TooltipCompat.PlaceComponentResult(imageView, getResources().getString(R.string.isLayoutRequested));
        this.D = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.getGnBenefitEntityDanaProtection, R.layout.NetworkUserEntityData$$ExternalSyntheticLambda8);
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.checkParameterIsNotNull, 0);
        imageView.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView4.setOnClickListener(onClickListener);
        searchAutoComplete.setOnClickListener(onClickListener);
        searchAutoComplete.addTextChangedListener(this.getValueOfTouchPositionAbsolute);
        searchAutoComplete.setOnEditorActionListener(onEditorActionListener);
        searchAutoComplete.setOnItemClickListener(onItemClickListener);
        searchAutoComplete.setOnItemSelectedListener(onItemSelectedListener);
        searchAutoComplete.setOnKeyListener(this.mTextKeyListener);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.mOnQueryTextFocusChangeListener != null) {
                    SearchView.this.mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(authRequestContext.getAuthRequestContext(R.styleable.setValuePrefixBytes, true));
        int dimensionPixelSize = authRequestContext.BuiltInFictitiousFunctionClassFactory.getDimensionPixelSize(R.styleable.PrefetchDownloadStatus, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.lookAheadTest = authRequestContext.BuiltInFictitiousFunctionClassFactory.getText(R.styleable.createJavaMethod);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getText(R.styleable.isTmpDetached);
        int i2 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.outerType, -1);
        if (i2 != -1) {
            setImeOptions(i2);
        }
        int i3 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.getOpPackageName, -1);
        if (i3 != -1) {
            setInputType(i3);
        }
        setFocusable(authRequestContext.getAuthRequestContext(R.styleable.PlaybackStateCompat$MediaKeyAction, true));
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.H = intent;
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.AppCompatEmojiTextHelper = intent2;
        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    SearchView.this.adjustDropDownSizeAndPosition();
                }
            });
        }
        KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        String queryHint = getQueryHint();
        this.mSearchSrcTextView.setHint(PlaceComponentResult(queryHint == null ? "" : queryHint));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$1;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.mSearchable = searchableInfo;
        if (searchableInfo != null) {
            this.mSearchSrcTextView.setThreshold(searchableInfo.getSuggestThreshold());
            this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
            int inputType = this.mSearchable.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.mSearchable.getSuggestAuthority() != null) {
                    inputType = inputType | 65536 | 524288;
                }
            }
            this.mSearchSrcTextView.setInputType(inputType);
            CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
            if (cursorAdapter != null) {
                cursorAdapter.MyBillsEntityDataFactory(null);
            }
            if (this.mSearchable.getSuggestAuthority() != null) {
                SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
                this.mSuggestionsAdapter = suggestionsAdapter;
                this.mSearchSrcTextView.setAdapter(suggestionsAdapter);
                ((SuggestionsAdapter) this.mSuggestionsAdapter).getAuthRequestContext = this.SubSequence ? 2 : 1;
            }
            CharSequence queryHint = getQueryHint();
            SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
            if (queryHint == null) {
                queryHint = "";
            }
            searchAutoComplete.setHint(PlaceComponentResult(queryHint));
        }
        boolean MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        this.F = MyBillsEntityDataFactory2;
        if (MyBillsEntityDataFactory2) {
            this.mSearchSrcTextView.setPrivateImeOptions("nm");
        }
        KClassImpl$Data$declaredNonStaticMembers$2(isIconified());
    }

    public void setAppSearchData(Bundle bundle) {
        this.PlaceComponentResult = bundle;
    }

    public void setImeOptions(int i) {
        this.mSearchSrcTextView.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public void setInputType(int i) {
        this.mSearchSrcTextView.setInputType(i);
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (!this.moveToNextValue && isFocusable()) {
            if (!isIconified()) {
                boolean requestFocus = this.mSearchSrcTextView.requestFocus(i, rect);
                if (requestFocus) {
                    KClassImpl$Data$declaredNonStaticMembers$2(false);
                }
                return requestFocus;
            }
            return super.requestFocus(i, rect);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.moveToNextValue = true;
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mSearchSrcTextView.setImeVisibility(false);
        this.moveToNextValue = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = onQueryTextListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.FragmentBottomSheetPaymentSettingBinding = onSuggestionListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = onClickListener;
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.mSearchSrcTextView.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.I = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        onSubmitQuery();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = charSequence;
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(PlaceComponentResult(queryHint));
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (charSequence == null) {
            SearchableInfo searchableInfo = this.mSearchable;
            if (searchableInfo != null && searchableInfo.getHintId() != 0) {
                return getContext().getText(this.mSearchable.getHintId());
            }
            return this.lookAheadTest;
        }
        return charSequence;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == z) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
        KClassImpl$Data$declaredNonStaticMembers$2(z);
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(PlaceComponentResult(queryHint));
    }

    public boolean isIconfiedByDefault() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public void setIconified(boolean z) {
        if (z) {
            onCloseClicked();
        } else {
            onSearchClicked();
        }
    }

    public boolean isIconified() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = z;
        KClassImpl$Data$declaredNonStaticMembers$2(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.BottomSheetCardBindingView$watcherCardNumberView$1;
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.SubSequence = z;
        CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).getAuthRequestContext = z ? 2 : 1;
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.SubSequence;
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.mSuggestionsAdapter = cursorAdapter;
        this.mSearchSrcTextView.setAdapter(cursorAdapter);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public void setMaxWidth(int i) {
        this.GetContactSyncConfig = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.GetContactSyncConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.GetContactSyncConfig;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getContext().getResources().getDimensionPixelSize(R.dimen.getErrorConfigVersion), size);
        } else if (mode == 0) {
            size = this.GetContactSyncConfig;
            if (size <= 0) {
                size = getContext().getResources().getDimensionPixelSize(R.dimen.getErrorConfigVersion);
            }
        } else if (mode == 1073741824 && (i3 = this.GetContactSyncConfig) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getContext().getResources().getDimensionPixelSize(R.dimen.NetworkUserEntityData$$ExternalSyntheticLambda0), size2);
        } else if (mode2 == 0) {
            size2 = getContext().getResources().getDimensionPixelSize(R.dimen.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
            Rect rect = this.B;
            searchAutoComplete.getLocationInWindow(this.VerifyPinStateManager$executeRiskChallenge$2$2);
            getLocationInWindow(this.getOnBoardingScenario);
            int[] iArr = this.VerifyPinStateManager$executeRiskChallenge$2$2;
            int i5 = iArr[1];
            int[] iArr2 = this.getOnBoardingScenario;
            int i6 = i5 - iArr2[1];
            int i7 = iArr[0] - iArr2[0];
            rect.set(i7, i6, searchAutoComplete.getWidth() + i7, searchAutoComplete.getHeight() + i6);
            this.C.set(this.B.left, 0, this.B.right, i4 - i2);
            UpdatableTouchDelegate updatableTouchDelegate = this.E;
            if (updatableTouchDelegate == null) {
                UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.C, this.B, this.mSearchSrcTextView);
                this.E = updatableTouchDelegate2;
                setTouchDelegate(updatableTouchDelegate2);
                return;
            }
            updatableTouchDelegate.getAuthRequestContext(this.C, this.B);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
        int i = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mSearchButton.setVisibility(i);
        BuiltInFictitiousFunctionClassFactory(z2);
        this.getCallingPid.setVisibility(z ? 8 : 0);
        this.getErrorConfigVersion.setVisibility((this.getErrorConfigVersion.getDrawable() == null || this.NetworkUserEntityData$$ExternalSyntheticLambda1) ? 8 : 0);
        BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory(!z2);
        PlaceComponentResult();
    }

    private boolean MyBillsEntityDataFactory() {
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
            intent = this.H;
        } else if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
            intent = this.AppCompatEmojiTextHelper;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return (this.BottomSheetCardBindingView$watcherCardNumberView$1 || this.F) && !isIconified();
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.mGoButton.setVisibility((this.BottomSheetCardBindingView$watcherCardNumberView$1 && KClassImpl$Data$declaredNonStaticMembers$2() && hasFocus() && (z || !this.F)) ? 0 : 8);
    }

    private void PlaceComponentResult() {
        this.A.setVisibility((KClassImpl$Data$declaredNonStaticMembers$2() && (this.mGoButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) ? 0 : 8);
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        if (!z2 && (!this.NetworkUserEntityData$$ExternalSyntheticLambda1 || this.initRecordTimeStamp)) {
            z = false;
        }
        this.mCloseButton.setVisibility(z ? 0 : 8);
        Drawable drawable = this.mCloseButton.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    void updateFocusedState() {
        int[] iArr = this.mSearchSrcTextView.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.getSupportButtonTintMode.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.A.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.G);
        post(this.whenAvailable);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onQueryRefine(CharSequence charSequence) {
        getAuthRequestContext(charSequence);
    }

    boolean onSuggestionsKey(View view, int i, KeyEvent keyEvent) {
        if (this.mSearchable != null && this.mSuggestionsAdapter != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
            }
            if (i == 21 || i == 22) {
                this.mSearchSrcTextView.setSelection(i == 21 ? 0 : this.mSearchSrcTextView.length());
                this.mSearchSrcTextView.setListSelection(0);
                this.mSearchSrcTextView.clearListSelection();
                this.mSearchSrcTextView.ensureImeVisible();
                return true;
            } else if (i == 19) {
                this.mSearchSrcTextView.getListSelection();
                return false;
            }
        }
        return false;
    }

    private CharSequence PlaceComponentResult(CharSequence charSequence) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1 || this.readMicros == null) {
            return charSequence;
        }
        double textSize = this.mSearchSrcTextView.getTextSize();
        Double.isNaN(textSize);
        int i = (int) (textSize * 1.25d);
        this.readMicros.setBounds(0, 0, i, i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.readMicros), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void MyBillsEntityDataFactory(boolean z) {
        int i = 8;
        if (this.F && !isIconified() && z) {
            this.mGoButton.setVisibility(8);
            i = 0;
        }
        this.mVoiceButton.setVisibility(i);
    }

    void onTextChanged(CharSequence charSequence) {
        Editable text = this.mSearchSrcTextView.getText();
        this.I = text;
        boolean z = !TextUtils.isEmpty(text);
        BuiltInFictitiousFunctionClassFactory(z);
        MyBillsEntityDataFactory(!z);
        BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
            TextUtils.equals(charSequence, this.DatabaseTableConfigUtil);
        }
        this.DatabaseTableConfigUtil = charSequence.toString();
    }

    void onSubmitQuery() {
        Editable text = this.mSearchSrcTextView.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        OnQueryTextListener onQueryTextListener = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (onQueryTextListener == null || !onQueryTextListener.BuiltInFictitiousFunctionClassFactory()) {
            if (this.mSearchable != null) {
                launchQuerySearch(0, null, text.toString());
            }
            this.mSearchSrcTextView.setImeVisibility(false);
            this.mSearchSrcTextView.dismissDropDown();
        }
    }

    void onCloseClicked() {
        if (TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                OnCloseListener onCloseListener = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                if (onCloseListener == null || !onCloseListener.getAuthRequestContext()) {
                    clearFocus();
                    KClassImpl$Data$declaredNonStaticMembers$2(true);
                    return;
                }
                return;
            }
            return;
        }
        this.mSearchSrcTextView.setText("");
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
    }

    void onSearchClicked() {
        KClassImpl$Data$declaredNonStaticMembers$2(false);
        this.mSearchSrcTextView.requestFocus();
        this.mSearchSrcTextView.setImeVisibility(true);
        View.OnClickListener onClickListener = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void onVoiceClicked() {
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo == null) {
            return;
        }
        try {
            String str = null;
            if (!searchableInfo.getVoiceSearchLaunchWebSearch()) {
                if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    Intent intent = this.AppCompatEmojiTextHelper;
                    ComponentName searchActivity = searchableInfo.getSearchActivity();
                    Intent intent2 = new Intent("android.intent.action.SEARCH");
                    intent2.setComponent(searchActivity);
                    PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
                    Bundle bundle = new Bundle();
                    Bundle bundle2 = this.PlaceComponentResult;
                    if (bundle2 != null) {
                        bundle.putParcelable("app_data", bundle2);
                    }
                    Intent intent3 = new Intent(intent);
                    Resources resources = getResources();
                    String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
                    String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
                    String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
                    int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
                    intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
                    intent3.putExtra("android.speech.extra.PROMPT", string2);
                    intent3.putExtra("android.speech.extra.LANGUAGE", string3);
                    intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
                    if (searchActivity != null) {
                        str = searchActivity.flattenToShortString();
                    }
                    intent3.putExtra("calling_package", str);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                    getContext().startActivity(intent3);
                    return;
                }
                return;
            }
            Intent intent4 = new Intent(this.H);
            ComponentName searchActivity2 = searchableInfo.getSearchActivity();
            if (searchActivity2 != null) {
                str = searchActivity2.flattenToShortString();
            }
            intent4.putExtra("calling_package", str);
            getContext().startActivity(intent4);
        } catch (ActivityNotFoundException unused) {
            InstrumentInjector.log_w(LOG_TAG, "Could not find voice search activity");
        }
    }

    void onTextFocusChanged() {
        KClassImpl$Data$declaredNonStaticMembers$2(isIconified());
        post(this.G);
        if (this.mSearchSrcTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.G);
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        KClassImpl$Data$declaredNonStaticMembers$2(true);
        this.mSearchSrcTextView.setImeOptions(this.scheduleImpl);
        this.initRecordTimeStamp = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.initRecordTimeStamp) {
            return;
        }
        this.initRecordTimeStamp = true;
        int imeOptions = this.mSearchSrcTextView.getImeOptions();
        this.scheduleImpl = imeOptions;
        this.mSearchSrcTextView.setImeOptions(imeOptions | 33554432);
        this.mSearchSrcTextView.setText("");
        setIconified(false);
    }

    /* loaded from: classes6.dex */
    static class SavedState extends AbsSavedState {
        boolean MyBillsEntityDataFactory;
        public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {1, -107, Ascii.ESC, -41, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int getAuthRequestContext = 92;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.SearchView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r7, byte r8, short r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 * 15
                int r7 = 19 - r7
                int r9 = r9 + 105
                int r8 = r8 * 4
                int r8 = 16 - r8
                byte[] r0 = androidx.appcompat.widget.SearchView.SavedState.KClassImpl$Data$declaredNonStaticMembers$2
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L16
                r9 = r8
                r3 = r9
                r4 = 0
                r8 = r7
                goto L2c
            L16:
                r3 = 0
                r6 = r8
                r8 = r7
                r7 = r9
                r9 = r6
            L1b:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r9) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                r3 = r0[r8]
            L2c:
                int r7 = r7 + r3
                int r8 = r8 + 1
                int r7 = r7 + 2
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.SavedState.a(short, byte, short, java.lang.Object[]):void");
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.MyBillsEntityDataFactory = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.MyBillsEntityDataFactory));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchView.SavedState{");
            try {
                Object[] objArr = {this};
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[0] - 1);
                Object[] objArr2 = new Object[1];
                a(b, b, KClassImpl$Data$declaredNonStaticMembers$2[0], objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[0];
                byte b3 = (byte) (b2 - 1);
                Object[] objArr3 = new Object[1];
                a(b2, b3, b3, objArr3);
                sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                sb.append(" isIconified=");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append("}");
                return sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.MyBillsEntityDataFactory = isIconified();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        KClassImpl$Data$declaredNonStaticMembers$2(savedState.MyBillsEntityDataFactory);
        requestLayout();
    }

    void adjustDropDownSizeAndPosition() {
        int i;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.getSupportButtonTintMode.getPaddingLeft();
            Rect rect = new Rect();
            boolean authRequestContext = ViewUtils.getAuthRequestContext(this);
            int dimensionPixelSize = this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? resources.getDimensionPixelSize(R.dimen.BuiltInFictitiousFunctionClassFactory) + resources.getDimensionPixelSize(R.dimen.scheduleImpl) : 0;
            this.mSearchSrcTextView.getDropDownBackground().getPadding(rect);
            if (authRequestContext) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.mSearchSrcTextView.setDropDownHorizontalOffset(i);
            this.mSearchSrcTextView.setDropDownWidth((((this.NetworkUserEntityData$$ExternalSyntheticLambda0.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    boolean onItemClicked(int i, int i2, String str) {
        OnSuggestionListener onSuggestionListener = this.FragmentBottomSheetPaymentSettingBinding;
        if (onSuggestionListener == null || !onSuggestionListener.PlaceComponentResult()) {
            PlaceComponentResult(i);
            this.mSearchSrcTextView.setImeVisibility(false);
            this.mSearchSrcTextView.dismissDropDown();
            return true;
        }
        return false;
    }

    boolean onItemSelected(int i) {
        OnSuggestionListener onSuggestionListener = this.FragmentBottomSheetPaymentSettingBinding;
        if (onSuggestionListener == null || !onSuggestionListener.KClassImpl$Data$declaredNonStaticMembers$2()) {
            Editable text = this.mSearchSrcTextView.getText();
            Cursor BuiltInFictitiousFunctionClassFactory2 = this.mSuggestionsAdapter.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                if (BuiltInFictitiousFunctionClassFactory2.moveToPosition(i)) {
                    CharSequence BuiltInFictitiousFunctionClassFactory3 = this.mSuggestionsAdapter.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2);
                    if (BuiltInFictitiousFunctionClassFactory3 != null) {
                        getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3);
                        return true;
                    }
                    getAuthRequestContext(text);
                    return true;
                }
                getAuthRequestContext(text);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean PlaceComponentResult(int i) {
        Cursor BuiltInFictitiousFunctionClassFactory2 = this.mSuggestionsAdapter.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory2 == null || !BuiltInFictitiousFunctionClassFactory2.moveToPosition(i)) {
            return false;
        }
        Intent MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
        if (MyBillsEntityDataFactory2 != null) {
            try {
                getContext().startActivity(MyBillsEntityDataFactory2);
                return true;
            } catch (RuntimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed launch activity: ");
                sb.append(MyBillsEntityDataFactory2);
                InstrumentInjector.log_e(LOG_TAG, sb.toString(), e);
                return true;
            }
        }
        return true;
    }

    private void getAuthRequestContext(CharSequence charSequence) {
        this.mSearchSrcTextView.setText(charSequence);
        this.mSearchSrcTextView.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void launchQuerySearch(int i, String str, String str2) {
        getContext().startActivity(KClassImpl$Data$declaredNonStaticMembers$2("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent KClassImpl$Data$declaredNonStaticMembers$2(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.I);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.PlaceComponentResult;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        r2 = androidx.appcompat.widget.SuggestionsAdapter.BuiltInFictitiousFunctionClassFactory(r10, r10.getColumnIndex("suggest_intent_data_id"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.Intent MyBillsEntityDataFactory(android.database.Cursor r10) {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r1 = "suggest_intent_action"
            java.lang.String r1 = androidx.appcompat.widget.SuggestionsAdapter.KClassImpl$Data$declaredNonStaticMembers$2(r10, r1)     // Catch: java.lang.RuntimeException -> L66
            if (r1 != 0) goto L10
            android.app.SearchableInfo r1 = r9.mSearchable     // Catch: java.lang.RuntimeException -> L66
            java.lang.String r1 = r1.getSuggestIntentAction()     // Catch: java.lang.RuntimeException -> L66
        L10:
            if (r1 != 0) goto L14
            java.lang.String r1 = "android.intent.action.SEARCH"
        L14:
            r3 = r1
            java.lang.String r1 = "suggest_intent_data"
            java.lang.String r1 = androidx.appcompat.widget.SuggestionsAdapter.KClassImpl$Data$declaredNonStaticMembers$2(r10, r1)     // Catch: java.lang.RuntimeException -> L66
            if (r1 != 0) goto L24
            android.app.SearchableInfo r1 = r9.mSearchable     // Catch: java.lang.RuntimeException -> L66
            java.lang.String r1 = r1.getSuggestIntentData()     // Catch: java.lang.RuntimeException -> L66
        L24:
            if (r1 == 0) goto L47
            java.lang.String r2 = "suggest_intent_data_id"
            java.lang.String r2 = androidx.appcompat.widget.SuggestionsAdapter.KClassImpl$Data$declaredNonStaticMembers$2(r10, r2)     // Catch: java.lang.RuntimeException -> L66
            if (r2 == 0) goto L47
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.RuntimeException -> L66
            r4.<init>()     // Catch: java.lang.RuntimeException -> L66
            r4.append(r1)     // Catch: java.lang.RuntimeException -> L66
            java.lang.String r1 = "/"
            r4.append(r1)     // Catch: java.lang.RuntimeException -> L66
            java.lang.String r1 = android.net.Uri.encode(r2)     // Catch: java.lang.RuntimeException -> L66
            r4.append(r1)     // Catch: java.lang.RuntimeException -> L66
            java.lang.String r1 = r4.toString()     // Catch: java.lang.RuntimeException -> L66
        L47:
            if (r1 != 0) goto L4b
            r4 = r0
            goto L50
        L4b:
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.RuntimeException -> L66
            r4 = r1
        L50:
            java.lang.String r1 = "suggest_intent_query"
            java.lang.String r6 = androidx.appcompat.widget.SuggestionsAdapter.KClassImpl$Data$declaredNonStaticMembers$2(r10, r1)     // Catch: java.lang.RuntimeException -> L66
            java.lang.String r1 = "suggest_intent_extra_data"
            java.lang.String r5 = androidx.appcompat.widget.SuggestionsAdapter.KClassImpl$Data$declaredNonStaticMembers$2(r10, r1)     // Catch: java.lang.RuntimeException -> L66
            r7 = 0
            r8 = 0
            r2 = r9
            android.content.Intent r10 = r2.KClassImpl$Data$declaredNonStaticMembers$2(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.RuntimeException -> L66
            return r10
        L66:
            r1 = move-exception
            int r10 = r10.getPosition()     // Catch: java.lang.RuntimeException -> L6c
            goto L6d
        L6c:
            r10 = -1
        L6d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Search suggestions cursor at row "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r10 = " returned exception."
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            java.lang.String r2 = "SearchView"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r2, r10, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.MyBillsEntityDataFactory(android.database.Cursor):android.content.Intent");
    }

    void forceSuggestionQuery() {
        if (Build.VERSION.SDK_INT < 29) {
            PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = PRE_API_29_HIDDEN_METHOD_INVOKER;
            SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
            PreQAutoCompleteTextViewReflector.PlaceComponentResult();
            Method method = preQAutoCompleteTextViewReflector.PlaceComponentResult;
            if (method != null) {
                try {
                    method.invoke(searchAutoComplete, new Object[0]);
                } catch (Exception unused) {
                }
            }
            SearchAutoComplete searchAutoComplete2 = this.mSearchSrcTextView;
            PreQAutoCompleteTextViewReflector.PlaceComponentResult();
            Method method2 = preQAutoCompleteTextViewReflector.BuiltInFictitiousFunctionClassFactory;
            if (method2 != null) {
                try {
                    method2.invoke(searchAutoComplete2, new Object[0]);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            return;
        }
        this.mSearchSrcTextView.refreshAutoCompleteResults();
    }

    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* loaded from: classes6.dex */
    static class UpdatableTouchDelegate extends TouchDelegate {
        private final View BuiltInFictitiousFunctionClassFactory;
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private final Rect PlaceComponentResult;
        private final Rect getAuthRequestContext;
        private final Rect getErrorConfigVersion;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.MyBillsEntityDataFactory = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.getErrorConfigVersion = new Rect();
            this.getAuthRequestContext = new Rect();
            this.PlaceComponentResult = new Rect();
            getAuthRequestContext(rect, rect2);
            this.BuiltInFictitiousFunctionClassFactory = view;
        }

        public final void getAuthRequestContext(Rect rect, Rect rect2) {
            this.getErrorConfigVersion.set(rect);
            this.getAuthRequestContext.set(rect);
            Rect rect3 = this.getAuthRequestContext;
            int i = -this.MyBillsEntityDataFactory;
            rect3.inset(i, i);
            this.PlaceComponentResult.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action == 0) {
                if (this.getErrorConfigVersion.contains(x, y)) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    z = true;
                }
                z = false;
            } else if (action == 1 || action == 2) {
                z = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (z && !this.getAuthRequestContext.contains(x, y)) {
                    z2 = false;
                }
            } else {
                if (action == 3) {
                    z = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                }
                z = false;
            }
            if (z) {
                if (z2 && !this.PlaceComponentResult.contains(x, y)) {
                    motionEvent.setLocation(this.BuiltInFictitiousFunctionClassFactory.getWidth() / 2, this.BuiltInFictitiousFunctionClassFactory.getHeight() / 2);
                } else {
                    motionEvent.setLocation(x - this.PlaceComponentResult.left, y - this.PlaceComponentResult.top);
                }
                return this.BuiltInFictitiousFunctionClassFactory.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean MyBillsEntityDataFactory;
        private SearchView getAuthRequestContext;
        final Runnable mRunShowSoftInputIfNecessary;

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.isLayoutRequested);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mRunShowSoftInputIfNecessary = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.showSoftInputIfNecessary();
                }
            };
            this.KClassImpl$Data$declaredNonStaticMembers$2 = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            setMinWidth((int) TypedValue.applyDimension(1, (i < 960 || i2 < 720 || configuration.orientation != 2) ? (i >= 600 || (i >= 640 && i2 >= 480)) ? 192 : BlobStatic.MONITOR_IMAGE_WIDTH : 256, displayMetrics));
        }

        void setSearchView(SearchView searchView) {
            this.getAuthRequestContext = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.getAuthRequestContext.hasFocus() && getVisibility() == 0) {
                this.MyBillsEntityDataFactory = true;
                if (SearchView.isLandscapeMode(getContext())) {
                    ensureImeVisible();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.getAuthRequestContext.onTextFocusChanged();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.getAuthRequestContext.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.MyBillsEntityDataFactory) {
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                post(this.mRunShowSoftInputIfNecessary);
            }
            return onCreateInputConnection;
        }

        void showSoftInputIfNecessary() {
            if (this.MyBillsEntityDataFactory) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.MyBillsEntityDataFactory = false;
            }
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.MyBillsEntityDataFactory = false;
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.MyBillsEntityDataFactory = false;
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.MyBillsEntityDataFactory = true;
            }
        }

        void ensureImeVisible() {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.getAuthRequestContext(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER;
            PreQAutoCompleteTextViewReflector.PlaceComponentResult();
            Method method = preQAutoCompleteTextViewReflector.getAuthRequestContext;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class PreQAutoCompleteTextViewReflector {
        Method BuiltInFictitiousFunctionClassFactory;
        Method PlaceComponentResult;
        Method getAuthRequestContext;

        PreQAutoCompleteTextViewReflector() {
            this.PlaceComponentResult = null;
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.getAuthRequestContext = null;
            if (Build.VERSION.SDK_INT < 29) {
                try {
                    Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                    this.PlaceComponentResult = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                try {
                    Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                    this.BuiltInFictitiousFunctionClassFactory = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused2) {
                }
                try {
                    Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                    this.getAuthRequestContext = method;
                    method.setAccessible(true);
                    return;
                } catch (NoSuchMethodException unused3) {
                    return;
                }
            }
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }

        static void PlaceComponentResult() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static void getAuthRequestContext(SearchAutoComplete searchAutoComplete, int i) {
            searchAutoComplete.setInputMethodMode(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:15:0x0049). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray r9, int r10) {
        /*
            byte[] r0 = androidx.appcompat.widget.SearchView.MyBillsEntityDataFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 3
            r3 = 97
            r4 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r5 = 3
            r6 = 0
            r7 = 97
            r1 = r0
            r0 = r10
            r10 = r9
            goto L49
        L15:
            r2 = r1
            r3 = 3
            r5 = 97
            r6 = 0
            r1 = r0
            r0 = r10
            r10 = r9
        L1d:
            int r3 = r3 + 1
            byte r7 = (byte) r5
            r2[r6] = r7
            r7 = 22
            if (r6 != r7) goto L41
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r9 = r1.isInstance(r9)
            if (r9 == 0) goto L3c
            android.content.Context r10 = (android.content.Context) r10
            android.graphics.drawable.Drawable r9 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r10, r0)
            return r9
        L3c:
            android.graphics.drawable.Drawable r9 = r10.BuiltInFictitiousFunctionClassFactory(r0)
            return r9
        L41:
            int r6 = r6 + 1
            r7 = r1[r3]
            r8 = r3
            r3 = r2
            r2 = r5
            r5 = r8
        L49:
            int r7 = -r7
            int r2 = r2 + r7
            int r2 = r2 + (-8)
            r8 = r5
            r5 = r2
            r2 = r3
            r3 = r8
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.__fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
    }
}
