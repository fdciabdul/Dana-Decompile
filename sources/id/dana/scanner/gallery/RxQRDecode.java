package id.dana.scanner.gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.google.zxing.Result;
import dagger.internal.Preconditions;
import id.dana.utils.BitmapUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RxQRDecode {
    public CompositeDisposable BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
    Context PlaceComponentResult;

    @Inject
    public RxQRDecode(Context context) {
        this.PlaceComponentResult = context;
    }

    public final void getAuthRequestContext(final Uri uri, final int i, final int i2, DisposableObserver<Result> disposableObserver) {
        Disposable disposable = (Disposable) Observable.just(uri).subscribeOn(Schedulers.getAuthRequestContext()).observeOn(AndroidSchedulers.PlaceComponentResult()).map(new Function() { // from class: id.dana.scanner.gallery.RxQRDecode$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RxQRDecode rxQRDecode = RxQRDecode.this;
                Uri uri2 = (Uri) obj;
                return BitmapUtil.KClassImpl$Data$declaredNonStaticMembers$2(rxQRDecode.PlaceComponentResult, uri, i, i2);
            }
        }).flatMap(new Function() { // from class: id.dana.scanner.gallery.RxQRDecode$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource just;
                just = Observable.just(new DecodeImage((Bitmap) obj).MyBillsEntityDataFactory());
                return just;
            }
        }).subscribeWith(disposableObserver);
        Preconditions.getAuthRequestContext(disposable);
        Preconditions.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(disposable);
    }
}
