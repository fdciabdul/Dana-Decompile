package id.dana.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import butterknife.Unbinder;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.BaseButterKnife;
import id.dana.di.component.ApplicationComponent;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseFragment extends Fragment implements DisposableHandler, PresenterHandler, ViewPagerListener, BaseButterKnife {
    private BaseActivity baseActivity;
    private CompositeDisposable disposables;
    private FragmentListener fragmentListener;
    private MultipleClickHandler multipleClickHandler;
    protected int pageHeight = 0;
    private List<AbstractContract.AbstractPresenter> presenterList;
    private Unbinder unbinder;

    public /* synthetic */ void bind(Activity activity) {
        BaseButterKnife.CC.MyBillsEntityDataFactory(this, activity);
    }

    public /* synthetic */ void bind(Object obj, View view) {
        BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this, obj, view);
    }

    protected abstract int getLayout();

    protected abstract void init();

    public /* synthetic */ boolean isViewBinded() {
        return BaseButterKnife.CC.PlaceComponentResult(this);
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onSelected() {
    }

    public void onUnSelected() {
    }

    public /* synthetic */ void tryUnbind() {
        BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // id.dana.base.BaseButterKnife
    public Unbinder getUnbinder() {
        return this.unbinder;
    }

    @Override // id.dana.base.BaseButterKnife
    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    public ApplicationComponent getApplicationComponent() {
        if (getBaseActivity() != null) {
            return getBaseActivity().getApplicationComponent();
        }
        return null;
    }

    public BaseActivity getBaseActivity() {
        return this.baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent getIntentClassWithTracking(Class<?> cls, String str) {
        return getBaseActivity().getIntentClassWithTracking(cls, str);
    }

    public void showToast(String str) {
        Toast.makeText(getActivity(), str, 0).show();
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
            for (AbstractContract.AbstractPresenter abstractPresenter : list) {
                if (abstractPresenter != null) {
                    abstractPresenter.onDestroy();
                }
            }
            this.presenterList = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) getActivity();
            this.baseActivity = baseActivity;
            this.fragmentListener = (FragmentListener) context;
            this.multipleClickHandler = baseActivity;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getLayout() != 0) {
            View inflate = layoutInflater.inflate(getLayout(), viewGroup, false);
            bindView(inflate);
            return inflate;
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public boolean isSafe() {
        return (isRemoving() || getActivity() == null || isDetached() || !isAdded() || getView() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bindView(View view) {
        bind(this, view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (Build.VERSION.SDK_INT >= 30) {
            this.pageHeight = getBaseActivity().getWindowManager().getCurrentWindowMetrics().getBounds().height();
        } else {
            this.pageHeight = getBaseActivity().getWindowManager().getDefaultDisplay().getHeight();
        }
        init();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isViewBinded()) {
            onSelected();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        onUnSelected();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        tryUnbind();
        dispose();
        disposePresenter();
        super.onDestroyView();
    }

    public void enableClick() {
        MultipleClickHandler multipleClickHandler = this.multipleClickHandler;
        if (multipleClickHandler != null) {
            multipleClickHandler.enableClick();
        }
    }

    public void disableClick() {
        MultipleClickHandler multipleClickHandler = this.multipleClickHandler;
        if (multipleClickHandler != null) {
            multipleClickHandler.disableClick();
        }
    }

    protected boolean isClickable() {
        MultipleClickHandler multipleClickHandler = this.multipleClickHandler;
        if (multipleClickHandler != null) {
            return multipleClickHandler.isClickable();
        }
        return true;
    }

    protected void activityDoAction(String str, Object obj) {
        FragmentListener fragmentListener = this.fragmentListener;
        if (fragmentListener != null) {
            fragmentListener.doAction(str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addDisposables(Disposable... disposableArr) {
        for (Disposable disposable : disposableArr) {
            addDisposable(disposable);
        }
    }

    public void addDisposable(Disposable disposable) {
        if (this.disposables == null) {
            this.disposables = new CompositeDisposable();
        }
        Preconditions.getAuthRequestContext(disposable);
        Preconditions.getAuthRequestContext(this.disposables);
        this.disposables.getAuthRequestContext(disposable);
    }

    protected String getShownErrorMessage() {
        try {
            TextView textView = (TextView) getView().findViewById(16908290).getRootView().findViewWithTag(getResources().getString(R.string.error_message_tag));
            if (textView.getVisibility() == 0) {
                return textView.getText().toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public void dispose() {
        CompositeDisposable compositeDisposable = this.disposables;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            return;
        }
        this.disposables.dispose();
    }
}
