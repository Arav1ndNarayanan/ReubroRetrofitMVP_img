package com.example.reubroretrofitmvp.interfaces;


import com.example.reubroretrofitmvp.model.Notice;
import com.example.reubroretrofitmvp.model.NoticeList;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface GetNoticeDataService
{
    @GET("f1d10847-c5de-43dc-99c3-960b74ace207")
        // Observable<List<Users>> getUsers();
    Call<NoticeList> getNoticeData();
}