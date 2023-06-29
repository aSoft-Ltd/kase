import expect.expect
import kase.Optional
import kase.none
import kase.optionalOf
import kommander.expect
import kotlin.test.Test
import kotlin.test.fail

class OptionalTest {

    @Test
    fun should_be_easily_mapped() {
        val int = optionalOf(0)
        val res = int.map { it + 78 }.valueOrThrow()
        expect<Int>(res).toBe(78)
    }

    @Test
    fun should_throw_if_they_have_no_values() {
        val str: Optional<String> = none()
        try {
            str.valueOrThrow()
            fail("Was supposed to throw but did not")
        } catch (err: Throwable) {
            expect(err.message).toBe("Optional has no value")
        }
    }

    @Test
    fun should_returned_default_values_when_asked_to() {
        val str: Optional<String> = none()
        val name = str.valueOr("Anderson")
        expect(name).toBe("Anderson")
    }

    @Test
    fun should_be_able_to_map_none_twice() {
        val n = none<Int>()
        val res = n.map { it + 5 }.valueOr(6)
        expect(res).toBe(6)
    }
}