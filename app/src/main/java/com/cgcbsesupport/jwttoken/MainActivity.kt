package com.cgcbsesupport.jwttoken

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.cgcbsesupport.jwttoken.api.ApiUtilities
import io.fusionauth.jwt.domain.JWT
import io.fusionauth.jwt.hmac.HMACSigner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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


    }

    private fun createJwt(): String {
        val signer = HMACSigner.newSHA256Signer("papayacoders")
        val jwt = JWT().setIssuer("papayacoders")
            .setSubject("software dev")
        return JWT.getEncoder().encode(jwt, signer)

    }
}