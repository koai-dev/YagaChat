package com.rbservice.yaga.utils

//class AppConfig {
//    private val rc = Firebase.remoteConfig.apply {
//        setDefaultsAsync(R.xml.remote_config_defaults)
//        setConfigSettingsAsync(
//            FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(10).build()
//        )
//    }
//
//    init {
//        val fetchTask = rc.fetch(0L)
//        fetchTask.addOnCompleteListener {
//            if (it.isSuccessful) {
//                rc.activate()
//            }
//        }
//    }
//
//    val apiKey = rc.getString(Constants.API_KEY)
//    val authorization = rc.getString(Constants.AUTHORIZATION)
//}
//
//object AppConfigUtil{
//    lateinit var appConfig: AppConfig
//}