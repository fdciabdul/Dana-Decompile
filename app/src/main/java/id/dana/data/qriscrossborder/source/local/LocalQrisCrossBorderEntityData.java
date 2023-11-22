package id.dana.data.qriscrossborder.source.local;

import android.content.Context;
import id.dana.data.qriscrossborder.source.QrisCrossBorderEntityData;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012"}, d2 = {"Lid/dana/data/qriscrossborder/source/local/LocalQrisCrossBorderEntityData;", "Lid/dana/data/qriscrossborder/source/QrisCrossBorderEntityData;", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "()Lio/reactivex/Observable;", "MyBillsEntityDataFactory", "p0", "", "(Ljava/lang/String;)Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "PlaceComponentResult", "Lid/dana/data/qriscrossborder/source/local/QrisCrossBorderPreference;", "Lid/dana/data/qriscrossborder/source/local/QrisCrossBorderPreference;", "Lid/dana/data/storage/Serializer;", "Lid/dana/data/storage/Serializer;", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;Lid/dana/data/qriscrossborder/source/local/QrisCrossBorderPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalQrisCrossBorderEntityData implements QrisCrossBorderEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final QrisCrossBorderPreference BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Serializer MyBillsEntityDataFactory;

    @Inject
    public LocalQrisCrossBorderEntityData(Context context, Serializer serializer, QrisCrossBorderPreference qrisCrossBorderPreference) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(qrisCrossBorderPreference, "");
        this.PlaceComponentResult = context;
        this.MyBillsEntityDataFactory = serializer;
        this.BuiltInFictitiousFunctionClassFactory = qrisCrossBorderPreference;
    }

    @Override // id.dana.data.qriscrossborder.source.QrisCrossBorderEntityData
    public final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        QrisCrossBorderPreference qrisCrossBorderPreference = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        qrisCrossBorderPreference.getAuthRequestContext.saveData("QRIS_ORIGIN_COUNTRY", p0);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.qriscrossborder.source.QrisCrossBorderEntityData
    public final Observable<Boolean> getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        QrisCrossBorderPreference qrisCrossBorderPreference = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        qrisCrossBorderPreference.getAuthRequestContext.saveData("QRIS_CURRENT_COUNTRY", p0);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.qriscrossborder.source.QrisCrossBorderEntityData
    public final Observable<String> getAuthRequestContext() {
        String string = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getString("QRIS_CURRENT_COUNTRY");
        if (string == null) {
            string = "";
        }
        Observable<String> just = Observable.just(string);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.qriscrossborder.source.QrisCrossBorderEntityData
    public final Observable<String> MyBillsEntityDataFactory() {
        String string = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getString("QRIS_ORIGIN_COUNTRY");
        if (string == null) {
            string = "";
        }
        Observable<String> just = Observable.just(string);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
