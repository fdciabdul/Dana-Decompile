package id.dana.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import dagger.internal.Preconditions;
import id.dana.base.AbstractContract;
import id.dana.base.BaseButterKnife;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseRichView extends FrameLayout implements DisposableHandler, PresenterHandler, BaseButterKnife {
    private CompositeDisposable disposables;
    private boolean inflated;
    private MultipleClickHandler multipleClickHandler;
    private List<AbstractContract.AbstractPresenter> presenterList;
    private SingleClickListener singleClickListener;
    private TypedArray styledAttributes;
    private Unbinder unbinder;
    private View view;

    /* loaded from: classes8.dex */
    public interface OnAsyncInflateListener {
    }

    public /* synthetic */ void bind(Activity activity) {
        BaseButterKnife.CC.MyBillsEntityDataFactory(this, activity);
    }

    public /* synthetic */ void bind(Object obj, View view) {
        BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this, obj, view);
    }

    public abstract int getLayout();

    public void injectComponent(ApplicationComponent applicationComponent) {
    }

    public void injected(boolean z) {
    }

    protected boolean isForRecyclerViewholder() {
        return false;
    }

    public void onInjectedView(View view) {
    }

    protected void onSingleClick(View view) {
    }

    public void parseAttrs(Context context, AttributeSet attributeSet) {
    }

    protected void setSingleClick() {
    }

    public void setup() {
    }

    public /* synthetic */ void tryUnbind() {
        BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this);
    }

    public BaseRichView(Context context) {
        super(context);
        init(context, null, false);
    }

    public BaseRichView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, false);
    }

    public BaseRichView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, false);
    }

    public BaseRichView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, false);
    }

    @Override // id.dana.base.BaseButterKnife
    public Unbinder getUnbinder() {
        return this.unbinder;
    }

    @Override // id.dana.base.BaseButterKnife
    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    public boolean isViewBinded() {
        return this.unbinder != null;
    }

    public void init(Context context, AttributeSet attributeSet, boolean z) {
        boolean z2;
        if (isInEditMode()) {
            z2 = false;
        } else {
            injectComponent(ComponentHolder.getAuthRequestContext());
            z2 = true;
        }
        this.view = LayoutInflater.from(context).inflate(getLayout(), (ViewGroup) this, true);
        this.inflated = true;
        initEvent(context, attributeSet, z2);
    }

    private void initEvent(Context context, AttributeSet attributeSet, boolean z) {
        onInjectedView(this.view);
        View view = this.view;
        if (view != null) {
            bindView(view);
        }
        parseAttrs(context, attributeSet);
        setup(isInEditMode());
        if (!isInEditMode()) {
            injected(z);
        }
        this.multipleClickHandler = getBaseActivity();
        setSingleClick();
    }

    public boolean isInflated() {
        return this.inflated;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.view;
        if (view != null) {
            bindView(view);
        }
    }

    protected void bindView(View view) {
        if (this.unbinder == null) {
            bind(this, view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dispose();
        if (!isForRecyclerViewholder()) {
            disposePresenter();
        }
        tryUnbind();
    }

    public ApplicationComponent getApplicationComponent() {
        if (getBaseActivity() != null) {
            return getBaseActivity().getApplicationComponent();
        }
        return null;
    }

    public BaseActivity getBaseActivity() {
        if (getContext() instanceof BaseActivity) {
            return (BaseActivity) getContext();
        }
        return null;
    }

    public void addDisposable(Disposable disposable) {
        if (this.disposables == null) {
            this.disposables = new CompositeDisposable();
        }
        Preconditions.getAuthRequestContext(disposable);
        Preconditions.getAuthRequestContext(this.disposables);
        this.disposables.getAuthRequestContext(disposable);
    }

    public void dispose() {
        CompositeDisposable compositeDisposable = this.disposables;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            return;
        }
        this.disposables.dispose();
    }

    public void registerPresenter(AbstractContract.AbstractPresenter... abstractPresenterArr) {
        if (this.presenterList == null) {
            this.presenterList = new ArrayList();
        }
        if (abstractPresenterArr == null || abstractPresenterArr.length <= 0) {
            return;
        }
        this.presenterList.addAll(Arrays.asList(abstractPresenterArr));
    }

    public void disposePresenter() {
        List<AbstractContract.AbstractPresenter> list = this.presenterList;
        if (list != null) {
            Iterator<AbstractContract.AbstractPresenter> it = list.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }

    public void enableClick() {
        MultipleClickHandler multipleClickHandler = this.multipleClickHandler;
        if (multipleClickHandler != null) {
            multipleClickHandler.enableClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void disableClick() {
        MultipleClickHandler multipleClickHandler = this.multipleClickHandler;
        if (multipleClickHandler != null) {
            multipleClickHandler.disableClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRichViewClickable() {
        MultipleClickHandler multipleClickHandler = this.multipleClickHandler;
        if (multipleClickHandler != null) {
            return multipleClickHandler.isClickable();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleClickListener getSingleItemClickListener() {
        if (this.singleClickListener == null) {
            this.singleClickListener = new SingleClickListener(getBaseActivity()) { // from class: id.dana.base.BaseRichView.1
                @Override // id.dana.base.SingleClickListener
                public final void PlaceComponentResult(View view) {
                    BaseRichView.this.onSingleClick(view);
                }
            };
        }
        return this.singleClickListener;
    }

    public void showWarningDialog(String str) {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || TextUtils.isEmpty(str)) {
            return;
        }
        baseActivity.showWarningDialog(str);
    }

    protected void showWarningDialog(String str, DialogInterface.OnDismissListener onDismissListener, boolean z, int i) {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || TextUtils.isEmpty(str)) {
            return;
        }
        baseActivity.showWarningDialog(str, onDismissListener, z, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getStyledAtrributesString(int i) {
        return this.styledAttributes.getString(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TypedArray getStyledAttributes() {
        return this.styledAttributes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        this.styledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
    }

    public View getView() {
        return this.view;
    }

    public void setup(boolean z) {
        setup();
    }
}
