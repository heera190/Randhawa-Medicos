package com.example.randhawamedicos.api

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API_Builder {

    companion object {
       const val BASE_URL = "https://your.url.com"
    }

    @FormUrlEncoded
    @POST("/createuser")
    suspend fun createUser(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("phone") phone: String,
        @Field("email") email: String,
        @Field("pincode") pin: String,
        @Field("address") address: String
    ) : Response<CreateUserResponse>

    @FormUrlEncoded
    @POST("/addorder")
    suspend fun createOrder(
        @Field("user_id") user_id: String,
        @Field("productName") productName: String,
        @Field("price") productPrice: Float,
        @Field("quantity") productQuantity: Int,
    ) : Response<CreateOrderResponse>

    @GET("/getAllUsers")
    suspend fun getAllUsers() : Response<GetAllUsersResponse>

    @FormUrlEncoded
    @POST("/signin")
        suspend fun signIn(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Response<GetSignInResponse>


        @GET("/getAllProducts")
        suspend fun getAllProduct() : Response<GetAllProductsModel>

        @GET("/specifyorder")
        suspend fun getSpecificOrder(
            @Query("user_id") user_id: String
        ) : Response<GetSpecificOrderResponse>
}
