package id.dana.data.account.avatar.repository.source.network;

import id.dana.data.account.avatar.repository.source.AvatarEntityData;
import id.dana.data.account.avatar.repository.source.network.result.AvatarEntityResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@Singleton
/* loaded from: classes.dex */
public class NetworkFileUploadEntityData implements AvatarEntityData {
    private static final String BIZ_TYPE = "avatar";
    private static final String FILE_TYPE = ".png";
    private static final MediaType MEDIA_TYPE_FORM_DATA = MediaType.parse("multipart/form-data");
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    private static final String MULTIPART_NAME = "file";
    private final AvatarApi avatarApi;

    @Inject
    public NetworkFileUploadEntityData(AvatarApi avatarApi) {
        this.avatarApi = avatarApi;
    }

    @Override // id.dana.data.account.avatar.repository.source.AvatarEntityData
    public Observable<AvatarEntityResult> uploadAvatar(File file, String str) {
        AvatarApi avatarApi = this.avatarApi;
        RequestBody createData = createData("avatar");
        StringBuilder sb = new StringBuilder();
        sb.append(file.getName());
        sb.append(str);
        Single<ResultResponse<AvatarEntityResult>> uploadAvatar = avatarApi.uploadAvatar(createData, createData(changeAvatarName(sb.toString())), createImageData(file, str));
        Function function = new Function() { // from class: id.dana.data.account.avatar.repository.source.network.NetworkFileUploadEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return (AvatarEntityResult) ((ResultResponse) obj).getResult();
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleMap(uploadAvatar, function));
        if (BuiltInFictitiousFunctionClassFactory instanceof FuseToObservable) {
            return ((FuseToObservable) BuiltInFictitiousFunctionClassFactory).getAuthRequestContext();
        }
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(BuiltInFictitiousFunctionClassFactory));
    }

    private String changeAvatarName(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.replaceAll(".png", ""));
        sb.append(".png");
        return sb.toString();
    }

    private RequestBody createData(String str) {
        return RequestBody.create(MEDIA_TYPE_FORM_DATA, str);
    }

    private MultipartBody.Part createImageData(File file, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getName());
        sb.append(str);
        return MultipartBody.Part.createFormData("file", changeAvatarName(sb.toString()), RequestBody.create(MEDIA_TYPE_PNG, file));
    }
}
