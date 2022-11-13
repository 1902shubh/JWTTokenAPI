# JWTTokenAPI
JWT Token API calling



## Create JWT Token
```
private fun createJwt(): String {
        val signer = HMACSigner.newSHA256Signer("mandir")
        val jwt = JWT().setIssuer("mandir")
            .setSubject("nearest mandir")
        return JWT.getEncoder().encode(jwt, signer)

    }
```

## Call your api

```
val jt = createJwt()
        Log.d("SHUBH", "onCreate: ${jt}")

        val mahaquiz = RequestBody.create("text/plain".toMediaTypeOrNull(), "9118")
        val type = RequestBody.create("text/plain".toMediaTypeOrNull(), "1")

        lifecycleScope.launch(Dispatchers.IO) {
            val apiInterface = ApiUtilities.getApiInterface()

            try {
                val response = apiInterface.getMandir(mahaquiz, type, "Bearer $jt")

                withContext(Dispatchers.Main) {

                    Log.d("SHUBH", "onCreate: ${response.body()!!}")
                }
            } catch (e: Exception) {
                Log.d("SHUBH", "onCreate: ${e.message}")
            }
        }
```

## ApiInterface

```
 @Multipart
    @POST("/api/v1/api-v2.php")
    suspend fun getMandir(
        @Part("para2") para2: RequestBody,
        @Part("para1") para1: RequestBody,
        @Header("Authorization") authHeader: String
    ): Response<MandirModel>

```

    
          
