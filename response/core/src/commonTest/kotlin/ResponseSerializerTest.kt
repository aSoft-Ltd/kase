import kase.Failed
import kase.Response
import kase.Successful
import kase.encodeResponseToString
import kase.decodeResponseFromString
import kommander.expect
import kommander.toBe
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test

class ResponseSerializerTest {
    @Test
    fun should_be_able_to_serialize_a_successful() {
        val res = Successful(45)
        expect(Json.encodeToString(res)).toBe("""{"status":{"code":200,"message":"ok"},"data":45}""")
    }

    @Test
    fun should_be_able_to_serialize_a_response() {
        val res: Response<Int> = Successful(45)
        expect(Json.encodeResponseToString(res)).toBe("""{"status":{"code":200,"message":"ok"},"data":45}""")
    }

    @Test
    fun should_be_able_to_decode_a_response() {
        val json = """"{"status":{"code":200,"message":"ok"},"data":45}""""
        val res = Json.decodeResponseFromString<Int>(json)
        expect(res).toBe<Failed>()
        expect(res.asSuccessful?.data).toBe(null)
    }

    @Test
    fun should_be_able_to_decode_a_failed_response() {
        val json = """{"pen":"new"}"""
        val res = Json.decodeResponseFromString<Int>(json)
        expect(res).toBe<Failed>()
    }
}