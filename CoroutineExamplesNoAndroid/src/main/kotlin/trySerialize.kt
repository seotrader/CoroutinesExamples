import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class GeoLocation(val lat: Double, val long: Double) {

}

fun main() {

    var list = arrayListOf<GeoLocation>(GeoLocation(5.0, 6.0),
        GeoLocation(5.0, 6.0),
        GeoLocation(5.0, 8.0),
        GeoLocation(5.0, 9.0))

    var seralizedString = Json.encodeToString(list)

    println("seralizedString = $seralizedString")
}