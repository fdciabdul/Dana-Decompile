package id.dana.base;

/* loaded from: classes.dex */
public interface AbstractContract {

    /* loaded from: classes.dex */
    public interface AbstractPresenter {
        void onDestroy();
    }

    /* loaded from: classes.dex */
    public interface AbstractView {
        void dismissProgress();

        void onError(String str);

        void showProgress();
    }
}
