package ca.six.mall.util

import java.security.MessageDigest

fun String.sha512() : String{
    val bytes : ByteArray = MessageDigest.getInstance("SHA-512")
            .digest(this.toByteArray())
    return bytes.toHex()

}

fun ByteArray.toHex() : String{
    val sb = StringBuilder()
    this.forEach { value ->
        val hexInt = value.toInt() and (0xFF)
        val hexString = Integer.toHexString(hexInt)
        if(hexString.length == 1){
            sb.append("0")
        }
        sb.append(hexString)
    }
    return sb.toString()

}