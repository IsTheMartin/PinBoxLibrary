package ismartin.com.pinboxlibrary

import android.content.Context
import android.content.SharedPreferences

class SharedPrefs (context: Context){
    private val PREFS_FILENAME = "ismartin.com.pinboxlibrary.prefs"
    private val PIN_SAVED = "pin_saved"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var pinSaved: String?
    get() = prefs.getString(PIN_SAVED, "")
    set(value) = prefs.edit().putString(PIN_SAVED, value).apply()
}