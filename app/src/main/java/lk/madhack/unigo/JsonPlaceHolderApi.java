package lk.madhack.unigo;

import lk.madhack.unigo.model.LoginDetails;
import lk.madhack.unigo.model.Student;
import lk.madhack.unigo.response.StudentResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @POST("login")
    Call<StudentResponse> login(@Body LoginDetails post);

    @POST("register")
    Call<StudentResponse> register(@Body Student post);

}
