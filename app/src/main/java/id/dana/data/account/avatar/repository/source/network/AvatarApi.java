package id.dana.data.account.avatar.repository.source.network;

import id.dana.data.account.avatar.repository.source.network.result.AvatarEntityResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/* loaded from: classes.dex */
public interface AvatarApi {
    @POST("/h/alipayplus.home.upload.json")
    @Multipart
    Single<ResultResponse<AvatarEntityResult>> uploadAvatar(@Part("bizType") RequestBody requestBody, @Part("filename") RequestBody requestBody2, @Part MultipartBody.Part part);
}
