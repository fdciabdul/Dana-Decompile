package id.dana.data.uploadfiles;

import com.alibaba.ariver.permission.PermissionConstant;
import id.dana.data.uploadfiles.model.PresignedUrlRequest;
import id.dana.data.uploadfiles.model.PresignedUrlResponse;
import id.dana.data.uploadfiles.model.UploadFilesPreference;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.uploadfiles.UploadFilesEntity;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Response;

@Singleton
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0019\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b+\u0010,J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J3\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\"J1\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Lid/dana/data/uploadfiles/UploadFilesEntityRepository;", "Lid/dana/domain/uploadfiles/UploadFilesRepository;", "Lid/dana/domain/uploadfiles/UploadFilesEntity;", "selectedFile", "Lio/reactivex/Observable;", "", "addSelectedFiles", "(Lid/dana/domain/uploadfiles/UploadFilesEntity;)Lio/reactivex/Observable;", "clearFiles", "()Lio/reactivex/Observable;", "request", "", "bizType", "Lid/dana/data/uploadfiles/model/PresignedUrlResponse;", "getPresignedUrl", "(Lid/dana/domain/uploadfiles/UploadFilesEntity;Ljava/lang/String;)Lio/reactivex/Observable;", "", "getSelectedFiles", "", "getTotalFilesSize", "index", "removeSelectedFiles", "(I)Lio/reactivex/Observable;", "setSelectedFiles", "(Ljava/util/List;)Lio/reactivex/Observable;", "totalSize", "setTotalFilesSize", "", "selectedFiles", "contentType", "url", "Lretrofit2/Response;", "Ljava/lang/Void;", PermissionConstant.UPLOAD_FILE, "([BLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "uploadFiles", "(Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/uploadfiles/UploadFilesApi;", "uploadFilesApi", "Lid/dana/data/uploadfiles/UploadFilesApi;", "Lid/dana/data/uploadfiles/model/UploadFilesPreference;", "uploadFilesPreference", "Lid/dana/data/uploadfiles/model/UploadFilesPreference;", "<init>", "(Lid/dana/data/uploadfiles/UploadFilesApi;Lid/dana/data/uploadfiles/model/UploadFilesPreference;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UploadFilesEntityRepository implements UploadFilesRepository {
    public static final String GROUP_ID_FORMAT = "yyyyMMdd";
    public static final String RESOLUTION_CENTER = "resolutioncenter";
    private final UploadFilesApi uploadFilesApi;
    private final UploadFilesPreference uploadFilesPreference;

    @Inject
    public UploadFilesEntityRepository(UploadFilesApi uploadFilesApi, UploadFilesPreference uploadFilesPreference) {
        Intrinsics.checkNotNullParameter(uploadFilesApi, "");
        Intrinsics.checkNotNullParameter(uploadFilesPreference, "");
        this.uploadFilesApi = uploadFilesApi;
        this.uploadFilesPreference = uploadFilesPreference;
    }

    private final Observable<PresignedUrlResponse> getPresignedUrl(UploadFilesEntity request, String bizType) {
        DateTimeUtil dateTimeUtil = DateTimeUtil.INSTANCE;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String dateTimeString = dateTimeUtil.getDateTimeString(GROUP_ID_FORMAT, locale, System.currentTimeMillis());
        UploadFilesApi uploadFilesApi = this.uploadFilesApi;
        String str = bizType;
        if (str.length() == 0) {
            str = RESOLUTION_CENTER;
        }
        Observable map = uploadFilesApi.getPresignedUrl(new PresignedUrlRequest(dateTimeString, str, "", request.getFileName(), request.getContentType())).map(new Function() { // from class: id.dana.data.uploadfiles.UploadFilesEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PresignedUrlResponse m2071getPresignedUrl$lambda1;
                m2071getPresignedUrl$lambda1 = UploadFilesEntityRepository.m2071getPresignedUrl$lambda1((ResultResponse) obj);
                return m2071getPresignedUrl$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPresignedUrl$lambda-1  reason: not valid java name */
    public static final PresignedUrlResponse m2071getPresignedUrl$lambda1(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (PresignedUrlResponse) resultResponse.getResult();
    }

    private final Observable<Response<Void>> uploadFile(byte[] selectedFiles, String contentType, String url) {
        UploadFilesApi uploadFilesApi = this.uploadFilesApi;
        RequestBody create = RequestBody.create(MediaType.parse(contentType), selectedFiles);
        Intrinsics.checkNotNullExpressionValue(create, "");
        return uploadFilesApi.uploadFile(url, create, contentType);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [T, id.dana.domain.uploadfiles.UploadFilesEntity] */
    @Override // id.dana.domain.uploadfiles.UploadFilesRepository
    public final Observable<List<UploadFilesEntity>> uploadFiles(List<UploadFilesEntity> selectedFile, final String bizType) {
        Observable<List<UploadFilesEntity>> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(selectedFile, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new UploadFilesEntity("", "", "", "", "", null, false, 64, null);
        Single list = Observable.fromIterable(selectedFile).subscribeOn(Schedulers.MyBillsEntityDataFactory()).flatMap(new Function() { // from class: id.dana.data.uploadfiles.UploadFilesEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2072uploadFiles$lambda2;
                m2072uploadFiles$lambda2 = UploadFilesEntityRepository.m2072uploadFiles$lambda2(Ref.ObjectRef.this, this, bizType, (UploadFilesEntity) obj);
                return m2072uploadFiles$lambda2;
            }
        }).flatMap(new Function() { // from class: id.dana.data.uploadfiles.UploadFilesEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2073uploadFiles$lambda4;
                m2073uploadFiles$lambda4 = UploadFilesEntityRepository.m2073uploadFiles$lambda4(Ref.ObjectRef.this, this, (PresignedUrlResponse) obj);
                return m2073uploadFiles$lambda4;
            }
        }).map(new Function() { // from class: id.dana.data.uploadfiles.UploadFilesEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UploadFilesEntity m2074uploadFiles$lambda5;
                m2074uploadFiles$lambda5 = UploadFilesEntityRepository.m2074uploadFiles$lambda5(Ref.ObjectRef.this, (Response) obj);
                return m2074uploadFiles$lambda5;
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: uploadFiles$lambda-2  reason: not valid java name */
    public static final ObservableSource m2072uploadFiles$lambda2(Ref.ObjectRef objectRef, UploadFilesEntityRepository uploadFilesEntityRepository, String str, UploadFilesEntity uploadFilesEntity) {
        Intrinsics.checkNotNullParameter(objectRef, "");
        Intrinsics.checkNotNullParameter(uploadFilesEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(uploadFilesEntity, "");
        objectRef.element = uploadFilesEntity;
        return uploadFilesEntityRepository.getPresignedUrl(uploadFilesEntity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadFiles$lambda-4  reason: not valid java name */
    public static final ObservableSource m2073uploadFiles$lambda4(Ref.ObjectRef objectRef, UploadFilesEntityRepository uploadFilesEntityRepository, PresignedUrlResponse presignedUrlResponse) {
        Intrinsics.checkNotNullParameter(objectRef, "");
        Intrinsics.checkNotNullParameter(uploadFilesEntityRepository, "");
        Intrinsics.checkNotNullParameter(presignedUrlResponse, "");
        byte[] file = ((UploadFilesEntity) objectRef.element).getFile();
        if (file != null) {
            ((UploadFilesEntity) objectRef.element).setContentUrl(presignedUrlResponse.getDocumentUrl());
            Observable just = Observable.just(uploadFilesEntityRepository.uploadFile(file, ((UploadFilesEntity) objectRef.element).getContentType(), presignedUrlResponse.getPresignedUrl()).blockingFirst());
            if (just != null) {
                return just;
            }
        }
        throw new Exception();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadFiles$lambda-5  reason: not valid java name */
    public static final UploadFilesEntity m2074uploadFiles$lambda5(Ref.ObjectRef objectRef, Response response) {
        Intrinsics.checkNotNullParameter(objectRef, "");
        Intrinsics.checkNotNullParameter(response, "");
        return (UploadFilesEntity) objectRef.element;
    }

    @Override // id.dana.domain.uploadfiles.UploadFilesRepository
    public final Observable<List<UploadFilesEntity>> getSelectedFiles() {
        Observable<List<UploadFilesEntity>> just = Observable.just(this.uploadFilesPreference.getSelectedUploadFiles());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.uploadfiles.UploadFilesRepository
    public final Observable<Boolean> addSelectedFiles(UploadFilesEntity selectedFile) {
        Intrinsics.checkNotNullParameter(selectedFile, "");
        this.uploadFilesPreference.addSelectedUploadFiles(selectedFile);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.uploadfiles.UploadFilesRepository
    public final Observable<Boolean> setTotalFilesSize(int totalSize) {
        this.uploadFilesPreference.setTotalSize(totalSize);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.uploadfiles.UploadFilesRepository
    public final Observable<Integer> getTotalFilesSize() {
        Observable<Integer> just = Observable.just(Integer.valueOf(this.uploadFilesPreference.getTotalSize()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.uploadfiles.UploadFilesRepository
    public final Observable<Boolean> clearFiles() {
        this.uploadFilesPreference.clearData();
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.uploadfiles.UploadFilesRepository
    public final Observable<Boolean> removeSelectedFiles(int index) {
        List<UploadFilesEntity> selectedUploadFiles = this.uploadFilesPreference.getSelectedUploadFiles();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : selectedUploadFiles) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            UploadFilesEntity uploadFilesEntity = (UploadFilesEntity) obj;
            if (i != index) {
                arrayList.add(obj);
            }
            i++;
        }
        return setSelectedFiles(arrayList);
    }

    private final Observable<Boolean> setSelectedFiles(List<UploadFilesEntity> selectedFile) {
        this.uploadFilesPreference.setSelectedUploadFiles(selectedFile);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
