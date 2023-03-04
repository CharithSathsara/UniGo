package lk.madhack.unigo;

import java.util.List;

import lk.madhack.unigo.model.Announcement;
import lk.madhack.unigo.model.Event;
import lk.madhack.unigo.model.LoginDetails;
import lk.madhack.unigo.model.Student;
import lk.madhack.unigo.model.Subject;
import lk.madhack.unigo.response.StudentResponse;
import lk.madhack.unigo.response.SubjectResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @POST("login")
    Call<StudentResponse> login(@Body LoginDetails post);

    @POST("register")
    Call<StudentResponse> register(@Body Student post);

    @GET("getAllEvents")
    Call<List<Event>> getAllEvents();

    @GET("getAllAnnouncements")
    Call<List<Announcement>> getAllAnnouncements();

    @GET("getSubjects/1")
    Call<List<Subject>>  getCsSubjects();

    @GET("getSubjects/2")
    Call<List<Subject>> getBictSubjects();

}
