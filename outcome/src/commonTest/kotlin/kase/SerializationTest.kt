package kase

import kase.outcome.Failure
import kase.outcome.Outcome
import kommander.expect
import kommander.toBe
import kotlinx.serialization.json.Json
import kotlin.test.Test

class SerializationTest {

    private val codec = Json { prettyPrint = true }

    @Test
    fun should_be_serializable() {
        val o: Outcome<String, Int> = Failure("Bad Number")
        val json = codec.encodeToString(o)
        expect(json).toBe(
            """
            {
                "type": "kase.outcome.Failure",
                "value": "Bad Number"
            }
        """.trimIndent()
        )
    }

    @Test
    fun should_be_deserializable() {
        val json = """
            {
                "type": "kase.outcome.Failure",
                "value": "Bad Number"
            }
        """.trimIndent()

        val o = codec.decodeFromString<Outcome<String, Boolean>>(json)
        expect(o).toBe<Failure<Int>>()

        expect(o.error()).toBe("Bad Number")
    }
}